<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<style>
.main_video_block{
cursor: pointer;
}
.main_video_block_rec{
cursor: pointer;
}
</style>
	<script>
function gotoDetail(CFID){
	location.href= "goods_detail.LF?CFId="+CFID;
}
</script>
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
			 
				<div class="category_block">
					<a href="${pageContext.request.contextPath}/search_category.LF?category=0" onfocus>
					<div id="category_icon">
						<img src="resources/imges/category/ca_all.png" class="category_1" alt="${ca.value}">
					</div>
						<br><br> <span><c:out value="전체"/></span>
					</a>
				</div>
				<div class="category_block">
					<a href="${pageContext.request.contextPath}/search_category.LF?category=1" onfocus>
					<div id="category_icon">
						<img src="resources/imges/category/ca_art.png" class="category_1" alt="${ca.value}">
					</div>
						<br><br> <span><c:out value="미술"/></span>
					</a>
				</div>
				<div class="category_block">
					<a href="${pageContext.request.contextPath}/search_category.LF?category=2" onfocus>
					<div id="category_icon">
						<img src="resources/imges/category/ca_Music.png" class="category_1" alt="${ca.value}">
					</div>
						<br><br> <span><c:out value="음악"/></span>
					</a>
				</div>
				<div class="category_block">
					<a href="${pageContext.request.contextPath}/search_category.LF?category=3" onfocus>
					<div id="category_icon">
						<img src="resources/imges/category/ca_Cooking.png" class="category_1" alt="${ca.value}">
					</div>
						<br><br> <span><c:out value="요리"/></span>
					</a>
				</div>
				<div class="category_block">
					<a href="${pageContext.request.contextPath}/search_category.LF?category=4" onfocus>
					<div id="category_icon">
						<img src="resources/imges/category/ca_LifeStyle.png" class="category_1" alt="${ca.value}">
					</div>
						<br><br> <span><c:out value="라이프스타일"/></span>
					</a>
				</div>
				<div class="category_block">
					<a href="${pageContext.request.contextPath}/search_category.LF?category=5" onfocus>
					<div id="category_icon">
						<img src="resources/imges/category/ca_WorkingOut.png" class="category_1" alt="${ca.value}">
					</div>
						<br><br> <span><c:out value="운동"/></span>
					</a>
				</div>
				<div class="category_block">
					<a href="${pageContext.request.contextPath}/search_category.LF?category=6" onfocus>
					<div id="category_icon">
						<img src="resources/imges/category/ca_Career.png" class="category_1" alt="${ca.value}">
					</div>
						<br><br> <span><c:out value="커리어"/></span>
					</a>
				</div>
				<div class="category_block">
					<a href="${pageContext.request.contextPath}/search_category.LF?category=7" onfocus>
					<div id="category_icon">
						<img src="resources/imges/category/ca_Journey.png" class="category_1" alt="${ca.value}">
					</div>
						<br><br> <span><c:out value="${ca.value}"/></span>
					</a>
				</div>
			 
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

