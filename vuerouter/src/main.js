import Vue from 'vue'
import App from './App.vue'
import Vuex from 'vuex'
import router from './router'
import Element from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import * as echarts from 'echarts'
import request from "./utils/request";
import VCalendar from 'v-calendar';
//和这一行：
Vue.prototype.$echarts = echarts
/*组件通信*/

Vue.prototype.$eventBus = new Vue();
Vue.prototype.$request = request;
// 引入日历插件
/*Vue[vuex] must call Vue.use(Vuex) before creating a store instance.
* 在创建Vuex 实例之前 必须先加载到Vue中
* */
Vue.use(Vuex)
Vue.use(VCalendar);
Vue.config.productionTip = false
Vue.use(Element);
/*全局数据*/
/*关于Vuex*/
// Vue.prototype.$store = new Vuex.Store({
//   state: {
//     familyid: null,
//     familyname: null,
//   },
// })

router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {  // 判断该路由是否需要登录权限
    // console.log(1112, sessionStorage.getItem('familyname'), Vue.prototype.$store.state.familyname)
    if (sessionStorage.getItem('familyname') != null) {  // 通过vuex state获取当前的family是否存在
      next();
    } else {
      next({
        path: '/Login',
      })
    }
  } else {
    next();
  }
})

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
