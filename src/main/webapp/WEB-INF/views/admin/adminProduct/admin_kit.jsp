<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h4>키트 관리</h4>

<div class="admin_table_filter">
	<table>
		<caption>검색조건설정</caption>
		<tr class="date_filter">
			<th>등록일 기준 검색</th>
				<input type="hidden" name="pn" value="${(empty param.p)? 1: param.p}"/>
			<td>
				<a href="#" class="day1">오늘</a> |<a href="#" class="day3">3일</a> |
				<a href="#" class="day7">7일</a> |<a href="#" class="month1">1개월</a>&nbsp; 직접설정 
				<input type="date" name="start_date" value="2020-05-01"/> ~ <input type="date" name="end_date" value="2020-05-19"/>
			</td>
		</tr>
<!-- 		<tr> -->
<!-- 			<th>상품 종류</th> -->
<!-- 			<td> -->
<!-- 				<select name=""> -->
<!--    					<option value="">전체</option> -->
<!--   					<option value="">이용권</option> -->
<!--     				<option value="">키트</option> -->
<!--     				<option value="">펀딩</option> -->
<!--     			</select> -->
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<th>결제 종류</th> -->
<!-- 			<td> -->
<!-- 				<select name=""> -->
<!--    					<option value="">결제 완료</option> -->
<!--   					<option value="">결제 대기</option> -->
<!--     				<option value="">결제 취소</option> -->
<!--     			</select> -->
<!-- 			</td> -->
<!-- 		</tr> -->
		<tr>
			<th>키워드 검색</th>
			<td>
				<select name="">
					<option value="">상품코드</option>
   					<option value="">상품명</option>
  					<option value="">판매자</option>
  					<option value="">구매자</option>
    			</select>
				<input type="text" name="keyword" size="40">
			</td>
		</tr>
<!-- 		<tr> -->
<!-- 			<th>신청상태</th> -->
<!-- 			<td> -->
<!-- 				<lable><input name="board_con" type="radio" value="">전체보기</lable> -->
<!-- 				<lable><input name="board_con" type="radio" value="">승인미완료</lable> -->
<!-- 				<lable><input name="board_con" type="radio" value="">승인완료</lable> -->
<!-- 			</td><td></td> -->
<!-- 		</tr> -->
	</table>
	<div class="admin_search_btns">
		<button type="button" onclick="location.href='admin_kit_list.LF'">상세조회</button>
		<button type="button" onclick="location.href='admin_kit_list.LF'">전체조회</button>
	</div>
</div>

<div class="board_sort_filter">
	<h6 class="admin_search_result">
	[현재 페이지 결과 <span class="board_result_count" id="page_result_cnt"><c:out value="${listSize}건" default=""/></span>]
	총 검색결과 <span class="board_result_count" id="all_result_cnt"><c:out value="${totalRecords}건" default=""/></span>
	</h6>
	
	<ul class="admin_search_edit">	
		<li>
			<button onclick="clickAllCheckBtn()">전체 선택</button>
			<button onclick="unclickAllCheckBtn()">선택 취소</button> |
			<button class="btn_filter" id="">삭제</button>
		</li>
	</ul>	
	<ul class="admin_search_sort">	
<!-- 		<li><a href="#">정확도순</a></li> -->
<!-- 		<li><a href="#">결제일순</a></li> -->
	</ul>
</div>    



<div class="admin_table_wrap">
	<table>
		<tr class="admin_table_head">
			<th width=2%><input type="checkbox" id="checkAll" onclick="checkAll()"/></th> 
			<th>순서</th> 
			<th>키트번호</th> 
			<th>키트소유 ID</th> 
			<th>클래스 ID</th> 
			<th>카테고리</th> 
			<th>상품명</th>
			<th>판매금액</th>
			<th>배송비</th>
		</tr>
		<c:forEach items="${kitList}" var="kit" varStatus="vs">
		<tr>
			<td><input type="checkbox" name="checked" value="${kit.id}"/></td> 
			<td>${vs.count }</td> 
			<td>${kit.id }</td> 
			<td>${kit.fId }</td> 
			<td>${kit.CFId }</td> 
			<td>
				<c:choose>
					<c:when test="${kit.category==1}">미술</c:when>
					<c:when test="${kit.category==2}">음악</c:when>
					<c:when test="${kit.category==3}">요리</c:when>
					<c:when test="${kit.category==4}">라이프스타일</c:when>
					<c:when test="${kit.category==5}">운동</c:when>
					<c:when test="${kit.category==6}">커리어</c:when>
					<c:when test="${kit.category==7}">여행</c:when>
				</c:choose>
			</td>
			<td>${kit.title }</td> 
			<td>${kit.price }</td> 
			<td>${kit.deliveryPrice }</td> 
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