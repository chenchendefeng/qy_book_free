
<template>
  <section class="zone-detail">
    <!-- 书籍表单 -->
    <el-form ref= "form" :model="form" :rules="rules" label-position="right" label-width="120px">
      <el-form-item label="主标题名称：" prop="title">
        <el-input v-model="form.title" placeholder="输入文字"/>
        <el-input v-model="form.titleRGB" placeholder="RGB值，输入数字"/>
      </el-form-item>
      <el-form-item label="副标题名称：" >
        <el-input v-model="form.title2" placeholder="输入文字"/>
        <el-input v-model="form.title2RGB" placeholder="RGB值，输入数字"/>
      </el-form-item>
      <el-form-item label="状态：">
        <el-select v-model="form.status" >
          <el-option label="上架" :value="1"/>
          <el-option label="下架" :value="0"/>
        </el-select>
      </el-form-item>
      <el-form-item label="排序：">
        <el-input type ="number" v-model="form.displayOrder" placeholder="输入数字" />
      </el-form-item>
      <el-form-item label="添加书籍：" prop="bid">
        <el-input v-model="form.bid" placeholder="输入书籍ID" /> <el-button type="primary" @click="addItem('form')">添加</el-button>
      </el-form-item>
      <el-form-item class="w">
        <el-table
          v-loading="listLoading"
          :data="form.bookList"
          element-loading-text="Loading"
          fit
          highlight-current-row
          header-cell-class-name="table-hd">
          <el-table-column label="书籍ID">
            <template slot-scope="scope">{{ scope.row.bid || '--'}}</template>
          </el-table-column>
          <el-table-column label="书籍名称" align="center" width="220">
            <template slot-scope="scope">{{ scope.row.name || '--' }}</template>
          </el-table-column>
          <el-table-column label="性别标签" align="center" width="100" v-if="type === 'recommend'">
            <template slot-scope="scope">{{ scope.row.sexMark === 'boy' ? '男性' : '女性' || '--' }}</template>
          </el-table-column>
          <el-table-column label="作者" width="140" align="center">
            <template slot-scope="scope">{{scope.row.author || '--' }}</template>
          </el-table-column>
          <el-table-column label="总阅读量" width="100" align="center">
            <template slot-scope="scope">{{ scope.row.readedCount || '--' }}</template>
          </el-table-column>
          <el-table-column label="授权方" width="180" align="center">
            <template slot-scope="scope">{{ scope.row.source || '--'}}</template>
          </el-table-column>
          <el-table-column label="操作" width="100" align="center">
            <template slot-scope="scope">
              <a @click="removeItem(scope.$index)">移除</a>
            </template>
          </el-table-column>
        </el-table>
        <div class="total" v-if="form.bookList.length">
          共{{form.bookList.length}}本
          <span v-if="type==='recommend'">，其中男性{{form.boyBooks}}本，女性{{form.girlBooks}}本</span>
        </div>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onValidate('form')">提交</el-button>
        <el-button type="info" @click="cancel">取消</el-button>
      </el-form-item>
    </el-form>
  </section>
</template>
<script>
import { getZoneDetail, saveOrUpdateZone, queryBook } from "@/apis/module";
export default {
  components: {},
  computed:{
    _id(){
      return this.$route.params.id;
    },
    type(){
      return this.$route.params.type;
    }
  },
  data() {
    return {
      listLoading:false,
      bidList:[],
      form: {
        bookList: [],
        title: "",
        titleRGB: "",
        title2: "",
        title2RGB: "",
        status: 1,
        displayOrder: 1,
        bid: ""
      },
      rules:{
        title: [
          { required: true, message: '请输入主标题名称', trigger: 'blur' }
        ],
        bid: [
          { required: true, message: '请输入输入书籍ID', trigger: 'blur' }
        ]
      }
    };
  },
  async created(){
    this.$route.params.id && await this.getDetail()
  },
  methods: {
    onValidate(formName){
      this.$refs[formName].validateField('title',(error) => {
        if(!error){
          if(this.bidList.length){
            this.onSubmit()
          }else{
            this.$refs[formName].validateField('bid',(error) => {
              if(!error){
                if(!this.bidList.length){
                  this.$message({
                    message: '请先添加书籍',
                    type: 'warning'
                  })
                }else{
                  this.onSubmit()
                }
              }
            })
          }
        } else {
          return false
        }
      })
    },
    onSubmit() {
      let param = Object.assign({},this.form,{
        bidList: this.bidList,
        subjectType: this.type
      })
      if(this._id){
        param = Object.assign(param,{
          id: this._id
        })
      }
      this.$alert('您确定提交吗', '提示', {
        confirmButtonText: '确定'
      }).then(() =>{
        delete param.bookList
        delete param.createTime
        delete param.updateTime
        saveOrUpdateZone(param).then(response => {
          this.$router.push(`/module/${this.type}`)
        })
      })
    },
    async getDetail(){
      await getZoneDetail({
        id: this._id
      }).then((res)=>{
        this.form = res.data.data
      })
      this.collectBid(this.form.bookList)
    },
    collectBid(list){
      this.bidList = list.map(function(item,index){
        return item.bid
      })
    },
    cancel(){
      this.$alert('您确定取消吗', '提示', {
        confirmButtonText: '确定'
      }).then(() =>{
        this.$router.push(`/module/${this.type}`)
      })
    },
    removeItem(index){
      this.$alert('您确定移除此书吗？', '提示', {
        confirmButtonText: '确定'
      }).then(() =>{
        this.form.bookList.splice(index,1)
        this.bidList.splice(index,1)
      })
    },
    addItem(formName){
      this.$refs[formName].validateField('bid',(error) => {
        if (!error) {
          if(this.bidList.indexOf(this.form.bid) !== -1){
            this.$message({
              message: '此书籍已添加',
              type: 'warning'
            });
            return;
          }
          queryBook({
            bid: this.form.bid
          }).then((res)=>{
            if(res.data.data === null){
              this.$message({
                message: '此书籍ID不存在',
                type: 'warning'
              });
              return;
            }
            this.form.bookList.push(res.data.data)
            this.form.bookList.sort((a,b) => b['readedCount'] - a['readedCount'])
            this.collectBid(this.form.bookList)
            this.form.bid = ''
          })
        }
      })
    }
  }
};
</script>

<style lang="less" scoped>
  .zone-detail{
    padding:10px 0 30px;
    .el-input{
      width:193px;
    }
    .w{
      width:90%;
    }
    .total{
      font-size: 12px;
      color:#333;
      padding:10px;
    }
  }
</style>