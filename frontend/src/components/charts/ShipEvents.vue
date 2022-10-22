<template>
  <div class="content">
    <h1>Ship Events</h1>
    <div class="container">
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
  </div>
</template>

<script>
export default {
  name: "ShipEvents",
  data() {
    return {
      ship: require('../../assets/img/ship.png')
    }
  }
}
</script>

<style scoped>
.content {
  background-color: #163b7a;
  color: white;
  width: 700px;
}
.container{
  display: flex;
  justify-content: space-around;
}

li{
  margin-top:20px;
  color: #dddddd;
}

#shipImg {
  width: 200px;
  height: 200px;
}
</style>
<!--<img v-bind:src="logo">
logo: require('../assets/images/blue-scooter.png'),-->
