<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<form action="register/res.log" method="post">
  		<fieldset>
  			<legend>用户名</legend>
  			<lable for="">
  				<input type="text" name="userName">
  			</lable>
  		</fieldset>
  		<fieldset>
  			<legend>密码</legend>
  			<label>
  				<input type="password" name="password">
  			</label>
  		</fieldset>
  		<input type="submit" value="注册">
  		
  	</form>
  	${errorMsg}
  	${error}
  </body>
</html>
