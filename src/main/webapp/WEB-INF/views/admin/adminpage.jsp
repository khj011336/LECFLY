<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resource/css/adminpage.css">
<link rel="stylesheet" href="../resource/css/admin_main.css">
<link rel="stylesheet" href="../resource/css/main.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/esm/popper.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/js/bootstrap.js" type="text/javascript"></script> 
<title>Lecfly 관리자 페이지</title>
<script>
$(document).ready(function() { 		
	
	$(document).on("click",'#nav_admin_main', function() {
		$(".container-fluid").load("admin_main.jsp");
	}); // admin 메인페이지 
	
	$(document).on("click",'#nav_board_bulletin', function() {
		$(".container-fluid").load("admin_board_bulletin.jsp");
	}); // 게시판 관리
	
	$(document).on("click",'#nav_board_payment', function() {
		$(".container-fluid").load("admin_board_payment.jsp");
	});// 이용권 결제내역
});

</script>
</head>

<body>
<div class="page-wrapper chiller-theme toggled">
  <a id="show-sidebar" class="btn btn-sm btn-dark" href="#">
    <i class="fas fa-bars"></i>
  </a>

  <!-- 관리자 사이드 메뉴  -->
	<%@include file="admin_side_nav.jsp" %>
	
  <!-- 관리자 조각  -->
  <div class="page-content">
    <div class="container-fluid">
      <%@include file="admin_main.jsp" %>
    </div>
  </div>
</div>


</body>
</html>