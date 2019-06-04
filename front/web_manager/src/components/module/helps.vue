<template>
  <div class="peizhi">
    <el-form ref="addForm" :model="addForm" label-width="110px" :rules="addFormRules">
      <el-form-item label="问题：" prop="question">
        <el-input v-model="addForm.question" style="width: 440px;" placeholder="单行输入"></el-input><br>
      </el-form-item>
      <el-form-item label="答案：" prop="answer">
        <el-input v-model="addForm.answer" style="width: 440px;" type="textarea" :autosize="{ minRows: 5, maxRows: 10}"></el-input><br>
      </el-form-item>
      <el-form-item label="状态：">
        <el-select v-model="addForm.status" placeholder="有效" style="width: 220px;">
          <el-option label="有效" :value="1">
          </el-option>
          <el-option label="无效" :value="0">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="排序：" prop="orderNo">
        <el-input v-model="addForm.orderNo" style="width: 220px;" placeholder="单行输入"></el-input>
      </el-form-item>
      <el-form-item label="渠道：">
        <el-input v-model="addForm.channle" style="width: 220px;" placeholder="单行输入"></el-input><br>
        <span>渠道为空时，对所有可见，多渠道并存是用 , 隔开</span>
      </el-form-item>
    </el-form>
    <div class="foot">
      <div class="login-btn">
        <el-button type="danger" @click="onSubmit">确定</el-button>
      </div>
      <div class="login-btn">
        <el-button type="info" @click="go">取消</el-button>
      </div>
    </div>
  </div>
</template>

<script>
import { helpinsert, helpupdate } from "@/apis/api";
export default {
  data() {
    return {
      addForm: {
        answer: "",
        channle: "",
        orderNo: 0,
        question: "",
        status: 1
      },
      addFormRules: {
         question: [{ required: true, message: "请填写内容", trigger: "blur"}],
         answer: [{ required: true, message: "请填写内容", trigger: "blur"}],
         orderNo: [{ required: true, message: "请填写内容", trigger: "blur"}],
      },
      hiden: false
    };
  },
  props: ["poplist", "add"],
  methods: {
    onSubmit() {
      this.$refs.addForm.validate(valid => {
        if (valid) {
          this.$confirm("确认提交吗?", "提示", {
            confirmButtonText: "确定",
            cancelButtonText: "取消",
            type: "warning"
          }).then(() => {
            if (this.add == 0) {
              helpupdate(this.addForm).then(res => {
                console.log(res);
                if (res.data.result !== "success") {
                  this.$message.error(`修改失败`);
                  return false;
                }
                this.$message.success("修改成功");
              });
              this.$emit("hiden");
            } else {
              helpinsert(this.addForm).then(res => {
                console.log(res);
                if (res.data.result !== "success") {
                  this.$message.error(`添加失败`);
                  return false;
                }
                this.$message.success("添加成功");
              });
              this.$emit("hiden");
            }
          });
        } else {
          console.log(this.addForm);
          this.$message.warning("请输入完整信息");
        }
      });
    },

    go() {
      this.$emit("hiden");
      this.$refs.addForm.resetFields();
    }
  },
  watch: {
    poplist(e) {
      this.addForm = e;
    }
  },

  mounted() {
    this.addForm = this.poplist;
  }
};
</script>


<style lang="less" scoped>
.foot {
  display: flex;
  height: 100px;
  justify-content: center;
  align-items: center;
}

.login-btn {
  text-align: center;
}
.login-btn button {
  width: 120px;
  height: 36px;
  margin: 0 30px;
}
</style>
