<template>
  <div v-motion-fade class="flex h-screen bg-blue-lavender dark:bg-black-basic">
    <!--  SIDEBAR LEFT  -->
    <SideBar/>
    <!--  CONTENT RIGHT  -->
    <div class="flex-1 h-full overflow-x-hidden overflow-y-auto">
      <!--  NAVBAR    -->
      <header class="relative">
        <div class="flex items-center justify-between p-4">
          <button type="button" class="transition-colors duration-200 rounded-md text-black-text dark:text-white-text md:hidden">
            <font-awesome-icon class="w-6 h-6" icon="fa-solid fa-bars" />
          </button>
          <div class="md:hidden">
            <router-link to="/power-usage">
              <svg xmlns="http://www.w3.org/2000/svg" width="150" viewBox="0 0 202.72 35.097">
                <g id="Group_1" data-name="Group 1" transform="translate(-100 -69.951)">
                  <path id="Path_1" data-name="Path 1" d="M608.4,432.734c-.774,2.789-1.614,5.562-2.292,8.375a1.593,1.593,0,0,1-1.962,1.467c-2.037-.111-4.085-.07-6.127-.01-.821.024-1.126-.271-1.327-1.043-.724-2.779-1.527-5.537-2.3-8.3a1.022,1.022,0,0,0-.4-.623v9.879h-6.765V417.441c.342-.024.675-.068,1.008-.069,2.355-.005,4.71.031,7.064-.019.82-.018,1.114.278,1.316,1.056,1.4,5.392,2.865,10.768,4.309,16.149a2.49,2.49,0,0,0,.507,1.051q.985-3.784,1.968-7.568,1.263-4.875,2.52-9.751c.12-.462.175-.928.879-.92,2.8.032,5.6.013,8.49.013V443.53c-2.072-.289-4.119-.549-6.149-.9-.212-.037-.468-.608-.473-.934-.04-2.666-.026-5.332-.028-8q0-.461,0-.922Z" transform="translate(-463.647 -347.401)" fill="#e0e1dd"/>
                  <path id="Path_2" data-name="Path 2" d="M752.834,434.435h-8.523v11.718c-2.118-.171-4.17.548-5.965-.79a1.549,1.549,0,0,1-.61-1.034c-.033-7.374-.057-14.749,0-22.123.022-3.05,1.659-4.679,4.728-4.738q6.073-.116,12.151-.014c3.2.056,4.8,1.661,4.821,4.858.055,7.236.018,14.472.037,21.708,0,.574-.16.907-.745,1.037-1.578.351-3.146.75-4.728,1.087-.876.187-1.2-.178-1.184-1.118.057-3.115.021-6.232.021-9.348Zm-.008-6.222a16.272,16.272,0,0,0-.046-2.676,1.393,1.393,0,0,0-.958-.92c-2.176-.084-4.358-.074-6.535-.008a1.222,1.222,0,0,0-.912.74,23.094,23.094,0,0,0-.044,2.864Z" transform="translate(-582.855 -347.442)" fill="#e0e1dd"/>
                  <path id="Path_3" data-name="Path 3" d="M1185.252,417.716h6.592v10.909h7.838v-10.9h6.545c.022.372.064.738.064,1.1,0,8.342-.013,16.684.008,25.026,0,.675-.159,1-.855,1.116-1.867.317-3.724.7-5.723,1.076V435.4h-7.828v10.979c-2.124,0-4.152.012-6.179-.024-.158,0-.4-.33-.443-.542a4.773,4.773,0,0,1-.018-1.034q0-12.825,0-25.649Z" transform="translate(-937.388 -347.689)" fill="#e0e1dd"/>
                  <path id="Path_4" data-name="Path 4" d="M1072.041,446.317c0-2.171-.028-4.27.044-6.365.007-.2.63-.54.971-.543,3.635-.04,7.272-.018,10.908-.031.7,0,1.7.253,1.87-.653a9.119,9.119,0,0,0-.133-3.132c-.035-.21-.825-.408-1.27-.416-2.389-.042-4.779-.011-7.168-.032a8.988,8.988,0,0,1-1.75-.173,3.811,3.811,0,0,1-3.414-3.751,89.613,89.613,0,0,1,.008-9.03c.152-2.693,1.8-4.15,4.5-4.186,4.743-.064,9.488-.018,14.232-.041.675,0,.919.251.909.915-.025,1.731-.039,3.464.008,5.194.022.814-.333.985-1.059.981-3.463-.023-6.926-.008-10.389,0-1.631,0-1.862.237-1.873,1.854q0,.208,0,.416c.006,1.735.19,1.928,1.887,1.931,2.216,0,4.433-.005,6.649,0a12.787,12.787,0,0,1,1.553.1,3.883,3.883,0,0,1,3.789,3.947c.114,2.938.111,5.888-.012,8.825a4.176,4.176,0,0,1-3.55,4.151,2.96,2.96,0,0,1-1.611-.077,18.713,18.713,0,0,0-14.658.063A2.625,2.625,0,0,1,1072.041,446.317Z" transform="translate(-847.676 -347.886)" fill="#29acd8"/>
                  <path id="Path_5" data-name="Path 5" d="M864.664,434.875V442.2l-6.53,1.449V417.533c.29-.024.586-.069.883-.07q7.06-.011,14.121-.009c.346,0,.692.021,1.037.043,2.746.18,4.361,1.713,4.5,4.465.1,2.036.084,4.084.012,6.123a3.767,3.767,0,0,1-2.754,3.74c2.458.828,2.953,2.618,2.9,4.755-.046,1.826-.01,3.655-.01,5.492-1.706,0-3.316.021-4.925-.005-1.859-.031-1.664.25-1.676-1.656-.008-1.384-.03-2.769.007-4.153.024-.91-.355-1.378-1.263-1.381C868.93,434.869,866.891,434.875,864.664,434.875Zm.075-6.165c2.212,0,4.352.02,6.49-.012a.912.912,0,0,0,.972-1.1c-.149-.99.579-2.181-.627-2.942a.4.4,0,0,0-.2-.036c-2.2,0-4.408,0-6.633,0Z" transform="translate(-678.261 -347.481)" fill="#e0e1dd"/>
                  <path id="Path_6" data-name="Path 6" d="M485.367,417.913c2.354,0,4.709.024,7.063-.016.82-.014,1.1.277,1.07,1.087-.05,1.522-.008,3.047-.019,4.57-.011,1.443-.02,1.441-1.519,1.441q-4.934,0-9.868,0c-1.713,0-1.918.21-1.924,1.9,0,.311.012.623,0,.935-.028.968.457,1.372,1.4,1.366,2.285-.014,4.57,0,6.856.005a15.345,15.345,0,0,1,1.555.063c2.569.273,4,1.66,4.1,4.236.105,2.731.022,5.47.021,8.2,0,.783-.3,1.16-1.175,1.195-5.878.235-11.754.518-17.631.793-1.5.07-1.5.082-1.5-1.426,0-.588.047-1.182-.011-1.765-.091-.907.25-1.207,1.17-1.2,3.462.045,6.925.018,10.387.016,2.327,0,2.424-.1,2.392-2.473-.02-1.5-.25-1.741-1.767-1.749-2.354-.012-4.709.007-7.063-.005-3.532-.019-5.145-1.642-5.143-5.154,0-2.251-.007-4.5.007-6.752.023-3.718,1.618-5.281,5.363-5.281Z" transform="translate(-373.763 -347.833)" fill="#29acd8"/>
                  <path id="Path_7" data-name="Path 7" d="M1356.308,441.093l-6.553.828V417.446h1.16q6.85,0,13.7,0c.45,0,.9.012,1.348.044,2.625.186,4.286,1.705,4.391,4.343.125,3.143.108,6.3.008,9.441a3.84,3.84,0,0,1-3.582,3.929,48.045,48.045,0,0,1-5.279.178c-1.69.025-3.38.005-5.193.005Zm.013-12.213c2.249,0,4.418.025,6.587-.013.74-.013,1.026-.59.929-1.237-.142-.947.574-2.119-.678-2.793a.44.44,0,0,0-.2-.044c-2.2,0-4.4,0-6.636,0Z" transform="translate(-1067.723 -347.474)" fill="#e0e1dd"/>
                  <path id="Path_8" data-name="Path 8" d="M987.345,417.9v7.223c-1.814,0-3.573.055-5.326-.021-.978-.042-1.215.3-1.21,1.234.036,6.125.018,12.249.018,18.374v1.307c-2.152-.638-4.145-1.2-6.1-1.854-.25-.084-.452-.7-.454-1.071-.029-5.536-.02-11.073-.02-16.609,0-1.357,0-1.359-1.336-1.36-1.686,0-3.373,0-5.129,0V417.9Z" transform="translate(-765.126 -347.835)" fill="#e0e1dd"/>
                  <path id="Path_9" data-name="Path 9" d="M848.19,549.7a8.606,8.606,0,0,1,1.073-.5,49.39,49.39,0,0,1,12.492-1.825,66.248,66.248,0,0,1,18.037,1.589c1.647.384,3.271.89,4.879,1.42a20.383,20.383,0,0,0,13.543-.06c4.058-1.434,8.06-.718,12.029.42a4.453,4.453,0,0,1,1.6.919c.66.567.533,1.029-.338,1.173-1.363.224-2.755.267-4.117.5-2.454.414-4.9.9-7.341,1.371-5.738,1.107-11.373.37-16.965-.975a115.58,115.58,0,0,0-26.6-3.436c-2.318-.01-4.636-.064-6.954-.114-.431-.009-.86-.1-1.29-.15Z" transform="translate(-670.383 -450.349)" fill="#e0e1dd"/>
                  <path id="Path_10" data-name="Path 10" d="M482.429,551.085a6.089,6.089,0,0,1,1.383-.43c3.659-.239,7.318-.479,10.981-.637,8.024-.347,16.053-.587,24.075-.983a25.56,25.56,0,0,1,16.426,5.1,3.215,3.215,0,0,1,.855.749,14.567,14.567,0,0,1,.809,1.575,6.079,6.079,0,0,1-1.717.27,37.048,37.048,0,0,1-3.766-.749,87.2,87.2,0,0,0-15.533-1.967q-14.57-.8-29.132-1.743c-1.456-.092-2.9-.4-4.346-.614Z" transform="translate(-380.628 -451.695)" fill="#e0e1dd"/>
                  <path id="Path_11" data-name="Path 11" d="M1302.384,417.8h6.564V419c0,7.541-.016,15.083.021,22.624,0,.932-.221,1.331-1.2,1.475-1.769.259-3.513.691-5.386,1.075Z" transform="translate(-1030.195 -347.759)" fill="#e0e1dd"/>
                  <path id="Path_12" data-name="Path 12" d="M1268.069,546.149a25.772,25.772,0,0,1,2.68-.957c5.885-1.422,11.757-2.908,17.68-4.153a7.682,7.682,0,0,1,8.1,3.273,1.356,1.356,0,0,1,.274.437c.142.579.25,1.167.37,1.751a6.372,6.372,0,0,1-1.742.181c-2.553-.445-5.073-1.132-7.639-1.439-4.532-.542-9.054.085-13.567.5-2.024.187-4.036.5-6.053.756Z" transform="translate(-1003.011 -445.237)" fill="#e0e1dd"/>
                </g>
              </svg>
            </router-link>
          </div>
          <h2 class="font-semibold inline-block hidden space-x-2 md:flex md:text-sm lg:text-base">
            <span class="text-blue-regular">Good Morning</span>  <span class="text-black-text dark:text-white-text">{{capitalizeFirstLetter(currentUser.username)}}</span>
          </h2>
          <nav class="hidden space-x-2 md:flex md:items-center">
            <button class="px-1" @click="showPreview()">
              <font-awesome-icon icon="fa-solid fa-bell" class="w-6 h-6 text-black-text dark:text-white-text"/>
            </button>
            <button class="px-1" @click="toggleDark()">
              <font-awesome-icon icon="fa-solid fa-circle-half-stroke" class="w-6 h-6 text-black-text dark:text-white-text" v-if="isDark" />
              <font-awesome-icon icon="fa-solid fa-moon" class="w-6 h-6 text-black-text dark:text-white-text" v-else/>
            </button>
            <router-link to="/profile">
              <img class="p-1 w-10 h-10 rounded-full ring-2 ring-blue-regular" :src="this.userImage" alt="Bordered avatar">
            </router-link>
            <div class="p-2 lg:text-base lg:inline-block md:hidden">
              <router-link to="/profile"><h3 class="text-black-text dark:text-white-text font-medium">{{capitalizeFirstLetter(currentUser.username)}}</h3></router-link>
              <div v-if="currentUser.roles[0] === 'ROLE_ADMIN'">
                <span class="text-black-text dark:text-white-text font-semibold">Admin</span>
              </div>
              <div v-else-if="currentUser.roles[0] === 'ROLE_MANAGER'">
                <span class="text-black-text dark:text-white-text font-semibold">Manager</span>
              </div>
              <div v-else>
                <span class="text-black-text dark:text-white-text font-semibold">Operator</span>
              </div>
            </div>
          </nav>
        </div>
      </header>
      <main>
        <div class="mt-2">
          <NotificationPreview id="preview" v-if="preview" @close="showPreview" @onClickOutside="onClickOutside"></NotificationPreview>
          <router-view>

          </router-view>
        </div>
      </main>
    </div>
  </div>
</template>

<script>
import {useDark, useToggle} from '@vueuse/core'
import SideBar from "@/components/SideBar";
import NotificationPreview from "@/components/elements/NotificationPreview";
import {library} from "@fortawesome/fontawesome-svg-core";
import {faBars, faBell, faGear, faMoon, faCircleHalfStroke, faUser} from "@fortawesome/free-solid-svg-icons";
import {computed, toRaw} from "vue";
import uploadService from "@/services/upload.service";

library.add(faMoon, faBell, faBars, faGear, faUser, faCircleHalfStroke)

export default {
  name: "DashBoard",
    provide() {
      return {
        userImage: computed(() => this.userImage)
      }
  },
  computed: {
    currentUser() {
      console.log(toRaw(this.$store.state.auth.user));
      return toRaw(this.$store.state.auth.user);
    }
  },
  data() {
    return {
      items: [
        {name: 'Power Usage', to: '/power-usage', icon: <font-awesome-icon icon="fa-solid fa-bolt" />
        },
        {name: 'Ship Information', to: '/ship-overview', icon: <font-awesome-icon icon="fa-solid fa-ship" />
        },
        {name: 'Rating', to: '/info', icon: <font-awesome-icon icon="fa-solid fa-star" />
        },
        {name: 'Manager', to: '/manager', icon: <font-awesome-icon icon="fa-solid fa-star" />
        }
      ],
      userImage: require('@/assets/img/default_user.png'),
      isDark: useDark(),
      preview: false
    }
  },
  components: {
    SideBar,
    NotificationPreview
  },
  created() {
    uploadService.getFile(this.currentUser.id).then(response => {
      this.userImage = "data:image/jpeg;base64," + response.data
    }).catch(e => {
      console.log(e)
    });
  },
  methods: {
    capitalizeFirstLetter(string) {
      return string.charAt(0).toUpperCase() + string.slice(1);
    },
    toggleDark() {
      this.isDark = !this.isDark
      useToggle(useDark(this.isDark))
    },
    showPreview() {
        this.preview = !this.preview
    },
    onClickOutside(){
      this.preview = false
    }
  }
}
</script>

<style scoped>
#preview{
  position: absolute;
  top: 10%;
  right:9%;
  z-index: 100;
}
</style>
