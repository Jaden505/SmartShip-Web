import {createRouter, createWebHashHistory} from "vue-router";
import Home from "@/components/Home";
import PowerUsage from "@/components/ships/PowerUsage";

const routes = [
    {path : "/", component: Home},
    {path : "/ships/power-usage", component: PowerUsage},
];

export const router = createRouter({
    history : createWebHashHistory(),
    routes
})