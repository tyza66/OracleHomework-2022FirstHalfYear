<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.yqxd.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/elementui.css">
<link rel="stylesheet" href="../css/layer.css">
<link rel="stylesheet" href="../css/control1_main.css">
<title>管理界面</title>
</head>

<body>
	<%
		if (session.getAttribute("loginName") == null || (String) session.getAttribute("loginName") == "") {
			response.sendRedirect("../index.jsp");
			return;
		}
	%>
	<div id="app">
		<div
			style="height: 50px; width: 100%; line-height: 50px; border-bottom: 1px solid #ccc; display: flex; overflow: hidden; position: fixed; z-index: 100; background-color: white;">
			<div
				style="width: 200px; margin-left: 30px; font-weight: bold; color: #559EFF;">疫起行动</div>
			<div style="flex: 1;"></div>
			<div style="width: 100px; margin-right: 25px;">
				<p>${sessionScope.loginName}</p>
			</div>
		</div>
		<el-main class="main"> <el-menu default-active="6"
			class="el-menu-vertical-demo lefttab"> <el-menu-item
			index="1" @click="gopage(1)"> <i
			class="el-icon-setting"></i> <span slot="title">人员管理</span> </el-menu-item> <el-menu-item
			index="2" @click="gopage(2)"> <i
			class="el-icon-setting"></i> <span slot="title">抢菜管理</span> </el-menu-item> <el-menu-item
			index="3" @click="gopage(3)"> <i
			class="el-icon-setting"></i> <span slot="title">活动管理</span> </el-menu-item> <el-menu-item
			index="4" @click="gopage(4)"> <i
			class="el-icon-setting"></i> <span slot="title">页游管理</span> </el-menu-item> <el-menu-item
			index="5" @click="gopage(5)"> <i
			class="el-icon-setting"></i> <span slot="title">隔离管理</span> </el-menu-item> <el-menu-item
			index="6" @click="gopage(6)"> <i
			class="el-icon-setting"></i> <span slot="title">交友匹配管理</span> </el-menu-item> <el-menu-item
			index="7" @click="gopage(7)"> <i
			class="el-icon-setting"></i> <span slot="title">讨论区管理</span> </el-menu-item> <el-menu-item
			index="8" @click="gopage(8)"> <i
			class="el-icon-setting"></i> <span slot="title">医疗咨询管理</span> </el-menu-item> <el-menu-item
			index="9" @click="gopage(9)"> <i
			class="el-icon-setting"></i> <span slot="title">外卖平台接入管理</span> </el-menu-item> </el-menu>

		<div class="righttab">
			<h2 style="margin-bottom:10px;">交友匹配规则管理</h2>
				男女混合匹配：<el-switch v-model="value1" active-color="#13ce66"
				inactive-color="#ff4949" style="margin:10px;"> </el-switch><br/>
				异性匹配：<el-switch v-model="value2" active-color="#13ce66"
				inactive-color="#ff4949" style="margin:10px;"> </el-switch><br/>
				爱好相似度匹配：<el-switch v-model="value3" active-color="#13ce66"
				inactive-color="#ff4949" style="margin:10px;"> </el-switch><br/>
				年龄相差10以上可匹配：<el-switch v-model="value4" active-color="#13ce66"
				inactive-color="#ff4949" style="margin:10px;"> </el-switch><br/>
				年龄相差20以上可匹配：<el-switch v-model="value5" active-color="#13ce66"
				inactive-color="#ff4949" style="margin:10px;"> </el-switch><br/>
				年龄相差30以上可匹配：<el-switch v-model="value6" active-color="#13ce66"
				inactive-color="#ff4949" style="margin:10px;"> </el-switch><br/>
				消除年龄限制：<el-switch v-model="value7" active-color="#13ce66"
				inactive-color="#ff4949" style="margin:10px;"> </el-switch><br/>
				关键字匹配：<el-switch v-model="value8" active-color="#13ce66"
				inactive-color="#ff4949" style="margin:10px;"> </el-switch><br/>
				允许用户在大厅自由挑选：<el-switch v-model="value9" active-color="#13ce66"
				inactive-color="#ff4949" style="margin:10px;"> </el-switch><br/>
				允许用户访问其他人信息：<el-switch v-model="value10" active-color="#13ce66"
				inactive-color="#ff4949" style="margin:10px;"> </el-switch><br/>
		</div>
		</el-main>
	</div>
	<script src="../js/vue.js"></script>
	<script src="../js/elementui.js"></script>
	<script src="../js/jquery-3.6.0.min.js"></script>
	<script src="../js/layer.js"></script>
	<script src="../js/control6_main.js"></script>
	<script>
		
	<%if (session.getAttribute("addstatus") == null || (String) session.getAttribute("addstatus") == "") {
			} else {
				if ((String) session.getAttribute("addstatus") == "ok") {%>
		app.$message({
			message : '添加成功！',
			type : 'success'
		});
	<%//session.setAttribute("addstatus","");
				} else if ((String) session.getAttribute("addstatus") == "no") {%>
		app.$message.error('操作失败');
	<%//session.setAttribute("addstatus","");
				} else if ((String) session.getAttribute("addstatus") == "dl") {%>
		app.$message({
			message : '删除成功！',
			type : 'success'
		});
	<%} else if ((String) session.getAttribute("addstatus") == "up") {%>
		app.$message({
			message : '编辑成功！',
			type : 'success'
		});
	<%}
			}%>
		
	</script>
</body>

</html>