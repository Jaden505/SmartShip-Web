<template>
  <head>
    <meta charset='utf-8' />
    <title>PTV Vector Map Restrictions Tutorial</title>
    <meta name='viewport' content='initial-scale=1,maximum-scale=1,user-scalable=no' />
    <link rel="stylesheet"  type="text/css" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" />
    <link rel="stylesheet" type="text/css" href="https://unpkg.com/maplibre-gl@2.1.9/dist/maplibre-gl.css" />

    <style>
      body { margin:0; padding:0; }
      #map { position:absolute; top:0; bottom:0; width:100%; }
    </style>
  </head>
  <body>

  <div id="map"></div>

  <script type="text/javascript" src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js" ></script>
  <script type="text/javascript" src="https://unpkg.com/maplibre-gl@2.1.7/dist/maplibre-gl.js" ></script>
  <script type="text/javascript" src="https://unpkg.com/@maplibre/maplibre-gl-leaflet@0.0.15/leaflet-maplibre-gl.js" ></script>
  <script type="text/javascript" src="https://unpkg.com/leaflet-ptv-developer@1.0.1/dist/leaflet-ptv-developer.js" ></script>
  <script type="text/javascript">
    /* The JS code below goes here */
  </script>
  </body>
</template>

<script>
import AlarmService from "@/services/AlarmService";

export default {
  name: "Map"
},

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

created() {
  var scripts = [
      "https://unpkg.com/leaflet@1.7.1/dist/leaflet.js", "https://unpkg.com/maplibre-gl@2.1.7/dist/maplibre-gl.js", "https://unpkg.com/@maplibre/maplibre-gl-leaflet@0.0.15/leaflet-maplibre-gl.js", "https://unpkg.com/leaflet-ptv-developer@1.0.1/dist/leaflet-ptv-developer.js"];
  scripts.forEach(script => {
    let tag = document.createElement('script');
    tag.setAttribute("scr", script);
    document.head.appendChild(tag);
  })
}

methods: {
  const API_KEY = 'YOUR_API_KEY';

  const coordinates = L.latLng(49.012, 8.4044); // Karlsruhe, Germany
  const map = L.map('map', {
    fullscreenControl: true
  }).setView(coordinates, 17);

  maplibregl.setRTLTextPlugin(
      'https://api.mapbox.com/mapbox-gl-js/plugins/mapbox-gl-rtl-text/v0.2.3/mapbox-gl-rtl-text.js',
      null,
      true
  );

  var vectorLayer = L.maplibreGL({
    attribution: '&copy; ' + new Date().getFullYear() + ' PTV Group, HERE',
    interactive:false,
    maxZoom: 18,
    style: 'https://vectormaps-resources.myptv.com/styles/latest/standard.json',
    transformRequest: (url, resourceType) => {
      if (resourceType === 'Tile' && url.startsWith('https://api.myptv.com')) {
        return {
          url: url + '?apiKey=' + API_KEY
        }
      }
    }
  }).addTo(map);
}
</script>

<style scoped>

</style>