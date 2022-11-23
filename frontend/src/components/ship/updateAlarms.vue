<template>
    <div id="container">
      <div id="allParameters">
        <div class="submit-form">
        <p class="title">Create new alarm</p>
        <div class="Parameters form-group">
          <label for="parameter" class="block mb-2 text-sm font-medium text-white-text">Parameter</label>
          <input  v-model="alarm.parameter" class="form-control" type="text" name="parameter"/>
        </div>
        <div class="Parameters form-group">
          <label for="category" class="block mb-2 text-sm font-medium text-white-text">Category</label>
          <input v-model="alarm.category" class="form-control" type="text" name="category"/>
        </div>
        <div class="Parameters form-group">
          <label for="value" class="block mb-2 text-sm font-medium text-white-text">Value</label>
          <input v-model="alarm.valueSinceLastUpdate" class="form-control" type="text" name="valueSinceLastUpdate"/>
        </div>
        <div class="Parameters form-group">
          <label for="settedUpValue" class="block mb-2 text-sm font-medium text-white-text">setted up Value</label>
          <input v-model="alarm.settedUpValue" class="form-control" type="text" name="settedUpValue"/>
        </div>
        <div class="Parameters form-group">
          <label for="id" class="block mb-2 text-sm font-medium text-white-text">Ship id</label>
          <input v-model="alarm.shipId" class="form-control" type="text" name="shipId"/>
        </div>
<!--        <button class="button" id="cancel" @click="cancelModal()">-->
<!--          {{ cancel }}-->
<!--        </button>-->

            <button class="button" id="update" @click="addAlarm">
                      {{ update }}
            </button>

        </div>
      </div>
    </div>
</template>

<script>
import AlarmService from "@/services/AlarmService";

export default {
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
  background-color: #002C60;
  border-radius: 20px;
  margin: 20px;
  box-shadow: 0 3px 10px rgb(0 0 0 / 2);
}

.Parameters {
  color: #0061FF;
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
.button{
  width: 30%;
  height: 50px;
  margin-top: 10%;
  margin-left: 100px;
  color: white;
  border-radius: 20px;
}
#update{
  background-color: lightgreen;
}
#cancel{
  background-color: deeppink;
}



/*Bartek zn schuld */

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


</style>
