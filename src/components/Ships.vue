<template>
  <div class="card" v-for="(ship, index) in ships" :key="index">
    <div class="row">
      <div class="img-box">
        <p>Ship</p>
      </div>
      <div class="infoBox">
       <p class="shipTitle">Ship name: {{ ship.shipName }}</p>
        <p class="shipTitle">Ship description: {{ ship.shipDesc }}</p>
      </div>
    </div>
    <div class="clock-in">
      <p>Clock In</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "ShipsComponent",

  data(){
    return {
      ships: [
        {
          shipName: 'Titanic',
          shipDesc: 'This is a safe ship'
        },
        {
          shipName: 'The Mayflower',
          shipDesc: 'Beautiful ship'
        },
        {
          shipName: 'Cruise Ship 1997',
          shipDesc: 'A luxurious ship'
        }
      ]
    }
  }
}
</script>

<style scoped>
  .card{
    border: 2px solid black;
    width: 83%;
    margin-left: 17%;
    background-color: #0066ff;
    margin-bottom: 1%;
  }

  .row{
    display: flex;
  }

  .img-box{
    flex: 1;
    font-size: 20px;
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
    margin-right: 1%;
    background-color: white;
    border: 2px solid black;
    border-radius: 20px;
    padding: 1%;
    cursor: pointer;
  }

  .clock-in p:hover{
    background-color: #80bfff;
  }


</style>