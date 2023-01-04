import { createApp } from 'vue'
import { MotionPlugin } from '@vueuse/motion'
import { router } from "@/router";
import App from './App.vue'
import store from './store';
import Toast, {POSITION} from "vue-toastification";
import "vue-toastification/dist/index.css";
// import VeeValidate from 'vee-validate';
import vClickOutside from "click-outside-vue3"
import './assets/styles/app.css'

import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

const app = createApp(App)

app.component('font-awesome-icon', FontAwesomeIcon)
app.use(store)
app.use(MotionPlugin)
app.use(router)
app.use(vClickOutside)
app.use(Toast);
// app.use(VeeValidate)
app.mount('#app')
