<template>
  <div class="app padding">
    <apexcharts ref="Chart" width="650" type="bar" :options="chartOptions" :series="series"></apexcharts>
    <div style="display: inline-block">
      <el-select v-model="value"
                 filterable
                 placeholder="Select"
                 @change="loadData">
        <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value"
        >
        </el-option>
      </el-select>
    </div>
  </div>
</template>

<script>
import VueApexCharts from 'vue-apexcharts'
import axios from "axios";

export default {
  name: 'Chart',
  components: {
    apexcharts: VueApexCharts,
  },
  data() {
    return {
      options: [{
        value: '2021',
        label: '2021'
      }, {
        value: '2022',
        label: '2022'
      }],
      value: new Date().getFullYear(),
      chartOptions: {
        chart: {
          id: 'vuechart-example',
        },
        xaxis: {
          categories: ['Jan','Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct','Nov','Dec'],
        },
      },
      series: [{
        name: 'Job',
        data: []
      },{
        name: 'Apply',
        data: []
      }]
    }
  },
  created() {
    this.loadData(this.value)
  },
  methods: {
    loadData(year) {
       axios.get('http://localhost:8080/admin/jobs/statistic?year='+year)
          .then((response) => {
            console.log('response.data',response.data.data)
            let newData = response.data.data
            this.series[0].data = newData
            axios.get('http://localhost:8080/admin/apply/statistic?year='+year)
                .then((response) => {
                  console.log('response.data',response.data.data)
                  let newData2 = response.data.data
                  this.series[1].data = newData2
                  this.$refs.Chart.updateSeries(this.series);
                })
          })
    },
  }
}
</script>
<style scoped>
button {
  background: #26E6A4;
  border: 0;
  font-size: 16px;
  color: '#fff';
  padding: 10px;
  margin-left: 28px;
}
.padding {
  display: flex;
  padding-top: 60px;
  padding-left: 600px;
}
</style>

