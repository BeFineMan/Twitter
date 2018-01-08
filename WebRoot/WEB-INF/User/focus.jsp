<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="c" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content+-Type" content="text/html; charset=UTF-8">
	<title>关注的人</title>
	<link href="/Twitter/css/focus.css" rel="stylesheet" type="text/css" media="all">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="keywords" content="后台登录">
	<script src="/Twitter/js/userhome.js" type="text/javascript"></script>
</head>  
<body style="background-color:#696969;"> 
	<!-- 顶部导航 -->
	<jsp:include page="/public/topnav.jsp"/> 
	<div id="all">
		<div id="all_top">
			<div id="all_top_icon">
				<img src="/Twitter/userIcon/Scorpio.png" width="100" height="100">
			</div>
			121
		</div>
	</div> 
</body>  
</html> 

