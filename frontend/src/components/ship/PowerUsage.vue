<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <div v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100">
    <button @click="this.isEditing = !this.isEditing" class="edit-dashboard text-white bg-blue-light-card focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text">Edit dashboard</button>

    <div class="grid grid-cols-1 p-4 space-y-8 lg:gap-8 lg:space-y-0 lg:grid-cols-4">
      <div class="col-span-2 shadow-md bg-blue-card-blue rounded-md">
        <td class="material-icons py-4 px-6" :class="{hidden: !isEditing}">fullscreen_exit</td>
        <td class="material-icons py-4 px-6" :class="{hidden: !isEditing}">edit</td>
        <div class="flex items-center justify-between p-4">
          <h4 class="text-xl font-semibold text-white-text">Startboard Engine Usage</h4>
        </div>
        <div class="relative p-4 h-72">
          <EngineUsage/>
        </div>
      </div>

      <div class="col-span-2 bg-blue-card-blue shadow-md rounded-md">
        <td class="material-icons py-4 px-6" :class="{hidden: !isEditing}">fullscreen_exit</td>
        <td class="material-icons py-4 px-6" :class="{hidden: !isEditing}">edit</td>
        <div class="flex items-center justify-between p-4">
            <h4 class="text-xl font-semibold text-white-text">Battery Pack Levels</h4>
          </div>
          <div class="relative p-4 h-72">
            <BatteryInfo/>
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
        <div class="items-center text-center p-4 shadow-md bg-white rounded-md bg-blue-card-blue">
          <div>
            <h6 class="text-md font-semibold leading-none tracking-wider text-white-text pb-2">
              Battery Pack 1 Level
            </h6>
            <span class="text-5xl font-semibold text-white-text">95</span>
          </div>
        </div>

        <div class="items-center text-center shadow-md p-4 bg-white rounded-md bg-blue-card-blue">
          <div>
            <h6 class="text-md font-semibold leading-none tracking-wider text-white-text pb-2">
              Battery Pack 1 Temperature
            </h6>
            <span class="text-5xl font-semibold text-white-text">56.8</span>
          </div>
        </div>

        <div class="items-center text-center p-4 bg-white shadow-md rounded-md bg-blue-card-blue">
          <div>
            <h6 class="text-md font-semibold leading-none tracking-wider text-white-text pb-2">
              Battery Pack 2 Level
            </h6>
            <span class="text-5xl font-bold text-white-text">84</span>
          </div>
        </div>

        <div class="items-center text-center p-4 shadow-md bg-white rounded-md bg-blue-card-blue">
          <div>
            <h6 class="text-md font-semibold leading-none tracking-wider text-white-text pb-2">
              Battery Pack 2 Temperature
            </h6>
            <span class="text-5xl font-semibold text-white-text">58.3</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import EngineUsage from "@/components/ship/charts-power-usage/EngineUsage";
import BatteryInfo from "@/components/ship/charts-power-usage/BatteryInfo";
export default {
  name: "PowerUsage",
  components: {
    BatteryInfo,
    EngineUsage
  },

  data() {
    return {
      isEditing: false
    }
  },
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
</style>
