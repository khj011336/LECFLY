<!-- 1. 네비를 빼게 되면서 다시 1050> 1200으로 사이즈를 늘려야되는 필요가 있는 듯함.(가운데로 몰았으나 이쁘지가 않음.)(이버전은 따로 백업하기로) -->
<!-- 2. 로그인과 마찬가지로 색상 적용이 안되어 있음. 기준 색상대로 적용할 것. -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<link type="text/css" rel="stylesheet" href="resources/css/member/mypage.css">
	<link type="text/css" rel="stylesheet" href="resources/css/member/mypage_list.css">
	<link type="text/css" rel="stylesheet" href="resources/css/member/create_new_member.css">
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<script src="resources/js/member/mypage.js"></script>
			<div id="mypage_wrap"> 											<!-- 조각페이지 -->	
				<div id="mypage_top"> 										<!-- 개인정보 영역 -->
					<div id="mypage_pic">
			            <img src="resources/imges/logo/LecFly_SLOGO_LW_W.png" width="148px" height="148px">
			          	<input type="button" value="프로필 사진 편집" onclick="changeProPic()">
			        </div>
			        <div id="mypage_mb_IF">
			        	<br><br>
			        	<label><b>'<c:out value="${mb.name}" default="guest" />'</b> 회원님은</label>
			        	<br><br>
			        	<c:if test="${mb.checkCreator eq 0 or mb.checkCreator eq 1 or mb.checkCreator eq 2}">
			        		<h1><u>일반회원</u> 입니다.</h1>
			        	</c:if>
			        	<c:if test="${mb.checkCreator eq 3}">
			        		<h1><u>크리에이터 회원</u> 입니다.</h1>
			        	</c:if>
			        	<br><br>
			        	<a href="Creator/_classdes.jsp"><h3>크리에이터 신청하기</h3></a>
			        </div>
			        <div class="mypage_mb_t" id="mypage_mb_t_attendlec">
			        	<img src="resources/imges/mypage/mypage_video.png" class="mypage_1" alt="강의" width="64px" height="64px">
						<br><br><br>
						<span>강의 신청 목록<b><c:out value="${cntLecture}" default ="0" /></b> 개</span>
			        </div>
			        <div class="mypage_mb_t" id="mypage_mb_t_coupon">
			        	<img src="resources/imges/mypage/mypage_coupon.png" class="mypage_1" alt="쿠폰" width="64px" height="64px">
						<br><br><br>
						<span>쿠폰 <b><c:out value="${cntCoupon}" default="0" /></b> 개</span>
			        </div>
			        <div class="mypage_mb_t" id="mypage_mb_t_ticket">
			        	<img src="resources/imges/mypage/mypage_ticket.png" class="mypage_1" alt="이용권" width="64px" height="64px">
						<br><br><br>
						<span><b><c:out value="${ticketFrontName}" default="" /></b> <c:out value="${ticketName}" default="보유중인 티켓 없음" /></span>
						<br>
						<p>
							<c:set var="lastCt" value="${(fn:length(strCateList) - 1)}" />
							<c:forEach var="strCate" items="${strCateList}" varStatus="vs">
								<a><c:out value="${strCate}"/></a>
								<c:if test="${vs.index ne lastCt}"> / </c:if>
								<c:if test="${vs.index eq lastCt}"> </c:if>
							</c:forEach>
						</p>
						<br>
						<span><small><fmt:formatDate value="${ticketEndDay}" pattern="yyyy-MM-dd" />까지</small></span>
			        </div>
			    </div>
				<div id="mypage_middle">									<!-- 정보 영역 및 메뉴영역 -->
				    <div id="tabs" class="mypage_tabs">
				    	<div id="tabs-mom">
						  <ul>
						    <li><a href="#tabs-1" id="tabs-mom-1">수강 관리</a></li>
						    <li><a href="#tabs-2" id="tabs-mom-2">활동 내역</a></li>
						    <li><a href="#tabs-3" id="tabs-mom-3">정보 관리</a></li>
						    <li><a href="#tabs-4" id="tabs-mom-4">주문/배송관리</a></li>
						  </ul>
						 </div>
					  <div id="tabs-1" class="mypage_tabs_li mypage_tabs_none">
					  	<ul>
					    	<li><a href="#" id="mypage_attending_lec">수강중인 강의</a></li>
					    	<li><a href="#" id="mypage_will_attend">찜하기</a></li>
					    	<li><a href="#" id="mypage_like">좋아요</a></li>
						</ul>
					  </div>
					  <div id="tabs-2" class="mypage_tabs_li mypage_tabs_none">
					  	<ul>
					    	<li><a href="#" id="mypage_comment">댓글내역</a></li>
					    	<li><a href="#" id="mypage_qna">문의내역</a></li>
					    	<li><a href="#" id="mypage_coupon_info">나의 쿠폰</a><li>
						</ul>
					  </div>
					  <div id="tabs-3" class="mypage_tabs_li mypage_tabs_none">
					  	<ul>
					    	<li><a href="#" id="mypage_mb_update">회원정보 수정</a></li>
					    	<li><a href="#" id="mypage_pw_update">비밀번호 변경</a></li>
						</ul>
					  </div>
					  <div id="tabs-4" class="mypage_tabs_li mypage_tabs_none">
					  	<ul>
					    	<li><a href="#" id="mypage_delivery_info">배송정보</a></li>
					    	<li><a href="#" id="mypage_payment_info">결제내역</a></li>
						</ul>
					  </div>
					</div>
				</div>
				
				<div id="mypage_bottom">									<!-- 조각페이지 영역 -->
					<c:if test="${not empty mpNone}">
						<%@ include file="mypage/attend_lec_manager/mypage_attending_lec.jsp"%>
					</c:if>
					<c:if test="${empty mpNone}">
						
					</c:if>
				</div>
			</div>
