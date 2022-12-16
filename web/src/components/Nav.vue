<template>
  <div>
    <div>
      <nav class="navbar navbar-expand navbar-light fixed-top nav">
        <div class="container header-nav">
          <a v-if="(currentPath === '/home' || '/job') && currentPath !== '/' && currentPath !== '/login'"
             href="/home" class="navbar-brand" :class="currentPath === '/home' ? 'active' : ''">Home</a>
          <div class="pad">
            <el-badge :value="numberRows" class="item">
              <a v-if="(currentPath === '/home' || '/job') && currentPath !== '/' && currentPath !== '/login'"
                 href="/job" class="navbar-brand" :class="currentPath === '/job' ? 'active' : ''">Jobs</a>
            </el-badge>
          </div>



<!--          <a v-if="(currentPath === '/home' || '/job') && currentPath !== '/' && currentPath !== '/login'"-->
<!--             href="/profile" class="navbar-brand" :class="currentPath === '/profile' ? 'active' : ''">Profile</a>-->
          <div class="collapse navbar-collapse" style="justify-content: end;">
            <u class="navbar-nav ml-auto login-signup">
              <li class="nav-item">
                <a v-if="(currentPath === '/' || '/login') && currentPath !== '/home' && currentPath !== '/job'"
                   href="/login" class="nav-link" :class="currentPath === '/login' ? 'active' : ''">Login</a>
                <a v-if="(currentPath === '/home' || '/job') && currentPath !== '/' && currentPath !== '/login'"
                   href="/login" class="nav-link" :class="currentPath === '/log-out' ? 'active' : ''">Logout</a>
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
  computed: {
    currentPath() {
      return this.$route.path;
    },
    numberRows() {
      return this.$store.state.numberTableRows;
    }
  },
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
</style>