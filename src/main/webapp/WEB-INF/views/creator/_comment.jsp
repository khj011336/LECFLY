<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>

<c:forEach begin="3" end="3"  varStatus="d">
<div id="cre_answer">
		<form action="${pageContext.request.contextPath}/ct_edit_test_proc.LF" method="post">
		 <span id = "membername"><b>김민아</b></span>&nbsp;<span>2020.04.02</span>
        <div>텍스트 텍스트 텍스트</div>
        <div id="answercomment"><small>답글</small></div>
		</form>
	</div>
	</c:forEach>
	<div id = "offset2"></div>