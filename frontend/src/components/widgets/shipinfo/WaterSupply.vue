<template>
  <canvas id="waterSupplyChart"></canvas>
  <h1 v-if="lackData">Not enough data is provided to display this graph</h1>
</template>

<script>
import Chart from 'chart.js/auto';
import ShipService from "@/services/ship.service";

export default {
  name: "WaterSupply",
  data() {
    return {
      tank1 : null,
      tank2 : null,
      lackData: false,
    }
  },

  mounted() {
    this.getWaterSupply();
  },

  methods: {
    getWaterSupply() {
      const ship_id = this.$store.state.auth.user.ship;

      ShipService.getWaterSupply(ship_id).then(
        response => {
          this.tank1 = response.data[0];
          this.tank2 = response.data[1];

          if (this.tank1 === null || this.tank2 === null) {
            this.lackData = true;
            return
          }

          this.createChart();
        },
        error => {
          console.log(error);
        }
      );
    },

    createChart() {
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
            data: [this.tank1, this.tank2],
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

      myChart;
    }
  },
}

</script>

<style scoped>
h1 {
  text-align: center;
  font-size: 20px;
  color: lightgrey;
  margin-top: 20px;
}
</style>
