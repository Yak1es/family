<template>

    <div class="ColumnarDiv">
        <div class="CTitleDiv">
            <h5 class="Ctitle">家庭收支情况</h5>
            <div class="Year">
                <el-date-picker
                        v-model="value3"
                        type="year"
                        placeholder="选择年" @change="GetYear" value-format="yyyy">
                </el-date-picker>
            </div>


        </div>

        <div id="Category" class="CategoryDiv"></div>
    </div>

</template>

<script>
  import eventbus from "../../../EventBus";

  export default {
    name: "Category",
    data() {
      return {
        value3: null,
        charts: null,
        sr: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
        zc: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
      }
    }, methods: {
      /*柱状图*/
      drawCategory(sr, zc) {
        this.charts = this.$echarts.init(document.getElementById('Category')),
            this.charts.setOption({
              title: {},
              tooltip: {},
              grid: {center: 'center'},
              legend: {
                center: 'center',
                data: ['收入', '支出'],
                itemHeight: 10,
                itemWidth: 23,
                /*块字体的大小*/
                textStyle: {
                  fontSize: 12,
                  color: '#5a6266'
                }
              },
              xAxis:
                  {
                    type: 'category',
                    data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
                    /*添加监听*/
                    triggerEvent: true
                  },
              yAxis: [
                {
                  type: 'value'
                }
              ],
              series: [
                {
                  name: '收入',
                  type: 'bar',
                  data: sr,
                  itemStyle: {
                    color: '#03a9f4',

                  }
                },
                {
                  name: '支出',
                  type: 'bar',
                  data: zc,
                  itemStyle: {
                    color: '#67c23a',
                  }
                }

              ]
            })
        this.charts.on('click', function (params) {
          if (params.componentType == "xAxis") {
            var month;
            if (params.value.length == 2) {
              month = params.value.slice(0, 1);
            }
            if (params.value.length == 3) {
              month = params.value.slice(0, 2);
            }
            eventbus.$emit('SendMonth', month)
          }
        });

      },
      /*根据年份显示柱状图*/
      GetYear() {
        eventbus.$emit('SendYear', this.value3)
        this.$request.post('/api/ShowData/Year', {'year': this.value3}).then((res) => {
           this.sr = res['yearIncome'];
           this.zc = res['yearSpend'];
        }).catch()


      }

    }, mounted() {
      this.$nextTick(function () {
        this.drawCategory(this.sr, this.zc)
      });

    }, watch: {
      'sr': function () {
        this.drawCategory(this.sr, this.zc)
      }
    }
  }
</script>

<style scoped>
    .CategoryDiv {
        width: 700px;
        margin-left: 10px;
        margin-top: 10px;
        height: 440px;
    }

    .ColumnarDiv {
        height: 100%;
        width: 800px;
        background: #fff;
        box-shadow: 0 0 20px rgb(0 0 0 / 8%);
        border-radius: 5px;
    }

    .CTitleDiv {

        margin-top: 5px;
        margin-left: 10px;
        height: 55px;
        line-height: 55px;
        display: flex;

    }

    .Ctitle {
        height: 100%;
        font-weight: 600;
        font-size: 16px;
        text-transform: uppercase;
        margin-bottom: 20px;
        margin-left: 15px;
    }

    .Year {
        margin-left: 30px;
        width: 120px;
    }

    .el-date-editor.el-input /deep/ .el-input__inner {

        border: none;
        width: 120px;

    }

    .el-date-editor.el-input /deep/ .el-input__prefix {
        top: 1px;
        left: 1px;
        transition: all .3s;
        font-size: 20px;
        color: #5a6266;
        width: auto;

    }

    .el-date-editor.el-input /deep/ .el-input__suffix {
        right: auto;

    }

    .el-date-editor.el-input /deep/ ::-webkit-input-placeholder {
        color: #747474;
        font-size: 14px;
    }

</style>