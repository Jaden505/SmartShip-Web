<template>
  <header class="navbar">
    <div class="navbar-wrapper">
      <div class="header-container">
        <div class="logo-container">
          LOGO
        </div>
        <div class="content">
          <nav class="navbar-menu menu">
            Menu
          </nav>
          <div class="language-toggler">
            Toggler
          </div>
        </div>
      </div>
    </div>
  </header>
</template>

<script>
export default {
  name: "NavBar"
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
}

.navbar-menu{
  display: flex;
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