import Vue from "vue";
import Router from "vue-router";
import store from "../store/index";
import { Message } from "element-ui";
//导入权限
import { GetAuthority } from "../utils/api";
//引入所有的数组
import AuthorList from "./component";
Vue.use(Router);
const router = new Router({
  // mode:"history",
  routes: [
    {
      path: "/",
      name: "Login",
      component: () => import("@/components/Login")
    },
    {
      path: "/signon",
      name: "Signon",
      component: () => import("@/components/signon")
    },
    {
      path: "/dashboard",
      name: "Dashbord",
      component: () => import("@/components/dashboard"),
      children: [
        {
          path: "/index",
          name: "Index",
          component: () => import("@/components/Index")
        },
        {
          path: "/editor",
          name: "Editor",
          component: () => import("@/components/editor")
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
          component: () => import("@/components/item/display")
        },
        {
          path: "/blog",
          name: "Blog",
          component: () => import("@/components/item/blog")
        },
        {
          path: "/playvideo/:name",
          name: "PlayVideo",
          component: () => import("@/components/playvideo")
        }
      ]
    }
  ]
});
var checked = false;
router.beforeEach((to, from, next) => {
  //const isLogin = store.state.token ? true : false;

  // if (to.path == "/" || to.path == "/word") {
  //   next();
  // } else {
  //   if (store.state.token == "") {
  //     Message({
  //       message: "没有token请重新登录",
  //       type: "err"
  //     });
  //     next("/");
  //   } else {
  //检测权限控制
  // if (!checked) {
  //   GetAuthority({
  //     username: "mikasa"
  //   }).then(res => {
  //     console.log(res);
  //   });
  //   checked = true;
  // }
  next();
  // }
  // }
});
export default router;
