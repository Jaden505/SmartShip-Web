import { createApp } from 'vue'
import { MotionPlugin } from '@vueuse/motion'
import {router} from "@/router";
import App from './App.vue'
import store from './store';
import './assets/styles/app.css'

const app = createApp(App)

app.use(store)
app.use(MotionPlugin)
app.use(router)
app.mount('#app')

