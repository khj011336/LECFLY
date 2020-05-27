<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="resources/css/admin/adminpage.css">
<link rel="stylesheet" href="resources/css/admin/admin_main.css">
<link rel="stylesheet" href="resources/css/common/main.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"
	type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/esm/popper.js"
	type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/js/bootstrap.js"
	type="text/javascript"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/drilldown.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<title>관리자 페이지</title>

</head>
<body>
	<div class="page-wrapper chiller-theme toggled">
		<a id="show-sidebar" class="btn btn-sm btn-dark" href="#"> <i class="fas fa-bars"></i>
		</a>

		<!-- 관리자 사이드 메뉴  -->
		<div id="admin_nav">
			<tiles:insertAttribute name="admin_nav" />
			<%-- 	<%@include file="admin_side_nav.jsp" %> --%>
		</div>

		<!-- 관리자 메인 조각  -->
		<div class="page-content">
			<div class="container-fluid">
				<tiles:insertAttribute name="admin_body" />
				<%--    <%@include file="admin_main.jsp" %> --%>
			</div>
		</div>
	</div>
	
<script src="resources/js/admin/admin.js"></script>
<script src="resources/js/admin/admin_stat.js"></script>
</body>
</html>