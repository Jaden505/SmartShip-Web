<template>
  <div class="nav">
    <ul>
      <router-link class="text-white bg-blue-light-card focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text" to="/manager/operators"><li @click="setOpActive" :class="{active: opIsActive}">Operators</li></router-link>
    </ul>
    <ul>
      <router-link to="/manager/ships" class="text-white bg-blue-light-card focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text"><li @click="setShActive" :class="{active: shIsActive}">Ships</li></router-link>
    </ul>
  </div>
</template>

<script>
export default {
  name: "ManagerNav",

  data(){
    return{
      opIsActive: false,
      shIsActive: false
    }
  },

  methods: {
    setOpActive(){
      this.shIsActive = false
      this.opIsActive = true
    },

    setShActive(){
      this.shIsActive = true
      this.opIsActive = false
    }
  }
}
</script>

<style scoped>
ul{
  width: 40%;
  margin-left: auto;
  margin-right: auto;
  margin-top: 1%;
  display: flex;
  list-style-type: none;
}

li{
  text-align: center;
  padding: 1%;
  margin: 1%;
  font-size: 24px;
  transition: background-color 0.7s;
}

ul:hover li{
  color: lightgrey;
}

.active{
  color: lightgrey;
}

a{
  text-decoration: none;
  color: black;
  flex: 1;
}
</style>