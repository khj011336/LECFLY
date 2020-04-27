<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="paymentFinished_wrapper">
	<div id="paymentFinished_content">
		<div class="paymentFinished_title_box">
			<h1 class="paymentFinished_title">결제완료</h1>
			<h3 class="paymentFinished_subtitle">
				<span class="basket">장바구니</span> <span class="order_sheet">&gt;
					주문서</span> <span class="order_finish">&gt; 주문완료</span>
			</h3>
		</div>
		<div id="finished_wrapper">
		<div class="finished_background">
			<div class="finished_backgroundInfo">
				<div class="finished_backgroundInfo2">
					<a href="javascript:void(0);" onclick="mainpage();" target="_self">
						<img class="finished_img"
						src="resource/img/logo/LecFly_LOGO_B_C.png"
						alt="LecFly">
						
					</a>
				</div>
				<div class="finished_font">
					주문이 정상적으로 <strong style="color: orange">완료</strong>되었습니다.
				</div>
				<a class="finished_orderdelivery"
					href="javascript:void(0);" onclick="mypageDelivery();"target="_self"> 주문배송조회 </a>
			</div>
		</div>
		<div id="orderInfo_title">주문 정보</div>
		<div class="orderInfo_box">
			<table class="orderInfo_table">
				<tbody>
					<tr>
						<th class="orderInfo_table_th">주문자</th>
						<td class="orderInfo_table_td">김건우</td>
					</tr>
					<tr>
						<th class="orderInfo_table_th">주문일자</th>
						<td class="orderInfo_table_td"><strong>2020.04.20</strong></td>
					</tr>
					<tr>
						<th class="orderInfo_table_th">주문번호</th>
						<td class="orderInfo_table_td"><strong
							style="color: #babc00;">Y1706060474490</strong></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div id="deliveryGoodsInfo_title">배송상품 정보</div>
		<div class="deliveryGoods_set">
			<a class="deliveryGoods_img" target="_self"
				href="javascript:void(0);" onclick="fundingItem();">
				<img src="resource/img/payment/working out.jpg" width="85" height="85" alt="다이어트 패키지">
			</a>
			<div class="deliveryGoods_imgInfo">
				<a class="deliveryGoods_a" target="_self"
					href="javascript:void(0);" onclick="fundingItem();">
					<strong>운동</strong><br>다이어트 패키지
					&lt홈트의 재정의&gt 다이어트 패키지
				</a>
				<div class="deliveryGoods_cnt">구매수량 : 1 개</div>
				<div>
					<span class="deliveryGoods_discount"> 5,000<em
						style="display: inline-block; color: #b0b0b0; font-style: normal; font-size: 12px; vertical-align: 1px;">원</em>
					</span> <span class="deliveryGoods_price"> 30,000<em
						class="korean_point">원</em>
					</span>
				</div>
			</div>
		</div>
		<div class="deliveryGoods_set">
			<a class="deliveryGoods_img" target="_self"
				href="javascript:void(0);" onclick="fundingItem2();">
				<img src="resource/img/payment/soap.jpg" width="85" height="85" alt="나를 위한 천연비누">
			</a>
			<div class="deliveryGoods_imgInfo">
				<a class="deliveryGoods_a" target="_self"
					href="javascript:void(0);" onclick="fundingItem2();">
					<strong>라이프 스타일</strong><br>LOVE YOUR LIFE 나를 위한 천연비누
				</a>
				<div class="deliveryGoods_cnt">구매수량 : 1 개</div>
				<div>
					<span class="deliveryGoods_price">18,000<em
						class="korean_point">원</em></span>
				</div>
			</div>
		</div>
		<div class="deliveryGoods_set">
			<a class="deliveryGoods_img" target="_self"
				href="javascript:void(0);" onclick="fundingItem2();">
				<img src="resource/img/payment/cooking.jpg" width="85" height="85" alt="">
			</a>
			<div class="deliveryGoods_imgInfo">
				<a class="deliveryGoods_a" target="_self"
					href="javascript:void(0);" onclick="fundingItem2();">
				 	<strong>쿠킹</strong><br>내 상황에 딱 맞는 쿠킹 클래스
				</a>
				<div class="deliveryGoods_cnt">구매수량 : 1 개</div>
				<div class="deliveryGoods_price">
					<span class="deliveryGoods_price">23,000<em
						class="korean_point">원</em></span>
				</div>
			</div>
		</div>
		<div id="deliveryInfo_title">배송지 정보</div>
		<div class="deliveryplace_set">
			<table class="deliveryInfo_table">
				<tbody>
					<tr>
						<th th colspan="1" rowspan="1" scope="row"
							class="deliveryInfo_table_th">받는분</th>
						<td class="deliveryInfo_table_td">김건우</td>
					</tr>
					<tr>
						<th class="deliveryInfo_table_th">연락처</th>
						<td class="deliveryInfo_table_td"><span>010-6546-5634</span>
						</td>
					</tr>
					<tr>
						<th class="deliveryInfo_table_th">주소</th>
						<td class="deliveryInfo_table_td">경기도 부천시 원미로 144번길 51 101동 1704호</td>
					</tr>
					<tr>
						<th class="deliveryInfo_table_th">택배 메세지</th>
						<td class="deliveryInfo_table_td">배송전에 연락주세요.</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div id="paymentInfo_title">결제 정보</div>
		<div class="paymentInfo_set">
			<div>
				<div class="paymentInfo_sumprice">
					<strong>총 상품금액</strong> <span class="sumGoods_price">71,000<em
						class="korean_point">원</em></span>
				</div>
				<div class="paymentInfo_sumprice">
					<strong>총 배송비</strong> <span class="sumDelivery_price">0<em
						class="korean_point">원</em></span>
				</div>
			</div>
			<div>
				<div class="paymentInfo_sumprice">
					<strong>쿠폰</strong> <span class="point_discountprice">-
						1,500<em class="korean_point">원</em>
					</span>
				</div>
			</div>
			<div class="paymentInfo_sumprice">
				<div>
					<strong style="color: #ff2828;">총 결제금액</strong> <span
						class="sum_paymentPrice"> 69,500<em class="korean_point">원</em>
					</span>
				</div>
			</div>
			<div>
				<div class="paymentInfo_sumprice">
					<strong> 결제수단 </strong> <span class="paymentInfo_method">카카오페이
						<em class="method_record">일시불(2020.04.20 11:46:00)</em>
					</span>
				</div>
			</div>
		</div>
		<div id="paymentFinished_button">
			<button type="button" class="paymentFinished_orderPage">주문내역보기</button>
			&nbsp;&nbsp;
			<button type="button" class="paymentFinished_goHomePage">홈으로
				가기</button>
		</div>
	</div>
	</div>
</div>
<script>
	// 주문 상세페이지로 이동
	$(document).on("click",'.paymentFinished_orderPage', function() {
		$("#homemain").load("payment/paymentDetail.jsp");
	});
	// 홈페이지로 이동
	$(document).on("click",'.paymentFinished_goHomePage', function() {
		$("#homemain").load("ETC/main.jsp");
	});
	
	// a href로 _self로 이동.
	
	// 홈페이지로 이동
	function mainpage() {
		$("#homemain").load("ETC/main.jsp");
	}
	// /member/mypage.jsp
	// 마이페이지 주문/배송 페이지로 이동
	function mypageDelivery() {
<%-- 		$('#homemain').load('<%=request.getContextPath()%>/member/mypage/order_manager/mypage_delivery_info.jsp'); --%>
$('#homemain').load('<%=request.getContextPath()%>/member/mypage.jsp?dlv=on');
	}
	
	// 펀딩 아이템으로 이동
	function fundingItem() {
		$('#homemain').load('<%=request.getContextPath()%>/Funding/fundingRegister.jsp');
	}
	
	function fundingItem2() {
		$('#homemain').load('<%=request.getContextPath()%>/goods/lectureRegister.jsp');
	}
	
	function fundingItem2() {
		$('#homemain').load('<%=request.getContextPath()%>/goods/lectureRegister.jsp');
	}
</script>