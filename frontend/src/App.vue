x<template>
  <NavBar></NavBar>
  <router-view></router-view>
</template>

<script>

import NavBar from "@/components/NavBar";

export default {
  name: 'App',
  components: {
    NavBar
  }
}
</script>

<style>

* {
  margin: 0;
  padding: 0;
}
html {
  height: 100%;
}

body {
  min-height: 100%;
}

#app {
  height: 100vh;
  overflow: hidden;
}
</style>

