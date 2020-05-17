<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>상품 상세페이지</title>
<link type="text/css" rel="stylesheet" href="resources/css/payment/pay_goodsDetail.css">
<div id="register_wrapper">
	<div id="register_nav">
<!-- 		<video class="register_video" controls> -->
<!-- 			<source src="resource/video/soap.mp4" type="video/ogg"> -->
<!-- 		</video> -->
		<div>
			<img src="${lec.titleImg}" alt="클래스 소개 img">
		</div>
		
		<br> <br>
		<ul id="register_tag_ul">
			<li class="register_tag_li"><a class="register_tag_li_a"
				href="#register_lecture_info">강의소개</a> |</li>
			<li class="register_tag_li"><a class="register_tag_li_a"
				href="#register_kit_info">KIT 소개</a> |</li>
			<li class="register_tag_li"><a class="register_tag_li_a"
				href="#register_curri_info">커리큘럼</a> |</li>
			<li class="register_tag_li"><a class="register_tag_li_a"
				href="#register_writer_info">작가 소개</a> |</li>
			<li class="register_tag_li"><a class="register_tag_li_a"
				href="#register_review_info">후기</a> |</li>
			<li class="register_tag_li"><a class="register_tag_li_a"
				href="#register_qna_info">QnA</a></li>
		</ul>
		<br> <br>
		<h1 id="register_lecture_info">강의소개</h1>
		<p id="register_lec">
			<img class="register_soap_img" src="${infoImg}"
				alt="soap"> <img class="register_soap_img"
				src="${infoImgb}" alt="soap"> <br> <br>
			<br> <br> <br> <br> <br> <br> <br>
			<br> <br> <br> ${lec.info }
		</p>
		<br> <br>
		<h1 id="register_kit_info">KIT 소개</h1>
		<br> <br> <img class="kit_img"
			src="${kit.img}" alt="kit"> <br> <br>
		<h1 id="register_curri_info">커리큘럼</h1>
		<table id="register_tb">
			<c:forEach var="vd" items="${vdList}" varStatus="vs">
				<tr>
					<td class="register_td">${vs.index + 1}</td>
					<td class="register_td">${vd.title}</td>
					<td class="register_td register_tb_num">${vd.duration}</td>
				</tr>
			</c:forEach>
		</table>
		<br> <br>
		<h1 id="register_writer_info">작가소개</h1>
		<p id="register_wri">${creInfo}</p>
		<br> <br>
		<h1 id="register_review_info">후기</h1>
		<br> <br>
		<p id="register_review">
			<span class="review_name">명주</span> <a href="#">★</a><a href="#">★</a><a
				href="#">★</a><a href="#">★</a><a href="#">★</a> <span
				class="review_week"> <small>일주일 전</small></span> <small>

				저렴하고 양도 적당하고 좋네요! 저는 남은 재료랑 미니하트 다 써서 몽땅 큰 비누 만들었어요~ 그런데 비누가 굳을까봐
				초조해져서 차분히 할 수가 없는 것 같아요 계속 초초..ㅎㅎ 다음에 하면 더 잘할 수 있을 것 같아요! 감사합니다!</small>
		</p>
		<p id="register_review">
			<span class="review_name">수현</span> <a href="#">★</a><a href="#">★</a><a
				href="#">★</a><a href="#">★</a><a href="#">★</a> <span
				class="review_week"> <small>일주일 전</small></span>
		</p>
		<p id="register_review">
			<span class="review_name">건우</span> <a href="#">★</a><a href="#">★</a><a
				href="#">★</a><a href="#">★</a><a href="#">★</a> <span
				class="review_week"> <small>한달 전</small></span>
		</p>
		<p id="register_review">
			<span class="review_name">세현</span> <a href="#">★</a><a href="#">★</a><a
				href="#">★</a><a href="#">★</a><a href="#">★</a> <span
				class="review_week"> <small>3개월 전</small></span>
		</p>
		<p id="register_review">
			<span class="review_name">기민</span> <a href="#">★</a><a href="#">★</a><a
				href="#">★</a><a href="#">★</a><a href="#">★</a> <span
				class="review_week"> <small>1년 전</small></span>
		</p>
		<br> <br>
		<h1 id="register_qna_info">QnA</h1>
		<br>
		
		<c:forEach var="rp" items="${ccList}" varStatus="vs">
			<br> <i class="fas fa-user"> ${rp.cMName} <input type="date" value="<fmt:formatDate value='${rp.cMDate}' pattern='yyyy-MM-dd' />" readonly>
			${rp.cMDate}
			</i> <br> <br> ${rp.cMIF}  <br>
		</c:forEach>
		 <br>
		<textarea name="feedback" rows="5" cols="20" placeholder="댓글을 입력해주세요"></textarea>
		<input type="button" value="입력">
	</div>
</div>
<div id="register_content">
	${lecCategory}
	<h1 id="register_content_title">
		${lec.subTitle}
	</h1>
	<div id="register_wri_name">by. ${creName}</div>
	<br> <br>
	<p>
		<span class="register_kit_select">&lt;준비물 KIT&gt;</span> <span
			class="register_kit_info"><a href="#register_kit_info">구성 안내 바로보기&gt;</a></span>
	</p>
	<br> <br>
	<select class = "register_kit_select">
		<option selected="selected">선택안함</option>
		<option>스타터를 위한 KIT (18,000원)</option>
	</select>  
	<label for="register_soap" id="register_soap_title">장바구니 담기</label> <br>
	<br> <br> <span class="register_like_num"><i
		class="fas fa-heart"></i> ${lec.likeCount} </span> &nbsp; &nbsp; &nbsp; <span
		class="register_lec_pick"> 강의 찜하기 </span> <br> <br> <br>
	<p id="register_warning">'라이프스타일' 회원권 보유시 신청가능합니다.</p>
	<br> <span id="register_lec_apply">강의 신청하기</span>
</div>
<script>
	// 별점 추가
	$('#register_review a').click(function() {
		$(this).parent().children("a").removeClass("on"); /* 별점의 on 클래스 전부 제거 */
		$(this).addClass("on").prevAll("a").addClass("on"); /* 클릭한 별과, 그 앞 까지 별점에 on 클래스 추가 */
		return false;
	});

	// 장바구니로 이동
	$(document).on("click", '#register_soap_title', function() {
		$("#homemain").load("payment/shoppingCart.jsp");
	});
	// 결제페이지로 이동
	$(document).on("click", '#register_lec_apply', function() {
		$("#homemain").load("payment/fundingPayment.jsp");
	});
</script>
