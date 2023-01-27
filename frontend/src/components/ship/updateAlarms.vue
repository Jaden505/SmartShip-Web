<template>
  <div id="container">
    <div id="allParameters">
      <div class="submit-form">
        <form>
        <p class="title">Create new alarm</p>
        <div class="Parameters form-group">
          <label for="category" class="block mb-2 text-sm font-medium text-white-text">Group</label>
          <select v-model="selectedCategory" class="dropdown" type="text" name="category" required>
            <option v-for="(category, index) in categories"
                    :value="category"
                    :key="index">
              {{ category }}
            </option>
          </select>
        </div>
        <div class="Parameters form-group">
          <label class="block mb-2 text-sm font-medium text-white-text">Sensor name</label>
          <select v-model="selectedSensor" class="dropdown" type="text" name="sensor_name" required>
            <option v-for="(name, index) in allNames"
                    :value="name"
                    :key="index">
              {{ name }}
            </option>
          </select>
        </div>

        <div class="Parameters form-group">
          <label for="value" class="block mb-2 text-sm font-medium text-white-text">current value</label>
          <input v-model="value" class="form-control" type="text" name="valueSinceLastUpdate" required>
        </div>

        <div class="Parameters form-group">
          <label for="value" class="block mb-2 text-sm font-medium text-white-text">Your value</label>
          <input v-model="alarm.settedUpValue" class="form-control" type="text" name="valueSinceLastUpdate">
        </div>

        <div class="Parameters form-group">
          <label for="value" class="block mb-2 text-sm font-medium text-white-text">Notification Message</label>
          <input v-model="alarm.message" class="form-control w-50 h-50" type="text" name="valueSinceLastUpdate">
        </div>

        <button class="button" id="cancel" @click="cancelForm">
          {{ cancel }}
        </button>
        <button class="button" id="update" @click="addAlarm">
          {{ update }}
        </button>
      </form>
      </div>
    </div>
  </div>
</template>

<script>
import AlarmService from "@/services/alarm.service";
import SensordataService from "@/services/sensordata.service";

import {Alarm} from "@/models/alarm";
export default {
  created(){
    this.getCategories();
    this.getSensorNameByMotor();
    this.getSensorNameByBattery();
    this.getSensorNameBySeaConditions();
    this.getSensorNameByFuel();
    this.getSensorName();
  },
  name: "AddAlarms",
  data() {
    return {
      value: null,
      parametertext: "Parameter: ",
      categorytext: "Category: ",
      realTimeValuetext: "Real time value: ",
      settedUpValuetext: "Setted up value: ",
      ship_idtext: "Ship-id: ",
      update: "Update",
      cancel: "Cancel",
      categories: [],
      allNames: [],
      sensor_names: [],
      sensorCat: [],
      // sensor_groups start
      Motors: [],
      Seas: [],
      Fuels: [],
      Batteries: [],
      // sensor_groups end
      /* istanbul ignore next */
      // shipId: JSON.parse(localStorage.getItem('user')).ship,

      selectedSensor: null,
      selectedCategory: null,
      alarm: {
        parameter: "",
        category: "",
        settedUpValue: "",
        date: "",
        message: "",
        unit: "",
      },
      sensor_data: {
        sensor_id: "",
        gps_latitude: "",
        gps_longtitude: "",
        sensor_group: "",
        sensor_name: "",
        ship_id: "",
        speed: "",
        time: "",
        type: "",
        unit: "",
        value: "",
        settedUpValue: "",
      }
    }
  },

  watch: {
    input: function () {
      // eslint-disable-next-line no-undef
      app.input = localStorage.getItem('ship');
    },
    selectedSensor(sensor){
      if (sensor !== null){
        this.value = this.getSensorValue(this.selectedCategory.replace(" ", "_"), sensor.replace(" ", "_"), this.shipId);
      }
    },
    selectedCategory(category){
      if (category !== null){
        this.allNames = this.getSensorName(category.replace(" ", "_"))
        console.log(this.allNames)
        console.log("hello")
      }
    }
  },

  methods: {

    localStorage() {
      console.log(this.shipId)
    },

    // filter() {
    //   if (this.selectedCategory == "Motor") {
    //     return this.Motors;
    //   } else if (this.selectedCategory == "Sea Conditions") {
    //     return this.Seas;
    //   } else if (this.selectedCategory == "Fuel") {
    //     return this.Fuels;
    //   } else if (this.selectedCategory == "Battery") {
    //     return this.Batteries;
    //   }
    // },

    async getCategories() {
      SensordataService.getCategories()
          .then(response => {
            this.categories = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          })
    },

    async getSensorName(group) {
      SensordataService.getSensorName(group)
          .then(response => {
            this.allNames = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          })
    },

    async getSensorValue(group, name, ship){
      SensordataService.getSensorValue(group, name, ship)
          .then(response => {
            this.value = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          })
    },

    async getSensorNameByMotor() {
      SensordataService.getSensorNameByMotor()
          .then(response => {
            this.Motors = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          })
    },

    async getSensorNameBySeaConditions() {
      SensordataService.getSensorNameBySeaConditions()
          .then(response => {
            this.Seas = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          })
    },

    async getSensorNameByFuel() {
      SensordataService.getSensorNameByFuel()
          .then(response => {
            this.Fuels = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          })
    },

    async getSensorNameByBattery() {
      SensordataService.getSensorNameByBattery()
          .then(response => {
            this.Batteries = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          })
    },

    filterOnGroup() {
      this.Batteries
    },

    cancelForm() {
      window.location.reload(true);
    },

    addAlarm(){
      const alarm = new Alarm(this.selectedSensor, this.selectedCategory, parseFloat(this.alarm.settedUpValue), this.shipId, this.alarm.date, this.alarm.message, this.alarm.unit)
      console.log(alarm)
      AlarmService.addAlarm(alarm)
          .then(response => {
            window.location.reload(true)
            console.log(response.data)
          })
          .catch(e => {
            console.log(e)
          })
    }
  }
}
</script>

<style scoped>
#container {
  position: absolute;
  top: 10%;
  left: 30%;
  z-index: 99;
  align-items: center;
  justify-content: center;
  width: auto;
  height: auto;
  background-color: #343434;
  border-radius: 20px;
  margin: 20px;
  box-shadow: 0 3px 10px rgb(0 0 0 / 2);
}

.Parameters {
  margin-top: 3%;
  display: block;
  font-size: 30px;
}
#allParameters{
  border-radius: 20px;
  height: auto;
}

input{
  border-radius: 10px;
  width: 70%;
  height: 20%;
  margin-left: 78px;
}

div.submit-form{
  width: 500px;
}

label{
  margin-left: 78px;
}

.button{
  width: 35%;
  margin-left: 252px;
  margin-bottom: 23px;
}

.title{
  margin-top: 20px;
  margin-left: 130px;
  font-size: 200%;
  color: white;
}

#cancel{
  margin-left: 80px;
  background-color: #656565;
}

#cancel , #update {
  display:inline-block;
  /* additional code */
}

#update{
  background-color: #656565;
}

.button{
  width: 35%;
  height: 50px;
  margin-top: 10%;
  margin-left: 10px;
  color: white;
  border-radius: 20px;
}

.dropdown{
  margin-left: 78px;
  width: 70%;
  border-radius: 10px;
}

</style>
