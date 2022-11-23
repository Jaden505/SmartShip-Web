<template>
  <div v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100">
        <div class="grid grid-cols-2 gap-8 w-100 p-4">
          <div class="bg-blue-card-blue p-4 rounded-md">
            <div class="pb-4">
              <h4 class="text-xl font-semibold text-white-text">Notifications</h4>
            </div>
            <div v-for="(notification, index) in notifications"
                 :key="index" class="bg-blue-nice shadow-lg rounded-md p-4 mb-2" :class="{'active': selectedNotification === notification}"
                 @click="setNotification(notification)">
              <h2>{{ notification.title }}</h2><!-- Date (Element)-->
              <span>
              {{new Date(notification.date).getDate()}}-{{new Date(notification.date).getMonth()+1}}-{{new Date(notification.date).getFullYear()}}
              {{new Date(notification.date).getHours()}}:{{new Date(notification.date).getMinutes()}}
            </span>
            </div>
          </div>
          <div class="bg-blue-card-blue p-4 rounded-md text-white-text">
            <div class="pb-4">
              <h4 class="text-xl font-semibold text-white-text">Details</h4>
            </div>
            <div>
              <h2>Engine 1</h2>
              <h3>{{ selectedNotification.temperature }}<span>C</span></h3>
              <section>
                <h2>Notification message</h2>
                <p>{{ selectedNotification.message }}</p>
              </section>
            </div>
          </div>
        </div>
  </div>
</template>

<script>
import NotificationService from "@/services/NotificationService";

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
}

</style>
