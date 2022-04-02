<template>
    <div>
        <div class="FatherDiv">
            <div id="FatherIncome" class="Pie"></div>
        </div>
        <div class="MotherDiv">
            <div id="MotherIncome" class="Pie"></div>
        </div>
        <div class="SonDiv">
            <div id="SonIncome" class="Pie"></div>
        </div>
    </div>

</template>

<script>
  import eventbus from "../../../EventBus";

  export default {
    name: "Pie",
    data() {
      return {
        /*父亲图标信息*/
        FatherCharts: null,
        FatherData: [
          {value: 200, name: "工资"},
          {value: 100, name: "外快"},
        ],

        /*母亲图表信息*/
        MotherCharts: null,
        MotherData: [
          {value: 1000, name: "工资"},
          {value: 800, name: "外快"},
        ],

        /*孩子图表信息*/
        SonCharts: null,
        SonData: [
          {value: 300, name: "工资"},
          {value: 150, name: "外快"},
        ],
        /*图标的共同信息*/
        legend: {
          bottom: '10',
          /*块的大小*/
          itemHeight: 8,
          itemWidth: 18,
          /*块字体的大小*/
          textStyle: {
            fontSize: 10,
            color: '#5a6266'
          }
        },
        emphasis: {
          shadowBlur: 15,
          shadowOffsetX: 0,
          shadowColor: "rgba(0, 0, 0, 0.5)"
        }

      }
    },
    methods: {
      drawFatherIncomePie() {
        this.FatherCharts = this.$echarts.init(document.getElementById("FatherIncome"));
        this.FatherCharts.setOption({
          title: {
            subtext: '父亲收入',
            left: 'center'
          },
          tooltip: {
            trigger: 'item',
          },
          legend: this.legend,
          series: [
            {
              name: '收入',
              type: 'pie',
              radius: ['30%', '50%'],
              center: ['50%', '50%'],
              itemStyle: {
                emphasis: this.emphasis,
                color: function (params) {
                  //自定义颜色
                  var colorList = ["#fac858", "#f59e64"];
                  return colorList[params.dataIndex];
                }
              },
              data: this.FatherData,

            }
          ]
        })
      },
      drawMotherIncomePie() {
        this.MotherCharts = this.$echarts.init(document.getElementById("MotherIncome"));
        this.MotherCharts.setOption({
          title: {
            subtext: '母亲收入',
            left: 'center'
          },
          tooltip: {
            trigger: 'item',
          },
          legend: this.legend,
          series: [
            {
              name: '收入',
              type: 'pie',
              radius: ['30%', '50%'],
              center: ['50%', '50%'],
              itemStyle: {
                emphasis: this.emphasis,
                color: function (params) {
                  //自定义颜色
                  var colorList = ["#73c0de", "#617ee2"];
                  return colorList[params.dataIndex];
                }
              },
              data: this.MotherData

            }
          ]

        })
      },
      drawSonIncomePie() {
        this.SonCharts = this.$echarts.init(document.getElementById("SonIncome"));
        this.SonCharts.setOption({
          title: {
            subtext: '儿子收入',
            left: 'center'
          },
          tooltip: {
            trigger: 'item',
          },
          legend: this.legend,
          series: [
            {
              name: '收入',
              type: 'pie',
              radius: ['30%', '50%'],
              center: ['50%', '50%'],
              itemStyle: {
                emphasis: this.emphasis,
                color: function (params) {
                  //自定义颜色
                  var colorList = ["#8ae293", "#59c66c"];
                  return colorList[params.dataIndex];
                }
              },
              data: this.SonData

            }
          ]
        })
      },
      /*获得时间*/
      getDataTime() {
        eventbus.$on('DataTime', (params) => {
          console.log(params.Year + '-' + params.Month + '-' + params.Day);
          var date = params.Year + '-' + params.Month + '-' + params.Day
          this.$request.post('/api/ShowData/IncomeDay', {'Date': date}).then((res) => {
            console.log(res);
            this.FatherData = res['FatherIncome'];
            this.MotherData = res['MotherIncome'];
            this.SonData = res['SonIncome'];
          }).catch()
        })
      }

    },
    mounted() {
      this.$nextTick(function () {
        this.drawFatherIncomePie()
        this.drawMotherIncomePie()
        this.drawSonIncomePie()
        this.getDataTime();
      });
    },
    watch: {
      'FatherData': function () {
        this.drawFatherIncomePie()
      },
      'MotherData': function () {
        this.drawMotherIncomePie()
      }, 'SonData': function () {
        this.drawSonIncomePie()
      }
    }
  }
</script>

<style scoped>


    .Pie {
        width: 280px;
        height: 177px;
    }

    .FatherDiv {

    }

    .MotherDiv {

    }

    .SonDiv {

    }

</style>