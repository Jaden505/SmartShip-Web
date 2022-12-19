<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <div>
    <button class="text-white bg-blue-light-card focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text" @click="TogglePopup('buttonTriggerCreate')">Add Ship</button>
    <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
      <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400 columns">
      <tr class="columns">
        <th scope="col" class="py-3 px-6">Ship Id</th>
        <th scope="col" class="py-3 px-6">Ship Name</th>
        <th scope="col" class="py-3 px-6">Ship status</th>
        <th scope="col" class="py-3 px-6">Assigned operators</th>
        <th></th>
        <th></th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(ship, index) in ships" class="bg-white border-b dark:bg-gray-800 dark:border-gray-700" :key="index">
        <td class="py-4 px-6">{{ ship.id }}</td>
        <td class="py-4 px-6">{{ ship.name }}</td>
        <td class="py-4 px-6">{{ getStatusNameById(ship.status) }}</td>
        <td class="py-4 px-6">{{ getUsersByShipId(ship.id) }}</td>
        <td class="material-icons py-4 px-6" @click="TogglePopup('buttonTriggerEdit'); this.ship = ship">edit</td>
        <td class="material-icons py-4 px-6" @click="deleteShip(ship.id)">delete</td>
      </tr>
      </tbody>
    </table>
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
      let status_name = (this.statuses[status_id-1].status).toString();
      status_name = status_name.charAt(0) + status_name.substring(1).toLowerCase(); // Make lowercase except for first letter
      return status_name;
    }

  }
}
</script>

<style scoped>
.material-icons:hover {
  cursor: pointer;
}
</style>