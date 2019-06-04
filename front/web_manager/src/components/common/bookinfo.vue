<template>
  <div class="details">
    <div class="details-ul">
      <div class="details-li1">书籍ID</div>
      <div class="details-li2">{{book.cBID}}</div>
      <div class="details-li3">书名</div>
      <div class="details-li4">
        <span>{{book.title}}</span>

      </div>
    </div>
    <div class="details-ul">
      <div class="details-li1">作者</div>
      <div class="details-li2">{{book.authorname}}</div>
      <div class="details-li3">分类</div>
      <div class="details-li4 separator">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item v-for="(item , index) in book.categoryList" :key="index">{{item}}</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
    </div>
    <div class="details-ul">
      <div class="details-li1">上架时间</div>
      <div class="details-li2">{{book.shelfDate}}</div>
      <div class="details-li3">更新</div>
      <div class="details-li4">{{book.updatetime}}</div>
    </div>
    <div class="details-ul">
      <div class="details-li1">阅读量</div>
      <div class="details-li2">{{book.readCount}}</div>
      <div class="details-li3">售卖量</div>
      <div class="details-li4">{{book.saleCount}}</div>
    </div>
    <div class="details-ul">
      <div class="details-li1">书架收藏</div>
      <div class="details-li2">{{book.collection}}</div>

      <div class="details-li3">价格</div>
      <div class="details-li4">
        <span>{{book.price}}</span>
        <el-button size="mini" @click="jiage.dialogVisible = true">修改</el-button>
      </div>
    </div>

    <div class="details-ul">
      <div class="details-li1">收费模式</div>
      <div class="details-li2">
        <span>{{vipstatus[book.vipstatus]}}</span>
        <el-button size="mini" @click="jifei.dialogVisible = true">修改</el-button>
      </div>

      <div class="details-li3">计算方式</div>
      <div class="details-li4">
        <span>暂时无</span>
        <el-button size="mini" disabled>修改</el-button>
      </div>
    </div>

    <div class="details-ul">
      <div class="details-li5-img">书封面</div>
      <div class="details-li6-img">
        <img :src=book.coverUrl alt="">
        <el-upload class="upload" 
        action="/admin/upload/picture" 
        accept="image/*" 
        :data="{folder:'book'}"
        list-type="picture-card" 
        :on-error="errUpload" 
        :on-success="handlePictureCardPreview" 
        :file-list="fileList" 
        :limit="1">
          <el-button size="small">修改</el-button>
        </el-upload>
      </div>
    </div>

    <div class="details-ul">
      <div class="details-li5">作品状态</div>
      <div class="details-li6">
        <div class="details-li6-f">
          {{shelfStatus[book.shelfStatus]}} | {{status[book.status]}}
        </div>
        <span>{{book.chapterCount}}章</span>
        <span>{{book.allWords}}字</span>
        <div class="details-li6-r">
          <el-button v-if="book.shelfStatus==1" size="mini" @click="xiajia">下架</el-button>
          <el-button v-else size="mini" @click="shangjia">上架</el-button>
        </div>
      </div>
    </div>

    <div class="details-ul">
      <div class="details-li5-tabel">更新记录</div>
      <div class="details-li6-tabel">
        <el-table :data="users" highlight-current-row v-loading="listLoading" border>
          <el-table-column prop="createTime" label="时间" min-width="80" align="center">
          </el-table-column>
          <el-table-column prop="operation" label="内容" min-width="80" align="center">
          </el-table-column>
          <el-table-column prop="userName" label="操作人" min-width="80" align="center">
          </el-table-column>
        </el-table>

        <div class="paging">
          <el-pagination background @size-change="handleSizeChange"
          @current-change="handleCurrentChange" :current-page="currentPage"
           :page-size="4" layout="total, prev, pager, next, jumper" :total="total">
          </el-pagination>
        </div>
      </div>
    </div>

    <div class="details-ul">
      <div class="details-li-but">
        <!-- <el-button size="mini" @click="zhifu">用户支付记录</el-button> -->
        <el-button size="mini" @click="yuedu">书籍阅读记录</el-button>
        <el-button size="mini" @click="goumai">书籍购买记录</el-button>

      </div>
    </div>

    <!-- 收费模式 -->
    <el-dialog :visible.sync="jifei.dialogVisible" width="280px" append-to-body center>
      <p slot="title" class="tctitle">
        修改收费模式
      </p>
      <div class="select">
        <el-select v-model="jifei.value" placeholder="请选择收费模式">
          <el-option label="免费" :value="-1"></el-option>
          <el-option label="会员" :value="1"></el-option>
        </el-select>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="jifei.dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="modifyBook">确 定</el-button>
      </span>
    </el-dialog>

    <!-- 价格计算 -->
    <el-dialog :visible.sync="jiage.dialogVisible" width="280px" append-to-body center>
      <p slot="title" class="tctitle">
        修改收费模式
      </p>
      <div class="select">
        <el-select v-model="jiage.value" placeholder="请选择收费模式">
          <el-option label="1000字/0书币" :value="0"></el-option>
          <el-option label="1000字/1书币" :value="1"></el-option>
          <el-option label="1000字/2书币" :value="2"></el-option>
          <el-option label="1000字/3书币" :value="3"></el-option>
          <el-option label="1000字/4书币" :value="4"></el-option>
          <el-option label="1000字/5书币" :value="5"></el-option>
          <el-option label="1000字/6书币" :value="6"></el-option>
          <el-option label="1000字/7书币" :value="7"></el-option>
          <el-option label="1000字/8书币" :value="8"></el-option>
          <el-option label="1000字/9书币" :value="9"></el-option>
          <el-option label="1000字/10书币" :value="10"></el-option>
        </el-select>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="jiage.dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="BookUnitPrice">确 定</el-button>
      </span>
    </el-dialog>

  </div>
</template>


<script>
import {
  bookDetail,
  bookUpdateRecord,
  bookOffShelf,
  bookUpShelf,
  modifyBookPayType,
  modifyBookUnitPrice,
  updateCoverUrl
} from "@/apis/api";
import { mapMutations } from "vuex";
export default {
  data() {
    return {
      // 分页
      currentPage: 1, //获取到用户数据后, 作为请求参数获取当前页面的数据
      total: 0, //总条数
      book: [],
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
      vipstatus: {
        "-1": "免费",
        "1": "收费"
      },

      fileList: [],
      //具体列表
      users: [],
      listLoading: false, //刷新
      jifei: {
        value: -1,
        dialogVisible: false
      },
      jiage: {
        value: 10,
        dialogVisible: false
      }
    };
  },
  props: ["id"],
  methods: {
    ...mapMutations(["changeBook"]),
    goumai() {
      let para = {
        book: "third",
        uid: 111
      };
      this.changeBook(para);
      this.$emit("hiden");
    },
    yuedu() {
      let para = {
        book: "second",
        uid: 222
      };
      this.changeBook(para);
      this.$emit("hiden");
    },

    //上传成功
    handlePictureCardPreview(response, file, fileList) {
      this.fileList = [];
      if (response.result !== "success") {
        this.$message.error(response.msg);
        return false;
      }
      let para = {
        cbid: this.id,
        coverUrl: response.msg
      };
      updateCoverUrl(para).then(res => {
        if (res.data.result !== "success") {
          this.$message.error(`修改失败`);
          return false;
        }
        this.Booklist();
        this.$message({
          type: "success",
          message: "修改成功!"
        });
      });
    },
    //上传失败
    errUpload() {
      this.fileList = [];
      this.$message.error(`修改失败`);
    },

    //收费方式
    modifyBook() {
      let para = {
        cbid: this.id,
        payType: this.jifei.value
      };
      modifyBookPayType(para).then(res => {
        if (res.data.result !== "success") {
          this.$message.error(`修改失败`);
          return false;
        }
        this.jifei.dialogVisible = false;
        this.Booklist();
        this.$message({
          type: "success",
          message: "修改成功!"
        });
      });
    },

    //修改单价
    BookUnitPrice() {
      let para = {
        cbid: this.id,
        unitPrice: this.jiage.value
      };
      console.log(para);
      modifyBookUnitPrice(para).then(res => {
        if (res.data.result !== "success") {
          this.$message.error(`修改失败`);
          return false;
        }
        this.jiage.dialogVisible = false;
        this.Booklist();
        this.$message({
          type: "success",
          message: "修改成功!"
        });
      });
    },

    //下架
    xiajia() {
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
          cbid: this.id
        };
        bookOffShelf(para).then(res => {
          console.log(res);
          if (res.data.result !== "success") {
            this.$message.error(`下架失败`);
            return false;
          }
          this.Booklist();
          this.$message({
            type: "success",
            message: "下架成功!"
          });
        });
      });
    },
    //上架
    shangjia() {
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
          cbid: this.id
        };
        bookUpShelf(para).then(res => {
          console.log(res);
          if (res.data.result !== "success") {
            this.$message.error(`上架失败`);
            return false;
          }
          this.Booklist();
          this.$message({
            type: "success",
            message: "上架成功!"
          });
        });
      });
    },

    fengmian1() {
      // this.$confirm("确定修改封面吗？", "提示", {
      //   confirmButtonText: "确定",
      //   cancelButtonText: "取消",
      //   center: true
      // })
      //   .then(() => {
      //     this.$message({
      //       type: "success",
      //       message: "删除成功!"
      //     });
      //   })
      //   .catch(() => {
      //     this.$message({
      //       type: "info",
      //       message: "已取消删除"
      //     });
      //   });
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

    // 获取用户列表：
    Booklist() {
      let para = {
        cbid: this.id
      };
      bookDetail(para).then(res => {
        if (res.data.result !== "success") {
          this.$message.error(`获取失败`);
          return false;
        }
        this.book = res.data.data;
        this.getUsers();
        console.log(this.book);
      });

      this.listLoading = false;
    },

    getUsers() {
      let para = {
        pageSize: 4,
        pageNo: this.currentPage,
        cbid: this.id
      };
      bookUpdateRecord(para).then(res => {
        if (res.data.result !== "success") {
          this.$message.error(`获取数据失败`);
          return false;
        }
        let data = res.data.data;
        this.users = data.data;
        this.total = data.count;
        console.log(res.data);
      });
    }
  },

  // 获取用户数据
  mounted() {
    this.Booklist();
    this.getUsers();
  },
  watch: {
    id(e) {
      this.Booklist();
      this.getUsers();
    }
  }
};
</script>


<style lang="less" scoped>
.details {
  border: #ccc 1px solid;
  min-width: 800px;
  .details-ul {
    display: flex;
    border-bottom: #ccc 1px solid;
    & > div {
      height: 50px;
      display: flex;
      justify-content: center;
      align-items: center;
      border-right: #ccc 1px solid;
    }
    .details-li-but {
      height: 80px;
      width: 100%;
      button {
        margin: 0 20px;
      }
    }
    .details-li1 {
      flex: 1;
    }
    .details-li2 {
      flex: 3;
      span {
        padding: 0 40px;
      }
    }
    .details-li3 {
      flex: 3;
    }
    .details-li4 {
      flex: 5;
      span {
        padding: 0 40px;
      }
    }
    .details-li5 {
      flex: 1;
    }
    .details-li6 {
      flex: 11;
      display: flex;
      justify-content: space-around;
    }
    .details-li5-img {
      flex: 1;
      height: 120px;
    }
    .details-li6-img {
      flex: 11;
      height: 120px;
      img {
        width: 70px;

        padding: 0 20px;
      }
    }
    .details-li5-tabel {
      width: 8.333333333333333333%;
      height: 234px;
    }
    .details-li6-tabel {
      width: 91.66666666666666666%;
      height: 234px;
      display: flex;
      flex-direction: column;
      justify-content: space-between;
    }
    .separator.details-li4 {
      span {
        padding: 0;
      }
    }
  }
}
.select {
  display: flex;
  align-items: center;
  justify-content: center;
}
.tctitle {
  font-size: 18px;
  font-weight: 500;
}
</style>
