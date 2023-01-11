<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <ChooseChartType :clickedEditComponentIndex="clickedEditComponentIndex" @clicked="changeChartType" />

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
        <a v-for="(component, index) in addableComponents" :key="index" @click="switchDisplayComponent(component)">{{component.name}}</a>
      </div>
    </div>

    <button :class="{hidden: !isEditing}" @click="setComponentsPosition(); this.$router.go()"
            class="edit-dashboard text-white bg-blue-regular font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text drop-btn">Save</button>

    <!-- Loop component widgets -->
    <div class="grid grid-cols-1 p-4 space-y-8 lg:gap-8 lg:space-y-0 lg:grid-cols-4 comp-wrapper">
      <div class="show-context" v-for="(component_data, index) in componentsList" :key="index">

        <!-- Allows the dragging and dropping of the component -->
        <div class="col-span-2 shadow-md rounded-md droppable"
             :draggable="isEditing" @dragstart="dmc.onDragStart($event, component_data)"
             @drop.prevent="this.componentsList = dmc.dropHandler($event, component_data, componentsList)" @dragover.prevent>

          <div class="bg-blue-regular text-black-text dark:text-white-text">
            <div class="material-icons py-4 px-6" :class="{hidden: !isEditing}" @click="switchDisplayComponent(component_data['component'])">close</div>
            <div class="material-icons py-4 px-6" :class="{hidden: !isEditing}" @click="ischoosingChart = !ischoosingChart">edit</div>
          </div>
          <div class="flex items-center justify-between p-4">
            <h4 class="text-xl font-semibold text-black-text dark:text-white-text">{{component_data['component'].name}}</h4>
          </div>

          <!-- The component is called here -->
          <div class="relative p-4 h-72">
            <div class="position-number" :class="{hidden: !isEditing}"></div>
            <component
                :is="component_data['component']" :sensor_data="JSON.stringify(sensordata)"
                :sensor_name="component_data['sensor_name']" :sensor_group="component_data['sensor_group']"
                :chart_name="component_data['chart_name']" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

// Chart imports
import BarChart from "@/components/charts/BarChart";
import LineChart from "@/components/charts/LineChart";

import {DashboardMoveComponents} from "@/assets/js/DashboardMoveComponents";
import SensordataService from "@/services/sensordata.service";
import ChooseChartType from "@/components/elements/ChooseChartType";

export default {
  name: "PowerUsage",
  components: {
    BarChart,
    LineChart,
    ChooseChartType
  },

  data() {
    return {
      isEditing: false,
      ischoosingChart: false,
      clickedEditComponentIndex: null,
      sensordata: null,
      dmc: null,
      componentsList: [],
      addableComponents: [{"component": BarChart, "sensor_name": "Percentage Left", "sensor_group": "Battery", "chart_name": "Batteries charge"},
        {"component": LineChart, "sensor_name": "Engine 1 Temperature", "sensor_group": "Motor", "chart_name": "Engine Usage"}]
    }
  },

  mounted() {
    this.getSensorData();

    this.getComponentsPosition()

    // Initiate the DashboardMoveComponents class
    this.dmc = new DashboardMoveComponents();
  },

  methods: {
    switchEditing() {
      this.isEditing = !this.isEditing;

      document.querySelectorAll(".droppable").forEach(component => {
        component.draggable = !component.draggable;
      })
    },

    switchDisplayComponent(component) {
      // Display
      if (this.addableComponents.includes(component)) {
        this.componentsList.push(component);
        this.addableComponents.splice(this.addableComponents.indexOf(component), 1);
      }
      // Hide
      else if (this.componentsList.includes(component)) {
        this.addableComponents.push(component);
        this.componentsList.splice(this.componentsList.indexOf(component), 1);
      }
    },

    getComponentsPosition() {
      // Get components from local storage
      if (localStorage.components) {
        let component_names = this.addableComponents.map(component_data => component_data.component.name)

        for (let component of JSON.parse(localStorage.components)) {
          // Check if component was saved in local storage
          if (component_names.includes(component)) {
            this.switchDisplayComponent(this.addableComponents[component_names.indexOf(component)]);
            component_names.splice(component_names.indexOf(component), 1);
          }
        }
      }
      else {
        // Display all components by default
        this.componentsList = this.addableComponents;
        this.addableComponents = [];
      }
    },

    setComponentsPosition() {
      // Save components names in local storage
      localStorage.setItem('components', JSON.stringify(this.componentsList.map(component_data => component_data.component.name)));
    },

    getSensorData() {
      const shipid = this.$store.state.auth.user.ship;

      SensordataService.getByShipId(shipid)
          .then(response => {
            this.sensordata = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    },

    changeChartType(newChartType) {
      switch(newChartType) {
        case "bar_chart":
          this.componentsList[index].component = BarChart;
          break;
        case "line_chart":
          this.componentsList[index].component = LineChart;
          break;
        // case "pie_chart":
        //   this.componentsList[index].component = PieChart;
        //   break;
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
