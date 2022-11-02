<template>
    <div class="logo-container">
      <manager-header></manager-header>
    </div>

  <div class="content">

    <div class="side-content">
      <div v-motion-slide-left>
        <manager-menu></manager-menu>
      </div>
    </div>

    <div class="main-content">
        <manager-table></manager-table>
    </div>

    <div class="side-content">
      <p style="color: white; text-align: center">PLACEHOLDER</p>
      <div v-motion-slide-left>
        <manager-menu></manager-menu>
      </div>
    </div>

  </div>



</template>

<script>
import ManagerHeader from "@/components/manager/ManagerHeader";
import ManagerMenu from "@/components/manager/ManagerMenu";
import ManagerTable from "@/components/manager/ManagerTable";

export default {
  name: "ManagerDashboard",
  components: {
    ManagerHeader,
    ManagerMenu,
    ManagerTable
  }
}
</script>

<style scoped>
  .logo-container{
    padding: 1%;
  }

  .content{
    display: flex;
    margin-top: 5%;
  }

  .side-content{
    flex: 1;
  }

  .main-content{
    flex: 3;
    background: rgb(51,236,255);
    background: radial-gradient(circle, rgba(51,236,255,1) 28%, rgba(40,210,255,1) 54%, rgba(29,216,251,1) 92%);
    border-radius: 20px;
  }
</style>