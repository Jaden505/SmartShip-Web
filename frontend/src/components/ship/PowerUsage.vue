<template>
  <div class="conatainer-mine">
    <el-row :gutter="20">
      <el-col :span="12"><EngineUsage/></el-col>
      <el-col :span="12"><BatteryInfo/></el-col>
    </el-row>
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
