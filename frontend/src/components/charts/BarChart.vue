<template>
  <canvas id="barChart"></canvas>
  <h1 v-if="lackData">Not enough data is provided to display this graph</h1>
</template>

<script>
import Chart from "chart.js/auto";

export default {
  name: "BarChart",
  props: ["sensor_data", "sensor_group", "chart_name"],
  watch: {
    sensor_data: async function (newVal) {
      if (newVal !== null) {
        newVal = JSON.parse(newVal);
        this.data_points = await newVal.filter((sensor) => sensor["group"] === this.sensor_group);

        this.createChart();
      }
    },
  },

  data() {
    return {
      lackData: false,
      data_points: [],
      min_data_points: 2,
      max_data_points: 2
    }
  },

  methods: {
    createChart() {
      if (this.data_points.length < this.min_data_points) {
        this.lackData = true;
        return
      }

      const labels = this.data_points.map((battery) => battery["sensorName"])
      const data = this.data_points.map((battery) => parseInt(battery["value"]))

      // Only get last max data points values
      this.data_points = this.data_points.slice(this.data_points.length-this.max_data_points, this.data_points.length);

      const ctx = document.getElementById('barChart').getContext('2d');
      const gradient = ctx.createLinearGradient(0, 0, 0, 250);
      gradient.addColorStop(0, '#29acda');
      gradient.addColorStop(1, 'rgba(0, 44, 72, 0)');

      // Chart
      const myChart = new Chart(ctx, {
        type: 'bar',
        data: {
          labels: labels,
          datasets: [{
            label: 'Percentage',
            data: data,
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
