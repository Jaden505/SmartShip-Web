<template>
  <div class="nav">
    <ul>
      <router-link to="/manager/operators"><li @click="setOpActive" :class="{active: opIsActive}">Operator</li></router-link>
      <router-link to="/manager/ships"><li @click="setShActive" :class="{active: shIsActive}">Ship</li></router-link>
    </ul>
  </div>
</template>

<script>
export default {
  name: "ManagerNav",

  data(){
    return{
      opIsActive: true,
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
  background-color: lightgrey;
  text-align: center;
  padding: 1%;
  margin: 1%;
  font-size: 24px;
  transition: background-color 0.7s;
}

li:hover{
  background-color: dodgerblue;
  color: lightgrey;
}

.active{
  background-color: dodgerblue;
  color: lightgrey;
}

a{
  text-decoration: none;
  color: black;
  flex: 1;
}


</style>