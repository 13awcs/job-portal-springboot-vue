<template>
  <div class="center pad" v-loading="loading">
    <div>

    </div>
    <b>Search</b>
    <div>
      <div style="display: inline-block">
        <el-input placeholder="Search student" v-model="search" @keyup.enter.native="searchFunc(search)"></el-input>
      </div>
      <div style="display: inline-block" class="option">
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
          :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()) || data.title.toLowerCase().includes(search.toLowerCase()))"
          style="width: 100%"
          :cell-class-name="setColorStatus">

        <el-table-column
            label="Candidate"
            prop="name">
        </el-table-column>
        <el-table-column
            label="Job"
            prop="title">
        </el-table-column>
        <el-table-column
            label="Date apply"
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

  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      status: '',
      currentPage: 0,
      loading: false,
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

  },
  methods: {
    setColorStatus({row, rowIndex,columnIndex}) {
      if (columnIndex === 3 && row.status === 'Accepted') {
        return 'accept';
      } else if (columnIndex === 3 && row.status === 'Rejected') {
        return 'reject';
      }
      return '';
    },
    loadData() {
      this.loading = true;
      axios.get('http://localhost:8080/applies/has-status')
          .then((response) => {
            console.log('response.data',response.data.data)
            this.tableData = response.data.data;
            this.loading = false;
          })
          .catch((e) => {
            this.error.push(e);
          })
    },
    select() {
      axios.get('http://localhost:8080/applies/search?status='+this.value)
          .then((response) => {
            console.log('response.data',response.data.data)
            this.tableData = response.data.data;
            this.loading = false;
          })
          .catch((e) => {
            this.error.push(e);
          })
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

</style>