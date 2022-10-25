import {createRouter, createWebHashHistory} from "vue-router";
import Login from "@/components/Login";
import Clockin from "@/components/Clockin";
import Clockout from "@/components/Clockout";

const routes = [
    {path: "/",
        component: Login,
    },{path: "/Clockin",
        component: Clockin,
    },{path: "/Clockout",
        component: Clockout,
    }
];

export const router = createRouter({
    history : createWebHashHistory(),
    routes
})
