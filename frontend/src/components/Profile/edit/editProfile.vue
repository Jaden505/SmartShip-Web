<template>
  <Teleport to="#modal">
    <div class="modal-bg">
      <div class="modal p-10 rounded-md shadow-md bg-blue-regular dark:bg-black-light">
        <td class="material-icons close-popup" @click="TogglePopup()">close</td>

        <h1>Edit personal data</h1>

        <form class="w-full max-w-sm">

          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label class="block text-black-500 md:text-right mb-1 md:mb-0 pr-4">
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
              <label class="block text-black-500 md:text-right mb-1 md:mb-0 pr-4">
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
              <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4">
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
              <label class="block text-black-500 md:text-right mb-1 md:mb-0 pr-4">
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
              <label class="block text-black-500 md:text-right mb-1 md:mb-0 pr-4">
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
              <label class="block text-black-500 md:text-right mb-1 md:mb-0 pr-4">
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
              <label class="block text-black-500 md:text-right mb-1 md:mb-0 pr-4">
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
              <label class="block text-black-500 md:text-right mb-1 md:mb-0 pr-4">
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
              <label class="block text-black-500 md:text-right mb-1 md:mb-0 pr-4">
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
            <button class="bg-gray-700 dark:bg-blue-regular font-medium rounded-lg text-sm px-5 py-2.5 text-center"
                    type="button"
                    @click=" updateUser">
              <span class="font-semibold text-white-text">Update</span>
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
.modal-bg {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100vh;

  background-color: rgba(0,0,0, 0.5);

  display: flex;
  justify-content: center;
  align-items: center;
}

.modal {
  position: relative;
  background: white;
  padding: 50px 100px;
  border-radius: 5px;
  box-shadow: 0px 10px 5px 2px rgba(0,0,0, 0.1);
}

.close-popup {
  padding-bottom: 20px;
}

.close-popup:hover {
  color: lightgrey;
  cursor: pointer;
}

h1 {
  color: white;
  text-align: center;
  font-size: 24px;
  margin-bottom: 5%;
}

label {
  width: 100%;
  text-align: center;
  color: white;
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

button {
  margin-top: 10%;
  width: 100%;
  background-color: white;
  transition: background-color 0.5s;
}

button:hover {
  background-color: lightskyblue;
}

</style>