import {createRouter, createWebHashHistory} from "vue-router";
import Login from "@/components/Login";
import PowerUsage from "@/components/ship/PowerUsage";
import ShipInfo from "@/components/ship/Information";
import ShipsList from "@/components/ShipList";
import ManagerDashboard from "@/components/manager/ManagerDashboard";
import ManagerOperator from "@/components/manager/ManagerOperatorTable";
import ManagerShips from "@/components/manager/ManagerShipTable";

const routes = [
    {path : "/", component: Login},
    {path : "/ships/", component: ShipsList},
    {path : "/ships/power-usage", component: PowerUsage},
    {path : "/ships/info", component: ShipInfo},
    {path : "/ships/ship-overview", component: ShipsList},
    {path : "/manager", component: ManagerDashboard,
    children: [
        {path: "/manager/operators", component: ManagerOperator},
        {path: "/manager/ships", component: ManagerShips}
    ]},

]

export const router = createRouter({
    history : createWebHashHistory(),
    routes
})
