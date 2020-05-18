<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>카카오페이 결제</title>
<link type="text/css" rel="stylesheet" href="resources/css/payment/pay_kakaopay.css">
<%
	String name = "김건우";//(String)request.getAttribute("name");
	String email = "frostkim21@nate.com";//(String)request.getAttribute("email");
	String phone = "010-6546-5634";//(String)request.getAttribute("phone");
	String address = "경기도 부천시 원미로 144번길 51";//(String)request.getAttribute("address");
	int totalPrice = 1000000;//(int)request.getAttribute("totalPrice");
%>
<script type="text/javascript">
         var IMP = window.IMP; // 생략가능
         IMP.init('imp94738326'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
         var msg;
        
         IMP.request_pay({
             pg : 'kakaopay', // 결제방식
             pay_method : 'card', // 결제수단
             merchant_uid : 'merchant_' + new Date().getTime(),
             name : 'LecFly 클래스 결제', // order 테이블에 들어갈 주문명 혹은 주문 번호
            amount : <%=totalPrice%>, //결제 금액
            buyer_email : '<%=email%>',   //구매자 eamil
            buyer_name : '<%=name%>', // 구매자 이름
            buyer_tel : '<%=phone%>', // 구매자 전화번호
            buyer_addr : '<%=address%>', // 구매자 주소
            buyer_postcode : '123-456', // 구매자 우편번호
            m_redirect_url : 'http://localhost:8081/LF/home.jsp' // 결제 완료 후 보냄 컨트롤러의 메소드 명
        }, function(rsp) {
            if ( rsp.success ) { // 성공시
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
//                cross-domain error가 발생하지 않도록 주의해주세요
                jQuery.ajax({
                    url: $('#homemain').load('<%=request.getContextPath()%>/payment/paymentFinished.jsp'), 
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
                      $('#homemain').load('<%=request.getContextPath()%>/payment/paymentFinished.jsp');
                    } else {
                        //[3] 아직 제대로 결제가 되지 않았습니다.
                        //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
                    }
                });
                
            } else {
                msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
                $('#homemain').load('<%=request.getContextPath()%>/payment/fundingPayment.jsp');
				alert(msg);
			}
		});
	</script>