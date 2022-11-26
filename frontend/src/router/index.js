import {createRouter, createWebHashHistory} from "vue-router";

import Login from "@/components/Login";
import PowerUsage from "@/components/ship/PowerUsage";
import ShipInfo from "@/components/ship/Information";
import ManagerDashboard from "@/components/manager/ManagerDashboard";
import ManagerOperator from "@/components/manager/ManagerOperatorTable";
import ManagerShips from "@/components/manager/ManagerShipTable";
import ShipsTable from "@/components/ship/ShipsTable";
import Dashboard from "@/components/Dashboard";
import EngineInformation from "@/components/ship/charts-information/EngineInformation";
import NotificationOverview from "@/components/ship/NotificationOverview";
import Alarms from "@/components/ship/Alarms";

const routes = [
    {path : "/", component: Login},
    {path: "/dashboard",
        component: Dashboard,
        children: [
            {
                path: "/ship-overview",
                component: ShipsTable,
                props: true
            },
            {
                path: "/power-usage",
                component: PowerUsage,
                props: true
            },
            {
                path: "/info",
                component: ShipInfo,
                props: true
            },
            {
                path: "/engine-info",
                component: EngineInformation,
                props: true
            },

            {path : "/manager", component: ManagerDashboard,
                children: [
                    {path: "/manager/operators", component: ManagerOperator},
                    {path: "/manager/ships", component: ManagerShips}
            ]},
            {
                path: "/notification-Overview",
                component: NotificationOverview,
                props: true
            },
            {
                path: "/alarms",
                component: Alarms,
                props: true
            }
        ]
    }
]

export const router = createRouter({
    history : createWebHashHistory(),
    routes,
})

router.beforeEach((to, from, next) => {
    const publicPages = ['/'];
    const authRequired = !publicPages.includes(to.path);
    const loggedIn = localStorage.getItem('user');

    // trying to access a restricted page + not logged in
    // redirect to login page
    if (authRequired && !loggedIn) {
        next('/');
    } else {
        next();
    }
});
