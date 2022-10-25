<template>
  <div class="card">
    <div class="content m-lg-2">
      <h1>Starboard Engine Usage</h1>

      <canvas class="chart-container"></canvas>
    </div>

  </div>
</template>

<script>
import Chart from "chart.js/auto";

export default {
  name: "EngineUsage",

  mounted() {
    let line_chart = document.getElementById("chart-container");

    var chart = new Chart(line_chart, {
      animationEnabled: true,
      theme: "light2",
      title: {
        text: "Simple Line Chart"
      },
      data: [{
        type: "line",
        indexLabelFontSize: 16,
        dataPoints: [
          {y: 450},
          {y: 414},
          {y: 520, indexLabel: "\u2191 highest", markerColor: "red", markerType: "triangle"},
          {y: 460},
          {y: 450},
          {y: 500},
          {y: 480},
          {y: 480},
          {y: 410, indexLabel: "\u2193 lowest", markerColor: "DarkSlateGrey", markerType: "cross"},
          {y: 500},
          {y: 480},
          {y: 510}
        ]
      }]
    });

    chart.render();
  }
}
</script>

<style scoped>
.card {
  background-color: #163b7a;
  color: white;
}
h1{
  color: deepskyblue;
}

.chart-container {
  display: flex;
  margin-bottom: 30px;
  height: 370px;
  width: 190px;
}
</style>
