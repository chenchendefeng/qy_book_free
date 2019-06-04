<template>
  <section class="inv">
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">

        <el-form-item label="状态：" prop="type">
          <el-select v-model="filters.type" placeholder="全部" style="width: 220px;">
            <el-option label="修改书币" :value="1">
            </el-option>
            <el-option label="推送消息" :value="2">
            </el-option>
            <el-option label="用户管理" :value="3">
            </el-option>
            <el-option label="书籍管理" :value="4">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="开始时间：">
          <el-date-picker style="width: 180px;" v-model="filters.value1" type="date" placeholder="选择日期" value-format="yyyy-MM-dd HH:mm:ss" format="yyyy 年 MM 月 dd 日" :picker-options="pickerOptions0">
          </el-date-picker>
        </el-form-item>

        <el-form-item label="结束时间：">
          <el-date-picker style="width: 180px;" v-model="filters.value2" align="center" type="date" placeholder="选择日期" value-format="yyyy-MM-dd 23:59:59" format="yyyy 年 MM 月 dd 日" :picker-options="pickerOptions1">
          </el-date-picker>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="getUs">确认</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table :data="users" highlight-current-row v-loading="listLoading" style="width: 100%;" border :header-cell-style="{background:'#eee'}">
      <el-table-column prop="staffName" label="操作人" min-width="120" align="center" :show-overflow-tooltip="true">
      </el-table-column>
      <el-table-column prop="inviteName" label="操作类型" min-width="120" align="center" :show-overflow-tooltip="true">
        <template slot-scope="scope">
           {{statuss[scope.row.type-1]}}
        </template>
      </el-table-column>
      <el-table-column prop="remark" label="操作内容" min-width="90" align="center" :show-overflow-tooltip="true">
        <!-- <template slot-scope="scope">
           {{statuss[scope.row.type]}}
        </template> -->
      </el-table-column>
      <el-table-column prop="createDate" label="操作时间" min-width="100" align="center" :show-overflow-tooltip="true">
      </el-table-column>
      <el-table-column prop="loginIp" label="登录IP" min-width="100" align="center" :show-overflow-tooltip="true">
      </el-table-column>
    </el-table>

    <!--用户详情-->
    <el-dialog title="用户详情" :visible.sync="FormVisible1" width="1000px" @closed="close1">
      <particular :uid="uid" @hiden="show1" ref="userin"></particular>
    </el-dialog>

    <!--详情-->
    <el-dialog title="书籍详情" :visible.sync="FormVisible2" @closed="close2" width="1000px">
      <bookinfo :id="cbid" @hiden="show2" ref="bookin"></bookinfo>
    </el-dialog>

    <!-- 分页 -->
    <div class="paging">
      <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-sizes="[10, 20, 50, 100]" :page-size="10" layout="total, sizes, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </div>

  </section>
</template>

<script>
import { customerMrRecordpage } from "@/apis/api";
import bookinfo from "@/components/common/bookinfo";
import particular from "@/components/common/particular";
import { Dates } from "@/apis/mUtils";
export default {
  components: {
    bookinfo,
    particular
  },
  data() {
    return {
      statuss: ["修改书币","推送消息","用户管理","书籍管理"],
      // 分页
      currentPage: 1, //获取到用户数据后, 作为请求参数获取当前页面的数据
      total: 0, //总条数
      //搜索
      filters: {
        type: "",
        value1: "",
        value2: ""
      },
      uid: "",
      cbid: "",
      FormVisible1: false,
      FormVisible2: false,
      //具体列表
      users: [],
      tip: ["支付宝", "微信"],
      tip1: ["未支付", "支付完成", "支付失败"],
      listLoading: false, //刷新
      pageSize: 10,
      pickerOptions0: {
        disabledDate: time => {
          return time.getTime() > Date.now();
        }
      },
      pickerOptions1: {
        disabledDate: time => {
          if (this.value1 != "") {
            let moth = new Date(this.filters.value1).getTime();
            return (
              time.getTime() <= moth - 8.64e7 || time.getTime() > Date.now()
            );
          }
        }
      }
    };
  },
  // 获取用户数据
  mounted() {
    this.filters.value1 = Dates.formatDate(
      Date.now() - 8.64e7 * 6,
      "yyyy-MM-dd 00:00:00"
    );
    this.filters.value2 = Dates.formatDate(Date.now(), "yyyy-MM-dd HH:mm:ss");
    this.getUsers();
  },
  methods: {
    //子隐藏
    show1() {
      this.FormVisible1 = false;
    },
    //关闭弹窗时候触发
    close1() {
      this.$refs.userin.Userlist();
      this.getUsers();
    },

    //子隐藏
    show2() {
      this.FormVisible2 = false;
    },
    //关闭弹窗时候触发
    close2() {
      this.$refs.bookin.Booklist();
      this.getUsers();
    },
    //y用户详情
    handleEdit(index, row) {
      this.uid = row.uid;
      // console.log(this.uid)
      this.FormVisible = true;
    },

    handleEdit2(index, row) {
      this.uid = row.inviterId;
      // console.log(this.uid)
      this.FormVisible = true;
    },
    // 分页
    handleSizeChange(val) {
      this.pageSize = val;
      this.getUsers();
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.getUsers();
      console.log(`当前页: ${val}`);
    },

    getUs() {
      this.currentPage = 1;
      this.getUsers();
    },

    // 获取用户列表：
    getUsers() {
      this.listLoading = true;
      let para = {
        type: this.filters.type, //关键字
        pageNo: this.currentPage,
        pageSize: this.pageSize, //每页个数
        startTime: this.filters.value1,
        endTime: this.filters.value2
      };

      customerMrRecordpage(para)
        .then(res => {
          if (res.data.result !== "success") {
            this.$message.error(`获取失败`);
            return false;
          }
          this.users = res.data.data.data;
          this.total = res.data.data.count;
          this.listLoading = false;
        })
        .catch(() => {
          this.$message.error("请求错误");
          this.listLoading = false;
        });
    }
  },
  destroyed() {}
};
</script>

<style lang="less" scoped>
.paging {
  margin: 10px auto;

  text-align: center;
}
.inv {
  margin-bottom: 50px;
}

.toolbar {
  margin-bottom: 50px;
}
.tabtext {
  // display: flex;
  // flex-direction: column;

  span {
    color: red;
    cursor: pointer;
  }
}

.yhtel {
  padding: 30px 10px;
  border-bottom: 3px solid #eee;
  margin-bottom: 20px;
}
</style>