<template>
  <div id="app" >
    <Nav></Nav>
    <div>
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import Nav from './components/Nav'
export default {
  name: 'App',
  components: {
    Nav
  }
}
</script>
<style>
.mid  {
  padding-top: 100px;
  padding-left: 100px;
  padding-right: 100px;

}
.header-nav {
}
</style>

