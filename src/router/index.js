import {createRouter, createWebHashHistory} from "vue-router";
import Home from "@/components/Home";
import Login from "@/components/Login";

const routes = [
    {path : "/",
        component: Home},
    {path: "/login",
        component: Login}
];

export const router = createRouter({
    history : createWebHashHistory(),
    routes
})