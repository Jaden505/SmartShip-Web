<template>
  <div class="p-4" v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100">
        <div class="d-flex mb-5">
          <router-link class="text-white text-md px-3 py-2 mr-3 font-semibold rounded bg-blue-regular" to="/manager/operators" @click="setOpActive" :class="{active: opIsActive}">Operators</router-link>
          <router-link to="/manager/ships" class="text-white px-3 py-2 text-md font-semibold rounded bg-blue-regular" @click="setShActive" :class="{active: shIsActive}">Ships</router-link>
        </div>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "ManagerDashboard",

  data(){
    return{
      isActive: false,
      opIsActive: false,
      shIsActive: false
    }
  },
  methods: {
    setOpActive(){
      this.shIsActive = false
      this.opIsActive = true
    },

    setShActive(){
      this.shIsActive = true
      this.opIsActive = false
    }
  }
}
</script>

<style scoped>
</style>
