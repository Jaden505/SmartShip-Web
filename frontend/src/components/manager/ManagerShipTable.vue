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
    <table class="text-center table-auto w-full text-black-text dark:text-white-text">
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
      <tr v-for="(ship, index) in ships" class="bg-purple-basic dark:bg-black-light" :key="index">
        <td class="px-3 py-4">{{ ship.id }}</td>
        <td class="px-3 py-4">{{ ship.name }}</td>
        <td class="px-3 py-4">{{ ship.status.status }}</td>
        <td class="px-3 py-4">{{ getUserPerShip(ship) }}</td>
        <td>
          <font-awesome-icon icon="fa-solid fa-pen-to-square" class="px-3 py-4 cursor-pointer" @click="TogglePopup('buttonTriggerEdit'); this.ship = ship" />
          <font-awesome-icon icon="fa-solid fa-trash" class="px-3 py-4 cursor-pointer" @click="deleteShip(ship.id)"/>
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
import {ref, toRaw} from 'vue';
import createForm from "@/components/manager/forms/createShipForm";
import warningShip from "@/components/manager/forms/warningShip";
import {library} from "@fortawesome/fontawesome-svg-core";
import {faPenToSquare, faTrash} from "@fortawesome/free-solid-svg-icons";

library.add(faTrash, faPenToSquare)

export default {
  name: "ManagerTable",
  components: {
    editForm,
    createForm,
    warningShip
  },

  created() {
    UserService.getUsers()
        .then(response => {
          this.users = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });

    ShipService.getAll()
        .then(response => {
          this.ships = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });

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
    getUserPerShip(assignedShip){
      let users = toRaw(this.users);
      let filtered = users.filter(function (el) {
        return el.ship != null;
      });
      let user = filtered.find(person => person.ship.id === assignedShip.id);
      if (user === undefined){
        return "No ship assigned"
      } else {
        return user.username;
      }
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