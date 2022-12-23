<template>
  <div class="login">
    <el-card>
      <h2>Login</h2>
      <el-form
          class="login-form"
          :model="model"
          :rules="rules"
          ref="form"
          @submit.native.prevent="login"
      >
        <el-form-item prop="username">
          <el-input v-model="model.username" placeholder="Username" prefix-icon="fas fa-user"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
              v-model="model.password"
              placeholder="Password"
              type="password"
              prefix-icon="fas fa-lock"
              show-password
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button
              :loading="loading"
              class="login-button"
              type="primary"
              native-type="submit"
              block
          >Login</el-button>
        </el-form-item>
        <a class="forgot-password" href="https://oxfordinformatics.com/">Forgot password ?</a>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import router from 'vue-router'
import axios from "axios";
export default {
  path: '',
  data() {
    return {
      message: '',
      validCredentials: {
        id: '',
        role: '',
        username: '',
        password: ''
      },
      model: {
        username: '',
        password: ''
      },
      loading: false,
      rules: {
        username: [
          {
            required: true,
            message: "Username is required",
            trigger: "blur"
          },
          {
            min: 3,
            message: "Username length should be at least 3 characters",
            trigger: "blur"
          }
        ],
        password: [
          { required: true, message: "Password is required", trigger: "blur" },
          {
            min: 3,
            message: "Password length should be at least 3 characters",
            trigger: "blur"
          }
        ]
      }
    };
  },
  methods: {
    simulateLogin() {
      return new Promise(resolve => {
        setTimeout(resolve, 800);
      });
    },
    async login() {
      // let valid = await this.$refs.form.validate();
      // if (!valid) {
      //   return;
      // }
      // this.loading = true;
      // await this.simulateLogin();
      // this.loading = false;
      axios.post('http://localhost:8080/login',this.model)
      .then((response) => {
        this.validCredentials = response.data.data
        this.$store.dispatch("updateRecruiterId",this.validCredentials.id)
        this.message = response.data.message
        if(this.message === 'Login successfully !'){
          if(this.validCredentials.role==='recruiter'){
            this.path =''
            this.path = '/home'
            this.$router.push(this.path)
          }
          else if(this.validCredentials.role==='admin') {
            this.path = '/admin/home'
            this.$router.push(this.path)
          }
        } else if (this.message === 'Username or password is wrong !') {
          this.$message.error("Username or password is wrong !");
        }

      })
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.login {
  flex: 1;
  display: flex;
  padding-top: 300px;
  justify-content: center;
  align-items: center;
}

.login-button {
  width: 100%;
  margin-top: 40px;
}
.login-form {
  width: 290px;
}
.forgot-password {
  margin-top: 10px;
}
</style>
<style lang="scss">
$teal: rgb(0, 124, 137);
.el-button--primary {
  background: $teal;
  border-color: $teal;

  &:hover,
  &.active,
  &:focus {
    background: lighten($teal, 7);
    border-color: lighten($teal, 7);
  }
}
.login .el-input__inner:hover {
  border-color: $teal;
}
.login .el-input__prefix {
  background: rgb(238, 237, 234);
  left: 0;
  height: calc(100% - 2px);
  left: 1px;
  top: 1px;
  border-radius: 3px;
  .el-input__icon {
    width: 30px;
  }
}
.login .el-input input {
  padding-left: 35px;
}
.login .el-card {
  padding-top: 0;
  padding-bottom: 30px;
}
h2 {
  font-family: "Open Sans";
  letter-spacing: 1px;
  font-family: Roboto, sans-serif;
  padding-bottom: 20px;
}
a {
  color: $teal;
  text-decoration: none;
  &:hover,
  &:active,
  &:focus {
    color: lighten($teal, 7);
  }
}
.login .el-card {
  width: 340px;
  display: flex;
  justify-content: center;
}
</style>
