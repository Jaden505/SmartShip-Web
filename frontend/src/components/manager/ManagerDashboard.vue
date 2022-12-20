<template>
  <div v-motion :delay="100"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :initial="{ opacity: 0, y: 100 }"
       :variants="{ custom: { scale: 2 } }"
       class="p-4">
    <DropdownMenu>
      <template v-slot:toggler>
        <button
            class="relative flex items-center focus:outline-none pl-5 pr-3 py-2 rounded-lg bg-gray-300 text-gray-800 font-semibold"
        >
          <h1 v-if="opIsActive === false && shIsActive === false">Click to choose the data!</h1>
          <h1 v-if="opIsActive">Operators</h1>
          <h1 v-if="shIsActive">Ships</h1>

          <svg
              class="ml-1 h-5 w-5 fill-current text-gray-700"
              viewBox="0 0 24 24"
              xmlns="http://www.w3.org/2000/svg"
          >
            <path
                d="M15.3 9.3a1 1 0 0 1 1.4 1.4l-4 4a1 1 0 0 1-1.4 0l-4-4a1 1 0 0 1 1.4-1.4l3.3 3.29 3.3-3.3z"
            ></path>
          </svg>
        </button>
      </template>
      <DropdownMenuContent>
        <div>
          <router-link :class="{active: opIsActive}" to="/manager/operators" @click="setOpActive">Operators</router-link>
        </div>
        <div>
          <router-link :class="{active: shIsActive}" to="/manager/ships" @click="setShActive">Ships</router-link>
        </div>
      </DropdownMenuContent>
    </DropdownMenu>
    <router-view></router-view>
  </div>
</template>

<script>
import DropdownMenu from "@/components/elements/DropdownMenu";
import DropdownMenuContent from "@/components/elements/DropdownMenuContent";

export default {
  name: "ManagerDashboard",
  components: {DropdownMenuContent, DropdownMenu},
  data() {
    return {
      isActive: false,
      opIsActive: false,
      shIsActive: false
    }
  },
  methods: {
    setOpActive() {
      this.shIsActive = false
      this.opIsActive = true
    },

    setShActive() {
      this.shIsActive = true
      this.opIsActive = false
    }
  }
}
</script>

<style scoped>
</style>
