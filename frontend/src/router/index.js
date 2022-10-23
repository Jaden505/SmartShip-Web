import {createRouter, createWebHashHistory} from "vue-router";
import Login from "@/components/Login";
import Ships from "@/components/Ships";

const routes = [
    {path: "/",
        component: Login},
    { path: "/ships", component: Ships}
];

export const router = createRouter({
    history : createWebHashHistory(),
    routes
})
