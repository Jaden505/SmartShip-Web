<template>
  <SeaConditions />
  <TripStatistics />
</template>

<script>
import SeaConditions from "@/components/charts/SeaConditions";
import TripStatistics from "@/components/charts/TripStatistics";

export default {
  name: "ShipInfo",
  components: {
    SeaConditions,
    TripStatistics
  }
}
</script>

<style scoped>

</style>