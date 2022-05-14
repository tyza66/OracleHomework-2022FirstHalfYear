<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<form action="/employeeSystem/login.do">
		<p>
			<input type="text" name="id" placeholder="请输入用户名">
		</p>
		<p>
			<input type="password" name="pwd" placeholder="请输入密码">
		</p>
		<p>
			<input type="submit" value="登录">
		</p>
	</form>
	<%
		String failtip = (String) request.getAttribute("failtip");
		if (failtip != null) {
	%>
		<h6 style="color:red;"><%=failtip %></h6>
	<%
		}
	%>

</body>
</html>