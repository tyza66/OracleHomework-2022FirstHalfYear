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
      name: '',
      sex: '',
      age: '',   
      phone: '',     
      symptom: '',
      checkdate: '',
      indate:'',
      way: '',
      pwd: '',
      department: '',
      roomid: '',
      hs: ''
  },
	  dialogVisible2: false,
	  labelPosition2: 'right',
	  formLabelAlign2: {
		  id: '',
	      name: '',
	      sex: '',
	      age: '',   
	      phone: '',     
	      symptom: '',
	      checkdate: '',
	      indate:'',
	      way: '',
	      pwd: '',
	      department: '',
	      roomid: '',
	      hs: ''   
	  }
  },
  created: function () {
	  this.tempDate = this.tableData;
  },
  methods: {
    gopage(n){
      window.location.href = './control'+n+'.jsp'
    },
    handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
        	  this.formLabelAlign.id= ''
        	  this.formLabelAlign.name= ''
        	  this.formLabelAlign.sex= ''
        	  this.formLabelAlign.age= ''  
        	  this.formLabelAlign.phone=''
        	  this.formLabelAlign.symptom= ''
        	  this.formLabelAlign.checkdate= ''
        	  this.formLabelAlign.indate= ''
        	  this.formLabelAlign.way= ''
        	  this.formLabelAlign.pwd= '' 
        	  this.formLabelAlign.department= ''
        	  this.formLabelAlign.roomid= ''
        	  this.formLabelAlign.hs=''	             	
            done();
          })
          .catch(_ => { });
  },
  handleClose2(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
        	  this.formLabelAlign2.id= ''
           	  this.formLabelAlign2.name= ''
           	  this.formLabelAlign2.sex= ''
           	  this.formLabelAlign2.age= ''  
           	  this.formLabelAlign2.phone=''
           	  this.formLabelAlign2.symptom= ''
           	  this.formLabelAlign2.checkdate= ''
           	  this.formLabelAlign2.indate= ''
           	  this.formLabelAlign2.way= ''
           	  this.formLabelAlign2.pwd= '' 
           	  this.formLabelAlign2.department= ''
           	  this.formLabelAlign2.roomid= ''
           	  this.formLabelAlign2.hs=''	          

      	  
          done();
        })
        .catch(_ => { });
  },
  //什么作用
  putQuarantineQuarantine(id, name,sex, age,phone,symptom,checkdate,indate, way,pwd,department,roomid,hs) {
      var one = {
    		  id:id ,
    	      name:name ,
    	      sex: sex,
    	      age: age,   
    	      phone: phone,     
    	      symptom: symptom,
    	      checkdate: checkdate,
    	      indate:indate,
    	      way: way,
    	      pwd: pwd,
    	      department: department,
    	      roomid: roomid,
    	      hs: hs
    	      
      }
      this.tableData.push(one);
    },
    
    insert() {
    	window.location.href = '../quarantinequarantine?t=2&id=' + this.formLabelAlign.id + 
    	'&name=' + this.formLabelAlign.name +
    	"&sex=" + this.formLabelAlign.sex +
    	'&age=' + this.formLabelAlign.age +
    	'&number=' + this.formLabelAlign.phone +
    	"&symptom=" + this.formLabelAlign.symptom +
    	"&checkdate=" + this.formLabelAlign.checkdate +
    	"&indate=" + this.formLabelAlign.indate +
		"&way=" + this.formLabelAlign.way +
		"&pwd=" + this.formLabelAlign.pwd+
		"&did=" + this.formLabelAlign.department +
		"&rid=" + this.formLabelAlign.roomid +
		"&hs=" + this.formLabelAlign.hs ;
    	},
    delete1(id) {
      window.location.href = '../quarantinequarantine?t=3&id=' + id;
    },
    handleClick(row) {
      this.formLabelAlign2 = {
    		  id:row.id ,
    	      name:row.name ,
    	      sex: row.sex,
    	      age: row.age,   
    	      phone:row.phone,     
    	      symptom: row.symptom,
    	      checkdate: row.checkdate,
    	      indate:row.indate,
    	      way: row.way,
    	      pwd: row.pwd,
    	      department: row.department,
    	      roomid: row.roomid,
    	      hs: row.hs
    	      
      }
      this.dialogVisible2 = true;
    },
    update(){
    	var a = (this.formLabelAlign2.sex=='男')?1:0;
    	var b = (this.formLabelAlign2.hs=='阳性')?1:0;
    	window.location.href = '../quarantinequarantine?t=4&id=' + this.formLabelAlign2.id + 
    	'&name=' + this.formLabelAlign2.name +
    	"&sex=" + a + 
    	'&age=' + this.formLabelAlign2.age +
    	'&number=' + this.formLabelAlign2.phone +
    	"&symptom=" + this.formLabelAlign2.symptom +
    	"&checkdate=" + this.formLabelAlign2.checkdate +
    	"&indate=" + this.formLabelAlign2.indate +
		"&way=" + this.formLabelAlign2.way +
		"&pwd=" + this.formLabelAlign2.pwd+
		"&did=" + this.formLabelAlign2.department +
		"&rid=" + this.formLabelAlign2.roomid +
		"&hs=" + b;    	
    },
    search1(){
      var temp = [];
      this.tableData = this.tempDate;
      for(var i = 0;i<this.tableData.length;i++){
        if(this.tableData[i].name.search(this.search)!=-1||this.tableData[i].id.search(this.search)!=-1){
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