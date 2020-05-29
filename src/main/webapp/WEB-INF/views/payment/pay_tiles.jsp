<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<head>
<%@include file="/resources/variable/pubLinkCss.jspf"%>
<title>결제페이지</title>
</head>
<body>
	<div id="wrapper">
		<div id="header" class='header'>
			<tiles:insertAttribute name="header" />
		</div>
			<tiles:insertAttribute name="left" />
		<div id="homemain">
			<tiles:insertAttribute name="payment-body" />
		</div>
		<div id="footer" class='footer'>
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>