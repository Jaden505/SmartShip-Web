<template>
  <div v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100">
    <div class="grid grid-cols-1 px-4 md:pr-5 space-y-8 lg:gap-8 lg:space-y-0 lg:grid-cols-3">
      <!-- CARD -->
      <div class="bg-blue-card-blue rounded-md">
        <!-- CARD HEADER -->
        <div class="flex items-center justify-between p-4">
          <h4 class="text-lg font-semibold text-white-text">Engine Information</h4>
        </div>
        <!-- CHART -->
        <div class="relative p-4 h-72">

        </div>
      </div>

      <!-- CARD -->
      <div class="col-span-2 bg-blue-card-blue rounded-md">
        <!-- CARD HEADER -->
        <div class="flex items-center justify-between p-4">
          <h4 class="text-lg font-semibold text-white-text">Water Supply</h4>
        </div>
        <!-- CHART -->
        <div class="flex relative p-4 h-72">
          <div class="w-1/2">
            <WaterSupply/>
          </div>
          <div class="w-1/2 grid grid-cols-1 gap-8 p-4">
            <div class="flex items-center justify-between p-4 rounded-md bg-blue-card-blue drop-shadow-lg">
              <div>
                <h2 class="text-xl font-semibold leading-none tracking-wider text-white-text">
                  Current Consumption
                </h2>
                <h3 class="text-3xl font-semibold mt-2">50,021</h3>
              </div>
            </div>
            <div class="flex items-center justify-between bg-blue-card-blue drop-shadow-lg p-4 rounded-md">
              <div>
                <h2 class="text-xl font-semibold leading-none tracking-wider text-white-text">
                  Current Consumption
                </h2>
                <h3 class="text-3xl font-semibold mt-2">50,021</h3>
              </div>
            </div>
          </div>

        </div>
      </div>
    </div>
    </div>
</template>

<script>
import WaterSupply from "@/components/ship/charts-information/WaterSupply";
export default {
    name: "ShipsTable",
  components: {WaterSupply}
}
</script>

<style scoped>
</style>
