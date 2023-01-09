<template>
  <div v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100">
        <div class="flex w-full p-4">
          <div class="p-4 m-2 rounded-md w-1/3 bg-blue-regular dark:bg-black-light">
            <div class="pb-4">
              <h4 class="text-xl font-semibold text-black-text dark:text-white-text">Notifications</h4>
            </div>
            <!-- Using v-for to loop through the notifications -->
            <div v-for="(notification, index) in notifications"
                 :key="index" class="shadow-lg text-black-text dark:text-white-text rounded-md p-4 mb-2"
                 :class="{'active bg-blue-700 dark:bg-black-basic': selectedNotification === notification}"
                 @click="setNotification(notification)">
              <button class="delete md:p-0 lg:p-2"
                      @click="deleteNotification(notification.id, notification.title, notification.shipId)">
                <font-awesome-icon icon="fa-solid fa-trash" class="w-6 h-6 text-black-text dark:text-white-text"/>
              </button>
              <h2 class="text-xl">{{ notification.title }}</h2>

              <!--Using the data and the Date constructor to show the date and time of the notification-->
              <span class="text-sm">
              {{ ('0' + new Date(notification.date).getDate()).slice(-2)
                }}-{{ ('0' + (new Date(notification.date).getMonth() + 1)).slice(-2)
                }}-{{ new Date(notification.date).getFullYear()
                }} {{ ('0' + new Date(notification.date).getHours()).slice(-2)
                }}:{{ ('0' + new Date(notification.date).getMinutes()).slice(-2) }}
            </span>
            </div>
          </div>
          <!--Notification message-->
          <div class="p-4 m-2 rounded-md text-black-text dark:text-white-text w-2/3">
            <div>
              <h2 class="text-2xl">{{selectedNotification.title}}</h2>
              <section class="mt-5">
                <h3 class="text-2xl">{{selectedNotification.category}}</h3>
                <h3>About the ship with id: {{selectedNotification.shipId}}</h3>
                <h3>Current value: {{selectedNotification.value}} {{selectedNotification.unit}}</h3>
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
import {library} from "@fortawesome/fontawesome-svg-core";
import {faTrash} from "@fortawesome/free-solid-svg-icons";
library.add(faTrash)

export default {
  mounted() {
    this.getNotifications();
  },
  name: "NotificationOverview",
  data() {
    return {
      notifications: [],
      selectedNotification: "",
    }
  },
  methods: {
    setNotification(notification) {
      this.selectedNotification = notification
    },
    deleteNotification(id, title, shipId) {
      if (confirm("Are you sure you want to delete this notification?\n" +"Title: " + title + "\nShip-id: " + shipId)){
        NotificationService.delete(id)
            .then(() => {
              this.getNotifications();
            })
            .catch(e => {
              console.log(e)
            })
      }
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
.delete{
  float: right;
  margin-right: -1rem;
}
</style>
