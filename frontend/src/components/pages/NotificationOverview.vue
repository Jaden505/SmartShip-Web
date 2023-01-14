<template>
  <div v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100">
        <div class="flex w-full p-4">
          <div class="p-4 m-2 rounded-md w-1/3 bg-purple-basic dark:bg-black-light">
            <div class="pb-4">
              <h4 class="text-xl font-semibold text-black-text dark:text-white-text">Notifications</h4>
            </div>
            <div v-if="notifications.length === 0" class="inline w-5 h-5 text-black-text dark:text-white-text">
              You don't have any notifications.
            </div>
            <div v-for="(notification, index) in notifications"
                 :key="index" class="shadow-lg relative rounded-md p-4 mb-2"
                 :class="{'active bg-blue-lavender dark:bg-black-basic': selectedNotification === notification}"
                 @click="setNotification(notification)">
              <button class="absolute delete inset-y-0 right-0 flex items-center pr-4"
                      @click="deleteNotification(notification.id, notification.title, notification.shipId)">
                <font-awesome-icon icon="fa-solid fa-trash" class="w-5 h-5 text-black-text dark:text-white-text"/>
              </button>
              <div class="inline-block">
                <h4 v-if="notifications.length > 0" class="text-xl text-black-text dark:text-white-text">
                  {{ notification.title }}</h4>
                <span class="text-sm text-black-text dark:text-white-text">
              {{ ('0' + new Date(notification.date).getDate()).slice(-2)
                  }}-{{ ('0' + (new Date(notification.date).getMonth() + 1)).slice(-2)
                  }}-{{ new Date(notification.date).getFullYear()
                  }} {{ ('0' + new Date(notification.date).getHours()).slice(-2)
                  }}:{{ ('0' + new Date(notification.date).getMinutes()).slice(-2) }}
            </span>
              </div>

            </div>
          </div>
          <div v-if="notifications.length > 0"
               class="p-4 m-2 rounded-md bg-purple-basic dark:bg-black-light text-black-text dark:text-white-text w-2/3">
              <h2 class="text-2xl">{{selectedNotification.title}}</h2>
              <hr class="h-px my-2 bg-gray-700 border-0 dark:bg-gray-200">
              <section class="mt-5">
                <p>Category: {{selectedNotification.category}}</p>
                <p>Ship-id: {{selectedNotification.shipId}}</p>
                <p class="mb-5">Exceeding value: {{selectedNotification.value}} {{selectedNotification.unit}}</p>
                <h1 class="text-2xl">Notification message</h1>
                <p>{{ selectedNotification.message }}</p>
              </section>
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
            if(this.notifications.length > 0){
              this.selectedNotification = this.notifications[0]
            }
            else{
              this.selectedNotification = null
            }
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
</style>
