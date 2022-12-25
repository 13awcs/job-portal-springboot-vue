<template>
  <div class="center pad" v-loading="loading">
    <div class="pag">
      <b>Search</b>
      <el-input placeholder="Search" v-model="search" @keyup.enter.native="searchFunc(search)"></el-input>
    </div>
    <div>
      <el-table
          :data="tableData.filter(data => !search || data.title.toLowerCase().includes(search.toLowerCase()) || data.recruiter.toLowerCase().includes(search.toLowerCase())
          || data.companyName.toLowerCase().includes(search.toLowerCase()))"
          style="width: 120%"
          @cell-click="showInfoDialog">

        <el-table-column
            label="Job"
            prop="title">
        </el-table-column>
        <el-table-column
            label="Recruiter"
            prop="recruiter">
        </el-table-column>
        <el-table-column
            label="Company"
            prop="companyName">
        </el-table-column>
        <el-table-column
            label="Create At"
            prop="createAt">
        </el-table-column>
        <el-table-column
            label="Action">
          <template slot-scope="scope" >
            <div>
              <el-button size="mini" class="primary-btn" type="green" @click="accept(scope.$index, scope.row)">
                Accept
              </el-button>
              <el-button size="mini" type="danger"
                         @click="reject(scope.$index, scope.row)">
                Reject
              </el-button>
            </div>
          </template>
        </el-table-column>
        <el-table-column align="left">
        </el-table-column>
      </el-table>
    </div>

    <div>
      <el-dialog :model="recruiter" :visible.sync="centerDialogVisible" title="Recruiter information">
        <div style="display: inline-flex; width: 100%;">
          <el-form :model="recruiter" style="width: 70%;">
            <el-form-item :label-width="formLabelWidth" label="Name">
              <el-input v-model="recruiter.name" autocomplete="off" class="input" readonly="true"></el-input>
            </el-form-item>
            <el-form-item :label-width="formLabelWidth" label="Address">
              <el-input v-model="recruiter.address" autocomplete="off" readonly="true"></el-input>
            </el-form-item>
            <el-form-item :label-width="formLabelWidth" label="DoB">
              <el-input v-model="recruiter.dob" autocomplete="off" readonly="true"></el-input>
            </el-form-item>
            <el-form-item :label-width="formLabelWidth" label="Company">
              <el-input v-model="recruiter.companyName" autocomplete="off" readonly="true"></el-input>
            </el-form-item>
            <el-form-item :label-width="formLabelWidth" label="Email">
              <el-input v-model="recruiter.email" autocomplete="off" readonly="true"></el-input>
            </el-form-item>
            <el-form-item :label-width="formLabelWidth" label="Phone">
              <el-input v-model="recruiter.phone" autocomplete="off" readonly="true"></el-input>
            </el-form-item>
          </el-form>
          <span style="width: 30%; padding-left: 10px;">
            <el-image
                :src="recruiter.avatar"
                style="width: 250px; height: 300px"></el-image>
          </span>
        </div>
        <div slot="footer" class="dialog-footer">
          <el-button
              @click="enable"
              type="success">Enable</el-button>
          <el-button
              @click="disable"
              type="danger">Disable</el-button>
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
import { mapState } from 'vuex'
export default {
  data() {
    return {
      centerDialogVisible: false,
      jobDialogVisible: false,
      currentPage: 0,
      loading: false,
      tableData: [],
      totalElement: 0,
      count: 0,
      error: [],
      search: '',
      form: {
        id: '',
        title: '',
        name: '',
        companyName: '',
        createAt: '',
      },
      recruiter: {
        name: '',
        address: '',
        dob: '',
        companyName: '',
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
      },
      dialogEditFormVisible: false,
      dialogFormVisible: false,
      formLabelWidth: '120px'
    }
  },
  created() {
    this.loadData();
  },
  watch: {
    search() {
      if (this.search == '') {
        this.loadData();
      }
    },
    // currentPage() {
    //   this.clickPagination(this.currentPage-1);
    // }

  },
  methods: {
    loadData() {
      this.loading = true;
      axios.get('http://localhost:8080/admin/jobs-not-active')
          .then((response) => {
            console.log('response.data',response.data.data)
            this.tableData = response.data.data;
            this.$store.dispatch("updateNumberRow", this.tableData.length)
            this.loading = false;
          })
          .catch((e) => {
            this.error.push(e);
          })
    },
    accept(index,row) {
      axios.post('http://localhost:8080/jobs/set-active/'+row.id+'?active=true')
      this.tableData.splice(index, 1)
      console.log('count : ',this.tableData.length)
    },

    reject(index,row) {
      axios.post('http://localhost:8080/jobs/set-active/'+row.id+'?active=false')
      this.tableData.splice(index, 1)
      console.log('count : ',this.tableData.length)

    },
    disable() {
      axios.post('http://localhost:8080/recruiter/disable/'+this.form.id+'?disable=true')
      console.log('vao day : ',this.form.id)
      this.centerDialogVisible = false
    },
    enable(){
      axios.post('http://localhost:8080/recruiter/disable/'+this.form.id+'?disable=false')
      console.log('vao day : ',this.form.id)
      this.centerDialogVisible = false
    },
    showInfoDialog(row, column, cell, event) {
      if (column.label === 'Recruiter') {
        this.form.id = row.id
        axios.get('http://localhost:8080/recruiter/' + row.id)
            .then((response) => {
              console.log('response.data', response.data.data)
              this.recruiter = response.data.data;
              this.loading = false;
            })
            .catch((e) => {
              this.error.push(e);
            })
        this.centerDialogVisible = true
      }
      if (column.label === 'Job') {
        axios.get('http://localhost:8080/jobs/' + row.id)
            .then((response) => {
              console.log('response.data', response.data)
              this.job = response.data;
              this.loading = false;
            })
            .catch((e) => {
              this.error.push(e);
            })
        this.jobDialogVisible = true

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
.primary-btn {
  background: #198754;
  color: white;
}
</style>