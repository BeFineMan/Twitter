<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>乌云后台登录</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="keywords" content="后台登录">
	<style>
		#test{
			width:50px;
			height:50px;
			background-color:green;
		}
		#test h1{
			margin:0px;
			border:0px;
			font-size:25px;
			width:50px;
			height:50px;
			z-index:0;
			background-color:blue;
		}
		#test input{
			width:50px;
			height:50px;
			opacity: 10;
			cursor: pointer;
			z-index:1;
			position:relative;
			background-color:yellow;
			cursor: pointer;
			}
	</style>
	<script type="text/javascript">
	</script>
</head>
<body>
	<div id="test"> 
		<input type="file" class="hidden" value="">
		<h1>点</h1>
	</div>

	<jsp:forward page="">
	<% request.setAttribute("name","value"); %>
</body>
</html>







