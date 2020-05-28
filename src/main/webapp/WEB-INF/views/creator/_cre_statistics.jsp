<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<script type="text/javascript">
$(document).ready(function(){
	
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
	var chartOptions2 = {
 			chart: {
 		        type: 'bar', //'column', //'line',  // 'bar'
 		        renderTo: 'treeab'
 		    },
 		    title: {
 		        text: '영상별 좋아요'
 		    },
 		    subtitle: {
 		        text: '영상별 좋아요 현황 (개)'
 		    },
 		    xAxis: {
 		    	title: {
 		    		text: '영상별 좋아요'
 		    	} ,
 		          categories: ['afaf','asdasd'] // [] 
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
 		        name: '좋아요',
				color: '#FF0000' 		        
 		    }] 
 		};
 		
 		var myChart;
 		var chartOptions = {
 			chart: {
 		        type: 'line', //'column', //'line',  // 'bar'
 		        renderTo: 'treea'
 		    },
 		    title: {
 		        text: '영상별 조회수'
 		    },
 		    subtitle: {
 		        text: '영상별 조회수 현황 (개)'
 		    },
 		    xAxis: {
 		    	title: {
 		    		text: '영상별 조회수'
 		    	} ,
 		          categories: ['afaf','asdasd'] // [] 
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
 		        name: '조회수',
				color: '#FF0000' 		        
 		    }] 
 		};
 		var videoName = JSON.parse('${videoJson}');
 		myChart = new Highcharts.chart(chartOptions);
 		var myChart2;
 		myChart2 = new Highcharts.chart(chartOptions2);
 		myChart2.xAxis[0].setCategories(videoName.videoName,true);
 		myChart2.series[0].setData(videoName.like,true);
 		console.log(videoName);
 		myChart.xAxis[0].setCategories(videoName.videoName,true);
 		myChart.series[0].setData(videoName.views,true);
 		
 		$(document).on("change","#CreSele", function() {
 			var URLHD = 
 				'${pageContext.request.contextPath}/';
 			var url =  URLHD+'creator_statistics.LF';
 			$.ajax({
 				type: 'get',
 				data: {'lecId' : $("#CreSele").val() , 'net' : "1"},
 				url: url,
 				dataType: 'text',
 				success: function(res, status, xhr) {
 					$("#statst").empty();
					$("#statst").html(res);
										
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
            <div><p>만족도</p></div>
            <div><p>${videoStat.totalview} </p>views</div>
            <div><p>좋아요:${videoStat.likeCount}</p></div>
        </div>
        <div class="Cregraphaa" id="treea">
         <p class="highcharts-description">
            <div><p>월별 평균</p></div>
        </div>
         <div class="Cregraphaa" id="treeab">
         <p class="highcharts-description">
            <div><p>월별 평균</p></div>
        </div>
      