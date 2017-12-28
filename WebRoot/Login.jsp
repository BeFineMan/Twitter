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
	<script type="text/javascript">
		var user = "<%=session.getAttribute("USER_CONTEXT")%>";
		if(!(user == null || user == "null" || ""==user)){
			alert("登陆成功");
			window.location.href = "/Twitter/login/doLogin.log";
		}
		var errorMsg = "<%=session.getAttribute("errorMsg")%>";	
		<%session.removeAttribute("errorMsg");%>
		if(!(errorMsg==null || ""==errorMsg || errorMsg == "null")){
			alert(errorMsg);
		}
		
		function check(){
			var userName = document.getElementById("userName").toString().trim();
			var password = document.getElementById("password").toString().trim();
			if(userName ==""){
				alert("请输入正确的用户名");
			}
			if(password ==""){
				alert("请输入密码");
			}
			if(password =="")
		}
		
		function register(){
			var url = "/Twitter/register/res.log";
			var formObject = document.createElement('form');
			document.body.appendChild(formObject);
			formObject.action = url;
			formObject.setAttribute("method","post");
			
			formObject.submit();
		};
	</script>
</head>
<body style="background: url('images/bbb.jpg');">
<div class="login-form">
			<div class="top-login">
				<span><img src="images/group.png" alt=""></span>
			</div>
			<h1>登录</h1>
			<div class="login-top">

			<form id="login_form" action="/Twitter/login/doLogin.log" method="post">
				<div class="login-ic">
					<i></i>
					<input id="userName" type="text" value="用户" name="userName" onfocus="this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;User name&#39;;}">
					<div class="clear"> </div>
				</div>
				
				<div class="login-ic">
					<i class="icon"></i>
					<input id="password" type="password" value="密码" name="password" onfocus="this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;password&#39;;}">
					<div class="clear"> </div>
				</div>
				
				<div class="log-bwn">
					<input type="submit" value="登录">
				</div>
					
				<div class="log-bwn">
					<input type="button" value="注册" onclick="register()">
				</div>
				
				
				</form>
			</div>
			<p class="copy">WeiBo</p>
</div>		

</body></html>