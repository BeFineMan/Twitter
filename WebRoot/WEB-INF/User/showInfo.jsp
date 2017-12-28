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
	<link href="/Twitter/css/style.css" rel="stylesheet" type="text/css" media="all">
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
				<span><img src="/Twitter/images/group.png" alt=""></span>
			</div>
			<h1>编辑信息</h1>
			<div class="login-top">
			<form action="/Twitter/edit/person.log">
				<div class="login-ic">
					<i></i>
					
					<input type="text" value="${user.baseInfo.nickName}" name="userName" onfocus="this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;User name&#39;;}">
					<div class="clear"> </div>
				</div>
				
				<div class="login-ic">
					<i class="icon"></i>
					<input type="text" value="${user.baseInfo.realName}" name="password" onfocus="this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;password&#39;;}">
					<div class="clear"> </div>
				</div>
				
				<div class="login-ic">
					<i></i>
					<input type="text" value="${user.baseInfo.sex}" name="sex" onfocus="this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;性 别&#39;;}">
					<div class="clear"> </div>
				</div>
				
				
				
				<div class="login-ic">
					<i></i>
					<input type="text" value="${user.baseInfo.birthday}" name="birthday" onfocus="this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;生 日&#39;;}">
					<div class="clear"> </div>
				</div>
				
				<div class="login-ic">
					<i></i>
					<input type="text" value="${user.baseInfo.simpleinfo}" name="shortInfo" onfocus="this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;简 介&#39;;}">
					<div class="clear"> </div>
				</div>
				
				
				<div class="log-bwn">
					<input type="submit" value="编辑">
				</div>
				
				</form>
			</div>
			${errorMsg}
			<p class="copy">个人信息${a}</p>
</div>		

</body></html>