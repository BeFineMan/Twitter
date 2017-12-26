<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'head.jsp' starting page</title>
  <style type="text/css">
  body{
  background-image: url("../images/headSimple2.jpg");
  background-color:#1873aa;
  } 
  h1{
	  color:#fff;
  }
  #name{
  margin-top:20px;
  margin-right:20px;
  float: right;
  color: #FFF
  }
  
  #course{
  font-size:20px;
  margin-left:600px;
   margin-top:20px;
  float: left;
  color: #FFF
  }
  
  </style>
  </head>
  
  <body>
    <div id="course">课程管理中心</div>
    <div id="name">${student.sID}&nbsp;  ${student.sName }</div>
    
  </body>
</html>
