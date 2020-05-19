<!-- 문의내역 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:if test="${not empty qnaList}">
	<div class="mypage_bottom_info">
		<h2 class="mypage_bottom_title">문의내역</h2>
		<div class="mypage_bottom_contents">
			<div class="mypage_table">
				<table border="0">
					<tr>
						<th style='width:100px'>번호</th><th>제목</th><th style='width:100px'>조회수</th><th style='width:100px'>댓글수</th><th style='width:200px'>날짜</th>
					</tr>
					<c:forEach var="qna" items="${qnaList}" varStatus="vs">
					<tr>
						<td><c:out value="${((pn-1) * 10) + (vs.index + 1)}" /></td> <!-- 게시글번호 -->
						<td><c:out value="${qna.title}"/></td> <!-- Property [title] not found on type [java.lang.String] qna 제목 -->
						<td><c:out value="${qna.hits}"/></td> <!-- 조회수 -->
						<td><c:out value="${qna.comment}"/></td> <!--  댓글수 -->
						<td><fmt:formatDate value="${qna.writedDay}" pattern="yyyy.MM.dd HH:mm"/></td> <!-- 작성날짜 -->
					</tr>
					</c:forEach>
				</table>
			</div>
			
			<div id="mypage_table_numbering">
					<c:if test="${pn gt 1}">
						<span onclick="myPagePagiNatePre(${pn}, '${pageContext.request.contextPath}/mypage_qna.LF')">&lt;&nbsp;</span>
					</c:if>
					<c:forEach begin="1" end="${maxPG}" step="1" varStatus="vs">
						<c:if test="${vs.current eq pn}">
							<b>${vs.current}</b>
					</c:if>
					<c:if test="${vs.current ne pn}">
						<span onclick="myPagePagiNateCurrunt(${pn}, ${vs.current}, '${pageContext.request.contextPath}/mypage_qna.LF')">${vs.current}</span>
					</c:if>
	            		${vs.current eq maxPG ? "" : " "}
	        		</c:forEach>
					<c:if test="${pn lt maxPG}">
						<span onclick="myPagePagiNateNext(${pn}, ${maxPG}, '${pageContext.request.contextPath}/mypage_qna.LF')">&nbsp;&gt;</span>
					</c:if>
			</div>
		</div>
	</div>
</c:if>
<c:if test="${empty qnaList}">
	<%@ include file="../attend_lec_manager/mypage_no_list.jsp"  %>
</c:if>