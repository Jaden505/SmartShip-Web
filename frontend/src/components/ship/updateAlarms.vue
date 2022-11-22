<template>
  <form>
    <div id="container">
      <div id="allParameters">
        <div class="Parameters">
          {{ parametertext }}
          <input type="text" v-model="this.alarm.parameter"/>
        </div>
        <div class="Parameters">
          {{ categorytext }}
          <input type="text" v-model="this.alarm.category"/>
        </div>
        <div class="Parameters">
          {{ realTimeValuetext }}
          <input type="number" v-model="this.alarm.valueSinceLastUpdate"/>
        </div>
        <div class="Parameters">
          {{ settedUpValuetext }}
          <input type="number" v-model="this.alarm.settedUpValue"/>
        </div>
        <div class="Parameters">
          {{ ship_idtext }}
          <input type="text" v-model="this.alarm.ship_id"/>
        </div>
        <button class="button" id="cancel" @click="cancelModal()">
          {{ cancel }}
        </button>

        <button class="button" id="update" @click="updateAlarms()">
          {{ update }}
        </button>
      </div>
    </div>
  </form>
</template>

<script>
export default {
  name: "AddAlarms",
  props:["alarm"],
  data() {
    return {
      parametertext: "Parameter: ",
      categorytext: "Category: ",
      realTimeValuetext: "Real time value: ",
      settedUpValuetext: "Setted up value: ",
      ship_idtext: "Ship-id: ",
      update: "Update",
      cancel: "Cancel",
      parameter: "",
      category: "",
      valueSinceLastUpdate: "",
      settedUpValue: "",
    }
  },
  methods:{
    // eslint-disable-next-line vue/no-dupe-keys
    cancelModal(){
      this.$emit('cancel')
    },
    updateAlarms(){
      this.$emit('update')
    }
  }
}
</script>

<style scoped>
#container {
  position: absolute;
  top: 10%;
  left: 30%;
  z-index: 99;
  align-items: center;
  justify-content: center;
  width: auto;
  height: auto;
  background-color: #002C60;
  border-radius: 20px;
  margin: 20px;
  box-shadow: 0 3px 10px rgb(0 0 0 / 2);
}

.Parameters {
  color: #0061FF;
  margin-top: 3%;
  display: block;
  font-size: 30px;
}

input{
  border-radius: 10px;
}
#allParameters{
  border-radius: 20px;
  height: auto;
}
.button{
  width: 30%;
  height: 50px;
  margin-top: 10%;
  margin-left: 100px;
  color: white;
  border-radius: 20px;
}
#update{
  background-color: lightgreen;
}
#cancel{
  background-color: deeppink;
}



</style>
