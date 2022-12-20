<template>
  <button @click="toggle">
    <slot name="toggler">
    </slot>
    <slot/>
  </button>
</template>

<script>
export default {
  name: "DropdownMenu",
  provide() {
    return {
      sharedState: this.sharedState
    };
  },
  data() {
    return {
      sharedState: {
        active: false
      }
    };
  },
  methods: {
    toggle() {
      this.sharedState.active = !this.sharedState.active;
    }
  }
};
</script>

<style scoped>
</style>