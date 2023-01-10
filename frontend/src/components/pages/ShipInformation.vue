<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <div v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100">
    <button @click="this.switchEditing();"
            class="edit-dashboard text-white bg-blue-regular font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text">Edit dashboard</button>

    <div class="dropdown">
      <button :class="{hidden: !isEditing}"
              class="edit-dashboard text-white bg-blue-regular font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text drop-btn">Add</button>
      <div class="dropdown-content text-black-text dark:text-white-text">
        <a v-for="(component, index) in addableComponents" :key="index" @click="switchDisplayComponent(component)">{{component.name}}</a>
      </div>
    </div>
    <button :class="{hidden: !isEditing}" @click="setComponents(); this.$router.go()"
            class="edit-dashboard text-white bg-blue-regular font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text drop-btn">Save</button>

    <div class="grid grid-cols-1 p-4 space-y-8 lg:gap-8 lg:space-y-0 lg:grid-cols-4 comp-wrapper">
      <div class="show-context" v-for="(component, index) in componentsList" :key="index">
        <div class="relative col-span-2 bg-purple-basic dark:bg-black-light shadow-md rounded-md droppable"
             :draggable="isEditing" @dragstart="dmc.onDragStart($event, component)"
             @drop.prevent="this.componentsList = dmc.dropHandler($event, component, componentsList)" @dragover.prevent>
          <div class="absolute right-0 text-black-text dark:text-white-text">
            <font-awesome-icon icon="fa-solid fa-xmark" class="py-5 px-6" :class="{hidden: !isEditing}" @click="switchDisplayComponent(component)">close</font-awesome-icon>
            <font-awesome-icon icon="fa-solid fa-pen-to-square" class="py-5 px-6" :class="{hidden: !isEditing}">edit</font-awesome-icon>
          </div>
          <div class="flex items-center justify-between p-4">
            <h4 class="text-xl font-semibold text-black-text dark:text-white-text">{{component.name}}</h4>
          </div>
          <div class="relative p-4 h-72">
            <div class="position-number" :class="{hidden: !isEditing}"></div>
            <component :is="component" :sensordata="JSON.stringify(sensordata)" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import WaterSupply from "@/components/widgets/shipinfo/WaterSupply";
import Map from "@/components/ship/Map";
import SeaConditions from "@/components/widgets/shipinfo/SeaConditions";
import EngineInformation from "@/components/widgets/shipinfo/EngineInformation";

import {DashboardMoveComponents} from "@/assets/js/DashboardMoveComponents";
import SensordataService from "@/services/sensordata.service";

export default {
    name: "ShipInformation",
  components: {
    Map,
    WaterSupply,
    SeaConditions,
    EngineInformation
  },

  data() {
    return {
      isEditing: false,
      sensordata: null,
      dmc: null,
      componentsList: [],
      addableComponents: [WaterSupply, Map, SeaConditions, EngineInformation]
    }
  },

  mounted() {
    this.getSensorData();

    this.dmc = new DashboardMoveComponents(null);

    // Get components from local storage
    if (localStorage.Components_Ship_Information) {
      let component_names = this.addableComponents.map(component => component.name);

      for (let component of JSON.parse(localStorage.Components_Ship_Information)) {
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
      localStorage.setItem('Components_Ship_Information', JSON.stringify(this.componentsList.map(component => component.name)));
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
