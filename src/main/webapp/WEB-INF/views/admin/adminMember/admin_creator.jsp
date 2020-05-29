<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h4>크리에이터 관리</h4>

<div class="admin_table_filter">
	<table>
		<caption>검색조건설정</caption>
		<tr class="date_filter">
			<th>승인일 기준 검색</th>
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
					<option value="name" ${(param.t== "name")? " selected":""}>회원명</option>
					<option value="nickname" ${(param.t== "nickname")? " selected":""} >크리에이터 닉네임</option>
				</select>
			<input type="text" name="keyword" size="40">
		</tr>
		<tr>
			<th>신청상태</th>
			<td>
				<label><input name="status" type="radio" value="4" checked="checked">전체보기</label>
				<label><input name="status" type="radio" value="0">심사중</label>
				<label><input name="status" type="radio" value="1">승인거절</label>
				<label><input name="status" type="radio" value="2">승인요청</label>
				<label><input name="status" type="radio" value="3">승인완료</label>
			</td>
		</tr>
	</table>
	<div class="admin_search_btns">
<!-- 		<button type="button" id="search_filter_btn_creator">상세조회</button> -->
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
			<button onclick="clickAllCheckBtn()">전체 선택</button>
			<button onclick="unclickAllCheckBtn()">선택 취소</button> |
<!-- 			<button class="btn_filter" id="update_approval_creator"> 승인 완료</button> -->
<!-- 			<button class="btn_filter" id="update_disapproval_creator">승인거절</button> | -->
			<button class="btn_filter" id="delete_creator_list">삭제</button>
		</li>
	</ul>	
<!-- 	<ul class="admin_search_sort">	 -->
<%-- 		<li><a href="?p=${pn}&o=1">강의많은순</a></li> --%>
<%-- 		<li><a href="?p=${pn}&o=2">승인대기순</a></li> --%>
<%-- 		<li><a href="?p=${pn}&o=3">승인완료순</a></li> --%>
<!-- 	</ul> -->
</div>    


<div class="admin_table_wrap">
	<table>
		<tr class="admin_table_head">
			<th width=2%><input type="checkbox" id="checkAll" onclick="checkAll()"/></th> 
			<th>순서</th> 
			<th>크리에이터번호</th> 
			<th>프로필이미지</th> 
			<th>이름</th> 
			<th>닉네임</th> 
			<th>연락처</th> 
			<th>SNS 계정</th> 
			<th>소개</th>
			<th>요청 상태</th>
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
			<c:choose>
					<c:when test="${cr.status == 0}">
						<td name="status" value="0" style="color: gray;">미신청</td>
					</c:when>
					<c:when test="${cr.status == 1}">
						<td name="status" value="1" style="color: orangered;">승인 거절</td>
					</c:when>
					<c:when test="${cr.status == 2}">
						<td name="status" value="2" style="color: orange;">신규 요청</td>
					</c:when>
					<c:when test="${cr.status == 3}">
						<td name="status" value="3" style="color: #5cb85c;">승인 완료</td>
					</c:when>
				</c:choose>
			<td><fmt:formatDate value="${cr.grantDate}" pattern="yyyy.MM.dd" /></td> 
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