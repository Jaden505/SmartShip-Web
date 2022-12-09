<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <div v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100">
    <button @click="this.isEditing = !this.isEditing" class="edit-dashboard text-white bg-blue-light-card focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text">Edit dashboard</button>

    <div class="grid grid-cols-1 p-4 space-y-8 lg:gap-8 lg:space-y-0 lg:grid-cols-4">

      <div class="col-span-2 shadow-md bg-blue-card-blue rounded-md" draggable="true" @dragstart="dmc.onDragStart($event, this)"
           v-on:dragend="dmc.dropHandler($event, this)" v-on:dragover="dmc.dragHandler($event)">
        <td class="material-icons py-4 px-6" :class="{hidden: !isEditing}">fullscreen_exit</td>
        <td class="material-icons py-4 px-6" :class="{hidden: !isEditing}">edit</td>
        <div class="flex items-center justify-between p-4">
          <h4 class="text-xl font-semibold text-white-text">Startboard Engine Usage</h4>
        </div>
        <div class="relative p-4 h-72">
          <div class="position-number" :class="{hidden: !isEditing}">1</div>
          <EngineUsage/>
        </div>
      </div>

      <div class="col-span-2 bg-blue-card-blue shadow-md rounded-md" draggable="true" @dragstart="dmc.onDragStart($event, this)"
           v-on:dragend="dmc.dropHandler($event, this)" v-on:dragover="dmc.dragHandler($event)">
        <td class="material-icons py-4 px-6" :class="{hidden: !isEditing}">fullscreen_exit</td>
        <td class="material-icons py-4 px-6" :class="{hidden: !isEditing}">edit</td>
        <div class="flex items-center justify-between p-4">
          <h4 class="text-xl font-semibold text-white-text">Battery Pack Levels</h4>
        </div>
        <div class="relative p-4 h-72">
          <div class="position-number" :class="{hidden: !isEditing}">2</div>
          <BatteryInfoLine/>
        </div>
      </div>
    </div>

    <div class="grid grid-cols-1 p-4 space-y-8 lg:gap-8 lg:space-y-0 lg:grid-cols-2">
      <div class="grid grid-cols-2 gap-8 shadow-md rounded-md">
        <div class="hide-top-cols" :class="{hidden: !isEditing}"></div>
        <div class="hide-top-cols edit-icons-holder" :class="{hidden: !isEditing}">
          <td class="material-icons py-4 px-6" :class="{hidden: !isEditing}">fullscreen_exit</td>
          <td class="material-icons py-4 px-6" :class="{hidden: !isEditing}">edit</td>
        </div>
        <div class="position-number" :class="{hidden: !isEditing}">3</div>
        <BatteryInfoCards/>
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
      dmc: null
    }
  },

  mounted() {
    this.dmc = new DashboardMoveComponents(null);
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
  left: 50%;
  top: 50%;
}
</style>
