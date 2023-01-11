<template>
  <div id="container">
    <div id="allParameters">
      <div class="submit-form">
        <p class="title">Create new alarm</p>
        <div class="Parameters form-group">
          <label for="category" class="block mb-2 text-sm font-medium text-white-text">Group</label>
          <select v-model="selectedCategory" class="dropdown" type="text" name="category">
            <option v-for="(category, index) in categories"
                    :value="category"
                    :key="index">
              {{ category }}
            </option>
          </select>
        </div>
        <div class="Parameters form-group">
          <label class="block mb-2 text-sm font-medium text-white-text">Sensor name</label>
          <select v-model="selectedSensor" class="dropdown" type="text" name="sensor_name">
            <option v-for="(sensor, index) in filter()"
                    :value="sensor"
                    :key="index">
              {{ sensor }}
            </option>
          </select>
        </div>
        <div class="Parameters form-group">
          <label for="settedUpValue" class="block mb-2 text-sm font-medium text-white-text">current Value</label>
          <p class = "waarde">200</p>
        </div>
        <div class="Parameters form-group">
          <label for="value" class="block mb-2 text-sm font-medium text-white-text">your Value</label>
          <input v-model="alarm.valueSinceLastUpdate" class="form-control" type="text" name="valueSinceLastUpdate"/>
        </div>
        <button class="button" id="cancel" @click="cancelForm">
          {{ cancel }}
        </button>
        <button class="button" id="update" @click="addAlarm">
          {{ update }}
        </button>

      </div>
    </div>
  </div>
</template>

<script>
import AlarmService from "@/services/alarm.service";
import SensordataService from "@/services/sensordata.service";
import {toRaw} from "vue";
import {DashboardMoveComponents} from "@/assets/js/DashboardMoveComponents";

export default {
  created(){
    this.getCategories();
    this.getSensorNameByMotor();
    this.getSensorNameByBattery();
    this.getSensorNameBySeaConditions();
    this.getSensorNameByFuel();
  },
  name: "AddAlarms",
  data() {
    return {
      parametertext: "Parameter: ",
      categorytext: "Category: ",
      realTimeValuetext: "Real time value: ",
      settedUpValuetext: "Setted up value: ",
      ship_idtext: "Ship-id: ",
      update: "Update",
      cancel: "Cancel",
      categories: [],
      selectedCategory: null,
      sensor_names: [],
      sensorCat: [],
      // sensor_groups start
      Motors: [],
      Seas: [],
      Fuels: [],
      Batteries: [],
      // sensor_groups end
      shipId: null,
      selectedSensor: null,
      alarm: {
        parameter: "",
        category: "",
        valueSinceLastUpdate: "",
        settedUpValue: "",
        shipId:"",
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
    }
  },

  methods: {

    localStorage() {
      console.log(this.shipId)
    },

    filter() {
      if (this.selectedCategory == "Motor") {
        return this.Motors;
      } else if (this.selectedCategory == "Sea Conditions") {
        return this.Seas;
      } else if (this.selectedCategory == "Fuel") {
        return this.Fuels;
      } else if (this.selectedCategory == "Battery") {
        return this.Batteries;
      }
    },

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

    addAlarm() {

      const alarm = {
        sensor_group: this.sensor_data.sensor_group,
        sensor_name: this.sensor_data.sensor_name,
        value: this.sensor_data.value,
        settedUpValue: this.sensor_data.settedUpValue,
      };

      console.log(alarm)
      AlarmService.addAlarm(alarm)
          .then(response => {
            window.location.reload(true)
            console.log(response.data)
          })
          .catch(e => {
            console.log(e)
          })
    },
    getAllCategories() {
      AlarmService.getAllCategories()
          .then(response => {
            this.alarms = response.data;
            console.log(response.data);
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

input{
  border-radius: 10px;
}
#allParameters{
  border-radius: 20px;
  height: auto;
}

input{
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

.waarde{
  width: 70%;
  height: 20%;
  margin-left: 78px;
  color: white;
}

</style>
