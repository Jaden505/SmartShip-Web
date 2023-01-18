<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <ChooseChartType v-if="ischoosingChart" @clicked="changeChartType" />

  <div v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100">
    <button @click="this.switchEditing();"
            class="edit-dashboard text-black-text dark:text-white-text bg-blue-regular font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text">Edit dashboard</button>

    <div class="dropdown">
      <button :class="{hidden: !isEditing}"
              class="edit-dashboard text-white bg-blue-regular font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text drop-btn">Add</button>
      <div class="dropdown-content text-black-text dark:text-white-text">
        <a v-for="(chart_data, index) in addableCharts" :key="index" @click="switchDisplayChart(chart_data)">{{chart_data.chart_name}}</a>
      </div>
    </div>

    <button :class="{hidden: !isEditing}" @click="setChartPositions(); this.$router.go()"
            class="edit-dashboard text-white bg-blue-regular font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text drop-btn">Save</button>

    <!-- Loop component widgets -->
    <div class="grid grid-cols-1 p-4 space-y-8 lg:gap-8 lg:space-y-0 lg:grid-cols-4 comp-wrapper">
      <div class="show-context" v-for="(chart_data, index) in shownCharts" :key="index">

        <!-- Allows the dragging and dropping of the component -->
        <div class="col-span-2 shadow-md rounded-md droppable"
             :draggable="isEditing" @dragstart="dmc.onDragStart($event, chart_data)"
             @drop.prevent="this.shownCharts = dmc.dropHandler($event, chart_data, shownCharts)" @dragover.prevent>

          <div class="bg-blue-regular text-black-text dark:text-white-text">
            <div class="material-icons py-4 px-6" :class="{hidden: !isEditing}" @click="switchDisplayChart(chart_data)">close</div>
            <div class="material-icons py-4 px-6" :class="{hidden: !isEditing}" @click="ischoosingChart = !ischoosingChart; selectedChart = chart_data">edit</div>

          </div>
          <div class="flex items-center justify-between p-4">
            <h4 class="text-xl font-semibold text-black-text dark:text-white-text">{{chart_data.chart_name}}</h4>
          </div>

          <div class="relative p-4 h-72 text-black-light dark:text-white-text component-container" :id="chart_data.chart_name">
            <div class="position-number" :class="{hidden: !isEditing}"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import {DashboardMoveComponents} from "@/assets/js/DashboardMoveComponents";
import SensordataService from "@/services/sensordata.service";
import ChooseChartType from "@/components/elements/ChooseChartType";
import SetupChart from "@/assets/js/SetupChart";

export default {
  name: "PowerUsage",
  components: {
    ChooseChartType,
  },

  data() {
    return {
      selectedChart: null,
      isEditing: false,
      ischoosingChart: false,
      sensordata: null,
      dmc: null,
      shownCharts: [],
      addableCharts: [{"sensor_name": null, "sensor_group": "Battery", "chart_name": "BatteriesCharge", "chart_type": "bar"},
        {"sensor_name": "Engine 1 Temperature", "sensor_group": "Motor", "chart_name": "EngineUsage", "chart_type": "line"}]
    }
  },

  async mounted() {
    await this.getSensorData();

    await this.getChartsPosition();

    this.createCharts();

    // Initiate the DashboardMoveComponents class
    this.dmc = new DashboardMoveComponents();
  },

  methods: {
    switchEditing() {
      this.isEditing = !this.isEditing;

      document.querySelectorAll(".droppable").forEach(chart => {
        chart.draggable = !chart.draggable;
      })
    },

    switchDisplayChart(chart) {
      // Display
      if (this.addableCharts.includes(chart)) {
        this.shownCharts.push(chart);
        this.addableCharts.splice(this.addableCharts.indexOf(chart), 1);
      }
      // Hide
      else if (this.shownCharts.includes(chart)) {
        this.addableCharts.push(chart);
        this.shownCharts.splice(this.shownCharts.indexOf(chart), 1);
      }
    },

    getChartsPosition() {
      // Get charts from local storage
      if (localStorage.charts) {
        let chart_names = this.addableCharts.map(chart_data => chart_data.chart_name);

        for (let chart of JSON.parse(localStorage.charts)) {
          // Check if chart was saved in local storage
          if (chart_names.includes(chart)) {
            this.switchDisplayChart(this.addableCharts[chart_names.indexOf(chart)]);
            chart_names.splice(chart_names.indexOf(chart), 1);
          }
        }
      }
      else {
        // Display all charts by default
        this.shownCharts = this.addableCharts;
        this.addableCharts = [];
      }
    },

    setChartPositions() {
      // Save chart names in local storage
      localStorage.setItem('charts', JSON.stringify(this.shownCharts.map(chart_data => chart_data.chart_name)));
    },

    async getSensorData() {
      const shipid = this.$store.state.auth.user.ship;

      await SensordataService.getByShipId(shipid)
          .then(response => {
            this.sensordata = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },

    changeChartType(newChartType) {
      if (this.selectedChart.chart_type === newChartType) {
        alert("You already have this chart type selected");
        return;
      }

      this.selectedChart.chart_type = newChartType;

      this.setChartPositions();
      this.$router.go();
    },

    createCharts() {
      for (let chart_data of this.shownCharts) {
        let chart = new SetupChart(JSON.stringify(this.sensordata), chart_data.sensor_name, chart_data.sensor_group, chart_data.chart_type, chart_data.chart_name);
        let canvas = chart.createChart();

        document.querySelector(`#${chart_data.chart_name}`).appendChild(canvas);
      }
    }
  }
}
</script>


<style scoped>
.edit-dashboard {
  margin-left: 18px;
}

.material-icons {
  padding: 15px;
  float: right;
}

.material-icons:hover {
  cursor: pointer;
}

.hidden {
  display:none;
}

.position-number {
  opacity: 50%;
  color: white;
  font-size: 50px;

  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.show-context {
  display: contents;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {
  background-color: rgba(0,0,0,0.2);
  cursor: pointer;
}

.dropdown:hover .dropdown-content {display: block;}
</style>
