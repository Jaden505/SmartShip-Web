<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <div class="popup">
    <div class="popup-inner" v-motion-fade>
      <td class="material-icons close-popup" @click="TogglePopup(); update(current.id, current)">close</td>
      <h1 class="font-bold">Edit Ship</h1>
      <form class="w-full max-w-sm">
        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="name">
              Ship name
            </label>
          </div>
          <div class="md:w-2/3">
            <input
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                id="name"
                type="text"
                v-model="current.name">
          </div>
        </div>

        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="origin">
              Origin
            </label>
          </div>
          <div class="md:w-2/3">
            <input
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                id="origin"
                type="text"
                v-model="current.origin">
          </div>
        </div>

        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="status">
              Status
            </label>
          </div>
          <div class="md:w-2/3">
            <select v-model="current.status">
              <option v-for="(status,index) in statuses" :key="index" :value="status.id" >{{ status.status }}</option>
            </select>
          </div>
        </div>

        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="location">
              Location
            </label>
          </div>
          <div class="md:w-2/3">
            <input
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                id="location"
                type="text"
                v-model="current.location">
          </div>
        </div>

        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="destination">
              Destination
            </label>
          </div>
          <div class="md:w-2/3">
            <input
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                id="destination"
                type="text"
                v-model="current.destination">
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
import ShipService from "@/services/ship.service";
import StatusService from "@/services/status.service";

export default {
  name: "editUserForm",
  props: ['TogglePopup', 'ship'],

  data() {
    return {
      current: this.ship,
      statuses: []
    }
  },

  methods: {
    update(ship_id, current) {
      ShipService.updateShip(ship_id, current)
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
  },

  mounted() {
    this.getStatuses();
  },
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
  background-color: lightskyblue;
}

</style>