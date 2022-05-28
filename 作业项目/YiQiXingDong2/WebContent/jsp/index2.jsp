<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.yqxd.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>登录页</title>
<link rel="stylesheet" href="../css/index.css">
</head>
<body>
<form action="/informationManagement/log">
	<div class="container">
        <div class="tit">登录</div>
        <input type="text" placeholder="账号" name="username">
        <input type="password" placeholder="密码" name="password">
        <!-- 
        <button>登录</button>
         -->
         <input type="submit" value="登录" class="button"> 
        <span>没有账号？<a href="#">去注册</a></span>
    </div>
    <div class="square">
        <ul>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
    <div class="circle">
        <ul>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
    <%--登录失败信息显示 --%>
<%
 	String failtip=(String)request.getAttribute("failtip");
 	if(failtip != null){
%>
	<h6 style="color:red"><%=failtip %></h6>
<%
 	}
 %>
</form>
</body>
</html>