var app = new Vue({
  el: "#app",
  data: {
    labelPosition: 'right',
    userLogin: {
      user: '1',
      id: '',
      password: '',
      yanzheng:''
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