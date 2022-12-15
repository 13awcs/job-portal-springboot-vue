<template>
  <div>
    <div>
      <nav class="navbar navbar-expand navbar-light fixed-top nav">
        <div class="container header-nav">
          <a href="/" class="navbar-brand" :class="currentPath === '/' ? 'active' : ''">Home</a>
          <a href="/job" class="navbar-brand" :class="currentPath === '/job' ? 'active' : ''">Jobs</a>
          <div class="collapse navbar-collapse" style="justify-content: end;">
            <u class="navbar-nav ml-auto login-signup">
              <li class="nav-item">
                <a href="/login" class="nav-link" :class="currentPath === '/login' ? 'active' : ''">Login</a>
              </li>
              <li class="nav-item">
                <a href="/sign-up"
                   class="nav-link"
                   :class="currentPath === '/sign-up' ? 'active' : ''">Sign up</a>
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
    }
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
</style>