<template>
<div class = "flex-container">
  <div class="flex-box">
    Box 1
  </div>

  <div class="flex-box">
    Box 2
  </div>

  <div class="flex-box">
    Box 3
  </div>

  <div class="flex-box">
    Box 4
  </div>
</div>
</template>

<script>
export default {
  name: "NotificationsOverview"
}
</script>

<style scoped>
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
.flex-container{
  width: 100%;
  height: auto;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  background-color: #002C48;
  justify-content: center;
}
.flex-box{
  width: 200px;
  height: 200px;
  background-color: #002C60;
  color: #0061FF;
  font-size: 25px;
  text-align: center;
  line-height: 200px;
  border-radius: 20px;
  margin: 20px;
}

</style>