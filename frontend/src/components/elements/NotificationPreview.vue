<!-- @author: Joli-Coeur Weibolt  Notification-Preview Component -->
<template>
  <div id="container">
    <div class="preview bg-blue-regular dark:bg-black-light">
      <h1 class="text-black-text dark:text-white-text">Notifications</h1>
      <hr size="10" width="90%" color="white">
      <!--The preview of all the notifications-->
      <div v-for="(notification, index) in notifications"
           :key="index">
        <h2 class="text-black-text dark:text-white-text">{{ notification.title }}</h2>
        <p class="text-black-text dark:text-white-text">.......</p>
        <hr size="10" width="90%" color="white">
      </div>
      <router-link class="see_more text-black-text dark:text-white-text" @click="closePreview" to="/notification-overview">See More</router-link>
    </div>
  </div>
</template>

<script>
import NotificationService from "@/services/notification.service";

export default {
  name: "NotificationPreview",
  mounted() {
    this.getNotifications();
  },
  data() {
    return {
      notifications: [],
    }
  },
  methods: {
    getNotifications() {
      NotificationService.getAll()
          .then(response => {
            this.notifications = response.data
            console.log(response.data)
          })
          .catch(e => {
            console.log(e)
          })
    },
    closePreview() {
      this.$emit('close')
    }
  }
}
</script>

<style scoped>
#container {
  display: block;
  position: absolute;
  top: 10%;
  right: 9%;
  z-index: 100;
}
.preview{
  padding: 6%;
  width: 180px;
  border-radius: 10px;
}
.see_more{
 margin-left: 25%;
}
</style>
