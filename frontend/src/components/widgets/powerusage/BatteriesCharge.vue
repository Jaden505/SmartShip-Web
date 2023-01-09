<template>
  <canvas id="waterSupplyChart"></canvas>
  <h1 v-if="lackData">Not enough data is provided to display this graph</h1>
</template>

<script>
import Chart from 'chart.js/auto';
import ShipService from "@/services/ship.service";

export default {
  name: "BatteriesCharge",
  props: ["sensordata"],
  watch: {
    sensordata: async function (newVal) {
      if (newVal !== null) {
        newVal = JSON.parse(newVal);
        this.batteries = await newVal.filter((sensor) => sensor["group"] === "Battery");

        this.createChart();
      }
    }
  },

  data() {
    return {
      lackData: false,
      batteries: []
    }
  },

  methods: {
    createChart() {
      if (this.batteries.length < 2 || this.batteries.length <= 0) {
        this.lackData = true;
        return
      }

      // Only get last 2 values
      this.usages = this.batteries.slice(this.batteries.length-2, this.batteries.length);

      const ctx = document.getElementById('waterSupplyChart').getContext('2d');
      const gradient = ctx.createLinearGradient(0, 0, 0, 250);
      gradient.addColorStop(0, '#29acda');
      gradient.addColorStop(1, 'rgba(0, 44, 72, 0)');

      // Chart
      const myChart = new Chart(ctx, {
        type: 'bar',
        data: {
          labels: this.batteries.map((battery) => battery["sensorName"]),
          datasets: [{
            label: 'Percentage',
            data: this.batteries.map((battery) => parseInt(battery["value"])),
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
