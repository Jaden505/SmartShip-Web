<template>
  <div class="content">
    <h1>Trip statistics</h1>

    <p>There is currently no trip going on</p>
    <p>The curent trip is from Paris to Amsterdam</p>


  </div>
</template>

<script>
export default {
  name: "TripStatistics",

  mounted() {
    this.importGoogleMaps();
  },

  methods: {
    importGoogleMaps() {
      let recaptchaScript = document.createElement('script')
      recaptchaScript.setAttribute('src', 'https://maps.googleapis.com/maps/api/js?sensor=false')
      document.head.appendChild(recaptchaScript)
    },
  }
}
</script>

<style scoped>
  .content {
    background-color: #163b7a;
    color:white;
  }
</style>