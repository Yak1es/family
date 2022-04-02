<template>
    <div>
        <div>
            <el-row :gutter="20">
                <el-col :span="6">
                    <div class="grid-content bg-purple">
                        <div class="info">
                            <i class="el-icon-tickets"></i>
                            <div class="Money">
                                   <span> $
                                    <countTo
                                            :startVal='startVal'
                                            :endVal='endVal'
                                            :duration='duration'>
                                  {{endVal}}</countTo>
                                </span>
                                <p>今日收入</p>
<!--                                <el-button @click="tt">tttt</el-button>-->
                            </div>

                        </div>

                    </div>
                </el-col>

                <el-col :span="6">
                    <div class="grid-content bg-purple">
                        <div class="info">
                            <i class="el-icon-document"></i>
                            <div class="Money">
                                <span> $
                                    <countTo
                                            :startVal='startVal'
                                            :endVal='endVal'
                                            :duration='duration'>
                                  {{endVal}}</countTo>
                                </span>
                                <p>今日支出</p>
                            </div>

                        </div>

                    </div>
                </el-col>


                <el-col :span="6">
                    <div class="grid-content bg-purple">
                        <div class="info">
                            <i class="el-icon-coin"></i>
                            <div class="Money">
                                  <span> $
                                    <countTo
                                            :startVal='startVal'
                                            :endVal='endVal'
                                            :duration='duration'>
                                  {{endVal}}</countTo>
                                </span>
                                <p>本月收入</p>
                            </div>

                        </div>

                    </div>
                </el-col>
                <el-col :span="6">
                    <div class="grid-content bg-purple">
                        <div class="info">
                            <i class="el-icon-notebook-1"></i>
                            <div class="Money">
                                <span> $
                                    <countTo
                                            :startVal='startVal'
                                            :endVal='endVal'
                                            :duration='duration'>
                                  {{endVal}}</countTo>
                                </span>
                                <p>本月支出</p>
                            </div>

                        </div>

                    </div>
                </el-col>
            </el-row>
        </div>

        <!--本月家庭的收入与支出-->
        <div class="BarDiv">
            <!--柱状图-->

            <month-category/>

            <!--饼图-->
            <month-pie/>

        </div>


        <!--每月家庭的收入与支出-->
        <div class="DataInfo">
            <div class="TableTitle">
                每日收支
            </div>
            <family-calendar/>
        </div>
        <!--每月家庭的收入与支出-->
        <div class="TableDataDiv">
            <!--标题-->
            <div class="TableTitle">详情记录</div>

            <family-data-table/>


        </div>


    </div>

</template>

<script>

  import countTo from 'vue-count-to'
  import MonthCategory from "../HomeDataComponents/Family/MonthCategory";
  import MonthPie from "../HomeDataComponents/Family/MonthPie";
  import FamilyCalendar from "../HomeDataComponents/Day/FamilyCalendar";
  import FamilyDataTable from "../HomeDataComponents/TableComponents/FamilyDataTable";

  export default {
    name: "HomePage",
    components: {countTo, MonthCategory, MonthPie, FamilyCalendar, FamilyDataTable},
    data() {
      return {
// 需要滚动的时间
        duration: 4000,
        // 初始值
        startVal: 0,
        // 最终值
        endVal: 23569,
        month: null,
      }
    },

    methods: {
      tt() {
        this.$request.post('/api/test',null).then((res)=>{
          console.log(res);
        }).catch()
      }
    }

  }
</script>

<style scoped>
    .grid-content {
        position: relative;
        border-radius: 5px;
        background-color: #fff;
        width: 273px;
        height: 97px;
        box-shadow: 0 0 20px rgb(0 0 0 / 8%);
    }

    .info {
        line-height: 22px;
        justify-content: center;
        align-items: center;
        display: flex;
        height: 100%;
    }

    .info i {
        font-size: 55px;
        position: absolute;
        left: 30px;
    }

    /*图标*/
    .el-icon-tickets {
        color: #00c292;
    }

    .el-icon-document {
        color: #03a9f3;
    }

    .el-icon-coin {
        color: #fba878;
    }

    .el-icon-notebook-1 {
        color: #ab8ce4;
    }


    .info span {
        color: #455a64;
        font-size: 20px;
    }

    .info p {
        color: #a6bac7;
        font-size: 14px;
    }

    .Money {
        position: absolute;
        left: 120px;
        top: 20px;
    }

    /*家庭收支图片*/
    .BarDiv {
        position: relative;
        border-radius: 5px;
        margin-top: 30px;
        height: 500px;
        display: flex;
    }

    /*家庭成员数据div*/
    .DataInfo {
        position: relative;
        border-radius: 5px;
        margin-top: 30px;

    }

    /*具体数据*/
    .TableDataDiv {
        position: relative;
        border-radius: 5px;
        margin-top: 30px;
        height: 500px;

    }

    .TableTitle {
        background: #fff;
        border-radius: 5px;
        height: 55px;
        line-height: 55px;
        box-shadow: 0 0 20px rgb(0 0 0 / 8%);
        text-align: left;
        font-weight: 600;
        font-size: 16px;
        text-indent: 1em;

    }


</style>