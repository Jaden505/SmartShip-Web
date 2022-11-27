<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <button class="text-white bg-blue-light-card focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text" @click="TogglePopup('buttonTriggerCreate')">Add user</button>

    <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
      <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400 columns">
        <tr>
          <th scope="col" class="py-3 px-6">Operator Id</th>
          <th scope="col" class="py-3 px-6">Operator Name</th>
          <th scope="col" class="py-3 px-6">Operator Email</th>
          <th scope="col" class="py-3 px-6">Assigned Ship</th>
          <th></th>
          <th></th>
        </tr>
    </thead>
    <tbody>
    <tr v-for="(operator, index) in users" :key="index" class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
      <td class="py-4 px-6">{{ operator.id }}</td>
      <td class="py-4 px-6">{{ operator.username }}</td>
      <td class="py-4 px-6">{{ operator.email }}</td>
      <td class="py-4 px-6">{{ getShipName(operator.shipID) }}</td>
      <td class="material-icons py-4 px-6" @click="TogglePopup('buttonTriggerEdit'); this.operator = operator">edit</td>
      <td class="material-icons py-4 px-6" @click="deleteUser(operator.id)">delete</td>
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
import { isProxy, toRaw } from 'vue';

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

      if (ship !== []) {
        isProxy(ship) ? ship = toRaw(ship[0]).name : ship = ship[0].name;
        return ship;
      }

      else return "No ship assigned";
    }
  }
}
</script>

<style scoped>

</style>