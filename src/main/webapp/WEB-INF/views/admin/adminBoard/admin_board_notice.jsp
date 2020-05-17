<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
 $(document).ready(function() {
	$("#update_notice_list").click(function() {
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
			url : "${pageContext.request.contextPath}/admin_update_notice_list.LF",
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

<h4>공지내역 관리</h4>

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
  					<option value="">일반 공지사항</option>
    				<option value="">크리에이터 공지사항</option>
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
	</table>
	<div class="admin_search_btns">
		<button type="button" onclick="location.href='admin_board_notice.LF'">상세조회</button>
		<button type="button" onclick="location.href='admin_board_notice.LF'">전체조회</button>
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
			<span class="date_filter"><a href="#">새글 등록</a></span>
		</li>
	</ul>	
	<ul class="admin_search_sort">	
		<li><a href="#">등록일순</a></li>
		<li><a href="#">조회수순</a></li>
		
	</ul>
</div>    

<div class="admin_table_wrap">
	<table>
		<tr class="admin_table_head">
			<th width=2%><input type="checkbox" id="checkAll" onclick="checkAll()"/></th> 
			<th>번호</th> 
			<th>공지사항번호</th> 
			<th>위치</th> 
			<th>제목</th> 
			<th>내용</th>
			<th>작성일</th> 
			<th>갱신일</th> 
			<th>조회수</th> 
			<th>미리보기</th> 
		</tr>
		<c:forEach items="${ntList}" var="nt" varStatus="vs">
		<tr>
			<td><input type="checkbox" name="checked" value="${nt.id }"/></td>  
			<td>${vs.count }</td> 
			<td>${nt.id }</td> 
			<td>${nt.stype }</td> 
			<td>${nt.mbId }</td> 
			<%-- <td>${nt.title }</td>  --%>
			<td>
				<c:choose>
					<c:when test="${fn:length(nt.title) gt 10}"> <%--10글자 이상일 시 --%>
		 		    <c:out value="${fn:substring(nt.title,0,9)}...">
		 		    </c:out></c:when> 
		 		    <c:otherwise>
		 		    <c:out value="${nt.title}">
		 		    </c:out></c:otherwise>
	 		    </c:choose>
			</td>
			<%-- <td>${nt.content}</td>  --%>
			<td>
				<c:choose>
					<c:when test="${fn:length(nt.content) gt 15}"> <%--15글자 이상일 시 --%>
		 		    <c:out value="${fn:substring(cnt.content,0,14)}...">
		 		    </c:out></c:when> 
		 		    <c:otherwise>
		 		    <c:out value="${nt.content}">
		 		    </c:out></c:otherwise>
	 		    </c:choose>
			</td>
			<td>${nt.writedDay }</td> 
			<td>${nt.updatedDay }</td> 
			<td>${nt.hits }</td> 
			<td><button value="미리보기"></button></td> 
		</tr>
		</c:forEach>
	</table>
	<div id="paginate">
		<c:if test="${pn > 1}">
			<a href="${pageContext.request.contextPath}/admin_board_notice.LF?pn=${pn-1}">[이전]</a>
		</c:if>
		 &nbsp; &nbsp;
		<c:forEach varStatus="vs" begin="1" end="${maxPn}" step="1">
			<c:if test='${vs.current eq pn}'>
				<b style='color: orange'>${vs.current}</b>
			</c:if>	
			<c:if test='${vs.current ne pn}'>
				<a href="${pageContext.request.contextPath}/admin_board_notice.LF?pn=${vs.current}">${vs.current}</a>
			</c:if>
			 &nbsp;
			 	
			 ${vs.current eq maxPn ? '': '|'}
		</c:forEach>
		 &nbsp; &nbsp;
		<c:if test="${pn < maxPn}">
			<a href="${pageContext.request.contextPath}/admin_board_notice.LF?pn=${pn+1}">[다음]</a>
		</c:if>
	</div>
</div>