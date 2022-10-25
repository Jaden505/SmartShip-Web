<template>
  <div class="main-container">
    <div class="container-up">
      <div class="row">
        <div class="col">
          <EngineUsage/>
        </div>
      </div>
    </div>
    <div class="container-bottom">
      <div class="row">
        <div class="col">
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import EngineUsage from "./charts-power-usage/EngineUsage";

export default {
  name: "PowerUsage",
  components: {
    EngineUsage
  }
}
</script>

<style scoped>
.main-container {
  background-color: #00111C;
}
</style>
