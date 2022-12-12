<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <div v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100">
    <button @click="this.switchEditing();" class="edit-dashboard text-white bg-blue-light-card focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text">Edit dashboard</button>
    <button :class="{hidden: !isEditing}" class="edit-dashboard text-white bg-blue-light-card focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text">Toevoegen</button>

    <div class="grid grid-cols-1 p-4 space-y-8 lg:gap-8 lg:space-y-0 lg:grid-cols-4 comp-wrapper">
      <div class="show-context" v-for="(component, index) in componentsList" :key="index">
        <div class="col-span-2 shadow-md bg-blue-card-blue rounded-md droppable"
             draggable="false" @dragstart="dmc.onDragStart($event)"
             @drop.prevent="dmc.dropHandler($event)" @dragover.prevent="dmc.dragHandler($event)">
          <td class="material-icons py-4 px-6" :class="{hidden: !isEditing}">edit</td>
          <div class="flex items-center justify-between p-4">
            <h4 class="text-xl font-semibold text-white-text">{{component.name}}</h4>
          </div>
          <div class="relative p-4 h-72">
            <div class="position-number" :class="{hidden: !isEditing}"></div>
            <component :is="component"  />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import EngineUsage from "@/components/ship/charts-power-usage/EngineUsage";
import BatteryInfoLine from "@/components/ship/charts-power-usage/BatteryInfoLine";
import BatteryInfoCards from "@/components/ship/charts-power-usage/BatteryInfoCards";
import {DashboardMoveComponents} from "@/assets/js/DashboardMoveComponents";

export default {
  name: "PowerUsage",
  components: {
    BatteryInfoLine,
    EngineUsage,
    BatteryInfoCards,
  },

  data() {
    return {
      isEditing: false,
      dmc: null,
      componentsList: [BatteryInfoLine, EngineUsage]
    }
  },

  mounted() {
    this.dmc = new DashboardMoveComponents(null);
    this.dmc.updatePosition()
  },

  methods: {
    switchEditing() {
      this.isEditing = !this.isEditing;

      document.querySelectorAll(".droppable").forEach(component => {
        component.draggable = !component.draggable;
      })
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

.edit-icons-holder {
  margin-left: auto;
  margin-right: 0;
}

.hidden {
  display:none;
}

.hide-top-cols {
  height: 0;
  z-index: 1;
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
</style>
