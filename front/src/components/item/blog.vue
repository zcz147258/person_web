<template>
  <div id="blog">
    <div class="item" v-for="(item,index) in arr" :key="index">
      <div class="head">
        <div class="title">{{item.blog_title}}</div>
        <div class="author">{{item.username}}</div>
        <div class="sort">{{item.blog_sort}}</div>
        <div class="time">{{item.create_time}}</div>
      </div>
      <div class="content" v-html="item.blog_content"></div>
    </div>
  </div>
</template>

<script>
import { GetBlog } from '../../utils/api'
export default {
  data(){
    return{
       arr:[]
    }
  },
  created(){
    GetBlog().then((res)=>{
      if(res.bloginfo){
          console.log(this.arr = res.bloginfo)
      }else{
        console.log(res)
      }
      }).catch((err)=>{
        console.log(err)
        })
  },
  methods:{
    
  }
};
</script>
<style lang="less" scoped>
.item {
  width: 80%;
  height: auto;
  margin: auto;
  margin-top: 30px;
  background: steelblue;
  border-radius: 5px;
  .head{
    display: flex;
    justify-content: space-around;
    .title{
      font-size: 20px;
      font-weight: bolder;
      color: rgb(238, 130, 6);
    }
    .author{
      font-size: 20px;
      font-weight: bolder;
      color: rgb(240, 23, 34);
    }
    .sort{
      font-size: 20px;
      font-weight: bolder;
      color: rgb(25, 248, 17);
    }
    .time{
       font-size: 20px;
      font-weight: bolder;
      color: rgb(41, 6, 236);
    }
  }
  .content{
    margin: 20px 20px;
  }
}
</style>
