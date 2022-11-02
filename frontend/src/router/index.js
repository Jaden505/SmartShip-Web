import {createRouter, createWebHashHistory} from "vue-router";
import Login from "@/components/Login";
import PowerUsage from "@/components/ship/PowerUsage";
import ShipInfo from "@/components/ship/Information";
import Ships from "@/components/Ships";
import ShipsTable from "@/components/ship/ShipsTable";
import ShipsList from "@/components/ShipList";
import ManagerDashboard from "@/components/manager/ManagerDashboard";

const routes = [
    {path : "/", component: Login},
    {path : "/ships/", component: Ships},
    {path : "/ships/power-usage", component: PowerUsage},
    {path : "/ships/info", component: ShipInfo},
    {path : "/ships/ship-overview", component: ShipsTable},
    {path : "/ships/ship-list", component: ShipsList},

    {path: "/manager", component: ManagerDashboard}
]

export const router = createRouter({
    history : createWebHashHistory(),
    routes
})
