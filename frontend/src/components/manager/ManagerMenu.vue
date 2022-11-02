<template>

  <router-link to="">
    <div class="side-item">
      <h2>All operators</h2>
    </div>
  </router-link>
  <router-link to="">
    <div class="side-item">
      <h2>All operators without ship</h2>
    </div>
  </router-link>
  <router-link to="">
    <div class="side-item">
      <h2>All ships</h2>
    </div>
  </router-link>

</template>

<script>
export default {
  name: "ManagerMenu"
}
</script>

<style scoped>
  .side-item{
    background: rgb(138,243,254);
    background: radial-gradient(circle, rgba(138,243,254,1) 28%, rgba(135,230,255,1) 54%, rgba(107,231,254,1) 92%);
    text-align: center;
    width: 90%;
    margin: 0 auto 10% auto;
    padding: 5%;
  }

  a{
    text-decoration: none;
    color: black;
  }

</style>