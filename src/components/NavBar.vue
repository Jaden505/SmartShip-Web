<template>
  <header class="navbar">
    <div class="navbar-wrapper">
      <div class="header-container">
        <div class="logo-container">
          <img v-bind:src="logo" width="200" height="100">
        </div>
        <div class="content">
          <nav class="navbar-menu menu">
            <button id="sign_in" class="buttons">{{sign_in}}</button>
          </nav>
          <div class="language-toggler">
            <button id="register" class="buttons">{{register}}</button>
          </div>
        </div>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: "NavBar",
  data () {
    return {
      logo: require('../assets/img/SmartShipLogo.jpeg'),
      register: 'Register',
      sign_in: 'Sign In'
    }
  }
}
</script>

<style scoped>
.navbar {
  top: 0;
  left: 0;
  position: relative;
  color: #dddddd;
}

.navbar-wrapper .header-container {
  display: flex;
  justify-content: space-between;
  margin: 0 auto;
}

.navbar-wrapper {
  position: relative;
  padding: 0 24px 0 24px;
  top: 0;
}

.logo-container{
  display: flex;
  align-items: center;
  height: 10vh;
  padding-top: 1vh;
}

.navbar-menu{
  display: flex;
}
.buttons{
  color: #dddddd;
  font-size: 180%;
  width: 110%;
  border-radius: 10px;
}
#register{
  background-color: #363e44;
  border-color: #2baedaff;
}
#register:hover {
  background-color: #2baedaff;
}
#sign_in{
  text-decoration-line: underline;
  color:#2baedaff;
  background-color: #363e44;
  border: none;
}

.language-toggler{
  padding: 0 0 0 30px;
}

.navbar-wrapper .header-container .content {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  flex-grow: 1;
}

</style>
