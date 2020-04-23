<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String ROOT = request.getContextPath(); %>

	<div class="lecfly_header_info_wrapper">
	<div class="lecfly_header_info nav_lecfly_info"><a herf="#">온라인 취미 영상 플랫폼 
	<span class="info_color">LECFLY</span> 이용안내 </a></div>
	</div>
<div class="header_wrapper" style="z-index:30;">

	
	<div class="header_column_logo">
		<img src="<%= ROOT %>/resource/img/logo/LecFly_LOGO_B_C.png"/>
	</div>
	<div class="header_column_search">
	<div id = backC>
		<form action="#" method="get">
			<input type="search" placeholder="검색어를 입력하세요" name="search" class="search_bar">
			<i class="fas fa-search search_btn"></i>
			<input type="submit" class="search_btn" >
		</form>
		</div>
	</div>
	<div class="header_column_menu">
		<ul>
			<li id= "CSCenter"><a href="#">고객섬김센터</a></li>
			<li id= "TEST"><a href="<%= ROOT %>/Creator/creatorcenter.jsp" >크리에이터센터</a>
			</li>
			<li  id= "TEST2" style="z-index:30;"><a href="<%=ROOT%>/ETC/login.jsp" >로그인</a></li>
		</ul>
	</div>
</div>

