<template>
  <section>
    <!--工具条-->
    <el-row>
      <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
        <el-form :inline="true" :model="filters">
          <el-form-item style="width: 100%;">
            <el-input v-model="filters.bid" placeholder="输入书籍ID查询" prefix-icon="el-icon-search" ></el-input>
          </el-form-item>
          <el-form-item style="width: 80%;">
            <el-input v-model="filters.keyword" placeholder="输入作者或者书名查询" prefix-icon="el-icon-search"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="getUsers">搜索</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>

    <div class="yhtel">
      书籍信息
    </div>
    <!--列表-->
    <el-table :data="users" highlight-current-row v-loading="listLoading" style="width: 100%;">
      <!-- <el-table-column label="序号" type="index" width="50" align="center">
            </el-table-column> -->
      <el-table-column prop="cBID" label="书籍ID" min-width="120" align="center" :show-overflow-tooltip="true">
      </el-table-column>
      <el-table-column prop="title" label="书名" min-width="100" align="center" :show-overflow-tooltip="true">
      </el-table-column>
      <el-table-column prop="authorname" label="作者" min-width="80" align="center" :show-overflow-tooltip="true">
      </el-table-column>
      <el-table-column prop="readCount" label="分类" min-width="120" align="center" :show-overflow-tooltip="true">
        <template slot-scope="scope">
          <div>
            <span class="categoryList" v-for="(item,index) in scope.row.categoryList" :key="index">{{item}}-</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column prop="price" label="价格" min-width="80" align="center" :show-overflow-tooltip="true">
      </el-table-column>
      <el-table-column prop="userName" label="状态" min-width="110" align="center" :show-overflow-tooltip="true">
        <template slot-scope="scope">
          <div>
            <p>{{shelfStatus[scope.row.shelfStatus]}}</p>
            <p>{{scope.row.shelfDate}}</p>
          </div>
        </template>
      </el-table-column>
      <el-table-column prop="userName" label="作品状态" min-width="70" align="center" :show-overflow-tooltip="true">
        <template slot-scope="scope">
          <div>
            <p>{{status[scope.row.status]}}</p>
            <p>{{scope.row.allWords/10000}}万字</p>
          </div>
        </template>
      </el-table-column>
      <el-table-column prop="readCount" label="阅读量" min-width="70" align="center" :show-overflow-tooltip="true">
      </el-table-column>
      <el-table-column prop="saleCount" label="销售量" min-width="60" align="center" :show-overflow-tooltip="true">
      </el-table-column>

      <el-table-column label="操作" align="center" min-width="150">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit1(scope.$index, scope.row)">详情</el-button>
          <el-button v-if="scope.row.shelfStatus==1" size="mini" @click="handleEdit2(scope.$index, scope.row)">下架</el-button>
          <el-button v-else size="mini" @click="handleEdit3(scope.$index, scope.row)">上架</el-button>

        </template>
      </el-table-column>
    </el-table>

    <!--详情-->
    <el-dialog title="书籍详情" :visible.sync="FormVisible" @closed="close" width="1000px">
      <bookinfo :id="id" @hiden="show" ref="bookin"></bookinfo>
    </el-dialog>

    <!-- 分页 -->
    <div class="paging">
      <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-size="100" layout="total, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </div>

  </section>
</template>

<script>
import { bookList, bookOffShelf, bookUpShelf } from "@/apis/api";
import { Utils, Dates } from "@/apis/mUtils";
import bookinfo from "../common/bookinfo";
export default {
  components: {
    bookinfo
  },
  data() {
    return {
      status: {
        "30": "连载中",
        "40": "暂停中",
        "45": "完结申请",
        "50": "已完结",
        "101": " 封笔",
        "102": "错误",
        "103": " 精彩纷呈",
        "104": " 接近尾声",
        "105": " 新书上传",
        "106": " 情节展开",
        "107": "出版中"
      },
      shelfStatus: {
        "0": "下架",
        "1": "上架在售"
      },
      // 分页
      currentPage: 1, //获取到用户数据后, 作为请求参数获取当前页面的数据
      total: 0, //总条数
      //搜索
      filters: {
        keyword: "",
        bid: ""
      },
      //具体列表
      users: [],
      listLoading: false, //刷新
      FormVisible: false,
      id: ""
    };
  },
  methods: {
    close() {
      this.$refs.bookin.Booklist();
      this.getUsers();
    },
    
    show() {
      this.FormVisible = false;
    },
    // 分页
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.getUsers();
      console.log(`当前页: ${val}`);
    },

    handleEdit1(index, row) {
      this.id = row.cBID;
      this.FormVisible = true;
    },

    handleEdit2(index, row) {
      this.$confirm(
        '<p style=" font-size: 20px; font-weight: 600; height: 50px; line-height: 50px;">是否<span style=" color: red;">下架</span>该书？<p>',
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          dangerouslyUseHTMLString: true,
          center: true
        }
      ).then(() => {
        let para = {
          cbid: row.cBID
        };
        bookOffShelf(para).then(res => {
          console.log(res);
          if (res.data.result !== "success") {
            this.$message.error(`下架失败`);
            return false;
          }
          this.getUsers();
          this.$message({
            type: "success",
            message: "下架成功!"
          });
        });
      });
    },
    handleEdit3(index, row) {
      this.$confirm(
        '<p style=" font-size: 20px; font-weight: 600; height: 50px; line-height: 50px;">是否<span style=" color: red;">上架</span>该书？<p>',
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          dangerouslyUseHTMLString: true,
          center: true
        }
      ).then(() => {
        let para = {
          cbid: row.cBID
        };
        bookUpShelf(para).then(res => {
          console.log(res);
          if (res.data.result !== "success") {
            this.$message.error(`上架失败`);
            return false;
          }
          this.getUsers();
          this.$message({
            type: "success",
            message: "上架成功!"
          });
        });
      });
    },

    // 获取用户列表：
    getUsers() {
      this.listLoading = true;
      let para = {
        keyWord: this.filters.keyword,
        cbid: this.filters.bid
      };
      bookList(para)
        .then(res => {
          if (res.data.result !== "success") {
            this.$message.error(`获取数据失败`);
            return false;
          }
          let data = res.data.data;
          this.users = data;
          this.total = data.length;
          console.log(data);
          this.listLoading = false;
        })
        .catch(() => {
          this.listLoading = false;
        });
    }
  },

  // 获取用户数据
  mounted() {
    // this.getUsers();
    // console.log(this.status[30])
  }
};
</script>

<style lang="less" scoped>
.paging {
  margin: 10px auto;
  text-align: center;
}
.toolbar {
  margin-bottom: 50px;
}
.yhtel {
  padding: 30px 10px;
  border-bottom: 3px solid #eee;
  margin-bottom: 20px;
}

.el-dialog__body {
  background: #eee;
}
.categoryList {
  padding: 0 2px;
}
</style>