<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h4>강의 영상 관리</h4>

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
    				<option value="">영상번호</option>
    				<option value="">업로더 ID</option>
    				<option value="">영상제목</option>
				</select>
			<input type="text" size="40"></td>
		</tr>
		
	</table>
	<div class="admin_search_btns">
		<button type="button" onclick="location.href='admin_video_list.LF'">조회하기</button>
	</div>
</div>

<div class="board_sort_filter">
	<h6 class="admin_search_result">
	[현재 페이지 결과 <span class="board_result_count"><c:out value="${listSize}건" default=""/></span>]
	검색결과 <span class="board_result_count"><c:out value="${totalRecords}건" default=""/></span>
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
		<li><a href="#">조회수순</a></li>
		<li><a href="#">생성일순</a></li>
		<li><a href="#">좋아요순</a></li>
	</ul>
</div>    



<div class="admin_table_wrap">
	<table>
		<tr class="admin_table_head" style="text-align: center">
			<th width=2%><input type="checkbox" id="checkAll" onclick="checkAll()"/></th> 
			<th>번호</th> 
			<th>영상번호</th> 
			<th>업로더 ID</th> 
			<th>카테고리</th> 
			<th>영상제목</th>
			<th>조회수</th>
			<th>좋아요수</th>
			<th>클래스 생성날짜</th>
			<th>업데이트 날짜</th>
		</tr>
		<c:forEach items="${vdList}" var="vd" varStatus="vs">
		<tr style="text-align: center">
			<td><input type="checkbox" name="checked" value="${vd.id }"/></td> 
			<td>${vs.count }</td> 
			<td>${vd.id }</td> 
			<td>${vd.fId }</td> 
			<td>
				<c:choose>
					<c:when test="${vd.category==1}">미술</c:when>
					<c:when test="${vd.category==2}">음악</c:when>
					<c:when test="${vd.category==3}">요리</c:when>
					<c:when test="${vd.category==4}">라이프스타일</c:when>
					<c:when test="${vd.category==5}">운동</c:when>
					<c:when test="${vd.category==6}">커리어</c:when>
					<c:when test="${vd.category==7}">여행</c:when>
				</c:choose>
			</td>
			<td>${vd.title }</td> 
			<td>${vd.views }</td> 
			<td>${vd.likeCount }</td> 
			<td><fmt:formatDate value="${vd.createdAt }" pattern="yyyy년 MM월 dd일"/></td> 			
			<td><fmt:formatDate value="${vd.updatedAt }" pattern="yyyy년 MM월 dd일"/></td>  
		</tr>
		</c:forEach>
	</table>
	<div id="paginate">
		<c:if test="${pn > 1}">
			<a href="${pageContext.request.contextPath}/admin_video_list.LF?pn=${pn-1}">[이전]</a>
		</c:if>
		 &nbsp; &nbsp;
		<c:forEach varStatus="vs" begin="1" end="${maxPn}" step="1">
			<c:if test='${vs.current eq pn}'>
				<b style='color: orange'>${vs.current}</b>
			</c:if>	
			<c:if test='${vs.current ne pn}'>
				<a href="${pageContext.request.contextPath}/admin_video_list.LF?pn=${vs.current}">${vs.current}</a>
			</c:if>
			 &nbsp;
			 	
			 ${vs.current eq maxPn ? '': '|'}
		</c:forEach>
		 &nbsp; &nbsp;
		<c:if test="${pn < maxPn}">
			<a href="${pageContext.request.contextPath}/admin_video_list.LF?pn=${pn+1}">[다음]</a>
		</c:if>
	</div>
</div>