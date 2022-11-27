<template>
  <div class="p-4" v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100">
    <ManagerNav></ManagerNav>
    <router-view></router-view>
  </div>
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