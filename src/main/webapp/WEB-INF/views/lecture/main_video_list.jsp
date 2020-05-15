<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="main_video_wrapper">

	<c:forEach items="${nomalList}" var="lec" varStatus="vs">
	<c:if test="${vs.count % 4 == 1 }">
	<div class="main_video_block_row"> <!-- 한 행에 전시할 강의 시작점마다 : 4개마다 --> 
	</c:if>
		<div class="main_video_block">
			<div class="main_video_thumb">
				<!-- 좋아요 버튼 --> 
				<div class="main_video_thumb_btn">
					<c:forEach var="lik" items="${likeList}">
	  					<c:if test="${lik eq lec.id}">
	    					<a href="unlike_lecture.LF"><i class="far fa-heart fa-2x" style="color: orangered"></i></a>
	  					</c:if>
			 			<c:if test="${lik ne lec.id}">
	    					<a href="like_lecture.LF"><i class="far fa-heart fa-2x" style="color: white"></i></a>
	  					</c:if>
					</c:forEach>
				</div> 
				<!-- 좋아요 버튼 --> 
				<img src="resources/imges/dummy_lec_img/art/art_2m.jpg" alt="${lec.title }">
			</div>
			<div class="main_video_info">
				<p class="main_video_info_category">
				<c:set var="i">${lec.category }</c:set>
				<c:out value="${categoryMap[i]}"/></p>
				<p class="main_video_info_title">"${lec.title}"</p>
				<img src="resources/imges/dummy_lec_img/art/art_2m.jpg" class="video_info_creator_img">
				<p class="main_video_info_creator_name">${lec.nickname}</p>
				<div class="main_video_like">
					<i class="fas fa-heart fa-lg"></i>${lec.likeCount} &nbsp;
<!-- 					<i class="far fa-thumbs-up fa-lg"></i>98% -->
				</div>
			</div>
		</div>
	<c:if test="${vs.count % 4 == 0 }">	
	</div>
	</c:if>
	</c:forEach>
</div>
			

	
