<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.LECFLY.LF.model.vo.creator.LectureVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<script src = "resources/js/creator/select.js"></script>
<script>
var lt = new selectList("#offset", ${maxPage} ,"#CRcontent","get",'creator.LF');
lt.List();
$().ready(function(){
	$("#CRHT3").on("click",function(){
		 location.href = "creator_update_profile.LF";
	});
$("#CRHT2").on("click",function(){
	if(${isCreator} == 2){
	alert("현재 크리에이터 승인요청중입니다.승인후 정상적인 등록이가능합니다!");
	}else if(${isCreator} == 3){
		location.href ="creator_new_lecture.LF";
	}else if(${isCreator} == 4){
		alert("현재 작성중인 첫 글이있습니다.등록후 정상적인 활동이가능합니다!");	
	}else{
		location.href ="creator_new_profile.LF";
	}
});
});
</script>
<div id='CRwrap'>
	<div id="CRmain" class="CRwidth">
		<div id="CRcontent">
			<div id="CRhead">
				<span class="CRHT">온라인 렉쳐</span><span id="CRHT3">+기본정보수정</span>
				 <span id="CRHT2">+새로운 렉쳐</span> 
			</div>
			<%@include file="_cre_class.jsp"%>
		</div>
		<div id='CRguide'>
			<div id="CRhead2" class="CRHT">
				<p>LEC 가이드</p>
			</div>
			 
			<div class="CRguideCon">
				<p class='CRfo'>강의 올리는방법</p>
				<br>
				<p class='CRsize'>나의 강의 올리는방법과  개설과정이 궁금하시진 않은가요? 지금 궁금증을 풀어보세요</p>
				<span class="CRbot">자세히 보기</span>
			</div>
			<div class="CRguideCon">
				<p class='CRfo'>LECFLY 회사소개서</p>
				<br>
				<p class='CRsize'>우리 회사에 대한 궁금한점에 대해 알려드릴게요</p>
				<span class="CRbot">자세히 보기..</span>
			</div>
		 
		</div>
	</div>
</div>
