<template>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <div class="col-md-12 popup rounded-lg">
    <div class="card card-container popup-inner">
      <td class="material-icons close-popup" @click="TogglePopup()">close</td>

      <Form @submit="createOperator" :validation-schema="schema">
        <div v-if="!successful">
          <div class="form-group">
            <label for="username">Username</label>
            <Field name="username" type="text" class="form-control" />
            <ErrorMessage name="username" class="error-feedback" />
          </div>
          <div class="form-group">
            <label for="email">Email</label>
            <Field name="email" type="email" class="form-control" />
            <ErrorMessage name="email" class="error-feedback" />
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <Field name="password" type="password" class="form-control" />
            <ErrorMessage name="password" class="error-feedback" />
          </div>

          <div class="form-group">
            <button class="text-white bg-blue-light-card focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text" :disabled="loading">
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
  name: "createUserForm",
  props: ['TogglePopup'],
  components: {
    Form,
    Field,
    ErrorMessage,
  },

  data(){
    return {
      ships: []
    }
  },

  methods: {
    createOperator(user) {
      user.roleID = 1;
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

            console.log(this.message)
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
  background: #151515;
  padding: 4%;
}

h1{
  color: white;
}

label{
  width: 100%;
  text-align: center;
  color: lightgrey;
}

input{
  width: 100%;
  padding: 1%;
  text-align: center;
  margin-bottom: 20px;
}

select{
  width: 100%;
  padding: 1%;
  text-align: center;
}

button{
  margin-top: 10%;
  width: 100%;
}

.close-popup {
  padding-bottom: 20px;
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
</style>
