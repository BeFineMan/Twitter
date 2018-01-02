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
		.divTab{
		float: right;
		}
		
	</style> 
</head>

<body>
	<div id="topnav">
		<jsp:include page="/public/topnav.jsp"/> 
	</div>

<div class="login-form">
			<div class="top-login">
				<span><img src="/Twitter/images/group.png" alt=""></span>
			</div>
			<h1>编辑信息</h1>
			<div class="login-top">
			
			<form id="submit_userInfo" action="/Twitter/edit/person.log" method="post">
				<div class="login-ic">
					<i></i>
					<input type="text"  value="${sessionScope.USER_CONTEXT.baseInfo.nickName}" id="nickName" name="nickName" disabled  onfocus="changeFlag();this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;昵称&#39;;}">
					<div class="clear"> </div>
				<div class=".divTab">昵称</div>
				</div>
				
				<div class="login-ic">
					<i class="icon"></i>
					<input type="text" value="${sessionScope.USER_CONTEXT.baseInfo.realName}" id="realName" name="realName" disabled onfocus="changeFlag();this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;真实姓名&#39;;}">
					<div class="clear"> </div>
					<div class=".divTab">真实姓名</div>
				</div>
				
		 		<div class="login-ic">
					<i></i>
					<input type="text" value="${sessionScope.USER_CONTEXT.baseInfo.sex}" id="simpleinfo" name="simpleinfo" disabled onfocus="changeFlag();this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;简 介&#39;;}">
					<div class="clear"> </div> 
					<div class=".divTab">性别</div>
				</div> 
				
				<div class="login-ic">
					<i></i>
					<input type="text" value="${sessionScope.USER_CONTEXT.baseInfo.birthday}" id="birthday" name="birthday" disabled onfocus="changeFlag();this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;生 日&#39;;}">
					<div class="clear"> </div>
					<div class=".divTab">生日</div>
				</div>
				
				<div class="login-ic">
					<i></i>
					<input type="text" value="${sessionScope.USER_CONTEXT.baseInfo.simpleinfo}" id="simpleinfo" name="simpleinfo" disabled onfocus="changeFlag();this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;简 介&#39;;}">
					<div class="clear"> </div>
					<div class=".divTab">简介</div>
				</div>
				
				<div class="log-bwn">
					<input id="button_bianji" type="button" value="编辑" onclick = "clickbj()">
				</div>
				
				</form>
			</div>
			<p class="copy">个人信息</p>
</div>		

</body>
	<script type="text/javascript">
		var inputs = document.getElementsByTagName("input");	//获得所有的input标签
		var button = document.getElementById("button_bianji");
		var sexError = "<%=session.getAttribute("sexError")%>";
		<%session.removeAttribute("sexError");%>
		if(!(sexError == null || sexError == "null")){
			clickbj();
			alert(sexError);
		}
	
		//筛选出input里属性名为disbled的属性，将它删除。即可恢复成可编辑状态
		function clickbj(){
			//如果按钮为编辑时，进行编辑操作。
			if(button.value == "编辑"){
				for(var i = 0;i<inputs.length; i++){
					var attr = inputs[i].attributes;	
					for(var j=0; j<attr.length; j++){
						if(attr[j].name=="disabled"){
							attr.removeNamedItem("disabled")
						}	
						if(attr[j].name=="value"&&attr[j].value=="编辑"){
							attr[j].value="保存";
						}
					}
				}
			}else if(button.value == "保存"){		//如果按钮为保存时，提交表单
				//提交表单
				var formObject = document.getElementById("submit_userInfo");
				formObject.action = "/Twitter/edit/updateUserInfo.log";
				formObject.submit();
			}
		};
		
	</script>

</html>