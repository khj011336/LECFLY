<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h4>쿠폰 관리</h4>

<div class="admin_table_filter">
	<table>
		<caption>검색조건설정</caption>
		<tr class="date_filter">
			<th>생성일 기준 검색</th>
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
    				<option value="title" ${(param.t== "title")? " selected":""} >쿠폰명</option>
    				<option value="nickname" ${(param.t == "nickname")? " selected":""} >쿠폰번호</option>
				</select>
				<input type="text" name="keyword" size="40">
			</td>
		</tr>
		<tr>
			<th>사용여부</th>
			<td>
				<label><input name="status" type="radio" value="3" checked="checked">전체보기</label>
				<label><input name="status" type="radio" value="0">승인미완료</label>
				<label><input name="status" type="radio" value="1">승인완료</label>
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
			<span class="date_filter"><a href="#" onclick="clickAllCheckBtn()">| 전체선택</a></span>
			<span class="date_filter"><a href="#" onclick="unclickAllCheckBtn()">선택취소 |</a></span>
			<span class="date_filter"><a href="#" id="update_approve_lecture"> 승인처리</a></span>
			<span class="date_filter"><a href="#" id="update_disapproval_lecture">승인취소 |</a></span>
			<span class="date_filter"><a href="#" id="delete_lecture_list">삭제</a></span>
		</li>
	</ul>	
	<ul class="admin_search_sort">	
		<li><a href="#" sort="status,asc">승인대기순</a></li>
		<li><a href="#" sort="id,desc">생성일순</a></li>
		<li><a href="#" sort="video_track,desc">영상많은순</a></li>
		<li><a href="#" sort="like_count,desc">좋아요순</a></li>
	</ul>
</div>    



<div class="admin_table_wrap">
	<table id="resultTable">
		<tr class="admin_table_head" style="text-align: center">
			<th width=2%><input type="checkbox" id="checkAll" onclick="checkAll()"/></th> 
			<th>순서</th> 
			<th>쿠폰번호</th> 
			<th>쿠폰명</th> 
			<th>적용대상</th> 
			<th>보유회원</th> 
			<th>사용여부</th>
			<th>할인금액</th>
			<th>생성일</th>
			<th>종료일</th>
		</tr>
		
		<c:forEach items="${cpList}" var="cp" varStatus="vs">
		<tr style="text-align: center">
			<td><input type="checkbox" name="checked" value="${lec.id }"/></td> 
			<td>${vs.count}</td> 
			<td>${cp.code}</td> 
			<td>${cp.couponName}</td> 
			<td>${cp.applyTo}</td> 
			<td>${cp.mbId}</td> 
			<td>${cp.useCheck}</td> 
			<td>${cp.discount}</td> 	
			<td><fmt:formatDate value="${cp.createdDay }" pattern="yyyy년 MM월 dd일"/></td> 			
			<td><fmt:formatDate value="${cp.endDay }" pattern="yyyy년 MM월 dd일"/></td> 			
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
