<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>

<html>
<head>
<meta charset="UTF-8">
<title>테스트용 임시 jsp</title>
</head>
<body>
	<div id="new_answer">
		<form action="${pageContext.request.contextPath}/ct_edit_test_proc.LF" method="post">
			<label>
				댓글 업데이트: 
			</label>
			<input type="number" name="targetCtId">
			<textarea name="comment" rows="4" cols="80" placeholder="댓글 실명으로 입력!!"></textarea> <br>			
			<input type="submit" value="댓글변경">
		</form>
	</div>
</body>
</html>