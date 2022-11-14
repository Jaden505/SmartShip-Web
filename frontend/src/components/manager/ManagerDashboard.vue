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
  }
</style>