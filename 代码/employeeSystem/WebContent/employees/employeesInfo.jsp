<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.sdm.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息展示</title>
</head>
<body>
	<%--获取请求传过来的数据--%>
	<%
		//小脚本（java代码）
		List<Employees> list = (ArrayList) request.getAttribute("elist");
		//判断空值
		if (list.size() == 0) {
	%>
	<h1>获取员工信息失败</h1>
	<%
		} else {
	%>
	<table border="1" cellspacing="0" cellpadding="10">
		<tr>
			<th>员工编号</th>
			<th>员工姓名</th>
			<th>员工邮箱</th>
			<th>联系方式</th>
			<th>入职日期</th>
			<th>职位编号</th>
			<th>员工工资</th>
			<th>员工绩效</th>
			<th>上级编号</th>
			<th>部门编号</th>
		</tr>
		<%
			for (Employees e : list) {
		%>
		<tr>
			<td><%=e.getEmployeeId()%></td>
			<td><%=e.getFirstName()%>·<%=e.getLastName()%></td>
			<td><%=e.getEmail()%></td>
			<td><%=e.getPhoneNumber()%></td>
			<td><%=e.getHireDate()%></td>
			<td><%=e.getJobId()%></td>
			<td><%=e.getSalary()%></td>
			<td><%=e.getCommissionPct()%></td>
			<td><%=e.getManagerId()%></td>
			<td><%=e.getDepartmentId()%></td>
		</tr>
		<%
			}
		%>
	</table>
	>
	<%
		}
	%>
	<%--需要对获取过来的集合进行一个空值判断--%>
</body>
</html>