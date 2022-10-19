<template>
<!--  <HeaderComp></HeaderComp>-->
  <NavBar></NavBar>
  <router-view></router-view>
</template>
<script>

import NavBar from "@/components/NavBar";
// import HeaderComp from "@/components/Header";

export default {
  name: 'App',
  components: {
    NavBar,
    // HeaderComp,
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
