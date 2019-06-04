<template>
  <section class="gifts-exchange">
    <div class="operations">
      <el-form :inline="true" :model="filters">
        <el-form-item>
          <el-select v-model="filters.exchangeType" placeholder="礼品类型">
            <el-option label="全部" value/>
            <el-option label="金豆" :value="'gold'"/>
            <el-option label="现金" :value="'rmb'"/>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-select v-model="filters.orderStatus" placeholder="订单状态">
            <el-option label="全部" value/>
            <el-option
              v-for="(value, name, index) in orderStatusObj"
              :key="index"
              :label="value"
              :value="+name"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="兑换创建时间：">
          <el-date-picker
            style="width: 180px;"
            v-model="filters.startTime"
            type="date"
            placeholder="选择日期"
            value-format="yyyy-MM-dd HH:mm:ss"
            format="yyyy 年 MM 月 dd 日"
            :picker-options="pickerOptionsStart"
          ></el-date-picker>
        </el-form-item>
        <el-form-item label="至">
          <el-date-picker
            style="width: 180px;"
            v-model="filters.endTime"
            align="center"
            type="date"
            placeholder="选择日期"
            value-format="yyyy-MM-dd HH:mm:ss"
            format="yyyy 年 MM 月 dd 日"
            :picker-options="pickerOptionsEnd"
          ></el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-input v-model="filters.cuId" placeholder="用户ID"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="search(1)">搜索</el-button>
        </el-form-item>
      </el-form>
    </div>
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      fit
      highlight-current-row
      header-cell-class-name="table-hd"
      :row-key="getRowKeys"
      :expand-row-keys="expands"
      @current-change="toggleRowExpansion"
    >
      <el-table-column type="expand">
        <template slot-scope="scope">
          <div class="fold-info">
            <div>
              <img>
              <ul>
                <li class="title">用户昵称：{{scope.row.nickName || '--'}}</li>
                <li
                  v-if="scope.row.exchangeType === 'gold'"
                >金豆扣减前：{{scope.row.noDeduction}} 金豆扣减后：{{scope.row.deductioned}}</li>
                <li
                  v-if="scope.row.exchangeType === 'rmb'"
                >现金扣减前：{{scope.row.noDeduction}} 现金扣减后：{{scope.row.deductioned}}</li>
                <li>注册时间：{{scope.row.regDate || '--'}}</li>
              </ul>
            </div>
            <div>备注：{{scope.row.remark || '--'}}</div>
            <div>
              <el-button type="primary" @click="showReview(scope.row.id)">审核</el-button>
            </div>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="兑换订单编号">
        <template slot-scope="scope">{{ scope.row.orderNo || '--'}}</template>
      </el-table-column>
      <el-table-column label="兑换用户" align="center" width="120">
        <template slot-scope="scope">
          <router-link
            class="title"
            :to="`/user/detail/${scope.row.cuId}`"
          >{{ `${scope.row.nickName}(${scope.row.cuId})` || '--'}}</router-link>
        </template>
      </el-table-column>
      <el-table-column label="礼品名称" align="center" width="200">
        <template slot-scope="scope">{{ scope.row.goodsName || '--'}}</template>
      </el-table-column>
      <el-table-column label="礼品类型" align="center" width="100">
        <template slot-scope="scope">{{ scope.row.exchangeType === 'gold' ? '金豆':'现金' }}</template>
      </el-table-column>
      <el-table-column label="扣减消耗" width="100" align="center">
        <template slot-scope="scope">{{scope.row.cost || '--'}}</template>
      </el-table-column>
      <el-table-column label="兑换创建时间" width="140" align="center">
        <template slot-scope="scope">{{ scope.row.createTime || '--' }}</template>
      </el-table-column>
      <el-table-column label="兑换处理时间" width="140" align="center">
        <template slot-scope="scope">{{ scope.row.auditTime || '--' }}</template>
      </el-table-column>
      <el-table-column label="状态" width="100" align="center">
        <template slot-scope="scope">{{ orderStatusObj[scope.row.orderStatus] || '--' }}</template>
      </el-table-column>
      <el-table-column label="操作" width="100" align="center">
        <template slot-scope="scope">
          <el-button type="primary" @click="toggleRowExpansion(scope.row)">查看</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="审核" :visible.sync="visible" width="40%" @close="close">
      <el-form ref="form" :model="form" :rules="rules" label-position="right" label-width="120px">
        <el-form-item label="审核结果：" prop="orderStatus">
          <el-radio-group v-model="form.orderStatus">
            <el-radio :label="1">通过</el-radio>
            <el-radio :label="2">不通过</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="备注：">
          <el-input type="textarea" :rows="4" maxlength="300" show-word-limit placeholder="请输入备注（非必填）" v-model="form.remark"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onValidate('form')">提交</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <!-- 分页 -->
    <div class="paging" v-if="count">
      <el-pagination
        background
        @current-change="search"
        :current-page="pageNo"
        :page-size="pageSize"
        layout="total, prev, pager, next, jumper"
        :total="count"
      ></el-pagination>
    </div>
  </section>
</template>
<script>
import { getExchangeRecords, exchangeAudit } from "@/apis/gifts";
import { Dates } from "@/apis/mUtils";
export default {
  computed:{
    _cuId(){
      return this.$route.params.id
    }
  },
  mounted() {
    if(this._cuId){
      this.filters = Object.assign({},this.filters,{
        orderStatus : '',
        startTime : '',
        endTime : '',
        cuId : this._cuId
      })
      
    }else{
      this.filters.startTime = Dates.formatDate(
        Date.now() - 8.64e7 * 6,
        "yyyy-MM-dd 00:00:00"
      );
      this.filters.endTime = Dates.formatDate(Date.now(), "yyyy-MM-dd HH:mm:ss");
    }
    this.fetchData();
  },
  data() {
    return {
      pageNo: 1,
      pageSize: 10,
      count: 0,
      orderStatusObj: {
        0: "审核中",
        1: "审核成功",
        2: "审核失败"
        // 3: '微信发送处理中',
        // 4: '红包发送成功',
        // 5: '红包发送失败'
      },
      filters: {
        exchangeType: "",
        orderStatus: 0,
        startTime: "",
        endTime: "",
        cuId: ""
      },
      list: [],
      listLoading: false,
      visible: false,
      form: {
        orderStatus: '',
        remark: ''
      },
      reviewItemId:'',
      rules:{
        orderStatus: [
          { required: true, message: '请选择审核结果', trigger: 'blur' }
        ],
      },
      getRowKeys(row) {
        return row.id;
      },
      expands: [0],
      pickerOptionsStart: {
        disabledDate: time => {
          return time.getTime() > Date.now();
        }
      },
      pickerOptionsEnd: {
        disabledDate: time => {
          if (this.filters.startTime != "") {
            let moth = new Date(this.filters.startTime).getTime();
            return (
              time.getTime() <= moth - 8.64e7 || time.getTime() > Date.now()
            );
          }
        }
      }
    };
  },
  methods: {
    search(val) {
      this.pageNo = val;
      this.fetchData();
    },
    fetchData() {
      this.listLoading = true;
      let param = Object.assign({}, this.filters, {
        pageNo: this.pageNo,
        pageSize: this.pageSize
      });
      getExchangeRecords(param).then(({ data }) => {
        this.list = data.data.data;
        this.count = data.data.count;
        this.listLoading = false;
      });
    },
    toggleRowExpansion(row) {
      this.expands = [];
      this.expands.push(row.id);
    },
    showReview(id){
      this.visible = true
      this.reviewItemId = id
    },
    close(){
      this.reviewItemId = ''
    },
    onValidate(formName){
      this.$refs[formName].validate(valid => {
        if(valid){
          this.onSubmit()
        }
      })
    },
    onSubmit(){
      this.$alert('提交后将立即付款给用户，您确定提交审核操作吗', '提示', {
        confirmButtonText: '确定'
      }).then(() =>{
        let param = Object.assign({},this.form,{
          id: this.reviewItemId
        })
        exchangeAudit(param).then(() => {
          this.fetchData
        })
      })
    }
  }
};
</script>
<style lang="less" scoped>
.gifts-exchange {
  .title {
    color: #409eff;
  }
  ul {
    line-height: 30px;
  }
  .fold-info {
    display: flex;
    align-items: center;
    justify-content: space-between;
    > div {
      width: 33%;
    }
    > div:first-child {
      img {
        float: left;
        width: 80px;
        height: 80px;
        margin-right: 15px;
        border: solid 1px #ccc;
      }
    }
    > div:last-child {
      width: auto;
    }
  }
}
</style>
