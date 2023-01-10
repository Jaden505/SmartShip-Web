<template>
  <Teleport to="#modal">
    <div class="container bg-blue-regular dark:bg-black-light">
      <div class="modal-bg">
        <div class="modal p-10 rounded-md shadow-md bg-blue-regular dark:bg-black-light">
          <p class="title text-black-text dark:text-white-text">Create new alarm</p>
          <Form @submit="addAlarm" class="submit-form">
            <div class="form-group">
              <label for="parameter" class="block mb-2 text-sm font-medium text-black-text dark:text-white-text">Parameter</label>
              <Field name="parameter" type="text" class="form-control" />
            </div>
            <div class="form-group">
              <label for="category" class="block mb-2 text-sm font-medium text-black-text dark:text-white-text">Category</label>
              <Field name="category" type="text" class="form-control" />
            </div>
            <div class="form-group">
              <label for="value" class="block mb-2 text-sm font-medium text-black-text dark:text-white-text">Value</label>
              <Field class="form-control" type="number" name="valueSinceLastUpdate"/>
            </div>
            <div class="form-group">
              <label for="settedUpValue" class="block mb-2 text-sm font-medium text-black-text dark:text-white-text">setted up Value</label>
              <Field class="form-control" type="number" name="settedUpValue"/>
            </div>
            <div class="form-group">
              <label for="id" class="block mb-2 text-sm font-medium text-black-text dark:text-white-text">Ship id</label>
              <Field class="form-control" type="text" name="shipId"/>
            </div>
            <button class="button bg-blue-700 dark:bg-gray-700">
              {{ update }}
            </button>
          </Form>
        </div>
      </div>
        </div>
  </Teleport>
</template>

<script>
import AlarmService from "@/services/alarm.service";
import {Alarm} from "@/models/alarm";
import { Form, Field, ErrorMessage } from "vee-validate";
import {toRaw} from "vue";

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
    }
  },
  components: {
    Form,
    Field
  },
  methods: {
    addAlarm(alarm) {
      const alarmObject = toRaw(alarm)

      console.log(alarm)

      const newAlarm = new Alarm(0, alarmObject.parameter, alarmObject.category, alarmObject.valueSinceLastUpdate, alarmObject.settedUpValue, alarmObject.shipId)

      console.log(newAlarm)

      AlarmService.addAlarm(newAlarm)
          .then(response => {
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
.modal-bg {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100vh;

  background-color: rgba(0,0,0, 0.5);

  display: flex;
  justify-content: center;
  align-items: center;
}

.modal {
  position: relative;
  background: white;
  padding: 50px 100px;
  border-radius: 5px;
  box-shadow: 0px 10px 5px 2px rgba(0,0,0, 0.1);
}

.Parameters {
  margin-top: 3%;
  display: block;
  font-size: 30px;
}

input{
  border-radius: 10px;
}

.button{
  width: 30%;
  height: 50px;
  margin-top: 10%;
  margin-left: 100px;
  color: white;
  border-radius: 20px;
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
}


</style>
