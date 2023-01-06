<template>
  <div v-motion :delay="100"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :initial="{ opacity: 0, y: 100 }"
       :variants="{ custom: { scale: 2 } }"
       class="mt-4 p-4 relative">
    <div>
      <div class="row">
        <div class="col-8">
          <label class="btn btn-default p-0">
            <input
                type="file"
                accept="image/*"
                ref="file"
                @change="selectImage"
            />
          </label>
        </div>

        <div class="col-4">
          <button
              class="btn btn-success btn-sm float-right"
              :disabled="!currentImage"
              @click="upload"
          >
            Upload
          </button>
        </div>
      </div>
    </div>
    <div>
      <div class="px-4 flex right-0">
        <img alt="Bordered avatar" class="h-40 w-40 rounded-full ring-4 ring-black-basic" src="../../assets/img/example_user.jpg">
      </div>
      <div class="-mt-8">
        <div class="name-section rounded-t-md bg-blue-regular pt-12 pb-4 px-5">
          <h1 class="text-2xl">Raihan Saboerali</h1>
          <h2>Operator</h2>
        </div>
        <div class="bar shadow-lg bg-blue-regular flex rounded-b-md">
          <div :class="{active: personalActive}" class="tab px-5 py-2 rounded-t-md text-md">
            <router-link to="/profile/personal" @click="setPersonalActive">Personal</router-link>
          </div>
          <div :class="{active: shipActive}" class="tab px-5 py-2 rounded-t-md text-md">
            <router-link to="/profile/ship" @click="setShipActive">Ship</router-link>
          </div>
        </div>
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import UploadService from "@/services/upload.service";
import {toRaw} from "vue";

export default {
  name: "Profile",

  data() {
    return {
      personalActive: false,
      shipActive: false,
      currentImage: undefined,
    }
  },

  methods: {
    setPersonalActive() {
      this.personalActive = true;
      this.shipActive = false;
    },

    setShipActive() {
      this.shipActive = true;
      this.personalActive = false;
    },

    selectImage() {
      this.currentImage = this.$refs.file.files.item(0);
    },

    upload() {
      this.progress = 0;

      console.log(this.currentImage)
      let user = toRaw(this.$store.state.auth.user);

      UploadService.upload(this.currentImage, user.email)
          .then((response) => {
            console.log(response)
          })
          .then((images) => {
            this.imageInfos = images.data;
          })
          .catch((err) => {
            this.progress = 0;
            this.message = "Could not upload the image! " + err;
            this.currentImage = undefined;
          });
    },
  }
}
</script>

<style scoped>

.active {
  background-color: #202020;
  color: #E0E1DD;
  transition: background-color 0.6s;
}
</style>