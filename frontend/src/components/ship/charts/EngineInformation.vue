<template>
  <div class="content">
    <h1>Engine Information</h1>
    <p>RPM:</p>
    <div class="chart-container">
      <canvas id="engineInformationChart"></canvas>
      <canvas id="engineInformationChart2"></canvas>
    </div>
    <p>kW:</p>
    <div class="chart-container-bottom">
      <canvas id="engineInformationChart3"></canvas>
      <canvas id="engineInformationChart4"></canvas>
    </div>
    <div class="container">
      <div class="section">
        <p>Engine 1 Temperature</p>
        <h2 class="celcius">60.4°</h2>
      </div>
      <div class="section">
        <p>Engine 2 Temperature</p>
        <h2 class="celcius">62.1°</h2>
      </div>
    </div>
  </div>
</template>

<script>
import Chart from "chart.js/auto";

export default {
  name: "EngineInformation",
  mounted() {
    console.log('Component mounted')
    const ctx = document.getElementById('engineInformationChart');
    const ctx2 = document.getElementById('engineInformationChart2');
    const ctx3 = document.getElementById('engineInformationChart3');
    const ctx4 = document.getElementById('engineInformationChart4');
    const data = {
      labels: [
        'good',
        'warning',
        'critical'
      ],
      datasets: [{
        label: '',
        data: [300, 75, 40],
        backgroundColor: [
          'rgb(57,96,162)',
          'rgb(255, 205, 86)',
          'rgb(235,54,54)',
        ],
        hoverOffset: 4,
        hoverBackgroundColor: [
          'rgb(76,120,190)',
          'rgb(232,191,115)',
          'rgb(232,88,88)',
        ]
      }]
    };
    const myChart = new Chart(ctx, {
      type: 'doughnut',
      data: data,
    });
    const myChart2 = new Chart(ctx2, {
      type: 'doughnut',
      data: data,
    });
    const myChart3 = new Chart(ctx3, {
      type: 'doughnut',
      data: data,
    });
    const myChart4 = new Chart(ctx4, {
      type: 'doughnut',
      data: data,
    });
    myChart;
    myChart2;
    myChart3;
    myChart4;
  }
}
</script>

<style scoped>
.content {
  background-color: #163b7a;
  color: white;
}

.chart-container {
  display: flex;
  margin-bottom: 30px;
  margin-left: 25%;
  height: 150px;
  width: 190px;
}

.chart-container-bottom {
  display: flex;
  margin-left: 25%;
  height: 150px;
  width: 190px;
}

.section {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  text-align: center;
  border-radius: 10px;
  padding: 20px;
  margin: 10px;
  width: 220px;
  height: 75px;
}

.container{
  padding: 20px;
  margin-left: 20%;
  display:flex;
}

.celcius{
  color: deepskyblue;
}
</style>
