<!-- 좋아요 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:if test="${!empty vdList}">
	<div class="mypage_bottom_info">
		<h2 class="mypage_bottom_title">좋아요한 강의</h2>
		<div class="mypage_bottom_contents">
	
			<div class="list_video_wrapper">
			
			
			<c:forEach var="vd" items="${vdList}" varStatus="vs">	
				<c:if test="${vs.index mod 4 eq 0}">
				<div class="list_video_block_row">
				</c:if>			
				<div class="list_video_block">
					<div class="list_video_thumb">
					<a href="#"> <img src="${vd.imgPath}" alt="lecfly lecture"></a>
					</div>
					<div class="list_video_info">
						<p class="video_info_category"><c:out value="${vd.category}" /></p>
						<p class="video_info_title"><c:out value="${vd.title}"/></p>
						<img src="<c:out value='${creImgPathList.get(vs.index)}' />" class="video_info_creator_img">
						<p class="video_info_creator_name"><c:out value="${creNickNameList.get(vs.index)}" /></p>
					</div>
				</div>
				<c:if test="${vs.index mod 4 eq 3 or vs.last}">
				</div>
				</c:if>					
			</c:forEach>		
		</div>
		
	</div>

</c:if>
			
<c:if test="${empty vdList}">
	<%@ include file="mypage_no_list.jsp"  %>
</c:if>