<template>
  <div class="flex w-full p-4 text-black-light dark:text-white-text " v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100">

    <div class="flex" v-if="alarms.length !== 0">
      <div v-for="(alarm, index) in alarms" :key="index" class="bg-purple-basic dark:bg-black-light rounded-md shadow-md w-[250px]">
        <div class="p-4">
          <h1 class="text-xl text-center mb-3">Alarm {{index+1}}</h1>
          <p class="text-md">{{ parametertext + alarm.parameter }}</p>
          <p class="text-md">{{ categorytext + alarm.category }}</p>
          <p class="text-md">{{ realTimeValuetext + alarm.valueSinceLastUpdate }}</p>
          <p class="text-md">{{ settedUpValuetext+ alarm.settedUpValue }}</p>
          <button class="text-white bg-blue-regular font-medium rounded-lg my-3 text-sm px-5 py-2.5 text-center text-white-text" @click="deleteAlarm(alarm.id)">
            <font-awesome-icon icon="fa-solid fa-trash" class="w-5 h-5 text-black-text dark:text-white-text"/>
          </button>
        </div>
      </div>
    </div>
    <div v-else class="flex flex-col mx-auto">
      <h1 class="text-2xl">There are currently no alarms. You can make one by clicking underneath!</h1>
      <div class="mx-auto mt-5">
        <button class="text-white bg-blue-regular font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text" id="slide_start_button" @click="openPop()">
          <font-awesome-icon icon="fa-solid fa-plus" />
        </button>
      </div>
    </div>
    </div>
  <AddAlarms v-if="this.add"></AddAlarms>
</template>
<script>
import AddAlarms from "@/components/modals/updateAlarms";
import AlarmService from "@/services/alarm.service";

import {library} from "@fortawesome/fontawesome-svg-core";
import {faPlus, faTrash} from "@fortawesome/free-solid-svg-icons";
library.add(faPlus, faTrash)

export default {
  components: {AddAlarms},
  mounted() {
    this.getAlarms();
  },
  data() {
    return {
      parametertext: "Parameter: ",
      categorytext: "Category: ",
      realTimeValuetext: "Real time value: ",
      settedUpValuetext: "Setted up value: ",
      star: "⭐",
      remove: "Delete",
      alarms: [],
      select: false,
      add: false,
      selectedalarm:"",
    }
  },
  methods: {
    openPop(){
      this.add = true;
    },
    getAlarms() {
      AlarmService.getAll()
          .then(response => {
            this.alarms = response.data
            console.log(response.data)
          })
          .catch(e => {
            console.log(e)
          })
    },
    deleteAlarm(index){
      AlarmService.delete(index)
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
</style>
