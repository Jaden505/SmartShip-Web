<template>
  <div v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100">
        <div class="flex w-full p-4">
          <div class="bg-black-light p-4 m-2 rounded-md w-1/3">
            <div class="pb-4">
              <h4 class="text-xl font-semibold text-white-text">Notifications</h4>
            </div>
            <div v-for="(notification, index) in notifications"
                 :key="index" class="bg-black-light shadow-lg text-white-text rounded-md p-4 mb-2" :class="{'active': selectedNotification === notification}"
                 @click="setNotification(notification)">
              <h2 class="text-xl">{{ notification.title }}</h2><!-- Date (Element)-->
              <span class="text-sm">
              {{ ('0' + new Date(notification.date).getDate()).slice(-2) }}-{{ ('0' + (new Date(notification.date).getMonth() + 1)).slice(-2) }}-{{ new Date(notification.date).getFullYear() }}
                {{ ('0' + new Date(notification.date).getHours()).slice(-2) }}:{{ ('0' + new Date(notification.date).getMinutes()).slice(-2) }}
            </span>
            </div>
          </div>
          <div class="bg-black-light p-4 m-2 rounded-md text-white-text w-2/3">
            <div>
              <h2 class="text-2xl">{{selectedNotification.title}}</h2>
              <section class="mt-5">
                <h2 class="text-2xl">Notification message</h2>
                <p>{{ selectedNotification.message }}</p>
              </section>
            </div>
          </div>
        </div>
  </div>
</template>

<script>


import NotificationService from "@/services/notification.service";

export default {
  mounted() {
    this.getNotifications();
  },
  name: "NotificationOverview",
  data() {
    return {
      selected: false,
      notifications: [],
      selectedNotification: "",
    }
  },
  methods: {
    setNotification(notification) {
      this.selectedNotification = notification
      this.selected = true
    },
    getNotifications() {
      NotificationService.getAll()
          .then(response => {
            this.notifications = response.data
            this.selectedNotification = this.notifications[0]
            console.log(response.data)
          })
          .catch(e => {
            console.log(e)
          })
    },
  }
}
</script>

<style scoped>

.active {
  background: #dddddd;
  color: #202020;
}

</style>
