<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<script type="text/javascript">
	    
	    $(document).ready(function () {
		    var height = $(window).height();
		    $(".container1").height('10px');
		    setTimeout(function () {
		        $(".masker").hide();
		    }, 1000)
		    banner1();
		})
	
		function banner1() {
		    for (var i = 0; i < 7; i++) {
		        $(".container1 div").eq(i).css({
		            "transition": "transform 1s"
		        });
		    }
		    
		    $(".container1 div").on("click", function () {
		    	
		        var index = $(this).index();
		        var prev1 = (index - 1) >= 0 ? (index - 1) : (index - 1 + 7);
		        var prev2 = (index - 2) >= 0 ? (index - 2) : (index - 2 + 7);
		        var prev3 = (index - 3) >= 0 ? (index - 3) : (index - 3 + 7);
		        var next1 = (index + 1) <= 6 ? (index + 1) : (index + 1 - 7);
		        var next2 = (index + 2) <= 6 ? (index + 2) : (index + 2 - 7);
		        var next3 = (index + 3) <= 6 ? (index + 3) : (index + 3 - 7);
		        
		        $(".container1 div").eq(prev3).css({
		            "transform": "perspective(200px) translateZ(-60px) translateX(-300px)",
		            "z-index": "1"
		        });
		        $(".container1 div").eq(prev2).css({
		            "transform": "perspective(200px) translateZ(-40px) translateX(-200px)",
		            "z-index": "2"
		        });
		        $(".container1 div").eq(prev1).css({
		            "transform": "perspective(200px) translateZ(-20px) translateX(-100px)",
		            "z-index": "3"
		        });
		        $(".container1 div").eq(index).css({
		            "transform": "perspective(200px) translateZ(0px) translateX(0px)",
		            "z-index": "4"
		        });
		        $(".container1 div").eq(next1).css({
		            "transform": "perspective(200px) translateZ(-20px) translateX(100px)",
		            "z-index": "3"
		        });
		        $(".container1 div").eq(next2).css({
		            "transform": "perspective(200px) translateZ(-40px) translateX(200px)",
		            "z-index": "2"
		        });
		        $(".container1 div").eq(next3).css({
		            "transform": "perspective(200px) translateZ(-60px) translateX(300px)",
		            "z-index": "1"
		        });
		    });
		}
	</script> 	
	<div id = "bannertesta"> 
	
	<div class="container1" style="height: 300px;">
        <div><img src="resource/img/banner/배너_test1.jpg"><a href="#" id="banner1">클래스 바로가기</a></div>
        <div><img src="resource/img/banner/배너_test2.jpg"><a href="#" id="banner1">클래스 바로가기</a></div>
        <div><img src="resource/img/banner/배너_test3.jpg"><a href="#" id="banner1">클래스 바로가기</a></div>
        <div><img src="resource/img/banner/배너_test4.jpg"><a href="#" id="banner1">클래스 바로가기</a></div>
        <div><img src="resource/img/banner/배너_test5.jpg"><a href="#" id="banner1">클래스 바로가기</a></div>
        <div><img src="resource/img/banner/배너_test6.jpg"><a href="#" id="banner1">클래스 바로가기</a></div>
        <div><img src="resource/img/banner/배너_test7.jpg"><a href="#" id="banner1">클래스 바로가기</a></div>
    </div>
    
    </div>