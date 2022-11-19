<template>
  <div v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100" class="grid grid-cols-1 px-4 md:pr-5 space-y-8 lg:gap-8 lg:space-y-0 lg:grid-cols-3">
    <!-- CARD -->
    <div class="col-span-2 bg-blue-card-blue rounded-md">
      <!-- CARD HEADER -->
      <div class="flex items-center justify-between p-4">
        <h4 class="text-lg font-semibold text-white-text">Bar Chart</h4>
      </div>
      <!-- CHART -->
      <div class="relative p-4 h-72">

      </div>
    </div>

    <!-- CARD -->
    <div class="bg-blue-card-blue rounded-md">
      <!-- CARD HEADER -->
      <div class="flex items-center justify-between p-4">
        <h4 class="text-lg font-semibold text-white-text">Doughnut Chart</h4>
      </div>
      <!-- CHART -->
      <div class="relative p-4 h-72">

      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: "PowerUsage",
  components: {

  }
}
</script>

<style scoped>
</style>
