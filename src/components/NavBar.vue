<template>
  <div class="sidenav">
    <a><router-link to="/"><img width="250" src="../assets/img/SmartShipLogo.jpeg" /></router-link></a>
    <a><router-link to="/ships">Power Usage</router-link></a>
    <a><router-link to="/ships">Ship information</router-link></a>
    <a><router-link to="/ships">Rating</router-link></a>

    <div class="bottomnav">
      <a>Sign out</a>
    </div>
  </div>
</template>

<script>
export default {
  name: "NavBar"
}
</script>

<style scoped>
.sidenav {
  height: 100%;
  width: 300px;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #111;
  overflow-x: hidden;
  padding-top: 20px;
}

.sidenav a {
  padding: 6px 8px 6px 16px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
}

.sidenav a:hover {
  color: #f1f1f1;
}
.bottomnav {
  position: absolute;
  bottom: 50px;
  text-align: center;
}
</style>