<!-- @author: Joli-Coeur Weibolt & Milos Mihajlović   Notification Overview Component -->
<template>
  <div v-motion
       :initial="{ opacity: 0, y: 100 }"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :variants="{ custom: { scale: 2 } }"
       :delay="100">
    <div class="flex w-full p-4 text-black-text dark:text-white-text">
      <div class="p-4 m-2 rounded-md w-1/3 bg-purple-basic dark:bg-black-light">
        <div class="pb-4">
          <h4 class="text-xl font-semibold">Notifications</h4>
        </div>
        <!--We show the text below only if the user has no notifications-->
        <div v-if="notifications.length === 0" class="inline w-5 h-5">
          You don't have any notifications.
        </div>
        <!--We loop through the notifications and show them in a list with a delete button for each notification-->
        <div v-for="(notification, index) in notifications"
             :key="index" class="shadow-lg relative rounded-md p-4 mb-2"
             :class="{'active bg-blue-lavender dark:bg-black-basic': selectedNotification === notification}"
             @click="setNotification(notification)">
          <!--The delete button-->
          <button class="absolute delete inset-y-0 right-0 flex items-center pr-4"
                  @click="deleteNotification(notification.id, notification.title, notification.shipId)">
            <font-awesome-icon icon="fa-solid fa-trash" class="w-5 h-5"/>
          </button>
          <div class="inline-block">
            <h4 class="text-xl">
              {{ notification.title }}</h4>
            <span class="text-sm">
              {{('0' + new Date(notification.date).getDate()).slice(-2)
              }}-{{('0' + (new Date(notification.date).getMonth() + 1)).slice(-2)
              }}-{{new Date(notification.date).getFullYear()
              }} {{('0' + new Date(notification.date).getHours()).slice(-2)
              }}:{{('0' + new Date(notification.date).getMinutes()).slice(-2) }}
            </span>
          </div>
        </div>
      </div>
      <!--We show the div below only if the user has a notification-->
      <div v-if="notifications.length > 0"
           class="p-4 m-2 rounded-md bg-purple-basic dark:bg-black-light w-2/3">
        <h2 class="text-2xl">{{ selectedNotification.title }}</h2>
        <hr class="h-px my-2 bg-gray-700 border-0 dark:bg-gray-200">
        <section class="mt-5">
          <p>Category: {{ selectedNotification.category }}</p>
          <p>Ship-id: {{ selectedNotification.shipId }}</p>
          <p class="mb-5">Exceeding value: {{ selectedNotification.value }} {{ selectedNotification.unit }}</p>
          <h1 class="text-2xl">Notification message</h1>
          <p>{{ selectedNotification.message }}</p>
        </section>
      </div>
    </div>
  </div>
</template>

<script>
import NotificationService from '@/services/notification.service'
import {library} from "@fortawesome/fontawesome-svg-core";
import {faTrash} from "@fortawesome/free-solid-svg-icons";

library.add(faTrash)
export default {
  name: "NotificationOverview",
  //Used created() to fetch the notifications from the backend
  //created is a lifecycle hook that is called after the component is created and can be
  //used to fetch data from the backend
  created() {
    this.getNotifications()
  },
  data() {
    return {
      notifications: [],
      selectedNotification: null,
    }
  },
  methods: {
    setNotification(notification) {
      this.selectedNotification = notification
    },
    deleteNotification(id, title, shipId) {
      if (confirm("Are you sure you want to delete this notification?\n" + "Title: " + title + "\nShip-id: " + shipId)){
        NotificationService.delete(id)
            .then(() => {
              //After the notification is deleted from the backend, we fetch the notifications again
              //so the deleted notification is not shown anymore
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
    }
  }
}
</script>
<style scoped>
</style>
