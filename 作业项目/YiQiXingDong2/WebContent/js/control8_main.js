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
      place: '',
      number2:''
    },
    dialogVisible2: false,
    labelPosition2: 'right',
    formLabelAlign2: {
      id: '',
      type: '',
      number: '',
      place: '',
       number2:''
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
          this.formLabelAlign.number2 = ''
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
          this.formLabelAlign2.number2 = ''
          done();
        })
        .catch(_ => { });
    },
    putVegatable(id, type, number, place,number2) {
      var one = {
        id: id,
        type: type,
        number: number,
        place: place,
        number2:number2
      }
      this.tableData.push(one);
    },
    insert() {
      window.location.href = '../Medical?t=2&id=' + this.formLabelAlign.id  +'&time=' 
      + this.formLabelAlign.type+'&pname='
      + this.formLabelAlign.number +  '&dname='
      + this.formLabelAlign.place +'&classify='
      + this.formLabelAlign.number2 ;
    },
    delete1(id) {
      window.location.href = '../Medical?t=3&id=' + id;
    },
    handleClick(row) {
      this.formLabelAlign2 = {
        id: row.id,
        type: row.type,
        number: row.number,
        place: row.place,
         number2: row.number2,
      }
      this.dialogVisible2 = true;
    },
    update(){
      window.location.href = '../Medical?t=4&id=' + this.formLabelAlign2.id 
      + '&time=' + this.formLabelAlign2.type 
      + '&pname=' + this.formLabelAlign2.number 
      + "&dname=" + this.formLabelAlign2.place
      + '&classify=' + this.formLabelAlign2.number2;
    },
    search1(){
      var temp = [];
      this.tableData = this.tempDate;
      for(var i = 0;i<this.tableData.length;i++){
        if(this.tableData[i].number.search(this.search)!=-1){
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