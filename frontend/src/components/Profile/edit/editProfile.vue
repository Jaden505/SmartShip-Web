<template>
  <Teleport to="#modal">
    <div class="modal-bg">
      <div class="modal p-10 rounded-md shadow-md bg-purple-basic dark:bg-black-light">
        <font-awesome-icon class="close-popup text-black-light dark:text-white-text" icon="fa-solid fa-xmark" @click="TogglePopup()"/>
        <h1 class="font-bold text-black-text dark:text-white-text">Edit personal data</h1>

        <form class="w-full max-w-sm">

          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4">
                Firstname
              </label>
            </div>
            <div class="md:w-2/3">
              <input
                  v-model="current.firstname"
                  class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                  type="text">
            </div>
          </div>

          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4">
                Lastname
              </label>
            </div>
            <div class="md:w-2/3">
              <input
                  v-model="current.lastname"
                  class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                  type="text">
            </div>
          </div>

          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4">
                Gender
              </label>
            </div>
            <div class="md:w-2/3">
              <div class="inline-block relative w-48">
                <select
                    v-model="current.gender"
                    class="block appearance-none w-full bg-white border border-gray-400 hover:border-gray-500 px-4 py-2 pr-8 rounded shadow leading-tight focus:outline-none focus:shadow-outline">
                  <option value="Male">Male</option>
                  <option value="Female">Female</option>
                </select>
              </div>
            </div>
          </div>

          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4">
                Email
              </label>
            </div>
            <div class="md:w-2/3">
              <input
                  v-model="current.email"
                  class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                  type="text">
            </div>
          </div>

          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label class="block text-black-text dark:text-white-text md:text-right mb-1 md:mb-0 pr-4">
                Phone number
              </label>
            </div>
            <div class="md:w-2/3">
              <input
                  v-model="current.phoneNumber"
                  class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                  type="text">
            </div>
          </div>

          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4">
                Address
              </label>
            </div>
            <div class="md:w-2/3">
              <input
                  v-model="current.address"
                  class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                  type="text">
            </div>
          </div>

          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4">
                Postal Code
              </label>
            </div>
            <div class="md:w-2/3">
              <input
                  v-model="current.postalCode"
                  class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                  type="text">
            </div>
          </div>

          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4">
                City
              </label>
            </div>
            <div class="md:w-2/3">
              <input
                  v-model="current.city"
                  class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                  type="text">
            </div>
          </div>

          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4">
                Country
              </label>
            </div>
            <div class="md:w-2/3">
              <input
                  v-model="current.country"
                  class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                  type="text">
            </div>
          </div>

          <div class="md:flex md:items-center">
            <button class="shadow bg-blue-regular w-full mt-2 text-black-light dark:text-white-text font-bold py-2 px-4 rounded-md"
                    type="button"
                    @click=" updateUser">
              Update
            </button>
          </div>

        </form>
      </div>
    </div>
  </Teleport>
</template>

<script>
import userService from "@/services/user.service";
import {toRaw} from "vue";

import {library} from "@fortawesome/fontawesome-svg-core";
import {faXmark} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/vue-fontawesome";

library.add(faXmark)

export default {
  name: "editProfile",
  props: ['TogglePopup', 'user'],

  data() {
    return {
      current: this.user
    }
  },

  methods: {
    updateUser() {
      try {
        const id = toRaw(this.$store.state.auth.user.id)
        userService.updateProfile(id, this.current)
      } catch (e) {
        console.log(e.response.data)
      }
      this.TogglePopup()
    }
  }
}
</script>

<style scoped>
h1 {
  text-align: center;
  font-size: 24px;
  margin-bottom: 5%;
}

label {
  width: 100%;
  text-align: center;
}

input {
  width: 100%;
  padding: 1%;
}

input:focus {
  border: 2px solid black;
}

select {
  width: 100%;
  padding: 1%;
}

</style>
