import Vue from 'vue';
import Router from 'vue-router';
import { mapState, mapMutations } from 'vuex'

const main = r => require.ensure([], () => r(require('../view/common/Home.vue')), '')

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            redirect: '/login'
        },
        {
            path: '/Home',
            component: main,
            meta: {
                title: '自述文件'
            },
            children: [
                
                //首页
                {
                    path: '/Dashboard',
                    component: resolve => require(['../view/Dashboard.vue'], resolve),
                    meta: {
                        title: '首页'
                    }
                },


                // 模块管理
                {
                    path: '/module/banner', meta: { title: 'banner管理' },
                    component: resolve => require(['../view/module/banner.vue'], resolve)
                },
                {
                    path: '/module/boy', meta: { title: '男生专区管理' },
                    component: resolve => require(['../view/module/boy.vue'], resolve)
                },   
                {
                    path: '/module/girl', meta: { title: '女生专区管理'},
                    component: resolve => require(['../view/module/girl.vue'], resolve)
                },
                {
                    path: '/module/recommend', meta: { title: '推荐专区管理' },
                    component: resolve => require(['../view/module/recommend.vue'], resolve)
                },
                {
                    path: '/module/zoneDetail/:type?/:id?',
                    component: resolve => require(['../view/module/zoneDetail.vue'], resolve)
                },
                {
                    path: '/module/startup', meta: { title: '启动页管理' },
                    component: resolve => require(['../view/module/startup.vue'], resolve)
                },
                {
                    path: '/module/personal', meta: { title: '个人中心管理' },
                    component: resolve => require(['../view/module/personal/list.vue'], resolve)
                },
                {
                    path: '/module/personal/detail/:id?',
                    component: resolve => require(['../view/module/personal/detail.vue'], resolve)
                },
                {
                    path: '/module/welfare/:type?', meta: { title: '福利中心管理' },
                    component: resolve => require(['../view/module/welfare.vue'], resolve)
                },
                {
                    path: '/module/welfare/detail/:type?/:id?',
                    component: resolve => require(['../view/module/welfareDetail.vue'], resolve)
                },
                {
                    path: '/module/version', meta: { title: '版本管理' },
                    component: resolve => require(['../view/module/version.vue'], resolve)
                },
                {
                    path: '/module/popups', meta: { title: '弹窗配置' },
                    component: resolve => require(['../view/module/popups.vue'], resolve)
                },
                {
                    path: '/module/help', meta: { title: '帮助配置' },
                    component: resolve => require(['../view/module/help.vue'], resolve)
                },

                //用户管理
                {
                    path: '/user/list', meta: { title: '用户管理' },
                    component: resolve => require(['../view/user/list.vue'], resolve)
                },
                {
                    path: '/user/detail/:id?',
                    component: resolve => require(['../view/user/detail.vue'], resolve)
                },
                {
                    path: '/user/recharge', meta: { title: '用户充值' },
                    component: resolve => require(['../view/user/recharge.vue'], resolve)
                },
                {
                    path: '/user/analysis', meta: { title: '金豆红包统计' },
                    component: resolve => require(['../view/user/analysis.vue'], resolve)
                },

                //统计菜单
                {
                    path: '/statistics/active', meta: { title: '用户活跃统计' },
                    component: resolve => require(['../view/statistics/active.vue'], resolve)
                },
                {
                    path: '/statistics/firstRecharge', meta: { title: '首次充值详情' },
                    component: resolve => require(['../view/statistics/firstRecharge.vue'], resolve)
                },
                {
                    path: '/statistics/firstRegistration', meta: { title: '首次注册详情' },
                    component: resolve => require(['../view/statistics/firstRegistration.vue'], resolve)
                },
                {
                    path: '/statistics/orderAnalysis', meta: { title: '订单分析' },
                    component: resolve => require(['../view/statistics/orderAnalysis.vue'], resolve)
                },
                {
                    path: '/statistics/order', meta: { title: '订单统计' },
                    component: resolve => require(['../view/statistics/order.vue'], resolve)
                },
                {
                    path: '/statistics/retention', meta: { title: '用户留存统计' },
                    component: resolve => require(['../view/statistics/retention.vue'], resolve)
                },
                {
                    path: '/statistics/userAnalysis', meta: { title: '用户分析' },
                    component: resolve => require(['../view/statistics/userAnalysis.vue'], resolve)
                },
                {
                    path: '/statistics/userSource', meta: { title: '用户来源统计' },
                    component: resolve => require(['../view/statistics/userSource.vue'], resolve)
                },
                {
                    path: '/statistics/visitor', meta: { title: '访客实时统计' },
                    component: resolve => require(['../view/statistics/visitor.vue'], resolve)
                },

                //设置
                {
                    path: '/Permissionlist',
                    component: resolve => require(['../view/system/Permission.vue'], resolve),
                    meta: { title: '权限表' }
                },
                {
                    path: '/system/role', meta: { title: '权限管理' },
                    component: resolve => require(['../view/system/role.vue'], resolve)
                },
                {
                    path: '/system/user', meta: { title: '系统用户' },
                    component: resolve => require(['../view/system/user.vue'], resolve)
                },
                {
                    path: '/system/operateList', meta: { title: '操作记录' },
                    component: resolve => require(['../view/system/operateList.vue'], resolve)
                },


                //书籍管理
                {
                    path: '/books/list', meta: { title: '书籍管理' },
                    component: resolve => require(['../view/books/list.vue'], resolve)
                },
                {
                    path: '/books/detail/:id?',
                    component: resolve => require(['../view/books/detail.vue'], resolve)
                },


                //礼品管理
                {
                    path: '/gifts/list', meta: { title: '礼品管理' },
                    component: resolve => require(['../view/gifts/list.vue'], resolve)
                },
                {
                    path: '/gifts/detail/:id?',
                    component: resolve => require(['../view/gifts/detail.vue'], resolve)
                },
                {
                    path: '/gifts/exchangeList/:id?', meta: { title: '礼品兑换记录' },
                    component: resolve => require(['../view/gifts/exchangeList.vue'], resolve)
                },


                //会员管理
                {
                    path: '/member/goods', meta: { title: '商品管理' },
                    component: resolve => require(['../view/member/goods.vue'], resolve)
                },
                {
                    path: '/member/goods/detail/:id?',
                    component: resolve => require(['../view/member/goodsDetail.vue'], resolve)
                },
                {
                    path: '/member/buyRecord', meta: { title: '会员购买记录' },
                    component: resolve => require(['../view/member/buyRecord.vue'], resolve)
                },
                {
                    path: '/member/recharge', meta: { title: '充值会员' },
                    component: resolve => require(['../view/member/recharge.vue'], resolve)
                },


                //推送管理
                {
                    path: '/push/post', meta: { title: '推送管理' },
                    component: resolve => require(['../view/push/push.vue'], resolve)
                },
                {
                    path: '/push/communicate', meta: { title: '云通信账户' },
                    component: resolve => require(['../view/push/communicate.vue'], resolve)
                },
                {
                    path: '/push/communicate/add', meta: { title: '云通信账户 > 新增' },
                    component: resolve => require(['../view/push/communicateAdd.vue'], resolve)
                },
                {
                    path: '/push/feedback', meta: { title: '反馈管理' },
                    component: resolve => require(['../view/push/feedback.vue'], resolve)
                },

                // 邀请管理
                {
                    path: '/invite/list', meta: { title: '邀请管理' },
                    component: resolve => require(['../view/invite/index.vue'], resolve)
                },

                {
                    path: '/404',
                    component: resolve => require(['../view/err/404.vue'], resolve),
                    meta: {
                        title: '404'
                    }
                },
                {
                    path: '/403',
                    component: resolve => require(['../view/err/403.vue'], resolve),
                    meta: {
                        title: '403'
                    }
                },
            ]
        },
        {
            path: '/login',
            component: resolve => require(['../view/login/Login.vue'], resolve),
        },
        {
            path: '*',
            redirect: '/404'
        }
    ]
})


