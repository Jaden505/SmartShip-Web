<template>
  <div class="items-center text-center p-4 shadow-md bg-white rounded-md bg-blue-card-blue" v-for="(condition, index) in conditions" :key="index">
    <div>
      <h6 class="text-md font-semibold leading-none tracking-wider text-white-text pb-2">
        {{ condition.sensorName }}
      </h6>
      <span class="text-5xl font-semibold text-white-text">{{ condition.value }} {{ condition.unit }}</span>
    </div>
  </div>
</template>

<script>
export default {
  name: "SeaConditions",
  props: ["sensordata"],
  watch: {
    sensordata: async function (newVal) {
      if (newVal !== null) {
        newVal = JSON.parse(newVal);
        this.conditions = await newVal.filter((sensor) => sensor["group"] === "Sea Conditions");
        console.log(this.conditions)
      }
    }
  },

  data() {
    return {
      conditions: []
    }
  }
}
</script>

<style scoped>

</style>