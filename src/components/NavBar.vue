<template>
  <div class="topnav">
    <a><router-link to="/">HOME</router-link></a>

    <a><router-link to="/ships">MY SHIPS</router-link></a>
    <a><router-link to="/account">MY ACCOUNT</router-link></a>
    <div class="rightnav">
      <a><router-link to="/sign-up">SIGN UP</router-link></a>
      <a><router-link to="/login">LOG IN</router-link></a>
    </div>
  </div>
</template>
<script>
export default {
  name: "NavBar"
}
</script>


<style scoped>
.topnav {
  background-color: #333;
  overflow: hidden;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}
.rightnav{
  float: right;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}
</style>