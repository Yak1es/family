<template>
    <div>
        <el-row class="tac">
            <el-col :span="12">
                <el-menu class="el-menu-vertical-demo"
                         @open="handleOpen" @close="handleClose"
                         background-color="#fff" text-color="#607d8b"
                         :default-active="$route.path">


                    <el-menu-item class="Home">
                        <i class="el-icon-house"></i>
                        <span slot="title" @click="Home" index="/User/Home">首页</span>
                    </el-menu-item>

                    <el-menu-item>

                        <span class="Record">收支记录</span>
                    </el-menu-item>
                    <el-submenu index="1">
                        <template slot="title">
                            <i class="el-icon-date"></i>
                            <span>日常收支</span>
                        </template>
                        <el-menu-item-group>
                            <el-menu-item index="/User/FatherSpendPage" @click="FatherSpendPage">今日开支</el-menu-item>
                            <el-menu-item index="/User/FatherIncomePage" @click="FatherIncomePage">今日收支</el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                    <el-submenu index="2">
                        <template slot="title">
                            <i class="el-icon-s-data"></i>
                            <span>家庭统计</span>
                        </template>
                        <el-menu-item-group>
                            <el-menu-item index="/User/PersonalPage" @click="MeberPage">个人收支</el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>


                </el-menu>
            </el-col>
        </el-row>
    </div>
</template>

<script>
  export default {
    name: "NavMenu",
    data() {
      return {}
    },
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      Home() {

        this.$router.push({path: '/User/Home'})
      },
      FatherSpendPage() {
        this.$router.push({path: '/User/FatherSpendPage'})
      },
      FatherIncomePage() {
        this.$router.push({path: '/User/FatherIncomePage'})
      },
      MeberPage() {
        this.$router.push({path: '/User/PersonalPage'})
      }

    }
  }
</script>

<style scoped>
    .el-col-12 {
        width: 100%;
    }

    .el-menu {
        border: none;

    }

    .el-submenu /deep/ .el-submenu__title {
        padding-right: 30px;
        padding-left: 30px !important;
    }

    .el-menu-item-group /deep/ .el-menu-item {

        padding-left: 75px !important;
    }

    .el-menu i {
        width: 40px;
        font-size: 17px;
        margin-right: 7px;
    }

    .el-menu span {
        font-size: 16px;
    }

    .Home {
        padding-right: 30px;
        padding-left: 30px !important;
    }

    .Record {

        color: #41434d;
        font-size: 18px !important;
        font-weight: 700;
        text-transform: uppercase;
        padding-left: 20px;
        letter-spacing: 1px;
    }

    /*选中颜色*/
    .el-menu-item.is-active {
        color: #0facf4;
        font-size: 16px;
        font-weight: 400;
    }

</style>