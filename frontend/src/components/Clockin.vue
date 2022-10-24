<template>
  <div class="container">
    <div class="center">
      <br>
      <br>
      <h2 class="welcome">Hey *user* Click op de Clock-in button om in te loggen</h2>

      <dropdown>
        <input id="toggle2" type="checkbox">
        <label for="toggle2" class="animate">Editor<i class="fa fa-list float-right"></i></label>
        <ul class="animate">
          <li class="animate">Source<i class="fa fa-code float-right"></i></li>
          <li class="animate">Fullpage<i class="fa fa-arrows-alt float-right"></i></li>
          <li class="animate">Debug<i class="fa fa-cog float-right"></i></li>
        </ul>
      </dropdown>


    </div>
    <button class="bubbly-button">Clock-in</button>
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Clockin"
}
</script>

<style scoped>

/*centered button in div*/

.container {
  margin: auto;
  margin-top: 100px;
  background-color: white;
  height: 50%;
  position: relative;
  border-radius: 25px;
  width: 70%;
  /*hide everything beyond dic*/
  
}

.center {
  margin: 0;
  position: absolute;
  top: 50%;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}

/*centered button in div*/
body {
  font-size: 16px;
  font-family: 'Helvetica', 'Arial', sans-serif;
  text-align: center;
  background-color: #f8faff;
}
.bubbly-button {
  font-family: 'Helvetica', 'Arial', sans-serif;
  display: inline-block;
  font-size: 1em;
  padding: 1em 2em;
  margin-top: 280px;
  -webkit-appearance: none;
  appearance: none;
  background-color: #ff0081;
  color: #fff;
  border-radius: 4px;
  border: none;
  cursor: pointer;
  position: relative;
  transition: transform ease-in 0.1s, box-shadow ease-in 0.25s;
  box-shadow: 0 2px 25px rgba(255, 0, 130, 0.5);
  float: right;
  margin-right: 20px;
}
.bubbly-button:focus {
  outline: 0;
}
.bubbly-button:before, .bubbly-button:after {
  position: absolute;
  content: '';
  display: block;
  width: 140%;
  height: 100%;
  left: -20%;
  z-index: -1000;
  transition: all ease-in-out 0.5s;
  background-repeat: no-repeat;
}
.bubbly-button:before {
  display: none;
  top: -75%;
  background-image: radial-gradient(circle, #ff0081 20%, transparent 20%), radial-gradient(circle, transparent 20%, #ff0081 20%, transparent 30%), radial-gradient(circle, #ff0081 20%, transparent 20%), radial-gradient(circle, #ff0081 20%, transparent 20%), radial-gradient(circle, transparent 10%, #ff0081 15%, transparent 20%), radial-gradient(circle, #ff0081 20%, transparent 20%), radial-gradient(circle, #ff0081 20%, transparent 20%), radial-gradient(circle, #ff0081 20%, transparent 20%), radial-gradient(circle, #ff0081 20%, transparent 20%);
  background-size: 10% 10%, 20% 20%, 15% 15%, 20% 20%, 18% 18%, 10% 10%, 15% 15%, 10% 10%, 18% 18%;
}
.bubbly-button:after {
  display: none;
  bottom: -75%;
  background-image: radial-gradient(circle, #ff0081 20%, transparent 20%), radial-gradient(circle, #ff0081 20%, transparent 20%), radial-gradient(circle, transparent 10%, #ff0081 15%, transparent 20%), radial-gradient(circle, #ff0081 20%, transparent 20%), radial-gradient(circle, #ff0081 20%, transparent 20%), radial-gradient(circle, #ff0081 20%, transparent 20%), radial-gradient(circle, #ff0081 20%, transparent 20%);
  background-size: 15% 15%, 20% 20%, 18% 18%, 20% 20%, 15% 15%, 10% 10%, 20% 20%;
}
.bubbly-button:active {
  transform: scale(0.9);
  background-color: #e60074;
  box-shadow: 0 2px 25px rgba(255, 0, 130, 0.2);
}
.bubbly-button.animate:before {
  display: block;
  animation: topBubbles ease-in-out 0.75s forwards;
}
.bubbly-button.animate:after {
  display: block;
  animation: bottomBubbles ease-in-out 0.75s forwards;
}
@keyframes topBubbles {
  0% {
    background-position: 5% 90%, 10% 90%, 10% 90%, 15% 90%, 25% 90%, 25% 90%, 40% 90%, 55% 90%, 70% 90%;
  }
  50% {
    background-position: 0% 80%, 0% 20%, 10% 40%, 20% 0%, 30% 30%, 22% 50%, 50% 50%, 65% 20%, 90% 30%;
  }
  100% {
    background-position: 0% 70%, 0% 10%, 10% 30%, 20% -10%, 30% 20%, 22% 40%, 50% 40%, 65% 10%, 90% 20%;
    background-size: 0% 0%, 0% 0%, 0% 0%, 0% 0%, 0% 0%, 0% 0%;
  }
}
@keyframes bottomBubbles {
  0% {
    background-position: 10% -10%, 30% 10%, 55% -10%, 70% -10%, 85% -10%, 70% -10%, 70% 0%;
  }
  50% {
    background-position: 0% 80%, 20% 80%, 45% 60%, 60% 100%, 75% 70%, 95% 60%, 105% 0%;
  }
  100% {
    background-position: 0% 90%, 20% 90%, 45% 70%, 60% 110%, 75% 80%, 95% 70%, 110% 10%;
    background-size: 0% 0%, 0% 0%, 0% 0%, 0% 0%, 0% 0%, 0% 0%;
  }
}

.bubbly-button:hover{
  color: #ff0081;
  background-color: white;
  transition-timing-function: ease-out;
  /* A litttttle slower on the way in */
  transition: 0.25s;
}

/*dropdown*/

* {
  padding: 0;
  margin: 0;
  font-family: 'Lato', sans-serif;
  box-sizing: border-box;
}
.float-right {
  float: right;
}
.fa {
  font-size: 0.8em;
  line-height: 22px !important;
}
dropdown {
  display: inline-block;
  margin: 20px 50px;
}
dropdown label, dropdown ul li {
  display: block;
  width: 200px;
  background: #ecf0f1;
  padding: 15px 20px;
}
dropdown label:hover, dropdown ul li:hover {
  background: #1abc9c;
  color: white;
  cursor: pointer;
}
dropdown label {
  color: #1abc9c;
  border-left: 4px solid #1abc9c;
  border-radius: 0 5px 0 0;
  position: relative;
  z-index: 2;
}
dropdown input {
  display: none;
}
dropdown input ~ ul {
  position: relative;
  visibility: hidden;
  opacity: 0;
  top: -20px;
  z-index: 1;
}
dropdown input:checked + label {
  background: #1abc9c;
  color: white;
}
dropdown input:checked ~ ul {
  visibility: visible;
  opacity: 1;
  top: 0;
}
dropdown ul li:nth-child(1) {
  border-left: 4px solid #e74c3c;
}
dropdown ul li:nth-child(1) .fa {
  color: #e74c3c;
}
dropdown ul li:nth-child(1):hover {
  background: #e74c3c;
  color: white;
}
dropdown ul li:nth-child(1):hover .fa {
  color: white;
}
dropdown ul li:nth-child(2) {
  border-left: 4px solid #0072b5;
}
dropdown ul li:nth-child(2) .fa {
  color: #0072b5;
}
dropdown ul li:nth-child(2):hover {
  background: #0072b5;
  color: white;
}
dropdown ul li:nth-child(2):hover .fa {
  color: white;
}
dropdown ul li:nth-child(3) {
  border-left: 4px solid #2c3e50;
}
dropdown ul li:nth-child(3) .fa {
  color: #2c3e50;
}
dropdown ul li:nth-child(3):hover {
  background: #2c3e50;
  color: white;
}
dropdown ul li:nth-child(3):hover .fa {
  color: white;
}
.animate {
  -webkit-transition: all 0.3s;
  -moz-transition: all 0.3s;
  -ms-transition: all 0.3s;
  -ms-transition: all 0.3s;
  transition: all 0.3s;
  backface-visibility: hidden;
  -webkit-backface-visibility: hidden;
  -moz-backface-visibility: hidden;
  /* Chrome and Safari */
  -ms-backface-visibility: hidden;
  /* Firefox */
}
/* Internet Explorer */


.center{
  width: 80%;
}


</style>