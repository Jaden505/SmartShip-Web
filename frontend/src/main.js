import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import { MotionPlugin } from '@vueuse/motion'
import {router} from "@/router";
import App from './App.vue'
import store from './store';
// import VeeValidate from 'vee-validate';


import './assets/css/main.css'

const app = createApp(App)

// app.use(VeeValidate)
app.use(store)
app.use(MotionPlugin)
app.use(router)
app.use(ElementPlus)
app.mount('#app')
