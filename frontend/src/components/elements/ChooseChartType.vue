<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <div class="container shadow-md rounded-md">
    <h1 class="font-semibold dark:text-white-text">Pick a type of chart</h1>
      <input type="radio" name="Line Chart" id="linechart" @click="this.$emit('clicked', 'LineChart')">
      <label for="linechart">
      <div class="material-icons py-4 px-6">show_chart</div>
    </label>

      <input type="radio" name="Bar Chart" id="barchart" @click="this.$emit('clicked', 'BarChart')">
      <label for="barchart">
      <div class="material-icons py-4 px-6">bar_chart</div>
    </label>

      <input type="radio" name="Pie Chart" id="piechart" @click="this.$emit('clicked', 'PieChart')">
      <label for="piechart">
        <div class="material-icons py-4 px-6">pie_chart</div>
    </label>
  </div>
</template>

<script>
export default {
  name: "ChooseChartType",
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