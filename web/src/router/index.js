import Vue from "vue"
import Router from "vue-router"
import HomePage from "@/components/HomePage";
import Login from "@/components/Login";
import Job from "@/components/Job";
import JobAdmin from "@/components/admin/JobAdmin";
import HomeAdmin from "@/components/admin/HomeAdmin";

Vue.use(Router)

export default new Router ({
    mode: 'history',
    routes: [
        {path: '/',name : ':Login', component: Login,alias:'/login'},
        {path: '/home',name : ':HomePage', component: HomePage},
        {path: '/job',name : ':Job', component: Job},
        {path: '/admin/job',name : ':JobAdmin', component: JobAdmin},
        {path: '/admin/home',name : ':HomeAdmin', component: HomeAdmin},
    ]
})