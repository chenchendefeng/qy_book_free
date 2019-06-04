<template>
  <div class="detail-box">
    <div class="db-header">
      <img :src="book.coverImg" />
      <ul>
        <li>{{book.name}}<el-tag :type="book.shelfStatus ? 'success':'warning'">{{book.shelfStatus?'上架':'下架'}}</el-tag></li>
        <li>cbid：{{book.bid}}</li>
        <li>授权方：{{book.source}}</li>
      </ul>
    </div>
    <div class="db-list">
      <div>
        <h3>基本信息</h3>
        <ul>
          <li><span>书籍名称：</span>{{book.name}}</li>
          <li><span>作者名称：</span>{{book.author}}</li>
          <li><span>书籍分类：</span>{{book.adCategory}}</li>
          <li><span>完结状态：</span>{{book.finishFlag ? '已完结' : '连载中'}}</li>
          <li><span>书籍字数：</span>{{book.totalWordCount}}</li>
        </ul>
      </div>
      <div>
        <h3>其他信息<i class="el-icon-edit-outline" @click="showEdit"></i></h3>
        <ul>
          <li><span>性别标签：</span>{{sexMark[book.sexMark]}}</li>
          <li><span>书籍状态：</span>{{book.shelfStatus ? '上架' : '下架'}}</li>
          <li><span>总阅读量：</span>{{book.readedCount}}</li>
          <li><span>加入书架量：</span>{{book.addBookShelfCount}}</li>
        </ul>
      </div>
    </div>

    <el-dialog :visible.sync="visible" width="30%" title="修改其他信息" class="dialog-update">
      <template>
        <el-form ref="form" :rules="rules" :model="form" label-position="right" label-width="130px">
          <el-form-item label="书籍名称：" >
            {{book.name}}
          </el-form-item>
          <el-form-item label="性别标签：" prop="sexMark">
            <el-select v-model="form.sexMark">
              <el-option label="全部" value="all" />
              <el-option label="男生" value="boy" />
              <el-option label="女生" value="girl" />
            </el-select>
          </el-form-item>
          <el-form-item label="书籍状态：" prop="shelfStatus">
            <el-select v-model="form.shelfStatus">
              <el-option label="上架" :value="1" />
              <el-option label="下架" :value="2" />
            </el-select>
          </el-form-item>
          <el-form-item label="阅读量：" prop="readedCount">
            <el-input type="number" v-model="form.readedCount" placeholder="输入数字"/>
          </el-form-item>
          <el-form-item label="加入书架量：" prop="addBookShelfCount">
            <el-input type="number" v-model="form.addBookShelfCount" placeholder="输入数字"/>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit('form')">保 存</el-button>
            <el-button @click="cancel">取消</el-button>
          </el-form-item>
        </el-form>
      </template>
    </el-dialog>
  </div>
</template>
<script>
import { mapState, mapMutations } from "vuex";
import { getBookDetail, updateBookDetail } from "@/apis/book"

export default {
  computed:{
    bid(){
      return this.$route.params.id;
    }
  },
  data() {
    return {
      book:{},
      visible: false,
      sexMark:{
        all: '全部',
        boy: '男生',
        girl: '女生'
      },
      form: {
        sexMark: '',
        shelfStatus: '',
        readedCount: '',
        addBookShelfCount: ''
      },
      rules:{
        shelfStatus: [
          { required: true, message: '请选择书籍状态', trigger: 'change' }
        ],
        sexMark: [
          { required: true, message: '请选择性别标签', trigger: 'change' }
        ],
        readedCount: [
          { required: true, message: '请输入阅读量', trigger: 'change' }
        ],
        addBookShelfCount: [
          { required: true, message: '请输入加入书架量', trigger: 'change' }
        ],
      }
    }
  },
  created(){
    this.bid && this.fetchData()
  },
  methods: {
    fetchData(){
      getBookDetail({
        bid: this.bid
      }).then((res)=>{
        this.book = res.data.data
      })
    },
    showEdit(){
      this.visible = true
      this.form = Object.assign({},this.book)
    },
    cancel(){
      this.$alert('您确定取消吗', '提示', {
        confirmButtonText: '确定'
      }).then(() =>{
        this.visible = false
      })
    },
    onSubmit(formName) {
      const param = this.form
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$alert('您确定提交吗', '提示', {
            confirmButtonText: '确定'
          }).then(() =>{
            updateBookDetail(param).then(() => {
              this.visible = false
              this.fetchData()
              this.$message({
                type: 'success',
                message: '修改成功!'
              })
            })
          })
        } else {
          return false
        }
      })
    }
  }
};
</script>

<style lang="less" scoped>
.detail-box{
  color:#666;
  font-size: 14px;
}
.db-header{
  display: flex;
  padding:30px 30px 40px;
  border-bottom: solid 1px #ccc;
  img{
    width: 100px;
    height: 100px;
  }
  ul{
    padding: 0 0 0 20px;
    line-height: 30px;
    .el-tag{
      margin-left: 10px;
    }
  }
}
.db-list{
  display: flex;
  padding:30px 10px;
  color:#999;
  >div{
    width: 40%;
  }
  h3{
    margin-bottom: 20px;
    border-left: solid 2px #555;
    height: 16px;
    line-height: 16px;
    padding-left: 10px;
    .el-icon-edit-outline{
      color:#1296db;
      margin-left: 10px;
      cursor: pointer;
    }
  }
  ul{
    padding:0 0 30px 30px;
    line-height: 50px;
    span{
      color:#666;
      margin-right: 20px;
      width: 90px;
      display: inline-block;
      text-align: right;
    }
  }
}

.dialog-update{
  .el-input{
    width:193px;
  }
}
</style>
