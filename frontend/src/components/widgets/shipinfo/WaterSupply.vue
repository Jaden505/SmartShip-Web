<template>
  <canvas id="waterSupplyChart"></canvas>
</template>

<script>
import Chart from 'chart.js/auto';
import ShipService from "@/services/ship.service";

export default {
  name: "WaterSupply",
  data() {
    return {
      chart: []
    }
  },
  mounted() {
    console.log('Component mounted')
    // this.getChart();
    const ctx = document.getElementById('waterSupplyChart').getContext('2d');
    const gradient = ctx.createLinearGradient(0, 0, 0, 250);
    gradient.addColorStop(0, '#29acda');
    gradient.addColorStop(1, 'rgba(0, 44, 72, 0)');


    // Chart
    const myChart = new Chart(ctx, {
      type: 'bar',
      data: {
        labels: ['Tank 1', 'Tank 2'],
        datasets: [{
          label: 'Water',
          data: [],
          backgroundColor: gradient,
          fill: true,
          barThickness: 40,
          borderWidth: 1,
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

    const shipid = this.$store.state.auth.user.ship;

    // display data
    ShipService.getWater(shipid).then(response => {
      console.log(response.data);

      this.chart = response.data;
      myChart.data.datasets[0].data[0] = response.data[0];
      myChart.data.datasets[0].data[1] = response.data[1];

      myChart.update()
      myChart;
    })

  },
}

</script>

<style scoped>
</style>
