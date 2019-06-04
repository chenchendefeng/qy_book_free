<template>
  <div>
    <div class="operations">
      <el-select v-model="filter.status" placeholder="状态">
        <el-option label="全部" value=""/>
        <el-option label="上架" :value="1"/>
        <el-option label="下架" :value="0"/>
      </el-select>
      <el-select v-model="filter.category" placeholder="筛选条件">
        <el-option label="全部" value=""/>
        <el-option label="男生" value="boy"/>
        <el-option label="女生" value="girl"/>
        <el-option v-for="(item, index) in category" :key="index" :label="item.adCategory" :value="item.adCategory"/>
      </el-select>
      <el-input v-model="filter.keyWord" placeholder="书籍名称/编号" clearable/>
      <el-button type="primary" @click="search(1)">搜索</el-button>
    </div>
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      fit
      highlight-current-row
      header-cell-class-name="table-hd"
    >
      <el-table-column label="书籍信息">
        <template slot-scope="scope">
          <div class="book-info">
            <img :src="scope.row.coverImg">
            <ul>
              <li>{{scope.row.name}}</li>
              <li>cbid:{{scope.row.bID}}</li>
              <li>作者：{{scope.row.author}}</li>
            </ul>
          </div>
          {{ scope.row.book}}
        </template>
      </el-table-column>
      <el-table-column label="书籍分类" align="center" width="120">
        <template slot-scope="scope">{{ scope.row.category }}</template>
      </el-table-column>
      <el-table-column label="授权方" align="center" width="220">
        <template slot-scope="scope">{{ scope.row.source }}</template>
      </el-table-column>
      <el-table-column label="加入书架量" align="center" width="90">
        <template slot-scope="scope">{{ scope.row.addBookShelfCount }}</template>
      </el-table-column>
      <el-table-column label="阅读量" width="90" align="center">
        <template slot-scope="scope">{{scope.row.readedCount }}</template>
      </el-table-column>
      <el-table-column label="标签" width="90" align="center">
        <template slot-scope="scope">{{ scope.row.finishFlag ? '已完结' : '连载中' }}</template>
      </el-table-column>
      <el-table-column label="状态" width="90" align="center">
        <template slot-scope="scope">{{ scope.row.shelfStatus ? '上架' : '下架' }}</template>
      </el-table-column>
      <el-table-column label="操作" width="90" align="center">
        <template slot-scope="scope">
          <a @click="go(scope.row)">查看</a>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <div class="paging" v-if="count">
      <el-pagination
        background
        @current-change="search"
        :current-page="pageNo"
        :page-size="pageSize"
        layout="total, prev, pager, next, jumper"
        :total="count"
      />
    </div>
  </div>
</template>
<script>
import { getBooks, getBookCategory } from "@/apis/book";
import { setStore } from "@/apis/mUtils";
export default {
  data() {
    return {
      filter: {
        status: "",
        category: "",
        keyWord: ""
      },
      category: [],
      count: 0,
      pageNo: 1,
      pageSize: 15,
      list: [],
      listLoading: false
    };
  },
  beforeCreate() {
    getBookCategory().then(res => {
      this.category = res.data.data;
    });
  },
  created() {
    this.fetchData();
  },
  methods: {
    search(val) {
      this.pageNo = val;
      this.fetchData();
    },
    fetchData() {
      this.listLoading = true;
      let param = Object.assign({},this.filter,{
        pageNo: this.pageNo,
        pageSize: this.pageSize
      })
      Object.keys(param).forEach(function(key){
        if(param[key] === ''){
          delete param[key]
        }
      })
      getBooks(param).then(({ data }) => {
        this.list = data.data.data;
        this.count = data.data.count;
        this.listLoading = false;
      });
    },
    go(book){
      this.$router.push({
        path: `/books/detail/${book.bID}`
      })
      setStore('metaTitle',`书籍管理 > ${book.name}`)
    }
  }
};
</script>

<style lang="less" scoped>
.book-info {
  display: flex;
  img {
    width: 80px;
    height: 80px;
  }
  ul {
    padding: 0 0 0 15px;
  }
}
</style>
