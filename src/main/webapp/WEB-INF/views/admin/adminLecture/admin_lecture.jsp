<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
 $(document).ready(function() {
	$("#update_lecture_list").click(function() {
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
			url : "${pageContext.request.contextPath}/admin_update_lecture_list.LF",
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
<h4>강의 관리</h4>

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
  					<option value="">업로더 아이디</option>
    				<option value="">업로더 닉네임</option>
    				<option value="">강의명</option>
    				<option value="">강의번호</option>
				</select>
			<input type="text" size="40"></td>
		</tr>
		<tr>
			<th>신청상태</th>
			<td>
				<label><input name="board_con" type="radio" value="">전체보기</label>
				<label><input name="board_con" type="radio" value="">승인미완료</label>
				<label><input name="board_con" type="radio" value="">승인완료</label>
			</td><td></td>
		</tr>
	</table>
	<div class="admin_search_btns">
		<button type="button" onclick="location.href='admin_lecture_list.LF'">조회하기</button>
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
			<span class="date_filter"><a href="#" id="update_lecture_list">수정</a></span>
			<span class="date_filter"><a href="#">삭제</a></span>
			<span class="date_filter"><a href="#">저장</a></span>
		</li>
	</ul>	
	<ul class="admin_search_sort">	
		<li><a href="#">정확도순</a></li>
		<li><a href="#">신청일순</a></li>
		<li><a href="#">현재수강생수</a></li>
		<li><a href="#">누적수강생수</a></li>
		<li><a href="#">좋아요수</a></li>
	</ul>
</div>    



<div class="admin_table_wrap">
	<table>
		<tr class="admin_table_head">
			<th width=2%><input type="checkbox" id="checkAll" onclick="checkAll()"/></th> 
			<th>번호</th> 
			<th>클래스번호</th> 
			<th>업로더 ID</th> 
			<th>카테고리</th> 
			<th>타이틀</th>
			<th>승인 진행상태</th>
			<th>좋아요수</th>
			<th>강의 영상 수</th>
			<th>클래스 생성날짜</th>
			<th>업데이트 날짜</th>
		</tr>
		<c:forEach items="${lecList}" var="lec" varStatus="vs">
		<tr>
			<td><input type="checkbox" name="checked" value="${lec.id }"/></td> 
			<td>${vs.count }</td> 
			<td>${lec.id }</td> 
			<td>${lec.fid }</td> 
			<td>${lec.category}</td>
			<td>${lec.title }</td> 
			<td>${lec.status }</td> 
			<td>${lec.likeCount }</td> 
			<td>${lec.videoTrack }</td> 
			<td>${lec.createdAt }</td> 
			<td>${lec.updatedAt }</td> 
		</tr>
		</c:forEach>
	</table>
	
	<div id="paginate">
		<c:if test="${pn > 1}">
			<a href="${pageContext.request.contextPath}/admin_lecture_list.LF?pn=${pn-1}">[이전]</a>
		</c:if>
		 &nbsp; &nbsp;
		<c:forEach varStatus="vs" begin="1" end="${maxPn}" step="1">
			<c:if test='${vs.current eq pn}'>
				<b style='color: orange'>${vs.current}</b>
			</c:if>	
			<c:if test='${vs.current ne pn}'>
				<a href="${pageContext.request.contextPath}/admin_lecture_list.LF?pn=${vs.current}">${vs.current}</a>
			</c:if>
			 &nbsp;
			 	
			 ${vs.current eq maxPn ? '': '|'}
		</c:forEach>
		 &nbsp; &nbsp;
		<c:if test="${pn < maxPn}">
			<a href="${pageContext.request.contextPath}/admin_lecture_list.LF?pn=${pn+1}">[다음]</a>
		</c:if>
	</div>
</div>