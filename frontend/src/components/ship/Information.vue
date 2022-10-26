<template>
  <div class="container-mine">
    <el-row :gutter="20">
      <el-col :span="8"><EngineInformation/></el-col>
      <el-col :span="8"><WaterSupply/></el-col>
      <el-col :span="8"><TripStatistics/></el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="14"><SeaConditions/></el-col>
      <el-col :span="10"><ShipEvents/></el-col>
    </el-row>
  </div>
</template>

<script>
import SeaConditions from "./charts-information/SeaConditions";
import TripStatistics from "./charts-information/TripStatistics";
import WaterSupply from "./charts-information/WaterSupply";
import EngineInformation from "./charts-information/EngineInformation";
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
</style>
