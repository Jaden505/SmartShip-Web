<template>
  <NavBar/>
  <div class="px-6 py-16 mx-auto sm:max-w-xl md:max-w-full lg:max-w-screen-xl md:px-24 lg:px-8 lg:py-20">
    <div class="flex flex-col lg:flex-row">
      <div class="mb-3 lg:max-w-lg lg:pr-5 lg:mb-0">
        <div class="max-w-xl mb-6">
          <h2 class="title text-transparent text-center bg-clip-text bg-gradient-to-r from-blue-regular to-blue-light max-w-lg mb-6 text-5xl font-sans font-bold tracking-tight sm:text-4xl md:text-6xl lg:text-7xl sm:leading-none lg:text-start sm:text-start md:text-start">
            {{title}}
          </h2>
          <p class="subtitle text-white-text text-center font-sans text-2xl sm:text-2xl md:text-3xl lg:text-3xl md:text-lg lg:text-start sm:text-start md:text-start">
            {{subtitle}}
          </p>
        </div>
      </div>
      <div class="flex items-center w-full max-w-md px-6 mx-auto lg:w-2/6">
        <div class="flex-1">
            <form>
              <div>
                <input type="email" name="email" id="email" placeholder="example@example.com" class="block w-full px-4 py-2 mt-2 text-gray-700 placeholder-gray-400 bg-white border border-gray-200 rounded-md dark:placeholder-gray-600 dark:bg-gray-900 dark:text-gray-300 dark:border-gray-700 focus:border-blue-400 dark:focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
              </div>

              <div class="mt-6">
                <input type="password" name="password" id="password" placeholder="Your Password" class="block w-full px-4 py-2 mt-2 text-gray-700 placeholder-gray-400 bg-white border border-gray-200 rounded-md dark:placeholder-gray-600 dark:bg-gray-900 dark:text-gray-300 dark:border-gray-700 focus:border-blue-400 dark:focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
              </div>

              <div class="flex justify-between mt-2">
                <a href="#" class="text-sm text-gray-400 focus:text-blue-500 hover:text-blue-500 hover:underline">Forgot password?</a>
              </div>

              <div class="mt-4">
                <button class="w-full font-bold px-4 py-2 tracking-wide text-blue-dark rounded-md bg-gradient-to-r from-blue-regular to-blue-700 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800 shadow-lg shadow-blue-500/50 dark:shadow-lg dark:shadow-blue-800/80">
                  Sign in
                </button>
              </div>

            </form>
          </div>
        </div>
      </div>
    </div>
</template>

<script>
import User from '../models/user'
import NavBar from "@/components/NavBar";

export default {
  name: "Login-Screen",
  components: {
    NavBar
  },
  data () {
    return {
      user: new User('', ''),
      title: 'Welcome to SmartShip Dashboard',
      subtitle: 'Your journey starts here! Just sign-in and enjoy your trip!',
    }
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    }
  },
  created() {
    if (this.loggedIn) {
      this.$router.push('/profile');
    }
  },
  methods: {
    handleLogin() {
      this.loading = true;
      this.$validator.validateAll().then(isValid => {
        if (!isValid) {
          this.loading = false;
          return;
        }

        if (this.user.name && this.user.password) {
          this.$store.dispatch('/signin', this.user).then(
              () => {
                this.$router.push('/profile');
              },
              error => {
                this.loading = false;
                this.message =
                    (error.response && error.response.data) ||
                    error.message ||
                    error.toString();
              }
          );
        }
      });
    }
  }
}
</script>

<style scoped>
</style>
