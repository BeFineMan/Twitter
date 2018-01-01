<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<html>
<head>
<title>乌云后台登录</title>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="后台登录" />
	<link rel="stylesheet" href="/Twitter/css/userhome.css" type="text/css">
</head> 

<body>
	<div id="topnav">
		<jsp:include page="/public/topnav.jsp"/> 
	</div>
	登陆成功
	<a href="/Twitter/edit/test.log">测试</a><br>
	<a href="/Twitter/login/logout.log">注销</a>	<br>
	<!-- 上传组件 -->
	<form action="/Twitter/user/uploadIcon.log" method="post" enctype="multipart/form-data">
		<table width="75%" horder="1" align="center" bgcolor="#FDF5E6" bordercolor="#6B8E23">
			<tr>
				<td>
					<div align="center">
						<font style="font-size:15px;color:#FF8000">上传文件1:</font>
						<input type="file" name="file_icon_1" size="40">
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">
						<font style="font-size:15px;color:#FF8000">上传文件2:</font>
						<input type="file" name="file_icon_2" size="40">
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div align="center">
						<font style="font-size:15px;color:#FF8000">上传账户</font>
						<input type="text" name="username" size="40">
						<input type="submit" name="submit" value="上传">
					</div>
				</td>
			</tr>
		</table>
	</form>
	
	<!-- 圆框头像 -->
	<div style="width: 74px; height: 74px; float:left; border-radius: 50%; border: 3px solid #eee; overflow: hidden;">
	  <img width="80" height="80" src="/Twitter/userIcon/Scorpio.png"/>
	</div> 
</body>
</html>

