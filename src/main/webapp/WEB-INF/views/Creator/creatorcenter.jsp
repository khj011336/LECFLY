<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<head>
<title>크리에이터 센터</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link href="../resource/css/CreCommentMt.css" rel="stylesheet"
	type="text/css">
<link href="../resource/css/creator.css" rel="stylesheet"
	type="text/css">
<link href="../resource/css/side_nav.css" rel="stylesheet"
	type="text/css">
<link href="../resource/css/main.css" rel="stylesheet" type="text/css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.4.0/css/fontawesome.css"
	type="text/css" rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.4.0/css/solid.css"
	type="text/css" rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
	<link rel="stylesheet" href ="../resource/css/CSCenter.css" type="text/css">
	<script>
	$().ready(function () {
	
$('.header_column_logo').click(function () {
	location.href = "http://localhost:8081/LF/";
});
$(document).on("click",".CRsend",function () {
	$('#Cre_main').load("CrePlaylist.jsp");
});
$(document).on("click",'.crinf',function () {
	var s =$("#countor select").val();
	$("#Cre_main").load("_classdes.jsp");
	});

$(document).on("click",'.deleteOne',function () {
	var s =$("#countor select").val();
	if(s == 1){
	$("#Cre_main").load("_videoupload.jsp");		
	}else{
		$("#Cre_main").load("_sellkitregistration.jsp");
	}
	});
	$(document).on("click",".nav_video_list", function () {
		$("#Cre_main").load("CrecommentList.jsp");
	});
	$(document).on("click",".nav_lecfly_info", function () {
		$("#Cre_main").load("_myclass.jsp");
		$("#Crcircle").css("display","none");
	});
	$(document).on("click",".CRsendCo", function () {
		$("#Cre_main").load("CrecommentMt.jsp");
	});
	$(document).on("click",".listup", function () {
		$("#Cre_main").load("_videoupload.jsp");
	});
	$(document).on("click","#CRHT2", function () {
		$("#Cre_main").load("_classdes.jsp");
		$("#Crcircle").css("display","inline-block");
		
	});
$(document).on("click",".Ccirk", function (re) {
		$(".Ccirk").css("text-decoration","none");
		$(".Ccirk").css("color","black");
		$(this).css("text-decoration","underline");
		$(this).css("color","#ffa500");
		var pa = $(this).html();
		if(pa == "1.크리에이터 소개"){ $("#Cre_main").load("_creatorprofile.jsp");}
		else if(pa == "2.클래스 기본정보"){ $("#Cre_main").load("_classdes.jsp");}
		else{$("#Cre_main").load("../goods/lectureRegister.jsp");}  
	});
$(document).on("click","#CRHT2", function () {
		$("#Cre_main").load("_creatorprofile.jsp");
		$("#Crcircle").css("display","inline-block");
	});
$(document).on("click",".nav_payment", function () {
	$("#Cre_main").load("Crestatistics.jsp");
	
});
$(document).on("click",".nav_wish_list", function () {
	$("#Cre_main").load("Cre_CS_1.jsp");
	});

	});

</script>
</head>
<body>
	<div id="wrapper" >
		<div id="header" class='header'>
			<%@ include file="../common/header.jsp"%>
		</div>
		<%@ include file="Creside_nav.jsp"%>
		<%@ include file="CreStatus.jsp" %>
		<div id="Cre_main">
			
			<%@ include file="_myclass.jsp"%>
		</div>
		<div id="footer" class='footer'>
			<%@ include file="../common/footer.jsp"%>
		</div>
	</div>
</body>
</html>




