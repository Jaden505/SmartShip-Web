<template>
  <div v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100">
    <div class="grid grid-cols-1 p-4 space-y-8 lg:gap-8 lg:space-y-0 lg:grid-cols-4">
      <div class="col-span-2 shadow-md bg-blue-card-blue rounded-md">
        <div class="flex items-center justify-between p-4">
          <h4 class="text-xl font-semibold text-white-text">Startboard Engine Usage</h4>
        </div>
        <div class="relative p-4 h-72">
          <EngineUsage/>
        </div>
      </div>

      <div class="col-span-2 bg-blue-card-blue shadow-md rounded-md">
        <div class="flex items-center justify-between p-4">
          <h4 class="text-xl font-semibold text-white-text">Battery Pack Levels</h4>
        </div>
        <div class="relative p-4 h-72">
          <BatteryInfo/>
        </div>
      </div>
    </div>

    <div class="grid grid-cols-1 p-4 space-y-8 lg:gap-8 lg:space-y-0 lg:grid-cols-2">
      <!-- CARD -->
<!--      <div class="bg-blue-card-blue shadow-md rounded-md">-->
<!--        &lt;!&ndash; CARD HEADER &ndash;&gt;-->
<!--        <div class="flex items-center justify-between p-4">-->
<!--          <h4 class="text-xl font-semibold text-white-text">Doughnut Chart</h4>-->
<!--        </div>-->
<!--        &lt;!&ndash; CHART &ndash;&gt;-->
<!--        <div class="relative p-4 h-72">-->

<!--        </div>-->
<!--      </div>-->
      <div class="grid grid-cols-2 gap-8">
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

  }
}
</script>

<style scoped>
</style>
