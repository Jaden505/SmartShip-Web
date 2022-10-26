<template>
  <div class="content">
    <el-row>
      <el-col class="column">
        <el-card>Hey</el-card>
      </el-col>
    </el-row>
    <el-row>
      <el-col class="column">
        <el-card>Hey</el-card>
      </el-col>
    </el-row>
    <el-row>
      <el-col class="column">
        <el-card>Hey</el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
    name: "ShipsTable",
    data() {
    return {
      tableData: [
        {
          date: '2016-05-03',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-02',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-04',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-01',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
      ]
    }
  }
}
</script>

<style scoped>
.column {
  width: 100%;
}

.el-row {
  margin-bottom: 30px;
  height: 200px;
}

.el-card {
  background: #002C48;
  border: none;
  color: #E0E1DD;
  border-radius: 20px;
  height: 100%;
}
</style>
