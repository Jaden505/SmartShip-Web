import {createRouter, createWebHashHistory} from "vue-router";
import Login from "@/components/Login";
import PowerUsage from "@/components/ship/PowerUsage";
import ShipInfo from "@/components/ship/Information";

const routes = [
    {path: "/", component: Login},
    {path : "/ships/PowerUsage", component: PowerUsage},
    {path : "/ships/Information", component: ShipInfo},
];

export const router = createRouter({
    history : createWebHashHistory(),
    routes
})
