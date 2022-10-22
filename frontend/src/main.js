import { createApp } from 'vue'
import App from './App.vue'
import { router } from '../../backend/router'

createApp(App).use(router).mount('#app')
