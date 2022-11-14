import {createRouter, createWebHashHistory} from "vue-router";

import Login from "@/components/Login";
import PowerUsage from "@/components/ship/PowerUsage";
import ShipInfo from "@/components/ship/Information";
import ShipsTable from "@/components/ship/ShipsTable";
import Dashboard from "@/components/Dashboard";
import Alarms from "@/components/ship/Alarms";

const routes = [
    {path : "/",
        component: Login},
    {path: "/Dashboard",
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
                path: "/Alarms",
                component: Alarms,
                props: true
            }
        ]
    },
]

export const router = createRouter({
    history : createWebHashHistory(),
    routes,
})

// router.beforeEach((to, from, next) => {
//     const publicPages = ["/"];
//     const authRequired = !publicPages.includes(to.path);
//     const loggedIn = localStorage.getItem('user');
//
//     // trying to access a restricted page + not logged in
//     // redirect to login page
//     if (authRequired && !loggedIn) {
//         next('/login');
//     } else {
//         next();
//     }
// });
