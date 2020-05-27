<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="main_banner">
	<c:choose>
		<c:when test="${empty bannerList}">
			<%@ include file="../common/main_banner2.jsp"%>
		</c:when>
		<c:when test="${not empty bannerList}">
			<%@ include file="../common/main_banner.jsp"%>
		</c:when>
	</c:choose>
	
</div>
<div id="main_content" class="main_content">
	<div class="main_wrapper">
		<h2 class="main_title">카테고리</h2>
		<div class="main_category">
			<c:forEach items="${categoryMap }" var="ca" varStatus="vs">
				<div class="category_block">
					<a href="${pageContext.request.contextPath}/search_category.LF?category=${ca.key}" onfocus>
					<div id="category_icon">
						<img src="resources/imges/category/카테고리_${ca.value}.png" class="category_1" alt="${ca.value}">
					</div>
						<br><br> <span><c:out value="${ca.value}"/></span>
					</a>
				</div>
			</c:forEach>
		</div>
		<h2 class="main_title">추천 클래스</h2>
		<c:choose>
			<c:when test="${empty recoList}">
				<%@ include file="main_recommend_list2.jsp" %>
			</c:when>
			<c:when test="${not empty recoList}">
				<%@ include file="main_recommend_list.jsp" %>
			</c:when>
		</c:choose>
		
		
		<h2 class="main_title">이런 클래스는 어때요</h2>
		<c:choose>
			<c:when test="${empty nomalList}">
				<%@ include file="main_video_list2.jsp" %>
			</c:when>
			<c:when test="${not empty nomalList}">
				<%@ include file="main_video_list.jsp" %>
			</c:when>
		</c:choose>
		
	</div>
</div>

