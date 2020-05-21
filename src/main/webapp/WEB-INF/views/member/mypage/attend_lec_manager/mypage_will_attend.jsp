<!-- 찜하기 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<c:if test="${not empty likeCountList}">	
	<div class="mypage_bottom_info">
		<h2 class="mypage_bottom_title">찜하기한 강의</h2>
		<div class="mypage_bottom_contents">
			<div class="list_video_wrapper">
			<c:forEach var="lc" items="${likeCountList}" varStatus="vs">
				<c:if test="${vs.index mod 4 eq 0}">
				<div class="list_video_block_row">
				</c:if>		
				<div class="list_video_block nav_video_list">
					<div class="list_video_thumb">
					<a href="#"> <img src="<c:out value='${imgPathList.get(vs.index)}' />" alt="lecfly lecture"></a>
					</div>
					<div class="list_video_info">
						<p class="video_info_category"><c:out value="${cateList.get(vs.index)}" /></p>
						<p class="video_info_title"><c:out value="${titleList.get(vs.title)}"/></p>
						<img src="<c:out value='${creImgList.get(vs.index)}' />" class="video_info_creator_img">
						<p class="video_info_creator_name"><c:out value="${nickNameList.get(vs.index)}" /></p>
						<div class="main_video_like">
						<i class="fas fa-heart fa-lg"></i><c:out value="${lc}" /> &nbsp;
						<!--  좋아요 누른사람/ 해당 클래스 강의를 듣는 멤버수 -->
						<i class="far fa-thumbs-up fa-lg"></i>98%
						</div>
					</div>
				</div>
				<c:if test="${vs.index mod 4 eq 3 or vs.last}">
				</div>
				</c:if>
			</c:forEach>
				
			</div>
		</div>
	
	</div>
</c:if>
			
<c:if test="${not empty msg_status}">
	<%@ include file="mypage_no_list.jsp"  %>
</c:if>