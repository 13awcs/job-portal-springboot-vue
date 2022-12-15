import Vue from "vue"
import Router from "vue-router"
import HomePage from "@/components/HomePage";
import Login from "@/components/Login";
import About from "@/components/About";
import Job from "@/components/Job";

Vue.use(Router)

export default new Router ({
    mode: 'history',
    routes: [
        {path: '/login',name : ':Login', component: Login},
        {path: '/',name : ':HomePage', component: HomePage},
        {path: '/job',name : ':Job', component: Job},
    ]
})