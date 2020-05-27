<!-- 배송정보-결제대기 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="mypage_bottom_info">
	<h2 class="mypage_bottom_title">결제대기</h2>
	<div class="mypage_bottom_contents">
	<c:if test="${not empty phisList}">
		<div class="mypage_table">
		
			<c:forEach var="phis" items="phisList" varStatus="vs">
			<table border="0">

				<tr>
					<th rowspan="3" style='width: 250px;'><img src="<c:out value="${kitList.get(vs.index).imgPath}" />" width="240px" height="125px"></th>
					<td colspan="2"><b><c:out value="${kitList.get(vs.index).title}" /></b></td><td></td><td><button>주문상세조회</button></td>
				</tr>
				<tr>
					<td>판매자:</td><td><c:out value="${creList.get(vs.index).nickname}" /></td><td>주문번호 : <c:out value="${phis.checSameOrder}" /></td><td>주문일자 : <fmt:formatDate value="${phis.dealDay}"  pattern="yyyy.MM.dd" /></td>
				</tr>
				<tr>
					<td>수량: </td><td><c:out value="${kitCount}"/>개</td><td>총 결제금액:</td><td><c:out value="${phis.payHistorySum}"/>원</td>
				</tr>
				<tr>
					<td></td>
				</tr>
			</table>
			</c:forEach>
		
		</div>
	</c:if>
	
	<c:if test="${empty phisList}">
		<div class="mypage_table">
			<table border="0">
				<tr>
					<th>현재 배송준비중인 상품이 없습니다.</th>
				</tr>
			</table>
		</div>
	</c:if>
	</div>
</div>