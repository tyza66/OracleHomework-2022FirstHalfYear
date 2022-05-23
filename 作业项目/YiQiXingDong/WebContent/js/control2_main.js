var app = new Vue({
  el: "#app",
  data: {
    search: '',
    tableData: [{
      id: '',
      type: '',
      number: '',
      place: ''
    }],
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
    }
  }
});