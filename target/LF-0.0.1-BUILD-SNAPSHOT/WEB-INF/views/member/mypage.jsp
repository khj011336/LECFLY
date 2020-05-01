<!-- 1. 네비를 빼게 되면서 다시 1050> 1200으로 사이즈를 늘려야되는 필요가 있는 듯함.(가운데로 몰았으나 이쁘지가 않음.)(이버전은 따로 백업하기로) -->
<!-- 2. 로그인과 마찬가지로 색상 적용이 안되어 있음. 기준 색상대로 적용할 것. -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$( function() {
	  $( "#tabs" ).tabs();
	} );
	var ROOTCP = '<%= application.getContextPath()%>';
	$(document).ready(function() {
		$("#mypage_mb_t_ticket").click(function() {
			var url = ROOTCP+'/member/mypage/mypage_list.jsp';
			$("#mypage_bottom").load(url, function(){
				console.log("이용권 결제내역 로딩완료");
			});			
		}); // 이용권 결제내역
		
		$("#tabs-mom-1").click(function() {
			var url = ROOTCP+'/member/mypage/attend_lec_manager/mypage_attending_lec.jsp';
			$("#mypage_bottom").load(url, function(){
				console.log("대분류 수강중인강의 로딩완료");
			});			
		}); // 대분류 이동> 수강중인 강의
		$("#tabs-mom-2").click(function() {
			var url = ROOTCP+'/member/mypage/activity/mypage_comment.jsp';
			$("#mypage_bottom").load(url, function(){
				console.log("대분류 댓글내역 로딩완료");
			});			
		}); // 대분류 이동> 댓글내역
		$("#tabs-mom-3").click(function() {
			var url = ROOTCP+'/member/mypage/info_manager/mypage_mb_update.jsp';
			$("#mypage_bottom").load(url, function(){
				console.log("대분류 회원정보 수정 로딩완료");
			});			
		}); // 대분류 이동> 회원정보 수정
		$("#tabs-mom-4").click(function() {
			var url = ROOTCP+'/member/mypage/order_manager/mypage_delivery_info.jsp';
			$("#mypage_bottom").load(url, function(){
				console.log("배송정보 로딩완료");
			});			
		}); // 대분류 이동> 배송정보
		
		$("#mypage_attending_lec").click(function() {
			var url = ROOTCP+'/member/mypage/attend_lec_manager/mypage_attending_lec.jsp';
			$("#mypage_bottom").load(url, function(){
				console.log("수강중인강의 로딩완료");
			});			
		}); // 수강중인 강의
		$("#mypage_will_attend").click(function() {
			var url = ROOTCP+'/member/mypage/attend_lec_manager/mypage_will_attend.jsp';
			$("#mypage_bottom").load(url, function(){
				console.log("찜하기 로딩완료");
			});			
		}); // 찜하기
		$("#mypage_like").click(function() {
			var url = ROOTCP+'/member/mypage/attend_lec_manager/mypage_no_list.jsp';
			$("#mypage_bottom").load(url, function(){
				console.log("좋아요 로딩완료");
			});			
		}); // 좋아요
		
		$("#mypage_comment").click(function() {
			var url = ROOTCP+'/member/mypage/activity/mypage_comment.jsp';
			$("#mypage_bottom").load(url, function(){
				console.log("댓글내역 로딩완료");
			});			
		}); // 댓글내역
		$("#mypage_qna").click(function() {
			var url = ROOTCP+'/member/mypage/activity/mypage_qna.jsp';
			$("#mypage_bottom").load(url, function(){
				console.log("문의내역 로딩완료");
			});			
		}); // 문의내역
		$("#mypage_funding").click(function() {
			var url = ROOTCP+'/member/mypage/activity/mypage_funding.jsp';
			$("#mypage_bottom").load(url, function(){
				console.log("펀딩신청내역 로딩완료");
			});			
		}); // 펀딩신청내역
		$("#mypage_coupon_info").click(function() {
			var url = ROOTCP+'/member/mypage/activity/mypage_coupon_info.jsp';
			$("#mypage_bottom").load(url, function(){
				console.log("쿠폰내역 로딩완료");
			});
		});// 쿠폰내역 
		$("#mypage_mb_update").click(function() {
			var url = ROOTCP+'/member/mypage/info_manager/mypage_mb_update.jsp';
			$("#mypage_bottom").load(url, function(){
				console.log("회원정보 수정 로딩완료");
			});			
		}); // 회원정보 수정
		$("#mypage_pw_update").click(function() {
			var url = ROOTCP+'/member/mypage/info_manager/mypage_pw_update.jsp';
			$("#mypage_bottom").load(url, function(){
				console.log("비밀번호 변경 로딩완료");
			});			
		}); // 비밀번호 변경

		$("#mypage_shoppingcart").click(function() {
			var url = ROOTCP+'/member/mypage/order_manager/mypage_shoppingcart.jsp';
			$("#mypage_bottom").load(url, function(){
				console.log("장바구니 로딩완료");
			});			
		}); // 장바구니
		$("#mypage_receive_address").click(function() {
			var url = ROOTCP+'/member/mypage/order_manager/mypage_receive_address.jsp';
			$("#mypage_bottom").load(url, function(){
				console.log("배송지관리 로딩완료");
			});			
		}); // 배송지관리
		$("#mypage_delivery_info").click(function() {
			var url = ROOTCP+'/member/mypage/order_manager/mypage_delivery_info.jsp';
			$("#mypage_bottom").load(url, function(){
				console.log("배송정보 로딩완료");
			});			
		}); // 배송정보
		$("#mypage_payment_info").click(function() {
			var url = ROOTCP+'/member/mypage/order_manager/mypage_payment_info.jsp';
			$("#mypage_bottom").load(url, function(){
				console.log("결제내역 로딩완료");
			});			
		}); // 결제내역
		$(".mypage_mb_t").click(function() {
			var url = ROOTCP+'/member/mypage/activity/mypage_coupon_info.jsp';
			$("#mypage_bottom").load(url, function(){
				console.log("쿠폰내역 로딩완료");
			});
		});// 쿠폰내역
	});
 </script>

<div id="mypage_wrap"> 											<!-- 조각페이지 -->	
	<div id="mypage_top"> 										<!-- 개인정보 영역 -->
		<div id="mypage_pic">
            <img src="resource/img/logo/LecFly_SLOGO_LW_W.png" width="148px" height="148px">
          	<input type="button" value="프로필 사진 편집">
        </div>
        <div id="mypage_mb_IF">
        	<br><br>
        	<label><b>'홍길동'</b> 회원님은</label>
        	<br><br>
        	<h1><u>일반 회원</u> 입니다.</h1>
        	<br><br>
        	<a href="Creator/_classdes.jsp"><h3>크리에이터 신청하기</h3></a>
        </div>
        <div class="mypage_mb_t">
        	<img src="resource/img/mypage/mypage_video.png" class="mypage_1" alt="강의" width="64px" height="64px">
			<br><br><br>
			<span>강의 신청 목록 <b>6</b> 개</span>
        </div>
        <div class="mypage_mb_t">
        	<img src="resource/img/mypage/mypage_coupon.png" class="mypage_1" alt="쿠폰" width="64px" height="64px">
			<br><br><br>
			<span>쿠폰 <b>4</b> 개</span>
        </div>
        <div class="mypage_mb_t" id="mypage_mb_t_ticket">
        	<img src="resource/img/mypage/mypage_ticket.png" class="mypage_1" alt="이용권" width="64px" height="64px">
			<br><br><br>
			<span><b>3</b> 카테고리 이용권</span>
			<br>
			<p><a>미술</a> / <a>요리</a> / <a>라이프스타일</a></p>
        </div>
    </div>
	<div id="mypage_middle">									<!-- 정보 영역 및 메뉴영역 -->
<!-- 	문의내역/쿠폰현황 -->
<!-- 	주문내역/이용권 내역 -->
<!-- 	회원수정/삭제  -->
	    <!-- <ol id="mypage_menu">
	        <li><a class="mypage_a" href="#">강의</a></li>
	        	아래 조각페이지에 수강중인강의/찜하기한강의/좋아요한강의
	        <li><a class="mypage_a" href="#">활동</a></li>
	        	아래 조각페이지에 문의내역/쿠폰 현황 메뉴 부여
	        <li><a class="mypage_a" href="#">구매내역</a></li>
	        	아래 조각페이지에 장바구니/주문내역/사용중인 이용권 메뉴 부여
	        <li><a class="mypage_a" href="#">회원관리</a></li>
	        	아래 조각페이지에 수정/삭제 메뉴 부여
	    </ol> -->
	    <div id="tabs" class="mypage_tabs">
	    	<div id="tabs-mom">
			  <ul>
			    <li><a href="#tabs-1" id="tabs-mom-1">수강 관리</a></li>
			    <li><a href="#tabs-2" id="tabs-mom-2">활동 내역</a></li>
			    <li><a href="#tabs-3" id="tabs-mom-3">정보 관리</a></li>
			    <li><a href="#tabs-4" id="tabs-mom-4">주문/배송관리</a></li>
			  </ul>
			 </div>
		  <div id="tabs-1" class="mypage_tabs_li">
		  	<ul>
		    	<li><a href="#" id="mypage_attending_lec">수강중인 강의</a></li>
		    	<li><a href="#" id="mypage_will_attend">찜하기</a></li>
		    	<li><a href="#" id="mypage_like">좋아요</a></li>
			</ul>
		  </div>
		  <div id="tabs-2" class="mypage_tabs_li">
		  	<ul>
		    	<li><a href="#" id="mypage_comment">댓글내역</a></li>
		    	<li><a href="#" id="mypage_qna">문의내역</a></li>
		    	<li><a href="#" id="mypage_funding">펀딩신청내역</a></li>
		    	<li><a href="#" id="mypage_coupon_info">나의 쿠폰</a><li>
			</ul>
		  </div>
		  <div id="tabs-3" class="mypage_tabs_li">
		  	<ul>
		    	<li><a href="#" id="mypage_mb_update">회원정보 수정</a></li>
		    	<li><a href="#" id="mypage_pw_update">비밀번호 변경</a></li>
			</ul>
		  </div>
		  <div id="tabs-4" class="mypage_tabs_li">
		  	<ul>
		    	<!-- <li><a href="#" id="mypage_shoppingcart">장바구니</a></li>
		    	<li><a href="#" id="mypage_receive_address">배송지관리</a></li> -->
		    	<li><a href="#" id="mypage_delivery_info">배송정보</a></li>
		    	<li><a href="#" id="mypage_payment_info">결제내역</a></li>
			</ul>
		  </div>
		</div>
	</div>
	
	<div id="mypage_bottom">									<!-- 조각페이지 영역 -->
		<%@ include file="mypage/attend_lec_manager/mypage_attending_lec.jsp"%>
	
	
<!--     	<div class="mypage_top_side">
	    	<h3>수강중인 강의</h3>
    	</div>
	    <div id="mypage_lec_ing">
	        <div class="mypage_lec">
	            <div class="mypage_lec_img"><img src="resource/img/mypage/sample1.jpg" width="300px" height="200px"></div>
	            <div class="mypage_lec_title">제목</div>
	            <div class="mypage_lec_des">#설명1 #설명2 #설명3</div>
	        </div>
	        <div class="mypage_lec">
	            <div class="mypage_lec_img"><img src="resource/img/mypage/sample2.jpg" width="300px" height="200px"></div>
	            <div class="mypage_lec_title">제목</div>
	            <div class="mypage_lec_des">#설명1 #설명2 #설명3</div>
	        </div>
	        <div class="mypage_lec">
	            <div class="mypage_lec_img"><img src="resource/img/mypage/sample3.jpg" width="300px" height="200px"></div>
	            <div class="mypage_lec_title">제목</div>
	            <div class="mypage_lec_des">#설명1 #설명2 #설명3</div>
	        </div>
	    </div>
	    	<div class="mypage_top_side">
		    	<h3>둘러본 강의</h3>
	    	</div>
	    <div id="mypage_lec_showen">
	        <div class="mypage_lec">
	            <div class="mypage_lec_img"><img src="resource/img/mypage/sample1.jpg" width="300px" height="200px"></div>
	            <div class="mypage_lec_title">제목</div>
	            <div class="mypage_lec_des">#설명1 #설명2 #설명3</div>
	        </div>
	        <div class="mypage_lec">
	            <div class="mypage_lec_img"><img src="resource/img/mypage/sample2.jpg" width="300px" height="200px"></div>
	            <div class="mypage_lec_title">제목</div>
	            <div class="mypage_lec_des">#설명1 #설명2 #설명3</div>
	        </div>
	        <div class="mypage_lec">
	            <div class="mypage_lec_img"><img src="resource/img/mypage/sample3.jpg" width="300px" height="200px"></div>
	            <div class="mypage_lec_title">제목</div>
	            <div class="mypage_lec_des">#설명1 #설명2 #설명3</div>
	        </div>
	    </div>
	    	<div class="mypage_top_side">
		    	<h3>추천 강의</h3>
	    	</div>
	    	<div class="mypage_top_side">
		    	<div><a class="mypage_a">더보기></a></div>
	    	</div>
	    <div id="mypage_lec_reco">
	        <div class="mypage_lec">
	            <div class="mypage_lec_img"><img src="resource/img/mypage/sample1.jpg" width="300px" height="200px"></div>
	            <div class="mypage_lec_title">제목</div>
	            <div class="mypage_lec_des">#설명1 #설명2 #설명3</div>
	        </div>
	        <div class="mypage_lec">
	            <div class="mypage_lec_img"><img src="resource/img/mypage/sample2.jpg" width="300px" height="200px"></div>
	            <div class="mypage_lec_title">제목</div>
	            <div class="mypage_lec_des">#설명1 #설명2 #설명3</div>
	        </div>
	        <div class="mypage_lec">
	            <div class="mypage_lec_img"><img src="resource/img/mypage/sample3.jpg" width="300px" height="200px"></div>
	            <div class="mypage_lec_title">제목</div>
	            <div class="mypage_lec_des">#설명1 #설명2 #설명3</div>
	        </div>
	    </div> -->
	</div>
</div>