<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link type="text/css" rel="stylesheet"
	href="resources/css/payment/pay_orderFinished.css">

<div id="paymentFinished_wrapper">
	<div id="paymentFinished_content">
		<div class="paymentFinished_title_box">
			<h1 class="paymentFinished_title">결제완료</h1>
			<h3 class="paymentFinished_subtitle">
				<span class="basket">장바구니</span> 
				<span class="order_sheet">&gt; 주문서</span>
				<span class="order_finish">&gt; 주문완료</span>
			</h3>
		</div>
		<c:forEach var="ph" items="${phlist}" varStatus="vs">
		<div id="finished_wrapper">
			<div class="finished_background">
				<div class="finished_backgroundInfo">
					<div class="finished_backgroundInfo2"></div>
					<div class="finished_font">
						주문이 정상적으로 <strong style="color: orange">완료</strong>되었습니다.
					</div>
					<a class="finished_orderdelivery" href="#popup1">주문상세조회</a>
					<div id="popup1" class="overlay">
						<div class="popup">
							<p class="orderDetail_title">
								<i class="fas fa-edit"></i>주문상세정보 
								<span>&#8226; 결제번호 : ${ph.checkSameOrder} | 주문일자: ${ph.dealDay}</span>
							</p>
							<a class="close" href="#">x</a>
							<div class="orderDetail_content">
								<table class="orderDetail_center" border="1"
									style="border-color: #eee;">
									<tr>
										<th class="orderDetail_center_th">상품번호<br>(주문번호)
										</th>
										<th class="orderDetail_center_th">상품명/주문옵션</th>
										<th class="orderDetail_center_th">상품금액<br>(개수)
										</th>
										<th class="orderDetail_center_th">할인금액</th>
										<th class="orderDetail_center_th">배송비</th>
										<th class="orderDetail_center_th">판매자</th>
										<th class="orderDetail_center_th">주문상태</th>
									</tr>
									<tr>
										<td class="orderDetail_center_td">${ph.checkSameOrder}<br>
										</td>
										<td class="orderDetail_center_td">${titleList[vs.index]}</td>
										<td class="orderDetail_center_td">${ph.payHistorySum}원<br>(${ph.buyProductCount})
										</td>
										<td class="orderDetail_center_td">0원</td>
										<td class="orderDetail_center_td">${ph.diliveryPrice}원</td>
										<td class="orderDetail_center_td">${ph.sellMbId}</td>
										<td class="orderDetail_center_td">거래완료</td>
									</tr>
								</table>
								<div class="bottom_content">
									<table class="orderDetail_left">
										<tr>
											<th class="orderDetail_left_th">받으시는분</th>
											<td class="orderDetail_left_td">${member.name}</td>
										</tr>
										<tr>
											<th class="orderDetail_left_th">연락처</th>
											<td class="orderDetail_left_td">${member.phNumber}</td>
										</tr>
										<tr>
											<th class="orderDetail_left_th">주소</th>
											<td class="orderDetail_left_td">${member.postalCode}<br>${member.basicAddress}
											</td>
										</tr>
										<tr>
											<th class="orderDetail_left_th">배송시 요구사항</th>
											<td class="orderDetail_left_td"></td>
										</tr>
									</table>
									<table class="orderDetail_right">
										<tr>
											<th class="orderDetail_right_th">최종 결제금액</th>
											<td class="orderDetail_right_td">${ph.payHistorySum + ph.diliveryPrice}원</td>
										</tr>
										<tr>
											<th class="orderDetail_right_th">결제방법</th>
											<td class="orderDetail_right_td">${ph.payWay == 1 ? "카드결제" : "카카오페이"}</td>
										</tr>
										<tr>
											<th class="orderDetail_right_th">상품금액</th>
											<td class="orderDetail_right_td">${ph.payHistorySum}원</td>
										</tr>
										<tr>
											<th class="orderDetail_right_th">배송비</th>
											<td class="orderDetail_right_td">${ph.diliveryPrice}원</td>
										</tr>
										<tr>
											<th class="orderDetail_right_th">쿠폰할인금액</th>
											<td class="orderDetail_right_td">0원</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="orderInfo_title">주문 정보</div>
			<div class="orderInfo_box">
				<table class="orderInfo_table">
					<tbody>
						<tr>
							<th class="orderInfo_table_th">주문자</th>
							<td class="orderInfo_table_td">${member.name}</td>
						</tr>
						<tr>
							<th class="orderInfo_table_th">주문일자</th>
							<td class="orderInfo_table_td"><strong>2020.04.20</strong></td>
						</tr>
						<tr>
							<th class="orderInfo_table_th">주문번호</th>
							<td class="orderInfo_table_td"><strong
								style="color: #babc00;">${ph.checkSameOrder}</strong></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div id="deliveryGoodsInfo_title">배송상품 정보</div>
			<div class="deliveryGoods_set">
				<a class="deliveryGoods_img" target="_self"
					href="javascript:void(0);" onclick="fundingItem();"> <img
					src="resource/img/payment/working out.jpg" width="85" height="85"
					alt="다이어트 패키지">
				</a>
				<div class="deliveryGoods_imgInfo">
					<a class="deliveryGoods_a" target="_self"
						href="javascript:void(0);" onclick="fundingItem();"> <strong>${ph.goodsType == 1 ? '회원권': '키트'}</strong><br>
						${titleList[vs.index]}
					</a>
					<div class="deliveryGoods_cnt">
						구매수량
						<c:out value="${ph.buyProductCount}" default="1" />개
					</div>
					<div>
						<span class="deliveryGoods_discount">0<em style="display: inline-block; color: #b0b0b0; font-style: normal; font-size: 12px; vertical-align: 1px;">원</em>
						</span> <span class="deliveryGoods_price">${ph.payHistorySum}<em
							class="korean_point">원</em>
						</span>
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
							<td class="deliveryInfo_table_td">${member.name}</td>
						</tr>
						<tr>
							<th class="deliveryInfo_table_th">연락처</th>
							<td class="deliveryInfo_table_td"><span>${member.phNumber}</span>
							</td>
						</tr>
						<tr>
							<th class="deliveryInfo_table_th">주소</th>
							<td class="deliveryInfo_table_td">${member.basicAddress}</td>
						</tr>
						<tr>
							<th class="deliveryInfo_table_th">택배 메세지</th>
							<td class="deliveryInfo_table_td"></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div id="paymentInfo_title">결제 정보</div>
			<div class="paymentInfo_set">
				<div>
					<div class="paymentInfo_sumprice">
						<strong>총 상품금액</strong> <span class="sumGoods_price">${ph.payHistorySum}
						<em class="korean_point">원</em></span>
					</div>
					<div class="paymentInfo_sumprice">
						<strong>총 배송비</strong> <span class="sumDelivery_price">${ph.diliveryPrice}
						<em class="korean_point">원</em></span>
					</div>
				</div>
				<div>
					<div class="paymentInfo_sumprice">
						<strong>쿠폰</strong> <span class="point_discountprice">${ph.couponId}<em
							class="korean_point">원</em></span>
					</div>
				</div>
				<div class="paymentInfo_sumprice">
					<div>
						<strong style="color: #ff2828;">총 결제금액</strong> <span
							class="sum_paymentPrice">${ph.payHistorySum + ph.diliveryPrice}<em
							class="korean_point">원</em>
						</span>
					</div>
				</div>
				<div>
					<div class="paymentInfo_sumprice">
						<strong> 결제수단 </strong> <span class="paymentInfo_method">${ph.payWay == 1 ? "카드결제" : "카카오페이"}
							<em class="method_record">${ph.updatedAt}</em>
						</span>
					</div>
				</div>
			</div>
			<div id="paymentFinished_button">
				<button type="button" class="paymentFinished_goHomePage">홈으로
					가기</button>
			</div>
		</div>
		</c:forEach>
	</div>
</div>
<script>
	$(document)
			.ready(
					function() {
						$(".paymentFinished_goHomePage")
								.on(
										"click",
										function() {
											window.location.href = '${pageContext.request.contextPath}'
													+ '/home.LF';
										});

						$(".finished_orderdelivery").on(
								"click",
								function() {
									$('#homemain').load(
											'${pageContext.request.contextPath}'
													+ '/pay_orderDetail.LF');
								})
					});
</script>