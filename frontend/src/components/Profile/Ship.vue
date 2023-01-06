<template>

  <div class="content-container">
    <div class="content">

      <h1>Ship information</h1>
      <hr>

      <div class="personal-info">
        <div class="personal-left">
          <div class="personal-record">
            <label>Ship Id</label>
            <p>{{ ship.id }}</p>
          </div>
          <div class="personal-record">
            <label>Ship status</label>
            <p>{{ ship.status }}</p>
          </div>
        </div>
        <div class="personal-right">
          <div class="personal-record">
            <label>Ship name</label>
            <p>{{ ship.name }}</p>
          </div>
        </div>
      </div><!--/personal-info-->

      <h1>Ship location</h1>
      <hr>

      <div class="personal-info">
        <div class="personal-left">
          <div class="personal-record">
            <label>Longitude</label>
            <p v-if="ship.longitude == null">Unknown</p>
            <p v-else>{{ ship.longitude }}</p>
          </div>
        </div>
        <div class="personal-right">
          <div class="personal-record">
            <label>Latitude</label>
            <p v-if="ship.latitude == null">Unknown</p>
            <p v-else>{{ ship.latitude }}</p>
          </div>
        </div>
      </div><!--/personal-info-->

    </div><!--/content--->
  </div><!--/content-container-->

</template>

<script>
import shipService from "@/services/ship.service";
import {toRaw} from "vue";

export default {
  name: "Ship",

  data(){
    return {
      ship: {
        id: null,
        status: null,
        name: null,
        longitude: null,
        latitude: null
      }
    }
  },

  methods: {
    getShip(){
      const id = toRaw(this.$store.state.auth.user.ship)
      shipService.get(id)
          .then(response => {
            this.ship.id = response.data[0].id
            this.ship.status = response.data[0].status
            this.ship.name = response.data[0].name
            this.ship.latitude = response.data[0].gpsLatitude
            this.ship.longitude = response.data[0].gpsLongtitude
          })
          .catch(e => {
            console.log(e)
          })
    }
  },

  mounted() {
    this.getShip()
  }
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