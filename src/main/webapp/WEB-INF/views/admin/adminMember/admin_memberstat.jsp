<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h4>회원 통계</h4>

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
  					<option value="">회원</option>
    				<option value="">크리에이터</option>
    				<option value="">관리자</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>키워드 검색</th>
			<td>
				<select name="">
   					<option value="">전체</option>
  					<option value="">아이디</option>
    				<option value="">닉네임</option>
    				<option value="">연락처</option>
    				<option value="">회원번호</option>
				</select>
			<input type="text" size="40"></td>
		</tr>
		<tr>
			<th>신청상태</th>
			<td>
				<lable><input name="board_con" type="radio" value="">전체보기</lable>
				<lable><input name="board_con" type="radio" value="">미신청</lable>
				<lable><input name="board_con" type="radio" value="">신청</lable>
				<lable><input name="board_con" type="radio" value="">승인미완료</lable>
				<lable><input name="board_con" type="radio" value="">승인완료</lable>
			</td><td></td>
		</tr>
	</table>
	<div class="admin_search_btns">
		<button type="button" onclick="location.href='admin_member_list.LF'">상세조회</button>
		<button type="button" onclick="location.href='admin_member_list.LF'">전체조회</button>
	</div>
</div>

<div class="board_sort_filter">
	<h6 class="admin_search_result">
	[현재 페이지 결과 <span class="board_result_count"><c:out value="${listSize}건" default=""/></span>]
	총 검색결과 <span class="board_result_count"><c:out value="${totalRecords}건" default=""/></span>
	</h6>
	
	<ul class="admin_search_edit">	
		<li>
			<span class="date_filter"><a href="#">전체선택</a></span>
			<span class="date_filter"><a href="#" id="update_member_list">수정</a></span>
			<span class="date_filter"><a href="#">삭제</a></span>
			<span class="date_filter"><a href="#">저장</a></span>
		</li>
	</ul>	
	<ul class="admin_search_sort">	
		<li><a href="#">정확도순</a></li>
		<li><a href="#">가입일순</a></li>
		<li><a href="#">최근방문순</a></li>
		
	</ul>
</div>    

<div class="admin_table_wrap">
	<table>
		<tr class="admin_table_head">
			<th width=2%><input type="checkbox" id="checkAll" onclick="checkAll()"/></th> 
			<th>번호</th> 
			<th>회원번호</th> 
			<th>이름</th> 
			<th>닉네임</th> 
			<th>생년월일</th>
			<th>성별</th> 
			<th>이메일</th> 
			<th>연락처</th> 
			<th>가입일</th>
			<th>이용권</th>
			<th>업로더신청</th>
			<th>최근방문일</th>
		</tr>
		<c:forEach items="${mbList}" var="mb" varStatus="vs">
			<tr>
				<td><input type="checkbox" name="checked" value="${mb.id}"/></td> 
				<td>${vs.count }</td> 
				<td>${mb.id }</td> 
				<td>${mb.name }</td> 
				<td>${mb.nicname }</td> 
				<td><fmt:formatDate value="${mb.birthday}" pattern="yyyy.MM.dd" /></td>
				<td>${mb.gender }</td> 
				<td>${mb.email }</td> 
				<td>${mb.phNumber }</td> 
				<td><fmt:formatDate value="${mb.joinedAt}" pattern="yyyy.MM.dd" /></td>
				<td>${mb.useTicket }</td> 
				<td>${mb.checkCreator }</td> 
				<td><fmt:formatDate value="${mb.loginedAt}" pattern="yyyy.MM.dd" /></td> 
			</tr>
		</c:forEach>
	</table>
	<div id="paginate">
		<c:if test="${pn > 1}">
			<a href="${pageContext.request.contextPath}/admin_member.LF?pn=${pn-1}">[이전]</a>
		</c:if>
		 &nbsp; &nbsp;
		<c:forEach varStatus="vs" begin="1" end="${maxPn}" step="1">
			<c:if test='${vs.current eq pn}'>
				<b style='color: orange'>${vs.current}</b>
			</c:if>	
			<c:if test='${vs.current ne pn}'>
				<a href="${pageContext.request.contextPath}/admin_member.LF?pn=${vs.current}">${vs.current}</a>
			</c:if>
			 &nbsp;
			 	
			 ${vs.current eq maxPn ? '': '|'}
		</c:forEach>
		 &nbsp; &nbsp;
		<c:if test="${pn < maxPn}">
			<a href="${pageContext.request.contextPath}/admin_member.LF?pn=${pn+1}">[다음]</a>
		</c:if>
	</div>
</div>