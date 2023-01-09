<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <Teleport to="#modal">
    <div class="modal-bg">
    <div class="modal p-10 rounded-md shadow-md bg-blue-regular dark:bg-black-light" v-motion-fade>
      <td class="material-icons close-popup" @click="TogglePopup()">close</td>
      <h1 class="font-bold text-black-text dark:text-white-text">Create Manager</h1>
      <Form @submit="createOperator" :validation-schema="schema" class="w-full max-w-sm">
        <div v-if="!successful">

          <div class="md:flex md:items-center mb-6">
            <div class="md:w-1/3">
              <label class="block text-black-text dark:text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="name">
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
              <label class="block text-black-text dark:text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="email">
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
              <label class="block text-black-text dark:text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="password">
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
              <label class="block text-black-text dark:text-gray-500 md:text-right mb-1 md:mb-0 pr-4" for="ship">
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
  </Teleport>
</template>

<script>
import ShipService from "@/services/ship.service";
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
  padding: 20px 50px;
  border-radius: 5px;
  box-shadow: 0px 10px 5px 2px rgba(0,0,0, 0.1);
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
