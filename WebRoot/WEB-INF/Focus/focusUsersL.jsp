<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="c" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head> 
<meta charset="utf-8"> 
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no"> 
<title>关注的人</title> 

<!-- 线上 -->
<base target="_blank" href="http://static.zgame.fun/web/">
<!-- 开发 -->
<!-- <base href="../../../../web/" /> -->

<link rel="icon" href="www/pc/images/favicon.ico" type="image/x-icon">

<link rel="stylesheet" type="text/css" href="www/pc/css/base.css">

<link rel="stylesheet" type="text/css" href="www/pc/css/newsList.css">

<script type="text/javascript" src="common/js/jquery-3.2.1.min.js"></script>

<!-- 请求的js -->
<!-- html拼接的js -->
<script type="text/javascript" src="www/pc/js/htmlStrCat.js"></script>
<!-- 工具类 -->
<script type="text/javascript" src="www/pc/js/tool.js"></script>

<style type="text/css">
    .img1{
        background-color: red;
    }
</style>
</head> 
<body> 	
    <div class="wrap"> 
        <!-- 顶部区域 -->
        <div class="top">
        	<img class="img1" src="www/pc/images/bg_1ee21af.jpg" alt="">
        </div>
        <!-- 新闻头部 -->
        <div class="headerContainer"> 
            <div class="header">
                <p><i> </i><span>关注的人</span></p>
                <ul class="tab">
                    <li class="selected"> 最新</li>
                    <li>新闻</li>
                    <li>公告</li>
                </ul>
            </div>
        </div>
        <!-- 新闻列表 -->
        <div class="list">
        <ul>

        <c:forEach items="${requestScope.focus}" var="item"> 
        	<li>
        		<a title="${item.baseInfo.nickName}" href="http://www.zgame.fun/detail.html?id=101">
        			<span>${item.baseInfo.nickName}</span>
        			<em></em>
        			<p class="lside">
        				<span class="time textBlack">已关注</span>
        				<span class="title textBlack"></span>
        				<span class="comment">简介: ${item.baseInfo.simpleinfo}</span>
        			</p>
        		</a>
        	</li>
        
        </c:forEach>
        </ul>
     	
     	
     	</div>
    </div>

    <!-- 底部分页栏 -->   
    <div class="paging">
        <div>
            <span>10/11</span>
            <a href="#">&lt;</a>
            <a href="#">&gt;</a>
        </div>
    </div>
<!-- 底部区域 -->
<div class="footer">
    <div class="footer_des">
        <div class="logo">
            <img src="www/pc/images/logo.png" alt="">
        </div>  
        <div class="gaba"><img src="www/pc/images/gaba.png" alt=""><a href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=51019002001212">川公网安备 51019002001212号</a>
        </div>
    </div>
</div>
<script type="text/javascript" src="www/pc/js/newsContro.js"></script>




   

 
 </body></html>