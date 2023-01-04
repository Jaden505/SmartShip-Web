<template>
  <canvas id="engineUsage"></canvas>
</template>

<script>
import Chart from "chart.js/auto";

export default {
  name: "EngineUsage",
  data() {
    return {
      chart: []
    }
  },
  mounted() {
    console.log('Component mounted')
    // this.getChart();
    const ctx = document.getElementById('engineUsage').getContext('2d');
    const gradient = ctx.createLinearGradient(0, 0, 0, 250);
    gradient.addColorStop(0, '#29acda');
    gradient.addColorStop(1, 'rgba(0, 44, 72, 0)');

    // Chart
    const myChart = new Chart(ctx, {
      type: 'line',
      data: {
        labels: ['9:45', '9:46', '9:47', '9:48', '9:49', '9:50'],
        datasets: [{
          data: [65, 59, 80, 81, 56, 55, 40],
          backgroundColor: gradient,
          fill: true,
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
            display: false,
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
