<!-- 배송정보-결제대기 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="mypage_bottom_info">
	<h2 class="mypage_bottom_title"><c:out value="${delStatHead}"/></h2>
	<div class="mypage_bottom_contents">
	<c:if test="${not empty phisList}">
		<div class="mypage_table">
		
			
			<table border="0">
				<c:set var="phisLastCnt" value="${(fn:length(phisList) - 1)}" />
				<c:forEach begin="0" end="phisLastCnt" step="1" varStatus="vs">
					<c:set var="creList" value="${creListMap['vs.index']}"/>
					<c:set var="kitList" value="${kitListMap['vs.index']}"/>
					<c:forEach begin="0" end="${creList.lenght-1}" step="1" varStatus="vsj">
				<tr>
					<th rowspan="3" style='width: 250px;'><img src="<c:out value="${kitList[vsj.index].imgPath}" />" width="240px" height="125px"></th>
					<td colspan="2"><b><c:out value="${kitList[vsj.index].title}" /></b></td><td></td><td><button>주문상세조회</button></td>
				</tr>
				<tr>
					<td>판매자:</td><td><c:out value="${creList[vsj.index].nickname}" /></td><td>주문번호 : <c:out value="${phisList[vs.index].checkSameOrder}" /></td><td>주문일자 : <fmt:formatDate value="${phisList[vs.index].dealDay}"  pattern="yyyy.MM.dd" /></td>
				</tr>
				<tr>
					<td>수량: </td><td><c:out value="${kitCount}"/>개</td><td>총 결제금액:</td><td><c:out value="${phisList[vs.index].payHistorySum}"/>원</td>
				</tr>
				<tr>
					<td></td>
				</tr>
					</c:forEach>
				</c:forEach>
			</table>
			
		
		</div>
	</c:if>
	
	<c:if test="${empty phisList}">
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