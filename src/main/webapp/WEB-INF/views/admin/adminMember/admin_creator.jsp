<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
 $(document).ready(function() {
	$("#update_creator_list").click(function() {
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
			url : "${pageContext.request.contextPath}/admin_update_creator_list.LF",
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
<h4>크리에이터 관리</h4>

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
    				<option value="" selected="selected">크리에이터</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>키워드 검색</th>
			<td>
				<select name="">
   					<option value="">전체</option>
    				<option value="">크리에이터번호</option>
    				<option value="">닉네임</option>
    				<option value="">상태</option>
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
		<button type="button" onclick="location.href='admin_creator_list.LF'">상세조회</button>
		<button type="button" onclick="location.href='admin_creator_list.LF'">전체조회</button>
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
			<span class="date_filter"><a href="#">수정</a></span>
			<span class="date_filter"><a href="#">삭제</a></span>
			<span class="date_filter"><a href="#">저장</a></span>
		</li>
	</ul>	
	<ul class="admin_search_sort">	
		<li><a href="#">정확도순</a></li>
		<li><a href="#">승인일순</a></li>
		<li><a href="#">최근방문순</a></li>
		
	</ul>
</div>    



<div class="admin_table_wrap">
	<table>
		<tr class="admin_table_head">
			<th width=2%><input type="checkbox" id="checkAll" onclick="checkAll()"/></th> 
			<th>번호</th> 
			<th>크리에이터번호</th> 
			<th>프로필이미지</th> 
			<th>이름</th> 
			<th>닉네임</th> 
			<th>연락처</th> 
			<th>SNS 계정</th> 
			<th>소개</th>
			<th>상태</th>
			<th>승인일</th>
		</tr>
		<c:forEach items="${crList}" var="cr" varStatus="vs">
		<tr>
			<td><input type="checkbox" name="checked" value="${cr.id }"/></td> 
			<td>${vs.count}</td> 
			<td>${cr.id }</td> 
			<%-- <td>${cr.imgPath }</td> --%> 
			<td>
				<c:choose>
					<c:when test="${fn:length(cr.imgPath) gt 10}"> <%--10글자 이상일 시 --%>
		 		    <c:out value="${fn:substring(cr.imgPath,0,9)}...">
		 		    </c:out></c:when> 
		 		    <c:otherwise>
		 		    <c:out value="${cr.imgPath}">
		 		    </c:out></c:otherwise>
	 		    </c:choose>
			</td>
			<td>${cr.name }</td> 
			<td>${cr.nickname }</td> 
			<td>${cr.cellPhone }</td> 
			<td>${cr.SNS }</td> 
			<%-- <td>${cr.info }</td>  --%>
			<td>
				<c:choose>
					<c:when test="${fn:length(cr.info) gt 10}"> <%--10글자 이상일 시 --%>
		 		    <c:out value="${fn:substring(cr.info,0,9)}...">
		 		    </c:out></c:when> 
		 		    <c:otherwise>
		 		    <c:out value="${cr.info}">
		 		    </c:out></c:otherwise>
	 		    </c:choose>
			</td>
			<td>${cr.status }</td> 
			<td>${cr.grantDate }</td> 
		</tr>
		</c:forEach>
	</table>
	<div id="paginate">
		<c:if test="${pn > 1}">
			<a href="${pageContext.request.contextPath}/admin_creator_list.LF?pn=${pn-1}">[이전]</a>
		</c:if>
		 &nbsp; &nbsp;
		<c:forEach varStatus="vs" begin="1" end="${maxPn}" step="1">
			<c:if test='${vs.current eq pn}'>
				<b style='color: orange'>${vs.current}</b>
			</c:if>	
			<c:if test='${vs.current ne pn}'>
				<a href="${pageContext.request.contextPath}/admin_creator_list.LF?pn=${vs.current}">${vs.current}</a>
			</c:if>
			 &nbsp;
			 ${vs.current eq maxPn ? '': '|'}
		</c:forEach>
		 &nbsp; &nbsp;
		<c:if test="${pn < maxPn}">
			<a href="${pageContext.request.contextPath}/admin_creator_list.LF?pn=${pn+1}">[다음]</a>
		</c:if>
	</div>
</div>