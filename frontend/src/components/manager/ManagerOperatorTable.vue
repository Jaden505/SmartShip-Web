<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <div class="button-section">
    <el-button type="primary" class="create-user-btn" @click="TogglePopup('buttonTriggerCreate')">Add user</el-button>
  </div>

  <table>
    <thead>
    <tr>
      <th>Operator Id</th>
      <th>Operator Name</th>
      <th>Operator Email</th>
      <th>Assigned Ship</th>
      <th></th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="(operator, index) in users" :key="index">
      <td>{{ operator.id }}</td>
      <td>{{ operator.username }}</td>
      <td>{{ operator.email }}</td>
      <td>{{ getShipName(operator.shipID) }}</td>
      <td class="material-icons" @click="TogglePopup('buttonTriggerEdit'); this.operator = operator">edit</td>
      <td class="material-icons" @click="deleteUser(operator.id)">delete</td>
    </tr>
    </tbody>
  </table>


  <editForm
    v-if="popupTrigger.buttonTriggerEdit"
    :TogglePopup="() => TogglePopup('buttonTriggerEdit')"
    :operator = this.operator
  />

  <createForm
      v-if="popupTrigger.buttonTriggerCreate"
      :TogglePopup="() => TogglePopup('buttonTriggerCreate')"
  />

</template>

<script>
import UserService from "../../services/user.service";
import ShipService from "@/services/ShipService";
import editForm from "@/components/manager/forms/editUserForm";
import {ref} from 'vue';
import createForm from "@/components/manager/forms/createUserForm";

export default {
  name: "ManagerTable",
  components: {
    editForm,
    createForm
  },

  mounted() {
    this.getUsers();
    this.getShips();
  },

  data() {
    return {
      users: [],
      operator: null,
      ships: []
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
      UserService.getUsersByRole(1) // Role operator
          .then(response => {
            this.users = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },

    toggle(operator){
      this.operator = operator
    },

    deleteUser(user_id){
      if (confirm("Are you sure you want to delete this operator?")) {
        UserService.deleteUser(user_id).catch(e => {
          console.log(e)
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

    getShipName(ship_id) {
      let ship = this.ships.filter(ship => ship.id == ship_id);

      if (ship !== []) return ship[0].name;
      else return "No ship assigned";
    }
  }
}
</script>

<style scoped>

.button-section{
  width: 90%;
  margin-left: auto;
  margin-right: auto;
}

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