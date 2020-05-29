<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	var sw = $('input[name=search]').val();
	if (sw != null && sw != '') {
		$('.search_word').text("'"+sw+"'");		
	} else {
		$('.search_word').text();		
	}
</script>
	
<div class="search_wrapper">
	<div class="search_top">
		<h2 class="search_title"><span class="search_word"></span>'${param.keyword }' 검색 결과</h2>
		<span class="search_result_count">${cateSize }</span>
		<ul class="sort">
			<li><select onchange="if(this.value) location.href=(this.value);">
					<option>카테고리선택</option>
					<option value="${pageContext.request.contextPath}/search_category.LF?category=1">미술</option>
					<option value="${pageContext.request.contextPath}/search_category.LF?category=2">음악</option>
					<option value="${pageContext.request.contextPath}/search_category.LF?category=3">요리</option>
					<option value="${pageContext.request.contextPath}/search_category.LF?category=4">라이프스타일</option>
					<option value="${pageContext.request.contextPath}/search_category.LF?category=5">운동</option>
					<option value="${pageContext.request.contextPath}/search_category.LF?category=6">커리어</option>
					<option value="${pageContext.request.contextPath}/search_category.LF?category=7">여행</option>
			</select></li>
<!-- 			<li><select> -->
<!-- 					<option>정확도순</option> -->
<!-- 					<option>최신순</option> -->
<!-- 					<option>인기순</option> -->
<!-- 					<option>만족도순</option> -->
<!-- 			</select></li> -->
		</ul>
	</div>
	<c:choose>
	
		<c:when test="${empty searchList }">
		<div class="main_video_wrapper">
			검색결과가 없습니다.
		</div>
		</c:when>
		<c:when test="${not empty searchList }">
		<div class="main_video_wrapper">
		<c:forEach items="${searchList}" var="lec" varStatus="vs">
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
					<img src="/images/2020/${fn:split(lec.titleImg,'_')[1]}/Img${lec.titleImg}" alt="${lec.title }">
					</div>
					<div class="main_video_info">
						<p class="main_video_info_category">
						<c:set var="i">${lec.category }</c:set>
						<c:out value="${categoryMap[i]}"/></p>
						<p class="main_video_info_title">"${lec.title}"</p>
						<img src="/images/2020/${fn:split(lec.titleImg,'_')[1]}/Img${lec.titleImg}" class="video_info_creator_img">
						<p class="main_video_info_creator_name">${lec.nickname}</p>
						<div class="main_video_like">
							<i class="fas fa-heart fa-lg"></i>${lec.likeCount} &nbsp;
<!-- 							<i class="far fa-thumbs-up fa-lg"></i>98% -->
						</div>
					</div>
				</div>
			<c:if test="${vs.count % 4 == 0 }">	
			</div>
			</c:if>
		</c:forEach>		
		</div>
		</c:when>
	</c:choose>
	

	</div>
</div>

