<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <div class="popup" >
    <div class="popup-inner">
      <td class="material-icons close-popup" @click="TogglePopup()">close</td>

      <h1>Edit Operator</h1>
      <form>
        <div class="user-edit-field">
          <label>Name</label><br>
          <input type="text" v-model="current.username"><br/>
        </div>
        <div class="user-edit-field">
          <label>Email</label><br>
          <input type="text" v-model="current.email"><br/>
        </div>
      </form>
      <el-button class="primary update-btn" @click="TogglePopup()">Update</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "editUserForm",
  props: ['TogglePopup', 'operator'],

  data(){
    return {
      current: this.operator
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