<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <Teleport to="#modal">
    <div class="modal-bg">
      <div class="modal p-10 rounded-md shadow-md bg-blue-regular dark:bg-black-light" v-motion-fade>
        <font-awesome-icon class="close-popup text-black-light dark:text-white-text" icon="fa-solid fa-xmark" @click="TogglePopup(); update(current.id, current)">close</font-awesome-icon>
      <h1 class="font-bold text-center mb-4 text-black-text dark:text-white-text">Edit Operator</h1>
      <form class="w-full max-w-sm">
        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4" for="name">
              Name
            </label>
          </div>
          <div class="md:w-2/3">
            <input class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                   id="name"
                   type="text"
                   v-model="current.username">
          </div>
        </div>
        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4" for="email">
              Email
            </label>
          </div>
          <div class="md:w-2/3">
            <input class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                   id="email"
                   type="email"
                   v-model="current.email">
          </div>
        </div>
        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4" for="password">
              Password
            </label>
          </div>
          <div class="md:w-2/3">
            <input class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                   id="password"
                   type="password"
                   v-model="current.password">
          </div>
        </div>
        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4" for="password">
              Ship
            </label>
          </div>
          <div class="md:w-2/3">
            <div class="inline-block relative w-48">
              <select class="block appearance-none w-full bg-white border border-gray-400 hover:border-gray-500 px-4 py-2 pr-8 rounded shadow leading-tight focus:outline-none focus:shadow-outline"
                      v-model="current.ship">
                <option :value="null"></option>
                <option v-for="(ship,index) in ships" :key="index" :value="ship">{{ ship.name }}</option>
              </select>
              <div class="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700">
                <svg class="fill-current h-4 w-4" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z"/></svg>
              </div>
            </div>
          </div>
        </div>
        <div class="md:flex md:items-center">
          <button class="shadow bg-blue-regular w-full mt-2 text-black-light dark:text-white-text font-bold py-2 px-4 rounded-md"
                  type="button"
                  @click="TogglePopup(); update(current.id, current)">
            Update
          </button>
        </div>
      </form>
    </div>
  </div>
  </Teleport>
</template>

<script>
import UserService from "@/services/user.service";
import ShipService from "@/services/ship.service";

export default {
  name: "editUserForm",
  props: ['TogglePopup', 'operator'],

  data() {
    return {
      current: this.operator,
      ships: []
    }
  },

  methods: {
    update(user_id, current) {
      UserService.updateUser(user_id, current)
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
    }
  },

  created() {
    this.getShips()
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