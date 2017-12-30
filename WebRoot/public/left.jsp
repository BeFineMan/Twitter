<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
body {
	margin:0px;
	padding: 0px;
	font-size: 12px;
	background-color: #1873aa;
	text-align: center;
	overflow: hidden;
} 
    #container{
    background-color: #FFFFFF;
    margin-top:-10px;
    margin-left:5px;
    width: 165px;
    height: 550px;
    }
   
    #style1{
    margin-top:10px;
    background-image:url("../images/main_40.gif");
    width:165px;
    height:28px;
    color: #FFFFFF;
    position: relative;
    }
    #person{
   margin-top:6px;
    margin-left: 35px;
	text-align:center;
	float: left;
    }
    #style2{
    margin-left: 8px; 
    margin-top: 5px;
    
    }
    #style211 {
    background-image: url("../images/main_47.gif");
    width: 151px;
    height: 23px;
    position: relative;
    }
    #style211 div{
    margin-top:5px;
    margin-left: 35px;
    color: #FFFFFF;
	text-align:center;
	float: left;
    }
    #style212{
    border: 1px solid #95d6e4;
    height: 150px;
    width: 149px;
  text-align: left;
    color: #033d61;
    }
    #style212 ul{
    list-style-type: none;
    list-style-image: url("../images/left.gif");
    margin-left: 20px;
    }
    #style212 ul li{
    margin-bottom:10px; 
    margin-left: -15px;
    }
    #style212 ul li a{
    text-decoration: none;
    color: #033d61;
    }
    #style212 ul li a:HOVER {
	text-decoration: underline;
	font-size: 13px;
}
</style>
<script type="text/javascript">
function hiddenDiv(div){
div.style.display=(div.style.display=='none'?'block':'none');
}
</script>
</head>
<body>
<div id="container">
<div id="style1">
<div id="person">个人信息</div>

</div>
<div id="style2">

<div id="style21">
<div id="style211">
<div><a href="javascript:void(0)" onclick="hiddenDiv(document.getElementById('style212'))">课程信息</a></div>
</div>

<div id="style212">
<ul>
<li><a href="${pageContext.request.contextPath}/student/tableServlet?" target="main">好友圈</a></li>
<li><a href="${pageContext.request.contextPath }/student/rubLessonServlet?method=listAll" target="main">特别关注</a></li>
<li><a href="${pageContext.request.contextPath }/student/chooseCourseServlet?method=getUI" target="main">粉丝</a></li>
<li><a href="${pageContext.request.contextPath }/student/findClassRom.jsp" target="main">A分组</a>
<li><a href="${pageContext.request.contextPath }/student/queryScoreServlet?method=getAllCourse" target="main">B分组</a></li>
</ul>
</div>
</div> 

</div>

<!-- 最外层的大DIV -->
</div>
</body>


</html>