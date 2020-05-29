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
			<c:if test="">
			 	<%@ include file="_payment_result.jsp" %>
			</c:if>
			<c:if test="">			
				<div class="mypage_table">
					<table border="0">
						<tr>
							<th>현재 <c:out value="${delStat}"/>인 상품이 없습니다.</th>
						</tr>
					</table>
				</div>
			</c:if>
			 	
		</div>
		
	</div>
</div>