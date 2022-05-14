<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工添加页面</title>
</head>
<body>
	<form action="/employeeSystem/employees/add.do"> 
		<p><input type="text" name="employeeid" placeholder="请输入员工编号"></p>
		<p><input type="text" name="firstname" placeholder="请输入员工名字"></p>
		<p><input type="text" name="lastname" placeholder="请输入员工姓氏"></p>
		<p><input type="text" name="email" placeholder="请输入员工邮箱"></p>
		<p><input type="text" name="phonenumber" placeholder="请输入员工联系方式"></p>
		<p><input type="text" name="jobid" placeholder="请输入员职位"></p>
		<p><input type="text" name="salary" placeholder="请输入员工工资"></p>
		<p><input type="text" name="commissionpct" placeholder="请输入员工绩效"></p>
		<p><input type="text" name="managerid" placeholder="请输入上级编号"></p>
		<p><input type="text" name="departmentid" placeholder="请输入部门编号"></p>
		<p><input type="submit" value="提交"></p>
	</form>
</body>
</html>