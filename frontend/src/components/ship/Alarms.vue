<template>
  <div class="flex-container">

    <div v-for="(alarm, index) in alarms" :key="index" class="flex-box">
      <div class="Parameters">{{ parametertext + alarm.parameter }}</div>
      <div class="Parameters">{{ categorytext + alarm.category }}</div>
      <div class="Parameters">{{ realTimeValuetext + alarm.valueSinceLastUpdate }}</div>
      <div class="Parameters">{{ settedUpValuetext+ alarm.settedUpValue }}</div>
      <div class="flex">
        <button class="flex-child" id="slide_start_button">
          {{ star }}
        </button>

        <button class="flex-child" id="slide_stop_button">
          {{ remove }}
        </button>
        <!--        <input type="button" class="flex-child" id="slide_start_button">-->
        <!--        <input type="button" class="flex-child" id="slide_stop_button">-->
      </div>
    </div>

  </div>
</template>

<script>
import AlarmService from "@/services/AlarmService";

export default {
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
      alarms: []
    }
  },
  methods: {
    // Creating function
    getAlarms() {
      AlarmService.getAll()
          .then(response => {
            this.alarms = response.data
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
  background-color: #002C48;
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
