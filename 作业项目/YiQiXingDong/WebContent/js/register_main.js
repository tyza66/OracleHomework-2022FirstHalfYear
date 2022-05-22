var app = new Vue({
  el: "#app",
  data: {
    labelPosition: 'right',
    userLogin: {
      user: '1',
      name: '',
      sex: '',
      phone:'',
      ks:'',
      password:''
    }
  },
  created: function () {

  },
  methods: {
	  backlogin(){
		  window.location.href =  './index.jsp'
	  }
  }
});