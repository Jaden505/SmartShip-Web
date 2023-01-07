<template>

  <div class="popup">
    <div class="popup-inner">
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
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                type="text"
                v-model="current.firstname">
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
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                type="text"
                v-model="current.lastname">
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
                  class="block appearance-none w-full bg-white border border-gray-400 hover:border-gray-500 px-4 py-2 pr-8 rounded shadow leading-tight focus:outline-none focus:shadow-outline"
                  v-model="current.gender">
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
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                type="text"
                v-model="current.email">
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
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                type="text"
                v-model="current.phoneNumber">
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
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                type="text"
                v-model="current.address">
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
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                type="text"
                v-model="current.postalCode">
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
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                type="text"
                v-model="current.city">
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
                class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white"
                type="text"
                v-model="current.country">
          </div>
        </div>

        <div class="md:flex md:items-center">
          <button class="shadow focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded"
                  type="button"
                  @click=" updateUser">
            Update
          </button>
        </div>

      </form>

    </div>
  </div>
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
    updateUser(){
      try {
        const id = toRaw(this.$store.state.auth.user.id)
        userService.updateProfile(id, this.current)
      } catch (e){
        console.log(e.response.data)
      }
      this.TogglePopup()
    }
  }
}
</script>

<style scoped>

.popup {
  position: fixed;
  top: -20%;
  left: 0;
  right: 0;
  bottom: 0;
  z-index: 99;
  background-color: rgba(0, 0, 0, 0.6);

  display: flex;
  align-items: center;
  justify-content: center;
}

.popup-inner {
  background: #00111C;
  padding: 3%;
  border: 2px solid black;
  border-radius: 25px;
  box-shadow: 5px 5px black;
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

select{
  width: 100%;
  padding: 1%;
}

button {
  margin-top: 10%;
  width: 100%;
  background-color: white;
  transition: background-color 0.5s;
}

button:hover{
  background-color: lightskyblue;
}

</style>