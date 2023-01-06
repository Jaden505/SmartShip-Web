<template>
  <button @click="isModalOpen = true">Open Modal</button>
  <Teleport to="#modal">
    <div class="modal-bg" v-if="isModalOpen">
      <div v-click-outside="onClickOutside" class="modal">
        <button @click="isModalOpen = false" class="close-modal-btn">x</button>
        <h1>PLease fill your email and click on the send button!</h1>
        <Form class="space-y-4 md:space-y-6" @submit="handleResetPassword" :validation-schema="schema">
          <div class="form-group">
            <Field name="email" type="text" class="form-control bg-gray-700 text-white-text sm:text-sm rounded-lg block w-full p-2.5" placeholder="Email"/>
          </div>
          <div class="form-group">
            <button class="text-white bg-blue-regular font-medium rounded-lg text-sm px-5 py-2.5 text-center" :disabled="loading">
                  <span
                      class="spinner-border spinner-border-sm"
                  ></span>
              <span class="font-semibold text-white-text">Send mail</span>
            </button>
          </div>
        </Form>
      </div>
    </div>
  </Teleport>
</template>

<script>
import { Form, Field, ErrorMessage } from "vee-validate";

export default {
  name: "ResetPassword",
  data() {
    return {
      isModalOpen: false,
    }
  },
  components: {
    Form,
    Field,
  },
  methods: {
    onClickOutside(event) {
      this.isModalOpen = false;
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

.close-modal-btn {
  position: absolute;
  top: 10px;
  right: 10px;
  background: none;
  border: none;
  cursor: pointer;
}

</style>