<template>
  <el-main class="main">
    <el-row class="row">
      <el-col :span="12" class="column">
        <div class="grid-content ep-bg-purple">
          <div id="titles_container">
            <h1 class="titles">
              {{title}}
            </h1>
            <h3 class="titles">
              {{subtitle}}
            </h3>
          </div>
        </div>
      </el-col>
      <el-col :span="12" class="column">
        <div class="grid-content ep-bg-purple">
          <div id="login">
            <div id="inputfields-container">
                <el-input class="inputfields" placeholder="Enter your email address" v-model="email"></el-input>
                <el-input class="inputfields" placeholder="Password" v-model="password" show-password></el-input>
            </div>
            <div id="forgot-password">
              <a href="">{{forgot_password }}</a>
            </div>
            <div id="sign-in">
              <button id="sign_in_button">{{sign_in}}</button>
            </div>
          </div>
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

.grid-content {
  /*color: #dddddd;*/
}
.inputfields{
  font-size: 160%;
  height: 100px;
  width: 60%;
  padding-top: 3vh;
  margin-bottom: 2%;
}
.titles{
  margin-bottom: 5%;
}
#inputfields-container{
  padding-top: 14vh;
}


#forgot-password{
  text-align: left;
  margin-left: 20%;
}
#titles_container{
  margin-left: 1%;
  padding-top: 15vh;
  text-align: left;
}
#sign_in_button{
  margin-top:1%;
  font-size: 200%;
  border-radius: 10px;
  width: 30%;
  background-color: #2baedaff;
}
a{
  color: #2baedaff;
  text-decoration: none;
}
h1 {
  font-size: 485%;
}
h3{
  text-decoration: none;
  font-size: 180%;
}
</style>
