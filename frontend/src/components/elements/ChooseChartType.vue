<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <div class="container shadow-md rounded-md">
    <h1 class="font-semibold dark:text-white-text">Pick a type of chart</h1>

    <div v-for="(type, index) in chartTypes" :key="index">
      <input type="radio" name="type" id="type" @click="this.$emit('clicked', [type, clickedEditComponentIndex])">
      <label for="type">
      <div class="material-icons py-4 px-6">{{ type }}</div>
    </label>
    </div>

  </div>
</template>

<script>
export default {
  name: "ChooseChartType",
  props: ["clickedEditComponentIndex"],

  data() {
    return {
      chartTypes: ["show_chart", "bar_chart", "pie_chart"]
    }
  }
}
</script>

<style scoped>
.container {
  position: absolute;
  z-index: 1;
  left: 60%;
  top: 50%;
  transform: translate(-60%, -50%);
  width: 55%;
  height: 35%;
  text-align: center;
}

h1 {
  margin-top: 5%;
  margin-bottom: 5%;
  font-size: 3rem;
}

/* HIDE RADIO */
[type=radio] {
  display: none;
}

[type=radio] + label {
  background-color: #151515;
  color:white;
}

label:hover {
  cursor: pointer;
}

/* CHECKED STYLES */
[type=radio]:checked + label {
  background-color: #151515;
  color:white;
}
.material-icons {
  font-size: 5rem;
}
</style>