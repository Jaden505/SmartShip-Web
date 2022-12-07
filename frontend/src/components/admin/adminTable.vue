<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <button class="text-white bg-blue-light-card focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text" @click="TogglePopup('buttonTriggerCreate')">Add user</button>

  <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
    <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400 columns">
    <tr>
      <th scope="col" class="py-3 px-6">Manager Id</th>
      <th scope="col" class="py-3 px-6">Manager Name</th>
      <th scope="col" class="py-3 px-6">Manager Email</th>
      <th></th>
      <th></th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="(manager, index) in users" :key="index" class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
      <td class="py-4 px-6">{{ manager.id }}</td>
      <td class="py-4 px-6">{{ manager.username }}</td>
      <td class="py-4 px-6">{{ manager.email }}</td>
      <td class="material-icons py-4 px-6" @click="TogglePopup('buttonTriggerEdit'); this.manager = operator">edit</td>
      <td class="material-icons py-4 px-6" @click="deleteUser(manager.id)">delete</td>
    </tr>
    </tbody>
  </table>


  <edit-manger-form
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
import editMangerForm from "@/components/admin/forms/editMangerForm";
import {ref} from 'vue';
import createForm from "@/components/manager/forms/createUserForm";

export default {
  name: "ManagerTable",
  components: {
    editMangerForm,
    createForm
  },

  mounted() {
    this.getUsers();
  },

  data() {
    return {
      users: [],
      operator: null,
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

  }
}
</script>

<style scoped>

</style>