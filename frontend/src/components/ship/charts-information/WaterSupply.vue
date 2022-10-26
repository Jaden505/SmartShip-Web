<template>
  <el-card shadow="always" class="el-card">
    <h1>Water Supply</h1>

    <div class="content">
      <el-row class="container">
        <div class="chart-container">
          <canvas id="waterSupplyChart"></canvas>
        </div>
      </el-row>
      <el-row class="container-2">
        <div class="sections">
          <el-card class="section" shadow="always">
            <h2 class="waterAmount-title">Current Consumption</h2>
            <p class="waterAmount">3T</p>
          </el-card>
          <el-card class="section" shadow="always">
            <h2 class="waterAmount-title">Consumption Last 24h</h2>
            <p class="waterAmount">25T</p>
          </el-card>
        </div>
      </el-row>
    </div>
  </el-card>
</template>

<script>
import Chart from 'chart.js/auto';

export default {
  name: "WaterSupply",
  mounted() {
    console.log('Component mounted')
    const ctx = document.getElementById('waterSupplyChart');

    const myChart = new Chart(ctx, {
      type: 'bar',
      data: {
        labels: ['Tank 1', 'Tank 2'],
        datasets: [{
          label: 'Water',
          data: [7, 10],
          barThickness: 40,
          backgroundColor: [
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)'
          ],
          borderColor: [
            'rgba(75, 192, 192, 1)',
            'rgba(75, 192, 192, 1)'
          ],
          borderWidth: 1,
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true,
          }
        }
      }
    });
    myChart;
  }
}

</script>

<style scoped>
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

.waterAmount-title {
  font-size: 1.5rem;
}

.waterAmount {
  font-size: 2rem;
  font-weight: 600;
  padding-top: 10px;
  color: #1CD0FF;
}
</style>
