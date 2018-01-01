<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'topnav.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="/Twitter/css/topnav.css" type="text/css">
  </head>
  
  
  <body>
  <div style="margin-top:50px">
    <ul>
	  <li><a class="active" href="/Twitter/user/home.log">主页</a></li>
	  <li><a href="/Twitter/edit/person.log">查看个人信息</a></li>
	  <li><a href="#contact">联系</a></li>
	  <li><a href="#about">关于</a></li>
	  <li style="float:right"><a class="user_active" href="/Twitter/login/logout.log">注销</a></li>
	  <li style="float:right">
	  	<a class="user_active" href="">${USER_CONTEXT.userName}</a>
	  </li>
	</ul>
  </div>
  </body>
</html>
