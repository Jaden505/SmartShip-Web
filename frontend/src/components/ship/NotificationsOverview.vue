<template>
  <div class = "flex-container">

    <div class="flex-box">
      <div class="Parameters">Parameter:</div>
      <div class="Parameters">Category:</div>
      <div class="Parameters">Real time value: </div>
      <div class="Parameters">setted up value:</div>

      <div class="flex">
        <input type="button" class="flex-child" id="slide_start_button">
        <input type="button" class="flex-child" id="slide_stop_button">
      </div>
    </div>

    <div class="flex-box">
      <div class="Parameters">Parameter:</div>
      <div class="Parameters">Category:</div>
      <div class="Parameters">Real time value: </div>
      <div class="Parameters">setted up value:</div>

      <div class="flex">
        <input type="button" class="flex-child" id="slide_start_button">
        <input type="button" class="flex-child" id="slide_stop_button">
      </div>
    </div>

    <div class="flex-box">
      <div class="Parameters">Parameter:</div>
      <div class="Parameters">Category:</div>
      <div class="Parameters">Real time value: </div>
      <div class="Parameters">setted up value:</div>

      <div class="flex">
        <input type="button" class="flex-child" id="slide_start_button">
        <input type="button" class="flex-child" id="slide_stop_button">
      </div>
    </div>

    <div class="flex-box">
      <div class="Parameters">Parameter:</div>
      <div class="Parameters">Category:</div>
      <div class="Parameters">Real time value: </div>
      <div class="Parameters">setted up value:</div>

      <div class="flex">
        <input type="button" class="flex-child" id="slide_start_button">
        <input type="button" class="flex-child" id="slide_stop_button">
      </div>
    </div>

    <div class="flex-box">
      <div class="Parameters">Parameter:</div>
      <div class="Parameters">Category:</div>
      <div class="Parameters">Real time value: </div>
      <div class="Parameters">setted up value:</div>

      <div class="flex">
        <input type="button" class="flex-child" id="slide_start_button">
        <input type="button" class="flex-child" id="slide_stop_button">
      </div>
    </div>

    <div class="flex-box">
      <div class="Parameters">Parameter:</div>
      <div class="Parameters">Category:</div>
      <div class="Parameters">Real time value: </div>
      <div class="Parameters">setted up value:</div>

      <div class="flex">
        <input type="button" class="flex-child" id="slide_start_button">
        <input type="button" class="flex-child" id="slide_stop_button">
      </div>
    </div>

    <div class="flex-box">
      <div class="Parameters">Parameter:</div>
      <div class="Parameters">Category:</div>
      <div class="Parameters">Real time value: </div>
      <div class="Parameters">setted up value:</div>

      <div class="flex">
        <input type="button" class="flex-child" id="slide_start_button">
        <input type="button" class="flex-child" id="slide_stop_button">
      </div>
    </div>

    <div class="flex-box">
      <div class="Parameters">Parameter:</div>
      <div class="Parameters">Category:</div>
      <div class="Parameters">Real time value: </div>
      <div class="Parameters">setted up value:</div>

      <div class="flex">
        <input type="button" class="flex-child" id="slide_start_button">
        <input type="button" class="flex-child" id="slide_stop_button">
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: "NotificationsOverview"
}
</script>

<style scoped>
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
.flex-container{
  width: 100%;
  height: auto;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  background-color: #002C48;
  justify-content: center;
}
.flex-box{
  width: 320px;
  height: 170px;
  background-color: #002C60;
  color: #0061FF;
  border-radius: 20px;
  margin: 20px;
  box-shadow: 0 3px 10px rgb(0 0 0 / 2);
}

.Parameters:first-child {
  padding-top: 10px;
}

.Parameters{
  margin-left: 15px;
  font-weight: 900;
}



/*new*/

.flex {
  display: -webkit-box;
  display: -moz-box;
  display: -ms-flexbox;
  display: -webkit-flex;
  display: flex;
}

.flex-child:first-child {
  background-color: #1CD0FF;
  margin-left: 48%;
}

.flex-child{
  border: none;
  padding: 4px;
  text-decoration: none;
  display: inline-block;
  margin-top: 20px;
  float: left;
  background-color: deeppink;
  width: 22%;
  border-radius: 8px;
  margin-left: 10px;
}

</style>