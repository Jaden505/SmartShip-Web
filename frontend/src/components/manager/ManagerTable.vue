<template>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <table>
    <thead>
      <tr>
        <th>Operator Id</th>
        <th>Operator Name</th>
        <th>Ship Name</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>123</td>
        <td>Hans</td>
        <td>Titanic</td>
        <td class="material-icons">edit</td>
        <td class="material-icons">delete</td>
      </tr>
      <tr>
        <td>123</td>
        <td>Hans</td>
        <td>Titanic</td>
        <td class="material-icons">edit</td>
        <td class="material-icons">delete</td>
      </tr>
      <tr>
        <td>123</td>
        <td>Hans</td>
        <td>Titanic</td>
        <td class="material-icons">edit</td>
        <td class="material-icons">delete</td>
      </tr>
    </tbody>
  </table>

</template>

<script>
export default {
  name: "ManagerTable"
}
</script>

<style scoped>

table{
  width: 90%;
  border: solid black 2px;
  margin: 1% auto 0 auto;
}

thead{
  background-color: #163b7a;
  border-bottom: 2px solid black;
}

thead th{
  padding: 1%;
  font-size: 22px;
  color: deepskyblue;
}

tbody td{
  padding: 1%;
  font-size: 20px;
}

tbody tr{
  background-color: white;
}

tbody tr:hover{
  background-color: white;
  opacity: 0.8;
}

tbody tr:nth-child(even){
  background-color: deepskyblue;
}

.material-icons:hover {
  cursor: pointer;
}

.material-icons {
  font-size: 28px;
  padding-top: 8px;
}
</style>