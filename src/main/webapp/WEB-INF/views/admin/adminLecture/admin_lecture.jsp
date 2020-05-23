<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">

function checkCheckbox() {
	if ( $('input[name="checked"]:checked').length == 0 ){
		alert("대상을 선택해주세요.");
		return false;
	} else {
		alert("확인을 누르면 진행됩니다.");
		return true;
	}
};
function formatTable(list) {
	var fmt = '<tr class="admin_table_head" style="text-align: center">'+
		'<th width=2%><input type="checkbox" id="checkAll" onclick="checkAll()"/></th> '+
		'<th>번호</th> '+
		'<th>강의번호</th> '+
		'<th>업로더 ID</th>' +
		'<th>업로더 닉네임</th> '+
		'<th>카테고리</th> '+
		'<th>강의명</th>'+
		'<th>승인 상태</th>'+
		'<th>좋아요 수</th>'+
		'<th>강의 영상 수</th>'+
		'<th>생성일</th>'+
		'<th>업데이트</th>'+
	'</tr>';
	$.each(list, function(i) {
		fmt += '<tr style="text-align: center">';
		fmt += '<td><input type="checkbox" name="checked" value="'+ list[i].id  +'"/></td>';
		fmt += '<td>'+ (i+1) +'</td>';
		fmt += '<td>'+ list[i].id +'</td>';
		fmt += '<td>'+ list[i].fid +'</td>';
		fmt += '<td>'+ list[i].nickname +'</td>';
		switch(list[i].category){
			case 1: fmt += '<td>'+ '미술' +'</td>'; break;
			case 2: fmt += '<td>'+ '음악' +'</td>'; break;
			case 3: fmt += '<td>'+ '요리' +'</td>'; break;
			case 4: fmt += '<td>'+ '라이프스타일' +'</td>'; break;
			case 5: fmt += '<td>'+ '운동' +'</td>'; break;
			case 6: fmt += '<td>'+ '커리어' +'</td>'; break;
			case 7: fmt += '<td>'+ '여행' +'</td>'; break;
			default: fmt += '<td>'+ '없음' +'</td>';
		}
		
		fmt += '<td>'+ list[i].title +'</td>';
		switch(list[i].status){
			case 0: fmt += '<td name="status" value="0">'+ '승인 대기' +'</td>'; break;
			case 1: fmt += '<td name="status" value="1">'+ '승인 완료' +'</td>'; break;
		default: fmt += '<td name="status" value="3">'+ '없음' +'</td>';
		}
		
		fmt += '<td>'+ list[i].likeCount +'</td>';
		fmt += '<td>'+ list[i].videoTrack +'</td>';
		fmt += '<td>'+ longToDate(list[i].createdAt) +'</td>';
		fmt += '<td>'+ longToDate(list[i].updatedAt) +'</td>';
		fmt += '</tr>';
	});
	return fmt;
};
function longToDate(val){  // long 시간 -> date 출력형식변경
	  var date = new Date(val); 
	  var yyyy=date.getFullYear().toString(); 
	  var mm = (date.getMonth()+1).toString();
	  var dd = date.getDate().toString(); 

	  var Str = '';
	  Str += yyyy + '-' + (mm[1] ? mm : '0' + mm[0]) + '-' +(dd[1] ? dd : '0' + dd[0]);
	  return Str;
};
function makePaginate(maxPn){
	var fmt = '';
	for (var i = 0; i < maxPn; i++) {
		fmt += '<a href="#" onclick="movePage(pn)">'+(i+1)+'</a>';
		fmt += '<input type="hidden" name="pn" value="'+ (i+1) +'">';
		if(i < maxPn-1){
			fmt += " | ";
		}
	}
	return fmt;
}
function movePage(pn){
	$(this).on("click", function(){
		$("#search_filter_btn").click();
	});
};

$(document).ready(function() {
	$("#search_filter_btn").on("click", function() {
		
		var URLHD = '${pageContext.request.contextPath}/';
		var url = URLHD+'admin_lecture_list_search.LF';
	
		var pn = $('input[name=pn]').val();
		if(!pn || pn == "" || pn == null || pn == undefined){
			pn = "1";
		}
		var start_date = $('input[name=start_date]').val();
		var end_date = $('input[name=end_date]').val();
		var category = $('select[name=category]').val();
		var search = $('select[name=search]').val();
		var keyword = $('input[name=keyword]').val();
		var status = $('input[name=status]').val();
		
		var params = {
			"pn": pn,	
			"start_date": start_date,
			"end_date": end_date,
			"category": category,
			"search": search,
			"keyword": keyword,
			"status": status
		};
		
		console.log(params);

		$.ajax({
			type:'post',
			contentType: 'application/json',
			data : JSON.stringify(params),
			url:url,
			dataType:'json',
			success:function(res, status, xhr){
				console.log(">> 검색결과");
				console.log(res);
				// 결과 가져오기
				var results = res.lecList;
				var listSize = res.listSize;
				var maxPn = res.maxPn;	
				var totalRecords = res.totalRecords;
				var pn = res.pn;
				// 결과 출력
				$('#page_result_cnt').html(listSize);
				$('#all_result_cnt').html(totalRecords);
				var resultTable = formatTable(results);
				$('#resultTable').html(resultTable);
				var paginate = makePaginate(maxPn);
				$('#paginate').html(paginate);
			},
			error: function(xhr,status){
				console.log(xhr);
				console.log(xhr.status);
				console.log(status);
			}
		});
		
	});
	
	
	$("#update_lecture_list").click(function() {
		if(checkCheckbox() == false){
			return;
		}
		
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
	// 강의 승인 다중처리
	$("#update_approve_lecture").on("click", function() {
		if(checkCheckbox() == false){
			return;
		}
		var status = $('td[name=status]').val();
		console.log(status);
		return;
		// 배열 선언 및 체크된 리스트 저장 
		var checkArray = [];
		
		$('input[name="checked"]:checked').each(function(i) {
			checkArray.push($(this).val());
		});
		
		// 파람으로 보낼 정보들 저장
		var params = {
				"checkList" : checkArray,
				"status": status
		}
		
		// ajax 호출
		$.ajax({
			url : "${pageContext.request.contextPath}/update_approve_lecture.LF",
			type: "post",
			contentType: 'application/json',
			data : JSON.stringify(params),
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
				<span class="date_filter"><a href="#" searchDate="1day">오늘</a></span> |
				<span class="date_filter"><a href="#" searchDate="3day">3일</a></span> |
				<span class="date_filter"><a href="#" searchDate="7day">7일</a></span> |
				<span class="date_filter"><a href="#" searchDate="1month">1개월</a></span>
				<input type="date" name="start_date" value="2020-05-01"/> ~ <input type="date" name="end_date" value="2020-05-19"/>
			</td>
		</tr>
		<tr>
			<th>카테고리 선택</th>
			<td>
				<select name="category">
   					<option value="0">전체</option>
  					<option value="1">미술</option>
    				<option value="2">음악</option>
    				<option value="3">요리</option>
    				<option value="4">라이프스타일</option>
    				<option value="5">운동</option>
    				<option value="6">커리어</option>
    				<option value="7">여행</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>키워드 검색</th>
			<td>
				<select name="search">
   					<option value="all">전체</option>
    				<option value="nickname">업로더닉네임</option>
    				<option value="title">강의명</option>
    				<option value="id">강의번호</option>
				</select>
			<input type="text" name="keyword" size="40"></td>
		</tr>
		<tr>
			<th>신청상태</th>
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
			<span class="date_filter"><a href="#" id="disapproval_lecture_list">승인취소 |</a></span>
			<span class="date_filter"><a href="#" id="update_lecture_list">삭제</a></span>
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
			<th>번호</th> 
			<th>강의번호</th> 
			<th>업로더 ID</th> 
			<th>업로더 닉네임</th> 
			<th>카테고리</th> 
			<th>강의명</th>
			<th>승인 상태</th>
			<th>좋아요 수</th>
			<th>강의 영상 수</th>
			<th>생성일</th>
			<th>업데이트</th>
		</tr>
		
		<c:forEach items="${lecList}" var="lec" varStatus="vs">
		<tr style="text-align: center">
			<td><input type="checkbox" name="checked" value="${lec.id }"/></td> 
			<td>${vs.count }</td> 
			<td>${lec.id }</td> 
			<td>${lec.fid }</td> 
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
			<td><input type="text" value="${lec.title }" name="title" size="90"></input></td> 
			<td>
				<select name="status">
				<c:choose>
					<c:when test="${lec.status == 0}">
						<option value="0" selected="selected">승인 대기</option>
						<option value="1">승인 완료</option>
					</c:when>
					<c:when test="${lec.status == 1}">
						<option value="1" selected="selected">승인 완료</option>
						<option value="0">승인 대기</option>
					</c:when>
				</c:choose>
				</select>
			</td> 
			<td>${lec.likeCount }</td> 
			<td>${lec.videoTrack }</td> 
			<td><fmt:formatDate value="${lec.createdAt }" pattern="yyyy년 MM월 dd일"/></td> 			
			<td><fmt:formatDate value="${lec.updatedAt }" pattern="yyyy년 MM월 dd일"/></td> 			
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
				<input type="hidden" name="pn" value="${vs.current}">
				<b style='color: orange'>${vs.current}</b>
			</c:if>	
			<c:if test='${vs.current ne pn}'>
				<a href="${pageContext.request.contextPath}/admin_lecture_list.LF?pn=${vs.current}">${vs.current}</a>
			</c:if>
			
			 	
			 ${vs.current eq maxPn ? '': '| '}
		</c:forEach>
		 &nbsp; &nbsp;
		<c:if test="${pn < maxPn}">
			<a href="${pageContext.request.contextPath}/admin_lecture_list.LF?pn=${pn+1}">[다음]</a>
		</c:if>
	</div>
</div>