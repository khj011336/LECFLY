<!-- 수강중인 강의 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<c:if test="${!empty laList}">
	<div class="mypage_bottom_info">
		<h2 class="mypage_bottom_title">수강중인 강의</h2>
		<div class="mypage_bottom_contents">
			<div class="list_video_wrapper">
				<c:forEach var="la" items="${laList}" varStatus="vs">
				<c:if test="${vs.index mod 4 eq 0}">       <!-- 0번쨰에 4번쨰 8번째 -->
				<div class="list_video_block_row">
				</c:if>
<!-- 				<div class="list_video_block_row"> -->
					<div class="list_video_block nav_video_list">
						<div class="list_video_thumb nav_video_list">
							<a href="#">
								<img src="${la.videoPic}" alt="lecfly lecture"> 
								<div class="video_info_progressbar_bg">
									<div class="video_info_progressbar" style="width: 3%"></div>
								</div>
							</a>
						</div>
						<div class="list_video_info">
							<p class="video_info_title_n">${la.videoName}</p>
							<p class="video_info_date"><fmt:formatDate value="${la.showAt}" pattern="yyyy.MM.dd"/>&nbsp;시청</p>
						</div>
					</div>
<!-- 				</div> -->
				<c:if test="${vs.index mod 4 eq 3 or vs.last}"> <!-- 0번쨰에 4번쨰 8번째 -->
				</div>
				</c:if>
				</c:forEach>
			</div>	
		</div>	
	</div>
</c:if>

			
<c:if test="${empty laList}">
	<%@ include file="mypage_no_list.jsp"  %>
</c:if>