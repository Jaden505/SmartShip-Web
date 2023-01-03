<template>

  <div class="content-container">
    <div class="content">

      <h1>Personal</h1>
      <hr class="underline">

      <div class="personal-info">
        <div class="personal-left">
          <div class="personal-record">
            <label>Firstname</label>
            <p>Raihan</p>
          </div>
          <div class="personal-record">
            <label>Lastname</label>
            <p>Saboerali</p>
          </div>
          <div class="personal-record">
            <label>Gender</label>
            <p>Male</p>
          </div>
        </div>
        <div class="personal-right">
          <div class="personal-record">
            <label>Nationality</label>
            <p>Netherlands</p>
          </div>
          <div class="personal-record">
            <label>Date of Birth</label>
            <p>9-02-2003</p>
          </div>
        </div>
      </div><!--/personal-info-->

      <h1>Contact</h1>
      <hr>

      <div class="personal-info">
        <div class="personal-left">
          <div class="personal-record">
            <label>Email</label>
            <p>raihanja@gmail.com</p>
          </div>
        </div>
        <div class="personal-right">
          <div class="personal-record">
            <label>Phone number</label>
            <p>06-12345678</p>
          </div>
        </div>
      </div><!--/personal-info-->

      <h1>Residence</h1>
      <hr>

      <div class="personal-info">
        <div class="personal-left">
          <div class="personal-record">
            <label>Address</label>
            <p>Kalverstraat 223</p>
          </div>
          <div class="personal-record">
            <label>Postal code</label>
            <p>1098 DE</p>
          </div>
        </div>
        <div class="personal-right">
          <div class="personal-record">
            <label>City</label>
            <p>Amsterdam</p>
          </div>
          <div class="personal-record">
            <label>Country</label>
            <p>The Netherlands</p>
          </div>
        </div>
      </div><!--/personal-info-->

    </div><!--/content-->
  </div><!--/content-container-->

</template>

<script>
export default {
  name: "Personal"
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