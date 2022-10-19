import {createRouter, createWebHashHistory} from "vue-router";
import Home from "@/components/Home";
import Ships from "@/components/Ships";

const routes = [
    {path : "/", component: Home},
    {path: "/list", component: Ships}
];

export const router = createRouter({
    history : createWebHashHistory(),
    routes
})