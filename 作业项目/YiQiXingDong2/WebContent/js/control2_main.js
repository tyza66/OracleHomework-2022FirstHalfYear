var app = new Vue({
  el: "#app",
  data: {
    search: '',
    tableData: [],
    tempDate:[],
    dialogVisible: false,
    labelPosition: 'right',
    formLabelAlign: {
      id: '',
      type: '',
      number: '',
      place: ''
    },
    dialogVisible2: false,
    labelPosition2: 'right',
    formLabelAlign2: {
      id: '',
      type: '',
      number: '',
      place: ''
    }
  },
  created: function () {
    this.tempDate = this.tableData;
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
    
    handleClose2(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          this.formLabelAlign2.id = ''
          this.formLabelAlign2.type = ''
          this.formLabelAlign2.number = ''
          this.formLabelAlign2.place = ''
          done();
        })
        .catch(_ => { });
    },
    
    putVegatable(id, type, number, place) {
      var one = {
        id: id,
        type: type,
        number: number,
        place: place
      }
      this.tableData.push(one);
    },
    
    insert() {
      window.location.href = '../vegetable?t=2&id=' + this.formLabelAlign.id + '&kind=' + this.formLabelAlign.type + '&number=' + this.formLabelAlign.number + "&place=" + this.formLabelAlign.place;
    },
    delete1(id) {
      window.location.href = '../vegetable?t=3&id=' + id;
    },
    handleClick(row) {
      this.formLabelAlign2 = {
        id: row.id,
        type: row.type,
        number: row.number,
        place: row.place
      }
      this.dialogVisible2 = true;
    },
    update(){
      window.location.href = '../vegetable?t=4&id=' + this.formLabelAlign2.id + '&kind=' + this.formLabelAlign2.type + '&number=' + this.formLabelAlign2.number + "&place=" + this.formLabelAlign2.place;
    },
    search1(){
      var temp = [];
      this.tableData = this.tempDate;
      for(var i = 0;i<this.tableData.length;i++){
        if(this.tableData[i].type.search(this.search)!=-1){
          temp.push(this.tableData[i]);
        }
      }
      this.tempDate = this.tableData;
      this.tableData = temp;
      this.search = "";
    },
    reload(){
      this.tableData = this.tempDate;
    }
  }
});