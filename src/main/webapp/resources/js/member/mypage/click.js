/**
 *             클릭시 이벤트 
 */
	$( function() {
	 	  $( "#tabs" ).tabs();
 	} );
 	$(document).ready(function() {
 		$("#mypage_mb_t_ticket").click(function() {
 			var url = 'mypage_list.LF';
 			$("#mypage_bottom").load(url, function(){
 				console.log("이용권 결제내역 로딩완료");
 			});			
 		}); // 이용권 결제내역
		
 		$("#tabs-mom-1").click(function() {
 			var url = "mypage_attending_lec.LF";
 			$("#mypage_bottom").load(url, function(){
 				console.log("대분류 수강중인강의 로딩완료");
 			});			
 		}); // 대분류 이동> 수강중인 강의
		$("#tabs-mom-2").click(function() {
 			var url = "mypage_comment.LF";
 			$("#mypage_bottom").load(url, function(){
 				console.log("대분류 댓글내역 로딩완료");
 			});			
 		}); // 대분류 이동> 댓글내역
 		$("#tabs-mom-3").click(function() {
			var url = "mypage_mb_update.jsp";
 			$("#mypage_bottom").load(url, function(){
 				console.log("대분류 회원정보 수정 로딩완료");
 			});			
 		}); // 대분류 이동> 회원정보 수정
		$("#tabs-mom-4").click(function() {
 			var url = "mypage_delivery_info.LF";
			$("#mypage_bottom").load(url, function(){
				console.log("배송정보 로딩완료");
			});			
 		}); // 대분류 이동> 배송정보
		
 		$("#mypage_attending_lec").click(function() {
 			var url = "mypage_attending_lec.LF";
 			$("#mypage_bottom").load(url, function(){
 				console.log("수강중인강의 로딩완료");
 			});			
 		}); // 수강중인 강의
 		$("#mypage_will_attend").click(function() {
 			var url = "mypage_will_attend.LF";
 			$("#mypage_bottom").load(url, function(){
 				console.log("찜하기 로딩완료");
 			});			
 		}); // 찜하기
 		$("#mypage_like").click(function() {
 			var url = "mypage_like.LF";
 			$("#mypage_bottom").load(url, function(){
 				console.log("좋아요 로딩완료");
 			});			
 		}); // 좋아요
		
 		$("#mypage_comment").click(function() {
			var url = "mypage_comment.LF";
 			$("#mypage_bottom").load(url, function(){
 				console.log("댓글내역 로딩완료");
 			});			
 		}); // 댓글내역
 		$("#mypage_qna").click(function() {
 			var url = "mypage_qna.LF";
 			$("#mypage_bottom").load(url, function(){
 				console.log("문의내역 로딩완료");
 			});			
 		}); // 문의내역
 		$("#mypage_funding").click(function() {
 			var url = "mypage_funding.LF";
 			$("#mypage_bottom").load(url, function(){
 				console.log("펀딩신청내역 로딩완료");
 			});			
		}); // 펀딩신청내역
		$("#mypage_coupon_info").click(function() {
 			var url = "mypage_coupon_info.LF";
 			$("#mypage_bottom").load(url, function(){
 			 	console.log("쿠폰내역 로딩완료");
 			});
 		});// 쿠폰내역 
 		$("#mypage_mb_update").click(function() {
 			var url = "mypage_mb_update.LF";
 			$("#mypage_bottom").load(url, function(){
 				console.log("회원정보 수정 로딩완료");
 			});			
 		}); // 회원정보 수정
 		$("#mypage_pw_update").click(function() {
 			var url = "mypage_pw_update.jsp";
 			$("#mypage_bottom").load(url, function(){
 				console.log("비밀번호 변경 로딩완료");
 			});			
 		}); // 비밀번호 변경

 		$("#mypage_shoppingcart").click(function() {
			var url = "mypage_shoppingcart.LF";
 			$("#mypage_bottom").load(url, function(){
 				console.log("장바구니 로딩완료");
 			});			
 		}); // 장바구니
 		$("#mypage_receive_address").click(function() {
 			var url = "mypage_receive_address.LF";
 			$("#mypage_bottom").load(url, function(){
 				console.log("배송지관리 로딩완료");
 			});			
 		}); // 배송지관리
 		$("#mypage_delivery_info").click(function() {
 			var url = "mypage_delivery_info.LF";
 			$("#mypage_bottom").load(url, function(){
 				console.log("배송정보 로딩완료");
 			});			
 		}); // 배송정보
 		$("#mypage_payment_info").click(function() {
 			var url = "mypage_payment_info.LF";
 			$("#mypage_bottom").load(url, function(){
 				console.log("결제내역 로딩완료");
 			});			
 		}); // 결제내역
 		$(".mypage_mb_t").click(function() {
 			var url = "mypage_coupon_info.LF";
 			$("#mypage_bottom").load(url, function(){
 				console.log("쿠폰내역 로딩완료");
 			});
 		});// 쿠폰내역
 	});