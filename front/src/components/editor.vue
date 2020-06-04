<template>
  <div>
    <quill-editor
      v-model="content"
      ref="myQuillEditor"
      :options="editorOption"
      @focus="onEditorFocus($event)"
      @blur="onEditorBlur($event)"
      @change="onEditorChange($event)"
    >
    </quill-editor>
    <el-button type="warning" class="upload" @click="upload">上传发布</el-button>
  </div>
</template>

<script>
import { quillEditor } from "vue-quill-editor";
import { PostBlog } from '../utils/api'
export default {
  data() {
    return {
      content: "", // 富文本编辑器默认内容
      editorOption: {}
    };
  },
  mounted() {
    this.editor = this.$refs.myQuillEditor.quill;
  },
  beforeDestroy() {
    this.editor = null;
    delete this.editor;
  },
  components: {
    quillEditor
  },
  methods: {
    // 准备富文本编辑器
    onEditorReady(editor) {},
    // 富文本编辑器 失去焦点事件
    onEditorBlur(editor) {},
    // 富文本编辑器 获得焦点事件
    onEditorFocus(editor) {},
    // 富文本编辑器 内容改变事件
    onEditorChange(editor, html, text) {
    //   console.log(this.content);
    },
    upload(){
        PostBlog({
            content:this.content,
            title:"blog",
            sort:"study",
            username:"mikasa"
        }).then((res)=>{console.log(res)}).catch((err)=>{
            console.log(err)
        })
    }
  }
};
</script>

<style lang="less" scoped>
div{
 .upload{
    margin-top: 20px;
    margin-left: 50%;
    transform: translate(-50%);
}
}

</style>>

</style>
