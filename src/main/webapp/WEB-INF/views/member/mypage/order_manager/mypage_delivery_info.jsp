<!-- 배송 정보 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:if test="${not empty phisList}">    
	<div class="mypage_bottom_info">
		<h2 class="mypage_bottom_title">배송 정보</h2>
		<div class="mypage_bottom_contents">
			<div class="dilivery_status">
				<div id="mypage_dilivery_status">
					<a id="mypage_dilivery_status_1">결제대기
					<br><br>
					<span style="color:orange"><c:out value="${deliveryStatusArray[0]}" default="0"/></span></a>
				</div>
				<div id="mypage_dilivery_status_point"><i class="fas fa-chevron-right fa-5x"></i></div>
				<div id="mypage_dilivery_status">
					<a id="mypage_dilivery_status_2">배송준비
					<br><br>
					<span style="color:orange"><c:out value="${deliveryStatusArray[1]}" default="0"/></span></a>
				</div>
				<div id="mypage_dilivery_status_point"><i class="fas fa-chevron-right fa-5x"></i></div>
				<div id="mypage_dilivery_status">
					<a id="mypage_dilivery_status_3">배송중
					<br><br>
					<span style="color:orange"><c:out value="${deliveryStatusArray[2]}" default="0"/></span></a>
				</div>
				<div id="mypage_dilivery_status_point"><i class="fas fa-chevron-right fa-5x"></i></div>
				<div id="mypage_dilivery_status">
					<a id="mypage_dilivery_status_4">배송완료
					<br><br>
					<span style="color:orange"><c:out value="${deliveryStatusArray[3]}" default="0"/></span></a>
				</div>
			</div>
			<div class="dilivery_status_chart">
<%-- 				<%@ include file="delivery_stat.jsp"%> --%>
			</div>
		</div>
	</div>
</c:if>