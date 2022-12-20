import Vue from "vue"
import Router from "vue-router"
import HomePage from "@/components/HomePage";
import Login from "@/components/Login";
import Job from "@/components/Job";

Vue.use(Router)

export default new Router ({
    mode: 'history',
    routes: [
        {path: '/',name : ':Login', component: Login,alias:'/login'},
        {path: '/home',name : ':HomePage', component: HomePage},
        {path: '/job',name : ':Job', component: Job},
    ]
})