<template>
    <div class="PieDiv">
        <div class="PieTypeS">
            <div class="PieTitleS">{{year+'年'+month+'月'}}家庭支出</div>
            <div class="PieTypeSTx">
                <div id="pieReportS" class="Pie"></div>
            </div>
        </div>
        <div class="PieTypeC">
            <div class="PieTitleC">{{year+'年'+month+'月'}}家庭收入</div>
            <div class="PieTypeCTx">
                <div id="pieReportI" class="Piei"></div>
            </div>
        </div>
    </div>
</template>

<script>
  import eventbus from "../../../EventBus";

  export default {
    name: "MonthPie",
    data() {
      return {
        month: '1',
        year: '2021',
        /*月支出*/
        spendPie: null,
        spendInfo: ['保险','娱乐', '日用品','水电气油','购物', '话费', '食品'],
        spendData: [
          {name: '保险', value: 12},
          {name: '娱乐', value: 18},
          {name:  '日用品', value: 30},
          {name: "水电气油", value: 40},
          {name: '购物', value: 40},
          {name: "话费", value: 40},
          {name: '食品', value: 40},
        ],
        /*月收入*/
        incomePie: null,
        incomeInfo: ['外快', '工资'],
        incomeData: [
          {name: '外快', value: 5000},
          {name: '工资', value: 8000},
        ]

      }
    }, methods: {
      /*支出*/
      drawSpendingPie() {
        /*初始化实例对象*/
        this.spendPie = this.$echarts.init(document.getElementById("pieReportS"))
        /*配置数据项*/
        let options = {
          /*鼠标移动有提示*/
          tooltip: {
            trigger: "item",
            formatter: "{a}<br/>{b}:{c} ({d}%)"
          },
          /*小块的位置*/
          legend: {
            bottom: 0,
            left: 15,
            top: 25,
            orient: 'vertical',
            /*块的大小*/
            itemHeight: 10,
            itemWidth: 22,
            /*块字体的大小*/
            textStyle: {
              fontSize: 12,
              color: '#5a6266'
            }
          },
          series: [
            {
              name: "金额",
              type: "pie",
              radius: ['40%', '60%'],
              center: ["50%", "50%"],
              labelLine: {
                length: 4,
                length2: 8
              },
              itemStyle: {
                emphasis: {
                  shadowBlur: 15,
                  shadowOffsetX: 0,
                  shadowColor: "rgba(0, 0, 0, 0.5)"
                },
                color: function (params) {
                  //自定义颜色
                  var colorList = ["#91cc75", "#fac858", "#73c0de", "#a6bcd2", "#8bd3dd", "#3fb27f", "#fc8452"];
                  return colorList[params.dataIndex];
                }
              },
              data: this.spendData
            }

          ],

        }
        /*将配置项赋值给charts*/
        this.spendPie.setOption(options, true);
      },
      /*收入*/
      drawIncomePie() {
        /*初始化实例对象*/
        this.incomePie = this.$echarts.init(document.getElementById("pieReportI"))
        /*配置数据项*/
        let options = {
          /*鼠标移动有提示*/
          tooltip: {
            trigger: "item",
            formatter: "{a}<br/>{b}:{c} ({d}%)"
          },
          /*小块的位置*/
          legend: {
            bottom: 0,
            left: 15,
            top: 25,
            data: this.incomeInfo, /*小块名称*/
            orient: 'vertical',
            /*块的大小*/
            itemHeight: 10,
            itemWidth: 22,
            /*块字体的大小*/
            textStyle: {
              fontSize: 12,
              color: '#5a6266'
            }
          },
          series: [
            {
              name: "金额",
              type: "pie",
              radius: ['40%', '60%'],
              center: ["50%", "50%"],
              labelLine: {
                length: 4,
                length2: 8
              },
              itemStyle: {
                emphasis: {
                  shadowBlur: 15,
                  shadowOffsetX: 0,
                  shadowColor: "rgba(0, 0, 0, 0.5)"
                },
                color: function (params) {
                  //自定义颜色
                  var colorList = ["#91cc75", "#fac858"];
                  return colorList[params.dataIndex];
                }
              },
              data: this.incomeData
            }

          ],

        }
        /*将配置项赋值给charts*/
        this.incomePie.setOption(options);

      },
      /*对应柱状图*/
      GetYear() {
        eventbus.$on('SendYear', (year) => {
          this.year = year;
          this.$request.post('/api/ShowData/Month', {'Year': this.year, 'Month': 1}).then((res) => {
            this.incomeData = res['MonthIncome'];
            this.spendData = res['MonthSpend'];
          }).catch();
        })
      },
      GetMonth() {
        eventbus.$on('SendMonth', (month) => {
          this.month = month;
          this.$request.post('/api/ShowData/Month', {'Year': this.year, 'Month': this.month}).then((res) => {
            this.incomeData = res['MonthIncome'];
            this.spendData = res['MonthSpend'];
          }).catch();
        })
      },
      /*动态监控数据*/
      PieSpendChange() {
        this.drawSpendingPie();
      },
      PieIncomeChange() {
        this.drawIncomePie();
      }
    },
    mounted() {
      this.$nextTick(function () {
        this.drawSpendingPie();
        this.drawIncomePie();
        this.GetYear();
        this.GetMonth();
      });

    },
    /*监听数据变化*/
    watch: {
      'spendData': function () {
        this.PieSpendChange();
      },
      'incomeData': function () {
        this.PieIncomeChange();
      }
    }
  }
</script>

<style scoped>
    .Piei {
        width: 100%;
        height: 200px;
    }

    .Pie {
        width: 100%;
        height: 200px;
        margin-top: 5px;
    }

    .PieDiv {
        margin-left: 30px;
        width: 500px;
    }

    .PieTypeS {
        background-color: #fff;
        border-radius: 5px;
        height: 240px;
        box-shadow: 0 0 20px rgb(0 0 0 / 8%);
        display: flex;
        flex-wrap: wrap;
        align-content: flex-start;
    }

    .PieTitleS {
        margin-top: 10px;
        width: 100%;
        height: 20px;
        font-weight: 600;
        font-size: 15px;
        text-transform: uppercase;
        line-height: 20px;
        color: #536168;

    }

    .PieTypeSTx {

        width: 100%;

    }

    .PieTypeC {
        background-color: #fff;
        border-radius: 5px;
        height: 240px;
        box-shadow: 0 0 20px rgb(0 0 0 / 8%);
        margin-top: 20px;
    }

    .PieTitleC {
        width: 100%;
        height: 35px;
        font-weight: 600;
        font-size: 15px;
        text-transform: uppercase;
        line-height: 35px;
        color: #536168;

    }

    .PieTypeCTx {

    }
</style>