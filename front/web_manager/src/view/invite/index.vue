<template>
  <section class="inv">
    <!--工具条-->
    <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
      <el-form :inline="true" :model="filters">
        <el-form-item label="开始时间：">
          <el-date-picker style="width: 180px;" v-model="filters.value1" type="date" placeholder="选择日期" value-format="yyyy-MM-dd HH:mm:ss" format="yyyy 年 MM 月 dd 日" :picker-options="pickerOptions0">
          </el-date-picker>
        </el-form-item>

        <el-form-item label="结束时间：">
          <el-date-picker style="width: 180px;" v-model="filters.value2" align="center" type="date" placeholder="选择日期" value-format="yyyy-MM-dd 23:59:59" format="yyyy 年 MM 月 dd 日" :picker-options="pickerOptions1">
          </el-date-picker>
        </el-form-item>

        <el-form-item>
          <el-input v-model="filters.name" placeholder="查询用户ID" prefix-icon="el-icon-search" style="width: 150px;" oninput="this.value=this.value.replace(/[^0-9]/g,'');"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="getUs">确认</el-button>
        </el-form-item>
      </el-form>
    </el-col>

    <!--列表-->
    <el-table :data="users" highlight-current-row v-loading="listLoading" style="width: 100%;" border :header-cell-style="{background:'#eee'}">
      <el-table-column prop="relativeInviteName" label="邀请人" min-width="120" align="center" :show-overflow-tooltip="true">

        <template slot-scope="scope">
          <div v-if="scope.row.inviterId == 0"></div>
          <div v-else><el-button size="small" type="text" @click="handleEdit2(scope.$index, scope.row)"> {{scope.row.relativeInviteName}}({{scope.row.inviterId}})</el-button></div>
        </template>
      </el-table-column>
      <el-table-column prop="inviteName" label="注册用户" min-width="120" align="center" :show-overflow-tooltip="true">
        <template slot-scope="scope">
          <el-button size="small" type="text" @click="handleEdit(scope.$index, scope.row)"> {{scope.row.inviteName}}({{scope.row.uid}})</el-button>
        </template>
      </el-table-column>
      <el-table-column prop="deviceCode" label="注册设备码" min-width="90" align="center" :show-overflow-tooltip="true">
      </el-table-column>
      <el-table-column prop="giftReceiveStatus" label="是否领奖" min-width="60" align="center">
        <template slot-scope="scope">
          {{statuss[scope.row.giftReceiveStatus]}}
        </template>
      </el-table-column>
      <el-table-column prop="regDate" label="被邀请人注册时间" min-width="100" align="center" :show-overflow-tooltip="true">
      </el-table-column>
      <el-table-column prop="regDate" label="领奖时间" min-width="100" align="center" :show-overflow-tooltip="true">
        <template slot-scope="scope">
          <p v-if="scope.row.giftReceiveStatus == 1">{{scope.row.regDate}}</p>
        </template>
      </el-table-column>
    </el-table>

    <!--用户详情-->
    <el-dialog title="用户详情" :visible.sync="FormVisible" width="1000px" @closed="close">
      <particular :uid="uid" @hiden="show" ref="userin"></particular>
    </el-dialog>

    <!-- 分页 -->
    <div class="paging">
      <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-sizes="[10, 20, 50, 100]" :page-size="10" layout="total, sizes, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </div>

  </section>
</template>

<script>
import { inviteRecordMgrlist } from "@/apis/api";
import particular from "@/components/common/particular";
import { Dates } from "@/apis/mUtils";
export default {
  components: {
    particular
  },
  data() {
    return {
      statuss: ["未发放", "发放成功", "发放失败"],
      // 分页
      currentPage: 1, //获取到用户数据后, 作为请求参数获取当前页面的数据
      total: 0, //总条数
      //搜索
      filters: {
        name: "",
        rids: "",
        value1: "",
        value2: ""
      },
      uid: "",
      FormVisible: false,
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
    show() {
      this.FormVisible = false;
    },
    //关闭弹窗时候触发
    close() {
      this.$refs.userin.Userlist();
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
        uid: this.filters.name, //关键字
        pageNo: this.currentPage,
        pageSize: this.pageSize, //每页个数
        startDate: this.filters.value1,
        endDate: this.filters.value2
      };

      inviteRecordMgrlist(para)
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