<template>
  <el-row class="tac">
    <el-col :lg="4">
      <el-menu
        default-active="2"
        class="el-menu-vertical-demo"
        background-color="#778899"
        text-color="#E0FFFF"
        active-text-color="#B8860B"
        @select="handleOpen"
      >
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span>个人信息</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="1-1">首页</el-menu-item>
            <el-menu-item index="1-2">首页</el-menu-item>
            <el-menu-item index="1-3">首页</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-menu-item index="2">
          <i class="el-icon-star-on"></i>
          <span slot="title">权限控制</span>
        </el-menu-item>
        <el-menu-item index="3">
          <i class="el-icon-s-grid"></i>
          <span slot="title">博客发布</span>
        </el-menu-item>
        <el-menu-item index="4">
          <i class="el-icon-document"></i>
          <span slot="title">文件管理</span>
        </el-menu-item>
        <el-menu-item index="5">
          <i class="el-icon-s-grid"></i>
          <span slot="title">我的博客</span>
        </el-menu-item>
      </el-menu>
    </el-col>
    <el-col :lg="20" id="container">
      <div id="headinfo">
        <div id="bread">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/index' }"
              >{{breadinfo.first}}</el-breadcrumb-item
            >
            <el-breadcrumb-item v-if="breadinfo.second != ''">{{breadinfo.second}}</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <div id="loginout">
          <span>退出</span>
          <el-button type="danger" icon="el-icon-user-solid" @click="loginout"></el-button>
        </div>
      </div>
      <router-view />
    </el-col>
  </el-row>
</template>

<script>
export default {
  data() {
    return {
      breadinfo:{
        first:"权限控制",
        second:""
      }
    };
  },
  mounted() {
    this.$router.push("/self").catch(data => {});
  },
  methods: {
    handleOpen(index) {
      switch (index) {
        case "1-1":
          this.$router.push("/index").catch(data => {});
          this.breadinfo.first = "个人信息"
          this.breadinfo.second = "首页"
          break;
        case "2":
          this.$router.push("/self").catch(data => {});
          this.breadinfo.first = "权限控制"
          this.breadinfo.second = ""
          break;
        case "3":
          this.$router.push("/editor").catch(data => {});
          this.breadinfo.first = "博客发布"
          this.breadinfo.second = ""
          break;
        case "4":
          this.$router.push("/music").catch(data => {});
          this.breadinfo.first = "文件管理"
          this.breadinfo.second = ""
          break;
          case "5":
          this.$router.push("/blog").catch(data => {});
          this.breadinfo.first = "我的博客"
          this.breadinfo.second = ""
          break;
      }
    },
    openitem(key, keypath) {
      console.log(key, keypath);
    },
    loginout(){
      this.$router.push("/")
    }
  }
};
</script>

<style lang="less">
.el-menu-vertical-demo {
  height: 100vh;
}
#container {
  background: #FFFAF0;
  height: 100vh;
  overflow: scroll;
  #headinfo {
    height: 50px;
    background-color: #c9daf8;
    display: flex;
    align-items: center;
    justify-content: space-between;
    #bread{
      margin-left: 20px;
    }
    #loginout{
      margin-right: 50px;
    }
  }
}
.el-menu i {
  color: #e0ffff;
}
</style>
