<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <Teleport to="#modal">
  <div class="modal-bg" >
    <div class="modal p-10 rounded-md shadow-md bg-blue-regular dark:bg-black-light" v-motion-fade>
      <td class="material-icons close-popup" @click="TogglePopup()">close</td>

      <h1 class="font-bold">Create Ship</h1>
      <form class="w-full max-w-sm">

        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="id">
              Ship Id
            </label>
          </div>
          <div class="md:w-2/3">
            <input type="text" :class="{error: isError}" v-model="newShip.id">
          </div>
        </div>

        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="name">
              Name
            </label>
          </div>
          <div class="md:w-2/3">
            <input type="text" :class="{error: isError}" v-model="newShip.name">
          </div>
        </div>

        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="status">
              Status
            </label>
          </div>
          <div class="md:w-2/3">
            <select :class="{error: isError}" v-model="newShip.status">
              <option v-for="status in statuses" :value="status" :key="status.id">{{ status.status }}</option>
            </select>
          </div>
        </div>
        <div class="form-group md:flex md:items-center">
          <button class="shadow focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded"
                  @click="create()">Create</button>
        </div>

      </form>

    </div>
  </div>
  </Teleport>
</template>

<script>
import ShipService from "@/services/ship.service";
import {Ship, status} from "@/models/ship"

export default {
  name: "createUserForm",
  props: ['TogglePopup'],

  data(){
    return {
      newShip: new Ship("","", "", "", "", 1400, 1400),
      statuses: status,
      isError: false,
    }
  },

  methods: {
    checkFields() {
      return (this.newShip.name !== "");
    },

    create() {
      if (this.checkFields()) {
        this.isError = false
        ShipService.create(this.newShip)
        this.TogglePopup()
      }
      else {
        this.isError = true
      }
    },
  }
}
</script>

<style scoped>
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

.error{
  border: red 2px solid;
  animation: shake 0.2s ease-in-out 0s 2;
  box-shadow: 0 0 0.6rem #ff0000;
}

@keyframes shake {
  0% {
    margin-left: 0rem;
  }
  25% {
    margin-left: 0.5rem;
  }
  75% {
    margin-left: -0.5rem;
  }
  100% {
    margin-left: 0rem;
  }
}
</style>
