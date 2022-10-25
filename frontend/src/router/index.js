import {createRouter, createWebHashHistory} from "vue-router";
import Login from "@/components/Login";

const routes = [
    {path: "/",
        component: Login}
];

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
