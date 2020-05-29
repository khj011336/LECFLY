<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h4>강의 영상 관리</h4>
<div class="admin_table_filter">
	<table>
		<caption>검색조건설정</caption>
		<tr class="date_filter">
			<th>영상 등록일 기준 검색</th>
				<input type="hidden" name="pn" value="${(empty param.p)? 1: param.p}"/>
			<td>
				<a href="#" class="day1">오늘</a> |<a href="#" class="day3">3일</a> |
				<a href="#" class="day7">7일</a> |<a href="#" class="month1">1개월</a>&nbsp; 직접설정 
				<input type="date" name="start_date" value="2020-05-01"/> ~ <input type="date" name="end_date" value="2020-05-19"/>
			</td>
		</tr>
		<tr>
			<th>카테고리 선택</th>
			<td>
				<select name="category">
   					<option value="0" ${(param.c == "0")? " selected":"" }>전체</option>
  					<option value="1" ${(param.c == "1")? " selected":"" }>미술</option>
    				<option value="2" ${(param.c == "2")? " selected":"" }>음악</option>
    				<option value="3" ${(param.c == "3")? " selected":"" }>요리</option>
    				<option value="4" ${(param.c == "4")? " selected":"" }>라이프스타일</option>
    				<option value="5" ${(param.c == "5")? " selected":"" }>운동</option>
    				<option value="6" ${(param.c == "6")? " selected":"" }>커리어</option>
    				<option value="7" ${(param.c == "7")? " selected":"" }>여행</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>키워드 검색</th>
			<td>
				<select name="target">
    				<option value="title" ${(param.t == "title")? " selected":""} >영상제목</option>
    				<option value="nickname" ${(param.t == "nickname")? " selected":""} >업로더닉네임</option>
    				<option value="id" ${(param.t == "id")? " selected":""} >영상번호</option>
				</select>
				<input type="text" name="keyword" size="40">
		</tr>
		
	</table>
	<div class="admin_search_btns">
		<button type="button" onclick="location.href='admin_video_list.LF'">상세조회</button>
		<button type="button" onclick="location.href='admin_video_list.LF'">조회하기</button>
	</div>
</div>

<div class="board_sort_filter">
	<h6 class="admin_search_result">
	[현재 페이지 결과 <span class="board_result_count" id="page_result_cnt"><c:out value="${listSize}건" default=""/></span>]
	총 검색결과 <span class="board_result_count" id="all_result_cnt"><c:out value="${totalRecords}건" default=""/></span>
	</h6>
	
	<ul class="admin_search_edit">	
		<li>
			<button class="date_filter" onclick="clickAllCheckBtn()">전체 선택</button>
			<button class="date_filter" onclick="unclickAllCheckBtn()">선택 취소</button> |
			<button class="date_filter" id="delete_video_list">삭제</button>
		</li>
	</ul>	
<!-- 	<ul class="admin_search_sort">	 -->
<%-- 		<li><a href="?p=${pn}&o=1">조회순</a></li> --%>
<%-- 		<li><a href="?p=${pn}&o=2">좋아요순</a></li> --%>
<%-- 		<li><a href="?p=${pn}&o=3">업데이트순</a></li> --%>
<!-- 	</ul> -->
</div>    

<div class="admin_table_wrap">
	<table>
		<tr class="admin_table_head" style="text-align: center">
			<th width=2%><input type="checkbox" id="checkAll" onclick="checkAll()"/></th> 
			<th>순서</th> 
			<th>영상번호</th> 
			<th>업로더 ID</th> 
			<th>카테고리</th> 
			<th>영상제목</th>
			<th>조회수</th>
			<th>좋아요수</th>
			<th>강의 생성날짜</th>
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
