<template>
  <div class="flex-container">

    <div v-for="(alarm, index) in alarms" :key="index" class="flex-box">
      <button id="edit" @click="showModal(alarm)">Edit</button>
      <div class="Parameters">{{ parametertext + alarm.parameter }}</div>
      <div class="Parameters">{{ categorytext + alarm.category }}</div>
      <div class="Parameters">{{ realTimeValuetext + alarm.valueSinceLastUpdate }}</div>
      <div class="Parameters">{{ settedUpValuetext+ alarm.settedUpValue }}</div>
      <div class="flex">
        <button class="flex-child" id="slide_start_button">
          {{ star }}
        </button>

        <button class="flex-child" id="slide_stop_button" @click="deleteAlarm(alarm.id)">
          {{ remove }}
        </button>
        <!--        <input type="button" class="flex-child" id="slide_start_button">-->
        <!--        <input type="button" class="flex-child" id="slide_stop_button">-->
      </div>
    </div>
    <button class="flex-box" id="slide_start_button" @click="openPop()">
      <h1>+</h1>
    </button>
        <!--        <input type="button" class="flex-child" id="slide_start_button">-->
        <!--        <input type="button" class="flex-child" id="slide_stop_button">-->
    </div>
  <AddAlarms v-if="this.select" :alarm="this.selectedalarm" @cancel="cancelModal()" @update="updateAlarms(this.selectedalarm.id)"></AddAlarms>
  <AddAlarms v-if="this.add" :alarm="this.addedalarm" @cancel="cancelModal()" @click="addAlarm()"></AddAlarms>
</template>
<script>
import AddAlarms from "@/components/ship/updateAlarms";
import AlarmService from "@/services/AlarmService";

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
      remove: "X",
      alarms: [],
      select: false,
      add: false,
      selectedalarm:"",
      addedalarm: "",
    }
  },
  methods: {
    // Creating function
    showModal(alarm){
      this.selectedalarm = alarm;
      this.select = true;
    },
    cancelModal(){
      this.add = false;
      this.select = false;
      AlarmService;
    },
    openPop(){
      this.add = true;
    },
    addAlarm(){
      AlarmService.post()
          .then(response => {
            window.location.reload(true)
            console.log(response.data)
          })
          .catch(e => {
            console.log(e)
          })
    },

    updateAlarms(id) {
      AlarmService.put(id)
          .then(response => {
            window.location.reload(true)
            console.log(response.data)
          })
          .catch(e => {
            console.log(e)
          })
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
  background-color: #002C60;
  color: #0061FF;
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
  background-color: #1CD0FF;
  margin-left: 48%;
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

</style>
