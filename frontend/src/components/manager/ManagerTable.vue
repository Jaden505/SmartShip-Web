<template>

  <table>
    <thead>
      <tr>
        <th>Operator Id</th>
        <th>Operator Name</th>
        <th>Ship Name</th>
        <th>Edit</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>123</td>
        <td>Hans</td>
        <td>Titanic</td>
        <td>U</td>
        <td>X</td>
      </tr>
      <tr>
        <td>123</td>
        <td>Hans</td>
        <td>Titanic</td>
        <td>U</td>
        <td>X</td>
      </tr>
      <tr>
        <td>123</td>
        <td>Hans</td>
        <td>Titanic</td>
        <td>U</td>
        <td>X</td>
      </tr>
      <tr>
        <td>123</td>
        <td>Hans</td>
        <td>Titanic</td>
        <td>U</td>
        <td>X</td>
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
  background: rgb(187,249,255);
  background: radial-gradient(circle, rgba(187,249,255,1) 28%, rgba(168,237,255,1) 54%, rgba(153,239,255,1) 92%);
  border-bottom: 2px solid black;
}

thead th{
  padding: 1%;
  font-size: 22px;
  color: black;
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
  background: rgb(133,244,255);
  background: radial-gradient(circle, rgba(133,244,255,1) 28%, rgba(107,224,255,1) 54%, rgba(85,228,255,1) 92%);
}

</style>