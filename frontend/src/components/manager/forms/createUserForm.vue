<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <div class="popup">
    <div class="popup-inner" v-motion-fade>
      <td class="material-icons close-popup" @click="TogglePopup()">close</td>
      <h1 class="font-bold">Create Manager</h1>
      <Form @submit="createOperator" :validation-schema="schema" class="w-full max-w-sm">
        <div v-if="!successful">

          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="name">
                Name
              </label>
            </div>
            <div class="md:w-2/3">
              <Field name="username" type="text" class="form-control" />
              <ErrorMessage name="username" class="error-feedback" />
            </div>
          </div>

          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="email">
                Email
              </label>
            </div>
            <div class="md:w-2/3">
              <Field name="email" type="email" class="form-control" />
              <ErrorMessage name="email" class="error-feedback" />
            </div>
          </div>

          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="password">
                Password
              </label>
            </div>
            <div class="md:w-2/3">
              <Field name="password" type="password" class="form-control" />
              <ErrorMessage name="password" class="error-feedback" />
            </div>
          </div>
          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label class="block text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="ship">
                Ship
              </label>
            </div>
            <div class="md:w-2/3">
              <select name="shipID" ref="shipID">
                <option :value=null></option>
                <option v-for="(ship,index) in ships" :key="index" :value="ship.id">{{ ship.name }}</option>
              </select>
            </div>
          </div>
          <div class="form-group md:flex md:items-center">
            <button class="shadow focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded" :disabled="loading">
              <span v-show="loading" class="spinner-border spinner-border-sm"></span>
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
</template>

<script>
import ShipService from "@/services/ShipService";
import { Form, Field, ErrorMessage } from "vee-validate";

export default {
  name: "createManagerForm",
  props: ['TogglePopup'],
  components: {
    Form,
    Field,
    ErrorMessage,
  },

  data(){
    return {
      ships: [],
    }
  },

  methods: {
    createOperator(user) {
      user.roleID = 1; // Default operator role
      user.shipID = this.$refs.shipID.value; // Set ship id

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
  transition: color 0.5s;
}

.close-popup:hover {
  color: lightgrey;
  cursor: pointer;
}

.close-popup {
  padding-bottom: 30px;
  color: lightgrey;
}

.close-popup:hover {
  color: grey;
  cursor: pointer;
}

/*Form*/

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

input:focus{
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
