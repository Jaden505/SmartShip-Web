<template>
  <div v-motion :delay="100"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :initial="{ opacity: 0, y: 100 }"
       :variants="{ custom: { scale: 2 } }"
       class="mt-4 p-4">


    <div class="name-section bg-blue-regular">
      <h1>Raihan Saboerali</h1>
    </div>


    <div class="bar">
      <div class="tab" :class="{active: personalActive}">
        <router-link to="/profile/personal" @click="setPersonalActive">Personal</router-link>
      </div>
      <div class="tab" :class="{active: shipActive}">
        <router-link to="/profile/ship" @click="setShipActive">Ship</router-link>
      </div>
    </div>


    <router-view></router-view>


  </div>
</template>

<script>
export default {
  name: "Profile",

  data(){
    return{
      personalActive: false,
      shipActive: false
    }
  },

  methods: {
    setPersonalActive(){
      this.personalActive = true;
      this.shipActive = false;
    },

    setShipActive(){
      this.shipActive = true;
      this.personalActive = false;
    }
  }
}
</script>

<style scoped>
  .name-section{
    padding: 2%;
    font-size: 42px;
    font-weight: lighter;
    border-top-left-radius: 20px;
    border-top-right-radius: 20px;
  }

  .bar{
    background-color: rgb(34, 137, 171);
    display: flex;
  }

  .tab{
    padding: 1%;
    font-size: 24px;
    border-top-left-radius: 20px;
    border-top-right-radius: 20px;
  }

  .active{
    background-color: rgba(32, 31, 31, 0.97);
    color: white;
    transition: background-color 0.6s;
  }
</style>