<template>
  <el-card shadow="always" class="el-card">
    <h1>Engine Information</h1>

    <div class="content">
      <el-row class="container">
        <div class="chart-container">
          <canvas id="engineInformationChart"></canvas>
          <canvas id="engineInformationChart2"></canvas>
        </div>
        <div class="chart-container">
          <canvas id="engineInformationChart3"></canvas>
          <canvas id="engineInformationChart4"></canvas>
        </div>
      </el-row>
      <el-row class="container-2">
        <div class="sections">
          <el-card class="section" shadow="always">
            <h2 class="temperature_title">Engine 1 Temperature</h2>
            <p class="temperature">60.4°</p>
          </el-card>
          <el-card class="section" shadow="always">
            <h2 class="temperature_title">Engine 2 Temperature</h2>
            <p class="temperature">62.1°</p>
          </el-card>
        </div>
      </el-row>
    </div>
  </el-card>
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
    const data2 = {
      labels: [
        'good',
        'warning',
        'critical'
      ],
      datasets: [{
        label: '',
        data: [100, 60, 40],
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
      data: data2,
    });
    const myChart4 = new Chart(ctx4, {
      type: 'doughnut',
      data: data2,
    });
    myChart;
    myChart2;
    myChart3;
    myChart4;
  }
}
</script>

<style scoped>


.chart-container {
  display: flex;
  margin-bottom: 30px;
  height: 150px;
  width: 190px;
}

.sections {
  line-height: 12px;
  display: flex;
  align-items: center;
}

.el-card {
  background: #002C48;
  border: none;
  color: #E0E1DD;
  text-align: center;
  border-radius: 20px;
}

.section {
  margin: 10px;
  box-shadow: 3px 4px 12px 0px rgba(0,0,0,0.5);
  -webkit-box-shadow: 3px 4px 12px 0px rgba(0,0,0,0.5);
  -moz-box-shadow: 3px 4px 12px 0px rgba(0,0,0,0.5);
}

.temperature_title {
  font-size: 1.5rem;
}

.temperature {
  font-size: 2rem;
  font-weight: 600;
  color: #1CD0FF;
  padding-top: 10px;
}

</style>
