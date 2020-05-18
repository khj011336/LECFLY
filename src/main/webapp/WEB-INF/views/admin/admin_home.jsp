<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="resources/css/admin/adminpage.css">
<link rel="stylesheet" href="resources/css/admin/admin_main.css">
<link rel="stylesheet" href="resources/css/common/main.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/esm/popper.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/js/bootstrap.js" type="text/javascript"></script> 
<title>관리자 페이지</title>
<script type="text/javascript">
function checkAll(){
    if( $("#checkAll").is(':checked') ){
      $("input[name=checked]").prop("checked", true);
    }else{
      $("input[name=checked]").prop("checked", false);
    }
}
</script>

<style type="text/css">

/* 관리자 리스트 출력 폼 */
.admin_table_wrap {/* 결과물 출력부 래퍼 */
	margin: 0 auto;
	text-align:center;
	padding: 0 30px;
	table-layout: fixed
}
.admin_table_wrap > table {
	border-top: 2px solid black; 
	border-bottom: 2px solid black; 
	width:100%;
}
.admin_table_wrap td {
	border: .1px solid lightgray; 
}
.admin_table_head > th {
	background-color: #e8e8e8;
}
.admin_table_filter > table {/* 결과물 정렬기준 */
	margin: 30px;
	width:100%;
}

.admin_table_filter th {
	background-color: #e8e8e8;
}
.admin_table_filter caption {
	caption-side: top;
	
}
.date_filter{/* 기간검색 */
	padding: 0px;
}
.board_sort_filter ul{
	list-style: none;
}
.board_sort_filter li{
	display: inline-block;
}
.board_result_count {
	color: orangered;
}
.admin_search_btns {
 	text-align:center;
}
/* 결과 상단 출력결과 및 정렬 */
.admin_search_result {
	margin-left: 30px;
}
.admin_search_edit {
	float: left;
}
.admin_search_edit li{
	margin-left: 30px; 
}
.admin_search_sort{
	float: right;
	margin-right: 30px;
}
.admin_search_sort li{
/* 	margin-right: 5px; */
} 

</style>
</head>
<body>
	<div class="page-wrapper chiller-theme toggled">
		  <a id="show-sidebar" class="btn btn-sm btn-dark" href="#">
		    <i class="fas fa-bars"></i>
		  </a>

  <!-- 관리자 사이드 메뉴  -->
  <div id="admin_nav">
  	<tiles:insertAttribute name="admin_nav"/>
<%-- 	<%@include file="admin_side_nav.jsp" %> --%>
  </div>
	
  <!-- 관리자 메인 조각  -->
  <div class="page-content">
    <div class="container-fluid">
   	<tiles:insertAttribute name="admin_body"/>
<%--       <%@include file="admin_main.jsp" %> --%>
    </div>
  </div>
</div>
	
</body>
</html>