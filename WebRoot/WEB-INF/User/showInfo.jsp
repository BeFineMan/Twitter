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
			
			<form id="submit_userInfo" action="/Twitter/edit/person.log">
				<div class="login-ic">
					<i></i>
					<input type="text"  value="${user.baseInfo.nickName}" id="userName" name="userName" disabled  onfocus="changeFlag();this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;User name&#39;;}">
					<div class="clear"> </div>
				</div>
				
				<div class="login-ic">
					<i class="icon"></i>
					<input type="text" value="${user.baseInfo.realName}" id="password" name="password" disabled onfocus="changeFlag();this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;password&#39;;}">
					<div class="clear"> </div>
				</div>
				
				<div class="login-ic">
					<i></i>
					<input type="text" value="${user.baseInfo.sex}" name="sex" id="sex" disabled onfocus="changeFlag();this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;性 别&#39;;}">
					<div class="clear"> </div>
				</div>
				
				<div class="login-ic">
					<i></i>
					<input type="text" value="${user.baseInfo.birthday}" id="birthday" name="birthday" disabled onfocus="changeFlag();this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;生 日&#39;;}">
					<div class="clear"> </div>
				</div>
				
				<div class="login-ic">
					<i></i>
					<input type="text" value="${user.baseInfo.simpleinfo}" id="shortInfo" name="shortInfo" disabled onfocus="changeFlag();this.value = &#39;&#39;;" onblur="if (this.value == &#39;&#39;) {this.value = &#39;简 介&#39;;}">
					<div class="clear"> </div>
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
		var flag = null;
		var map = null;
		
		
		//建立标记,建立map集合对象
		function createFlag(){
			flag = new Array(inputs.length - 1);
			for(var i = 0; i < flag.length; i++){
				map = new Object();
				map.name = i;
				map.value = inputs[i].name;
				map.fg = 1;
				flag[i] = map;
				console.log(flag[i].fg);
			}
		}
		
		//更改标记，修改标记为0
		function changeFlag(){
			if(flag != null){
				var event =  window.event.srcElement;		//获取触发该事件的元素
				for(var i = 0; i < flag.length; i++){
					if(flag[i].value == event.name){
						flag[i].fg = 0;
						break;
					}
				}
			}
			
		}
	
		//筛选出input里属性名为disbled的属性，将它删除。即可恢复成可编辑状态
		function clickbj(){
			//如果按钮为编辑时，进行编辑操作。
			if(button.value == "编辑"){
				createFlag();		//建立标记
							
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
				
			//如果按钮为保存时，提交表单	
			}else if(button.value == "保存"){	
				//先获取和设置参数
				var array_param = new Array();
				var param = null;	//参数对象
				for(var i = 0 ; i < flag.length; i++){
					if(flag[i].fg==0){
						param = new Object();
						param.name = flag[i].value;		//参数名
						param.value = document.getElementById(flag[i].value).value;		//参数值
						array_param.push(param);
					}
				}
				//创建表单
				var formObject = document.createElement('form');
				formObject.setAttribute("method","post");
				formObject.action = "/Twitter/edit/updateUserInfo.log";
				
				//将参数放进input元素中，并放进表单里
				var input_param = null;
				for(var i = 0; i < array_param.length; i++){
					input_param = document.createElement("input");
					input_param.setAttribute("type", "text");
					input_param.setAttribute("name",array_param[i].name);
					input_param.setAttribute("value",array_param[i].value);
					formObject.appendChild(input_param);
				}
				console.log(formObject.elements.length);
				//跳转
				formObject.submit();
			}
		};
		
	</script>

</html>