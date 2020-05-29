<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<div class="mypage_table">
			<table border="0">
				<tr>
					<th style='width:100px'>번호</th><th>상품명</th><th>결제금액</th><th>구매일</th><th>배송상태</th><th>결제수단</th>
				</tr>
				<tr>
					<td>1</td><td>강아지 수채화 클래스 키트</td><td>27,000 원</td><td>2020.06.02</td><td>배송완료<br>2020.03.06</td><td>신용카드</td>
				</tr>
				<tr>
					<td>2</td><td>실크커튼 자수 클래스 키트</td><td>18,000 원</td><td>2020.06.02</td><td>배송완료<br>2020.03.06</td><td>신용카드</td>
				</tr>
				<tr>
					<td>3</td><td>가죽 카드지갑 만들기 클래스 키트</td><td>36,000 원</td><td>2020.06.01</td><td>배송완료<br>2020.03.05</td><td>신용카드</td>
				</tr>
				<tr>
					<td>4</td><td>강아지 수채화 클래스 키트</td><td>27,000 원</td><td>2020.06.01</td><td>배송완료<br>2020.03.05</td><td>신용카드</td>
				</tr>
				<tr>
					<td>5</td><td>실크커튼 자수 클래스 키트</td><td>18,000 원</td><td>2020.06.01</td><td>배송완료<br>2020.06.05</td><td>신용카드</td>
				</tr>
				<tr>
					<td>6</td><td>가죽 카드지갑 만들기 클래스 키트</td><td>36,000 원</td><td>2020.05.28</td><td>배송완료<br>2020.06.02</td><td>신용카드</td>
				</tr>
				<tr>
					<td>7</td><td>홈트레이닝 소도구 KIT</td><td>38,000 원</td><td>2020.05.15</td><td>배송완료<br>2020.05.20</td><td>신용카드</td>
				</tr>
				<tr>
					<td>8</td><td>홈트레이닝 소도구 KIT</td><td>38,000 원</td><td>2020.05.11</td><td>배송완료<br>2020.05.16</td><td>신용카드</td>
				</tr>
				<tr>
					<td>9</td><td>홈트레이닝 소도구 KIT</td><td>38,000 원</td><td>2020.05.01</td><td>배송완료<br>2020.05.06</td><td>신용카드</td>
				</tr>
				<tr>
					<td>10</td><td>홈트레이닝 소도구 KIT</td><td>38,000 원</td><td>2020.05.01</td><td>배송완료<br>2020.03.06</td><td>신용카드</td>
				</tr>
			</table>
		</div>
		<div id="mypage_table_numbering">
			<span>&lt;&nbsp;</span>
			<c:forEach begin="1" end="10" step="1" varStatus="vs">
				<c:if test="${vs.index eq 1}">
					<b>${vs.index}</b>
				</c:if>
				<c:if test="${vs.index ne 1}">
					<span>${vs.index}</span>
				</c:if>
           		${vs.current eq 10 ? "" : " "}
       		</c:forEach>
			<span>&nbsp;&gt;</span>
		</div>
		
		
		

		
		
		
		