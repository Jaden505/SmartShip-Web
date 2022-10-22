import {createRouter, createWebHashHistory} from "vue-router";
import Home from "../../frontend/src/components/Home";
import PowerUsage from "../../frontend/src/components/ships/PowerUsage";
import ShipInfo from "../../frontend/src/components/ships/ShipInfo";

const routes = [
    {path : "/", component: Home},
    {path : "/ships/power-usage", component: PowerUsage},
    {path : "/ships/information", component: ShipInfo},
];

export const router = createRouter({
    history : createWebHashHistory(),
    routes
})