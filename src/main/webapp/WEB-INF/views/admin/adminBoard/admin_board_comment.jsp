<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h4>댓글목록 관리</h4>

<div class="admin_table_filter">
	<table>
		<caption>검색조건설정</caption>
		<tr class="date_filter">
			<th>작성일 기준 검색</th>
				<input type="hidden" name="pn" value="${(empty param.p)? 1: param.p}"/>
			<td>
				<a href="#" class="day1">오늘</a> |<a href="#" class="day3">3일</a> |
				<a href="#" class="day7">7일</a> |<a href="#" class="month1">1개월</a>&nbsp; 직접설정 
				<input type="date" name="start_date" value="2020-05-01"/> ~ <input type="date" name="end_date" value="2020-05-19"/>
			</td>
		</tr>
		<tr>
			<th>댓글 위치 선택</th>
			<td>
				<select name="">
   					<option value="">전체</option>
   					<option value="">강의</option>
   					<option value="">동영상</option>
   					<option value="">QNA게시판</option>
   				</select>
			</td>
		</tr>
		<tr>
			<th>키워드 검색</th>
			<td>
				<select name="">
   					<option value="">전체</option>
  					<option value="">내용</option>
    				<option value="">작성자</option>
    			</select>
				<input type="text" name="keyword" size="40">
			</td>
		</tr>
	</table>
	<div class="admin_search_btns">
		<button type="button" onclick="location.href='admin_board_comment.LF'">상세조회</button>
		<button type="button" onclick="location.href='admin_board_comment.LF'">전체조회</button>
	</div>
</div>

<div class="board_sort_filter">
	<h6 class="admin_search_result">
	[오늘 등록된 새 글 <span class="board_result_count"><c:out value="${listSize}건" default=""/></span>]
	총 검색결과 <span class="board_result_count"><c:out value="${totalRecords}건" default=""/></span>
	</h6>
	
	<ul class="admin_search_edit">	
		<li>
			<span class="date_filter"><a href="#">전체선택</a></span>
			<span class="date_filter"><a href="#" id="update_qna_list">수정</a></span>
			<span class="date_filter"><a href="#">삭제</a></span>
		</li>
	</ul>	
	<ul class="admin_search_sort">	
		<li><a href="#">등록일순</a></li>
	</ul>
</div>    

<div class="admin_table_wrap">
	<table>
		<tr class="admin_table_head">
			<th width=2%><input type="checkbox" id="checkAll" onclick="checkAll()"/></th>
			<th>번호</th> 
			<th>댓글번호</th> 
			<th>원글 위치</th>
			<th>원글번호</th> 
			<th>내용</th> 
			<th>작성자</th>
			<th>작성날짜</th> 
			<th>미리보기</th> 
		</tr>
		<c:forEach items="${qcList}" var="comment" varStatus="vs">
		<tr>
			<td><input type="checkbox" name="checked" value="${comment.id }"/></td> 
			<td>${vs.count}</td> 
			<td>${comment.id}</td> 
			<td>${comment.tableCate}</td>
			<td>${comment.atId}</td>
			<td>${comment.comment}</td>
			<td>${comment.mbNic}</td>
			<td>${comment.createdAt}</td>
			<td><button value="미리보기"></button></td>
		</tr>
		</c:forEach>
	</table>
	<div id="paginate">
		<c:if test="${pn > 1}">
			<a href="${pageContext.request.contextPath}/admin_board_comment.LF?pn=${pn-1}">[이전]</a>
		</c:if>
		 &nbsp; &nbsp;
		<c:forEach varStatus="vs" begin="1" end="${maxPn}" step="1">
			<c:if test='${vs.current eq pn}'>
				<b style='color: orange'>${vs.current}</b>
			</c:if>	
			<c:if test='${vs.current ne pn}'>
				<a href="${pageContext.request.contextPath}/admin_board_comment.LF?pn=${vs.current}">${vs.current}</a>
			</c:if>
			 &nbsp;
			 	
			 ${vs.current eq maxPn ? '': '|'}
		</c:forEach>
		 &nbsp; &nbsp;
		<c:if test="${pn < maxPn}">
			<a href="${pageContext.request.contextPath}/admin_board_comment.LF?pn=${pn+1}">[다음]</a>
		</c:if>
	</div>
</div>