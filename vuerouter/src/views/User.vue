<template>
    <div>
        <el-container>
            <el-header class="NavFont">家庭记账系统
                <div class="User"> 当前用户:{{this.familyname}} <span @click="LoginOut">退出登录</span></div>
            </el-header>

            <el-container>
                <el-aside width="280px">
                    <nav-menu/>
                </el-aside>

                <el-main>
                    <div class="T">
                        <router-view></router-view>
                    </div>
                    
                </el-main>

            </el-container>
        </el-container>
    </div>
</template>

<script>
  import NavMenu from "../components/NavMenu";

  export default {
    name: "Father",

    components: {NavMenu},
    data() {
      return {
        familyname: null,
      }
    },
    methods: {
      LoginOut() {
        alert('是否退出')
        sessionStorage.clear();
        location.reload();
      }
    },
    mounted() {
      this.familyname = sessionStorage.getItem('familyname');
    }
  }
</script>

<style scoped>

    .el-header {
        background: #fff;
        border-bottom: 1px solid #e8e9ed;
        color: #333;
        text-align: center;
        line-height: 60px;
        z-index: 999;
        width: 100%;
        position: fixed;
        top: 0;
    }

    .el-aside {
        background: #fff;
        height: 800px;
        box-shadow: 1px 0 20px rgb(0 0 0 / 8%);
        position: fixed;
        margin-top: 60px;

    }

    .el-main {
        background-color: #f0f1f6;
        color: #333;
        text-align: center;
    }

    .T {

        margin-left: 280px;
        margin-top: 60px;
    }

    .User {

        position: absolute;
        right: 40px;
        top: 1px;
        color: #333;
        font-size: 14px;
        color: #5a6266;

    }

    .User span {
        margin-left: 10px;
    }

    .User span:hover {
        cursor: pointer;
    }


</style>