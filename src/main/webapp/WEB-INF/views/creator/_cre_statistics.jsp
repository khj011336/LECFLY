<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<script src="${pageContext.request.contextPath}/resources/chart/highcharts.js"></script>
<script src="${pageContext.request.contextPath}/resources/chart/modules/exporting.js"></script>
<script src="${pageContext.request.contextPath}/resources/chart/modules/export-data.js"></script>
<script src="${pageContext.request.contextPath}/resources/chart/modules/accessibility.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var myChart2;
		var chartOptions2 = {
		chart: {
	        plotBackgroundColor: null,
	        plotBorderWidth: null,
	        plotShadow: false,
	        type: 'pie',
	        renderTo: 'treeab'
	    },
	    title: {
	        text: '날자 별 댓글 개수의 비율(%)'
	    },
	    tooltip: {
	        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	    },
	    accessibility: {
	        point: {
	            valueSuffix: '%'
	        }
	    },
	    plotOptions: {
	        pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	                enabled: true,
	                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
	                connectorColor: 'silver'
	            }
	        }
	    },
	    series: [{
	    	name: '', 
	    	data:[]
	    }]
		};
		myChart2 = new Highcharts.chart(chartOptions2);
 		Highcharts.setOptions({
 		    colors: Highcharts.map(Highcharts.getOptions().colors, function (color) {
 		        return {
 		            radialGradient: {
 		                cx: 0.5,
 		                cy: 0.3,
 		                r: 0.7
 		            },
 		            stops: [
 		                [0, color],
 		                [1, Highcharts.color(color).brighten(-0.3).get('rgb')] // darken
 		            ]
 		        };
 		    })
 		});
 		var myChart;
 		var chartOptions = {
 			chart: {
 		        type: 'line', //'column', //'line',  // 'bar'
 		        renderTo: 'treea'
 		    },
 		    title: {
 		        text: '댓글 통계'
 		    },
 		    subtitle: {
 		        text: '게시글별 댓글 개수, 동감합, 동감평균 (개)'
 		    },
 		    xAxis: {
 		    	title: {
 		    		text: '게시글'
 		    	}, 
 		        categories: [ 'a', 'b', 'c', 'd' ]  // [] 
 		    	, crosshair: true
 		    },
 		    yAxis: {
 		        title: {
 		            text: '(개)'
 		        },
 		        min: 0
 		    },
 		    plotOptions: {
 		    	bar: {
 		    		dataLabels: {
 		                enabled: true
 		            },
 		            enableMouseTracking: true
 		    	},
 		    	column: {
 		            pointPadding: 0.2,
 		            borderWidth: 0,
 		            dataLabels: {
 		                enabled: true
 		            },
 		            enableMouseTracking: true
 		        },
 		        line: {
 		            dataLabels: {
 		                enabled: true
 		            },
 		            enableMouseTracking: true
 		        }
 		    },
 		    tooltip: {
 		        headerFormat: 
 		        	'<span style="font-size:10px">{point.key}</span><table>',
 		        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
 		            '<td style="padding:0"><b>{point.y:.1f}개</b></td></tr>',
 		        footerFormat: '</table>',
 		        shared: true,
 		        useHTML: true
 		    },
 		    credits: false,
 		    series: [{
 		        name: '댓글수',
 		       data: [7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6],
				color: '#FF0000' 		        
 		    }, {
 		        name: '공감합',
 		        color: '#00FF00'
 		    }, {
 		        name: '공감평균',
 		       color: '#0000FF' 
 		    }]
 		};
 		
 		myChart = new Highcharts.chart(chartOptions);
 		$("#asStatPerArticle").on("click", function() {
 			var URLHD = 
 				'${pageContext.request.contextPath}/';
 			var url =  URLHD+'admin/stat_as_count.my';
 			$.ajax({
 				type: 'post',
 				data: 'dummy=123',
 				url: url,
 				dataType: 'json',
 				success: function(res, status, xhr) {
					 
					console.log(res);
					myChart.xAxis[0].setCategories(
							res.atTitleData, true);
					var asCnt = res.asCntData;
					myChart.series[0].setData(asCnt, true);
					var cpSum = res.cpSumData;
					myChart.series[1].setData(cpSum, true);
					var cpAvg = res.cpAvgData;
					myChart.series[2].setData(cpAvg, true);
					for( var i = 0; i < res.atTitleData.length; i++ ) {
						var li = '<li>'+res.atTitleData[i]+" : "
							+asCnt[i]+ ','
							+cpSum[i]+ ','
							+cpAvg[i]+ '</li>';
						$('#stat_report').append(li);
					}					
				},				
				error: function(xhr,status) {
					console.log(xhr);
					console.log(xhr.status);
					console.log(status);
				}
 			}); 			
		});
});
</script>
  <div class="CreavIner">
            <div><p>누적만족도</p></div>
            <div><p>0%</p></div>
            <div><p>따봉(그림):22 싫어요(그림):14</p></div>
        </div>
        <div class="Cregraphaa" id="treea">
         <p class="highcharts-description">
            <div><p>월별 평균</p></div>
        </div>
         <div class="Cregraphaa" id="treeab">
         <p class="highcharts-description">
            <div><p>월별 평균</p></div>
        </div>
      