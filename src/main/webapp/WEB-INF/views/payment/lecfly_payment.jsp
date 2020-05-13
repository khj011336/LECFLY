<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<head>
<%@include file ="/resources/variable/pubLinkCss.jspf" %>
<!-- kakao 우편 서비스 -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- kakaoPay 결제 서비스 -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<!-- card 등록 서비스 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/imask/3.4.0/imask.min.js"></script>

<link href="resources/css/payment/pay_card_register.css" rel ="stylesheet" type="text/css" >
<link href="resources/css/payment/pay_intro.css" rel ="stylesheet" type="text/css" >
<link href="resources/css/payment/pay_cart.css" rel ="stylesheet" type="text/css" >
<link href="resources/css/payment/pay_order.css" rel ="stylesheet" type="text/css" >
<link href="resources/css/payment/pay_order_finish.css" rel ="stylesheet" type="text/css" >
<link href="resources/css/payment/pay_order_email.css" rel ="stylesheet" type="text/css" >
<link href="resources/css/payment/pay_order_detail.css" rel ="stylesheet" type="text/css" > 

<title>결제페이지</title>
</head>
<body>
	<div id="wrapper" >
		<div id="header" class="header">
			<tiles:insertAttribute name="payment_header" />
		</div>
		<div id="left" class="left">
			<tiles:insertAttribute name="payment_left" />
		</div>
		<div id="main">
    		<tiles:insertAttribute name="payment_body" />    
		</div>
		<div id="footer" class="footer">
			<tiles:insertAttribute name="payment_footer" />
		</div>
	</div>
</body>
</html>




