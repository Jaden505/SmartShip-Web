import { createApp } from 'vue'
import { MotionPlugin } from '@vueuse/motion'
import { router } from "@/router";
import App from './App.vue'
import store from './store';
// import VeeValidate from 'vee-validate';
import './assets/styles/app.css'

import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

const app = createApp(App)

// app.use(VeeValidate)
app.component('font-awesome-icon', FontAwesomeIcon)
app.use(store)
app.use(MotionPlugin)
app.use(router)
app.mount('#app')
