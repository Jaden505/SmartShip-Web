import {createRouter, createWebHashHistory} from "vue-router";
import Login from "@/components/Login";
import PowerUsage from "@/components/ship/PowerUsage";
import ShipInfo from "@/components/ship/Information";
import ListShips from "@/components/ship/ListShips";

const routes = [
    {path: "/", component: Login},
    {path : "/ships/", component: ListShips},
    {path : "/ships/power-usage", component: PowerUsage},
    {path : "/ships/info", component: ShipInfo},
];

export const router = createRouter({
    history : createWebHashHistory(),
    routes
})
