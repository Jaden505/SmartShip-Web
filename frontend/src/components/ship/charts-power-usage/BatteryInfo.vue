<template>
  <canvas id="batteryInfo"></canvas>
</template>

<script>
import Chart from "chart.js/auto";

export default {
  name: "BatteryInfo",
  data() {
    return {
      chart: []
    }
  },
  mounted() {
    console.log('Component mounted')
    // this.getChart();
    const ctx = document.getElementById('batteryInfo').getContext('2d');

    // Chart
    const myChart = new Chart(ctx, {
      type: 'line',
      data: {
        labels: ['9:45', '9:46', '9:47', '9:48', '9:49', '9:50'],
        datasets: [{
          label: 'Battery Pack 1',
          data: [86, 86, 86, 85, 85, 85, 84],
          barThickness: 40,
          borderColor: '#15415E',
          borderWidth: 2,
        }, {
            label: 'Battery Pack 2',
            data: [99, 99, 98, 95, 95, 95],
            barThickness: 40,
            borderColor: '#29acda',
            borderWidth: 2,
          }]
      },
      options: {
        maintainAspectRatio: false,
        responsive: true,
        scales: {
          x: {
            ticks: {
              font: {
                size: 17,
                weight: "bold"
              }
            },
            grid: {
              display: false
            }
          },
          y: {
            beginAtZero: true,
            ticks: {
              font: {
                size: 13,
              }
            },
            grid: {
              display: false
            }
          }
        },
        plugins: {
          legend: {
            font: {
              size: 30
            }
          }
        }
      }
    });

    myChart;
  },
}

</script>

<style scoped>
</style>
