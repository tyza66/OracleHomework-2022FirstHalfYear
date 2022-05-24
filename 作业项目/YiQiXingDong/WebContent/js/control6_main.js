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
    },
    commit(){
      var z1 = this.value1?2:1;
      var z2 = this.value2?2:1;
      var z3 = this.value3?2:1;
      var z4 = this.value4?2:1;
      var z5 = this.value5?2:1;
      var z6 = this.value6?2:1;
      var z7 = this.value7?2:1;
      var z8 = this.value8?2:1;
      var z9 = this.value9?2:1;
      var z10 = this.value10?2:1;
      window.location.href = '../FriendsController?t=2&z1='+z1+"&z2="+z2+"&z3="+z3+"&z4="+z4+"&z5="+z5+"&z6="+z6+"&z7="+z7+"&z8="+z8+"&z9="+z9+"&z10="+z10;
    }
  }
});