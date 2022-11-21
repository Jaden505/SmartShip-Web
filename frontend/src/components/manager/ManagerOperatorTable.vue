<template>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

  <table>
    <thead>
      <tr>
        <th>Operator Id</th>
        <th>Operator Name</th>
        <th>Operator Email</th>
        <th>Assigned Ship Id</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(operator, index) in users" :key="index">
            <td>{{ operator.id }}</td>
            <td>{{ operator.username }}</td>
            <td>{{ operator.email }}</td>
            <td>{{ operator.shipID }}</td>
            <td class="material-icons">edit</td>
            <td class="material-icons">delete</td>
        </tr>
    </tbody>
  </table>

</template>

<script>
import UserService from "../../services/user.service";

export default {
  name: "ManagerTable",

  mounted() {
        this.getUsers();
    },

    data() {
        return {
            users: [],
        }
    },

    methods: {
        getUsers() {
          UserService.getUsersByRole(1) // Role operator
            .then(response => {
                this.users = response.data;
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
        });
        }
    }
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
  color: lightgrey;
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