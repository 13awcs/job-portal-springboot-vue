<template>
  <div class="center pad" v-loading="loading">
    <div>

    </div>
    <div class="pag">
      <span>
        <b>Search</b>
        <el-input placeholder="Search student" v-model="search" @keyup.enter.native="searchFunc(search)"></el-input>
      </span>

      <span>
        <el-select v-model="value" filterable placeholder="Select">
        <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
        </el-option>
      </el-select>
      </span>

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
            label="Action">
          <template slot-scope="scope" >
            <div>
              <el-button size="mini" class="primary-btn" type="green" @click="() => showDetail(scope.row)">
                Accept
              </el-button>
              <el-button size="mini" type="danger"
                         @click="deleteStudent(scope.$index, scope.row)">
                Reject
              </el-button>
            </div>
          </template>
        </el-table-column>
        <el-table-column align="left">


        </el-table-column>


      </el-table>
      <!--      <el-pagination class="pagination"-->
      <!--                     v-model="tableData"-->
      <!--                     :current-page.sync="currentPage"-->
      <!--                     background-->
      <!--                     layout="prev, pager, next"-->
      <!--                     :page-size="size"-->
      <!--                     :total="totalElement">-->
      <!--      </el-pagination>-->
    </div>

    <!--    <div>-->
    <!--      <el-dialog title="Apply information" :model="form" :visible.sync="dialogEditFormVisible" >-->
    <!--        <el-form>-->
    <!--          <el-form-item label="Candidate" :label-width="formLabelWidth">-->
    <!--            <el-input v-model="form.name" autocomplete="off"></el-input>-->
    <!--          </el-form-item>-->
    <!--          <el-form-item label="Job" :label-width="formLabelWidth">-->
    <!--            <el-input v-model="form.title" autocomplete="off"></el-input>-->
    <!--          </el-form-item>-->
    <!--          <el-form-item label="Date apply" :label-width="formLabelWidth">-->
    <!--            <el-input v-model="form.dateApply" autocomplete="off"></el-input>-->
    <!--          </el-form-item>-->
    <!--          <el-form-item label="Status" :label-width="formLabelWidth">-->
    <!--            <el-input v-model="form.statusApply" autocomplete="off"></el-input>-->
    <!--          </el-form-item>-->
    <!--        </el-form>-->
    <!--        <div slot="footer" class="dialog-footer">-->
    <!--          <el-button @click="resetForm">Cancel</el-button>-->
    <!--          <el-button type="primary" @click="save">Save</el-button>-->
    <!--        </div>-->
    <!--      </el-dialog>-->
    <!--    </div>-->
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
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
    // currentPage() {
    //   this.clickPagination(this.currentPage-1);
    // }

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
      axios.get('http://localhost:8080/applies/bydate')
          .then((response) => {
            console.log('response.data',response.data.data)
            this.tableData = response.data.data;
            this.loading = false;
          })
          .catch((e) => {
            this.error.push(e);
          })
    },
    // clickPagination(pageNum) {
    //   axios.get('http://localhost:8080/students/?page=' + pageNum)
    //       .then((response) => {
    //         this.tableData = response.data.content;
    //         this.loading = false;
    //       })
    //       .catch((e) => {
    //         this.error.push(e);
    //       })
    //
    // },
    // deleteStudent(index, row) {
    //   console.log("xoa id", row.id)
    //   axios.delete('http://localhost:8080/students/' + row.id)
    //   this.tableData.splice(index, 1)
    // },
    // save() {
    //   this.dialogEditFormVisible = true
    //   console.log("data to save: ", this.form);
    //   let url = this.form.id ? 'http://localhost:8080/students/edit/' + this.form.id  : 'http://localhost:8080/students/add' ;
    //   console.log("id nay",this.form.id)
    //   axios.post(url, this.form)
    //       .then(() => this.loadData());
    //   this.resetForm();
    // },
    // searchFunc(keyword) {
    //   axios.get('http://localhost:8080/students/student/?search=' + keyword)
    //       .then((response) => {
    //         console.log(response.data)
    //         this.tableData = response.data.content;
    //       })
    //       .catch((e) => {
    //         this.error.push(e);
    //       })
    //
    // },
    // add(){
    //   this.resetForm();
    //   this.dialogEditFormVisible = true;
    // },
    // resetForm() {
    //   this.dialogEditFormVisible = false;
    //   this.form = {
    //     id: "",
    //     name: "",
    //     information: "",
    //     grade: "",
    //   }
    // },
    // showDetail(data) {
    //   console.log("data detail: ", data);
    //   this.dialogEditFormVisible = true;
    //   this.form = {
    //     id: data.id,
    //     name: data.name,
    //     information: data.information,
    //     grade: data.grade
    //   }
    //   console.log("id o day",this.form.id)
    // },

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