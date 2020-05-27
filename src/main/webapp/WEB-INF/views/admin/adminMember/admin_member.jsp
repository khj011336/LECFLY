<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
 $(document).ready(function() {
	$("#update_member_list").click(function() {
		// 배열 선언 및 체크된 리스트 저장 
		var checkArray = [];
		$('input[name="checked"]:checked').each(function(i) {
			checkArray.push($(this).val());
		});
		
		// 파람으로 보낼 정보들 저장
		var params = {
				"checkList" : checkArray
		}
		
		// ajax 호출
		$.ajax({
			url : "${pageContext.request.contextPath}/admin_update_member_list.LF",
			dataType: "json",
			type: "post",
			data: params, 
			success: function(res) {
				console.log(res);
			},
			error: function(request, status, error) {
				console.log("send checkedlist error");
			}
		});
	});
});

</script>

<h4>회원 관리</h4>

<div class="admin_table_filter">
	<table>
		<caption>검색조건설정</caption>
		<tr class="date_filter">
			<th>계정 등록일 기준 검색</th>
				<input type="hidden" name="pn" value="${(empty param.p)? 1: param.p}"/>
			<td>
				<a href="#" class="day1">오늘</a> |<a href="#" class="day3">3일</a> |
				<a href="#" class="day7">7일</a> |<a href="#" class="month1">1개월</a>
				<input type="date" name="start_date" value="2020-05-01"/> ~ <input type="date" name="end_date" value="2020-05-19"/>
			</td>
		</tr>
		<tr>
			<th>키워드 검색</th>
			<td>
				<select name="target">
   					<option value="">전체</option>
  					<option value="">아이디</option>
    				<option value="">닉네임</option>
    				<option value="">연락처</option>
    				<option value="">회원번호</option>
				</select>
			<input name="keyword" type="text" size="40"></td>
		</tr>
		<tr>
			<th>크리에이터 신청 여부</th>
			<td>
				<lable><input name="check_creator" type="radio" value="4" checked="checked">전체보기</lable>
				<lable><input name="check_creator" type="radio" value="0">미신청(일반회원)</lable>
				<lable><input name="check_creator" type="radio" value="1">요청 반려</lable>
				<lable><input name="check_creator" type="radio" value="2">신규 요청</lable>
				<lable><input name="check_creator" type="radio" value="3">처리 완료(크리에이터)</lable>
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
	<table style="text-align: center">
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
				<td>
					<c:choose>
						<c:when test="${mb.gender==1}">여성</c:when>
						<c:when test="${mb.gender==3}">남성</c:when>
					</c:choose>
				</td> 
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