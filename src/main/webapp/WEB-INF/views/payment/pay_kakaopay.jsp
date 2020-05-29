<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
    		                   url: $('#homemain').load('${pageContext.request.contextPath}' + '/pay_orderFinished.LF'), 
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
    		                     $('#homemain').load('${pageContext.request.contextPath}' + '/pay_orderFinished.LF');
    		                   } else {
    		                       //[3] 아직 제대로 결제가 되지 않았습니다.
    		                       //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
    		                   }
    		               });
    		               
    		           } else {
    		               msg = '결제에 실패하였습니다.';
    		               msg += '에러내용 : ' + rsp.error_msg;
    		               //실패시 이동할 페이지
    		               $('#homemain').load('${pageContext.request.contextPath}' + '/pay_order.LF');
    						alert(msg);
    					}
    		       });
				});
			});
	</script>