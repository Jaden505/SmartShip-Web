<template>
  <div class="box">
    <h1>PLease fill your email and click on the send button!</h1>
    <Form class="space-y-4 md:space-y-6" @submit="handleChangePassword()">
      <div class="form-group">
        <Field name="old_password" v-model="old_password" type="password" class="form-control bg-gray-700 text-white-text sm:text-sm rounded-lg block w-full p-2.5" placeholder="Old Password"/>
      </div>
      <div class="form-group">
        <Field name="new_password" v-model="new_password" type="password" class="form-control bg-gray-700 text-white-text sm:text-sm rounded-lg block w-full p-2.5" placeholder="New Password"/>
      </div>
      <div class="form-group">
        <button class="text-white bg-blue-regular font-medium rounded-lg text-sm px-5 py-2.5 text-center">
                  <span
                      class="spinner-border spinner-border-sm"
                  ></span>
          <span class="font-semibold text-white-text">Change Password</span>
        </button>
      </div>
    </Form>
  </div>
</template>

<script>
import { Form, Field } from "vee-validate";
import authService from "@/services/auth.service";

export default {
  name: "ChangePassword",
  components: {
    Form,
    Field,
  },
  data() {
    return {
      old_password: null,
      new_password: null,
      token: null
    }
  },
  created() {
    this.token = this.$route.query.token;
  },
  methods: {
    handleChangePassword(){
      authService.changePassword(this.new_password, this.old_password, this.token)
    }
  }
}
</script>

<style scoped>

</style>