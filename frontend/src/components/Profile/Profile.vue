<template>
  <div v-motion :delay="100"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :initial="{ opacity: 0, y: 100 }"
       :variants="{ custom: { scale: 2 } }"
       class="mt-4 p-4 relative">
    <div>
      <div class="px-4 flex right-0">
        <AvatarInput @input="selectImage"/>
      </div>
      <div class="-mt-8">
        <div class="name-section rounded-t-md bg-purple-basic dark:bg-blue-regular pt-12 pb-4 px-5">
          <h1 class="text-2xl" v-if="user.firstname != null">{{ user.firstname + " " + user.lastname }}</h1>
          <h1 v-else class="text-2xl">User</h1>
          <h2 v-if="role === 'ROLE_USER'">User</h2>
          <h2 v-if="role === 'ROLE_MANAGER'">Manager</h2>
          <h2 v-if="role === 'ROLE_ADMIN'">Admin</h2>
        </div>
        <div class="bar shadow-lg bg-purple-basic dark:bg-blue-regular flex">
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
import UploadService from "@/services/upload.service";
import {toRaw} from "vue";
import AvatarInput from "@/components/Profile/AvatarInput";
import userService from "@/services/user.service";

export default {
  name: "Profile",
  components: {AvatarInput},
  data() {
    return {
      personalActive: false,
      shipActive: false,
      currentImage: undefined,
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

    selectImage(file) {
      console.log(file)
      let user = toRaw(this.$store.state.auth.user);

      UploadService.upload(file, user.email)
          .then((response) => {
            console.log(response);
            location.reload();
            }
          ).catch((err) => {
            this.progress = 0;
            this.message = "Could not upload the image! " + err;
            this.currentImage = undefined;
          });
    },

    getRole(){
      const role = toRaw(this.$store.state.auth.user.roles[0])
      this.role = role;
      return role;
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

  created() {
    this.getRole();
    this.getUser()
  }
}
</script>

<style scoped>
html.dark .active {
  background-color: #202020;
  color: #ffffff;
}

.active {
  background-color: #ffffff;
  color: #202020;
  transition: background-color 0.6s;
}
</style>
