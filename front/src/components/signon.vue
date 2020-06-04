<template>
  <div id="signon">
    <div class="container">
      <span> 用户名：</span
      ><el-input v-model="username" placeholder="用户名"></el-input>
      <span> 密码：</span
      ><el-input v-model="password" placeholder="密码"></el-input>
      <span> 邮箱：</span
      ><el-input v-model="email" placeholder="邮箱"></el-input>
      <span> 验证码：</span
      ><el-input v-model="emailcode" placeholder="验证码"></el-input>
      <el-button class="send" type="primary" @click="send">发送验证码</el-button>
      <el-button class="singon" type="success" @click="signon" :disabled="controll">注册</el-button>
    </div>
  </div>
</template>

<script>
import { SignOn } from "../utils/api";
import { Send } from "../utils/api";
export default {
  data() {
    return {
      username: "",
      password: "",
      email: "",
      emailcode:"",
      controll:true
    };
  },
  methods: {
      send(){
          Send({
              email:this.email
          }).then((res)=>{
              this.controll = false;
              console.log(res)
            }).catch((err)=>{console.log(err)})
      },
    signon() {
      SignOn({
        username: this.username,
        password: this.password,
        email: this.email,
        emailcode:this.emailcode
      })
        .then(res => {
          console.log(res);
        })
        .catch(err => {
          console.log(err);
        });
    }
  }
};
</script>

<style lang="less" scoped>
#signon {
    min-height: 100vh;
    width: 100%;
     background-image: url(../assets/bg/7.jpg);
  background-repeat: no-repeat;
  background-size: cover;
  .container {
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    width: 20%;
    height: 300px;
    .singon,.send {
      margin: 10px 50%;
      transform: translate(-50%);
      width: 150px;
    }
  }
}
</style>
