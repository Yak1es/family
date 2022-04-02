<template>
    <div>
        <div class="FatherDiv">
            <div id="FatherSpend" class="Pie"></div>
        </div>
        <div class="MotherDiv">
            <div id="MotherSpend" class="Pie"></div>
        </div>
        <div class="SonDiv">
            <div id="SonSpend" class="Pie"></div>
        </div>
    </div>

</template>

<script>

  import eventbus from "../../../EventBus";

  export default {
    name: "FamilySpendPie",
    data() {
      return {
        /*父亲图标信息*/
        FatherCharts: null,
        FatherData: [
          {value: 200, name: "保险"},
          {value: 100, name: "话费"},
        ],

        /*母亲图表信息*/
        MotherCharts: null,
        MotherData: [
          {value: 1000, name: "保险"},
          {value: 800, name: "话费"},
        ],

        /*孩子图表信息*/
        SonCharts: null,
        SonData: [
          {value: 300, name: "保险"},
          {value: 150, name: "话费"},
        ],
        /*图标的共同信息*/
        legend: {
          bottom: '2',
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
        },
        roseType: 'area',

      }
    },
    methods: {
      drawFatherSpendPie() {
        this.FatherCharts = this.$echarts.init(document.getElementById("FatherSpend"));
        this.FatherCharts.setOption({
          title: {
            subtext: '父亲支出',
            left: 'center'
          },
          tooltip: {
            trigger: 'item',
          },
          legend: this.legend,
          series: [
            {
              name: '支出',
              type: 'pie',
              radius: ['30%', '50%'],
              center: ['50%', '50%'],
              roseType: this.roseType,
              itemStyle: {
                emphasis: this.emphasis,
                color: function (params) {
                  //自定义颜色
                  var colorList = ["#91cc75", "#fac858", "#73c0de", "#a6bcd2", "#8bd3dd", "#3fb27f", "#fc8452"];
                  return colorList[params.dataIndex];
                }
              },
              data: this.FatherData,

            }
          ]
        })
      },
      drawMotherSpendPie() {
        this.MotherCharts = this.$echarts.init(document.getElementById("MotherSpend"));
        this.MotherCharts.setOption({
          title: {
            subtext: '母亲支出',
            left: 'center'
          },
          tooltip: {
            trigger: 'item',
          },
          legend: this.legend,
          series: [
            {
              name: '支出',
              type: 'pie',
              radius: ['30%', '50%'],
              center: ['50%', '50%'],
              roseType: this.roseType,
              itemStyle: {
                emphasis: this.emphasis,
                color: function (params) {

                  //自定义颜色
                  var colorList = ["#91cc75", "#fac858", "#73c0de", "#a6bcd2", "#8bd3dd", "#3fb27f", "#fc8452"];
                  return colorList[params.dataIndex];;
                }
              },
              data: this.MotherData

            }
          ]

        })
      },
      drawSonSpendPie() {
        this.SonCharts = this.$echarts.init(document.getElementById("SonSpend"));
        this.SonCharts.setOption({
          title: {
            subtext: '儿子支出',
            left: 'center'
          },
          tooltip: {
            trigger: 'item',
          },
          legend: this.legend,
          series: [
            {
              name: '支出',
              type: 'pie',
              radius: ['30%', '50%'],
              center: ['50%', '50%'],
              roseType: this.roseType,
              itemStyle: {
                emphasis: this.emphasis,
                color: function (params) {

                  //自定义颜色
                  var colorList = ["#91cc75", "#fac858", "#73c0de", "#a6bcd2", "#8bd3dd", "#3fb27f", "#fc8452"];
                  return colorList[params.dataIndex];
                }
              },
              data: this.SonData

            }
          ]
        })
      },
      getDataTime() {
        eventbus.$on('DataTime', (params) => {
          console.log(params.Year + '-' + params.Month + '-' + params.Day);
          var date = params.Year + '-' + params.Month + '-' + params.Day
          this.$request.post('/api/ShowData/SpendDay', {'Date': date}).then((res) => {
            console.log(res);
            this.FatherData = res['FatherSpend'];
            this.MotherData = res['MotherSpend'];
            this.SonData = res['SonSpend'];
          }).catch()
        })
      },

    },
    mounted() {
      this.$nextTick(function () {
        this.drawFatherSpendPie()
        this.drawMotherSpendPie()
        this.drawSonSpendPie()
        this.getDataTime()
      });
    },
    watch: {
      'FatherData': function () {
        this.drawFatherSpendPie()
      },
      'MotherData': function () {
        this.drawMotherSpendPie()
      }, 'SonData': function () {
        this.drawSonSpendPie()
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