<template>
  <div class="main-container">
    <div class="container-up">
      <div class="row">
        <div class="col">
          <EngineUsage/>
        </div>
        <div class="col">
          <BatteryInfo/>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import EngineUsage from "./charts-power-usage/EngineUsage";
import BatteryInfo from "./charts-power-usage/BatteryInfo";

export default {
  name: "PowerUsage",
  components: {
    EngineUsage,
    BatteryInfo
  }
}
</script>

<style scoped>
</style>
