<!-- 댓글내역 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:if test="${!empty couponList}">
	<div class="mypage_bottom_info">
		<h2 class="mypage_bottom_title">쿠폰</h2>
		<a class="mypage_registerCoupon" href="#popup1">쿠폰 등록</a>
		<div id="popup1" class="overlay">
			<div class="popup">
				<h2 class="mypage_coupon_h2">쿠폰 등록하기</h2>
				<a class="close" href="#">x</a>
				<div class="mypage_coupon_content">
					<input type="text" name="mypage_coupon" id="mypage_coupon"
						placeholder="쿠폰 코드를 입력해주세요." size="20"> <input type="button"
						value="등록하기" name="register_coupon" />
				</div>
				<p id="mypage_coupon_p">필독! 주의사항</p>
				<ul id="mypage_coupon_ul">
					<li>이미 사용된 쿠폰은 등록할 수 없습니다.</li>
					<li>하나의 계정당 종류별 한 개의 쿠폰만 등록할 수 있습니다.</li>
					<li>쿠폰 등록이 완료되면 내 쿠폰으로 즉시 지급됩니다.</li>
					<li>일부 쿠폰의 경우, 등록기한 이후에는 사용이 불가능합니다.</li>
				</ul>
			</div>
		</div>
		<div class="mypage_bottom_contents">
			<div class="mypage_table">
				<table border="0">
					<tr>
						<th style='width: 100px'>번호</th>
						<th style='width: 100px'>쿠폰명</th>
						<th>할인금액(률)</th>
						<th>적용대상</th>
						<th>사용여부</th>
						<th style='width: 200px'>유효기간</th>
					</tr>
					<c:forEach var="coupon" items="${couponList}" varStatus="vs">
					<tr>
						<td><c:out value="${(pn-1) * 10 + vs.index}"/></td>
						<td><c:out value="${coupon.couponName}" default="쿠폰" /></td>
						<td><c:out value="${coupon.discount}"/></td> <!-- Property [discount] not found on type [java.lang.String] -->
						<td><c:out value="${couponApplyList[vs.index]}" default="모든회원" /></td>

						<td><c:out value="${strCanUse[vs.index]}" /></td>
						<td><fmt:formatDate value="${coupon.endDay}" pattern="yyyy.MM.dd HH:mm" /></td>
					</tr>
					</c:forEach>
				</table>
			</div>
			
			<div id="mypage_table_numbering">
				pn = <c:out value="${pn}"/> ,
				maxPg = <c:out value="${maxPG}"/>  
					<c:if test="${pn gt 1}">
						<span onclick="myPagePagiNatePre(${pn}, '${pageContext.request.contextPath}/mypage_coupon_info.LF')">&lt;&nbsp;</span>
					</c:if>
					<c:forEach begin="1" end="${maxPG}" step="1" varStatus="vs">
						<c:if test="${vs.index eq pn}">
							<b>${vs.index}</b>
					</c:if>
					<c:if test="${vs.index ne pn}">
						<span onclick="myPagePagiNateCurrunt(${pn}, ${vs.index}, '${pageContext.request.contextPath}/mypage_coupon_info.LF')">${vs.index}</span>
					</c:if>
	            		${vs.index eq maxPG ? "" : " "}
	        		</c:forEach>
					<c:if test="${pn lt maxPG}">
						<span onclick="myPagePagiNateNext(${pn}, ${maxPG}, '${pageContext.request.contextPath}/mypage_coupon_info.LF')">&nbsp;&gt;</span>
					</c:if>
			</div>
		</div>
	</div>
</c:if>
<c:if test="${empty couponList}">
	<%@ include file="../attend_lec_manager/mypage_no_list.jsp"  %>
</c:if>
