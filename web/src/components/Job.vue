<template>
  <div class="center pad" v-loading="loading">
    <div>

    </div>
    <div class="pag">
        <b>Search</b>
        <el-input placeholder="Search student" v-model="search" @keyup.enter.native="searchFunc(search)"></el-input>
    </div>

    <div>

      <el-table
          :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()) || data.title.toLowerCase().includes(search.toLowerCase()))"
          style="width: 120%">

        <el-table-column
            label="Candidate"
            prop="name">
        </el-table-column>
        <el-table-column
            label="Job"
            prop="title">
        </el-table-column>
        <el-table-column
            label="Apply date"
            prop="applyDate">
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

  </div>
</template>

<script>
import axios from "axios";
import { mapState } from 'vuex'
export default {
  data() {
    return {
      currentPage: 0,
      loading: false,
      tableData: [],
      totalElement: 0,
      count: 0,
      error: [],
      search: '',
      form: {
        id: '',
        name: '',
        title: '',
        dateApply: '',
        statusApply: '',
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
      axios.get('http://localhost:8080/applies/has-no-status')
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
      axios.post('http://localhost:8080/applies/edit/'+row.id+'?status=Accepted')
      this.tableData.splice(index, 1)
      console.log('count : ',this.tableData.length)
    },

    reject(index,row) {
      axios.post('http://localhost:8080/applies/edit/'+row.id+'?status=Rejected')
      this.tableData.splice(index, 1)
      console.log('count : ',this.tableData.length)

    },

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