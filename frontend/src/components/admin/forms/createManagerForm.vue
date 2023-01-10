<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <Teleport to="#modal">
    <div class="modal-bg">
    <div class="modal p-10 rounded-md shadow-md bg-blue-regular dark:bg-black-light" v-motion-fade>
      <font-awesome-icon class="close-popup text-black-light dark:text-white-text" icon="fa-solid fa-xmark" @click="TogglePopup()"/>
      <h1 class="font-bold text-black-text dark:text-white-text">Create Manager</h1>
      <Form @submit="createOperator" :validation-schema="schema" class="w-full max-w-sm">
        <div v-if="!successful">

          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4" for="name">
                Name
              </label>
            </div>
            <div class="md:w-2/3">
              <Field name="username" type="text" class="form-control bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white" />
              <ErrorMessage name="username" class="error-feedback" />
            </div>
          </div>

          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4" for="email">
                Email
              </label>
            </div>
            <div class="md:w-2/3">
              <Field name="email" type="email" class="form-control bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white" />
              <ErrorMessage name="email" class="error-feedback" />
            </div>
          </div>

          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4" for="password">
                Password
              </label>
            </div>
            <div class="md:w-2/3">
              <Field name="password" type="password" class="form-control bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white" />
              <ErrorMessage name="password" class="error-feedback" />
            </div>
          </div>
          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label class="block text-black-light dark:text-white-text md:text-right mb-1 md:mb-0 pr-4" for="ship">
                Ship
              </label>
            </div>
            <div class="md:w-2/3">
              <select name="shipID" ref="shipID" class="block appearance-none w-full bg-white border border-gray-400 hover:border-gray-500 px-4 py-2 pr-8 rounded shadow leading-tight focus:outline-none focus:shadow-outline">
                <option :value=null></option>
                <option v-for="(ship,index) in ships" :key="index" :value="ship.id">{{ ship.name }}</option>
              </select>
            </div>
          </div>
          <div class="form-group md:flex md:items-center">
            <button class="shadow bg-blue-regular w-full mt-2 text-black-light dark:text-white-text font-bold py-2 px-4 rounded-md">
              Create
            </button>
          </div>
        </div>
      </Form>

      <div
          v-if="message"
          class="alert"
          :class="successful ? 'alert-success' : 'alert-danger'"
      >
        {{ message }}
      </div>
    </div>
  </div>
  </Teleport>
</template>

<script>
import ShipService from "@/services/ship.service";
import { Form, Field, ErrorMessage } from "vee-validate";

import {library} from "@fortawesome/fontawesome-svg-core";
import {faXmark} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/vue-fontawesome";

library.add(faXmark)

export default {
  name: "createManagerForm",
  props: ['TogglePopup'],
  components: {
    Form,
    Field,
    ErrorMessage,
    FontAwesomeIcon
  },

  data(){
    return {
      ships: [],
    }
  },

  methods: {
    createOperator(user) {
      user.role = "manager"; // Default manager role
      user.shipID = this.$refs.shipID.value; // Set ship id

      console.log(user)

      this.$store.dispatch("auth/register", user).then(
          () => {
            location.reload()
          },
          (error) => {
            this.loading = false;
            this.message =
                (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                error.message ||
                error.toString();

            alert(this.message)
          }
      );
    },

    getShips() {
      ShipService.getAll()
          .then(response => {
            this.ships = response.data;
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
    }
  },

  created() {
    this.getShips()
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

input:focus{
  border: 2px solid black;
}

select{
  width: 100%;
  padding: 1%;
}
</style>
