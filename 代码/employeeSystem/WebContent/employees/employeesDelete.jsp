<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除员工信息</title>
</head>
<body>
	<form action="/employeeSystem/employees/delete.do">
		<p>
			<input type="text" name="employeeid" placeholder="请输入要删除的员工编号">
		</p>
		<p>
			<input type="submit" value="提交">
		</p>
	</form>
	<%
		String deletetip = (String) request.getAttribute("deletetip");
		if (deletetip != null) {
	%>
	<h6><%=deletetip%></h6>
	<%
		}
	%>
</body>
</html>