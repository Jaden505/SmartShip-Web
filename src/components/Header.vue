<template>
  <div class="topnav">
    <p class="greeting">Goodmorning <span class="user-name">User</span></p>

    <div class="rightnav">
      <a><router-link to="/ships">User info</router-link></a>
    </div>
  </div>
</template>
<script>
export default {
  name: "HeaderComp"
}
</script>


<style scoped>
.topnav {
  background-color: #333;
  position: fixed;
  top: 0;
  left: 300px;
  width: 100%;
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

.greeting {
  color: white;
  float: left;
}

.user-name {
  color: deepskyblue;
}
</style>