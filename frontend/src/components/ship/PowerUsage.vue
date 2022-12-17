<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <div v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100">
    <button @click="this.switchEditing();"
            class="edit-dashboard text-white bg-blue-light-card focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text">Edit dashboard</button>

    <div class="dropdown">
      <button :class="{hidden: !isEditing}"
              class="edit-dashboard text-white bg-blue-light-card focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text drop-btn">Add</button>
      <div class="dropdown-content">
        <a v-for="(component, index) in addableComponents" :key="index" @click="switchDisplayComponent(component)">{{component.name}}</a>
      </div>
    </div>
    <button :class="{hidden: !isEditing}" @click="setComponents()"
            class="edit-dashboard text-white bg-blue-light-card focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text drop-btn">Save</button>

    <div class="grid grid-cols-1 p-4 space-y-8 lg:gap-8 lg:space-y-0 lg:grid-cols-4 comp-wrapper">
      <div class="show-context" v-for="(component, index) in componentsList" :key="index">
        <div class="col-span-2 shadow-md bg-blue-card-blue rounded-md droppable"
             :draggable="isEditing" @dragstart="dmc.onDragStart($event, component)"
             @drop.prevent="this.componentsList = dmc.dropHandler($event, component, componentsList)" @dragover.prevent>
          <td class="material-icons py-4 px-6" :class="{hidden: !isEditing}" @click="switchDisplayComponent(component)">close</td>
          <td class="material-icons py-4 px-6" :class="{hidden: !isEditing}">edit</td>
          <div class="flex items-center justify-between p-4">
            <h4 class="text-xl font-semibold text-white-text">{{component.name}}</h4>
          </div>
          <div class="relative p-4 h-72">
            <div class="position-number" :class="{hidden: !isEditing}"></div>
            <component :is="component" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import EngineUsage from "@/components/ship/charts-power-usage/EngineUsage";
import BatteryInfoLine from "@/components/ship/charts-power-usage/BatteryInfoLine";
import BatteryInfo1 from "@/components/ship/charts-power-usage/BatteryInfo1";
import {DashboardMoveComponents} from "@/assets/js/DashboardMoveComponents";

export default {
  name: "PowerUsage",
  components: {
    BatteryInfoLine,
    EngineUsage,
    BatteryInfo1,
  },

  data() {
    return {
      isEditing: false,
      dmc: null,
      componentsList: [],
      addableComponents: [BatteryInfoLine, EngineUsage, BatteryInfo1]
    }
  },

  mounted() {
    this.dmc = new DashboardMoveComponents(null);

    // Get components from local storage
    if (localStorage.components) {
      let component_names = this.addableComponents.map(component => component.name);

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

    setComponents() {
      // Save components names in local storage
      localStorage.setItem('components', JSON.stringify(this.componentsList.map(component => component.name)));
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
  background-color: #0d6efd;
  background-image:
      linear-gradient(
          to right,
          #0d6efd, deepskyblue
      );
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
  color: lightgrey;
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
