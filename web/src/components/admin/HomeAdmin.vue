<template>
  <div class="app">
    <div class="chart">
      <div style="display: inline-flex">
        <div style="width: 80%" class="chart11">
          <apexcharts ref="Chart" :options="chartOptions" :series="series" type="bar" width="650"></apexcharts>
        </div>
        <div class="year-select" style="display: inline-block; width: 20%">
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

      <div class="table-x">
        <el-radio v-model="radio" label="1"
                  @click.native="getTopJob">Top Job
        </el-radio>
        <el-radio v-model="radio" label="2"
                  @click.native="getTopRecruiter">Top Recruiter
        </el-radio>
        <el-table
            :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()) || data.title.toLowerCase().includes(search.toLowerCase()))"
            style="width: 100%">
          <el-table-column
              :label="form.first"
              :prop="props.first">
          </el-table-column>
          <el-table-column
              :label="form.second"
              :prop="props.second">
          </el-table-column>
          <el-table-column
              :label="form.third"
              :prop="props.third">
          </el-table-column>
          <el-table-column
              :label="form.four"
              :prop="props.four">
          </el-table-column>
        </el-table>
      </div>

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
      Job: 'Haha',
      tableData: [],
      search: '',
      totalElement: 0,
      size: 0,
      radio: '1',
      form: {
        first: '',
        second: '',
        third: '',
        four: '',
      },
      props: {
        first: '',
        second: '',
        third: '',
        four: '',
      },
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
    this.countValueBadge();
    this.loadData(this.value)
    this.getTopJob()
  },
  methods: {
    loadData(year) {
       axios.get('http://localhost:8080/admin/jobs/statistic?year='+year)
          .then((response) => {
            console.log('response.data',response.data.data)
            let newData = response.data.data
            this.series[0].data = newData
            axios.get('http://localhost:8080/admin/apply/statistic?year=' + year)
                .then((response) => {
                  console.log('response.data', response.data.data)
                  let newData2 = response.data.data
                  this.series[1].data = newData2
                  this.$refs.Chart.updateSeries(this.series);
                })
          })
    },
    countValueBadge() {
      this.loading = true;
      axios.get('http://localhost:8080/admin/jobs-not-active')
          .then((response) => {
            console.log('response.data', response.data.data)
            this.tableData = response.data.data;
            this.$store.dispatch("updateNumberRow", this.tableData.length)
            this.loading = false;
          })
          .catch((e) => {
            this.error.push(e);
          })
    },
    getTopJob() {
      axios.get('http://localhost:8080/admin/apply/statistic/top-job')
          .then((response) => {
            this.form = {
              first: 'Job',
              second: 'Recruiter',
              third: 'Created At',
              four: 'Amount Apply',
            }
            this.props = {
              first: 'title',
              second: 'name',
              third: 'createdAt',
              four: 'amount',
            },
                console.log('response.data', response.data.content)
            this.tableData = response.data.content;
            this.totalElement = response.data.totalElements;
            this.size = response.data.size;
          })
          .catch((e) => {
            this.error.push(e);
          })
    },
    getTopRecruiter() {
      axios.get('http://localhost:8080/recruiter/get-top')
          .then((response) => {
            this.form = {
              first: 'Name',
              second: 'Dob',
              third: 'Company',
              four: 'Amount Job',
            }
            this.props = {
              first: 'name',
              second: 'dob',
              third: 'company',
              four: 'amount',
            },
                console.log('response.data', response.data.data)
            this.tableData = response.data.data;
            this.tableData.s
          })
          .catch((e) => {
            this.error.push(e);
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

.chart {
  position: absolute;
  left: 600px;
  top: 80px
}

.table-x {
  padding-top: 35px;
}
</style>

