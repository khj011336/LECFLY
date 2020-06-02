<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>상품 상세페이지</title>
<link type="text/css" rel="stylesheet" href="resources/css/creator/pay_goodsDetailtest.css">
<script type="text/javascript">

function goTrack(Cfid){
	location.href = "creator_lecplay.LF?CFId="+Cfid;
}
$(document).ready(function() {
	$("#moveCart").on("click", function() {
		var URLHD = '${pageContext.request.contextPath}/';
			var url = URLHD+'pay_cart.LF';
			var kitId = $("input[name=kit_id]").val();
			console.log(kitId);
			var param = "kitId=" + kitId + "&gdType=kit";
			$.ajax({
			type: 'POST',
			url : url,
			data: param,
			dataType: "JSON",
			success: function(res, status ,xhr){
				// res == 1 키트 Id 존재 / 0 이면 존재하지 않음(장바구니 페이지로 이동)
				var r = res.c;
				console.log("r = " + r);
				if (r == 0) {
					alert("상품이 등록되었습니다 !");
					$("#homemain").load('${pageContext.request.contextPath}' + '/show_cart.LF');
				} else if( r == 1 || r == 2 ) {
					location.href = "#goods_detail_modal";
				} else {
					if( r == 3 )
					$("#homemain").load('${pageContext.request.contextPath}' + '/login.LF');
				}
			},
			error: function(status, xhr) {
				console.log("실패");
			}
		});
	});
	
	$("#submit_comment").on("click", function() {
		var URLHD = '${pageContext.request.contextPath}/';
		var url = URLHD+'insert_comment.LF';
		var comment = $("textarea[name=feedback]").val();
		var lecId = ${CFId};
		console.log("댓글내용" + comment + "/게시글id" + lecId);
		var params = "ct=" + comment + "&CFId=" + lecId;
		$.ajax({
			type: 'POST',
			url : url,
			data: params,
 			dataType: "JSON",
			success: function(res, status ,xhr){
				console.log(res.result);
				$('#comment_all').remove();
				$('#comment_div').html(res.temp);
			},
			error: function(status, xhr){
				alert("실패");
			}
		});
	});
	
	$(".register_like_num").on("click", function() {
		console.log("좋아요버튼누름");
		var likeCnt = $(".register_like_num i:first").text();
		var lecId = $("input[name=like_lec]").val();
		console.log("likeCnt = " + likeCnt + " lecId = " + lecId);
		// ajax 보낼거준비 lecId + 좋아요개수 + 멤버는 세션에 존재함
		var url = "mb_click_lecture_like.LF" 	
		var params = "like_cnt=" + likeCnt + "&lec_id=" + lecId;
		$.ajax({
			type:"POST",
			url: url,
			data: params,
			dataType: "JSON",
			success: function(res, status, xhr) {
				console.log(res);
				// map 으로 받아서 res.likeCnt + 하트모양 받아야됨 그거를 넣을곳은?
				// $(".register_like_num i:first").text(res.likeCnt);
				// 하트 빈하트인지 색칠된 하트인지는 고민해보자.
				if(res.likeCnt != null) {
					$(".register_like_num i:first").text(res.likeCnt);
				}
			},
			error: function(status, xhr) {
				
			}
		});
		
	});
	
	
	
});

 </script>



<div id="register_wrapper">
	<div id="register_nav">
		<div class="register_video_img">
			<img src='<c:out value="${crPath}${lec.titleImg}" default="비디오 이미지.jpg"  />' id ="goodsimgcss" alt="비디오 이미지">
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
			<img class="register_soap_img" src="<c:out value='${crPath}${lec.infoImg}' default='soap.jpg' />">
			<img class="register_soap_imgb" src="<c:out value='${crPath}${lec.infoImgb}' default='soapb.jpg' />">
<!-- 			강의소개단 -->
			<div style="margin-left: 10px; float: center; font-size:22px; width: 700px; font-weight: bold;">
			${lec.info}
			</div>

		<br>

		<br> <br>
		<h1 id="register_kit_info">KIT 소개</h1>
		<input type="hidden" name="kit_id" value="${kit.id}">
		<br> <br><div id = "selftest"> <img class="kit_img" src='<c:out value="${crPath}${kit.imgPath}" default="abc.jpg"/>' onError ="this.src='resources/imges/logo/LecFly_SLOGO_W_W.png'"></div> <br> <br>
		<p id = "infoself">${kit.detailInfo}</p>
		<h1 id="register_curri_info">커리큘럼</h1>
		<table id="register_tb">

		<c:if test= "${not empty video }">
		 <c:forEach begin="0" end="${video.size()-1}" varStatus="vs">
				<tr>
					<td class="register_td" style="width: 600px;">${vs.index+1}.${video[vs.current].title}</td>
					<td class="register_td register_tb_num" rowspan="2" style="width: 100px; text-align: center;" >${video[vs.current].duration}분</td>
				</tr>
				<tr>
					<td class="register_td" style="font-size: 15px; font-weight: normal; padding-left: 30px;">${video[vs.current].info}</td>

				</tr>
		</c:forEach>
				 </c:if>

		</table>
		<br> <br>
		<h1 id="register_writer_info">작가소개</h1>
		<div><img class="register_soap_imgcb" src="<c:out value='${crPath}${cre.imgPath}' default='soap.jpg' />"></div>
		<p id="register_wri"> ${cre.info}</p>
		<br> <br>
		<h1 id="register_review_info">후기</h1>
		<br>
			${!empty postscript ? postscript: ''}
		<br>
		<h1 id="register_qna_info">QnA</h1>
		<div id="comment_div">
			${!empty comment ? comment : ''}
		</div>
		<textarea name="feedback" rows="5" cols="20" placeholder="댓글을 입력해주세요"></textarea>
		<input id="submit_comment" type="button" value="입력">
	</div>
</div>
<div id="register_content">
	<br><br><br>
	<h1 id="register_content_title">
		<c:out value="${lec.title}" default="없음" />
	</h1>
	<div id="register_wri_name">by. ${cre.nickname}</div>
	<br> <br>
	<p>
		<span class="register_kit_select">&lt;준비물 KIT&gt;</span> <span
			class="register_kit_info"><a href="#register_kit_info">구성 안내 바로보기&gt;</a></span>
	</p>
	<br> <br>
	<select class = "register_kit_select" style ="overflow: hidden;  width: 270px;">
		<option>${kit.title } (${kit.price})</option>
		<option >선택안함</option>
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
	<input type="hidden" name="like_lec" value="${lec.id}">
	<br> <br> <span class="register_like_num"><i
		class="fas fa-heart">${lec.likeCount}</i>  </span> &nbsp; &nbsp; &nbsp; <span
		class="register_lec_pick"> 강의 찜하기 </span> <br> <br> <br>
	<p id="register_warning">회원권 보유시 신청가능합니다.</p>
	<br> <span id="register_lec_apply" onclick="goTrack(${lec.id})">강의 시청하기</span>
</div>
