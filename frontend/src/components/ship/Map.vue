<template>
  <!--  <head>-->
  <!--    <meta charset='utf-8' />-->
  <!--    <title>PTV Vector Map Restrictions Tutorial</title>-->
  <!--    <meta name='viewport' content='initial-scale=1,maximum-scale=1,user-scalable=no' />-->
  <!--    <link rel="stylesheet"  type="text/css" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" />-->
  <!--    <link rel="stylesheet" type="text/css" href="https://unpkg.com/maplibre-gl@2.1.9/dist/maplibre-gl.css" />-->
  <!--  </head>-->
  <body>

  <div class="map" id="map"></div>
  </body>
</template>

<script>

import leaflet from "leaflet";
import libre from "maplibre-gl";
import ShipService from "@/services/ShipService";

// var scripts = [
//   "https://unpkg.com/leaflet@1.7.1/dist/leaflet.js", "https://unpkg.com/maplibre-gl@2.1.7/dist/maplibre-gl.js", "https://unpkg.com/@maplibre/maplibre-gl-leaflet@0.0.15/leaflet-maplibre-gl.js", "https://unpkg.com/leaflet-ptv-developer@1.0.1/dist/leaflet-ptv-developer.js"];
// scripts.forEach(script => {
//   let tag = document.createElement('script');
//   tag.setAttribute("scr", script);
//   document.head.appendChild(tag);
// });
//
// console.log(scripts[0])

export default {
  name: "Map",
  mounted() {
    ShipService.get(5)
        .then(response => {
          this.ship = response.data
          const API_KEY = 'RVVfOGFhMDk3MTFkNDM4NDkxOGExZTQzNWRmZmMwNTI5MzI6ZTBlMTZjYzItMWQ3Yi00YzYxLTk2NTAtYzc1Y2QyOTFiYWUz';
          const coordinates = leaflet.latLng(49.012, 8.4044); // Karlsruhe, Germany
          const map = leaflet.map('map', {
            fullscreenControl: true
          }).setView(coordinates, 10);

          libre.setRTLTextPlugin(
              'https://api.mapbox.com/mapbox-gl-js/plugins/mapbox-gl-rtl-text/v0.2.3/mapbox-gl-rtl-text.js',
              null,
              true
          );

          console.log(libre.version);
          // eslint-disable-next-line no-undef
          let ship_icon = L.icon({
            iconUrl: 'https://cdn.joypixels.com/emoji/joypixels/3.0/png/128/1f6a2.png',
            iconSize: [40, 40],
          });
          // // eslint-disable-next-line no-undef
          // let begin_icon = L.icon({
          //   iconUrl: 'https://cdn2.iconfinder.com/data/icons/classic-development-circle/512/start-1024.png',
          //   iconSize: [40, 40],
          // });
          // // eslint-disable-next-line no-undef
          // let destination_icon = L.icon({
          //   iconUrl: 'https://d35k22e9287vnh.cloudfront.net/224x/images/e/end.png',
          //   iconSize: [40, 40],
          // });
          console.log(response.data)
          console.log(this.ship[0].latitude)
          // eslint-disable-next-line no-undef
          let shiplocation = L.marker([this.ship[0].gpsLatitude, this.ship[0].gpsLongtitude], {icon: ship_icon});
          let ship_popup = shiplocation.bindPopup(
                    "NAME:\n"+this.ship[0].name +
                    "\nORIGIN: " + this.ship[0].origin +
                    "\nDESTINATION: " + this.ship[0].destination +
                    "\nSTATUS: " + this.ship[0].status +
                    "\nLATITUDE: " + this.ship[0].gpsLatitude +
                    "\nLONGTITUDE: " + this.ship[0].gpsLongtitude).openPopup();

          ship_popup.addTo(map)
          // begin_popup.addTo(map)
          // destination_popup.addTo(map)


          var map1 = new libre.Map({
            container: 'map', // container id
            style: 'https://demotiles.maplibre.org/style.json', // style URL
            center: [0, 0], // starting position [lng, lat]
            zoom: 1 // starting zoom
          });
        })
        .catch(e => {
          console.log(e)
        })
  }
  ,
  data() {
    return {
      ship: []
    }
  }
}
</script>

<style scoped>

.map {
  position: absolute;
  bottom: 0;
  width: 64.5%;
  height: 90%;
}

</style>
