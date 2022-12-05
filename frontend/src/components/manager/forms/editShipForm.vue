<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <div class="popup" >
    <div class="popup-inner">
      <td class="material-icons close-popup" @click="TogglePopup(); update(current.id, current)">close</td>

      <h1>Edit Ship</h1>
      <form>
        <div class="user-edit-field">
          <label>Ship name</label><br>
          <input type="text" v-model="current.name"><br/>
        </div>
        <div class="user-edit-field">
          <label>Location</label><br>
          <input type="text" v-model="current.location"><br/>
        </div>
        <div class="user-edit-field">
          <label>Origin</label><br>
          <input type="text" v-model="current.origin"><br/>
        </div>
        <div class="user-edit-field">
          <label>Destination</label><br>
          <input type="text" v-model="current.destination"><br/>
        </div>
      </form>
      <button class="primary update-btn" @click="TogglePopup(); update(current.id, current)">Update</button>
    </div>
  </div>
</template>

<script>
import ShipService from "@/services/ShipService";

export default {
  name: "editUserForm",
  props: ['TogglePopup', 'ship'],

  data(){
    return {
      current: this.ship
    }
  },

  methods: {
    update(ship_id, current) {
        ShipService.updateShip(ship_id, current)
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