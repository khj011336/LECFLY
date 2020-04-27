<!-- 찜하기 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="mypage_bottom_info">
	<h2 class="mypage_bottom_title">찜하기한 강의</h2>
	<div class="mypage_bottom_contents">

		<div class="list_video_wrapper">
		
		<% for(int i = 1; i <= 9 ; i++ ){ %>		
			<% if(i % 4 == 1) {%>
			<div class="list_video_block_row">
			<% } %>		
			<div class="list_video_block nav_video_list">
				<div class="list_video_thumb">
				<a href="#"> <img src="resource/img/mypage/sample5.jpg" alt="lecfly lecture"></a>
				</div>
				<div class="list_video_info">
					<p class="video_info_category">라이프스타일</p>
					<p class="video_info_title">손뜨개 인형 만들기. 대바늘 뜨개로 엮는 유쾌한 인형 작지만 큰 행복</p>
					<img src="resource/img/mypage/sample5.jpg" class="video_info_creator_img">
					<p class="video_info_creator_name">뜨개질</p>
					<div class="main_video_like">
					<i class="fas fa-heart fa-lg"></i>5341 &nbsp;
					<i class="far fa-thumbs-up fa-lg"></i>98%
				</div>
				</div>
			</div>
			<% if(i % 4 == 0) {%>
			</div>
			<% } %>	
		<% } %>			
		
		</div>
	</div>
	
</div>