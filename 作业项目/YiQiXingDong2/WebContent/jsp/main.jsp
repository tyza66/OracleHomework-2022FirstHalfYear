<%@page import="oracle.net.aso.l"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.yqxd.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>隔离人员登录界面</title>
<link rel="stylesheet" href="css/layui.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo layui-hide-xs layui-bg-black">隔离人员信息栏</div>
    <!-- 头部区域（可配合layui 已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <!-- 移动端显示 -->
      
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item layui-hide layui-show-md-inline-block">
        <a href="javascript:;">
          <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
          <!-- 对登陆者做信息展示 -->
		<%
          	String username = (String) session.getAttribute("username");
          	if(username != null){
		%>
			<span><%=username %></span>
		<%
			} else {
		%>
			<span>未登录</span>
		<%
          }
		%>
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">Your Profile</a></dd>
          <dd><a href="">Settings</a></dd>
          <dd><a href="">Sign out</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
        <a href="javascript:;">
          <i class="layui-icon layui-icon-more-vertical"></i>
        </a>
      </li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">信息页面</a>
          <dl class="layui-nav-child">
            <dd><a href="/informationManagement/select" target="myif">查询页面展示</a></dd>
            <dd><a href="javascript:;"></a></dd>
            <dd><a href="javascript:;">menu 3</a></dd>
            <dd><a href="">the links</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">menu group 2</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">list 1</a></dd>
            <dd><a href="javascript:;">list 2</a></dd>
            <dd><a href="">超链接</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="javascript:;">click menu item</a></li>
        <li class="layui-nav-item"><a href="">the links</a></li>
      </ul>
    </div>
  </div>
  
	<div class="layui-body">
    <!-- 内容主体区域 -->
    <!-- <div style="padding: 15px;">内容主体区域。记得修改 layui.css 和 js 的路径</div> -->
		<iframe name="myif" src="" frameborder="0" width="100%" height="100%" scrolling="no"></iframe>
	
	</div>
</div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    
    
  </div>
  
<script src="js/layui.js"></script>
<script>
//JS 
layui.use(['element', 'layer', 'util'], function(){
  var element = layui.element
  ,layer = layui.layer
  ,util = layui.util
  ,$ = layui.$;
  
  //头部事件
  util.event('lay-header-event', {
    //左侧菜单事件
    menuLeft: function(othis){
      layer.msg('展开左侧菜单的操作', {icon: 0});
    }
    ,menuRight: function(){
      layer.open({
        type: 1
        ,content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
        ,area: ['260px', '100%']
        ,offset: 'rt' //右上角
        ,anim: 5
        ,shadeClose: true
      });
    }
  });
  
});
</script>
</body>
</html>