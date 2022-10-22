import {createRouter, createWebHashHistory} from "vue-router";
import Login from "@/components/Login";

const routes = [
    {path: "/",
        component: Login}
];

export const router = createRouter({
    history : createWebHashHistory(),
    routes
})
