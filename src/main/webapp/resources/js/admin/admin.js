//$(document).ready(function() {
//window.addEventListener("load",function() { 

	// 사이드네비 목록 선택
	$(".sidebar-dropdown > a").click(function() {
		$(".sidebar-submenu").slideUp(200);
		if ($(this).parent().hasClass("active")) {
			$(".sidebar-dropdown").removeClass("active");
			$(this).parent().removeClass("active");
		} else {
			$(".sidebar-dropdown").removeClass("active");
			$(this).next(".sidebar-submenu").slideDown(200);
			$(this).parent().addClass("active");
		}
	});
	
	// 사이드네비 닫기
	$("#close-sidebar").click(function() {
		$(".page-wrapper").removeClass("toggled");
	});
	$("#show-sidebar").click(function() {
		$(".page-wrapper").addClass("toggled");
	});
	function checkAll() {
		if ($("#checkAll").is(':checked')) {
			$("input[name=checked]").prop("checked", true);
		} else {
			$("input[name=checked]").prop("checked", false);
		}
	};
	
	// 전체선택
	function clickAllCheckBtn() {
		$("#checkAll").prop("checked", true);
		checkAll();
	};
	
	// 전체선택취소
	function unclickAllCheckBtn() {
		$("#checkAll").prop("checked", false);
		checkAll();
	};
	
	// (공통) 대상 선택 했는지 확인
	function checkCheckbox() {
		if ( $('input[name="checked"]:checked').length == 0 ){
			alert("대상을 선택해주세요.");
			return false;
		} else {
			var con = confirm("확인을 누르면 진행됩니다.");
			if(con){
				console.log("update process start");
				return true;
			} else {
				console.log("update process cancel");
				return false;
			}
		}
	};
	
	// (공통)long 시간 -> date 출력형식변경
	function longToDate(val){  
		  var date = new Date(val); 
		  var yyyy=date.getFullYear().toString(); 
		  var mm = (date.getMonth()+1).toString();
		  var dd = date.getDate().toString(); 

		  var Str = '';
		  Str += yyyy + '-' + (mm[1] ? mm : '0' + mm[0]) + '-' +(dd[1] ? dd : '0' + dd[0]);
		  return Str;
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

	var check = document.getElementById("checkAll");
	check.onclick = checkAll;
	
//////////////////////////////////////////////////////////// 
	$(".btn_filter").click(function() {
		
		if(checkCheckbox() == false){
			return;
		}
		// 배열 선언 및 체크된 리스트 저장 
		var checkArray = [];		
		$('input[name="checked"]:checked').each(function(i) {
			checkArray.push($(this).val());
		});		
		
		var btn = $(this).attr('id');
		var url = "";
		switch (btn) {
		case "update_approval_lecture":
			url = "admin_update_approval_lecture.LF";
			break;
		case "update_disapproval_lecture":
			url = "admin_update_disapproval_lecture.LF";
			break;
		case "delete_lecture_list":
			url = "admin_delete_lecture_list.LF";
			break;
		case "update_approval_member":
			url = "admin_update_approval_member.LF";
			break;	
		case "update_disapproval_member":
			url = "admin_update_disapproval_member.LF";
			break;	
		case "delete_member_list":
			url = "admin_delete_member_list.LF";
			break;
		case "delete_creator_list":
			url = "admin_delete_creator_list.LF";
			break;		
		default:
			return;
			break;
		}
		$.ajax({
			url : url,
			contentType: 'application/json',
			dataType: "json",
			type: "post",
			data: JSON.stringify(checkArray), 
			success: function(res) {
				console.log(res);
			},
			error: function(request, status, error) {
				console.log("send checkedlist error");
			}
		});
		location.reload();
	});
	
	// 강의 상세 조회
	$("#search_filter_btn").click(function() {
		var p = $("input[name='pn']").val();
		var sd = $("input[name='start_date']").val();
		var ed = $("input[name='end_date']").val();
		var c = $("select[name='category']").val();
		var t = $("select[name='target']").val();
		var k = $("input[name='keyword']").val();
		var s = $("input[name='status']:checked").val();
		// 파람으로 보낼 정보들 저장
		var params = {
				"pn" : p,
				"start_date":sd,
				"end_date":ed,
				"category":c,
				"target":t,
				"keyword":k,
				"status":s
		}
		// ajax 호출
		$.ajax({
			url : "admin_lecture_search.LF",
			contentType: 'application/json',
			dataType: "json",
			type: "post",
			data: JSON.stringify(params), 
			success: function(res) {
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
				$('#paginate').hide();
			},
			error: function(request, status, error) {
				console.log("send searchfilter error");
			}
		});
	});
	// 강의 검색결과 작성
	function formatTable(list) {
		var fmt = '<tr class="admin_table_head" style="text-align: center">'+
			'<th width=2%><input type="checkbox" id="checkAll" onclick="checkAll()"/></th> '+
			'<th>순서</th> '+
			'<th>강의번호</th> '+
			'<th>업로더 닉네임</th> '+
			'<th>카테고리</th> '+
			'<th>강의명</th>'+
			'<th>미리보기</th>'+
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
			fmt += '<td><button style="color:gray">미리보기</button></td>'; 	
			switch(list[i].status){
				case 0: fmt += '<td name="status" value="0">'+ '심사중' +'</td>'; break;
				case 1: fmt += '<td name="status" value="1" style="color: orangered;">'+ '승인 거절' +'</td>'; break;
				case 2: fmt += '<td name="status" value="2" style="color: orange;">'+ '승인 요청' +'</td>'; break;
				case 3: fmt += '<td name="status" value="3" style="color: #5cb85c;">'+ '승인 완료' +'</td>'; break;
			}
		
			fmt += '<td>'+ list[i].likeCount +'</td>';
			fmt += '<td>'+ list[i].videoTrack +'</td>';
			fmt += '<td>'+ longToDate(list[i].createdAt) +'</td>';
			fmt += '<td>'+ longToDate(list[i].updatedAt) +'</td>';
			fmt += '</tr>';
		});
		return fmt;
	};

//	$("input[name=adminsearch]").keydown(function(e){
//	if (e.keyCode === 13) {
//	var currentVal = $(this).val();
//	console.log(currentVal);
//	var selector = "p:contains("+ currentVal +")";
//	$(selector).cilck;
//	}
//});
//});	