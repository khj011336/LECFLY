<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<style>
#register_banner_form{
	margin: 30px;
	border: 1px solid gray;
	
}
.admin_search_btns {
	margin-bottom: 30px;
}
</style>
<h4>배너 관리</h4>

<div class="admin_table_filter">
	<table>
		<caption>검색조건설정</caption>
		<tr>
			<th>노출상태</th>
			<td><lable>
				<input name="board_con" type="radio" value="">전체보기</lable> <lable>
				<input name="board_con" type="radio" value="">전시중</lable> <lable>
				<input name="board_con" type="radio" value="">미전시</lable> <lable>
			<td></td>
		</tr>
	</table>
	<div class="admin_search_btns">
		<button type="button" onclick="location.href='admin_banner_list.LF'">조회하기</button>
	</div>
</div>

<div class="board_sort_filter">
	<h6 class="admin_search_result">
		[오늘 등록된 정보 <span class="board_result_count">0</span>건] 검색결과 <span
			class="board_result_count">${fn:length(bannerList)} </span>건
	</h6>
</div>
<!-- 배너 등록창 -->
<div id="register_banner_form">
	<h5>배너 등록</h5>
	<form
		action="${pageContext.request.contextPath}/admin_insert_banner.LF"
		method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>노출위치</th>
				<td><select name="fileDisplayOn" resultType="">
						<option value="1" selected="selected">메인배너</option>
				</select>
				</td>
			</tr>
			<tr>
				<th>노출순서</th>
				<td><select name="fileDisplayNum">
						<option value="0">좌 1</option>
						<option value="1">좌 2</option>
						<option value="2">좌 3</option>
						<option value="3" selected="selected">중</option>
						<option value="4">우 1</option>
						<option value="5">우 2</option>
						<option value="6">우 3</option>
				</select>
				</td>			
			</tr>
			
			<tr>
				<th>수업 ID</th>
				<td><input type="text" name="fileLectureId" size="20"></td>
			</tr>
			<tr>
				<th>파일 선택</th>
				<td><input type="file" name="bannerFile"></td>
				<input type="hidden" name="fileName" value="good">
				<input type="hidden" name="filePath" value="paththth">
				<input type="hidden" name="fileSize" value="123">
				<input type="hidden" name="fileupdatedDate" value="">
			</tr>
			<tr>
				<td><input type="reset" value="초기화"></td>
				<td><input type="submit" value="등록"></td>
			</tr>
		</table>
	</form>
</div>
<!-- 배너 검색결과 -->
<div id="banner_list" class="admin_table_wrap">
	<form action="${pageContext.request.contextPath}/admin_delete_banner.LF" method="post">
		<table>
			<tr class="admin_table_head">
				<th width=2%><input type="checkbox" /></th>
				<th>번호</th>
				<th>노출위치</th>
				<th>노출순서</th>
				<th>강의 ID</th>
				<th>파일 제목</th>
				<th>파일 경로</th>
				<th>파일 크기</th>
				<th>갱신일</th>
			</tr>
			
		<c:forEach items="${bannerList}" var="banner">
			<tr>
				<td width=2%><input type="checkbox" name="deleteId" value="${banner.id }"/></td>
				<td>${banner.id}</td>		
				<td>${banner.fileDisplayOn}</td>		
				<td>${banner.fileDisplayNum}</td>		
				<td>${banner.fileLectureId}</td>		
				<td>${banner.fileName}</td>		
				<td>${banner.filePath}</td>		
				<td>${banner.fileSize}</td>		
				<td>${banner.updatedDate}</td>	
			</tr>	
		</c:forEach>
			<tr>
			<input type="submit" value="삭제">
			</tr>
		</table>
	</form>
</div>