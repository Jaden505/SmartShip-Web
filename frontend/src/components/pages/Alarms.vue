<template>
  <div class="flex-container" v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100">

    <div v-for="(alarm, index) in alarms" :key="index" class="flex-box">
      <!--      <button id="edit" @click="showModal(alarm)">Edit</button>-->
      <div class="Parameters">{{ parametertext + alarm.parameter }}</div>
      <div class="Parameters">{{ categorytext + alarm.category }}</div>
      <div class="Parameters">{{ realTimeValuetext + alarm.valueSinceLastUpdate }}</div>
      <div class="Parameters">{{ settedUpValuetext + alarm.settedUpValue }}</div>
      <div class="flex">
        <!--        <button class="flex-child" id="slide_start_button">-->
        <!--          {{ star }}-->
        <!--        </button>-->

        <button class="flex-child" id="slide_stop_button" @click="deleteAlarm(alarm.id)">
          {{ remove }}
        </button>
        <!--        <input type="button" class="flex-child" id="slide_start_button">-->
        <!--        <input type="button" class="flex-child" id="slide_stop_button">-->
      </div>
    </div>
    <button class="flex-box" id="slide_start_button" @click="openPop()">
      <svg class="plus" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><path d="M200 344V280H136C122.7 280 112 269.3 112 256C112 242.7 122.7 232 136 232H200V168C200 154.7 210.7 144 224 144C237.3 144 248 154.7 248 168V232H312C325.3 232 336 242.7 336 256C336 269.3 325.3 280 312 280H248V344C248 357.3 237.3 368 224 368C210.7 368 200 357.3 200 344zM0 96C0 60.65 28.65 32 64 32H384C419.3 32 448 60.65 448 96V416C448 451.3 419.3 480 384 480H64C28.65 480 0 451.3 0 416V96zM48 96V416C48 424.8 55.16 432 64 432H384C392.8 432 400 424.8 400 416V96C400 87.16 392.8 80 384 80H64C55.16 80 48 87.16 48 96z"/></svg>
    </button>
    <!--        <input type="button" class="flex-child" id="slide_start_button">-->
    <!--        <input type="button" class="flex-child" id="slide_stop_button">-->
  </div>
  <AddAlarms v-if="this.add"></AddAlarms>
</template>
<script>
import AddAlarms from "@/components/modals/updateAlarms";
import AlarmService from "@/services/alarm.service";

export default {
  components: {AddAlarms},
  async created() {
    await AlarmService.getAll()
        .then(response => {
          this.alarms = response.data
          console.log(response.data)
        })
        .catch(e => {
          console.log(e)
        })

    const userShip = JSON.parse(window.localStorage.getItem('user')).ship.toString();
    if (userShip === null || userShip === undefined) {
      this.currentShip = null;
    } else {
      this.currentShip = userShip;
    }

    console.log(this.currentShip)

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
      currentShip: null
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
    onClickOutside(){
      this.add = false
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
