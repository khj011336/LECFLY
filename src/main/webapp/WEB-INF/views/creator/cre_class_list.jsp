<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.LECFLY.LF.model.vo.creator.LectureVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<script src = "resources/js/creator/select.js"></script>
<script>
var lt = new selectList("#offset",${maxPage},"#CRcontent","get",'creator.LF');
lt.List();
</script>
<div id='CRwrap'>

	<div id="CRmain" class="CRwidth">


		<div id="CRcontent">
			<div id="CRhead">
				<span class="CRHT">온라인 클래스</span><a href=""><span id="CRHT3">기본정보수정</span></a>
				<a href="creator_new_profile.LF"><span id="CRHT2">+새로운
						클래스</span></a>
			</div>
			<%@include file="_cre_class.jsp"%>
		</div>
		<div id='CRguide'>
			<div id="CRhead2" class="CRHT">
				<p>LEC 가이드</p>
			</div>
			<%
				for (int i = 0; i < 3; i++) {
			%>
			<div class="CRguideCon">
				<p class='CRfo'>강의 올리는방법</p>
				<br>
				<p class='CRsize'></p>
				<span class="CRbot">자세히 보기..</span>
			</div>
			<%
				}
			%>
		</div>
	</div>
</div>
