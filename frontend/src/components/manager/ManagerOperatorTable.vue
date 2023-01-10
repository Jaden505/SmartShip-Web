<template>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

  <div v-motion :delay="100"
       :enter="{ opacity: 1, y: 0, scale: 1 }"
       :initial="{ opacity: 0, y: 100 }"
       :variants="{ custom: { scale: 2 } }"
       class="mt-4">
    <div class="flex flex-row space-x-2">
      <button class="text-white bg-blue-regular font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text"
              @click="TogglePopup('buttonTriggerCreate')">Add user
      </button>
      <button v-if="activeButtonShip"
              class="bg-blue-regular font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text topBtn"
              @click="activate">Filter Ship
      </button>
      <button v-if="activeButtonOp"
              class="bg-blue-regular font-medium rounded-lg text-sm px-5 py-2.5 text-center text-white-text topBtn"
              @click="reActivate">Filter Operator
      </button>
      <br>
      <input v-if="activeSearch" id="myInput" :placeholder="'Search for '+ searchTitle" class="bg-transparent border text-black-light dark:text-white-text text-sm rounded-full pl-10 p-2.5 " title="Type in a name" type="text"
             @keyup="search">
    </div>
    <div class="mt-4">
      <table id="opTable" class="text-center table-auto w-full text-black-text dark:text-white-text">
        <thead>
        <tr>
          <th class="" scope="col">Operator Id</th>
          <th class="" scope="col">Operator Name</th>
          <th class="" scope="col">Operator Email</th>
          <th class="" scope="col">Assigned Ship</th>
          <th></th>
          <th></th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(operator, index) in users" :key="index" class="bg-purple-basic dark:bg-black-light">
          <td class="px-3 py-4">{{ operator.id }}</td>
          <td class="px-3 py-4">{{ operator.username }}</td>
          <td class="px-3 py-4">{{ operator.email }}</td>
          <td class="px-3 py-4">{{ getShipName(operator.ship) }}</td>
          <td>
            <div class="material-icons px-3 py-4" @click="TogglePopup('buttonTriggerEdit'); this.operator = operator">
              edit
            </div>
            <div class="material-icons px-3 py-4" @click="deleteUser(operator.id)">delete</div>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>


  <editForm
      v-if="popupTrigger.buttonTriggerEdit"
      :TogglePopup="() => TogglePopup('buttonTriggerEdit')"
      :operator=this.operator
  />

  <createForm
      v-if="popupTrigger.buttonTriggerCreate"
      :TogglePopup="() => TogglePopup('buttonTriggerCreate')"
  />

</template>

<script>
import UserService from "../../services/user.service";
import ShipService from "@/services/ship.service";
import editForm from "@/components/manager/forms/editUserForm";
import {isProxy, ref, toRaw} from 'vue';
import createForm from "@/components/manager/forms/createUserForm";

export default {
  name: "ManagerTable",
  components: {
    editForm,
    createForm
  },
  created() {
    UserService.getUsersByRole("operator")
        .then(response => {
          this.users = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    ShipService.getAll()
        .then(response => {
          this.ships = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
  },

  data() {
    return {
      users: [],
      operator: null,
      ships: [],

      activeSearch: false,
      activeButtonShip: true,
      activeButtonOp: false,
      searchTitle: null,
      columnNumber: null
    }
  },

  setup() {
    const popupTrigger = ref({
      buttonTriggerEdit: false,
      buttonTriggerCreate: false
    });

    const TogglePopup = (trigger) => {
      popupTrigger.value[trigger] = !popupTrigger.value[trigger]
    };

    return {
      popupTrigger,
      TogglePopup
    }
  },

  methods: {
    toggle(operator) {
      this.operator = operator
    },

    deleteUser(user_id) {
      if (confirm("Are you sure you want to delete this operator?")) {
        UserService.deleteUser(user_id).catch(e => {
          console.log(e)
        })
        location.reload()
      }
    },
    getShipName(ship) {
      if (ship == null) {
        return "No ship assigned";
      }
      let shipFound = this.ships.filter(shipFound => shipFound.id == ship.id);

      if (shipFound !== []) {
        isProxy(shipFound) ? ship = toRaw(shipFound[0]).name : shipFound = shipFound[0].name;
        return shipFound;
      }

    },

    search() {
      let input, filter, table, tr, td, i, txtValue;
      input = document.getElementById("myInput");
      filter = input.value.toUpperCase();
      table = document.getElementById("opTable");
      tr = table.getElementsByTagName("tr");
      for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[this.columnNumber];
        if (td) {
          txtValue = td.textContent || td.innerText;
          if (txtValue.toUpperCase().indexOf(filter) > -1) {
            tr[i].style.display = "";
          } else {
            tr[i].style.display = "none";
          }
        }
      }
    },

    activate() {
      this.activeSearch = true
      this.activeButtonShip = false
      this.activeButtonOp = true
      this.searchTitle = 'ship'
      this.columnNumber = 3
    },

    reActivate() {
      this.activeButtonShip = true
      this.activeButtonOp = false
      this.searchTitle = 'operator'
      this.columnNumber = 1
    }

  }
}
</script>

<style scoped>
table {
  border-collapse: separate;
  border-spacing: 0 10px;
}

td:first-child {
  border-radius: 10px 0 0 10px;
}

td:last-child {
  border-radius: 0 10px 10px 0;
}

</style>