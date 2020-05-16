<!-- 댓글내역 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<c:if test="${!empty qnacomList}">    
	<div class="mypage_bottom_info">
		<h2 class="mypage_bottom_title">댓글내역</h2>
		<div class="mypage_bottom_contents">
			<div class="mypage_table">
				<table border="0">
					<tr>
						<th style='width:100px'>번호</th><th>원본글</th><th>댓글</th><th style='width:100px'>대댓글</th><th style='width:200px'>날짜</th>
					</tr>
					<c:forEach var="qnacom" items="${qnacomList}" varStatus="vs">
					<tr>
						<td><c:out value="${((pn-1) * 10) + (vs.index + 1)}" /></td> <!-- 지금 pn이 0이라서그럼.. 게시글번호 -->
						<td><c:out value="${qnaList.get(vs.index).title}" /></td> <!-- 원글 제목 -->
						<td><c:out value="${qnacom.content}" /></td> <!-- 내 댓글  -->    
						<td><c:out value="${qnacom.parentsId}" /></td><!-- 대댓글 -->
						<td><fmt:formatDate value="${qnacom.writedDay}" pattern="yyyy.MM.dd HH:mm" /></td><!-- 작성날짜 -->
					</tr>
					</c:forEach>
				</table>
			</div>
    		
			<div id="mypage_table_numbering">
				<c:if test="${pn gt 1}">
					<span onclick="myPagePagiNatePre(${pn}, 'mypage_comment.LF')">&lt;&nbsp;</span>
				</c:if>
				<c:forEach begin="1" end="${maxPn}" step="1" varStatus="vs">
					<c:if test="${vs.current eq pn}">
						<b>${vs.current}</b>
				</c:if>
				<c:if test="${vs.current ne pn}">
					<span onclick="myPagePagiNateCurrunt(${pn}, ${vs.current}, 'mypage_comment.LF')">${vs.current}</span>
				</c:if>
            		${vs.current eq maxPn ? "" : " "}
        		</c:forEach>
				<c:if test="${pn lt maxPn}">
					<span onclick="myPagePagiNateNext(${pn}, ${maxPn}, 'mypage_comment.LF')">&nbsp;&gt;</span>
				</c:if>
			</div>
		</div>
	</div>
</c:if>