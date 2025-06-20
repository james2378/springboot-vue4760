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

     import users from '@/views/modules/users/list'
    import anquan from '@/views/modules/anquan/list'
    import chat from '@/views/modules/chat/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import jiankangguanli from '@/views/modules/jiankangguanli/list'
    import liuyan from '@/views/modules/liuyan/list'
    import ruzhutuifang from '@/views/modules/ruzhutuifang/list'
    import shebei from '@/views/modules/shebei/list'
    import shenghuoguanli from '@/views/modules/shenghuoguanli/list'
    import yiliao from '@/views/modules/yiliao/list'
    import yiqingfangkong from '@/views/modules/yiqingfangkong/list'
    import yonghu from '@/views/modules/yonghu/list'
    import zhiyuanzhe from '@/views/modules/zhiyuanzhe/list'
    import config from '@/views/modules/config/list'
    import dictionaryAnquan from '@/views/modules/dictionaryAnquan/list'
    import dictionaryChat from '@/views/modules/dictionaryChat/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryJiankangguanli from '@/views/modules/dictionaryJiankangguanli/list'
    import dictionaryRuzhutuifang from '@/views/modules/dictionaryRuzhutuifang/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShebei from '@/views/modules/dictionaryShebei/list'
    import dictionaryShenghuoguanli from '@/views/modules/dictionaryShenghuoguanli/list'
    import dictionaryYiliao from '@/views/modules/dictionaryYiliao/list'
    import dictionaryYiqingfangkong from '@/views/modules/dictionaryYiqingfangkong/list'
    import dictionaryZhuangtai from '@/views/modules/dictionaryZhuangtai/list'





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
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryAnquan',
        name: '巡检类型',
        component: dictionaryAnquan
    }
    ,{
        path: '/dictionaryChat',
        name: '数据类型',
        component: dictionaryChat
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryJiankangguanli',
        name: '健康状态类型',
        component: dictionaryJiankangguanli
    }
    ,{
        path: '/dictionaryRuzhutuifang',
        name: '入住状态类型',
        component: dictionaryRuzhutuifang
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShebei',
        name: '设备类型',
        component: dictionaryShebei
    }
    ,{
        path: '/dictionaryShenghuoguanli',
        name: '生活管理类型',
        component: dictionaryShenghuoguanli
    }
    ,{
        path: '/dictionaryYiliao',
        name: '医疗类型',
        component: dictionaryYiliao
    }
    ,{
        path: '/dictionaryYiqingfangkong',
        name: '疫情防控状态类型',
        component: dictionaryYiqingfangkong
    }
    ,{
        path: '/dictionaryZhuangtai',
        name: '状态',
        component: dictionaryZhuangtai
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/anquan',
        name: '安全',
        component: anquan
      }
    ,{
        path: '/chat',
        name: '客服聊天',
        component: chat
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/jiankangguanli',
        name: '健康信息',
        component: jiankangguanli
      }
    ,{
        path: '/liuyan',
        name: '留言板',
        component: liuyan
      }
    ,{
        path: '/ruzhutuifang',
        name: '入住退房信息',
        component: ruzhutuifang
      }
    ,{
        path: '/shebei',
        name: '设备',
        component: shebei
      }
    ,{
        path: '/shenghuoguanli',
        name: '生活信息',
        component: shenghuoguanli
      }
    ,{
        path: '/yiliao',
        name: '医疗信息',
        component: yiliao
      }
    ,{
        path: '/yiqingfangkong',
        name: '疫情防控信息',
        component: yiqingfangkong
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/zhiyuanzhe',
        name: '志愿者',
        component: zhiyuanzhe
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
