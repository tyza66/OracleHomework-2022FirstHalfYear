var app = new Vue({
  el: "#app",
  data: {
    search: '',
    tableData: [],
    tempDate:[],
    dialogVisible: false,
    labelPosition: 'right',
    formLabelAlign: {
      id:'',
      name: '',
      sex: '',
      phone: '',
      departmentid: '',
      pwd:''
    },
    dialogVisible2: false,
    labelPosition2: 'right',
    formLabelAlign2: {
      id:'',
      name: '',
      sex: '',
      phone: '',
      departmentid: '',
      pwd:''
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
          this.formLabelAlign.name = ''
          this.formLabelAlign.sex = ''
          this.formLabelAlign.phone = ''
          this.formLabelAlign.departmrntid = ''
          this.formLabelAlign.pwd = ''
          done();
        })
        .catch(_ => { });
    },
    
    handleClose2(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          this.formLabelAlign2.id = ''
          this.formLabelAlign2.name = ''
          this.formLabelAlign2.sex = ''
          this.formLabelAlign2.phone = ''
          this.formLabelAlign2.departmrntid = ''
          this.formLabelAlign2.pwd = ''
          done();
        })
        .catch(_ => { });
    },
    
    putVegatable(id,name, sex, phone, departmentid,pwd) {
      var one = {
        id:id,
        name: name,
        sex: sex,
        phone: phone,
        departmentid: departmentid,
        pwd:pwd
      }
      this.tableData.push(one);
    },
    
    insert() {
      window.location.href = '../register?t=2&id='+this.formLabelAlign.id+'&name=' + this.formLabelAlign.name + '&sex=' + this.formLabelAlign.sex + '&phone=' + this.formLabelAlign.phone + "&departmentid=" + this.formLabelAlign.departmentid + "&pwd=" + this.formLabelAlign.pwd;
    },
    delete1(name) {
      window.location.href = '../register?t=3&name=' + name;
    },
    handleClick(row) {
      this.formLabelAlign2 = {
       name: row.name,
        sex: row.sex,
        phone: row.phone,
        departmentid: row.departmentid,
        pwd:row.pwd
      }
      this.dialogVisible2 = true;
    },
    update(){
      window.location.href = '../register?t=4&id='+this.formLabelAlign.id+'&name=' + this.formLabelAlign.name + '&sex=' + this.formLabelAlign.sex + '&phone=' + this.formLabelAlign.phone + "&departmentid=" + this.formLabelAlign.departmentid + "&pwd=" + this.formLabelAlign.pwd;
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