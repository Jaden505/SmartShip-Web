<template>
  <div class="map" id="map"></div>
</template>

<script>

import leaflet from "leaflet";
import ShipService from "@/services/ship.service";

export default {
  name: "Map",
  mounted() {
    ShipService.get(JSON.parse(localStorage.getItem('user')).ship)
        .then(response => {
          this.ship = response.data;
          const map = leaflet.map('map').setView([0, 0], 1);
          leaflet.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
            maxZoom: 19,
            minZoom: 1,
            attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
          }).addTo(map);

          const ship_icon = leaflet.icon({
            iconUrl: 'https://cdn.joypixels.com/emoji/joypixels/3.0/png/128/1f6a2.png',
            iconSize: [35, 35],
          });

          let shipmarker = leaflet.marker([this.ship[0].gpsLatitude, this.ship[0].gpsLongtitude], {icon: ship_icon})
          let ship_popup = shipmarker.bindPopup("<b>NAME: </b>" + this.ship[0].name+"<br>"+
              "<b>ORIGIN: </b>"+this.ship[0].origin+"<br>"+
              "<b>DESTINATION: </b>"+this.ship[0].destination+"<br>"+
              "<b>STATUS: </b>"+this.ship[0].status+"<br>"+
              "<b>LATITUDE: </b>"+this.ship[0].gpsLatitude+"<br>"+
              "<b>LONGTITUDE: </b>"+this.ship[0].gpsLongtitude
          ).openPopup().addTo(map);
        }).catch(e => {
      console.log(e)
    })
  }
}
</script>

<style scoped>

.map {
  position: absolute;
  bottom: 100;
  width: 64.5%;
  height: 90%;
}

</style>
