<template>
  <el-card shadow="always" class="el-card">
    <h1>Trip statistics</h1>

    <p>There is currently no trip going on</p>
    <p>The current trip is from Paris to Amsterdam</p>


  </el-card>
</template>

<script>
export default {
  name: "TripStatistics"
}
</script>

<style scoped>
.el-card {
  background: #002C48;
  border: none;
  color: #E0E1DD;
  text-align: center;
  border-radius: 20px;
}
</style>
