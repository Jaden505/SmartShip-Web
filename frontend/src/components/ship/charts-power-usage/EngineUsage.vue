<template>
  <el-card shadow="always" class="el-card">
      <h1>Starboard Engine Usage</h1>
      <canvas class="chart-container" ref="chart-container"></canvas>
  </el-card>
</template>

<script>
import Chart from "chart.js/auto";

export default {
  name: "EngineUsage",

  mounted() {
    let chart_container = this.$refs["chart-container"];

    const labels = ["09:00", "10:00", "11:00", "12:00", "13:00"];
    const data = {
      labels: labels,
      datasets: [{
        label: "Kilowatt an hour",
        data: [65, 59, 80, 81, 56, 55, 40],
        fill: false,
        borderColor: 'rgb(75, 192, 192)',
        tension: 0.1
      }]
    };

    const config = {
      type: 'line',
      data: data,
    }

    let chart = new Chart(chart_container, config);

    chart;
  }
}
</script>

<style scoped>
.el-card {
  background: #002C48;
  border: none;
  color: #E0E1DD;
  text-align: center;
  border-radius: 20px;
}

.chart-container {
  display: flex;
  margin-bottom: 30px;
  height: 370px;
  width: 190px;
}
</style>
