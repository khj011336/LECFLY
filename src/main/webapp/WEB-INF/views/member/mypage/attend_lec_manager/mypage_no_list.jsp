<!-- 좋아요 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="mypage_bottom_info">
	<h2 class="mypage_bottom_title"><c:out value="${msg_status}" default="내"/> 강의</h2>
	<button class="edit_list_btn">목록편집</button>
	<div class="mypage_bottom_contents">
		<div class="mypage_nolist_wrapper">
			<div class="nolist_block">
				<img src="resources/imges/mypage/no_video_list.png" class="nolist_mark"><br>
				<span class="nolist_info"><c:out value="${mp_msg}" default="강의 내역이 없습니다." /></span>
			</div>
		</div>
	</div>
</div>