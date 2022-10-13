<template>
  <el-main class="main">
    <el-row class="row">
      <el-col :span="12" class="column">
        <div class="grid-content ep-bg-purple">
          Column 1
        </div>
      </el-col>
      <el-col :span="12" class="column">
        <div class="grid-content ep-bg-purple">
          Column 2
        </div>
      </el-col>
    </el-row>
  </el-main>
</template>

<script>
export default {
  name: "Login-Screen"
}
</script>

<style scoped>
.main {
  height: 100%;
  padding-bottom: 12vh;
}

.row {
  height: 100%;
}

.column {
  height: 100%;
}

.grid-content {
  color: #dddddd;
}


</style>