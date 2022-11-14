<template>
  <div class="flex">
    <SideBar/>
    <div class="w-full h-screen">
      <nav class="px-5 pt-5">
        <div class="flex justify-between items-center">
          <h2 class="text-white-text font-semibold">
            <span class="text-blue-regular">Good Morning</span> Bart Tynior
          </h2>
          <div class="flex gap-2">
            <form class="flex items-center">
              <label for="simple-search" class="sr-only">Search</label>
              <div class="relative w-full">
                <div class="flex absolute inset-y-0 left-0 items-center pl-3 pointer-events-none">
                  <svg aria-hidden="true" class="w-5 h-5 text-gray-500 dark:text-gray-400" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z" clip-rule="evenodd"></path></svg>
                </div>
                <input type="text" id="simple-search" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full pl-10 p-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="Search" required>
              </div>
            </form>
          </div>
          <div class="flex gap-4 leading-normal">
            <div class="relative pt-2">
              <font-awesome-icon icon="fa-solid fa-bell" class="w-6 h-6 text-white-text"/>
            </div>
            <div class="relative px-2 pt-2">
              <font-awesome-icon icon="fa-solid fa-moon" class="w-6 h-6 text-white-text"/>
            </div>
            <img class="p-1 w-10 h-10 rounded-full ring-2 ring-gray-300 dark:ring-gray-500" src="../assets/img/example_user.jpg" alt="Bordered avatar">
            <div>
              <h3 class="text-white-text font-medium">Sam Smith</h3>
              <span class="text-white-disabled">Operator</span>
            </div>
          </div>
        </div>
      </nav>
      <div class="w-full h-100%">
        <div class="px-5 py-5">
          <router-view>

          </router-view>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import SideBar from "@/components/SideBar";
import {library} from "@fortawesome/fontawesome-svg-core";
import {faBell, faMoon} from "@fortawesome/free-solid-svg-icons";
library.add(faMoon, faBell)

export default {
  name: "DashBoard",
  components: {
    SideBar
  }
}
</script>

<style scoped>

</style>