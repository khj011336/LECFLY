<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
$(document).ready(function() {
	var myChart;
	var chartOptions = {
			 chart: {
				  type: 'column',
				  renderTo: 'container_categorylecture'
				  },
				  title: {
				    text: '카테고리별 강의수'
				  },
				  subtitle: {
				    text: '2020.05 기준'
				  },
				  accessibility: {
				    announceNewData: {
				      enabled: true
				    }
				  },
				  xAxis: {
				    type: 'category'
				  },
				  yAxis: {
				    title: {
				      text: '강의 수(건)'
				    }
				  },
				  legend: {
				    enabled: false
				  },
				  plotOptions: {
				    series: {
				      borderWidth: 0,
				      dataLabels: {
				        enabled: true,
				        format: '{point.y}'
				      }
				    }
				  },
				  tooltip: {
				    headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
				    pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>총 {point.y}건</b><br/>'
				  },

				  series: [{
				      name: "카테고리",
				      colorByPoint: true,
				      data: []
				  }]	
	};
	myChart = new Highcharts.chart(chartOptions);
	
	$("#categorylecture").on("click", function(){
		console.log("카테고리 차트 요청");
		var URLHD = '${pageContext.request.contextPath}/';
		var url = URLHD + "stat_categoryLecture.LF";
		$.ajax({
			type: 'post',
			contentType: 'application/json',
			data: 'start=1',
			url: url,
			dateType: 'json',
			success: function(res, status, xhr) {
				console.log(res);
				
				var cateName = res.cateName;// 카테고리명
				var lectureCnt = res.lectureCnt;// 강의수
				
				var arr = new Array();
				var info;
				for (var i = 0; i < cateName.length; i++) {
					info = new Object();
					info.name = cateName[i];
					info.y = lectureCnt[i];
					arr.push(info);
					myChart.series[0].setData(arr, true);
				}
			},
			error: function(xhr, status) {
				console.log(xhr);
				console.log(xhr.status);
				console.log(status);
			}
		});
		
	});
});	
	
</script>
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
<div class="main_middle">
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
</div>
<input id="categorylecture" type="button" value="통계보기">
<!-- 차트 출력 부분 -->
<div id="stat_result">
<figure class="highcharts-figure">
	<div id="container_categorylecture"></div>
	<p class="highcharts-description"></p>
</figure>
</div>
