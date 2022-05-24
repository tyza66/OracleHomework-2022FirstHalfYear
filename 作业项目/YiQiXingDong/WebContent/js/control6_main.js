var app = new Vue({
  el: "#app",
  data: {
    value1:false,
    value2:false,
    value3:false,
    value4:false,
    value5:false,
    value6:false,
    value7:false,
    value8:false,
    value9:false,
    value10:false,
  },
  created: function () {
    this.tempDate = this.tableData;
  },
  methods: {
    gopage(n) {
      window.location.href = './control' + n + '.jsp'
    }
  }
});