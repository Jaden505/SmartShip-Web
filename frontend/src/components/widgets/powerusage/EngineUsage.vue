<template>
  <canvas id="engineUsage"></canvas>
</template>

<script>
import Chart from "chart.js/auto";

export default {
  name: "EngineUsage",
  props: ["sensordata"],
  watch: {
    sensordata: async function (newVal) {
      if (newVal !== null) {
        newVal = JSON.parse(newVal);
        this.usages = await newVal.filter((sensor) => sensor["sensorName"] === "Engine 1 Temperature");

        this.createChart();
      }
    }
  },

  data() {
    return {
      chart: [],
      usages: []
    }
  },

  methods: {
    createChart() {
      console.log(this.usages)
      const ctx = document.getElementById('engineUsage').getContext('2d');
      const gradient = ctx.createLinearGradient(0, 0, 0, 250);
      gradient.addColorStop(0, '#29acda');
      gradient.addColorStop(1, 'rgba(0, 44, 72, 0)');

      // Chart
      const myChart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: this.usages.slice(0, 8).map((usage) => usage["time"].substring(0, 5)),
          datasets: [{
            data: this.usages.map((usage) => usage["value"]),
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
    }
  }
}

</script>

<style scoped>
</style>
