<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h4>강의 관리</h4>

<div class="admin_table_filter">
	<table>
		<caption>검색조건설정</caption>
		<tr>
			<th>클래스 생성 날짜 기준 검색</th>
			<td>
				<span class="date_filter"><a href="#">오늘</a></span> |
				<span class="date_filter"><a href="#">3일</a></span> |
				<span class="date_filter"><a href="#">7일</a></span> |
				<span class="date_filter"><a href="#">1개월</a></span>
				<input type="date"/> ~ <input type="date"/>
			</td>
		</tr>
		<tr>
			<th>카테고리 선택</th>
			<td>
				<select name="">
   					<option value="">전체</option>
  					<option value="">미술</option>
    				<option value="">음악</option>
    				<option value="">요리</option>
    				<option value="">라이프스타일</option>
    				<option value="">운동</option>
    				<option value="">커리어</option>
    				<option value="">여행</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>키워드 검색</th>
			<td>
				<select name="">
   					<option value="">전체</option>
  					<option value="">업로더 아이디</option>
    				<option value="">업로더 닉네임</option>
    				<option value="">강의명</option>
    				<option value="">강의번호</option>
				</select>
			<input type="text" size="40"></td>
		</tr>
		<tr>
			<th>신청상태</th>
			<td>
				<lable><input name="board_con" type="radio" value="">전체보기</lable>
				<lable><input name="board_con" type="radio" value="">승인미완료</lable>
				<lable><input name="board_con" type="radio" value="">승인완료</lable>
			</td><td></td>
		</tr>
	</table>
	<div class="admin_search_btns">
		<button type="button">조회하기</button>
	</div>
</div>

<div class="board_sort_filter">
	<h6 class="admin_search_result">
	[오늘 등록된 정보 <span class="board_result_count">1</span>건]
	검색결과 <span class="board_result_count">20</span>건
	</h6>
	
	<ul class="admin_search_edit">	
		<li>
			<span class="date_filter"><a href="#">전체선택</a></span>
			<span class="date_filter"><a href="#">수정</a></span>
			<span class="date_filter"><a href="#">삭제</a></span>
			<span class="date_filter"><a href="#">저장</a></span>
		</li>
	</ul>	
	<ul class="admin_search_sort">	
		<li><a href="#">정확도순</a></li>
		<li><a href="#">신청일순</a></li>
		<li><a href="#">현재수강생수</a></li>
		<li><a href="#">누적수강생수</a></li>
		<li><a href="#">좋아요수</a></li>
	</ul>
</div>    



<div class="admin_table_wrap">
	<table>
		<tr class="admin_table_head">
			<th width=2%><input type="checkbox"/></th> 
			<th>번호</th> 
			<th>클래스번호</th> 
			<th>업로더 ID</th> 
			<th>카테고리</th> 
			<th>부주제</th> 
			<th>타이틀</th>
			<th>강의 설명</th> 
			<th>승인 진행상태</th>
			<th>수강회원 수</th>
			<th>좋아요수</th>
			<th>좋아요 회원목록</th>
			<th>강의 영상 수</th>
			<th>업데이트 날짜</th>
			<th>클래스 생성날짜</th>
		</tr>
		<% for(int i=1; i<=20;i++) {%>
		<tr>
			<td><input type="checkbox"/></td> 
			<td><%=i %></td> 
			<td></td> 
			<td></td> 
			<td></td>
			<td></td> 
			<td></td> 
			<td></td> 
			<td></td> 
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