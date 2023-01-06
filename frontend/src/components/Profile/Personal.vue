<template>

  <div class="content-container">
    <div class="content">

      <h1>Personal</h1>
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

      <h1>Contact</h1>
      <hr>

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

      <h1>Residence</h1>
      <hr>

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

</template>

<script>
import {toRaw} from "vue";
import userService from "@/services/user.service";

export default {
  name: "Personal",
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
  }
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

h1{
  font-size: 32px;
  padding: 1%;
  color: white;
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


</style>