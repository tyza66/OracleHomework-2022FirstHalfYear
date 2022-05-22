var app = new Vue({
  el: "#app",
  data: {
    labelPosition: 'right',
    userLogin: {
      user: '1',
      id: '',
      password: ''
    }
  },
  created: function () {

  },
  methods: {
    register(){
      window.location.href =  './register.jsp'
    },
    login(){
    	window.location.href =  './login?way=' + this.userLogin.user + "&username=" + this.userLogin.id + "&password=" + this.userLogin.password;
    }
  }
});