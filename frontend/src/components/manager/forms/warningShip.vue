<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <div class="popup" >
    <div class="popup-inner">
      <td class="material-icons close-popup" @click="TogglePopup()">close</td>
        <h1>Cannot delete this ship!</h1>
        <p>This ship has operators assigned. Please remove all the operators before deleting this ship!</p>
    </div>
  </div>
</template>

<script>

export default {
  name: "warningShip",
  props: ['TogglePopup'],

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
  background: #fd3f3f;
  box-shadow: 1px 1px black;
  padding: 3%;
  border-radius: 20px;
  border: 2px solid black;
}

.close-popup {
  padding-bottom: 20px;
  transition: color 0.8s;
}

.close-popup:hover {
  color: lightgrey;
  cursor: pointer;
}

h1{
  text-align: center;
  font-size: 24px;
  margin-bottom: 1%;
}

p{
  font-size: 20px;
}

</style>
