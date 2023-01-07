<template>
  <div v-motion :delay="100"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :initial="{ opacity: 0, y: 100 }"
       :variants="{ custom: { scale: 2 } }"
       class="mt-4 p-4 relative">
    <div>
      <div class="px-4 flex right-0">
        <img alt="Bordered avatar" class="h-40 w-40 rounded-full ring-4 ring-black-basic" src="../../assets/img/example_user.jpg">
      </div>
      <div class="-mt-8">
        <div class="name-section rounded-t-md bg-blue-regular pt-12 pb-4 px-5">
          <h1 class="text-2xl">{{ user.firstname + " " + user.lastname }}</h1>
          <h2 v-if="role === 'ROLE_USER'">User</h2>
          <h2 v-if="role === 'ROLE_MANAGER'">Manager</h2>
          <h2 v-if="role === 'ROLE_ADMIN'">Admin</h2>
        </div>
        <div class="bar shadow-lg bg-blue-regular flex rounded-b-md">
          <div :class="{active: personalActive}" class="tab px-5 py-2 rounded-t-md text-md">
            <router-link to="/profile/personal" @click="setPersonalActive">Personal</router-link>
          </div>
          <div :class="{active: shipActive}" class="tab px-5 py-2 rounded-t-md text-md">
            <router-link to="/profile/ship" @click="setShipActive">Ship</router-link>
          </div>
        </div>
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import userService from "@/services/user.service";
import {toRaw} from "vue";

export default {
  name: "Profile",

  data() {
    return {
      personalActive: false,
      shipActive: false,
      role: null,
      user: {
        firstname: null,
        lastname: null
      }
    }
  },

  methods: {
    setPersonalActive() {
      this.personalActive = true;
      this.shipActive = false;
    },

    setShipActive() {
      this.shipActive = true;
      this.personalActive = false;
    },

    getRole(){
      const id = toRaw(this.$store.state.auth.user.id)
      userService.getUserById(id)
          .then(response => {
            this.role = response.data.role.name
          })
          .catch(e => {
            console.log(e)
          })
    },

    getUser(){
      const id = toRaw(this.$store.state.auth.user.id)
      userService.getUserById(id)
          .then(response => {
            this.user.firstname = response.data.firstname
            this.user.lastname = response.data.lastname
            console.log(response.data)
          })
          .catch(e => {
            console.log(e)
          })
    }
  },

  mounted() {
    this.getRole();
    this.getUser()
  }
}
</script>

<style scoped>

.active {
  background-color: #202020;
  color: #E0E1DD;
  transition: background-color 0.6s;
}
</style>