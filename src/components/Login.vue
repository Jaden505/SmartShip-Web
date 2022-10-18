<template>
  <el-main class="main">
    <el-row class="row">
      <el-col :span="12" class="column">
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
      <el-col :span="12" class="column">
        <div class="grid-content ep-bg-purple">
          <el-form
              label-width="120px"
          >
            <el-form-item label="Email">
              <el-input v-model="email" type="email" autocomplete="off" placeholder="Email"/>
            </el-form-item>
            <el-form-item label="Password">
              <el-input v-model="password" type="password" autocomplete="off" placeholder="Password"/>
            </el-form-item>
            <div>
              <a class="forgotPassword">Forgot Password?</a>
              <el-form-item>
                <el-button type="primary">Submit</el-button>
              </el-form-item>
            </div>
          </el-form>
        </div>
      </el-col>
    </el-row>
  </el-main>
</template>

<script>
export default {
  name: "Login-Screen",
  data () {
    return {
      email: '',
      password: '',
      title: 'Welcome to SmartShip Dashboard',
      subtitle: 'Your journey starts here! Just sign-in and enjoy your trip!',
      forgot_password: 'Forgot Password ?',
      sign_in: 'SIGN-IN'
    }
  }
}
</script>

<style scoped>
.main {
  height: 100%;
  padding-bottom: 12vh;
}

.row {
  height: 100%;
}

.column {
  height: 100%;
  text-align: center;
}

.forgotPassword {
  color: #E0E1DD;
}

h1 {
  font-size: 5rem;
  background-color: #0061FF;
  background-image: linear-gradient(45deg, #0061FF, #60EFFF);
  background-size: 100%;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}
h3 {
  font-size: 1.7rem;
  color: #E0E1DD;

}
</style>
