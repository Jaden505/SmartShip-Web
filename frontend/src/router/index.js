import {createRouter, createWebHashHistory} from "vue-router";

import Login from "@/components/Login";
import Clockin from "@/components/Clockin";
import Clockout from "@/components/Clockout";
import PowerUsage from "@/components/ship/PowerUsage";
import ShipInfo from "@/components/ship/Information";
import Ships from "@/components/Ships";
import ShipsTable from "@/components/ship/ShipsTable";
import ShipsList from "@/components/ShipList";

const routes = [
    {path : "/", component: Login},
    {path : "/ships/", component: Ships},
    {path : "/ships/power-usage", component: PowerUsage},
    {path : "/ships/info", component: ShipInfo},
    {path : "/ships/ship-overview", component: ShipsTable},
    {path : "/ships/ship-list", component: ShipsList},
    {path: "/Clockout/:ship", component: Clockout},
    {path: "/Clockin/", component: Clockin},
]

export const router = createRouter({
    history : createWebHashHistory(),
    routes
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
