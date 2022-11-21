<template>
  <el-card shadow="always" class="el-card">
    <h1>Battery Info</h1>

    <div class="content">
      <el-row class="sections">
        <el-card class="section">
          <h1>Battery Info(KW/H)</h1>
          <div class="chart-container1">
            <canvas id="engineInformationChart" ref="engineInformationChart3"></canvas>
            <canvas id="engineInformationChart2" ref="engineInformationChart4"></canvas>
          </div>
<!--          <h2 class="condition-title">Battery pack 1 level</h2>-->
<!--          <p class="condition-value">88%</p>-->
        </el-card>
        <el-card class="section">
          <h1>Battery Info(%)</h1>
          <div class="chart-container">
            <canvas id="batteryPercentage " ref="batteryChart"></canvas>
          </div>
<!--          <h2 class="condition-title">Battery pack 2 level</h2>-->
<!--          <p class="condition-value">67%</p>-->
        </el-card>
        <el-card class="section">
          <h2 class="condition-title">Battery pack 1 temperature</h2>
          <p class="condition-value">45°C</p>
        </el-card>
        <el-card class="section">
          <h2 class="condition-title">Battery pack 2 temperature</h2>
          <p class="condition-value">60°C</p>
        </el-card>
      </el-row>
    </div>

    <br><br>
  </el-card>
</template>

<script>
import Chart from 'chart.js/auto';
import EngineService from "@/services/EngineService";
// import ShipService from "@/services/ShipService";
import SensorDataService from "@/services/SensorDataService";
export default {
  name: "BatteryInfo",

  mounted() {
    console.log('Component mounted')
    let ctx = this.$refs["batteryChart"];

    // Chart
    const myChart = new Chart(ctx, {
      type: 'bar',
      data: {
        labels: ['Battery pack 1', 'Battery pack 2'],
        datasets: [{
          label: 'Battery(%)',
          data: [0,100],
          barThickness: 40,
          backgroundColor: [
            'rgb(23,145,4)',
            'rgb(23,145,4)'
          ],
          borderColor: [
            'rgb(23,145,4)',
            'rgb(23,145,4)'
          ],
          borderWidth: 1,
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true,
          }
        }
      }
    });

    // display data
    SensorDataService.getSensorData().then(response => {
      this.chart = response.data;
      myChart.data.datasets[0].data[0] = response.data[2].value
      console.log(response.data)
      myChart.data.datasets[0].data[1] = response.data[3].value
      myChart.update()
      myChart;
    })

    let ctx3 = this.$refs["engineInformationChart3"];
    let ctx4 = this.$refs["engineInformationChart4"];

    const data2 = {
      labels: [
        'good',
        'warning',
        'critical'
      ],
      datasets: [{
        label: '',
        data: [],
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
    const myChart3 = new Chart(ctx3, {
      type: 'doughnut',
      data: data2,
    });
    const myChart4 = new Chart(ctx4, {
      type: 'doughnut',
      data: data2,
    });

    // display data
    EngineService.getEngine().then(response => {
      this.engineInfo = response.data;

      // for now... this will be more efficient in the future
      // engine1 kw
      myChart3.data.datasets[0].data[0] = response.data[0].kwGood
      myChart3.data.datasets[0].data[1] = response.data[0].kwWarning
      myChart3.data.datasets[0].data[2] = response.data[0].kwCritical
      myChart3.update()

      // engine2 kw
      myChart4.data.datasets[0].data[0] = response.data[1].kwGood
      myChart4.data.datasets[0].data[1] = response.data[1].kwWarning
      myChart4.data.datasets[0].data[2] = response.data[1].kwCritical
      myChart4.update()
    })
    myChart;
    myChart3;
    myChart4;
  },
}
</script>

<style scoped>
.chart-container1 {
  display: flex;
  margin-bottom: 30px;
  height: 150px;
  width: 190px;
}
.chart-container{
  position: absolute;
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
  box-shadow: 3px 4px 12px 0px rgba(0,0,0,0.5);
  -webkit-box-shadow: 3px 4px 12px 0px rgba(0,0,0,0.5);
  -moz-box-shadow: 3px 4px 12px 0px rgba(0,0,0,0.5);
}

.condition-title {
  font-size: 1.5rem;
}

.condition-value {
  padding-top: 10px;
  font-size: 2rem;
  font-weight: 600;
  color: #1CD0FF;
}
</style>
