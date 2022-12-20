<template>
  <transition name="dropdown-content">
    <div
        v-if="active"
        class="mt-2 w-30 bg-white-text rounded-lg border py-2 px-2 text-left"
    >
      <slot/>
    </div>
  </transition>
</template>

<script>
export default {
  name: "DropdownMenuContent",
  inject: ["sharedState"],
  computed: {
    active() {
      return this.sharedState.active;
    }
  }
}
</script>

<style scoped>
.dropdown-content-enter-active,
.dropdown-content-leave-active {
  transition: all 0.2s;
}
.dropdown-content-enter,
.dropdown-content-leave-to {
  opacity: 0;
  transform: translateY(-5px);
}
</style>