<template>
  <div class="items-center text-center p-4 shadow-md bg-white rounded-md bg-blue-card-blue "
       v-for="(condition, index) in conditions" :key="index">
    <div>
      <h6 class="text-md font-semibold leading-none tracking-wider text-black-light dark:text-white-text pb-2">
        {{ condition.sensorName }}
      </h6>
      <span class="text-5xl font-semibold text-black-light dark:text-white-text">{{ condition.value }} {{ condition.unit }}</span>
    </div>
  </div>
  <h1 class="text-2xl text-black-light dark:text-white-text" v-if="lackData">Not enough data is provided to display this graph</h1>
</template>

<script>
import {toRaw} from "vue";

export default {
  name: "SeaConditions",
  props: ["sensordata"],
  watch: {
    sensordata: async function (newVal) {
      if (newVal !== null) {
        newVal = JSON.parse(newVal);
        this.conditions = await newVal.filter((sensor) => sensor["group"] === "Sea Conditions");

        if (toRaw(this.conditions) === []){
          this.lackData = true;
        }

        if (toRaw(this.conditions).length > 2)
          this.lackData = true;
      }
    }
  },

  data() {
    return {
      lackData: false,
      conditions: []
    }
  }
}
</script>

<style scoped>

</style>
