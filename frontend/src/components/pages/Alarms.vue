<template>
  <div class="flex w-full p-4 text-black-light dark:text-white-text " v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100">

    <div class="flex" v-if="alarms.length !== 0">
      <div v-for="(alarm, index) in alarms" :key="index" @click="postNotification(alarm)" class="bg-purple-basic dark:bg-black-light rounded-md shadow-md w-[250px] m-3">
        <div class="p-4">
          <h1 class="text-xl text-center mb-3">Alarm {{index+1}}</h1>
          <p class="text-md">{{ parametertext + alarm.parameter }}</p>
          <p class="text-md">{{ categorytext + alarm.category }}</p>
          <p class="text-md">{{ settedUpValuetext+ alarm.settedUpValue }}</p>
          <button class="text-white bg-blue-regular font-medium rounded-lg my-3 text-sm px-5 py-2.5 text-center text-white-text" @click="deleteAlarm(alarm.id)">
            <font-awesome-icon icon="fa-solid fa-trash" class="w-5 h-5 text-black-text dark:text-white-text"/>
          </button>
        </div>
      </div>
      <div class="mx-auto mt-5">
        <button class="text-white bg-blue-regular font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text" id="slide_start_button" @click="openPop()">
          <font-awesome-icon icon="fa-solid fa-plus" />
        </button>
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

.flex-container {
  width: 100%;
  height: auto;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: center;
}

.flex-box {
  width: 320px;
  height: 170px;
  background-color: #343434;
  color: white;
  border-radius: 20px;
  margin: 20px;
  box-shadow: 0 3px 10px rgb(0 0 0 / 2);
}

.Parameters:first-child {
  padding-top: 10px;
}

.Parameters {
  margin-left: 15px;
  font-weight: 900;
}


/*new*/

.flex {
  display: -webkit-box;
  display: -moz-box;
  display: -ms-flexbox;
  display: -webkit-flex;
  display: flex;
}

.flex-child:first-child {
  background-color: #656565;
  color: #202020;
  margin-left: 73%;
}


.flex-child {
  border: none;
  padding: 4px;
  text-decoration: none;
  display: inline-block;
  margin-top: 20px;
  float: left;
  background-color: deeppink;
  width: 22%;
  border-radius: 8px;
  margin-left: 10px;
}

.plus{
  width: 90px;
  height: 90px;
  margin-left: 117px;
}

</style>
