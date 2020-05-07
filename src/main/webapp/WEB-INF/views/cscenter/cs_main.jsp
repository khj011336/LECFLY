<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
 	response.setHeader("Cache-Control", "no-store");
%>
<meta charset="UTF-8">
<title>CS CENTER</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link type="text/css" rel="stylesheet" href="resources/css/CScenter/CSCenter.css">
	<link type="text/css" rel="stylesheet" href="resources/css/CScenter/receive_board.css">

</head>
	<body>
<div class="CSsection">
	<div id="CSsec_title"><h2>고객섬김센터</h2></div>
    <div id="CSsec_subtitle">
       <ul>
           <li><h4><a href="#" id= "CS1">QnA</a></h4></li>
           <li><h4><a href="#" id= "CS2">자주묻는 질문</a></h4></li>
           <li><h4><a href="#" id= "CS3">공지사항</a></h4></li>
       </ul>
    </div>
    <div id="CS_page">
   		<%@ include file="cs_qna.jsp"%>
   </div>
</div>
</body>
</html>
