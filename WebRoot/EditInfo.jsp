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
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all">
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
				<span><img src="images/group.png" alt=""></span>
			</div>
			<h1>登录</h1>
			<div class="login-top">
			<form action="/Twitter/login/doLogin.log">
				<div class="login-ic">
					<i></i>
					<input type="text" value="昵称" name="userName" onfocus="this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;User name&#39;;}">
					<div class="clear"> </div>
				</div>
				
				<div class="login-ic">
					<i class="icon"></i>
					<input type="password" value="真实姓名" name="password" onfocus="this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;password&#39;;}">
					<div class="clear"> </div>
				</div>
				
				<div class="login-ic">
					<i></i>
					<input type="text" value="性别" name="userName" onfocus="this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;User name&#39;;}">
					<div class="clear"> </div>
				</div>
				
				
				
				<div class="login-ic">
					<i></i>
					<input type="text" value="生日" name="userName" onfocus="this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;User name&#39;;}">
					<div class="clear"> </div>
				</div>
				
				<div class="login-ic">
					<i></i>
					<input type="text" value="简介" name="userName" onfocus="this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;User name&#39;;}">
					<div class="clear"> </div>
				</div>
				
				
				<div class="log-bwn">
					<input type="submit" value="登录">
				</div>
				
				</form>
			</div>
			${errorMsg}
			<p class="copy">weibo</p>
</div>		

</body></html>