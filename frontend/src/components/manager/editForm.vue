<template>
  <div class="popup" >
    <div class="popup-inner">
      <h1>Edit Operator</h1>
      <form>
        <label>Operator Name</label><br>
        <input type="text" v-model="current.username"><br>
        <label>Email</label><br>
        <input type="email" v-model="current.email"><br/>
        <label>Password</label><br>
        <input type="password" v-model="current.password"><br/>
      </form>
      <button class="popup-close" @click="TogglePopup(); update(current.id, current)">
        Update
      </button>
    </div>
  </div>
</template>

<script>
import UserService from "../../services/user.service";

export default {
  name: "editForm",
  props: ['TogglePopup', 'operator'],

  data(){
    return {
      current: this.operator
    }
  },

  methods: {
    update(user_id, current) {
      UserService.updateUser(user_id, current)
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
}

button{
  margin-top: 10%;
  width: 100%;
}
</style>