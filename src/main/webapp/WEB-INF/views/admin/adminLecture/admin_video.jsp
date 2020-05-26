<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h4>강의 영상 관리</h4>

<div class="admin_table_filter">
	<table>
		<caption>검색조건설정</caption>
		<tr class="date_filter">
			<th>클래스 생성 날짜 기준 검색</th>
				<input type="hidden" name="pn" value="${(empty param.p)? 1: param.p}"/>
			<td>
				<a href="#" class="day1">오늘</a> |<a href="#" class="day3">3일</a> |
				<a href="#" class="day7">7일</a> |<a href="#" class="month1">1개월</a>
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
   					<option value="all" ${(param.f == "all")? " selected":"" }>전체</option>
    				<option value="nickname" ${(param.f == "nickname")? " selected":""} >업로더닉네임</option>
    				<option value="title" ${(param.f == "title")? " selected":""} >영상제목</option>
    				<option value="id" ${(param.f == "id")? " selected":""} >영상번호</option>
				</select>
				<input type="text" name="keyword" size="40">
		</tr>
		
	</table>
	<div class="admin_search_btns">
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
<script type="text/javascript">
$(document).ready(function() {
	// (공통) 대상 선택 했는지 확인
	function checkCheckbox() {
		if ( $('input[name="checked"]:checked').length == 0 ){
			alert("대상을 선택해주세요.");
			return false;
		} else {
			alert("확인을 누르면 진행됩니다.");
			return true;
		}
	};
	// (공통) 검색할 숫자가 한자리인 경우 0 붙이기
	var leadingZeros = function (date, num) {
		 var zero = '';
		 date = date.toString();
		
		 if (date.length < num) {
		  for (i = 0; i < num - date.length; i++)
		   zero += '0';
		 }
		 return zero + date;
	};
	var today = new Date();
	var year = today.getFullYear();
	var month = leadingZeros(today.getMonth()+1, 2);
	var month1ago = leadingZeros(today.getMonth(), 2);
	var date = leadingZeros(today.getDate(), 2);
	var date1ago = leadingZeros(today.getDate()-1, 2);
	var date3ago = leadingZeros(today.getDate()-3, 2);
	var date7ago = leadingZeros(today.getDate()-7, 2);
	var ed= year+"-"+month+"-"+date;
	// (공통) 검색 날짜 세팅 함수
	var filter = document.querySelector('.date_filter td');
	filter.onclick = function(e){
		e.preventDefault();
		var target = e.target;
		
		if(target.nodeName != "A") return;
		if(target.classList.contains("day1")){
			console.log(ed);
			$("input[name='start_date']").val(ed);
			$("input[name='end_date']").val(ed);
		}
		else if (target.classList.contains("day3")){
	 		$("input[name='start_date']").val(year+"-"+month+"-"+date3ago);
			$("input[name='end_date']").val(ed);
		}
		else if (target.classList.contains("day7")){
	 		$("input[name='start_date']").val(year+"-"+month+"-"+date7ago);
			$("input[name='end_date']").val(ed);
		}
		else if(target.classList.contains("month1")){
			$("input[name='start_date']").val(year+"-"+month1ago+"-"+date);
			$("input[name='end_date']").val(ed);
		}
	};
	$("input[name='start_date']").val("2020-01-01");
	$("input[name='end_date']").val(ed);
});
</script>