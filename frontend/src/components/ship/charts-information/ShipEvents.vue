<template>
  <el-card shadow="always" class="el-card">
    <h1>Ship Events</h1>

    <div class="content">
      <ul>
        <li>
          Not working...
        </li>
        <li>
          Not working...
        </li>
        <li>
          Not working...
        </li>
      </ul>
      <img id="shipImg" v-bind:src="ship">
    </div>
  </el-card >
</template>

<script>
export default {
  name: "ShipEvents",
  data() {
    return {
      ship: require('../../../assets/img/ship-icon.png')
    }
  }
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

#shipImg {
  width: 200px;
  height: 200px;
}
</style>
<!--<img v-bind:src="logo">
logo: require('../assets/images/blue-scooter.png'),-->
