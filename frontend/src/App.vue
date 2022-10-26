<template>
  <router-view></router-view>
</template>

<script>

export default {
  name: 'App',
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

router-view {
  overflow: scroll;
}
</style>

