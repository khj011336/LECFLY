<!-- 1. 색 처리가 프레임에 맞지 않음.(옥색 등 임의로 썻던 색상들 모두 강조색인 #FF4500으로 할것)		clear -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="">
<head>
	<meta charset="utf-8">
	<title>로그인 페이지</title>
	<link type="text/css" rel="stylesheet" href="resources/css/common/main.css">
    <link type="text/css" rel="stylesheet" href="resources/css/member/login.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
<%-- 		var ROOTCP = '<%= application.getContextPath()%>'; --%>
// 		$(document).ready(function() {
// 			$("#find_id").click(function() {
// 				var url = ROOTCP+'/ETC/find_mb_login.jsp';
// 				$("#login_wrap").load(url, function(){
// 				});			
// 			}); // #find_id
// 			$("#find_pw").click(function() {
// 				var url = ROOTCP+'/ETC/find_mb_pw.jsp';
// 				$("#login_wrap").load(url, function(){
// 				});			
// 			}); // #find_pw
// 		});
		
		
		
// 		function clickMbLogin(){
// 			var loginEmail = document.getElementById("login_email");
// 			var loginPw = document.getElementById("login_pw");
// 			location.href = "log_in.LF";
// 		}
		
    </script>
</head>
<div id="emtpy_space"></div>
<form name="login" action="login_proc.LF" method="post">
	<div id="login_wrap">
	    <div id="login_top">
	        <h2 id="login_title"><a href="home.LF" class="logo_link login_a"><img src="resources/imges/logo/LecFly_LOGO_B_C.png" ></a></h2>
	        <h2 id="login_subtitle">LOGIN</h2>
	    </div>
	    <div id="login_middle">
	    	<input type="text" placeholder="E-mail" name="email" id="login_email" >
	        <input type="password" placeholder="Password" name="pw" id="login_pw" maxlength="16" >
	        <div id="login_etc">
	        	<a id="find_id" class="login_linked login_a" href="find_mb_login.LF">아이디찾기</a>
	        	<span id="find_idpw_sl">&nbsp;/&nbsp;</span>
	        	<a id="find_pw" class="login_linked login_a" href="find_mb_pw.LF">비밀번호찾기</a>
	            <a id="register" class="login_linked login_a" href="clause.LF">회원가입</a>
	        </div>
	    </div>
	    <div id="login_msg" name="msg">${msg}</div>
	    <div id="login_bottom">
	        <div id="login_btn">
	        	<a href="#" onclick="javascript:document.login.submit();" class="login_a">로그인</a> <!-- 임시 아래꺼써야됨 -->
	<!--            	<a href="#" class="login_a" onclick="clickMbLogin()">로그인</a> -->
	        </div>
	    </div>
	
	</div>
</form>
</html>


    