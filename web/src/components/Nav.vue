<template>
  <div>
    <div>
      <nav class="navbar navbar-expand navbar-light fixed-top nav">
        <div class="container header-nav">
          <a v-if="(currentPath === '/home' || '/job') && currentPath !== '/' && currentPath !== '/login'"
             :class="currentPath === '/home' ? 'active' : ''" class="navbar-brand" href="/home">Home</a>

          <div class="pad">
            <el-badge :value="numberRows !== 0 && numberRows" class="item">
              <a v-if="(currentPath === '/home' || '/job') && currentPath !== '/' && currentPath !== '/login'"
                 :class="currentPath === '/job' ? 'active' : ''" class="navbar-brand" href="/job">Jobs</a>
            </el-badge>
          </div>
          <div class="collapse navbar-collapse" style="justify-content: end;">
            <u class="navbar-nav ml-auto login-signup">
              <li class="nav-item">
                <a v-if="(currentPath === '/' || '/login') && currentPath !== '/home' && currentPath !== '/job' && currentPath !== '/recruiter'
                    && currentPath !== '/candidate'"
                   :class=" hideBadge == true && currentPath === '/login' ? 'active' : ''" class="nav-link"
                   href="/login">Login</a>
                <a v-if="(currentPath === '/home' || '/job' || '/recruiter') && currentPath !== '/' && currentPath !== '/login'"
                   :class="hideBadge == true && currentPath === '/log-out' ? 'active' : ''" class="nav-link " style="cursor: pointer" @click="logOut">
                  Logout
                </a>
              </li>
            </u>
          </div>
        </div>
      </nav>
    </div>
  </div>
</template>

<script>

export default {
  name: "Nav",
  components: {},
  data() {
    return {
      path: '',
      disable: 'false'
    }
  },
  watch: {
    setBadgeStatus() {
      return this.disable = 'true'
    }
  },
  computed: {
    currentPath() {
      return this.$route.path;
    },
    numberRows() {
      return this.$store.state.numberTableRows;
    },
  },
  methods:{
    logOut() {
      this.hideBadge();
      localStorage.removeItem('vuex');
      this.$router.push('/login');
    },
    hideBadge() {
      return this.$store.state.numberTableRows = 0;
    },
  },
  beforeDestroy() {
    localStorage.removeItem('vuex');
  }
}
</script>

<style scoped>
.active {
  font-weight: bold;
}

.nav {
  background: #e7e7e7;
}

.pad {
  padding-left: 30px;
}

.drop {
  font-weight: bold;
}
</style>