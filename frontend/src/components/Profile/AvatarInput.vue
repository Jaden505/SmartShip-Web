<template>
  <div>
      <input
          type="file"
          accept="image/*"
          ref="file"
          @change="selectImage"
          class="hidden"
      />
      <div class="relative inline-block group ">
        <img alt="Bordered avatar" class="h-40 w-40 rounded-full ring-4 ring-blue-lavender dark:ring-black-basic" :src="this.avatarImage">
        <div class="absolute top-0 w-full h-full bg-black-basic bg-opacity-0 hover:bg-opacity-50 rounded-full flex items-center justify-center">
          <button @click="browse()" class="rounded-full invisible group-hover:visible hover:bg-white-text hover:bg-opacity-50 p-2 focus:outline-none">
            Browse
          </button>
        </div>
      </div>

    </div>


</template>

<script>
export default {
  name: "AvatarInput",
  inject: ['userImage'],
  data() {
    return {
      avatarImage: this.userImage
    }
  },
  methods: {
    browse() {
      this.$refs.file.click();
    },
    selectImage(e) {
      this.$emit('input', e.target.files[0]);
    }
  }
}
</script>

<style scoped>

</style>