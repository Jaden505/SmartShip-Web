<template>
  <div class="card">
    <h1>Water Supply</h1>
    <div class="chart-container">
      <canvas id="waterSupplyChart"></canvas>
    </div>
    <div class="flex-container">
      <div class="section">
        <p>Current Consumption</p>
        <h2 class="waterAmount">3T</h2>
      </div>
      <div class="section">
        <p>Consumption Last 24h</p>
        <h2 class="waterAmount">25T</h2>
      </div>
    </div>

  </div>
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
.card {
  background-color: #163b7a;
  color: white;
}

h1 {
  color: deepskyblue;
}

.chart-container {
  /*display: flex;*/
  /*margin-left: 42%;*/
  /*height:300px;*/
  /*width: 500px;*/
}

.section {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  text-align: center;
  /*border-radius: 10px;*/
  padding: 20px;
  margin-left: 10px;
}

.flex-container {
  display: flex;
}

.waterAmount {
  color: deepskyblue;
}
</style>
