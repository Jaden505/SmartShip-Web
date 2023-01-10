<template>
  <div v-motion-fade>
    <nav>
      <Header/>
    </nav>
    <div class="px-6 py-16">
        <div class="px-6">
          <div class="w-full flex mx-auto rounded-md shadow-md md:mt-0 sm:max-w-md xl:p-0 bg-purple-light dark:bg-black-light">
            <div class="p-6 space-y-4 md:space-y-6 sm:p-8">
              <h1 class="text-black-text dark:text-white-text font-bold leading-tight tracking-tight md:text-3xl">
                Change your password
              </h1>
              <Form class="space-y-4 md:space-y-6" @submit="handleChangePassword()">
                <div class="form-group">
                  <Field name="new_password" v-model="new_password" type="password" class="form-control bg-gray-700 text-white-text sm:text-sm rounded-lg block w-full p-2.5" placeholder="New Password"/>
                </div>
                <div class="form-group">
                  <button class="text-white bg-blue-regular font-medium rounded-lg text-sm px-5 py-2.5 text-center">
                    <span class="font-semibold text-white-text">Change Password</span>
                  </button>
                </div>
              </Form>
            </div>
          </div>
        </div>
      </div>
    </div>
</template>

<script>
import { Form, Field } from "vee-validate";
import authService from "@/services/auth.service";
import {useToast} from "vue-toastification";
import Header from "@/components/Header";

export default {
  name: "ChangePassword",
  components: {
    Header,
    Form,
    Field,
  },
  data() {
    return {
      new_password: null,
      token: null
    }
  },
  setup() {
    const toast = useToast();
    return { toast }
  },
  created() {
    this.token = this.$route.query.token;
  },
  methods: {
    async handleChangePassword(){
      await authService.changePassword(this.new_password, this.token);
      this.toast.success("You have successfully changed your password! You can now close this window and go back to th login page.")
    },
  }
}
</script>

<style scoped>

</style>