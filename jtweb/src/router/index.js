import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login.vue'
import Home from '../components/Home.vue'
import Welcome from '../components/Welcome.vue'
import User from '../components/user/User.vue'
import ItemCat from '../components/ItemCat/ItemCat.vue'
import ItemCatParam from '../components/ItemCat/ItemCatParam.vue'
import Item from '../components/Item/Item.vue'
import AddItem from '../components/addItem/addItem.vue'
Vue.use(VueRouter)
const routes = [
  {path: '/', redirect: '/login'},
  {path: '/login', component: Login},
  {path: '/home', component: Home,redirect:'/welcome', children :[
    {path:'/welcome',component: Welcome},
    {path:'/user',component: User},
    {path:'/itemCat',component:ItemCat},
    {path:'/itemCatParam',component:ItemCatParam},
    {path:'/item',component:Item},
    {path:'/item/addItem',component:AddItem}
  ]}
]

//定义路由对象
const router = new VueRouter({
  routes
})

/**
 * 2.定义导航首位(注意书写顺序)
 * beforeEach:循环遍历用户的所有的请求.(拦截)
 *            在其中需要定义一个回调函数(3个参数)
 *  参数的介绍:to:要访问的请求路径,from:从那个页面跳转而来,next:表示请求放行
 *
 * 业务需求:1.如果用户请求/login(登录页面)
 */
router.beforeEach((to,from,next)=>{
  if(to.path==='/login'){
    return next()
  }//获取token信息
  let token = window.sessionStorage.getItem('token')
  //3.判断token是否有值?   if(token)如果token不为null
  if(!token){ return next('/login')

  }else{
  //表示放行
  next()
  }
})

export default router
