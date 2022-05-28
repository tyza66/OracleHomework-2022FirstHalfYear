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
      password:'',
      yanzheng:''
    }
  },
  created: function () {

  },
  methods: {
	  backlogin(){
		  window.location.href =  './index.jsp'
	  },
	  register(){
		  window.location.href =  './register?way='+this.userLogin.user+'&name='+this.userLogin.name+'&sex='+this.userLogin.sex+'&phone='+this.userLogin.phone+"&ks="+this.userLogin.ks+"&password="+this.userLogin.password+"&vcode="+this.userLogin.yanzheng;
	  }
  }
});