<template>
  <NavBar/>
  <el-main class="main">
    <el-row class="row" gutter="10">
      <el-col :span="12" class="column-1" justify="center">
        <div class="grid-content ep-bg-purple">
          <div class="title-container" align="left">
            <h1 class="title">
              {{title}}
            </h1>
            <h3 class="subtitle">
              {{subtitle}}
            </h3>
          </div>
        </div>
      </el-col>
      <el-col :span="12" class="column-2">
        <div class="grid-content ep-bg-purple" align="center">
          <el-form class="form" @submit.prevent="handleLogin">
            <input class="form-control" v-model="user.email" type="email" autocomplete="off" placeholder="Enter your email"/>
            <input class="form-control" v-model="user.password" type="password" autocomplete="off" placeholder="Enter your password"/>
            <div>
              <el-form-item>
                <el-link :underline="false" class="forgotPassword">Forgot Password?</el-link>
              </el-form-item>
              <el-form-item>
                <router-link class="link" to="/ships">
                <el-button  class="submit-button">Sign In</el-button>
                </router-link>
                <div class="btn2"></div>
              </el-form-item>
            </div>
          </el-form>
        </div>
      </el-col>
    </el-row>
  </el-main>
</template>

<script>
import User from '../models/user'
import NavBar from "@/components/NavBar";

export default {
  name: "Login-Screen",
  components: {
    NavBar
  },
  data () {
    return {
      user: new User('', ''),
      title: 'Welcome to SmartShip Dashboard',
      subtitle: 'Your journey starts here! Just sign-in and enjoy your trip!',
    }
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    }
  },
  created() {
    if (this.loggedIn) {
      this.$router.push('/profile');
    }
  },
  methods: {
    handleLogin() {
      this.loading = true;
      this.$validator.validateAll().then(isValid => {
        if (!isValid) {
          this.loading = false;
          return;
        }

        if (this.user.name && this.user.password) {
          this.$store.dispatch('/signin', this.user).then(
              () => {
                this.$router.push('/profile');
              },
              error => {
                this.loading = false;
                this.message =
                    (error.response && error.response.data) ||
                    error.message ||
                    error.toString();
              }
          );
        }
      });
    }
  }
}
</script>

<style scoped>
.main {
  height: 100%;
  padding-bottom: 12vh;
}

.link{
  text-decoration: none;
}

.submit-button, .btn2 {
  width: 100px;
  height: 50px;
  font-size: 1rem;
  font-weight: 600;
  color: #00111C;
  border-radius: 10px;
  background: linear-gradient(-45deg, #60EFFF, #0061FF);
  background-size: 600%;
  -webkit-animation: anime 16s linear infinite;
  animation: anime 16s linear infinite;
  border: solid 0 black;
  transition: all .2s ease-in-out;
}
.btn2 {
  position: absolute;
  transition: all .2s ease-in-out;
  z-index: -1;
  filter: blur(30px);
  opacity: 0.3;
}

.submit-button:hover, .btn2:hover {
  transform: translateY(-0.25em)
}

.row {
  height: 100%;
}

input {
  border: 0 solid red;
  border-radius: 4px;
  width: 100%;
  padding: 20px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  background-color : #363636;
}

input::placeholder {
  font-size: 20px;
}

.forgotPassword {
  color: #E0E1DD;
}

.form {
  width: 50%;
}

.title {
  font-size: 5rem;
  background-color: #0061FF;
  background-image: linear-gradient(45deg, #0061FF, #60EFFF);
  background-size: 100%;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}

.column-1, .column-2 {
  margin-top: 8%;
}

.subtitle {
  margin-top: 10px;
  font-size: 1.7rem;
  color: #E0E1DD;

}
</style>
