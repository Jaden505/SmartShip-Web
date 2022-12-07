<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <div class="popup">
    <div class="popup-inner">
      <td class="material-icons close-popup" @click="TogglePopup(); update(current.id, current)">close</td>

      <h1>Edit Operator</h1>
      <form>
        <div class="user-edit-field">
          <label>Name</label><br>
          <input type="text" v-model="current.username"><br/>
        </div>
        <div class="user-edit-field">
          <label>Email</label><br>
          <input type="email" v-model="current.email"><br/>
        </div>
        <div class="user-edit-field">
          <label>Password</label><br>
          <input type="password" v-model="current.password"><br/>
        </div>
        <div class="user-edit-field">
          <label>Ship</label><br>
          <select v-model="current.shipID">
            <option :value="null"></option>
            <option v-for="(ship,index) in ships" :key="index" :value="ship.id">{{ ship.name }}</option>
          </select>
        </div>
      </form>
      <button class="primary update-btn" @click="TogglePopup(); update(current.id, current)">Update</button>
    </div>
  </div>
</template>

<script>
import UserService from "@/services/user.service";
import ShipService from "@/services/ShipService";

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

h1 {
  color: white;
}

label {
  width: 100%;
  text-align: center;
  color: white;
}

input {
  width: 100%;
  padding: 1%;
  text-align: center;
}

select{
  width: 100%;
  padding: 1%;
  text-align: center;
}

button {
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