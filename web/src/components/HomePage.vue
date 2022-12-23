<template>
  <div v-loading="loading" class="center pad">
    <b>Search</b>
    <div>
      <div style="display: inline-block">
        <el-input v-model="search" placeholder="Search student" @keyup.enter.native="searchFunc(search)"></el-input>
      </div>
      <div class="option" style="display: inline-block">
        <el-select v-model="value"
                   filterable
                   placeholder="Select"
                   @change="select"
        >
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

    <div>

      <el-table
          :cell-class-name="setColorStatus"
          :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()) || data.title.toLowerCase().includes(search.toLowerCase()))"
          style="width: 100%"
          @cell-click="showInfoDialog">
        <el-table-column
            label="Candidate"
            prop="name">
          <template slot-scope="scope">
            <div>{{ scope.row.name }}</div>
          </template>
        </el-table-column>
        <el-table-column
            label="Job"
            prop="title">
          <template slot-scope="scope">
            <div>{{ scope.row.title }}</div>
          </template>
        </el-table-column>
        <el-table-column
            label="Apply date"
            prop="applyDate">
        </el-table-column>
        <el-table-column
            v-model="status"

            label="Status"
            prop="status"
        >
        </el-table-column>

      </el-table>
    </div>
    <div>
      <el-dialog :model="candidate" :visible.sync="centerDialogVisible" title="Candidate information">
        <div style="display: inline-flex; width: 100%;">
          <el-form :model="candidate" style="width: 70%;">
            <el-form-item :label-width="formLabelWidth" label="Name">
              <el-input v-model="candidate.name" autocomplete="off" class="input" readonly="true"></el-input>
            </el-form-item>
            <el-form-item :label-width="formLabelWidth" label="Education">
              <el-input v-model="candidate.education" autocomplete="off" readonly="true"></el-input>
            </el-form-item>
            <el-form-item :label-width="formLabelWidth" label="Title">
              <el-input v-model="candidate.level" autocomplete="off" readonly="true"></el-input>
            </el-form-item>
            <el-form-item :label-width="formLabelWidth" label="DoB">
              <el-input v-model="candidate.dob" autocomplete="off" readonly="true"></el-input>
            </el-form-item>
            <el-form-item :label-width="formLabelWidth" label="Email">
              <el-input v-model="candidate.email" autocomplete="off" readonly="true"></el-input>
            </el-form-item>
            <el-form-item :label-width="formLabelWidth" label="Phone">
              <el-input v-model="candidate.phone" autocomplete="off" readonly="true"></el-input>
            </el-form-item>
            <el-form-item :label-width="formLabelWidth" label="Address">
              <el-input v-model="candidate.address" autocomplete="off" readonly="true"></el-input>
            </el-form-item>
          </el-form>
          <span style="width: 30%; padding-left: 10px;">
            <el-image
                :fit="cover"
                :src="candidate.avatar"
                style="width: 250px; height: 300px"></el-image>
          </span>
        </div>
        <div slot="footer" class="dialog-footer">
          <el-button @click="centerDialogVisible = false">Cancel</el-button>
        </div>
      </el-dialog>
    </div>

    <div>
      <el-dialog :model="job" :visible.sync="jobDialogVisible" title="Job information">
        <div>
          <el-form :model="job" style="width: 550px;">
            <el-form-item :label-width="formLabelWidth" label="Title">
              <el-input v-model="job.title" autocomplete="off" class="input" readonly="true"></el-input>
            </el-form-item>
            <el-form-item :label-width="formLabelWidth" label="Type">
              <el-input v-model="job.type" autocomplete="off" readonly="true"></el-input>
            </el-form-item>
            <el-form-item :label-width="formLabelWidth" label="Level">
              <el-input v-model="job.level" autocomplete="off" readonly="true"></el-input>
            </el-form-item>
            <el-form-item :label-width="formLabelWidth" label="Company Name">
              <el-input v-model="job.companyName" autocomplete="off" readonly="true"></el-input>
            </el-form-item>
            <el-form-item :label-width="formLabelWidth" label="Salary">
              <el-input v-model="job.salary+' $'" autocomplete="off" readonly="true"></el-input>
            </el-form-item>
            <el-form-item :label-width="formLabelWidth" label="Location">
              <el-input v-model="job.location" autocomplete="off" readonly="true"></el-input>
            </el-form-item>
            <el-form-item :label-width="formLabelWidth" label="Amount">
              <el-input v-model="job.amount" autocomplete="off" readonly="true"></el-input>
            </el-form-item>
          </el-form>
        </div>
        <div slot="footer" class="dialog-footer">
          <el-button @click="jobDialogVisible = false">Cancel</el-button>
        </div>
      </el-dialog>
    </div>
  </div>


</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      centerDialogVisible: false,
      jobDialogVisible: false,
      status: '',
      loading: false,
      valueBadge: [],
      tableData: [],
      options: [{
        value: 'Accepted',
        label: 'Accepted'
      }, {
        value: 'Rejected',
        label: 'Rejected'
      }],
      value: '',
      totalElement: 0,
      size: 0,
      error: [],
      search: '',
      form: {
        id: '',
        name: '',
        title: '',
        dateApply: '',
        statusApply: '',
      },
      formLabelWidth: '120px',
      candidate: {
        name: '',
        education: '',
        address: '',
        level: '',
        dob: '',
        email: '',
        phone: '',
        avatar: '',
      },
      job: {
        title: '',
        type: '',
        level: '',
        companyName: '',
        salary: '',
        location: '',
        amount: '',
      }
    }

  },
  created() {
    this.countValueBadge();
    this.loadData();

  },
  watch: {
    search() {
      if (this.search == '') {
        this.loadData();
      }
    },


  },
  methods: {
    setColorStatus({row, rowIndex, columnIndex}) {
      if (columnIndex === 3 && row.status === 'Accepted') {
        return 'accept';
      } else if (columnIndex === 3 && row.status === 'Rejected') {
        return 'reject';
      }
      return '';
    },
    loadData() {
      this.loading = true;
      console.log('recruiterId: ',this.$store.state.recruiterId)
      axios.get('http://localhost:8080/applies/has-status/'+this.$store.state.recruiterId)
          .then((response) => {
            console.log('response.data', response.data.data)
            this.tableData = response.data.data;
            this.loading = false;
          })
          .catch((e) => {
            this.error.push(e);
          })
    },
    countValueBadge() {
      this.loading = true;
      axios.get('http://localhost:8080/applies/has-no-status/'+this.$store.state.recruiterId)
          .then((response) => {
            console.log('response.data', response.data.data)
            this.valueBadge = response.data.data;
            this.$store.dispatch("updateNumberRow", this.valueBadge.length)
            this.loading = false;
          })
          .catch((e) => {
            this.error.push(e);
          })
    },
    select() {
      axios.get('http://localhost:8080/applies/search?status=' + this.value)
          .then((response) => {
            console.log('response.data', response.data.data)
            this.tableData = response.data.data;
            this.loading = false;
          })
          .catch((e) => {
            this.error.push(e);
          })
    },
    showInfoDialog(row, column, cell, event) {
      if (column.label === 'Candidate') {
        axios.get('http://localhost:8080/candidates/candidate-by-apply-id/' + row.id)
            .then((response) => {
              console.log('response.data', response.data.data)
              this.candidate = response.data.data;
              console.log('candidate : ', this.candidate)
              this.loading = false;
            })
            .catch((e) => {
              this.error.push(e);
            })
        this.centerDialogVisible = true
      }
      if (column.label === 'Job') {
        this.jobDialogVisible = true
        axios.get('http://localhost:8080/jobs/job-by-apply-id/' + row.id)
            .then((response) => {
              console.log('response.data', response.data.data)
              this.job = response.data.data;
              console.log('job : ', this.job)
              this.loading = false;
            })
            .catch((e) => {
              this.error.push(e);
            })

      }
    }

  },
}
</script>

<style>
@import url("//unpkg.com/element-ui@2.15.12/lib/theme-chalk/index.css");

.center {
  padding: 200px 0;
}

.pag {
  padding: 30px 0;
  width: 300px;

}

.option {
  padding-left: 1000px;
}

.accept {
  font-weight: bold;
  color: forestgreen;
  font-size: 18px;
}

.reject {
  font-weight: bold;
  font-size: 18px;
  color: crimson;
}

.pagination {
  display: table;
  margin: 0 auto;
  padding: 10px;
}

.pad {
  padding-right: 100px;
  padding-left: 100px;
}

.input {
  font-size: large;
  font-weight: bold;
}


</style>