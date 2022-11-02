<template>
  <el-card shadow="always" class="el-card">
    <h1>Sea conditions</h1>

    <div class="content">
      <el-row class="sections">
        <el-card class="section">
          <h2 class="condition-title">Battery pack 1 level</h2>
          <p class="condition-value">88%</p>
        </el-card>
        <el-card class="section">
          <h2 class="condition-title">Battery pack 2 level</h2>
          <p class="condition-value">67%</p>
        </el-card>
        <el-card class="section">
          <h2 class="condition-title">Battery pack 1 temperature</h2>
          <p class="condition-value">45°C</p>
        </el-card>
        <el-card class="section">
          <h2 class="condition-title">Battery pack 2 temperature</h2>
          <p class="condition-value">60°C</p>
        </el-card>
      </el-row>
    </div>

    <br><br>
  </el-card>
</template>

<script>
export default {
  name: "BatteryInfo"
}
</script>

<style scoped>
.sections {
  line-height: 12px;
  display: flex;
  align-items: center;
}

.el-card {
  background: #002C48;
  border: none;
  color: #E0E1DD;
  text-align: center;
  border-radius: 20px;
}

.section {
  margin: 10px;
  box-shadow: 3px 4px 12px 0px rgba(0,0,0,0.5);
  -webkit-box-shadow: 3px 4px 12px 0px rgba(0,0,0,0.5);
  -moz-box-shadow: 3px 4px 12px 0px rgba(0,0,0,0.5);
}

.condition-title {
  font-size: 1.5rem;
}

.condition-value {
  padding-top: 10px;
  font-size: 2rem;
  font-weight: 600;
  color: #1CD0FF;
}
</style>
