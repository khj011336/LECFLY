<!-- 결제내역 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="mypage_bottom_info">
	<h2 class="mypage_bottom_title">결제내역</h2>
	<div class="mypage_bottom_contents">
		<div id="payment_nav" class="mypage_nav2">
		  	<ul>
		    	<li><a id="mypage_pay_all">전체</a></li>
		    	<li><a id="mypage_pay_tickets">이용권</a></li>
		    	<li><a id="mypage_pay_kits">kit</a></li>
			</ul>
		 </div>
		<div id="payment_chart">
			 	<%@ include file="_payment_result.jsp" %>	
		</div>
		
	</div>
</div>