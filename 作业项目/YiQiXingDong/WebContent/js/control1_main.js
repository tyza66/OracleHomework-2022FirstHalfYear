var app = new Vue({
  el: "#app",
  data: {
    search: '',
    tableData: [{
      id: '111111111111',
      phone: '15909808533',
      name: '孙达明',
      age: 21,
      sex: '男',
      way: '渤海大学滨海校区',
      hs: '阴性',
      member: '管理员'
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