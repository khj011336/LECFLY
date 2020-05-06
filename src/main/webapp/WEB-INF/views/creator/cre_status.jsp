<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
    $().ready(function () {
    $(document).on("click","#fl1",function(){
    	location.href ="creator_new_profile.LF";
    });
$(document).on("click","#fl2",function(){
	location.href ="creator_new_lecture.LF";
    });
$(document).on("click","#fl3",function(){
	location.href ="";
});
    }
    </script>
<div id="Crcircle"><div class="Ccirk" id="fl1">1.크리에이터 소개</div>-<div class="Ccirk" id="fl2">2.클래스 기본정보</div>-<div class="Ccirk" id="fl3">3.클래스 미리 보기</div></div>