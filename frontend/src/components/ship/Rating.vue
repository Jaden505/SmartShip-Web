<template>
  <div v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100" class="grid grid-cols-1 px-4 md:pr-5 space-y-8 lg:gap-8 lg:space-y-0 lg:grid-cols-3">
  </div>
</template>

<script>

export default {
  name: "ShipInformation"
}
</script>

<style scoped>
</style>
