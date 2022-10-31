<template>
  <div class="card" v-for="(ship, index) in ships" :key="index">
    <div class="row">
      <div class="img-box">
        <p>{{ ship.shipName }}</p>
      </div>
      <div class="infoBox">
        <p class="shipTitle">Ship id: {{ ship.id }}</p>
        <p class="shipTitle">Ship name: {{ ship.status }}</p>
        <p class="shipTitle">Ship description: {{ ship.location}}</p>
      </div>
    </div>
  </div>
</template>

<script>
import ShipService from "../services/ShipService";

export default {
  name: "ShipsComponent",

  mounted() {
    this.getShips();
  },

  data(){
    return {
      ships: [],
    }
  },

  methods: {
    getShips() {
      ShipService.getAll()
          .then(response => {
            this.ships = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
      });
    }
  }
}
</script>

<style scoped>

.card{
  border: 2px solid black;
  width: 80%;
  margin-left: auto;
  margin-right: auto;
  background-color: #163b7a;
  margin-bottom: 1%;
  border-radius: 20px;
}

.row{
  display: flex;
}

.img-box{
  flex: 1;
  font-size: 40px;
  text-align: center;
  border: 2px solid black;
  margin: 1%;
  background-color: white;
}

.infoBox{
  text-align: left;
  flex: 3;
  margin: 1%;
  padding: 1%;
  border: 2px solid black;
  background-color: white;
}

.shipTitle{
  font-weight: bold;
}

.clock-in p{
  position: relative;
  left: 87%;
  width: 10%;
  text-align: center;
  margin: 0 1% 1% 0;
  background-color: white;
  border: 2px solid black;
  border-radius: 20px;
  padding: 1%;
  cursor: pointer;
}

.clock-in p:hover{
  background-color: #80bfff;
}

label{
  color: white;
  margin-left: 1%;
}

select{
  margin-left: 1%;
  text-align: center;
  width: 6%;
}

h1{
  color: white;
}


</style>