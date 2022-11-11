<template>
  <NavBar/>
  <div class="px-6 py-16 mx-auto sm:max-w-xl md:max-w-full lg:max-w-screen-xl md:px-24 lg:px-8 lg:py-20">
    <div class="flex flex-col lg:flex-row">
      <div class="mb-3 lg:max-w-lg lg:pr-5 lg:mb-0">
        <div class="max-w-xl mb-6">
          <h2 class="title text-transparent text-center bg-clip-text bg-gradient-to-r from-regular-blue to-light-blue max-w-lg mb-6 text-5xl font-sans font-bold tracking-tight sm:text-4xl md:text-6xl lg:text-7xl sm:leading-none lg:text-start sm:text-start md:text-start">
            {{title}}
          </h2>
          <p class="subtitle text-light-text text-center font-sans text-2xl sm:text-2xl md:text-3xl lg:text-3xl md:text-lg lg:text-start sm:text-start md:text-start">
            {{subtitle}}
          </p>
        </div>
      </div>
      <div class="flex items-center w-full max-w-md px-6 mx-auto lg:w-2/6">
        <div class="flex-1">
          <Form @submit="handleLogin" :validation-schema="schema">
            <div class="form-group mt-6">
              <Field name="username" type="text" class="form-control block w-full px-4 py-2 mt-2 text-gray-700 placeholder-gray-400 bg-white border border-gray-200 rounded-md dark:placeholder-gray-600 dark:bg-gray-900 dark:text-gray-300 dark:border-gray-700 focus:border-blue-400 dark:focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
              <ErrorMessage name="username" class="error-feedback" />
            </div>
            <div class="form-group mt-6">
              <Field name="password" type="password" class="form-control block w-full px-4 py-2 mt-2 text-gray-700 placeholder-gray-400 bg-white border border-gray-200 rounded-md dark:placeholder-gray-600 dark:bg-gray-900 dark:text-gray-300 dark:border-gray-700 focus:border-blue-400 dark:focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
              <ErrorMessage name="password" class="error-feedback" />
            </div>

            <div class="flex justify-between mt-2">
              <a href="#" class="text-sm text-gray-400 focus:text-blue-500 hover:text-blue-500 hover:underline">Forgot password?</a>
            </div>

            <div class="form-group">
              <button class="btn btn-primary btn-block" :disabled="loading">
            <span
                v-show="loading"
                class="spinner-border spinner-border-sm"
            ></span>
                <span>Login</span>
              </button>
            </div>

            <div class="form-group">
              <div v-if="message" class="alert alert-danger" role="alert">
                {{ message }}
              </div>
            </div>

            <div class="mt-4">
              <button class="w-full font-bold px-4 py-2 tracking-wide text-dark-blue rounded-md bg-gradient-to-r from-regular-blue to-blue-700 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800 shadow-lg shadow-blue-500/50 dark:shadow-lg dark:shadow-blue-800/80">
                Sign in
              </button>
            </div>

          </Form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { Form, Field, ErrorMessage } from "vee-validate";
import * as yup from "yup";

export default {
  name: "Login-Screen",
  components: {
    Form,
    Field,
    ErrorMessage,
  },
  data () {
    const schema = yup.object().shape({
      username: yup.string().required("Username is required!"),
      password: yup.string().required("Password is required!"),
    });

    return {
      email: '',
      password: '',
      title: 'Welcome to SmartShip Dashboard',
      subtitle: 'Your journey starts here! Just sign-in and enjoy your trip!',
      forgot_password: 'Forgot Password ?',
      sign_in: 'SIGN-IN',
      loading: false,
      message: '',
      schema,
    }
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  created() {
    if (this.loggedIn) {
      this.$router.push("/ship");
    }
  },
  methods: {
    handleLogin(user) {
      this.loading = true;

      this.$store.dispatch("auth/signin", user).then(
          () => {
            this.$router.push("/ships/");
          },
          (error) => {
            this.loading = false;
            this.message =
                (error.response &&
                    error.response.data &&
                    error.response.data.message) ||
                error.message ||
                error.toString();
          }
      );
    },
  },
};
</script>

<style scoped>
.main {
  height: 100%;
  padding-bottom: 12vh;
}

.row {
  height: 100%;
}

.column {
  height: 100%;
  text-align: center;
}

.forgotPassword {
  color: #E0E1DD;
}

h1 {
  font-size: 5rem;
  background-color: #0061FF;
  background-image: linear-gradient(45deg, #0061FF, #60EFFF);
  background-size: 100%;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}
h3 {
  font-size: 1.7rem;
  color: #E0E1DD;

}
</style>
