<!-- 배송 정보 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
var ROOTCP = '<%= application.getContextPath()%>';
$(document).ready(function() {
	$("#mypage_dilivery_status_1").click(function() {
		var url = ROOTCP+'/member/mypage/order_manager/delivery_stat1.jsp';
		$(".dilivery_status_chart").load(url, function(){
			console.log("결제대기 로딩완료");
		});			
	}); // 배송 정보 결제대기
	$("#mypage_dilivery_status_2").click(function() {
		var url = ROOTCP+'/member/mypage/order_manager/delivery_stat2.jsp';
		$(".dilivery_status_chart").load(url, function(){
			console.log("배송준비 로딩완료");
		});			
	}); // 배송 정보 배송준비
	$("#mypage_dilivery_status_3").click(function() {
		var url = ROOTCP+'/member/mypage/order_manager/delivery_stat3.jsp';
		$(".dilivery_status_chart").load(url, function(){
			console.log("배송중 로딩완료");
		});			
	}); // 배송 정보 배송중
	$("#mypage_dilivery_status_4").click(function() {
		var url = ROOTCP+'/member/mypage/order_manager/delivery_stat4.jsp';
		$(".dilivery_status_chart").load(url, function(){
			console.log("배송완료 로딩완료");
		});			
	}); // 배송 정보 배송완료
});
</script>
<div class="mypage_bottom_info">
	<h2 class="mypage_bottom_title">배송 정보</h2>
	<div class="mypage_bottom_contents">
		<div class="dilivery_status">
			<div id="mypage_dilivery_status">
				<a href="#" id="mypage_dilivery_status_1">결제대기
				<br><br>
				<span style="color:orange">2</span></a>
			</div>
			<div id="mypage_dilivery_status_point"><i class="fas fa-chevron-right fa-5x"></i></div>
			<div id="mypage_dilivery_status">
				<a href="#" id="mypage_dilivery_status_2">배송준비
				<br><br>
				<span style="color:orange">0</span></a>
			</div>
			<div id="mypage_dilivery_status_point"><i class="fas fa-chevron-right fa-5x"></i></div>
			<div id="mypage_dilivery_status">
				<a href="#" id="mypage_dilivery_status_3">배송중
				<br><br>
				<span style="color:orange">2</span></a>
			</div>
			<div id="mypage_dilivery_status_point"><i class="fas fa-chevron-right fa-5x"></i></div>
			<div id="mypage_dilivery_status">
				<a href="#" id="mypage_dilivery_status_4">배송완료
				<br><br>
				<span style="color:orange">3</span></a>
			</div>
			<!-- <ul>
		    	<li><a href="#" id="mypage_dilivery_status_1">결제대기</a></li>
		    	<li><a href="#" id="mypage_dilivery_status_2">배송준비</a></li>
		    	<li><a href="#" id="mypage_dilivery_status_3">배송중</a></li>
		    	<li><a href="#" id="mypage_dilivery_status_4">배송완료</a></li>
			</ul> -->
		</div>
		<div class="dilivery_status_chart">
			<%@ include file="delivery_stat1.jsp"%>
		</div>
	</div>
</div>