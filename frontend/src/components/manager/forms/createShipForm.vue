<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <div class="popup" >
    <div class="popup-inner" v-motion-fade>
      <td class="material-icons close-popup" @click="TogglePopup()">close</td>

      <h1 class="font-bold">Create Ship</h1>
      <form class="w-full max-w-sm">

        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="name">
              Name
            </label>
          </div>
          <div class="md:w-2/3">
            <input type="text" v-model="newShip.name">
          </div>
        </div>

        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="location">
              Location
            </label>
          </div>
          <div class="md:w-2/3">
            <input type="text" v-model="newShip.location">
          </div>
        </div>

        <div class="md:flex md:items-center mb-6">
          <div class="md:w-1/3">
            <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="status">
              Status
            </label>
          </div>
          <div class="md:w-2/3">
            <select v-model="newShip.status">
              <option v-for="(status,index) in statuses" :key="index" :value="status.id">{{ status.status }}</option>
            </select>
          </div>
        </div>

        <div class="form-group md:flex md:items-center">
          <button class="shadow focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded"
                  @click="TogglePopup(); create()">Create</button>
        </div>

      </form>

    </div>
  </div>
</template>

<script>
import ShipService from "@/services/ShipService";
import StatusService from "@/services/status.service";
import Ship from "@/models/ship"

export default {
  name: "createUserForm",
  props: ['TogglePopup'],

  mounted() {
    this.getStatuses();
  },

  data(){
    return {
      newShip: new Ship("", "", "", 1, 2, 0, 0), // Defaults
      statuses: []
    }
  },

  methods: {
    checkFields() {
      return (this.newShip.name !== "" && this.newShip.location !== "" && this.newShip.status !== "");
    },

    create() {
      if (this.checkFields()) {
        ShipService.create(this.newShip)
      }
      else {
        alert("Please fill all fields to create a ship.")
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
