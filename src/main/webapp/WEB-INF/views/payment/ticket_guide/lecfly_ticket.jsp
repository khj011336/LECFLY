<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>TICKET/LECFLY</title>
<link type="text/css" rel="stylesheet" href="resources/css/CScenter/CSCenter.css">
<link type="text/css" rel="stylesheet" href="resources/css/CScenter/receive_board.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	function goPayOrder(intName) { // 카테고리 이용권 1개인지 3개인지 전체인지 1 2 3 들어올예정
		console.log("intName = " + intName);
		var param = "ticName=" + intName;

<script type="text/javascript">
	var gIntName = 0;
	var gTicket = null;
	function showPayMenu(intName) {
		gIntName = intName;

		switch(gIntName) {
			case 1: // 메뉴1
				gTicket = {
						"gdsId": gIntName - 1,
						"gdsName": "1카테고리 회원권",
						"gdType": 0,
						"gdsImgPath": "resources/images/tickets/ticket_0.png",
						"gdsPrice": 12900,
						"gdsCnt": 1
				};
				break;
			case 2:
				gTicket = {
						"gdsId": gIntName - 1,
						"gdsName": "3카테고리 회원권",
						"gdType": 0,
						"gdsImgPath": "resources/images/tickets/ticket_1.png",
						"gdsPrice": 30900,
						"gdsCnt": 1
				};
				break;
			case 3:
				gTicket = {
						"gdsId": gIntName - 1,
						"gdsName": "무제한 회원권",
						"gdType": 0,
						"gdsImgPath": "resources/images/tickets/ticket_2.png",
						"gdsPrice": 49900,
						"gdsCnt": 1
				};
				break;

		}

		location.href = "#lecfly_ticket_modal";
	}
</script>

	}
</script>
<div class="CSsection">
	<div id="CSsec_title">
		<h2>홈페이지 안내</h2>
	</div>
	<div id="CSsec_subtitle">
		<ul>
			<li><h4>
					<a href="lecfly_guide.LF" class="lecfly_info">이용안내</a>
				</h4></li>
			<li><h4>
					<a href="lecfly_ticket.LF" style="background-color: orange"
						class="lecfly_membership_info">회원권</a>
				</h4></li>
		</ul>
	</div>

	<div class="lecflyticket">
		<div id="lecflyis_logo">
			<br>
			<br>
			<h2>
				<img src="resources/imges/logo/LecFly_LOGO_B_C.png">
			</h2>
		</div>
		<div>
			<br>
			<br>
		</div>
		<div id="lecflyticket_maintitle">
			<h1>회원권 안내</h1>
		</div>
		<div id="lecflyticket_noticebox">
			Lecfly는 카테고리별 회원권으로 이용가능합니다.<br> 한개의 회원권으로 카테고리 내 모든 강의를
			수강가능합니다.<br>
			<br> 카테고리 종류 : 음악, 운동, 요리, 미술, 라이프스타일, 커리어, 여행


			<div class="ticket_category">
				<c:forEach items="${categoryMapTicket }" var="tc" varStatus="vs">
					<div class="ticket_category_block">
						<a href="${pageContext.request.contextPath}/search_category.LF?category=${tc.key}" onfocus>
							<div id="category_icon">
								<img src="resources/imges/category/카테고리_${tc.value}.png"
									class="category_1" alt="${ctc.value}">
							</div> <span><c:out value="${tc.value}" /></span>
						</a>
					</div>
				</c:forEach>
			</div>

		</div>

		<div id="lecflyticket_box">
			<span style="color: gray;"> <i class="fas fa-crown fa-5x"></i>
			</span><br>
			<br>
			<br>
			<h3>
				<span style="background-color: lightgray">1 카테고리 회원권</span>
			</h3>
			<br>
			<h4>
				<span>12,900원 / 월</span>
			</h4>
			<br> 7개의 카테고리 중<br>한가지를 선택하여<br>해당 카테고리에 한해<br>무제한으로
			이용 가능합니다.<br>
			<div id="lecflyticket_gopay">
				<h4>
					<a class="lecflyticket" onclick="goPayOrder(1)">바로가기&nbsp;&gt;</a>

				</h4>
			</div>
			<div id="lecfly_ticket_modal" class="overlay">
			<div class="popup">
				<a class="close" href="#">x</a>
			<div class="lecfly_ticket_modal_popup_content">
				<h2 class="mypage_mb_isupdate">이미 등록되어 있는 상품입니다.</h2>
			</div>
			<br>
			<input id="lecfly_ticket_modal_popup_goCart" type="button" value="장바구니 이동">
			<input id="lecfly_ticket_modal_popup_goOrder" type="button" value="결제페이지 이동">
		</div>
		</div>
		</div>

		<div id="lecflyticket_box">
			<span style="color: gray;"> <i class="fas fa-list-ol fa-5x"></i>
			</span><br>
			<br>
			<br>
			<h3>
				<span style="background-color: lightgray">3 카테고리 회원권</span>
			</h3>
			<br>
			<h4>
				<span>30,900원 / 월</span>
			</h4>
			<br> 7개의 카테고리 중<br>세가지를 선택하여<br>해당 카테고리에 한해<br>무제한으로
			이용 가능합니다.
			<div id="lecflyticket_gopay">
				<h4>
					<a class="nav_mypage" onclick="goPayOrder(2)">바로가기&nbsp;&gt;</a>
				</h4>
			</div>
			<div id="lecfly_ticket_modal" class="overlay">
			<div class="popup">
				<a class="close" href="#">x</a>
			<div class="lecfly_ticket_modal_popup_content">
				<h2 class="mypage_mb_isupdate">이미 등록되어 있는 상품입니다.</h2>
			</div>
			<br>
			<input id="lecfly_ticket_modal_popup_goCart" type="button" value="장바구니 이동">
			<input id="lecfly_ticket_modal_popup_goOrder" type="button" value="결제페이지 이동">
		</div>
		</div>
		</div>

		<div id="lecflyticket_box">
			<span style="color: gray;"> <i class="fas fa-infinity fa-5x"></i>
			</span><br>
			<br>
			<br>
			<h3>
				<span style="background-color: lightgray">무제한 회원권</span>
			</h3>
			<br>
			<h4>
				<span>49,900원 / 월</span>
			</h4>
			<br> Lecfly에 업로드된<br>모든 카테고리 강의를<br>무제한으로 이용 가능합니다.<br>&nbsp;
			<div id="lecflyticket_gopay">
				<h4>
					<a onclick="goPayOrder(3)">바로가기&nbsp;&gt;</a>
				</h4>
			</div>
			<div id="lecfly_ticket_modal" class="overlay">
			<div class="popup">
				<a class="close" href="#">x</a>
			<div class="lecfly_ticket_modal_popup_content">
				<h2 class="mypage_mb_isupdate">이미 등록되어 있는 상품입니다.</h2>
			</div>
			<br>
			<input id="lecfly_ticket_modal_popup_goCart" type="button" value="장바구니 이동">
			<input id="lecfly_ticket_modal_popup_goOrder" type="button" value="결제페이지 이동">
		</div>
		</div>
		</div>
	</div>
</div>
<script type="text/javascript">

	// // 카테고리 이용권 1개인지 3개인지 전체인지 1 2 3 들어올예정

		$("#lecfly_ticket_modal_popup_goCart").on("click", function() {
			console.log("gIntName = " + gIntName);
			var URLHD = '${pageContext.request.contextPath}/';
			var url = URLHD+'pay_cart.LF';
			var param = "kitId=" + gIntName + "&gdType=ticket";
			$.ajax({
				type: "POST",
				url: url,
				data: param,
				dataType: "JSON",
				success:function(res, status, xhr) {
					var r = res.c;
					console.log("r = " + r);
					if (r == 0) {
						alert("상품이 등록되었습니다!");
						$("#homemain").load('${pageContext.request.contextPath}' + '/show_cart.LF');
					} else if( r == 1 || r == 2 ) {
						location.href = "#goods_detail_modal";
					} else {
						if( r == 3 )
						$("#homemain").load('${pageContext.request.contextPath}' + '/login.LF');
					}
				},
				error: function(staus, xhr) {
					alert("실패1");
				}
			});
		});

		$("#lecfly_ticket_modal_popup_goOrder").on("click", function() {
			console.log("gIntName = " + gIntName);
			var URLHD = '${pageContext.request.contextPath}/';
			var url = URLHD+'before_order.LF';
// 			var param = "ticName=" + gIntName + "&gdType=ticket";
			var param = "kitName=" + gIntName + "&gdType=ticket";
			$.ajax({
				type: 'POST',
				url: url,
				data: param,
				dataType: "JSON",
				success: function(res, status, xhr) {
					alert("성공2");
					console.log(res);
					console.log(res.result);
					if( res.result == "yes") {
						$.ajax({
							type: 'POST',
							url: '${pageContext.request.contextPath}' + '/pay_order.LF',
							contentType: 'application/json',
							data: JSON.stringify({
									"via" : "fromBaro",
									"size": 1,
									"totalPts": 1,
									"totalPrice": gTicket.gdsPrice,
									"data": [ gTicket ]
							}),
							success: function(res2, status2, xhr2) {
								console.log(res2);
								$('#homemain').html(res2);
							},
							error: function(status2, xhr2) {
								alert("실패");
							}
						});
					}
				},
				error: function(status, xhr) {
					alert("실패");
				}
			});
		});
///////////////////////////////////////////////////////////////////////////////
// 		Debug
// 		$("#lecfly_ticket_modal_popup_goOrder").on("click", function() {
//			console.log("gIntName = " + gIntName);
//			var URLHD = '${pageContext.request.contextPath}/';
//			var url = URLHD+'before_order.LF';
//			var param = "ticName=" + gIntName + "&gdType=ticket";
//			$.ajax({
//				type: 'POST',
//				url: url,
//				data: param,
//				dataType: "JSON",
//				success: function(res, status, xhr) {
//					alert("성공2");
//					console.log(res);
//					console.log(res.result);
//				},
//				error: function(status, xhr) {
//					alert("실패");
//				}
//			});
//		});

	//$('#homemain').html(res);
	//window.location.href = '${pageContext.request.contextPath}' + '/pay_order.LF';
</script>
