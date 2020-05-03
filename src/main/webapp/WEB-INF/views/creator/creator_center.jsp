<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<head>

<link href="resources/css/creator/creator.css" rel ="stylesheet" type="text/css" >
<link href="resources/css/creator/cre_comment_mt.css" rel ="stylesheet" type="text/css" >
<link href ="resources/css/creator/lecplay.css" rel ="stylesheet" type="text/css" >
<title>크리에이터 센터</title>
 
</head>
<body>
	<div id="wrapper" >
		<div id="header" class='header'>
			<tiles:insertAttribute name="header" />
		</div>
		<tiles:insertAttribute name="left" />
		<%@ include file="cre_status.jsp" %>
		<div id="Cre_main">
    <tiles:insertAttribute name="body" />    
		</div>
		<div id="footer" class='footer'>
		<tiles:insertAttribute name="footer" />
		</div>
		</div>
</body>
</html>




