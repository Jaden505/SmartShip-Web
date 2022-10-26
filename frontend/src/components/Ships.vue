<template>
  <HeaDer/>
  <el-main class="main">
    <el-row>
      <el-col :span="8">
        <label>Operator:</label><br/>
        <select v-model="operatorId">
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
        </select>
      </el-col>
      <el-col :span="16">
        <el-card class="el-card" v-for="(ship, index) in ships" :key="index">
          <div class="row">
            <div class="img-box">
              <p>{{ ship.shipName }}</p>
            </div>
            <div class="infoBox">
              <p class="shipTitle">Ship id: {{ ship.shipId }}</p>
              <p class="shipTitle">Ship name: {{ ship.shipName }}</p>
              <p class="shipTitle">Ship description: {{ ship.shipDesc }}</p>
            </div>
          </div>
          <div class="clock-in">
            <button class="clockin-button"><router-link class="link" to="/dashboard">Clock In</router-link></button>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </el-main>
</template>

<script>
import HeaDer from "@/components/Header";
export default {
  name: "ShipsComponent",
  components: {HeaDer},
  data(){
    return {
      ships: [
        {
          shipId: '1',
          shipName: 'Titanic',
          shipDesc: 'This is a safe ship'
        },
        {
          shipId: '2',
          shipName: 'The Mayflower',
          shipDesc: 'Beautiful ship'
        },
        {
          shipId: '3',
          shipName: 'Cruise Ship 1997',
          shipDesc: 'A luxurious ship'
        }
      ],
      operatorId: '',
      active: true,
      message: ''
    }
  },
  methods: {
  }

}
</script>

<style scoped>
.el-card {
  background: #002C48;
  border: none;
  color: #E0E1DD;
  text-align: center;
  border-radius: 20px;
  margin-bottom: 10px;
}

.link{
  text-decoration: none;
  color: #00111C;
}

.img-box{
  flex: 1;
  font-size: 40px;
  text-align: center;
  margin: 1%;
}

.infoBox{
  text-align: left;
  flex: 3;
  margin: 1%;
  padding: 1%;
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

.clockin-button {
  width: 100px;
  height: 50px;
  font-size: 1rem;
  font-weight: 600;
  color: #00111C;
  border-radius: 10px;
  background: linear-gradient(-45deg, #60EFFF, #0061FF);
  background-size: 600%;
  -webkit-animation: anime 16s linear infinite;
  animation: anime 16s linear infinite;
  border: solid 0 black;
  transition: all .2s ease-in-out;
}

.clockin-button:hover {
  transform: translateY(-0.25em)
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