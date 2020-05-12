<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	$('.main_video_like').on("click")(function(){
		alert("클릭");
	});
</script>

<div class="main_video_wrapper">
	<div class="main_video_block_row"> <!-- 한 행에 전시할 강의 시작점마다 -->
	<c:forEach items="${recoList}" var="lec">
		<div class="main_video_block_rec">
			<div class="main_video_thumb_rec"><a href="#">
			<a href="#"><div class="main_video_thumb_btn"><i class="far fa-heart fa-2x"><c:out value="${status }"/></i></div>
			</a><!-- 좋아요 버튼 -->
				<img src="resources/imges/dummy_lec_img/life_style/life_style_0.jpg" alt="${lec.title}">
			</div>
			<div class="main_video_info">
				<p class="main_video_info_category">
				<c:set var="i">${lec.category }</c:set>
				<c:out value="${categoryMap[i]}"/></p>
				<p class="main_video_info_title">"${lec.title}"</p>
				<img src="resources/imges/dummy_lec_img/life_style/life_style_0.jpg" class="video_info_creator_img">
				<p class="main_video_info_creator_name">${lec.nickname}</p>
				<div class="main_video_like">
					<i class="fas fa-heart fa-lg"></i>${lec.likeCount} &nbsp;
					<i class="far fa-thumbs-up fa-lg"></i>98%</a>
				</div>
			</div>
		</div>
	</c:forEach>	
	</div>
</div>
			

	
