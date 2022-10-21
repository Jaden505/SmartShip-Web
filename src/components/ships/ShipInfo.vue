<template>
  <SeaConditions />
  <TripStatistics />
  <WaterSupply />
  <EngineInformation />
</template>

<script>
import SeaConditions from "@/components/charts/SeaConditions";
import TripStatistics from "@/components/charts/TripStatistics";
import EngineInformation from "@/components/charts/WaterSupply";
import WaterSupply from "@/components/charts/EngineInformation";

export default {
  name: "ShipInfo",
  components: {
    WaterSupply,
    EngineInformation,
    SeaConditions,
    TripStatistics
  }
}
</script>

<style scoped>

</style>
