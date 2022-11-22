<template>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <table>
      <thead>
        <tr>
          <th>Ship Id</th>
          <th>Ship Name</th>
          <th>Assigned operators</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(ship, index) in ships" :key="index">
            <td>{{ ship.id }}</td>
            <td>{{ ship.name }}</td>
            <td>{{ getUsersByShipId(ship.id) }}</td>
            <td class="material-icons">edit</td>
            <td class="material-icons">delete</td>
        </tr>
      </tbody>
    </table>
  
  </template>
  
  <script>
  import ShipDataService from "../../services/ShipService";
  import UserService from "../../services/user.service";

  export default {
    name: "ManagerTable",

    mounted() {
        this.getUsers()
        this.getShips();
    },

    data() {
        return {
            ships: [],
            user: []
        }
    },

    methods: {
      getShips() {
        ShipDataService.getAll()
            .then(response => {
                this.ships = response.data;
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
        });
        },

      getUsers() {
        UserService.getUsers()
            .then(response => {
              this.users = response.data;
              console.log(response.data);
            })
            .catch(e => {
              console.log(e);
            });
        },

      getUsersByShipId(ship_id) {
        let operators = this.users.filter(user => user.shipID == ship_id);

        if (operators !== []) {
          operators.forEach((op, index) => {
            operators[index] = op.username;
          })

          return operators.toString();
        }

        else return "No operators";
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