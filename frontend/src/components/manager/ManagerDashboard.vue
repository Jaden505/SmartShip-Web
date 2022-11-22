<template>
  <ManagerNav></ManagerNav>

  <div class="welcome">
    <h1>Welcome Manager</h1>
  </div>

  <router-view></router-view>
</template>

<script>
import ManagerNav from "@/components/manager/ManagerNav";

export default {
  name: "ManagerDashboard",
  components: {
    ManagerNav,
  },

  data(){
    return{
      isActive: false
    }
  },

  methods: {

  }
}
</script>

<style scoped>

.welcome{
  margin-top: 1%;
  margin-bottom: 1%;
}

h1{
  color: white;
  text-align: center;
}



</style>