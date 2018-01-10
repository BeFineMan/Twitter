<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'topnav.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<!-- 样式 -->	
<style>
body{
	margin:0px;
	padding:0px;
}

#left_nav ul{
	list-style-type: none;	/*去除li的原始样式*/
	margin: 0px;
	padding:0px;
	width:130px;
	padding-left:15px;
	position: fixed;	/*不占据空间的定位*/
	background-color:white;
	color: #FFFAF0;
/* 	background-image:url('/Twitter/userhome_image/userhomebackground.jpg');
 */}
#left_nav ul li a{
	height:34px;
	display:block;
	padding-top:7px;
	font-size:15px;
	font-weight:bold;
	text-decoration: none;
}
	
</style>

  </head>
  <body>
  <div id="left_nav">
  	<ul>
  		<li>
  			<a href="/Twitter/user/home.log">首页</a>
  		</li>
  		<li>
  			<a href="/Twitter/user/home.log">我的收藏</a>
  		</li>
  		<li>
  			<a href="">推荐关注的人</a>
  		</li>
  	</ul>
  </div>
  </body>
</html>
