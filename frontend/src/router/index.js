import {createRouter, createWebHashHistory} from "vue-router";
import Login from "@/components/Login";
import Clockin from "@/components/Clockin";
import Clockout from "@/components/Clockout";

const routes = [
    {
        path: "/",
        component: Login,
    },
    {
        name: "Clockin",
        path: "/Clockin",
        component: Clockin,
    },
    {
        name: "Clockout",
        path: "/Clockout/:ship",
        component: Clockout,
        props: true
    }
];

export const router = createRouter({
    history : createWebHashHistory(),
    routes
})
