<template>

  <router-link to="/operators">
    <div class="side-item">
      <h2>Operators</h2>
    </div>
  </router-link>
  <router-link to="/ships">
    <div class="side-item">
      <h2>Ships</h2>
    </div>
  </router-link>
  <router-link to="/operators-without-ship">
    <div class="side-item">
      <h2>Operators without ship</h2>
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
    background-color: #163b7a;
    text-align: center;
    width: 90%;
    margin: 0 auto 10% auto;
    padding: 5%;
  }

  a{
    text-decoration: none;
    color: white;
  }

</style>