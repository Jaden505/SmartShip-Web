<template>
  <canvas id="engineUsage"></canvas>
  <h1 v-if="lackData">Not enough data is provided to display this graph</h1>
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
      lackData: false,
      usages: []
    }
  },

  methods: {
    createChart() {
      if (this.usages.length < 8) {
        this.lackData = true;
        return
      }

      this.usages = this.usages.slice(this.usages.length-8, this.usages.length);

      const ctx = document.getElementById('engineUsage').getContext('2d');
      const gradient = ctx.createLinearGradient(0, 0, 0, 250);
      gradient.addColorStop(0, '#29acda');
      gradient.addColorStop(1, 'rgba(0, 44, 72, 0)');

      // Get last 8 data points
      const labels = this.usages.map((usage) => usage["time"].substring(0, 5))
      const data = this.usages.map((usage) => usage["value"])

      // Chart
      const myChart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: labels,
          datasets: [{
            data: data,
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
                },
                callback: function(value) {
                  return value + ' KW';
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
h1 {
  text-align: center;
  font-size: 20px;
  color: lightgrey;
  margin-top: 20px;
}
</style>
