<template>
  <div class="content m-3">
  <table class="table table-striped">
    <thead>
    <tr>
      <th scope="col">Company(id)</th>
      <th scope="col">Ships(id)</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <th scope="row">1</th>
      <td>[sh1, sh2]</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>[sh3]</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>[sh4, sh5, sh6]</td>
    </tr>
    </tbody>
  </table>
  </div>
</template>

<script>
export default {
    name: "ShipsTable"
}
</script>

<style scoped>
table{
  background: linear-gradient(45deg, #0061FF, #60EFFF);
}
</style>
