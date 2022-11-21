<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <div class="popup" >
    <div class="popup-inner">
      <td class="material-icons close-popup" @click="TogglePopup()">close</td>

      <h1>Create Operator</h1>
      <form>
        <div class="user-edit-field">
          <label>Name</label><br>
          <input type="text" v-model="newUser.name"><br/>
        </div>
        <div class="user-edit-field">
          <label>Email</label><br>
          <input type="email" v-model="newUser.email"><br/>
        </div>
        <div class="user-edit-field">
          <label>Password</label><br>
          <input type="password" v-model="newUser.password"><br/>
        </div>
      </form>
      <el-button class="primary update-btn" @click="TogglePopup(); create()">Create</el-button>
    </div>
  </div>
</template>

<script>
import UserService from "@/services/user.service";
import User from "@/models/user"

export default {
  name: "createUserForm",
  props: ['TogglePopup'],

  data(){
    return {
      newUser: new User("", "", "")
    }
  },

  methods: {
    checkFields() {
      return (this.newUser.name !== "" && this.newUser.email !== "" && this.newUser.password !== "");
    },

    create() {
      if (this.checkFields()) {
        UserService.createUser()
      }
      else {
        alert("Please fill all fields to create a user.")
      }
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