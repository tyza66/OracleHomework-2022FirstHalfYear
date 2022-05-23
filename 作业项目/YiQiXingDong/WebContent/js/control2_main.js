var app = new Vue({
  el: "#app",
  data: {
    search: '',
    tableData: [],
    dialogVisible: false,
    labelPosition: 'right',
    formLabelAlign: {
      id: '',
      type: '',
      number: '',
      place: ''
    }
  },
  created: function () {

  },
  methods: {
    gopage(n) {
      window.location.href = './control' + n + '.jsp'
    },
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          this.formLabelAlign.id = ''
          this.formLabelAlign.type = ''
          this.formLabelAlign.number = ''
          this.formLabelAlign.place = ''
          done();
        })
        .catch(_ => { });
    },
    putVegatable(id,type,number,place){
      var one = {
        id: id,
        type: type,
        number: number,
        place: place
      }
      this.tableData.push(one);
    },
    insert(){
      window.location.href = '../'
    }
  }
});