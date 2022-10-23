import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import { MotionPlugin } from '@vueuse/motion'
import {router} from "@/router";
import App from './App.vue'

import './assets/css/main.css'

const app = createApp(App)

app.use(MotionPlugin)
app.use(router)
app.use(ElementPlus)
app.mount('#app')