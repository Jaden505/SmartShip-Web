<template>
  <div class="card">
    <h1>Sea conditions</h1>

    <div class="section">
      <p>Battery pack 1 level</p>
      <h1 class="condition-value">88%</h1>
    </div>



    <div class="section">
      <p>Battery pack 2 level</p>
      <h1 class="condition-value">67%</h1>
    </div>

    <br><br>

    <div class="section">
      <p>Battery pack 1 temperature</p>
      <h1 class="condition-value">45°C</h1>
    </div>

    <div class="section">
      <p>Battery pack 2 temperature</p>
      <h1 class="condition-value">60°C</h1>
    </div>
  </div>
</template>

<script>
export default {
  name: "BatteryInfo"
}
</script>

<style scoped>
.card {
  background-color: #163b7a;
  color:white;
  width: 700px;
  display: inline-block;
  padding: 30px;
}
h1{
  color:deepskyblue;
}

.section {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  text-align: center;
  display: inline-block;
  width: 250px;
}

.condition-value {
  color: deepskyblue;
}
</style>
