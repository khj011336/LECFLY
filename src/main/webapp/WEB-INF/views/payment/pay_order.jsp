<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link type="text/css" rel="stylesheet" href="resources/css/payment/pay_order.css">
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<div id="wrapper">
	<div id="fundingPayment_wrapper">
		<div id="fundingPayment_main_title">
			<strong class="fundingPayment_main_title">상품</strong> 결제하기 <br />
			<div class="fundingPayment_subtitle">
				<span class="fundingPayment_basket">장바구니</span><span
					class="fundingPayment_order_sheet">&gt; 주문서</span> <span
					class="fundingPayment_order_finish">&gt; 주문완료</span>
			</div>
		</div>
		<div id="fundingPayment_content">
			<div id="fundingPayment_title">주문자 정보</div>
			<div class="ordererInfo_box">
				<table class="ordererInfo_table">
					<tbody>
						<tr>
							<th class="ordererInfo_table_th">주문자명</th>
							<td colspan="2" class="ordererInfo_table_td">
								<input type="text" name="fundingPayment_name" size="20" value="${member.name}" readonly>
							</td>
						</tr>
						<tr>
							<th class="ordererInfo_table_th">이메일</th>
							<td colspan="2" class="ordererInfo_table_td">
								<input type="email" name="fundingPayment_email" required value="${member.email}" readonly>
							</td>
						</tr>
						<tr>
							<th class="ordererInfo_table_th">휴대전화</th>
							<td class="ordererInfo_table_td">
							<input type="tel" name="fundingPayment_tel" required pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" title="###-####-####" value="${member.phNumber}" readonly>
							</td>
							<td class="ordererInfo_table_td">
								<button type="button" name="phoneIdentity_button"disabled>인증 완료</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div id="deliveryPlaceInfo_title">배송지 정보</div>
			<div class="deliveryPlaceInfo_box">
				<table class="deliveryPlaceInfo_table">
					<tbody>
						<tr>
						<td class="deliveryPlaceInfo_table_td">
							<input type="radio" name="default_deliveryInfo_save" checked> 기본 배송지로 저장
						</td>
						<td class="deliveryPlaceInfo_table_td">
							<input type="radio" name="default_deliveryInfo_save"> 새로운 배송지
						</td>
						</tr>
						<tr>
							<th class="deliveryPlaceInfo_table_th">배송지명</th>
							<td colspan="3" class="deliveryPlaceInfo_table_td">
								<input type="text" name="deliveryPlace_name" size="20" value="기본 배송지" readonly>
							</td>
						</tr>
						<tr>
							<th class="deliveryPlaceInfo_table_th">수령자명</th>
							<td colspan="3" class="deliveryPlaceInfo_table_td">
								<input type="text" name="receiver_name" size="10" value="${member.name}" readonly>
							</td>
						</tr>
						<tr>
							<th class="deliveryPlaceInfo_table_th">휴대전화</th>
							<td colspan="3" class="deliveryPlaceInfo_table_td"><input
								type="tel" name="deliveryPlaceInfo_tel" required
								pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" title="###-####-####" value="${member.phNumber}" readonly>
							</td>
						</tr>
						<tr>
							<th class="deliveryPlaceInfo_table_th">추가번호(선택)</th>
							<td colspan="3" class="deliveryPlaceInfo_table_td">
							<input type="tel" name="deliveryPlaceInfo_tel_add" pattern="[0-10]{3}-[4-10]{4}-[7-14]{4}" title="###-####-####" value="01036845634" readonly>
							</td>
						</tr>
						<tr>
							<th class="deliveryPlaceInfo_table_th">주소</th>
							<td class="deliveryPlaceInfo_table_td">
								<input type="text" id="fundingPayment_postcode" placeholder="우편번호" value="${member.postalCode}" readonly>
							</td>
							<td class="deliveryPlaceInfo_table_td">
								<input type="button" name="fundingPayment_postcode_button" onclick="fundingPayment_execDaumPostcode()" value="우편번호 " disabled>
							</td>
						<tr>
							<th class="deliveryPlaceInfo_table_th_nbsp">&nbsp;</th>
							<td colspan="3" class="deliveryPlaceInfo_table_td_nbsp">
							<input type="text" id="fundingPayment_address" placeholder="주소" value="${member.basicAddress}" readonly>
							</td>
						</tr>
						<tr>
							<th class="deliveryPlaceInfo_table_th_nbsp">&nbsp;</th>
							<td colspan="3" class="deliveryPlaceInfo_table_td">
							<input type="text" id="fundingPayment_detailAddress" placeholder="상세주소" value="${member.detailAddress}" readonly>
							</td>
						</tr>
						<tr>
<!-- 						<tr> -->
<!-- 							<th class="deliveryPlaceInfo_table_th"></th> -->
<!-- 							<td colspan="3" class="deliveryPlaceInfo_table_td"><input -->
<!-- 								type="text" id="fundingPayment_extraAddress" placeholder="참고항목"> -->
<!-- 							</td> -->
<!-- 						</tr> -->
						<tr>
							<th class="deliveryPlaceInfo_table_th">배송요청 사항</th>
							<td colspan="3" class="deliveryPlaceInfo_table_td"><input
								type="text" name="delivery_required"
								placeholder="최대 50자까지 입력 가능합니다."></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div id="fundingPayment_sidebar">
			<div id="orderfundingInfo_title">주문 상품</div>
			<div class="orderfundingInfo_set">
			<c:forEach var="ct" items="${pd.data}" varStatus="vs">
				<a class="orderfunding_img" target="_target" href="javascript:void(0);" onclick="pageContext.request.contextPath/payment">
					<img src="resource/img/payment/working out.jpg" width="85" height="85" alt="다이어트 패키지">
				</a>
				<div class="orderfunding_imgInfo">
					<a class="orderfunding_a">
						<strong>${ct.gdType == 0 ? '회원권': '키트'}</strong><br>
					 	<strong>${ct.gdsName}</strong>
					</a>
					<div class="orderfunding_cnt">구매수량 <c:out value="${ct.gdsCnt}" default="1"/> 개</div>
					<div>
						<span class="orderfunding_price">${ct.gdsPrice}<em class="orderfunding_won">원</em></span>
					</div>
				</div>
			</c:forEach>
			</div>
			<div id="paymentInfo_title">결제 정보</div>
			<div class="paymentInfo_box">
				<table class="paymentInfo_table">
					<tr>
						<th class="paymentInfo_table_th">결제수단</th>
						<td class="paymentInfo_table_td"><input type="radio"
							name="paymentMethod" value="creditCard">신용카드 <input
							type="radio" name="paymentMethod" value="">카카오페이
							<input type="radio" name="paymentMethod" value="payCo">페이코
						</td>
					</tr>
					<tr>
						<th class="paymentInfo_table_th">쿠폰</th>
						<td class="paymentInfo_table_td"><input type="text"
							name="paymentPoint"></td>
						<td class="paymentInfo_table_td">
							<button type="button" name="paymentApply">적용</button>
						</td>
					</tr>
					<tr>
						<td></td>
						<td class="paymentInfo_table_td_point">현재 보유 쿠폰:
							<span class="point_color"> 0 </span>개
						</td>
						<td></td>
					</tr>
					<tr>
						<th class="paymentInfo_sum_th">상품금액</th>
						<td colspan="2" class="paymentInfo_sum_td">${pd.totalPrice}원</td>
					</tr>
					<tr>
						<th class="paymentInfo_sum_th">할인금액</th>
						<td colspan="2" class="paymentInfo_sum_td">0원</td>
					</tr>
					<tr>
						<th class="paymentInfo_sum_th">배송비</th>
						<td colspan="2" class="paymentInfo_sum_td">무료</td>
					</tr>
					<tr>
						<th class="paymentInfo_sum_th_last">전체 주문금액</th>
						<td colspan="2" class="paymentInfo_sum">${pd.totalPrice}</td>
					</tr>
				</table>
			</div>
		</div>
		<div id="fundingPayment_order_button">
			<p class="fundingPayment_desc">위 주문 내용을 확인 하였으며, 회원 본인은 결제에
				동의합니다.</p>
			<a href="javascript:void(0)" id="goFinish" class="fundingPayment_confirm_order"> 주문하기 </a>
		</div>
	</div>
</div>
	<script type="text/javascript">
		// 주소찾기
    	function fundingPayment_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("fundingPayment_extraAddress").value = extraAddr;

                } else {
                    document.getElementById("fundingPayment_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('fundingPayment_postcode').value = data.zonecode;
                document.getElementById("fundingPayment_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("fundingPayment_detailAddress").focus();
            }
        }).open();
    }

    	// 카카오페이 결제
    		$(document).ready(function() {
    			$("#goFinish").on("click", function() {
    				var IMP = window.IMP; // 생략가능
    		        IMP.init('imp94738326'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
    		        var msg;
    		        var name = '${member.name}';
    		        var email = '${member.email}';
    		        var tel = '${member.phNumber}';
    		        var addr = '${member.basicAddress}';
    		        var postcode = '${member.postalCode}';
    		        var amount = ${pd.totalPrice};
    		        IMP.request_pay({
    		            pg : 'kakaopay', // 결제방식
    		            pay_method : 'card', // 결제수단
    		            merchant_uid : 'merchant_' + new Date().getTime(),
    		            name : 'LecFly 클래스 결제', // order 테이블에 들어갈 주문명 혹은 주문 번호
    		            amount : amount, //결제 금액
    		            buyer_email : email,   //구매자 eamil
    		            buyer_name : name, // 구매자 이름
    		            buyer_tel : tel, // 구매자 전화번호
    		            buyer_addr : addr, // 구매자 주소
    		            buyer_postcode : postcode, // 구매자 우편번호
    		           m_redirect_url : 'http://localhost:8081/LECFLY/home.jsp' // 결제 완료 후 보냄 컨트롤러의 메소드 명
    		       }, function(rsp) {
    		           if ( rsp.success ) { // 성공시
    		               jQuery.ajax({
    		                   url: window.location.href = '${pageContext.request.contextPath}' + '/pay_orderFinished.LF',
    		                   type: 'POST',
    		                   dataType: 'json',
    		                   data: {
    		                       imp_uid : rsp.imp_uid
    		                       //기타 필요한 데이터가 있으면 추가 전달
    		                   }
    		               }).done(function(data) {
    		                   //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
    		                   if ( everythings_fine ) {
    		                       msg = '결제가 완료되었습니다.';
    		                       msg += '\n고유ID : ' + rsp.imp_uid;
    		                       msg += '\n상점 거래ID : ' + rsp.merchant_uid;
    		                       msg += '\결제 금액 : ' + rsp.paid_amount;
    		                       msg += '카드 승인번호 : ' + rsp.apply_num;

    		                       alert(msg);

    		                     //성공시 이동할 페이지
    		                     window.location.href = '${pageContext.request.contextPath}' + '/pay_orderFinished.LF';
    		                     //$('#homemain').load('${pageContext.request.contextPath}' + '/pay_orderFinished.LF');
    		                   } else {
    		                       //[3] 아직 제대로 결제가 되지 않았습니다.
    		                       //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
    		                   }
    		               });

    		           } else {
    		               msg = '결제에 실패하였습니다.';
    		               msg += '에러내용 : ' + rsp.error_msg;
    		               //실패시 이동할 페이지
    		               window.location.href = '${pageContext.request.contextPath}' + '/home.LF';
//     		               $('#homemain').load('${pageContext.request.contextPath}' + '/home.LF');
    						alert(msg);
    					}
    		       });
				});
			});
	</script>
