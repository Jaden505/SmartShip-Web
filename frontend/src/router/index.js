import {createRouter, createWebHashHistory} from "vue-router";

import Login from "@/components/Login";
import Clockin from "@/components/Clockin";
import Clockout from "@/components/Clockout";
import PowerUsage from "@/components/ship/PowerUsage";
import ShipInfo from "@/components/ship/Information";
import Ships from "@/components/Ships";
import ShipsTable from "@/components/ship/ShipsTable";
import ShipsList from "@/components/ShipList";
import Dashboard from "@/components/Dashboard";

const routes = [
    {path : "/",
        component: Login},
    {path : "/ships/",
        component: Ships},
    {path : "/ships/ship-list",
        component: ShipsList},
    {path: "/Clockout/:ship",
        component: Clockout},
    {path: "/Clockin/",
        component: Clockin},
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
            }
        ]
    },
]

export const router = createRouter({
    history : createWebHashHistory(),
    routes,
    linkActiveClass: 'vue-active-link'
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
