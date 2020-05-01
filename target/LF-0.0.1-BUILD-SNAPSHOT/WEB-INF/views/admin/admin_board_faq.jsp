<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h4>자주묻는질문 관리</h4>

<div class="admin_table_filter">
	<table>
		<caption>검색조건설정</caption>
		<tr>
			<th>기간검색</th>
			<td>
				<span class="date_filter"><a href="#">오늘</a></span> |
				<span class="date_filter"><a href="#">3일</a></span> |
				<span class="date_filter"><a href="#">7일</a></span> |
				<span class="date_filter"><a href="#">1개월</a></span>
				<input type="date"/> ~ <input type="date"/>
			</td>
		</tr>
		<tr>
			<th>분류 선택</th>
			<td>
				<select name="">
   					<option value="">전체</option>
   					<option value="">이용안내</option>
   					<option value="">강의수강</option>
   					<option value="">준비물 키트</option>
   					<option value="">결제/환불</option>
   					<option value="">크리에이터</option>
   					<option value="">기타</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>키워드 검색</th>
			<td>
				<select name="">
   					<option value="">전체</option>
  					<option value="">제목</option>
    				<option value="">내용</option>
				</select>
			<input type="text" size="40"></td>
		</tr>
		<tr>
			<th>처리상태</th>
			<td>
				<lable><input name="board_con" type="radio" value="">전체보기</lable>
			</td><td></td>
		</tr>
	</table>
	<div class="admin_search_btns">
		<button type="button">조회하기</button>
	</div>
</div>

<div class="board_sort_filter">
	<h6 class="admin_search_result">
	[오늘 등록된 새 글 <span class="board_result_count">1</span>건]
	검색결과 <span class="board_result_count">20</span>건
	</h6>
	
	<ul class="admin_search_edit">	
		<li>
			<span class="date_filter"><a href="#">전체선택</a></span>
			<span class="date_filter"><a href="#">수정</a></span>
			<span class="date_filter"><a href="#">삭제</a></span>
		</li>
	</ul>	
	<ul class="admin_search_sort">	
		<li><a href="#">정확도순</a></li>
		<li><a href="#">가나다순</a></li>
		
	</ul>
</div>    


<!-- FAQ -->
<div class="admin_table_wrap">
	<table>
		<tr class="admin_table_head">
			<th width=2%><input type="checkbox"/></th> 
			<th>번호</th> 
			<th>분류</th> 
			<th>글번호</th> 
			<th>분야</th> 
			<th>제목</th> 
			<th>내용</th> 
			<th>미리보기</th> 
		</tr>
		<% for(int i=1; i<=10;i++) {%>
		<tr>
			<td><input type="checkbox"/></td> 
			<td><%=i %></td> 
			<td></td> 
			<td></td> 
			<td></td> 
			<td></td> 
			<td></td>
			<td></td> 
		</tr>
		<% } %>
	</table>
</div>