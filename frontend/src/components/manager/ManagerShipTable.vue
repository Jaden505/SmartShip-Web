<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <div class="mt-4" v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100">
    <div class="flex flex-row space-x-2">
    <button class="text-white bg-blue-regular font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text" @click="TogglePopup('buttonTriggerCreate')">Add Ship</button>
    </div>
    <div class="mt-4">
    <table class="text-center table-auto w-full text-white-text" id="opTable">
      <thead>
      <tr>
        <th scope="col">Ship Id</th>
        <th scope="col">Ship Name</th>
        <th scope="col">Ship status</th>
        <th scope="col">Assigned operators</th>
        <th></th>
        <th></th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(ship, index) in ships" class="bg-black-light" :key="index">
        <td class="px-3 py-4">{{ ship.id }}</td>
        <td class="px-3 py-4">{{ ship.name }}</td>
        <td class="px-3 py-4">{{ getStatusNameById(ship.status) }}</td>
        <td class="px-3 py-4">{{ getUsersByShipId(ship.id) }}</td>
        <td>
          <div class="material-icons px-3 py-4" @click="TogglePopup('buttonTriggerEdit'); this.ship = ship">edit</div>
          <div class="material-icons px-3 py-4" @click="deleteShip(ship.id)">delete</div>
        </td>
      </tr>
      </tbody>
    </table>
    </div>
  </div>

  <editForm
      v-if="popupTrigger.buttonTriggerEdit"
      :TogglePopup="() => TogglePopup('buttonTriggerEdit')"
      :ship = this.ship
  />

  <createForm
      v-if="popupTrigger.buttonTriggerCreate"
      :TogglePopup="() => TogglePopup('buttonTriggerCreate')"
  />

  <warning-ship
    v-if="popupTrigger.buttonTriggerWarning"
    :TogglePopup="() => TogglePopup('buttonTriggerWarning')"
  />

</template>

<script>
import UserService from "../../services/user.service";
import ShipService from "@/services/ship.service";
import editForm from "@/components/manager/forms/editShipForm";
import {ref} from 'vue';
import createForm from "@/components/manager/forms/createShipForm";
import warningShip from "@/components/manager/forms/warningShip";
import StatusService from "@/services/status.service";

export default {
  name: "ManagerTable",
  components: {
    editForm,
    createForm,
    warningShip
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
      buttonTriggerCreate: false,
      buttonTriggerWarning: false
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

    async deleteShip(ship_id){
      if (confirm("Are you sure you want to delete this ship?")) {
        try{
          await ShipService.deleteShip(ship_id)
          location.reload()
        } catch (e){
          this.TogglePopup('buttonTriggerWarning')
          console.log(e)
        }
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

    getUsersByShipId(ship) {
      let operators = this.users.filter(user => user.ship === ship);

      if (operators.length !== 0) {
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
      let status_name = (this.statuses[status_id-1].status).toString();
      status_name = status_name.charAt(0) + status_name.substring(1).toLowerCase(); // Make lowercase except for first letter
      return status_name;
    }

  }
}
</script>

<style scoped>
table {
  border-collapse: separate;
  border-spacing: 0 10px;
}

/*Set border-radius on the top-left and bottom-left of the first table data on the table row*/
td:first-child {
  border-radius: 10px 0 0 10px;
}

/*// Set border-radius on the top-right and bottom-right of the last table data on the table row*/
td:last-child {
  border-radius: 0 10px 10px 0;
}

</style>