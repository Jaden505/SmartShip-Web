<template>
  <div class="card">
    <h1>Sea conditions</h1>

    <div class="section">
      <p>Sea state</p>
      <h1 class="condition-value">3</h1>
    </div>

    <div class="section">
      <p>Wind direction</p>
      <h1 class="condition-value">North</h1>
    </div>

    <br>

    <div class="section">
      <p>Sea temprature</p>
      <h1 class="condition-value">6.2</h1>
    </div>

    <div class="section">
      <p>Surface current</p>
      <h1 class="condition-value">West</h1>
    </div>
  </div>
</template>

<script>
export default {
  name: "SeaConditions"
}
</script>

<style scoped>
.card {
  background-color: #163b7a;
  color:white;
  width: 700px;
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
