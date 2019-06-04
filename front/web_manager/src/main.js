import Vue from 'vue';
import App from './App';
import router from './router';
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'; // 默认主题
// import '../static/css/theme-green/index.css';       // 浅绿色主题
import '../static/css/icon.css';
import "babel-polyfill";

Vue.use(ElementUI, {
    size: 'small'
});




//使用钩子函数对路由进行权限跳转
router.beforeEach((to, from, next) => {
    const role = sessionStorage.getItem('ms_username');
    // console.log(role,11)
    if (!role && to.path !== '/login') {
        next('/login');
    } else {
        next();
    }
})

//页面销毁时
// router.afterEach(function (to,from) {
   
// });

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app');
