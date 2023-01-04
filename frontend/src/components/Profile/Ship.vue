<template>

  <div class="content-container">
    <div class="content">

      <h1>Ship information</h1>
      <hr>

      <div class="personal-info">
        <div class="personal-left">
          <div class="personal-record">
            <label>Ship Id</label>
            <p>3010</p>
          </div>
          <div class="personal-record">
            <label>Ship status</label>
            <p>Active</p>
          </div>
        </div>
        <div class="personal-right">
          <div class="personal-record">
            <label>Ship name</label>
            <p>Titanic</p>
          </div>
        </div>
      </div><!--/personal-info-->

      <h1>Ship location</h1>
      <hr>

      <div class="personal-info">
        <div class="personal-left">
          <div class="personal-record">
            <label>Longitude</label>
            <p>97.324</p>
          </div>
        </div>
        <div class="personal-right">
          <div class="personal-record">
            <label>Latitude</label>
            <p>82.416</p>
          </div>
        </div>
      </div><!--/personal-info-->

    </div><!--/content--->
  </div><!--/content-container-->

</template>

<script>
export default {
  name: "Ship"
}
</script>

<style scoped>
.content-container {
  background-color: rgba(32, 31, 31, 0.97);
}

.content{
  width: 90%;
  margin-left: auto;
  margin-right: auto;
}

h1{
  font-size: 32px;
  padding: 1%;
  color: white;
}

.personal-info{
  display: flex;
}

.personal-left{
  flex: 1;
  padding: 1%;
}

.personal-record{
  display: flex;
  color: white;
  margin-bottom: 1%;
}

.personal-record label{
  font-size: 20px;
  font-weight: bold;
  flex: 1;
}

.personal-record p{
  font-size: 20px;
  flex: 3;
}

.personal-right{
  flex: 1;
  padding: 1%;
}
</style>