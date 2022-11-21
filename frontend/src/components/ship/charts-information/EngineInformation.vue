<template>
  <el-card shadow="always" class="el-card">


    <div class="content">
      <el-row class="container">
        <h1>Engine Information(RPM)</h1>
        <div class="chart-container">
          <canvas id="engineInformationChart" ref="engineInformationChart"></canvas>
          <canvas id="engineInformationChart2" ref="engineInformationChart2"></canvas>
        </div>
        <p>Engine 1 Temperature</p>
      </el-row>
      <el-row class="container-2">
        <div class="sections">
          <div class="sensor" v-for="(sensor, index) in engineInfo" :key="index">Engine temperature {{++index }}
          <el-card class="section" shadow="always">
              <h2 class="temperature">{{ sensor.temperature }}°</h2>
          </el-card>
          <el-card class="section" shadow="always">
          </el-card>
          </div>
        </div>
      </el-row>
    </div>
  </el-card>
</template>

<script>
import Chart from "chart.js/auto";
import EngineService from "@/services/EngineService";
// import SensorDataService from "@/services/SensorDataService";

export default {
  name: "EngineInformation",
  data() {
    return {
      engineInfo: [],
      sensor:[]
    }
  },
  mounted() {
    console.log('Component mounted')
    this.getSensor();
    let ctx = this.$refs["engineInformationChart"];
    let ctx2 = this.$refs["engineInformationChart2"];
    // let ctx3 = this.$refs["engineInformationChart3"];
    // let ctx4 = this.$refs["engineInformationChart4"];

    const data = {
      labels: [
        'good',
        'warning',
        'critical'
      ],
      datasets: [{
        label: '',
        backgroundColor: [
          'rgb(57,96,162)',
          'rgb(255, 205, 86)',
          'rgb(235,54,54)',
        ],
        hoverOffset: 4,
        hoverBackgroundColor: [
          'rgb(76,120,190)',
          'rgb(232,191,115)',
          'rgb(232,88,88)',
        ]
      }]
    };
    // const data2 = {
    //   labels: [
    //     'good',
    //     'warning',
    //     'critical'
    //   ],
    //   datasets: [{
    //     label: '',
    //     data: [],
    //     backgroundColor: [
    //       'rgb(57,96,162)',
    //       'rgb(255, 205, 86)',
    //       'rgb(235,54,54)',
    //     ],
    //     hoverOffset: 4,
    //     hoverBackgroundColor: [
    //       'rgb(76,120,190)',
    //       'rgb(232,191,115)',
    //       'rgb(232,88,88)',
    //     ]
    //   }]
    // };
    const myChart = new Chart(ctx, {
      type: 'doughnut',
      data: data,
    });
    const myChart2 = new Chart(ctx2, {
      type: 'doughnut',
      data: data,
    });
    // const myChart3 = new Chart(ctx3, {
    //   type: 'doughnut',
    //   data: data2,
    // });
    // const myChart4 = new Chart(ctx4, {
    //   type: 'doughnut',
    //   data: data2,
    // });

    // display data
    EngineService.getEngine().then(response => {
      this.engineInfo = response.data;

      // for now... this will be more efficient in the future
      // engine1 rpm
      myChart.data.datasets[0].data[0] = response.data[0].rpmGood
      myChart.data.datasets[0].data[1] = response.data[0].rpmWarning
      myChart.data.datasets[0].data[2] = response.data[0].rpmCritical
      myChart.update()

      // engine2 rpm
      myChart2.data.datasets[0].data[0] = response.data[1].rpmGood
      myChart2.data.datasets[0].data[1] = response.data[1].rpmWarning
      myChart2.data.datasets[0].data[2] = response.data[1].rpmCritical
      myChart2.update()

      // // engine1 kw
      // myChart3.data.datasets[0].data[0] = response.data[0].kwGood
      // myChart3.data.datasets[0].data[1] = response.data[0].kwWarning
      // myChart3.data.datasets[0].data[2] = response.data[0].kwCritical
      // myChart3.update()
      //
      // // engine2 kw
      // myChart4.data.datasets[0].data[0] = response.data[1].kwGood
      // myChart4.data.datasets[0].data[1] = response.data[1].kwWarning
      // myChart4.data.datasets[0].data[2] = response.data[1].kwCritical
      // myChart4.update()
    })
    myChart;
    myChart2;
    // myChart3;
    // myChart4;
  },
  methods: {
    getSensor() {
      EngineService.getEngine()
          .then(response => {
            this.sensor = response.data
            console.log(response.data)
          })
          .catch(e => {
            console.log(e)
          })
    }
  }
}
</script>

<style scoped>


.chart-container {
  display: flex;
  margin-bottom: 30px;
  height: 150px;
  width: 190px;
}

.sections {
  line-height: 12px;
  display: flex;
  align-items: center;
}

.el-card {
  background: #002C48;
  border: none;
  color: #E0E1DD;
  text-align: center;
  border-radius: 20px;
}

.section {
  margin: 10px;
  box-shadow: 3px 4px 12px 0px rgba(0, 0, 0, 0.5);
  -webkit-box-shadow: 3px 4px 12px 0px rgba(0, 0, 0, 0.5);
  -moz-box-shadow: 3px 4px 12px 0px rgba(0, 0, 0, 0.5);
}

.temperature_title {
  font-size: 1.5rem;
}

.temperature {
  font-size: 2rem;
  font-weight: 600;
  color: #1CD0FF;
  padding-top: 10px;
}

</style>
