import {createRouter, createWebHashHistory} from "vue-router";
import Home from "@/components/Home";
import PowerUsage from "@/components/ships/PowerUsage";
import ShipInfo from "@/components/ships/ShipInfo";

const routes = [
    {path : "/", component: Home},
    {path : "/ships/power-usage", component: PowerUsage},
    {path : "/ships/information", component: ShipInfo},
];

export const router = createRouter({
    history : createWebHashHistory(),
    routes
})