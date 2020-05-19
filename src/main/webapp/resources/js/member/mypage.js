/**
 *             클릭시 이벤트 
 */	
 	$(document).ready(function() {
 		$("#mypage_mb_t_ticket").click(function() {
 			$.ajax({
 				type: "POST",
 				url: "mypage_list.LF",
	 			cache: true,
				datatype: "text",
				data: "",
				success:function(res){
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
 			});			
 		}); // 이용권 결제내역

 		$("#tabs-mom-1").click(function() {
 			var params = "status=0";
 			$.ajax({
 				type: "POST",
 				url: "mypage_attending_lec.LF",
	 			cache: true,
				datatype: "text",
				data: params,
				success:function(res){
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
 			});
 		}); // 대분류 이동> 수강중인 강의
 		
		$("#tabs-mom-2").click(function() {
			var params = "pn=1";
			$.ajax({
 				type: "POST",
 				url: "mypage_comment.LF",
	 			cache: true,
				datatype: "text",
				data: params,
				success:function(res){
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
 			});				
 		}); // 대분류 이동> 댓글내역
		
 		$("#tabs-mom-3").click(function() {
 			$.ajax({
 				type: "POST",
 				url: "mypage_mb_update.LF",
	 			cache: true,
				datatype: "text",
				data: "",
				success:function(res){
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
 			});			
 		}); // 대분류 이동> 회원정보 수정
		$("#tabs-mom-4").click(function() {
			$.ajax({
 				type: "POST",
 				url: "mypage_delivery_info.LF",
	 			cache: true,
				datatype: "text",
				data: "",
				success:function(res){
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
 			});			
 		}); // 대분류 이동> 배송정보
		
 		$("#mypage_attending_lec").click(function() {
 			var params = "status=0";
 			$.ajax({
 				type: "POST",
 				url: "mypage_attending_lec.LF",
	 			cache: true,
				datatype: "text",
				data: params,
				success:function(res){
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
 			});
 		}); // 수강중인 강의
 		
 		
 		$("#mypage_will_attend").click(function() {
 			var rtPn = "pn=1";
 			$.ajax({
 				type: "POST",
 				url: "mypage_will_attend.LF",
	 			cache: true,
				datatype: "text",
				data: rtPn,
				success:function(res){
					console.log(res);
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
 			});
 		}); // 찜하기
 		
 		$("#mypage_like").click(function() {
 			var rtPn = "pn=1";
 			$.ajax({
 				type: "POST",
 				url: "mypage_like.LF",
	 			cache: true,
				datatype: "text",
				data: rtPn,
				success:function(res){
					console.log(res);
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
 			});
 		}); // 좋아요
		
 		$("#mypage_comment").click(function() {
 			var params = "pn=1";
 			$.ajax({
 				type: "POST",
 				url: "mypage_comment.LF",
	 			cache: true,
				datatype: "text",
				data: params,
				success:function(res){
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
 			});
 		}); // 댓글내역
 		
 		$("#mypage_qna").click(function() {
 			var params = "pn=1";
 			$.ajax({
 				type: "POST",
 				url: "mypage_qna.LF",
	 			cache: true,
				datatype: "text",
				data: params,
				success:function(res){
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
 			});
 		}); // 문의내역
 		
 		$("#mypage_funding").click(function() {
 			$.ajax({
 				type: "POST",
 				url: "mypage_funding.LF",
	 			cache: true,
				datatype: "text",
				data: "",
				success:function(res){
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
 			});			
		}); // 펀딩신청내역
 		
		$("#mypage_coupon_info").click(function() {
			var params = "pn=1"
			$.ajax({
 				type: "POST",
 				url: "mypage_coupon_info.LF",
	 			cache: true,
				datatype: "text",
				data: params,
				success:function(res){
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
 			});
 		});// 쿠폰내역 
		
		$("#mypage_mb_update").click(function() {
			$.ajax({
				type: "POST",
				url: "mypage_mb_update.LF",
				cache: true,
				datatype: "text",
				data: "",								// <= data 에 param 보낼꺼..{name : value}
				success:function(res){
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){
					
				}
			}); 
		});// 회원정보 수정
 		$("#mypage_pw_update").click(function() {
 			$.ajax({
 				type: "POST",
 				url: "mypage_pw_update.LF",
	 			cache: true,
				datatype: "text",
				data: "",
				success:function(res){
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
 			});
 		}); // 비밀번호 변경
 		$("#mypage_shoppingcart").click(function() {
 			$.ajax({
 				type: "POST",
 				url: "mypage_shoppingcart.LF",
	 			cache: true,
				datatype: "text",
				data: "",
				success:function(res){
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
 			});			
 		}); // 장바구니
 		$("#mypage_receive_address").click(function() {
 			$.ajax({
 				type: "POST",
 				url: "mypage_receive_address.LF",
	 			cache: true,
				datatype: "text",
				data: "",
				success:function(res){
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
 			});	
 		}); // 배송지관리 ???
 		$("#mypage_delivery_info").click(function() {
 			$.ajax({
 				type: "POST",
 				url: "mypage_delivery_info.LF",
	 			cache: true,
				datatype: "text",
				data: "",
				success:function(res){
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
 			});			
 		}); // 배송정보
 		$("#mypage_payment_info").click(function() {
 			$.ajax({
 				type: "POST",
 				url: "mypage_payment_info.LF",
	 			cache: true,
				datatype: "text",
				data: "",
				success:function(res){
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
 			});
 		}); // 결제내역
 		$(".mypage_mb_t").click(function() {
 			$.ajax({
 				type: "POST",
 				url: "mypage_coupon_info.LF",
	 			cache: true,
				datatype: "text",
				data: "",
				success:function(res){
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
 			});
 		});// 쿠폰내역
 		
 		
// 		$("#mypage_update_info_btn").click(function() {
// 			var name= $('input#posting-value-1').val();

// 		}); // 마이페이지 회원정보 변경 클릭시
 		
 		
 		
 		
 	}); // $(document).ready 끝;
 	
 	
 	// 마이페이지 페이지 네이션
 	function myPagePagiNatePre(pn, url) {
 		console.log("pn=" + pn + ", url = " + url);
 		if( pn > 1){
 			var rtPn = "pn=" + (pn - 1);
	 		$.ajax({
				type: "POST",
				url: url,
	 			cache: true,
				datatype: "text",
				data: rtPn,
				success:function(res){
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
	 		});
 		}
 	}
 	
 	function myPagePagiNateCurrunt( pn, current, url){
 		console.log("pn=" + pn + "/current = " + current + ", url = " + url);
 		if(current != pn){
 			var rtPn = "pn=" + current;
 			console.log("pn=" + current);
	 		$.ajax({
				type: "POST",
				url: url,
	 			cache: true,
				datatype: "text",
				data: rtPn,
				success:function(res){
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
	 		});
 		}
 	}
 	
 	function myPagePagiNateNext(pn, maxPn, url){
 		console.log("pn=" + pn + "/maxPn = " + maxPn + ", url = " + url);
 		if(pn < maxPn){
 			var rtPn = "pn=" + (pn + 1);
 			$.ajax({
				type: "POST",
				url: url,
	 			cache: true,
				datatype: "text",
				data: rtPn,
				success:function(res){
					$("#mypage_bottom").html(res);
				},
				error:function(request,status,error){	
				}
	 		});
 		}
 	}
 	