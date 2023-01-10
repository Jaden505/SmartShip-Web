<template onload="getCategories">
  <div onload="getCategories" id="container">
    <div id="allParameters">
      <div class="submit-form">
        <p class="title">Create new alarm</p>
        <div class="Parameters form-group">
          <label for="category" class="block mb-2 text-sm font-medium text-white-text">Category</label>
          <select v-model="alarm.category" class="dropdown" type="text" name="category">
            <option v-for="(category, index) in categories"
                    :value="category"
                    :key="index">
              {{ category }}
            </option>
          </select>
        </div>
        <div class="Parameters form-group">
          <label for="parameter" class="block mb-2 text-sm font-medium text-white-text">Censor name</label>
          <select @click="getCategories" v-model="alarm.category" class="dropdown" type="text" name="category">
            <option v-for="(category, index) in categories"
                    :value="category"
                    :key="index">
              {{ category }}
            </option>
          </select>
        </div>
        <div class="Parameters form-group">
          <label for="settedUpValue" class="block mb-2 text-sm font-medium text-white-text">current Value</label>
          <input v-model="alarm.settedUpValue" class="form-control" type="text" name="settedUpValue"/>
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

export default {
  mounted() {
    this.getCategories();
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
      sensorCat: [],
      alarm: {
        parameter: "",
        category: "",
        valueSinceLastUpdate: "",
        settedUpValue: "",
        shipId:"",
      }
    }
  },
  methods: {
    getCategories(){
     SensordataService.getCategories()
         .then(response => {
           this.categories = response.data;
           console.log(response.data);
         })
         .catch(e => {
           console.log(e);
         })
    },
    cancelForm(){
      window.location.reload(true);
    },

    addAlarm() {

      const alarm = {
        parameter: this.alarm.parameter,
        category: this.alarm.category,
        valueSinceLastUpdate: this.alarm.valueSinceLastUpdate,
        settedUpValue: this.alarm.settedUpValue,
        shipId: this.alarm.shipId
      };

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

</style>
