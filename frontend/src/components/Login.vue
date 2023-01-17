<template>
  <div>
    <nav>
      <Header/>
    </nav>
    <div class="px-6 py-16 mx-auto sm:max-w-xl md:max-w-full lg:max-w-screen-xl md:px-24 lg:px-8 lg:py-20">
      <div class="flex flex-col lg:flex-row">
        <div class="mb-3 lg:max-w-lg lg:pr-5 lg:mb-0">
          <div class="max-w-xl mb-6">
            <h2 class="title text-transparent text-center bg-clip-text bg-gradient-to-r from-blue-regular to-blue-light max-w-lg mb-6 text-5xl font-sans font-bold leading-tight tracking-tight sm:text-4xl md:text-6xl lg:text-7xl sm:leading-none lg:text-start sm:text-start md:text-start">
              Welcome to SmartShip Dashboard
            </h2>
            <p class="subtitle text-black-text dark:text-white-text text-center font-sans leading-tight tracking-tight text-2xl sm:text-2xl md:text-3xl lg:text-3xl md:text-lg lg:text-start sm:text-start md:text-start">
              Your Journey Begins With Just One Click!
            </p>
          </div>
        </div>
        <div class="flex items-center w-full px-6 mx-auto lg:w-3/6">
          <div class="w-full rounded-md shadow-md md:mt-0 sm:max-w-md xl:p-0 bg-purple-light dark:bg-black-light">
            <div class="p-6 space-y-4 md:space-y-6 sm:p-8">
              <h1 class="text-black-text dark:text-white-text font-bold leading-tight tracking-tight md:text-3xl">
                Sign in to your account
              </h1>
              <Form class="space-y-4 md:space-y-6" @submit="handleLogin">
                <div class="form-group">
                  <label id="username" for="username" class="block mb-2 text-sm font-medium text-black-text dark:text-white-text">Your username</label>
                  <Field name="username" type="text" class="form-control bg-gray-700 text-white-text sm:text-sm rounded-lg block w-full p-2.5" placeholder="Username"/>
                  <ErrorMessage name="username" class="error-feedback" />
                </div>
                <div class="form-group">
                  <label id="password" for="password" class="block mb-2 text-sm font-medium text-black-text dark:text-white-text">Password</label>
                  <Field name="password" type="password" class="form-control bg-gray-700 text-white-text sm:text-sm rounded-lg block w-full p-2.5" placeholder="Password"/>
                  <ErrorMessage name="password" class="error-feedback" />
                </div>
                <div class="form-group">
                  <button id="submit_button" class="text-white bg-blue-regular font-medium rounded-lg text-sm px-5 py-2.5 text-center">
                    <span class="font-semibold text-white-text">Sign In</span>
                  </button>
                </div>
                <div class="form-group">
                  <div v-if="message" class="alert alert-danger text-black-text dark:text-white-text" role="alert">
                    {{ message }}
                  </div>
                </div>
              </Form>
              <ResetPassword/>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { Form, Field, ErrorMessage } from "vee-validate";
import ResetPassword from "@/components/modals/ResetPassword";
import Header from "@/components/Header";
// import * as yup from "yup";

export default {
  name: "Login-Screen",
  components: {
    Header,
    ResetPassword,
    Form,
    Field,
    ErrorMessage,
  },
  data() {
    // const schema = yup.object().shape({
    //   username: yup.string().required("Username is required!"),
    //   password: yup.string().required("Password is required!"),
    // });
    return {
      message: "",
      // schema,
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  created() {
    if (this.loggedIn) {
      this.$router.push('/dashboard');
    }
  },
  methods: {
    handleLogin(user) {
      this.loading = true;

      this.$store.dispatch("auth/login", user).then(
          () => {
            this.$router.push("/power-usage");
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
</style>
