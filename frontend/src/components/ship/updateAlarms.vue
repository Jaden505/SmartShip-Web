<template>
  <form @submit="handleAlarm" :validation-schema="schema">
    <div id="container">
      <div id="allParameters">
        <div class="Parameters">
          <label for="parameter" class="block mb-2 text-sm font-medium text-white-text">Parameter</label>
          <field name="parameter" class="form-control bg-gray-700 text-gray-900 sm:text-sm rounded-lg block w-full p-2.5" type="text" placeholder="Parameter"/>
          <ErrorMessage name="parameter" class="error-feedback" />
        </div>
        <div class="Parameters">
          <label for="category" class="block mb-2 text-sm font-medium text-white-text">Category</label>
          <field name="category" class="form-control bg-gray-700 text-gray-900 sm:text-sm rounded-lg block w-full p-2.5" type="text" placeholder="Category"/>
          <ErrorMessage name="category" class="error-feedback" />
        </div>
        <div class="Parameters">
          <label for="value" class="block mb-2 text-sm font-medium text-white-text">Value</label>
          <field name="value" class="form-control bg-gray-700 text-gray-900 sm:text-sm rounded-lg block w-full p-2.5" type="text" placeholder="Value"/>
          <ErrorMessage name="value" class="error-feedback" />
        </div>
        <div class="Parameters">
          <label for="settedUpValue" class="block mb-2 text-sm font-medium text-white-text">setted up Value</label>
          <field name="settedUpValue" class="form-control bg-gray-700 text-gray-900 sm:text-sm rounded-lg block w-full p-2.5" type="text" placeholder="setted up Value"/>
          <ErrorMessage name="settedUpValue" class="error-feedback" />
        </div>
        <div class="Parameters">
          <label for="id" class="block mb-2 text-sm font-medium text-white-text">Ship id</label>
          <field name="shipId" class="form-control bg-gray-700 text-gray-900 sm:text-sm rounded-lg block w-full p-2.5" type="text" placeholder="Ship id"/>
          <ErrorMessage name="shipId" class="error-feedback" />
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



/*Bartek zn schuld */

.form-control{display:block;width:100%;padding:.375rem .75rem;font-size:1rem;font-weight:400;line-height:1.5;color:#212529;background-color:#fff;background-clip:padding-box;border:1px solid #ced4da;-webkit-appearance:none;-moz-appearance:none;appearance:none;border-radius:.375rem;transition:border-color .15s ease-in-out,box-shadow .15s ease-in-out}


</style>
