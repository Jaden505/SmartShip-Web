<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <button class="text-white bg-blue-light-card focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text" @click="TogglePopup('buttonTriggerCreate')">Add user</button>

  <button v-if="activeButtonShip" class="text-white bg-blue-light-card focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text topBtn" @click="activate">Filter Ship</button>
  <button v-if="activeButtonOp" class="text-white bg-blue-light-card focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text topBtn" @click="reActivate">Filter Operator</button><br>

  <input v-if="activeSearch" type="text" id="myInput" @keyup="search" :placeholder="'Search for '+ searchTitle" title="Type in a name">

  <table class="text-center table-auto w-full" id="opTable">
      <thead>
        <tr>
          <th scope="col" class="">Operator Id</th>
          <th scope="col" class="">Operator Name</th>
          <th scope="col" class="">Operator Email</th>
          <th scope="col" class="">Assigned Ship</th>
          <th></th>
          <th></th>
        </tr>
    </thead>
    <tbody>
    <tr v-for="(operator, index) in users" :key="index" class="bg-blue-card-blue">
      <td class="px-3 py-4">{{ operator.id }}</td>
      <td class="px-3 py-4">{{ operator.username }}</td>
      <td class="px-3 py-4">{{ operator.email }}</td>
      <td class="px-3 py-4">{{ getShipName(operator.ship) }}</td>
      <td>
        <div class="material-icons px-3 py-4" @click="TogglePopup('buttonTriggerEdit'); this.operator = operator">edit</div>
        <div class="material-icons px-3 py-4" @click="deleteUser(operator.id)">delete</div>
      </td>
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
import ShipService from "@/services/ship.service";
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
      ships: [],

      activeSearch: false,
      activeButtonShip: true,
      activeButtonOp: false,
      searchTitle: null,
      columnNumber: null
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

    getShipName(ship) {
      if (ship == null){
        return "No ship assigned";
      }
      let shipFound = this.ships.filter(shipFound => shipFound.id == ship.id);

      if (shipFound !== []) {
        isProxy(shipFound) ? ship = toRaw(shipFound[0]).name : shipFound = shipFound[0].name;
        return shipFound;
      }

    },

    search(){
      let input, filter, table, tr, td, i, txtValue;
      input = document.getElementById("myInput");
      filter = input.value.toUpperCase();
      table = document.getElementById("opTable");
      tr = table.getElementsByTagName("tr");
      for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[this.columnNumber];
        if (td) {
          txtValue = td.textContent || td.innerText;
          if (txtValue.toUpperCase().indexOf(filter) > -1) {
            tr[i].style.display = "";
          } else {
            tr[i].style.display = "none";
          }
        }
      }
    },

    activate(){
      this.activeSearch = true
      this.activeButtonShip = false
      this.activeButtonOp = true
      this.searchTitle = 'ship'
      this.columnNumber = 3
    },

    reActivate(){
      this.activeButtonShip = true
      this.activeButtonOp = false
      this.searchTitle = 'operator'
      this.columnNumber = 1
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