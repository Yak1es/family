<template>

    <div class="ShowDataDiv">
        <el-row :gutter="20">
            <!--日历-->
            <el-col :span="12">
                <div class="Calendar">
                    <v-calendar @dayclick="onDayClick" style="height: 566px;border: none" ref="calendars" is-expanded
                    ></v-calendar>
                </div>
            </el-col>
            <!--图表-->
            <el-col :span="12">
                <div class="MemberDiv">
                    <!--收入 与支出-->
                    <el-row :gutter="20">
                        <!--家庭成员收入-->
                        <el-col :span="12">
                            <div class="PieDiv">
                                <div class="PieTitle">
                                    <strong> 收入</strong>
                                </div>

                                <family-income-pie/>

                            </div>
                        </el-col>

                        <!--家庭成员支出-->
                        <el-col :span="12">
                            <div class="PieDiv">
                                <div class="PieTitle">
                                    <strong> 支出</strong>
                                </div>
                                <family-spend-pie/>
                            </div>
                        </el-col>

                    </el-row>
                </div>


            </el-col>
        </el-row>
    </div>


</template>

<script>

  import FamilyIncomePie from "./FamilyIncomePie";
  import FamilySpendPie from "./FamilySpendPie";
  import eventbus from "../../../EventBus";
  export default {
    name: "FamilyCalendar",
    components: {FamilyIncomePie, FamilySpendPie},
    data() {
      return {};
    },

    methods: {
      onDayClick() {

        // console.log(this.$refs.calendars)
        this.calendars = this.$refs.calendars;
        console.log(this.calendars.firstPage.month, this.calendars.firstPage.year, this.calendars.focusableDay)
        eventbus.$emit('DataTime',{'Year':this.calendars.firstPage.year,'Month':this.calendars.firstPage.month,'Day':this.calendars.focusableDay});

      },


    },
  }
</script>

<style scoped>


    /*显示日历和成员的盒子*/
    .ShowDataDiv {
        margin-top: 20px;
        width: 100%;
    }

    /*日历盒子*/
    .Calendar {
        box-shadow: 0 0 20px rgb(0 0 0 / 8%);
    }

    .el-calendar {
        border-radius: 5px;
    }

    .el-calendar /deep/ .el-calendar-day {
        width: 60px;
        height: 70px;
    }

    /*家庭成员盒子*/
    .MemberDiv {

    }

    /*第一个div 是标题*/
    .PieDiv {
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0 0 20px rgb(0 0 0 / 8%);
        display: flex;
        /*让元素换行*/
        flex-wrap: wrap;
        /*设置flex布局换行后的间隔*/
        align-content: flex-start;
    }

    .PieTitle {
        text-align: left;
        border-bottom: 1px solid rgba(0, 0, 0, .125);
        width: 100%;
        height: 26px;
        padding: 0.25rem 0.5rem;
        font-size: 15px;
    }

    /*日历样式*/
    .vc-container /deep/ .vc-header {
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 10px 18px 0 18px;
        height: 50px;
        margin-bottom: 10px;
    }

    .vc-container /deep/ .vc-day {

        min-height: 80px;
    }


</style>