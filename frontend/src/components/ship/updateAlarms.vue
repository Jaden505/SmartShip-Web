<template>
  <Teleport to="#modal">
      <div class="modal-bg">
        <div class="modal p-10 rounded-md shadow-md bg-blue-regular dark:bg-black-light">
          <font-awesome-icon class="close-popup text-black-light dark:text-white-text" icon="fa-solid fa-xmark" />
          <h1 class="font-bold text-black-text dark:text-white-text">Create new alarm</h1>
          <div class="submit-form">
            <div class="Parameters form-group">
              <label for="parameter" class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4">Parameter</label>
              <input  v-model="alarm.parameter" class="form-control bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white" type="text" name="parameter"/>
            </div>
            <div class="Parameters form-group">
              <label for="category" class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4">Category</label>
              <input v-model="alarm.category" class="form-control bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white" type="text" name="category"/>
            </div>
            <div class="Parameters form-group">
              <label for="value" class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4">Value</label>
              <input v-model="alarm.valueSinceLastUpdate" class="form-control bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white" type="text" name="valueSinceLastUpdate"/>
            </div>
            <div class="Parameters form-group">
              <label for="settedUpValue" class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4">setted up Value</label>
              <input v-model="alarm.settedUpValue" class="form-control bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white" type="text" name="settedUpValue"/>
            </div>
            <div class="Parameters form-group">
              <label for="id" class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4">Ship id</label>
              <input v-model="alarm.shipId" class="form-control bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white" type="text" name="shipId"/>
            </div>
            <button class="shadow bg-blue-regular w-full mt-2 text-black-light dark:text-white-text font-bold py-2 px-4 rounded-md" @click="addAlarm">
              {{ update }}
            </button>

          </div>
        </div>
      </div>
  </Teleport>
</template>

<script>
import AlarmService from "@/services/alarm.service";
import {library} from "@fortawesome/fontawesome-svg-core";
import {faXmark} from "@fortawesome/free-solid-svg-icons";

library.add(faXmark)

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
h1 {
  text-align: center;
  font-size: 24px;
  margin-bottom: 5%;
}

label {
  width: 100%;
  text-align: center;
}

input {
  width: 100%;
  padding: 1%;
}

input:focus {
  border: 2px solid black;
}

select {
  width: 100%;
  padding: 1%;
}
</style>
