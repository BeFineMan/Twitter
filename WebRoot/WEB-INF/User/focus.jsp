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
	<title>乌云后台登录</title>
	<link href="/Twitter/css/userhome.css" rel="stylesheet" type="text/css" media="all">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="keywords" content="后台登录">
	<script src="/Twitter/js/userhome.js" type="text/javascript"></script>
</head>  
<body style="background-color:#696969;"> 
	<% request.setAttribute("name","value");%>
	<!-- 顶部导航 -->
	<jsp:include page="/public/topnav.jsp"/> 
	<!-- 左部导航 -->
	<div style="margin-left:175px;">
		<jsp:include page="/public/leftnav.jsp"/> 
	</div>
		
<div id="all">	 
	<div id="center_content">
		<table>
			<tr>
				<td>
					<!-- 发表动态 -->	
					<form id="publish_dynamic_form" action="/Twitter/user/publishDynamic.log" method="post">	
						<div id="publish_dynamic_background" class="all_table_border">
							<!-- 这个DIV是动态上面的文字 -->	
							<div id="new_text">有什么新鲜事想告诉大家？</div> 
							<!-- 动态的多行框 -->
							<div>
								<textarea id="publish_dynamic_textarea" name="content" rows="" cols=""></textarea>
							</div>
							<!-- 动态底部 --> 
					 		<div id="publish_dynamic_content_bottom">  
					 			<!-- 底部左 -->
					 			<div id="publish_dynamic_content_bottom_left">
					 				<a href="">
						 				<div class="publish_dynamic_content_bottom_left_class">
											<div class="publish_dynamic_content_bottom_left_face_class">
												<img src="/Twitter/userhome_image/font-61475.png" width="26" height="26">
											</div>
											<div class="publish_dynamic_content_bottom_left_face_text">表情</div>
										</div>
					 				</a>
					 				<!-- 上传图片 -->
					 				<input id="file_image" type="file" name="path">
						 			<div class="publish_dynamic_content_bottom_left_class">
										<div class="publish_dynamic_content_bottom_left_face_class">
											<img src="/Twitter/userhome_image/mobileslideshow.png" width="26" height="26">
										</div>
										<div class="publish_dynamic_content_bottom_left_face_text">图片</div>
									</div>
									<!-- 上传视频 -->
					 				<a href="">
						 				<div class="publish_dynamic_content_bottom_left_class">
											<div class="publish_dynamic_content_bottom_left_face_class">
												<img src="/Twitter/userhome_image/409-video.png" width="26" height="26">
											</div>
											<div class="publish_dynamic_content_bottom_left_face_text">视频</div>
										</div>
					 				</a>
							 	</div>
							 	<!-- 底部右 -->
								<div id="publish_dynamic_content_bottom_right" onclick="publish();">  
									<div id="publish_dynamic_content_bottom_right_buttom">
										<div>
											发布 
										</div>
									 </div> 
								</div>
							</div>
						</div>
					</form>
				</td>
				
				<td>
					<!-- 用户 -->
					<div id="user_div" class="all_table_border">
						<!-- 圆框头像 --> 
						<div id="user_info_top">
							<div id="radiu_icon">  
						  	 	<img  width="60" height="60" src="/Twitter/userIcon/Scorpio.png"/> 
							</div>   
						</div> 
						
						<!-- 用户信息 -->
						<div id="user_info_bottom">
							<table id="user_info_bottom_table" >
								<tr>
									<th id="user_info_username" colspan="3">
										<div>名字</div>
									</th>
								</tr>	 
								<tr>
									<th>1</th>
									<th>2</th>
									<th>3</th>
								</tr>
								<tr>
									<th class="user_info_bottom_font">关注</th>
									<th class="user_info_bottom_font">粉丝</th>
									<th class="user_info_bottom_font">微博</th>
								</tr>
							</table>
						</div>
		 			</div>  
				</td>
			</tr>
			<!-- 以下是动态的生成 -->
			<c:forEach items="${requestScope.foucs }" var="focus">
				<tr>
					<td>
						<div>${focus.baseInfo.nickName}</div>
						<div>${focus.baseInfo.simpleinfo}</div>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<div>
	<form id="testform" action="/Twitter/user/test.log" method="post" enctype="multipart/form-data">
		<input id="text" type="text" name="text">
		<input id="file"  type="file" name="image">上传图片
		<input type="submit" name="提交" value="提交" >
	</form>
</div>
<div onclick="test();">测试点击我</div>.
</body> 
<script>
	/*动态改变动态的高度，根据文本的高度的增加而增加*/
	function changeDynamicText(){
		var text_hight = document.getElementById("dynamic_bottom_content_text").offsetHeight;
		var dynamic_hight = document.getElementById("dynamic");
		var new_dynamic_hight = text_hight-17+dynamic_hight.offsetHeight;
		dynamic_hight.style.height = new_dynamic_hight+"px";
	};
	changeDynamicText();
</script>
</html>

