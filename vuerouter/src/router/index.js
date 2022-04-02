import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "../views/Login";

Vue.use(VueRouter)

const routes = [
  {
    path: '',
    redirect: '/Login'
  },
  {
    path: '/Login',
    component: () => import('../views/Login')
  },
  //父亲模板
  {
    path: '/User',
    component: () => import('../views/User'),
    children: [
      {
        path: '/User/Home',
        component: () => import('../components/Home/HomePage'),
        meta: {
          requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
        },

      }, {
        path: '/User/FatherSpendPage',
        component: () => import('../components/MeberComponents/SpendComponetns/FatherSpendPage'),
        meta: {
          requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
        },
      },
      {
        path: '/User/FatherIncomePage',
        component: () => import('../components/MeberComponents/IncomeComponents/FatherIncomePage'),
        meta: {
          requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
        },
      }, {
        path: '/User/PersonalPage',
        component: () => import('../components/Personal/PersonalPage'),
        meta: {
          requireAuth: true,  // 添加该字段，表示进入这个路由是需要登录的
        },
      }
    ]
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

