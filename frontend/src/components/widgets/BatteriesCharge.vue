<template>
  <canvas id="waterSupplyChart"></canvas>
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
      batteries: []
    }
  },

  methods: {
    createChart() {
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
</style>
