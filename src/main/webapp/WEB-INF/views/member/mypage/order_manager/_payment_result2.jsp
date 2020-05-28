<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<div class="mypage_table">
			<table border="0">
				<tr>
					<th style='width:100px'>번호</th><th>상품명</th><th>결제금액</th><th>구매일</th><th>배송상태</th><th>결제수단</th>
				</tr>
				<c:forEach var="phis" items="${phisList}" varStatus="vs">
				<tr>
					<td><c:out value="${((pn-1) * 10) + (vs.index + 1)}" /></td>
					<td><c:out value="${kitTitleList[vs.index]}" /></td>
					<td><c:out value="${phis.payHistorySum}" /> 원</td>
					<td><fmt:formatDate value="${phis.updatedAt}" pattern="yyyy.MM.dd" /></td>
					<td><c:out value="${phis. }" /></td><td>신용카드</td>
				</tr>
				</c:forEach>
				<tr>
					<td>126</td><td>홈트레이닝 소도구 KIT</td><td>36,000 원</td><td>2020.03.05</td><td>배송완료<br>2020.03.08</td><td>신용카드</td>
				</tr>
				<tr>
					<td>125</td><td>홈트레이닝 소도구 KIT</td><td>36,000 원</td><td>2020.03.05</td><td>배송완료<br>2020.03.08</td><td>신용카드</td>
				</tr>
				<tr>
					<td>124</td><td>홈트레이닝 소도구 KIT</td><td>36,000 원</td><td>2020.03.05</td><td>배송완료<br>2020.03.08</td><td>신용카드</td>
				</tr>
				<tr>
					<td>123</td><td>홈트레이닝 소도구 KIT</td><td>36,000 원</td><td>2020.03.05</td><td>배송완료<br>2020.03.08</td><td>신용카드</td>
				</tr>
				<tr>
					<td>122</td><td>홈트레이닝 소도구 KIT</td><td>36,000 원</td><td>2020.03.05</td><td>배송완료<br>2020.03.08</td><td>신용카드</td>
				</tr>
				<tr>
					<td>121</td><td>홈트레이닝 소도구 KIT</td><td>36,000 원</td><td>2020.03.05</td><td>배송완료<br>2020.03.08</td><td>신용카드</td>
				</tr>
				<tr>
					<td>120</td><td>홈트레이닝 소도구 KIT</td><td>36,000 원</td><td>2020.03.05</td><td>배송완료<br>2020.03.08</td><td>신용카드</td>
				</tr>
				<tr>
					<td>119</td><td>홈트레이닝 소도구 KIT</td><td>36,000 원</td><td>2020.03.05</td><td>배송완료<br>2020.03.08</td><td>신용카드</td>
				</tr>
				<tr>
					<td>118</td><td>홈트레이닝 소도구 KIT</td><td>36,000 원</td><td>2020.03.05</td><td>배송완료<br>2020.03.08</td><td>신용카드</td>
				</tr>
			</table>
		</div>
		<div id="mypage_table_numbering">
			<c:if test="${pn gt 1}">
				<span onclick="myPagePagiNatePre(${pn}, '${pageContext.request.contextPath}/${rtUrl}')">&lt;&nbsp;</span>
			</c:if>
			<c:forEach begin="1" end="${maxPG}" step="1" varStatus="vs">
				<c:if test="${vs.index eq pn}">
					<b>${vs.index}</b>
				</c:if>
				
				<c:if test="${vs.index ne pn}">
					<span onclick="myPagePagiNateCurrunt(${pn}, ${vs.index}, '${pageContext.request.contextPath}/${rtUrl}')">${vs.index}</span>
				</c:if>
           		${vs.current eq maxPG ? "" : " "}
       		</c:forEach>
			<c:if test="${pn lt maxPG}">
				<span onclick="myPagePagiNateNext(${pn}, ${maxPG}, '${pageContext.request.contextPath}/${rtUrl}')">&nbsp;&gt;</span>
			</c:if>
		</div>
		
		
		

		
		
		
		