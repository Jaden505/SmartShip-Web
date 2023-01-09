<template>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

  <div class="content-container">
    <div class="content">

      <div class="title-section">
        <h1>Personal</h1>
        <div class="material-icons px-3 py-4 edit pointer" @click="TogglePopup('buttonTriggerEdit')">edit</div>
      </div>

      <hr class="underline">

      <div class="personal-info">
        <div class="personal-left">
          <div class="personal-record">
            <label>Firstname</label>
            <p>{{ user.firstname }}</p>
          </div>
          <div class="personal-record">
            <label>Lastname</label>
            <p>{{ user.lastname }}</p>
          </div>
          <div class="personal-record">
            <label>Gender</label>
            <p>{{ user.gender }}</p>
          </div>
        </div>
        <div class="personal-right">
          <div class="personal-record">
            <label>Nationality</label>
            <p>{{ user.nationality }}</p>
          </div>
          <div class="personal-record">
            <label>Date of Birth</label>
            <p>{{ user.dateOfBirth }}</p>
          </div>
        </div>
      </div><!--/personal-info-->

      <div class="title-section">
        <h1>Contact</h1>
      </div>

      <hr class="underline">

      <div class="personal-info">
        <div class="personal-left">
          <div class="personal-record">
            <label>Email</label>
            <p>{{ user.email }}</p>
          </div>
        </div>
        <div class="personal-right">
          <div class="personal-record">
            <label>Phone number</label>
            <p>{{ user.phoneNumber }}</p>
          </div>
        </div>
      </div><!--/personal-info-->

      <div class="title-section">
        <h1>Residence</h1>
      </div>

      <hr class="underline">

      <div class="personal-info">
        <div class="personal-left">
          <div class="personal-record">
            <label>Address</label>
            <p>{{ user.address }}</p>
          </div>
          <div class="personal-record">
            <label>Postal code</label>
            <p>{{ user.postalCode }}</p>
          </div>
        </div>
        <div class="personal-right">
          <div class="personal-record">
            <label>City</label>
            <p>{{ user.city }}</p>
          </div>
          <div class="personal-record">
            <label>Country</label>
            <p>{{ user.country }}</p>
          </div>
        </div>
      </div><!--/personal-info-->
      
    </div><!--/content-->
  </div><!--/content-container-->

  <edit-profile
      v-if="popupTrigger.buttonTriggerEdit"
      :TogglePopup="() => TogglePopup('buttonTriggerEdit')"
      :user=this.user
  />


</template>

<script>
import {ref, toRaw} from "vue";
import userService from "@/services/user.service";
import editProfile from "@/components/Profile/edit/editProfile";

export default {
  name: "Personal",
  components: {
    editProfile,
  },
  data(){
    return {
      user: {
        firstname: null,
        lastname: null,
        gender: null,
        nationality: null,
        dateOfBirth: null,
        email: null,
        phoneNumber: null,
        address: null,
        postalCode: null,
        city: null,
        country: null
      }
    }
  },

  methods: {
    getUser(){
      const id = toRaw(this.$store.state.auth.user.id)
      userService.getUserById(id)
          .then(response => {
            this.user.firstname = response.data.firstname;
            this.user.lastname = response.data.lastname;
            this.user.gender = response.data.gender;
            this.user.nationality = response.data.nationality;
            this.user.dateOfBirth = response.data.dateofbirth;
            this.user.email = response.data.email;
            this.user.phoneNumber = response.data.phonenumber;
            this.user.address = response.data.address;
            this.user.postalCode = response.data.postalcode;
            this.user.city = response.data.city;
            this.user.country = response.data.country;
          })
          .catch(e => {
            console.log(e)
          })
    }
  },

  mounted() {
    this.getUser();
  },

  setup(){
    const popupTrigger = ref({
      buttonTriggerEdit: false,
    });

    const TogglePopup = (trigger) => {
      popupTrigger.value[trigger] = !popupTrigger.value[trigger]
    };

    return {
      popupTrigger,
      TogglePopup
    }
  },
}
</script>

<style scoped>
.content-container {
  background-color: rgba(32, 31, 31, 0.97);
}

.content{
  width: 90%;
  margin-left: auto;
  margin-right: auto;
}

.title-section{
  display: flex;
  padding: 1%;
  font-size: 32px;
  color: white;
}

h1{
  flex: 100;
}

.edit{
  flex: 1;
}


.personal-info{
  display: flex;
}

.personal-left{
  flex: 1;
  padding: 1%;
}

.personal-record{
  display: flex;
  color: white;
  margin-bottom: 1%;
}

.personal-record label{
  font-size: 20px;
  font-weight: bold;
  flex: 1;
}

.personal-record p{
  font-size: 20px;
  flex: 3;
}

.personal-right{
  flex: 1;
  padding: 1%;
}

.pointer{
  cursor: pointer;
}


</style>