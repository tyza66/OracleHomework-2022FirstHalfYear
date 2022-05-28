<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/elementui.css">
<link rel="stylesheet" href="css/layer.css">
<link rel="stylesheet" href="css/index_main.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6/css/all.min.css">
<title>登录</title>
</head>
<body>
	<div id="app">
		<div
			style="height: 50px; width: 100%; line-height: 50px; border-bottom: 1px solid #ccc; display: flex; overflow: hidden; position: fixed; z-index: 100; background-color: white;">
			<div
				style="width: 200px; margin-left: 30px; font-weight: bold; color: #559EFF;">疫起行动</div>
			<div style="flex: 1;"></div>
			<div style="width: 100px; margin-right: 25px;">
				<p>未登录</p>
			</div>
		</div>
		<el-main class="main" id="bj">
		<div class="login">
			<center>
				<h2>登录</h2>
				<center>
					<%
						String failtip = (String) request.getAttribute("failtip");
						if (failtip != null) {
					%>
					<h6 style="color: red;"><%=failtip%></h6>
					<%
						}
					%>
				</center>
			</center>
			<div class="user">
				<el-form :label-position="labelPosition" label-width="80px"
					:model="userLogin">
				<center style="margin: 10px auto;">
					<el-radio v-model="userLogin.user" label="1" style="display:none;">用户登录</el-radio>
					<el-radio v-model="userLogin.user" label="2" style="display:none;">管理员登录</el-radio>
				</center>
				<el-form-item label="账号"> <el-input class="input"
					v-model="userLogin.id"></el-input> </el-form-item> <el-form-item label="密码">
				<el-input type="password" clearable class="input"
					v-model="userLogin.password"></el-input> </el-form-item> </el-form>
				<center>
					<el-button type="primary" @click="login()">登录</el-button>
					<el-button type="primary" @click="register()">注册</el-button>
				</center>
				<center><el-button type="text" @click="userlogin()">用户登录</el-button></center>
			</div>
		</div>
		</el-main>
	</div>
	<script src="./js/vue.js"></script>
	<script src="./js/elementui.js"></script>
	<script src="./js/jquery-3.6.0.min.js"></script>
	<script src="./js/layer.js"></script>
	<script src="./js/index_main.js"></script>
	<script
		src="https://cdn.jsdelivr.net/gh/stevenjoezhang/live2d-widget@latest/autoload.js"></script>
	<script>
		var a = 1500;
		function change(){
			document.getElementById('bj').style.setProperty('filter' ,"blur(" + (a - 100)/1000 + "px)");
			a = a - 100;
			if(a<=0) window.clearInterval(timer);
		}
		var timer = setInterval(change,100);
		
	</script>
</body>
</html>