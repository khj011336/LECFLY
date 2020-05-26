<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h4>강의 관리</h4>
<div class="admin_table_filter">
	<table>
		<caption>검색조건설정</caption>
		<tr class="date_filter">
			<th>클래스 생성일 기준 검색</th>
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
    				<option value="title" ${(param.t== "title")? " selected":""} >강의명</option>
    				<option value="nickname" ${(param.t == "nickname")? " selected":""} >업로더닉네임</option>
    				<option value="id" ${(param.t == "id")? " selected":""} >강의번호</option>
				</select>
				<input type="text" name="keyword" size="40">
			</td>
		</tr>
		<tr>
			<th>신청상태</th>
			<td>
				<label><input name="status" type="radio" value="4" checked="checked">전체보기</label>
				<label><input name="status" type="radio" value="0">심사중</label>
				<label><input name="status" type="radio" value="1">승인거절</label>
				<label><input name="status" type="radio" value="2">승인요청</label>
				<label><input name="status" type="radio" value="3">승인완료</label>
			</td><td></td>
		</tr>
	</table>
	<div class="admin_search_btns">
		<button type="button" id="search_filter_btn">상세조회</button>
		<button type="button" onclick="location.href='admin_lecture_list.LF'">전체조회</button>
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
			<button class="date_filter" id="update_approval_lecture"> 승인 완료</button>
			<button class="date_filter" id="update_disapproval_lecture">승인거절</button> |
			<button class="date_filter" id="delete_lecture_list">삭제</button>
		</li>
	</ul>	
	<ul class="admin_search_sort">	
		<li><a href="?p=${pn}&o=1">최신순</a></li>
		<li><a href="?p=${pn}&o=2">승인대기순</a></li>
		<li><a href="?p=${pn}&o=3">승인완료순</a></li>
		<li><a href="?p=${pn}&o=4">인기순</a></li>
	</ul>
</div>    

<div class="admin_table_wrap">
	<table id="resultTable">
		<tr class="admin_table_head">
			<th width=2%><input type="checkbox" id="checkAll" onclick="checkAll()"/></th> 
			<th>순서</th> 
			<th>강의번호</th> 
			<th>업로더 닉네임</th> 
			<th>카테고리</th> 
			<th>강의명</th>
			<th>미리보기</th>
			<th>승인 상태</th>
			<th>좋아요 수</th>
			<th>강의 영상 수</th>
			<th>생성일</th>
			<th>업데이트</th>
		</tr>
		<div id="result_records"></div>
		<c:forEach items="${lecList}" var="lec" varStatus="vs">
		<tr>
			<td><input type="checkbox" name="checked" value="${lec.id }"/></td> 
			<td>${vs.count }</td> 
			<td>${lec.id }</td> 
			<td>${lec.nickname }</td> 
			<td>
				<c:choose>
					<c:when test="${lec.category==1}">미술</c:when>
					<c:when test="${lec.category==2}">음악</c:when>
					<c:when test="${lec.category==3}">요리</c:when>
					<c:when test="${lec.category==4}">라이프스타일</c:when>
					<c:when test="${lec.category==5}">운동</c:when>
					<c:when test="${lec.category==6}">커리어</c:when>
					<c:when test="${lec.category==7}">여행</c:when>
				</c:choose>
			</td>
			<td>${lec.title }</td> 
			<td><button style="color:gray">미리보기</button></td> 		
			<c:choose>
				<c:when test="${lec.status == 0}">
					<td name="status" value="0">심사중</td>
				</c:when>
				<c:when test="${lec.status == 1}">
					<td name="status" value="1" style="color: orangered;">승인 거절</td>
				</c:when>
				<c:when test="${lec.status == 2}">
					<td name="status" value="2" style="color: orange;">승인 요청</td>
				</c:when>
				<c:when test="${lec.status == 3}">
					<td name="status" value="3" style="color: #5cb85c;">승인 완료</td>
				</c:when>
			</c:choose>
			<td>${lec.likeCount }</td> 
			<td>${lec.videoTrack }</td> 
			<td><fmt:formatDate value="${lec.createdAt }" pattern="yyyy.MM.dd"/></td> 			
			<td><fmt:formatDate value="${lec.updatedAt }" pattern="yyyy.MM.dd"/></td> 	
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

