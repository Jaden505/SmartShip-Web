<template>
<!--  class is dashboard maar het is puur zodat het horizontaal gealligned is voor de overview en detail-->
  <div class="dashboard">
    <div class="dashboard-content">
      <div class="dashboard-content__panel dashboard-content__panel--active">
        <div class="dashboard-list">
          <div class="dashboard-list__item" >
            <h2>Engine temeprature too high</h2><!-- Date (Element)--><span>16 nov 2022 - 15:35</span>
          </div>
          <div class="dashboard-list__item dashboard-list__item--active">
            <h2>System critical</h2><!-- Date (Element)--><span>16 nov 2022 - 15:35</span>
          </div>
        </div>
      </div>
    </div>
<!--    Overview detail-->
    <div class="dashboard-preview">
      <div class="dashboard-preview__panel dashboard-preview__panel--active">
        <div class="dashboard-preview__header">
          <h2>Engine 1</h2>
          <h3>59<span>C</span></h3>
        </div>
        <div class="dashboard-preview__content">
          <section>
            <h2>Notification message</h2>
            <p>Your engine has reached critical temperatures!</p>
          </section>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "NotificationOverview"
}
</script>

<style scoped>
/*Dit is de styling van de element waar ik het over had in het begin van de html*/
.dashboard {
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  background: #FFF;
  width: 64rem;
  height: 42.5rem;
  border-radius: 0.4375rem;
  box-shadow: 1.375rem 2rem 2.125rem rgba(0, 0, 0, 0.06);
  overflow: hidden;
  margin-top: 20px;
}


.dashboard-content {
  width: 100%;
  border-right: 0.0625rem solid #F2F2F2;
}

.dashboard-list__item {
  padding: 2.0625rem 2.5625rem;
  border-bottom: 0.0625rem solid #F2F2F2;
  cursor: pointer;
}
.dashboard-list__item h2 {
  margin: 0 0 1.6875rem;
  color: #5F6876;
  letter-spacing: 0.15rem;
}
.dashboard-list__item span {
  display: block;
  margin: 0 0 1.5rem;
  font-size: 0.625rem;
  letter-spacing: 0.13625rem;
}
.dashboard-list__item--active {
  background: #F5F7F7;
}
.dashboard-header__search input {
  outline: none;
  display: block;
  width: 100%;
  padding: 23px;
  border: 0;
  letter-spacing: 0.125rem;
}
.dashboard-preview {
  width: 100%;
  height: 100%;
}
.dashboard-preview__panel {
  display: none;
}
.dashboard-preview__panel--active {
  display: block;
}
.dashboard-preview__header {
  margin: 0 0 9.5rem;
  padding: 1.6875rem 1.8125rem;
  color: #FFF;
}
.dashboard-preview__header h2 {
  font-size: 0.875rem;
  line-height: 1.0625rem;
  color: black;
}
.dashboard-preview__header h3 {
  color: red;
  font-size: 2.25rem;
  line-height: 2.875rem;
}
.dashboard-preview__header h3 span {
  font-size: 1rem;
  line-height: 2.25rem;
  vertical-align: top;
}
.dashboard-preview__content {
  padding: 0 2.75rem;
}
.dashboard-preview__content section {
  padding: 2.0625rem 0;
  border-bottom: 1px solid #F2F2F2;
}
.dashboard-preview__content section:last-child {
  border: 0;
}
.dashboard-preview__content h2 {
  color: #5F6876;
  letter-spacing: 0.1375rem;
}
.dashboard-preview__content h2 span {
  color: #C0C3C9;
  font-size: 0.625rem;
}
.dashboard-preview__content label {
  display: block;
  margin: 1.0625rem 0 0 0;
  color: #5F6876;
}
.dashboard-preview__content label:first-child {
  margin: 2.5rem 0 0 0;
}
.dashboard-preview__content label input {
  margin: 0 1.4375rem 0 0;
}
</style>