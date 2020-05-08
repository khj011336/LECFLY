<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<%
 	response.setHeader("Cache-Control", "no-store");

%>
<head>
<%@include file ="/resources/variable/pubLinkCss.jspf" %>

<title>LecFly</title>
</head>
<body>
	<div id="wrapper">
		<div id="header" class="header" style="z-index:30;">
			<tiles:insertAttribute name="home_header" />
		</div>
			<tiles:insertAttribute name="home_left" />
		<div id="homemain">
			<tiles:insertAttribute name="home_body" />
		</div>
		<div id="footer" class="footer">
			<tiles:insertAttribute name="home_footer" />
		</div>
	</div>

</body>
</html>




