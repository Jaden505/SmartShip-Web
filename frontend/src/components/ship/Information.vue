<template>
  <div class="main-container">
    <div class="container-up">
      <div class="row">
        <div class="col">
          <WaterSupply/>
        </div>
        <div class="col">
          <EngineInformation/>
        </div>
        <div class="col">
          <TripStatistics/>
        </div>
      </div>
    </div>
    <div class="container-bottom">
      <div class="row">
        <div class="col">
          <ShipEvents/>
        </div>
        <div class="col">
          <SeaConditions/>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import SeaConditions from "./charts-information/SeaConditions";
import TripStatistics from "./charts-information/TripStatistics";
import EngineInformation from "./charts-information/WaterSupply";
import WaterSupply from "./charts-information/EngineInformation";
import ShipEvents from "./charts-information/ShipEvents";

export default {
  name: "ShipInformation",
  components: {
    ShipEvents,
    WaterSupply,
    EngineInformation,
    SeaConditions,
    TripStatistics
  }
}
</script>

<style scoped>
.main-container {
  background-color: #00111C;
}
</style>
