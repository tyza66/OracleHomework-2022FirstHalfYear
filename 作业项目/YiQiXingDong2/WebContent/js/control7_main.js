var app = new Vue({
  el: "#app",
  data: {
    search: '',
    tableData: [],
    tempDate:[]
  },
  created: function () {
	this.tempDate = this.tableData;
  },
  methods: {
    gopage(n){
      window.location.href = './control'+n+'.jsp'
    },
    putMessage(id,phone,time,passage){
      var one = {
        id: id,
      	phone: phone,
     	time: time,
     	passage: passage
      }
      this.tableData.push(one);
    },
    search1(){
      var temp = [];
      this.tableData = this.tempDate;
      for(var i = 0;i<this.tableData.length;i++){
        if(this.tableData[i].passage.search(this.search)!=-1){
          temp.push(this.tableData[i]);
        }
      }
      this.tempDate = this.tableData;
      this.tableData = temp;
      this.search = "";
    },
    reload(){
      this.tableData = this.tempDate;
    },
    delete1(id) {
      window.location.href = '../MessageController?t=3&id=' + id;
    }
  }
});