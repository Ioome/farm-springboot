import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import qukuai from '@/views/modules/qukuai/list'
    import news from '@/views/modules/news/list'
    import zhongzhi from '@/views/modules/zhongzhi/list'
    import discussqukuai from '@/views/modules/discussqukuai/list'
    import huanjing from '@/views/modules/huanjing/list'
    import storeup from '@/views/modules/storeup/list'
    import zhiwu from '@/views/modules/zhiwu/list'
    import yonghu from '@/views/modules/yonghu/list'
    import discusszhiwu from '@/views/modules/discusszhiwu/list'
    import discussgonggaoxinxi from '@/views/modules/discussgonggaoxinxi/list'
    import gonggaoxinxi from '@/views/modules/gonggaoxinxi/list'
    import discusszhongzhi from '@/views/modules/discusszhongzhi/list'
    import config from '@/views/modules/config/list'
    import huanshui from '@/views/modules/huanshui/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
          ,{
	path: '/qukuai',
        name: '区块',
        component: qukuai
      }
          ,{
	path: '/news',
        name: '新闻资讯',
        component: news
      }
          ,{
	path: '/zhongzhi',
        name: '种植',
        component: zhongzhi
      }
          ,{
	path: '/discussqukuai',
        name: '区块评论',
        component: discussqukuai
      }
          ,{
	path: '/huanjing',
        name: '环境',
        component: huanjing
      }
          ,{
	path: '/storeup',
        name: '我的收藏管理',
        component: storeup
      }
          ,{
	path: '/zhiwu',
        name: '植物',
        component: zhiwu
      }
          ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
          ,{
	path: '/discusszhiwu',
        name: '植物评论',
        component: discusszhiwu
      }
          ,{
	path: '/discussgonggaoxinxi',
        name: '公告信息评论',
        component: discussgonggaoxinxi
      }
          ,{
	path: '/gonggaoxinxi',
        name: '公告信息',
        component: gonggaoxinxi
      }
          ,{
	path: '/discusszhongzhi',
        name: '种植评论',
        component: discusszhongzhi
      }
          ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
          ,{
	path: '/huanshui',
        name: '换水',
        component: huanshui
      }
        ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
