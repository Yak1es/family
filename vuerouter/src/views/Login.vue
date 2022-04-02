<template>
    <div class="login-container">
        <el-image class="login-pic" :src="require('../assets/img/login.png')">
        </el-image>
        <el-form class="login-form" label-width="80px" :model="user" :rules="rules">
            <el-form-item>
                <h1 class="login-form-heading">家庭记账系统</h1>
            </el-form-item>
            <el-form-item label="用户名" prop="username">
                <el-input v-model="user.familyname" autofocus></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input type="password" v-model="user.familypassword"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button
                        type="primary"
                        @click="submitForm(user)"
                >
                    登录
                </el-button>
            </el-form-item>
        </el-form>
    </div>

</template>

<script>
  export default {
    name: "Login",
    data() {

      return {
        user: {
          familyname: '',
          familypassword: '',
        },
        rules: {
          Familyname: [
            {required: true, message: '用户名必填', trigger: 'blur'},
          ],
          Familypassword: [
            {required: true, message: '密码必填', trigger: 'blur'},
          ],
        },
      };
    },
    methods: {
      submitForm(user) {
        this.$request.post('/api/Login/UserLogin', user).then((res) => {
          if (res === 'Family1') {
            sessionStorage.setItem('familyid', res.toString());
            sessionStorage.setItem('familyname', user.familyname);
            this.$router.push({path: '/User/Home'}).catch(() => {
              alert('请先登录')
            })

          } else if (res === 'Family2') {
            sessionStorage.setItem('familyid', res.toString());
            sessionStorage.setItem('familyname', user.familyname);
            this.$router.push({path: '/User/Home'}).catch(() => {
              alert('请先登录')
            })
          } else if (res === 'Family3') {
            sessionStorage.setItem('familyid', res.toString());
            sessionStorage.setItem('familyname', user.familyname);
            this.$router.push({path: '/User/Home'}).catch(() => {
              alert('请先登录')
            })
          } else {
            alert('密码账号错误');
          }

        }).catch()

      },

    }
  }

</script>

<style scoped>
    .login-container {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .login-pic {
        width: 30vw;
        min-width: 300px;
        margin-right: 100px;
    }

    .login-form {
        width: 30vw;
        min-width: 300px;
    }

    .el-form-item:last-child {
        margin-bottom: 0;
    }

    .login-form-heading {
        margin: 0;
    }

</style>