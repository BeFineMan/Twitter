<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="keywords" content="后台登录">
	<style>
		@font-face{
			font-family:uc-nexus-iconfont;
			src:url(chrome-extension://pogijhnlcfmcppgimcaccdkmbedjkmhi/res/font_9qmmi8b8jsxxbt9.woff) format('woff'),url(chrome-extension://pogijhnlcfmcppgimcaccdkmbedjkmhi/res/font_9qmmi8b8jsxxbt9.ttf) format('truetype')
			}
	</style>
</head>
<body>

<div class="login-form">
			<div class="top-login">

			</div>

			<h1>个人信息</h1>
			<div class="login-top">
			<form action="/Twitter/login/doLogin.log" method="post">
				<div class="login-ic">
					<i></i>
					昵称：${user.baseInfo.nickName}
					<div class="clear"> </div>
				</div>
				
				<div class="login-ic">
					<i class="icon"></i>
					真实姓名：${user.baseInfo.realName}
					<div class="clear"> </div>
				</div>
				
				<div class="login-ic">
					<i></i>
					性别:${user.baseInfo.sex}
					<div class="clear"> </div>
				</div>
				
				
				
				<div class="login-ic">
					<i></i>
					生日:${user.baseInfo.birthday}
					<div class="clear"> </div>
				</div>
				
				<div class="login-ic">
					<i></i>
					简介：${user.baseInfo.simpleinfo}
					<div class="clear"> </div>
				</div>
				
				
				<div class="log-bwn">

					<input type="button" value="编辑">
				</div>
			</div>

			<p class="copy">个人信息</p>
</div>		


</body></html>