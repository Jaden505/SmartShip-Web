<template>
  <canvas id="chart"></canvas>
  <h1 v-if="lackData">Not enough data is provided to display this graph</h1>
</template>

<script>
import CreateCharts from "@/assets/js/CreateCharts.js";

export default {
  name: "CreateChart",
  props: ["sensor_data", "sensor_name", "sensor_group", "chart_type"],
  watch: {
    sensor_data: async function (newVal) {
      if (newVal !== null) {
        newVal = JSON.parse(newVal);

        if (this.sensor_name == null) {
          this.data_points = await newVal.filter((sensor) => sensor["group"] === this.sensor_group);
        } else {
          this.data_points = await newVal.filter((sensor) => sensor["sensorName"] === this.sensor_name);
        }

        this.createChart();
      }
    },
  },

  data() {
    return {
      lackData: false,
      data_points: [],
      min_data_points: 0,
      max_data_points: 0
    }
  },

  methods: {
    createChart() {
      switch(this.chart_type) {
        case "line":
          this.min_data_points = 4;
          this.max_data_points = 8;
          break;
        case "bar":
          this.min_data_points = 2;
          this.max_data_points = 2;
          break;
        case "pie":
          this.min_data_points = 2;
          this.max_data_points = 8;
          break;
      }

      // Check if there is enough data to display the graph
      if (this.data_points.length < this.min_data_points) {
        this.lackData = true;
        return
      }

      // Only get last max data points values
      this.data_points = this.data_points.slice(this.data_points.length-this.max_data_points, this.data_points.length);

      // Setup chart
      const ctx = document.getElementById('chart').getContext('2d');
      const gradient = ctx.createLinearGradient(0, 0, 0, 250);
      gradient.addColorStop(0, '#29acda');
      gradient.addColorStop(1, 'rgba(0, 44, 72, 0)');

      switch(this.chart_type) {
        case "line":
          CreateCharts.createLineChart(ctx, gradient, this.data_points);
          break;
        case "bar":
          CreateCharts.createBarChart(ctx, gradient, this.data_points);
          break;
        case "pie":
          CreateCharts.createPieChart(ctx, gradient, this.data_points);
          break;
      }
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
