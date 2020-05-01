<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav id="sidebar" class="sidebar-wrapper">
	<div class="sidebar-content">
		<div class="sidebar-brand">
			<a href="../home.jsp">LECFLY HOME</a>
			<div id="close-sidebar">
				<i class="fas fa-times"></i>
			</div>
		</div>
		<div class="sidebar-header">
			<!-- <div class="user-pic">
				<img class="img-responsive img-rounded"
					src="https://raw.githubusercontent.com/azouaoui-med/pro-sidebar-template/gh-pages/src/img/user.jpg"
					alt="User picture">
			</div> -->
			<div class="user-info">
				<span class="user-name"> <a href="#" id="nav_admin_main"><strong>LECFLY ADMIN</strong></a></span> 
				<!-- <span class="user-role">관리자 MAIN</span> --> 
				<span class="user-status">
					<i class="fa fa-circle"></i> <span>Online</span>
				</span>
			</div>
		</div>
		<!-- sidebar-header  -->
		<div class="sidebar-search">
			<div>
				<div class="input-group">
					<input type="text" class="form-control search-menu"
						placeholder="Search...">
					<div class="input-group-append">
						<span class="input-group-text"> <i class="fa fa-search"
							aria-hidden="true"></i>
						</span>
					</div>
				</div>
			</div>
		</div>
		<!-- sidebar-search  -->
		<div class="sidebar-menu">
			<ul>
				<li class="header-menu"><span>General</span></li>
				<li class="sidebar-dropdown"><a href="#"> <i
						class="fa fa-tachometer-alt"></i> <span>사이트관리</span> <!--               <span class="badge badge-pill badge-warning">New</span> -->
				</a>
					<div class="sidebar-submenu">
						<ul>
							<li><a href="#">사이트소개</a></li>
							<li><a href="#">사이트이용약관 <!-- <span class="badge badge-pill badge-success">Pro</span> --></a></li>
							<li><a href="#">관리자계정관리</a></li>
						</ul>
					</div></li>
				<li class="sidebar-dropdown"><a href="#" id="nav_board_lecture"> <i
						class="fa fa-shopping-cart"></i> <span>강의관리</span> <span
						class="badge badge-pill badge-danger">3</span>
				</a>
					<div class="sidebar-submenu">
						<ul>
							<li><a href="#" id="nav_board_lecture">강의관리 </a></li>
							<li><a href="#">주문내역</a></li>
							<li><a href="#">결제설정</a></li>
						</ul>
					</div></li>
				<li class="sidebar-dropdown"><a href="#"> <i
						class="far fa-gem"></i> <span>펀딩관리</span> <span
						class="badge badge-pill badge-primary">Beta</span>
				</a>
					<div class="sidebar-submenu">
						<ul>
							<li><a href="#">펀딩승인내역</a></li>
							<li><a href="#">펀딩상품관리</a></li>
							<li><a href="#">펀딩주문내역</a></li>
						</ul>
					</div></li>
				<li class="sidebar-dropdown"><a href="#" id="nav_board_payment"> <i
						class="fa fa-shopping-cart"></i> <span>결제관리</span> <span
						class="badge badge-pill badge-danger">63</span>
				</a>
					<div class="sidebar-submenu">
						<ul>
							<li><a href="#">결제내역관리 </a></li>
							<li><a href="#">결제설정</a></li>
						</ul>
					</div></li>
				<li class="sidebar-dropdown"><a href="#" id="nav_board_member"> <i
						class="fa fa-chart-line"></i> <span>회원관리</span>
				</a>
					<div class="sidebar-submenu">
						<ul>
							<li><a href="#">일반회원관리</a></li>
							<li><a href="#" id="nav_board_creator">크리에이터관리</a></li>
							<li><a href="#" id="nav_board_lecture">강의 관리</a></li>
						</ul>
					</div></li>
				<li class="sidebar-dropdown"><a href="#" id="nav_board_bulletin"> <i
						class="fa fa-globe"></i> <span>게시판관리</span>
				</a>
					<div class="sidebar-submenu">
						<ul>
							<li><a href="#" id="nav_board_notice">공지내역</a></li>
							<li><a href="#" id="nav_board_faq">자주묻는질문</a></li>
							<li><a href="#" id="nav_board_qna">문의 내역</a></li>
							<li><a href="#" id="nav_board_">댓글 내역</a></li>
						</ul>
					</div></li>
				<li class="header-menu"><span>Extra</span></li>
				<li><a href="#"> <i class="fa fa-book"></i> <span>약관</span>
				</a></li>
				<li><a href="#"> <i class="fa fa-calendar"></i> <span>캘린더</span>
				</a></li>
				<li><a href="#"> <i class="fa fa-folder"></i> <span>자료실</span>
				</a></li>
			</ul>
		</div>
		<!-- sidebar-menu  -->
	</div>
	<!-- sidebar-content  -->
	<div class="sidebar-footer">
		<a href="#"> <i class="fa fa-bell"></i> <span
			class="badge badge-pill badge-warning notification">3</span>
		</a> <a href="#"> <i class="fa fa-envelope"></i> <span
			class="badge badge-pill badge-success notification">7</span>
		</a> <a href="#"> <i class="fa fa-cog"></i> <span class="badge-sonar"></span>
		</a> <a href="#"> <i class="fa fa-power-off"></i>
		</a>
	</div>
</nav>

<script type="text/javascript">
	$(".sidebar-dropdown > a").click(function() {
		$(".sidebar-submenu").slideUp(200);
		if ($(this).parent().hasClass("active")) {
			$(".sidebar-dropdown").removeClass("active");
			$(this).parent().removeClass("active");
		} else {
			$(".sidebar-dropdown").removeClass("active");
			$(this).next(".sidebar-submenu").slideDown(200);
			$(this).parent().addClass("active");
		}
	});

	$("#close-sidebar").click(function() {
		$(".page-wrapper").removeClass("toggled");
	});
	$("#show-sidebar").click(function() {
		$(".page-wrapper").addClass("toggled");
	});
</script>