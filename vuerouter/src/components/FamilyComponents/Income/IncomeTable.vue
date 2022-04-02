<template>

    <div>
        <div class="SpendTitle">往日收支
            <el-button class="addbutton" size="mini" type="primary" plain round @click="dialogVisible=true">添加记录
            </el-button>
        </div>
        <!--添加记录框-->
        <el-dialog :visible.sync="dialogVisible" width="30%">
            <div slot="title" class="dialog-title">

                <span class="title-text">今日收支</span>
                <div class="button-right">
                    <span class="title-close" @click="dialogVisible = false"></span>
                </div>
            </div>

            <el-form ref="form" :model="form" label-width="80px" label-position="left" size="mini">
                <el-form-item label="支出类型">
                    <el-select v-model="form.income" placeholder="请选择支出类型">
                        <el-option label="外快" value="外快"></el-option>
                        <el-option label="工资" value="工资"></el-option>

                    </el-select>
                </el-form-item>
                <el-form-item label="收入金额">
                    <el-input v-model="form.money"></el-input>
                </el-form-item>
                <el-form-item label="详情描述">
                    <el-input type="textarea" v-model="form.moneynote" style="font-size: 15px;"></el-input>
                </el-form-item>

                <div>
                    <el-button type="primary" size="mini" @click="AddSpendRecord(form)">确定</el-button>
                    <el-button @click="dialogVisible = false" size="mini">取消</el-button>
                </div>


            </el-form>
        </el-dialog>

        <div>

            <!--表格-->
            <el-table
                    ref="filterTable"
                    :data="tableData.slice((currentPage-1)*pageSize,currentPage*pageSize)"
                    style="width: 100%"
                    :header-cell-style="{background:'#eeeff4',color:'#5d5e5e',fontSize:'14px',fontWeight:' normal',textTransform: 'uppercase'}"
                    v-if="isShowDataTime"
            >
                <el-table-column
                        prop="idate"
                        label="日期"
                        sortable
                        width="180"
                        column-key="date"
                >
                </el-table-column>
                <el-table-column
                        prop="moneynote"
                        label="支出详情">
                </el-table-column>
                <el-table-column
                        prop="money"
                        label="金额">
                </el-table-column>
                <el-table-column
                        prop="income"
                        label="收入类型">
                </el-table-column>

            </el-table>

            <!--分页按钮-->
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="currentPage"
                    :page-sizes="[10, 20, 30, 50, 100]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="tableData.length">
            </el-pagination>

        </div>
    </div>
</template>

<script>
  export default {
    data() {
      return {
        currentPage: 1,
        pageSize: 10,
        tableData: [],
        filtersarray: [],
        dialogVisible: false,
        isShowDataTime: false,
        form: {
          idate: null,
          money: null,
          income: null,
          moneynote: null,
          fk_familyid: null
        }
      }

    }
    ,
    methods: {
      // 每页多少条
      handleSizeChange(val) {
        console.log(123)
        this.pageSize = val;

      }
      ,
      // 当前页
      handleCurrentChange(val) {
        this.currentPage = val;
      },

      /*添加数据*/
      AddSpendRecord(from) {
        from.fk_familyid = sessionStorage.getItem('familyid');
        from.idate = this.getNowFormatDate()
        console.log(from);
        this.$request.post('/api/AddData/AddIncome', from).then((res) => {
          this.dialogVisible = false;
          if (res) {
            location.reload();
          }
        }).catch()
      },
      /*获取当前时间*/
      getNowFormatDate() {
        var date = new Date();
        var seperator1 = "-";
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
          month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
          strDate = "0" + strDate;
        }
        var currentdate = year + seperator1 + month + seperator1 + strDate;
        return currentdate;
      }
    }
    ,
    created() {
      /*页面加载请求数据*/
      this.$request.post('/api/ShowData/ShowIncomeRecord', {'FamilyId': sessionStorage.getItem('familyid')}).then((res) => {
        this.tableData = res;
        this.isShowDataTime = true;
      }).catch()
    }
  }
</script>
<style scoped>
    .SpendTitle {
        background: #fff;
        border-radius: 5px;
        height: 55px;
        line-height: 55px;
        box-shadow: 0 0 20px rgb(0 0 0 / 8%);
        text-align: left;
        font-weight: 600;
        font-size: 16px;
        text-indent: 1em;
        color: #00aaf8;
        position: relative;
    }

    .addbutton {

        position: absolute;
        right: 5px;
        top: 14px;
        color: #00aaf8;
        background-color: transparent;
        background-image: none;
        border-color: #00aaf8;

    }

    .el-pagination {
        margin-top: 8px;
        border-radius: 5px;
        box-shadow: 0 0 20px rgb(0 0 0 / 8%);
        background-color: #fff;
    }

    .el-pagination /deep/ .el-input__inner {
        border: 1px solid #fff;
    }

    .el-select {
        display: block;
    }


    /*对话框*/
    .dialog-title {
        text-align: left;
        font-size: 14px;
        font-weight: 700;
        overflow: hidden;
    }

    .el-select-dropdown {
        top: 150px;
    }


</style>