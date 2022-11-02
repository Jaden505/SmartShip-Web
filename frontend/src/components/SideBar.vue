<template>
  <el-row class="tac">
    <el-col :span="24">
      <el-menu
          class="el-menu-vertical"
          background-color="none"
      >
        <el-menu-item index="1">
          <span class="link"><router-link class="link" to="/info">Ship Information</router-link></span>
        </el-menu-item>
        <el-menu-item index="2">
          <span class="link"><router-link class="link" to="/ship-overview">Ship Table</router-link></span>
        </el-menu-item>
        <el-menu-item index="3">
          <span class="link"><router-link class="link" to="/power-usage">Power Usage</router-link></span>
        </el-menu-item>
      </el-menu>
    </el-col>
  </el-row>
</template>

<script>
export default {
  name: "SideBar"
}
</script>

<style scoped>
.el-menu-vertical {
  border-right: none;
  padding: 0;
}

.link {
  font-size: 1.5rem;
  text-decoration: none;
  color: #dddddd;
}
</style>