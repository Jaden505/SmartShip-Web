import {createRouter, createWebHashHistory} from "vue-router";
import Login from "@/components/Login";
import Clockin from "@/components/Clockin";

const routes = [
    {path: "/",
        component: Login,
    },{path: "/Clockin",
        component: Clockin,
    }
];

export const router = createRouter({
    history : createWebHashHistory(),
    routes
})
