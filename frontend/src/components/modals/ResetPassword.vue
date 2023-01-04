<template>
  <button class="text-white-text text-sm" @click="isModalOpen = true">Forgot Password?</button>
  <Teleport to="#modal">
    <div class="modal-bg" v-if="isModalOpen">
      <div v-click-outside="onClickOutside" class="modal p-10 rounded-md shadow-md bg-black-light">
<!--        <div>-->
<!--          <h1 class="text-white-text py-2 font-bold leading-tight tracking-tight text-2xl">Please fill your email and click on the send button!</h1>-->
<!--          <button @click="isModalOpen = false" class="close-modal-btn">x</button>-->
<!--        </div>-->
        <div class="flex items-start justify-between rounded-t pb-4">
          <h3 class="text-xl font-semibold text-white-text">
            Please fill your email!
          </h3>
          <button @click="isModalOpen = false" type="button" class="text-gray-400 bg-transparent rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white" data-modal-hide="defaultModal">
            <svg aria-hidden="true" class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>
            <span class="sr-only">Close modal</span>
          </button>
        </div>
        <Form class="space-y-2 md:space-y-4" @submit="handleResetPassword(this.email)">
          <div class="form-group">
            <Field name="email" v-model="email" type="text" class="form-control bg-gray-700 text-white-text sm:text-sm rounded-lg block w-full p-2.5" placeholder="Email"/>
          </div>
          <div class="form-group">
            <button class="bg-blue-regular font-medium rounded-lg text-sm px-5 py-2.5 text-center">
              <span class="font-semibold text-white-text">Send</span>
            </button>
          </div>
        </Form>
      </div>
    </div>
  </Teleport>
</template>

<script>
import { Form, Field, ErrorMessage } from "vee-validate";
import authService from "@/services/auth.service";

export default {
  name: "ResetPassword",
  data() {
    return {
      isModalOpen: false,
      email: null,
    }
  },
  components: {
    Form,
    Field,
  },
  methods: {
    onClickOutside(event) {
      this.isModalOpen = false;
    },
    handleResetPassword(email) {
      console.log(email)
      authService.resetPassword(email).then(response => {
        console.log(response)
      })
    }
  }
}
</script>

<style>
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
  padding: 50px 100px;
  border-radius: 5px;
  box-shadow: 0px 10px 5px 2px rgba(0,0,0, 0.1);
}

</style>