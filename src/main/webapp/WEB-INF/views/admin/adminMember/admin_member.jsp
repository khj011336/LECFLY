<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h4>회원 관리</h4>

<div class="admin_table_filter">
	<table>
		<caption>검색조건설정</caption>
		<tr class="date_filter">
			<th>가입일 기준 검색</th>
				<input type="hidden" name="pn" value="${(empty param.p)? 1: param.p}"/>
			<td>
				<a href="#" class="day1">오늘</a> |<a href="#" class="day3">3일</a> |
				<a href="#" class="day7">7일</a> |<a href="#" class="month1">1개월</a>&nbsp; 직접설정 
				<input type="date" name="start_date" value="2020-05-01"/> ~ <input type="date" name="end_date" value="2020-05-19"/>
			</td>
		</tr>
		<tr>
			<th>키워드 검색</th>
			<td>
				<select name="target">
					<option value="name" ${(param.t == "name")? " selected":""} >회원명</option>
					<option value="email" ${(param.t == "email")? " selected":""} >이메일</option>
					<option value="pn_number" ${(param.t == "pn_number")? " selected":""} >연락처</option>
				</select>
				<input type="text" name="keyword" size="40">
			</td>
		</tr>
		<tr>
<!-- 			<th>크리에이터 신청 여부</th> -->
<!-- 			<td> -->
<!-- 				<lable><input name="check_creator" type="radio" value="4" checked="checked">전체보기</lable> -->
<!-- 				<lable><input name="check_creator" type="radio" value="0">일반회원</lable> -->
<!-- 				<lable><input name="check_creator" type="radio" value="1">요청 취소</lable> -->
<!-- 				<lable><input name="check_creator" type="radio" value="2">신규 요청</lable> -->
<!-- 				<lable><input name="check_creator" type="radio" value="3">크리에이터</lable> -->
<!-- 			</td><td></td> -->
		</tr>
	</table>
	<div class="admin_search_btns">
<!-- 		<button type="button" id="search_filter_btn_member">상세조회</button> -->
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
			<button onclick="clickAllCheckBtn()">전체 선택</button>
			<button onclick="unclickAllCheckBtn()">선택 취소</button> |
			<button class="btn_filter" id="update_approval_member"> 승인 완료</button> 
			<button class="btn_filter" id="update_disapproval_member">승인 취소</button> |
			<button class="btn_filter" id="delete_member_list">삭제</button>
		</li>
	</ul>	
	<ul class="admin_search_sort">	
		<li><a href="?p=${pn}&o=1">신규가입순</a></li>
		<li><a href="?p=${pn}&o=2">승인대기순</a></li>
		<li><a href="?p=${pn}&o=3">승인완료순</a></li>
	</ul>
</div>    

<div class="admin_table_wrap">
	<table style="text-align: center">
		<tr class="admin_table_head">
			<th width=2%><input type="checkbox" id="checkAll" onclick="checkAll()"/></th> 
			<th>순서</th> 
			<th>회원번호</th> 
			<th>이름</th> 
			<th>닉네임</th> 
			<th>생년월일</th>
			<th>성별</th> 
			<th>아이디(이메일)</th> 
			<th>연락처</th> 
			<th>이용권</th>
			<th>크리에이터 요청</th>
			<th>가입일</th>
			<th>최근 방문일</th>
		</tr>
		<c:forEach items="${mbList}" var="mb" varStatus="vs">
			<tr>
				<td><input type="checkbox" name="checked" value="${mb.id}"/></td> 
				<td>${vs.count }</td> 
				<td>${mb.id }</td> 
				<td>${mb.name }</td> 
				<td>${mb.nicname }</td> 
				<td><fmt:formatDate value="${mb.birthday}" pattern="yyyy.MM.dd" /></td>
				<td>
					<c:choose>
						<c:when test="${mb.gender==1}">여성</c:when>
						<c:when test="${mb.gender==2}">관리자</c:when>
						<c:when test="${mb.gender==3}">남성</c:when>
					</c:choose>
				</td> 
				<td>${mb.email }</td> 
				<td>${mb.phNumber }</td> 
				<td>
				<c:choose>
					<c:when test="${mb.useTicket==0}">없음</c:when>
					<c:when test="${mb.useTicket==1}">1 카테고리 이용권</c:when>
					<c:when test="${mb.useTicket==2}">3 카테고리 이용권</c:when>
					<c:when test="${mb.useTicket==3}">무제한 이용권</c:when>
				</c:choose>
				</td> 
				<c:choose>
					<c:when test="${mb.checkCreator == 0}">
						<td name="status" value="0" style="color: gray;">미신청</td>
					</c:when>
					<c:when test="${mb.checkCreator == 1}">
						<td name="status" value="1" style="color: orange;">신규 요청</td>
					</c:when>
					<c:when test="${mb.checkCreator == 2}">
						<td name="status" value="2" style="color: orangered;">승인 거절</td>
					</c:when>
					<c:when test="${mb.checkCreator == 3}">
						<td name="status" value="3" style="color: #5cb85c;">승인 완료</td>
					</c:when>
				</c:choose>
				<td><fmt:formatDate value="${mb.joinedAt}" pattern="yyyy.MM.dd" /></td>
				<td><fmt:formatDate value="${mb.loginedAt}" pattern="yyyy.MM.dd" /></td> 
			</tr>
		</c:forEach>
	</table>
	<div id="paginate">
		<c:if test="${pn > 1}">
			<a href="?p=${pn-1}">[이전]</a>
		</c:if>
		<c:if test="${pn <= 1}">
			<span>[이전]</span>
		</c:if> &nbsp;&nbsp;
		<c:forEach varStatus="vs" begin="1" end="${maxPn}" step="1">
			<c:if test='${vs.current eq pn}'>
				<b style='color: orange'>${vs.current}</b>
			</c:if>	
			<c:if test='${vs.current ne pn}'>
				<a href="?p=${vs.current}">${vs.current}</a>
			</c:if>			 	
			 ${vs.current eq maxPn ? '': '| '}
		</c:forEach> &nbsp; &nbsp;
		<c:if test="${pn < maxPn}">
			<a href="?p=${pn+1}">[다음]</a>
		</c:if>
		<c:if test="${pn > maxPn}">
			<span>[다음]</span>
		</c:if>
	</div>
</div>