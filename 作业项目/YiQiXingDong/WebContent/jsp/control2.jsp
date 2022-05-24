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
			return ;
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
		<el-main class="main"> <el-menu default-active="2"
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
			<div style="margin: 10px 0;">
				<el-button type="primary" @click="dialogVisible = true">新增</el-button>
				<el-input clearable v-model="search" placeholder="请输入内容"
					style="width:20%;margin-left:10px;"> </el-input>
				<el-button type="primary" style="margin-left:10px;">查询</el-button>
			</div>
			<el-table stripe :data="tableData" border style="width: 100%">
			<el-table-column prop="id" label="蔬菜ID" width="180">
			</el-table-column> <el-table-column prop="type" label="蔬菜种类"> </el-table-column> <el-table-column
				prop="number" label="剩余量"> </el-table-column> <el-table-column
				prop="place" label="放置地点"> </el-table-column> <el-table-column
				fixed="right" label="操作" width="100"> <template
				slot-scope="scope"> <el-button
				@click="handleClick(scope.row)" type="text" size="small">编辑</el-button>
			<el-popconfirm title="你确定要删除吗?" @confirm="delete1(scope.row.id)">
            <template #reference>
              <el-button type="text" size="small">删除</el-button>
            </template>
          </el-popconfirm> </template> </el-table-column> </el-table>
		</div>
		</el-main>
		<el-dialog title="新增菜品" :visible.sync="dialogVisible" width="30%"
			:before-close="handleClose"> <el-form
			:label-position="labelPosition" label-width="80px"
			:model="formLabelAlign"> <el-form-item label="蔬菜ID">
		<el-input v-model="formLabelAlign.id"></el-input> </el-form-item> <el-form-item
			label="蔬菜种类"> <el-input v-model="formLabelAlign.type"></el-input>
		</el-form-item> <el-form-item label="剩余量"> <el-input
			v-model="formLabelAlign.number"></el-input> </el-form-item> <el-form-item
			label="放置地点"> <el-input v-model="formLabelAlign.place"></el-input>
		</el-form-item> </el-form> <span slot="footer" class="dialog-footer"> <el-button
				@click="dialogVisible = false;
						formLabelAlign.id = '';
						formLabelAlign.type = '';
						formLabelAlign.number = '';
						formLabelAlign.place = '';">取
			消</el-button> <el-button type="primary" @click="insert()">确 定</el-button>
		</span> </el-dialog>
		
		<el-dialog title="编辑菜品" :visible.sync="dialogVisible2" width="30%"
			:before-close="handleClose2"> <el-form
			:label-position="labelPosition2" label-width="80px"
			:model="formLabelAlign2"> </el-input> </el-form-item> <el-form-item
			label="蔬菜种类"> <el-input v-model="formLabelAlign2.type"></el-input>
		</el-form-item> <el-form-item label="剩余量"> <el-input
			v-model="formLabelAlign2.number"></el-input> </el-form-item> <el-form-item
			label="放置地点"> <el-input v-model="formLabelAlign2.place"></el-input>
		</el-form-item> </el-form> <span slot="footer" class="dialog-footer"> <el-button
				@click="dialogVisible2 = false;
						formLabelAlign2.id = '';
						formLabelAlign2.type = '';
						formLabelAlign2.number = '';
						formLabelAlign2.place = '';">取
			消</el-button> <el-button type="primary" @click="update()">确 定</el-button>
		</span> </el-dialog>
	</div>
	<script src="../js/vue.js"></script>
	<script src="../js/elementui.js"></script>
	<script src="../js/jquery-3.6.0.min.js"></script>
	<script src="../js/layer.js"></script>
	<script src="../js/control2_main.js"></script>
	<script>
		
	<%		if(session.getAttribute("addstatus") == null||(String)session.getAttribute("addstatus") == ""){
			}else{
				if((String)session.getAttribute("addstatus") == "ok"){
					%>
					app.$message({
				          message: '添加成功！',
				          type: 'success'
				        });
					<%
					//session.setAttribute("addstatus","");
				}else if((String)session.getAttribute("addstatus") == "no"){
					%>
					app.$message.error('操作失败');
					<%
					//session.setAttribute("addstatus","");
				}else if((String)session.getAttribute("addstatus") == "dl"){
					%>
					app.$message({
				          message: '删除成功！',
				          type: 'success'
				        });
					<%
				}else if((String)session.getAttribute("addstatus") == "up"){
					%>
					app.$message({
				          message: '编辑成功！',
				          type: 'success'
				        });
					<%
				}
			}
	if (request.getAttribute("vlist") == null) {
				request.getRequestDispatcher("../vegetable?t=1").forward(request, response);
			}
			List<Vegetables> list = (ArrayList) request.getAttribute("vlist");
			//判断空值
			if (list.size() == 0) {
			} else {
				for (Vegetables v : list) {%>
		app.putVegatable(<%=v.getVegetable_id()%>,'<%=v.getVegetable_kinds()%>',<%=v.getVegetable_number()%>,'<%=v.getVegetable_place()%>');
	<%}
				session.setAttribute("addstatus","");
			}%>
		
	</script>
</body>

</html>