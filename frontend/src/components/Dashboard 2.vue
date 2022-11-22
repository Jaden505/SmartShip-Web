<template>
  <HeaDer/>
  <el-main class="main">
    <el-row class="row" gutter="10">
      <el-col :span="4" class="column-1">
        <div class="grid-content ep-bg-purple">
          <SideBar/>
        </div>
      </el-col>
      <el-col :span="20" class="column-2">
        <div class="grid-content ep-bg-purple">
          <router-view></router-view>
        </div>
      </el-col>
    </el-row>
  </el-main>
</template>

<script>
import SideBar from "@/components/SideBar";
import HeaDer from "@/components/Header";
export default {
  name: "DashBoard",
  components: {
    HeaDer,
    SideBar
  }
}
</script>

<style scoped>

</style>