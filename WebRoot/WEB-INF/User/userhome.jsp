<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content+-Type" content="text/html; charset=UTF-8">
	<title>乌云后台登录</title>
	<link href="/Twitter/css/userhome.css" rel="stylesheet" type="text/css" media="all">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="keywords" content="后台登录">
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
	<div id="userinfo">
		<div id="radiu_icon">
	  		<img  width="60" height="60" src="/Twitter/userIcon/Scorpio.png"/>
		</div>  
	</div>
	
</body>
</html>

