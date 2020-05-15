<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h4>결제내역 조회</h4>

<div class="admin_table_filter">
	<table>
		<caption>검색조건설정</caption>
		<tr>
			<th>날짜 검색</th>
			<td>
				<span class="date_filter"><a href="#">오늘</a></span> |
				<span class="date_filter"><a href="#">3일</a></span> |
				<span class="date_filter"><a href="#">7일</a></span> |
				<span class="date_filter"><a href="#">1개월</a></span>
				<input type="date"/> ~ <input type="date"/>
			</td>
		</tr>
		<tr>
			<th>상품 종류</th>
			<td>
				<select name="">
   					<option value="">전체</option>
  					<option value="">이용권</option>
    				<option value="">키트</option>
    				<option value="">펀딩</option>
    			</select>
			</td>
		</tr>
		<tr>
			<th>결제 종류</th>
			<td>
				<select name="">
   					<option value="">결제 완료</option>
  					<option value="">결제 대기</option>
    				<option value="">결제 취소</option>
    			</select>
			</td>
		</tr>
		<tr>
			<th>키워드 검색</th>
			<td>
				<select name="">
					<option value="">상품코드</option>
   					<option value="">상품명</option>
  					<option value="">판매자</option>
  					<option value="">구매자</option>
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
		<button type="button">조회하기</button>
	</div>
</div>

<div class="board_sort_filter">
	<h6 class="admin_search_result">
	[오늘 등록된 정보 <span class="board_result_count">1</span>건]
	검색결과 <span class="board_result_count">20</span>건
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
		<li><a href="#">결제일순</a></li>
	</ul>
</div>    



<div class="admin_table_wrap">
	<table>
		<tr class="admin_table_head">
			<th width=2%><input type="checkbox" id="checkAll" onclick="checkAll()"/></th> 
			<th>번호</th> 
			<th>결제번호</th> 
			<th>구매회원 ID</th> 
			<th>판매회원 ID</th> 
			<th>종류</th> 
			<th>상품명</th>
			<th>결제수단</th> 
			<th>총 결제금액</th>
			<th>배송상태</th>
			<th>결제날짜</th>
		</tr>
		<c:forEach items="${payList}" var="pay" varStatus="vs">
		<tr>
			<td><input type="checkbox" name="checked" value="${pay.id}"/></td> 
			<td>${vs.count }</td> 
			<td>${pay.id }</td> 
			<td>${pay.buyMbId }</td> 
			<td>${pay.selMbId }</td>
			<td>${pay.goodsType }</td> 
			<td>${pay.goodsId }</td> 
			<td>${pay.payWay }</td> 
			<td>${pay.payHistorySum }</td> 
			<td>${pay.deliveryStatus }</td> 
			<td>${pay.dealDay }</td> 
		</tr>
		</c:forEach>
	</table>
</div>