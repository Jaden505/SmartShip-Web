<template>
  <canvas id="engine-oil-temperature"></canvas>
  <h1 class="text-2xl text-black-light dark:text-white-text" v-if="lackData">Not enough data is provided to display this graph</h1>
</template>

<script>
import Chart from 'chart.js/auto';

export default {
  name: "EngineInformation",
  props: ["sensordata"],
  watch: {
    sensordata: async function (newVal) {
      if (newVal !== null) {
        newVal = JSON.parse(newVal);
        this.engine_info = await newVal.filter((sensor) => sensor["group"] === "Motor");

        this.createChart();
      }
    }
  },

  data() {
    return {
      lackData: false,
      engine_info: []
    }
  },

  methods: {
    createChart() {
      if (this.engine_info.length <= 1) {
        this.lackData = true;
        return
      }

      const ctx = document.getElementById('engine-oil-temperature').getContext('2d');
      const gradient = ctx.createLinearGradient(0, 0, 0, 250);
      gradient.addColorStop(0, '#29acda');
      gradient.addColorStop(1, 'rgba(0, 44, 72, 0)');


      // Only get last value
      let temp = this.engine_info.filter((sensor) => sensor["sensorName"] === "Engine 1 Temperature");
      let oil_temp = this.engine_info.filter((sensor) => sensor["sensorName"] === "Engine 1 Oil Temperature");
      this.engine_info = [temp[temp.length -1], oil_temp[oil_temp.length -1]];

      // Chart
      const myChart = new Chart(ctx, {
        type: 'bar',
        data: {
          labels: ['Engine oil temperature', 'Engine temperature'],
          datasets: [{
            label: 'Tepmerature',
            data: this.engine_info.map((sensor) => Math.round(sensor["value"])),
            backgroundColor: gradient,
            fill: true,
            barThickness: 40,
            borderWidth: 1,
          }]
        },
        options: {
          indexAxis: 'y',
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
