<template>
  <div class="main-container">
    <div class="container-up">
      <WaterSupply />
      <EngineInformation />
      <TripStatistics />
    </div>
    <div class="container-bottom">
      <ShipEvents />
      <SeaConditions />
    </div>

  </div>
</template>

<script>
import SeaConditions from "./charts/SeaConditions";
import TripStatistics from "./charts/TripStatistics";
import EngineInformation from "./charts/WaterSupply";
import WaterSupply from "./charts/EngineInformation";
import ShipEvents from "./charts/ShipEvents";

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
.main-container{
  background-color: #00111C;
}
.container-up{
  display: flex;
  margin-left: 15%;
  justify-content: space-between;
}

.container-bottom{
  display:flex;
  margin-top: 20px;
  margin-bottom: 20px;
  margin-left: 15%;
  justify-content: space-evenly;
}

</style>
