

<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <el-button type="primary" class="create-user-btn" @click="TogglePopup('buttonTriggerCreate')">Add Ship</el-button>

  <table>
    <thead>
    <tr>
      <th>Ship Id</th>
      <th>Ship Name</th>
      <th>Ship status</th>
      <th>Assigned operators</th>
      <th></th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="(ship, index) in ships" :key="index">
      <td>{{ ship.id }}</td>
      <td>{{ ship.name }}</td>
      <td>{{ getStatusNameById(ship.status) }}</td>
      <td>{{ getUsersByShipId(ship.status) }}</td>
      <td class="material-icons" @click="TogglePopup('buttonTriggerEdit'); this.ship = ship">edit</td>
      <td class="material-icons" @click="deleteShip(ship.id)">delete</td>
    </tr>
    </tbody>
  </table>


  <editForm
      v-if="popupTrigger.buttonTriggerEdit"
      :TogglePopup="() => TogglePopup('buttonTriggerEdit')"
      :ship = this.ship
  />

  <createForm
      v-if="popupTrigger.buttonTriggerCreate"
      :TogglePopup="() => TogglePopup('buttonTriggerCreate')"
  />

</template>

<script>
import UserService from "../../services/user.service";
import ShipService from "@/services/ShipService";
import editForm from "@/components/manager/forms/editShipForm";
import {ref} from 'vue';
import createForm from "@/components/manager/forms/createShipForm";
import StatusService from "@/services/status.service";

export default {
  name: "ManagerTable",
  components: {
    editForm,
    createForm
  },

  mounted() {
    this.getUsers();
    this.getShips();
    this.getStatuses();
  },

  data() {
    return {
      users: [],
      ship: null,
      ships: [],
      statuses: []
    }
  },

  setup(){
    const popupTrigger = ref({
      buttonTriggerEdit: false,
      buttonTriggerCreate: false
    });

    const TogglePopup = (trigger) => {
      popupTrigger.value[trigger] = !popupTrigger.value[trigger]
    };

    return {
      popupTrigger,
      TogglePopup
    }
  },

  methods: {
    getUsers() {
      UserService.getUsers()
          .then(response => {
            this.users = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },

    toggle(ship){
      this.ship = ship
    },

    deleteShip(ship_id){
      if (confirm("Are you sure you want to delete this ship?")) {
        ShipService.deleteShip(ship_id).catch(e => {
          console.log(e)
          alert("This ship has operators assigned!")
        })
        location.reload()
      }
    },

    getShips() {
      ShipService.getAll()
          .then(response => {
            this.ships = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },

    getUsersByShipId(ship_id) {
      let operators = this.users.filter(user => user.shipID == ship_id);

      if (operators !== []) {
        operators.forEach((op, index) => {
          operators[index] = op.username;
        })

        return operators.toString();
      }

      else return "No operators";
    },

    getStatuses() {
      StatusService.get()
          .then(response => {
            this.statuses = response.data;
            console.log(this.statuses)
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },

    getStatusNameById(status_id) {
      let status_name = (this.statuses[status_id].status).toString();
      status_name = status_name.charAt(0) + status_name.substring(1).toLowerCase(); // Make lowercase except for first letter
      return status_name;
    }
  }
}
</script>

<style scoped>

table {
  width: 90%;
  border: solid black 2px;
  margin: 1% auto 0 auto;
}

thead {
  background-color: #163b7a;
  border-bottom: 2px solid black;
}

thead th {
  padding: 1%;
  font-size: 22px;
  color: lightgrey;
}

tbody td {
  padding: 1%;
  font-size: 20px;
}

tbody tr {
  background-color: white;
}

tbody tr:hover {
  background-color: white;
  opacity: 0.8;
}

tbody tr:nth-child(even) {
  background-color: deepskyblue;
}

.material-icons:hover {
  cursor: pointer;
}

.material-icons {
  font-size: 28px;
  padding-top: 8px;
}

.create-user-btn {
  float: right;
  margin-right: 5.1%;
  margin-top: 5%;
}
</style>