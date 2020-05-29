<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>상품 상세페이지</title>
<link type="text/css" rel="stylesheet" href="resources/css/payment/pay_goodsDetail.css">
<script type="text/javascript">
	$(document).ready(function() {
		$("#moveCart").on("click", function() {
			var URLHD = '${pageContext.request.contextPath}/';
 			var url = URLHD+'check_pay_cart.LF';
 			var kitId = $("input[name=kit_id]").val();
 			var params = "kitId=" + kitId;
 			$.ajax({
				type: 'POST',
				url : url,
				data: params,
				dataType: "JSON",
				success: function(res, status ,xhr){
					console.log("res = " + res  ); 
					// res 가 1이면 해당회원의 키트가 장바구니에 존재  0이면 존재하지않음
					var r = res.c;
					console.log("r = " + r);
					if(r == 1){
						console.log("알은 1");
						location.href = "#goods_detail_modal";
					} else {
						console.log("알은 1이아님");
						location.href = "#goods_detail_modal_popup_submitbtn";
					}
				},
				error: function(status, xhr){
					console.log("실패");
				}
			});

			
		});
		
		
		$("#goods_detail_modal_popup_submitbtn").on("click", function() {
			var URLHD = '${pageContext.request.contextPath}/';
			var url = URLHD+'pay_cart.LF';
			var kitId = $("input[name=kit_id]").val();
			console.log("goods_detail 눌렀을때 kitId = " + kitId);
			var params = "kitId=" + kitId;
			$.ajax({
				type: 'POST',
				url : url,
				data: params,
				success: function(res, status ,xhr){
					alert("성공");
					console.log(res);
					$('#homemain').html(res);
				},
				error: function(status, xhr){
					alert("실패");
				}
			});
		});
		
		//댓글추가
		$("#submit_comment").on("click", function() {
			var URLHD = '${pageContext.request.contextPath}/';
			var url = URLHD+'insert_comment.LF';
			var comment = $("textarea[name=feedback]").val();
			var lecId = ${lec.id};
			console.log("댓글내용" + comment + "/게시글id" + lecId);
			var params = "ct=" + comment + "&lecId=" + lecId;
			$.ajax({
				type: 'POST',
				url : url,
				data: params,
	 			dataType: "JSON",
				success: function(res, status ,xhr){
					console.log(res.result);
					$('#comment_div').html().remove();
					$('#comment_div').html(res.temp);
				},
				error: function(status, xhr){
					alert("실패");
				}
			});
		});
		// 대댓글 달기
		$("#submit_under_ct").on("click", function() {
			var URLHD = '${pageContext.request.contextPath}/';
			var url = URLHD+'insert_under_comment.LF';
			var comment = $("textarea[name=feedback]").val();
			var lecId = ${lec.id};
			console.log("댓글내용" + comment + "/게시글id" + lecId);
			var params = "ct=" + comment + "&lecId=" + lecId;
			$.ajax({
				type: 'POST',
				url : url,
				data: params,
	 			dataType: "JSON",
				success: function(res, status ,xhr){
					console.log(res.result);
					$('#comment_div').html().remove();
					$('#comment_div').html(res.temp);
				},
				error: function(status, xhr){
					alert("실패");
				}
			});
		});
		
		// 강의 수강페이지로 이동(비디오페이지)
		$('#register_lec_apply').on("click", function() {
			console.log('클릭됨');
			var mbId = ${member.id};
			var lecId = ${lecId};
			var lecCate = ${strCategory};
			var mbCate0 = ${mbStrCate0};
			var mbCate1 = ${mbStrCate1};
			var mbCate2 = ${mbStrCate2};
			var URL = "${pageContext.request.contextPath}/creator_lecplay.LF?mbId="+mbId+"&lecId="+lecId+"&lecCate="+lecCate+
			"&mbC0="+mbCate0+"&mbC1="+mbCate1+"&mbC2="+mbCate2;
			console.log(URL);
			location.href = URL;
		});
	});
	
	// 대댓글 입력칸?
// 	${'#under_comment'}.click(function() {
// 		${'#under_ct_form'}.html(
// 				"<textarea name='feedback' rows='5' cols='20' placeholder='댓글을 입력해주세요'></textarea><input id='submit_under_ct' type='button' value='입력'>");
// 	});
	
	
	// 별점 추가
	$('#register_review a').click(function() {
		$(this).parent().children("a").removeClass("on"); /* 별점의 on 클래스 전부 제거 */
		$(this).addClass("on").prevAll("a").addClass("on"); /* 클릭한 별과, 그 앞 까지 별점에 on 클래스 추가 */
		return false;
	});

	
</script>
<div id="register_wrapper">
	<div id="register_nav">
		<div class="register_video_img">
			<img src='<c:out value="${videos.play_imgs}" default="비디오 이미지.jpg" />' alt="비디오 이미지">
		</div>
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
			<img class="register_soap_img" src="<c:out value='${lec.infoImg}' default='soap.jpg' />">
			<img class="register_soap_imgb" src="<c:out value='${lec.infoImgb}' default='soapb.jpg' />">
			${lec.info}
		<br>
		</p>
		<br> <br>
		<h1 id="register_kit_info">KIT 소개</h1>
		<input type="hidden" name="kit_id" value="${kit.id}">
		<br> <br> <img class="kit_img" src='<c:out value="${kit.imgPath}" default="abc.jpg"></c:out>'> <br> <br>
		<h1 id="register_curri_info">커리큘럼</h1>
		<table id="register_tb">
			<c:forEach var="vd" items="${vidList}" varStatus="vs">
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
		<div id="lecture_reviews">
			${postscript}
<!-- 			<p id="register_review"> -->
<!-- 				<span class="review_name">명주</span> <a href="#">★</a><a href="#">★</a><a -->
<!-- 					href="#">★</a><a href="#">★</a><a href="#">★</a> <span -->
<!-- 					class="review_week"> <small>일주일 전</small></span> <small> -->
	
<!-- 					저렴하고 양도 적당하고 좋네요! 저는 남은 재료랑 미니하트 다 써서 몽땅 큰 비누 만들었어요~ 그런데 비누가 굳을까봐 -->
<!-- 					초조해져서 차분히 할 수가 없는 것 같아요 계속 초초..ㅎㅎ 다음에 하면 더 잘할 수 있을 것 같아요! 감사합니다!</small> -->
<!-- 			</p> -->
<!-- 			<p id="register_review"> -->
<!-- 				<span class="review_name">수현</span> <a href="#">★</a><a href="#">★</a><a -->
<!-- 					href="#">★</a><a href="#">★</a><a href="#">★</a> <span -->
<!-- 					class="review_week"> <small>일주일 전</small></span> -->
<!-- 			</p> -->
<!-- 			<p id="register_review"> -->
<!-- 				<span class="review_name">건우</span> <a href="#">★</a><a href="#">★</a><a -->
<!-- 					href="#">★</a><a href="#">★</a><a href="#">★</a> <span -->
<!-- 					class="review_week"> <small>한달 전</small></span> -->
<!-- 			</p> -->
<!-- 			<p id="register_review"> -->
<!-- 				<span class="review_name">세현</span> <a href="#">★</a><a href="#">★</a><a -->
<!-- 					href="#">★</a><a href="#">★</a><a href="#">★</a> <span -->
<!-- 					class="review_week"> <small>3개월 전</small></span> -->
<!-- 			</p> -->
<!-- 			<p id="register_review"> -->
<!-- 				<span class="review_name">기민</span> <a href="#">★</a><a href="#">★</a><a -->
<!-- 					href="#">★</a><a href="#">★</a><a href="#">★</a> <span -->
<!-- 					class="review_week"> <small>1년 전</small></span> -->
<!-- 			</p> -->
		</div>
		<br> <br>
		<h1 id="register_qna_info">QnA</h1>
		<br>
		<div id="comment_div">
			${comment}
<%-- 			<c:forEach var="rp" items="${ccList}" varStatus="vs"> --%>
<%-- 				<br> <i class="fas fa-user"><label>${rp.mbNic}님</label></i> --%>
<%-- 				<label style="padding-left:45px;">${rp.comment}</label> --%>
<!-- 				<br> -->
<%-- 				<label><fmt:formatDate value='${rp.createdAt}' pattern='yyyy-MM-dd HH:mm:ss'/></label> --%>
<!-- 				<input type="hidden" value="rp.id"><i style="padding-left:10px" class="fas fa-comments"></i> -->
<!-- 				<br> -->
<%-- 			</c:forEach> --%>
<!-- 			<table id="comment_table"> -->
<%-- 				<c:forEach var="rp" items="${ccList}" varStatus="vs"> --%>
<!-- 				<tr> -->
<%-- 					<td><i class="fas fa-user"><label>${rp.mbNic}님</label></i></td> --%>
<%-- 					<td><label style="padding-left:45px;">${rp.comment}</label></td> --%>
<%-- 					<td><label><fmt:formatDate value='${rp.createdAt}' pattern='yyyy-MM-dd HH:mm:ss'/></label></td> --%>
<!-- 					<td><a href="#">댓글</a></td> -->
<!-- 				</tr> -->
<%-- 				</c:forEach> --%>
<!-- 				<tr> -->
<!-- 					<td></td><td></td><td></td> -->
<!-- 				</tr> -->
<!-- 			</table> -->
<%-- 			<c:forEach var="rp" items="${ccList}" varStatus="vs"> --%>
<%-- 				<br> <i class="fas fa-user"> ${rp.mbId} <input type="date" value="<fmt:formatDate value='${rp.createdAt}' pattern='yyyy년-MM월-dd일 - HH시 mm분'/>" readonly> --%>
<%-- 				${rp.comment} --%>
<%-- 				</i> <br> <br> ${rp.mbNic} <br> --%>
<%-- 			</c:forEach> --%>
		</div>
		 <br>
		<textarea name="feedback" rows="5" cols="20" placeholder="댓글을 입력해주세요"></textarea>
		<input id="submit_comment" type="button" value="입력">
	</div>
</div>
<div id="register_content">
	<c:out value="${cate}"  default="없음"/>
	<br><br><br>
	<h1 id="register_content_title">
		<c:out value="${lec.subTitle}" default="없음" />	
	</h1>
	<div id="register_wri_name">by. ${creNickname}</div>
	<br> <br>
	<p>
		<span class="register_kit_select">&lt;준비물 KIT&gt;</span> <span
			class="register_kit_info"><a href="#register_kit_info">구성 안내 바로보기&gt;</a></span>
	</p>
	<br> <br>
	<select class = "register_kit_select">
		<option selected="selected">선택안함</option>
		<option>스타터를 위한 KIT (${kit.price})</option>
	</select>
	<input id="moveCart" type="button" value="장바구니 담기">
	<div id="goods_detail_modal" class="overlay">
		<div class="popup">
			
			<a class="close" href="#">x</a>
			<div class="goods_detail_modal_popup_content">
				<h2 class="mypage_mb_isupdate">이미 등록되어있는 상품입니다.</h2>
			</div>
			<input id="goods_detail_modal_popup_submitbtn" type="button" value="확인">
		</div>
	</div>
	<br> <br> <span class="register_like_num"><i
		class="fas fa-heart"></i> ${lec.likeCount} </span> &nbsp; &nbsp; &nbsp; <span
		class="register_lec_pick"> 강의 찜하기 </span> <br> <br> <br>
	<p id="register_warning">'라이프스타일' 회원권 보유시 신청가능합니다.</p>
	<br> <span id="register_lec_apply">강의 신청하기</span>
	
<!-- 	<div id="will_show_update_confirm" class="overlay"> -->
<!-- 		<div class="popup"> -->
<!-- 			<a class="close" href="#">x</a> -->
<!-- 			<div class="mypage_mb_update_popup_content"> -->
<%-- 				<h2 class="mypage_mb_isupdate">'${member.name}'님 회원정보 수정 성공</h2> --%>
<!-- 			</div> -->
<!-- 			<input id="mypage_mb_update_popup_submitbtn" type="button" value="확인" class="close"> -->
<!-- 		</div> -->
<!-- 	</div> -->
</div>