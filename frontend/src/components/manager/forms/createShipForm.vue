<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <Teleport to="#modal">
  <div class="modal-bg" >
    <div class="modal p-10 rounded-md shadow-md bg-blue-regular dark:bg-black-light" v-motion-fade>
      <font-awesome-icon class="close-popup text-black-light dark:text-white-text" icon="fa-solid fa-xmark" @click="TogglePopup()"/>

      <h1 class="font-bold text-black-text dark:text-white-text">Create Ship</h1>
      <form class="w-full max-w-sm">

        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4" for="id">
              Ship Id
            </label>
          </div>
          <div class="md:w-2/3">
            <input type="text" class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white" :class="{error: isError}" v-model="newShip.id">
          </div>
        </div>

        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4" for="name">
              Name
            </label>
          </div>
          <div class="md:w-2/3">
            <input type="text" class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white" :class="{error: isError}" v-model="newShip.name">
          </div>
        </div>

        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4" for="status">
              Status
            </label>
          </div>
          <div class="md:w-2/3">
            <select :class="{error: isError}" v-model="newShip.status">
              <option v-for="(status,index) in statuses" :key="index" :value="status.id">{{ status.status }}</option>
            </select>
          </div>
        </div>

        <div class="form-group md:flex md:items-center">
          <button class="shadow bg-blue-regular w-full mt-2 text-black-light dark:text-white-text font-bold py-2 px-4 rounded-md"
                  @click="create()">Create</button>
        </div>

      </form>

    </div>
  </div>
  </Teleport>
</template>

<script>
import ShipService from "@/services/ship.service";
import StatusService from "@/services/status.service";
import Ship from "@/models/ship"

import {library} from "@fortawesome/fontawesome-svg-core";
import {faXmark} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/vue-fontawesome";

library.add(faXmark)

export default {
  name: "createUserForm",
  props: ['TogglePopup'],

  mounted() {
    this.getStatuses();
  },

  data(){
    return {
      newShip: new Ship("","", "", 1400, 1400), // Defaults
      statuses: [],
      isError: false
    }
  },

  methods: {
    checkFields() {
      return (this.newShip.name !== "" && this.newShip.status !== "");
    },

    create() {
      if (this.checkFields()) {
        this.isError = false
        ShipService.create(this.newShip)
        location.reload()
        this.TogglePopup()
      }
      else {
        this.isError = true
      }
    },

    getStatuses() {
      StatusService.get()
          .then(response => {
            this.statuses = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    }
  }
}
</script>

<style scoped>
h1 {
  text-align: center;
  font-size: 24px;
  margin-bottom: 5%;
}

label {
  width: 100%;
  text-align: center;
}

input {
  width: 100%;
  padding: 1%;
}

input:focus {
  border: 2px solid black;
}

select {
  width: 100%;
  padding: 1%;
}
</style>
