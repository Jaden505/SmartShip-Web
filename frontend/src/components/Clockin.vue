/* eslint-disable */
<template>
  <HeaDer/>
  <el-card>
      <dropdown v-if="active">
        <h2 class="welcome">Hey Bart! Select a ship to clock in:</h2>
        <input id="toggle2" type="checkbox">
        <label for="toggle2" class="animate">Ships<i class="fa fa-list float-right"></i></label>
        <ul class="animate" v-for="(ship, index) in ships" :key="index">
          <li class="animate" @click="setCurrentShip(ship.name)">{{ ship.name }}</li>
        </ul>
      </dropdown>

      <div v-else>
        <p class="back" @click="goBack">{{ back }}</p>
        <h2 class="welcome">You selected the ship: {{ currentShip }}</h2>
      </div>
    <button v-if="!active" class="clockin-button" @click="clockIn">Clock-in</button>
  </el-card>
</template>

<script>
import HeaDer from "@/components/Header";
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Clockin",
  components: {HeaDer},
  data(){
    return {
      ships: [
        {
          name: "Grote Bherta"
        },
        {
          name: "Immaculata"
        },
        {
          name: "Teerstroom"
        }
      ],
      currentShip: null,
      active: true,
      back: "<<< Go back"
    }
  },
  methods: {
    setCurrentShip(ship){
      this.active = false
      this.currentShip = ship
    },

    clockIn(){
      this.$router.push({ name: "Clockout", params: { ship: this.currentShip } })
    },

    goBack(){
      this.active = true
    }
  }
}
</script>

<style scoped>
/*centered button in div*/

.el-card {
  background: #E0E1DD;
  border: none;
  color: #002C48;
  text-align: center;
  border-radius: 20px;
  height: 200px;
  width: 50%;
}

#toggle2{
  z-index: -7;
}

.back{
  color: cornflowerblue;
  cursor: pointer;
}

/*dropdown*/

* {
  padding: 0;
  margin: 0;
  font-family: 'Lato', sans-serif;
  box-sizing: border-box;
}
.float-right {
  float: right;
}
.fa {
  font-size: 0.8em;
  line-height: 22px !important;
}
dropdown {
  display: inline-block;
  margin: 20px 50px;
}
dropdown label, dropdown ul li {
  display: block;
  width: 200px;
  background: #ecf0f1;
  padding: 15px 20px;
}
dropdown label:hover, dropdown ul li:hover {
  background: #00111C;
  color: white;
  cursor: pointer;
}
dropdown label {
  color: #00111C;
  border-left: 4px solid #00111C;
  border-radius: 0 5px 0 0;
  position: relative;
  z-index: 2;
}
dropdown input {
  display: none;
}
dropdown input ~ ul {
  position: relative;
  visibility: hidden;
  opacity: 0;
  top: -20px;
  z-index: 1;
}
dropdown input:checked + label {
  background: #00233A;
  color: white;
}
dropdown input:checked ~ ul {
  visibility: visible;
  opacity: 1;
  top: 0;
}
dropdown ul li:nth-child(1) {
  border-left: 4px solid #00111C;
}
dropdown ul li:nth-child(1) .fa {
  color: #00111C;
}
dropdown ul li:nth-child(1):hover {
  background: #00233A;
  color: white;
}
dropdown ul li:nth-child(1):hover .fa {
  color: white;
}
dropdown ul li:nth-child(2) {
  border-left: 4px solid #0072b5;
}
dropdown ul li:nth-child(2) .fa {
  color: #0072b5;
}
dropdown ul li:nth-child(2):hover {
  background: #0072b5;
  color: white;
}
dropdown ul li:nth-child(2):hover .fa {
  color: white;
}
dropdown ul li:nth-child(3) {
  border-left: 4px solid #2c3e50;
}
dropdown ul li:nth-child(3) .fa {
  color: #2c3e50;
}
dropdown ul li:nth-child(3):hover {
  background: #2c3e50;
  color: white;
}
dropdown ul li:nth-child(3):hover .fa {
  color: white;
}
.animate {
  -webkit-transition: all 0.3s;
  -moz-transition: all 0.3s;
  -ms-transition: all 0.3s;
  -ms-transition: all 0.3s;
  transition: all 0.3s;
  backface-visibility: hidden;
  -webkit-backface-visibility: hidden;
  -moz-backface-visibility: hidden;
  /* Chrome and Safari */
  -ms-backface-visibility: hidden;
  /* Firefox */
}
/* Internet Explorer */


.clockin-button, .btn2 {
  width: 100px;
  height: 50px;
  font-size: 1rem;
  font-weight: 600;
  color: #00111C;
  border-radius: 10px;
  background: linear-gradient(-45deg, #60EFFF, #0061FF);
  background-size: 600%;
  border: solid 0 black;
  transition: all .2s ease-in-out;
}

.clockin-button:hover, .btn2:hover {
  transform: translateY(-0.25em)
}


</style>