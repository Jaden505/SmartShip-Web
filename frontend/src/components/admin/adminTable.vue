<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <button class="text-white bg-blue-light-card focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text" @click="TogglePopup('buttonTriggerCreate')">Add user</button>

  <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
    <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400 columns">
    <tr>
      <th scope="col" class="py-3 px-6">Manager Id</th>
      <th scope="col" class="py-3 px-6">Manager Name</th>
      <th scope="col" class="py-3 px-6">Manager Email</th>
      <th scope="col" class="py-3 px-6">Assigned Ship</th>
      <th></th>
      <th></th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="(manager, index) in users" :key="index" class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
      <td class="py-4 px-6">{{ manager.id }}</td>
      <td class="py-4 px-6">{{ manager.username }}</td>
      <td class="py-4 px-6">{{ manager.email }}</td>
      <td class="py-4 px-6">{{ getShipName(manager.shipID) }}</td>
      <td class="material-icons py-4 px-6 pointer" @click="TogglePopup('buttonTriggerEdit'); this.manager = manager">edit</td>
      <td class="material-icons py-4 px-6 pointer" @click="deleteUser(manager.id)">delete</td>
    </tr>
    </tbody>
  </table>

  <edit-manger-form
      v-if="popupTrigger.buttonTriggerEdit"
      :TogglePopup="() => TogglePopup('buttonTriggerEdit')"
      :manager = this.manager
  />

  <create-manager-form
      v-if="popupTrigger.buttonTriggerCreate"
      :TogglePopup="() => TogglePopup('buttonTriggerCreate')"
  />

</template>

<script>
import UserService from "../../services/user.service";
import editMangerForm from "@/components/admin/forms/editMangerForm";
import createManagerForm from "@/components/admin/forms/createManagerForm";
import {isProxy, ref, toRaw} from 'vue';
import ShipService from "@/services/ShipService";

export default {
  name: "ManagerTable",
  components: {
    editMangerForm,
    createManagerForm
  },

  mounted() {
    this.getUsers();
    this.getShips();
  },

  data() {
    return {
      users: [],
      ships: [],
      manager: null,
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
      UserService.getUsersByRole(2) // Role manager
          .then(response => {
            this.users = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
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
      if (ship_id == null){
        return "No ship assigned";
      }

      let ship = this.ships.filter(ship => ship.id == ship_id);

      if (ship !== []) {
        isProxy(ship) ? ship = toRaw(ship[0]).name : ship = ship[0].name;
        return ship;
      }

    },

    toggle(manager){
      this.manager = manager
    },

    deleteUser(user_id){
      if (confirm("Are you sure you want to delete this manager?")) {
        UserService.deleteUser(user_id).catch(e => {
          console.log(e)
        })
        location.reload()
      }
    },

  }
}
</script>

<style scoped>
  .pointer{
    cursor: pointer;
  }
</style>