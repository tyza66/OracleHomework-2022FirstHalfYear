var app = new Vue({
  el: "#app",
  data: {
    search: '',
    tableData: [{
      id:'',
      type:'',
      number:'',
      place:''
    }]
  },
  created: function () {

  },
  methods: {
    gopage(n){
      window.location.href = './control'+n+'.jsp'
    }
  }
});