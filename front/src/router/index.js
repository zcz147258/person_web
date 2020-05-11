import Vue from "vue";
import Router from "vue-router";
import store from "../store/index";
import { Message } from 'element-ui'
Vue.use(Router);
const router = new Router({
  routes: [
    {
      path: "/",
      name: "Login",
      component: () => import("@/components/Login")
    },
    {
      path: "/index",
      name: "Index",
      component: () => import("@/components/Index")
    },
    {
      path: "/music",
      name: "Music",
      component: () => import("@/components/item/music")
    },
    {
      path: "/video",
      name: "Video",
      component: () => import("@/components/item/video")
    },
    {
      path: "/self",
      name: "Self",
      component: () => import("@/components/item/self")
    },
    {
      path: "/word",
      name: "Word",
      component: () => import("@/components/item/word")
    },
    {
      path: "/display",
      name: "Display",
      component: () => import("@/components/item/blog")
    },
    {
      path: "/blog",
      name: "Blog",
      component: () => import("@/components/item/display")
    },
    {
      path: "/playvideo/:name",
      name: "PlayVideo",
      component: () => import("@/components/playvideo")
    }
  ]
});
router.beforeEach((to, from, next) => {
  const isLogin = store.state.token ? true : false;
  if (to.path == "/" || to.path == '/word') {
    next();
  } else {
    if (store.state.token == "") {
      Message({
        message: '没有token请重新登录',
        type: 'err'
      });
      next("/");
    } else {
      next();
    }
  }
});
export default router;
