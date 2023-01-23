<template>
  <div class="flex w-full p-4 text-black-light dark:text-white-text ">

    <div class="flex" v-if="alarms.length !== 0">
      <div v-for="(alarm, index) in alarms" :key="index" @click="postNotification(alarm)" class="bg-purple-basic dark:bg-black-light rounded-md shadow-md w-[250px] m-3">
        <div class="p-4">
          <h1 class="text-xl text-center mb-3">Alarm {{index+1}}</h1>
          <p class="text-md">{{ parametertext + alarm.parameter }}</p>
          <p class="text-md">{{ categorytext + alarm.category }}</p>
          <p class="text-md">{{ settedUpValuetext+ alarm.settedUpValue }}</p>
          <button class="text-white bg-blue-regular font-medium rounded-lg my-3 text-sm px-5 py-2.5 text-center text-white-text" @click="deleteAlarm(alarm.id)">
            Delete
          </button>
        </div>
      </div>
      <div class="mx-auto mt-5">
        <button class="button" @click="openPop()">
          Add new alarm
        </button>
      </div>
    </div>
    <div v-else class="flex flex
    -col mx-auto">
      <h1 class="text-2xl">There are currently no alarms. You can make one by clicking underneath!</h1>
      <div class="mx-auto mt-5">
        <button class="text-white bg-blue-regular font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text" id="slide_start_button" @click="openPop()">
          Add new alarm
        </button>
      </div>
    </div>
    </div>
  <AddAlarms v-if="this.add" @onClickOutside="onClickOutside"></AddAlarms>
</template>
<script>
import AddAlarms from "@/components/ship/updateAlarms";
import AlarmService from "@/services/alarm.service";
export default {
  components: {AddAlarms},
  mounted() {
    this.getAlarms();
  },
  data() {
    return {
      parametertext: "Parameter: ",
      categorytext: "Category: ",
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
    onClickOutside(){
      this.add = false
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
            this.getAlarms()
            console.log(response.data)
          })
          .catch(e => {
            console.log(e)
          })
    },
    postNotification(alarm){
      alarm.date = new Date();
      AlarmService.postNotification(alarm)
          .then(response => {
            this.getAlarms()
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
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.flex {
  display: -webkit-box;
  display: -moz-box;
  display: -ms-flexbox;
  display: -webkit-flex;
  display: flex;
}

.button{
  height: 250px;
  width: 246px;
  border-radius: 5px;
  background-color: #202020;
  margin: 12px;
}
</style>