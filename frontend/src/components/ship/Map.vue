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


import leafletDev from "leaflet-ptv-developer";

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

  mounted(){
    const API_KEY = 'RVVfOGFhMDk3MTFkNDM4NDkxOGExZTQzNWRmZmMwNTI5MzI6ZTBlMTZjYzItMWQ3Yi00YzYxLTk2NTAtYzc1Y2QyOTFiYWUz';

    const coordinates = leaflet.latLng(49.012, 8.4044); // Karlsruhe, Germany
    const map = leaflet.map('map', {
      fullscreenControl: true
    }).setView(coordinates, 17);

    libre.setRTLTextPlugin(
        'https://api.mapbox.com/mapbox-gl-js/plugins/mapbox-gl-rtl-text/v0.2.3/mapbox-gl-rtl-text.js',
        null,
        true
    );

    console.log(libre.version);

   var map1 = new libre.Map({
      container: 'map', // container id
      style: 'https://demotiles.maplibre.org/style.json', // style URL
      center: [0, 0], // starting position [lng, lat]
      zoom: 1 // starting zoom
    });

    // var vectorLayer = libre.maplibreGL({
    //   attribution: '&copy; ' + new Date().getFullYear() + ' PTV Group, HERE',
    //   interactive:false,
    //   maxZoom: 18,
    //   style: 'https://vectormaps-resources.myptv.com/styles/latest/standard.json',
    //   transformRequest: (url, resourceType) => {
    //     if (resourceType === 'Tile' && url.startsWith('https://api.myptv.com')) {
    //       return {
    //         url: url + '?apiKey=' + "RVVfOGFhMDk3MTFkNDM4NDkxOGExZTQzNWRmZmMwNTI5MzI6ZTBlMTZjYzItMWQ3Yi00YzYxLTk2NTAtYzc1Y2QyOTFiYWUz"
    //       }
    //     }
    //   }
    // }).addTo(map);
  }

    // const API_KEY = 'RVVfOGFhMDk3MTFkNDM4NDkxOGExZTQzNWRmZmMwNTI5MzI6ZTBlMTZjYzItMWQ3Yi00YzYxLTk2NTAtYzc1Y2QyOTFiYWUz';
    //
    // const coordinates = L.latLng(49.012, 8.4044); // Karlsruhe, Germany
    // const map = L.map('map', {
    //   fullscreenControl: true
    // }).setView(coordinates, 17);
    //
    // maplibregl.setRTLTextPlugin(
    //     'https://api.mapbox.com/mapbox-gl-js/plugins/mapbox-gl-rtl-text/v0.2.3/mapbox-gl-rtl-text.js',
    //     null,
    //     true
    // );
    //
    // var vectorLayer = L.maplibreGL({
    //   attribution: '&copy; ' + new Date().getFullYear() + ' PTV Group, HERE',
    //   interactive:false,
    //   maxZoom: 18,
    //   style: 'https://vectormaps-resources.myptv.com/styles/latest/standard.json',
    //   transformRequest: (url, resourceType) => {
    //     if (resourceType === 'Tile' && url.startsWith('https://api.myptv.com')) {
    //       return {
    //         url: url + '?apiKey=' + API_KEY
    //       }
    //     }
    //   }
    // }).addTo(map);
    //
}

// mounted(){
//   // let mapScript1 = document.createElement('Mapscript1')
//   // mapScript1.setAttribute('src', 'https://unpkg.com/leaflet@1.7.1/dist/leaflet.js')
//   // document.head.appendChild(mapScript1)
//   //
//   // let mapScript2 = document.createElement('Mapscript2')
//   // mapScript2.setAttribute('src', 'https://unpkg.com/maplibre-gl@2.1.7/dist/maplibre-gl.js')
//   // document.head.appendChild(mapScript2)
//   //
//   // let mapScript3 = document.createElement('Mapscript3')
//   // mapScript3.setAttribute('src', 'https://unpkg.com/@maplibre/maplibre-gl-leaflet@0.0.15/leaflet-maplibre-gl.js')
//   // document.head.appendChild(mapScript3)
//   //
//   // let mapScript4 = document.createElement('Mapscript4')
//   // mapScript4.setAttribute('src', 'https://unpkg.com/leaflet-ptv-developer@1.0.1/dist/leaflet-ptv-developer.js')
//   // document.head.appendChild(mapScript4)
// },

// created() {
//   var scripts = [
//       "https://unpkg.com/leaflet@1.7.1/dist/leaflet.js", "https://unpkg.com/maplibre-gl@2.1.7/dist/maplibre-gl.js", "https://unpkg.com/@maplibre/maplibre-gl-leaflet@0.0.15/leaflet-maplibre-gl.js", "https://unpkg.com/leaflet-ptv-developer@1.0.1/dist/leaflet-ptv-developer.js"];
//   scripts.forEach(script => {
//     let tag = document.createElement('script');
//     tag.setAttribute("scr", script);
//     document.head.appendChild(tag);
//   })
// }
// methods: {
//   const API_KEY = 'YOUR_API_KEY';
//
//   const coordinates = L.latLng(49.012, 8.4044); // Karlsruhe, Germany
//   const map = L.map('map', {
//     fullscreenControl: true
//   }).setView(coordinates, 17);
//
//   maplibregl.setRTLTextPlugin(
//       'https://api.mapbox.com/mapbox-gl-js/plugins/mapbox-gl-rtl-text/v0.2.3/mapbox-gl-rtl-text.js',
//       null,
//       true
//   );
//
//   var vectorLayer = L.maplibreGL({
//     attribution: '&copy; ' + new Date().getFullYear() + ' PTV Group, HERE',
//     interactive:false,
//     maxZoom: 18,
//     style: 'https://vectormaps-resources.myptv.com/styles/latest/standard.json',
//     transformRequest: (url, resourceType) => {
//       if (resourceType === 'Tile' && url.startsWith('https://api.myptv.com')) {
//         return {
//           url: url + '?apiKey=' + API_KEY
//         }
//       }
//     }
//   }).addTo(map);
// }
</script>

<style scoped>

.map{
  position:absolute;
  bottom:0;
  width: 82%;
  height: 90%;
}

</style>