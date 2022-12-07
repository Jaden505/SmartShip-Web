<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <div class="popup">
    <div class="popup-inner" v-motion-fade>
      <td class="material-icons close-popup" @click="TogglePopup(); update(current.id, current)">close</td>
      <h1 class="font-bold">Edit Manager</h1>
      <form class="w-full max-w-sm">
        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="name">
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
            <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="email">
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
            <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="password">
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
            <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="password">
              Ship
            </label>
          </div>
          <div class="md:w-2/3">
            <div class="inline-block relative w-48">
              <select class="block appearance-none w-full bg-white border border-gray-400 hover:border-gray-500 px-4 py-2 pr-8 rounded shadow leading-tight focus:outline-none focus:shadow-outline"
                      v-model="current.shipID">
                <option :value="null"></option>
                <option v-for="(ship,index) in ships" :key="index" :value="ship.id">{{ ship.name }}</option>
              </select>
              <div class="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700">
                <svg class="fill-current h-4 w-4" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z"/></svg>
              </div>
            </div>
          </div>
        </div>
        <div class="md:flex md:items-center">
            <button class="shadow focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded"
                    type="button"
                    @click="TogglePopup(); update(current.id, current)">
              Update
            </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import UserService from "@/services/user.service";
import ShipService from "@/services/ShipService";

export default {
  name: "editManagerForm",
  props: ['TogglePopup', 'manager'],

  data() {
    return {
      current: this.manager,
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
.popup {
  position: fixed;
  top: -20%;
  left: 0;
  right: 0;
  bottom: 0;
  z-index: 99;
  background-color: rgba(0, 0, 0, 0.6);

  display: flex;
  align-items: center;
  justify-content: center;
}

.popup-inner {
  background: #00111C;
  padding: 3%;
  border: 2px solid black;
  border-radius: 25px;
  box-shadow: 5px 5px black;
}

.close-popup {
  padding-bottom: 20px;
  transition: color 0.5s;
}

.close-popup:hover {
  color: lightgrey;
  cursor: pointer;
}

/*Form*/

h1 {
  color: white;
  text-align: center;
  font-size: 24px;
  margin-bottom: 5%;
}

label {
  width: 100%;
  text-align: center;
  color: white;
}

input {
  width: 100%;
  padding: 1%;
}

input:focus{
  border: 2px solid black;
}

select{
  width: 100%;
  padding: 1%;
}

button {
  margin-top: 10%;
  width: 100%;
  background-color: white;
  transition: background-color 0.5s;
}

button:hover{
  background-color: deepskyblue;
}
</style>