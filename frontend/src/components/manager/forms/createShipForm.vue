<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <div class="popup" >
    <div class="popup-inner">
      <td class="material-icons close-popup" @click="TogglePopup()">close</td>

      <h1>Create Ship</h1>
      <form>
        <div class="user-edit-field">
          <label>Name</label><br>
          <input type="text" v-model="newShip.name"><br/>
        </div>
        <div class="user-edit-field">
          <label>Location</label><br>
          <input type="text" v-model="newShip.location"><br/>
        </div>

        <div class="user-edit-field">
          <label>Status</label><br>
          <select v-model="newShip.status">
            <option v-for="(status,index) in statuses" :key="index" :value="status.id">{{ status.status }}</option>
          </select>
        </div>
      </form>
      <button class="primary update-btn" @click="TogglePopup(); create()">Create</button>
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
  background: #163b7a;
  padding: 3%;
}

h1{
  color: white;
}

label{
  width: 100%;
  text-align: center;
  color: white;
}

input{
  width: 100%;
  padding: 1%;
  text-align: center;
}

select{
  width: 100%;
  padding: 1%;
  text-align: center;
}

button{
  margin-top: 10%;
  width: 100%;
}

.user-edit-field {
  padding: 10px;
}

.update-btn {
  background-color: deepskyblue;
  color: white;
}

.update-btn:hover {
  background-color: dodgerblue;
}

.close-popup {
  padding-bottom: 20px;
}

.close-popup:hover {
  color: lightgrey;
  cursor: pointer;
}
</style>
