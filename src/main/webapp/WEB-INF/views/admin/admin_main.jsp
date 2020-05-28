<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h2>관리자 메인</h2>
<hr>
<div class="main_top">
	<div class="adtop_main_box">
		<div id="part1" style="background-color: #00C0EF;">
			<i class="far fa-eye fa-3x"></i>
		</div>
		<div id="part2" style="color: black;">
			<strong>방문자 수</strong><br> <span><c:out
					value="${allMbToday}" default="0" /></span>
		</div>
	</div>
	<div class="adtop_main_box">
		<div id="part1" style="background-color: #00A65A;">
			<i class="fas fa-users fa-3x"></i>
		</div>
		<div id="part2" style="color: black;">
			<strong>회원 수</strong><br> <span><c:out
					value="${allMbCnt}" default="0" /></span>
		</div>
	</div>
	<div class="adtop_main_box">
		<div id="part1" style="background-color: #F39C12;">
			<i class="fas fa-chalkboard-teacher fa-3x"></i>
		</div>
		<div id="part2" style="color: black;">
			<strong>업로더 수</strong><br> <span><c:out
					value="${allCrCnt}" default="0" /></span>
		</div>
	</div>
	<div class="adtop_main_box">
		<div id="part1" style="background-color: #DD4B39;">
			<i class="far fa-folder-open fa-3x"></i>
		</div>
		<div id="part2" style="color: black;">
			<strong>전체 강의 수</strong><br> <span><c:out
					value="${allLecCnt}" default="0" /></span>
		</div>
	</div>
</div>
<div class="main_top2">
	<div class="adtop_main_box">
		<div id="part1" style="background-color: #009ABF;">
			<i class="fas fa-users-cog fa-3x"></i>
		</div>
		<div id="part2" style="background-color: #00C0EF;">
			<strong>회원 관리</strong><br>New : <span><c:out
					value="${newMbCnt}" default="0" /></span>
		</div>
	</div>
	<div class="adtop_main_box">
		<div id="part1" style="background-color: #008548;">
			<i class="fas fa-user-plus fa-3x"></i>
		</div>
		<div id="part2" style="background-color: #00A65A;">
			<strong>업로더 승인</strong><br>New : <span><c:out
					value="${appCrCnt}" default="0" /></span>
		</div>
	</div>
	<div class="adtop_main_box">
		<div id="part1" style="background-color: #C27D0E;">
			<i style="margin-left: 10px;" class="fas fa-clipboard-check fa-3x"></i>
		</div>
		<div id="part2" style="background-color: #F39C12;">
			<strong>강의 승인</strong><br>New : <span><c:out
					value="${appLecCnt}" default="0" /></span>
		</div>
	</div>
	<div class="adtop_main_box">
		<div id="part1" style="background-color: #B13C2E;">
			<i class="far fa-comments fa-3x"></i>
		</div>
		<div id="part2" style="background-color: #DD4B39;">
			<strong>1:1 문의 답변하기</strong><br>New : <span><c:out
					value="${cmQnaCnt}" default="0" /></span>
		</div>
	</div>
</div>
<!-- <div class="main_middle">
	<div class="admiddle_main_box">
		<div id="mid_part1" style="background-color: #00C0EF;">
			<img alt="linechart"
				src="resources/imges/unknown/line_chart_sample.png">
		</div>
		<div id="mid_part2" style="background-color: #009ABF;">회원 증가율</div>
	</div>
	<div class="admiddle_main_box">
		<div id="mid_part1" style="background-color: #00A65A;">
			<img alt="linechart"
				src="resources/imges/unknown/bar_chart_sample.png">
		</div>
		<div id="mid_part2" style="background-color: #008548;">카테고리별 강의수</div>
	</div>
	<div class="admiddle_main_box">
		<div id="mid_part1" style="background-color: #F39C12;">
			<img alt="linechart"
				src="resources/imges/unknown/line_chart_sample.png">
		</div>
		<div id="mid_part2" style="background-color: #C27D0E;">이용권 매출</div>
	</div>
	<div class="admiddle_main_box">
		<div id="mid_part1" style="background-color: #DD4B39;">
			<img alt="linechart"
				src="resources/imges/unknown/line_chart_sample.png">
		</div>
		<div id="mid_part2" style="background-color: #B13C2E;">펀딩 매출</div>
	</div>
</div> -->
<input id="monthlymember" type="hidden" value="1통계보기">
<input id="categorylecture" type="hidden" value="2통계보기">
<input id="monthlysales" type="hidden" value="3통계보기">

<!-- 차트 출력 부분 -->
<div id="stat_result" style="display: flex; width: 1200px;">
	<figure class="highcharts-figure">
		<div id="container_monthlymember"></div>
		<p class="highcharts-description"></p>
	</figure>
	
	<figure class="highcharts-figure">
		<div id="container_categorylecture"></div>
		<p class="highcharts-description"></p>
	</figure>
	
	<figure class="highcharts-figure">
		<div id="container_monthlysales"></div>
		<p class="highcharts-description"></p>
	</figure>
	
	<ul id="stat_report">
	</ul>
</div>
