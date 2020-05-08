<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
//     var status = 0;
    $().ready(function () {
     	 var ischanged = false;
     	 var isempty = false;
     	 var ex = true;
      
     	$("#aform").find("input,textarea").on("change",function(){
        	ischanged = true;
        	});
    	$(document).on("click","#fl1",function(){
    		if(!ispty())
    	   	location.href ="creator_new_profile.LF";
    	   });
    	$(document).on("click","#fl2",function(){
    		location.href ="creator_new_lecture.LF";
    	   });
    	$(document).on("click","#fl3",function(){
    		location.href ="";
    	});
    	$(document).on("click","#creatBtn",function(){
    		if(!ispty()){
    			location.href ="creator_new_lecture.LF";
    			}
   		 ex = false;
   	   });
    	ispty();
 function ispty(){
    var each =	$('#aform').find("input[type!=hidden],textarea").not("input[type=button]")
    for(var i =0 ; i<each.length;i++ ){
    	if(!each[i].value){
    		 alert("입력을 다해주세요");
    		return isempty = true;
    	}else{
    		 return isempty = false;
    	}
} 
    	}
    	
    	   $(window).on("load",function(e){
    		   var nodename = e.target.activeElement.nodeName == "BODY";
    		  if(   nodename && ${p} ==1 && ischanged){
    			  $.ajax({
    				 url: "creator_new_profile_proc.LF" ,
    				 type:'POST',
    				 datatype:"text",
    				 data: $("#aform").serialize() ,
    				 contentType: "application/x-www-form-urlencoded; charset=UTF-8",
    				 success: function(e){
    					  localStorage.setItem('status',"1");
    				 }
    			  });
    		  }else if(!ex ){
    			  
    		  }else if( nodename && ${p} ==2 && ischanged){
    			  $.ajax({
     				 url: "creator_new_lecture_proc.LF" ,
     				 type:'POST',
     				 datatype:"text",
     				 data: $("#aform").serialize() ,
     				 contentType: "application/x-www-form-urlencoded; charset=UTF-8",
     				 success: function(e){
     					  localStorage.setItem('status',"2");
     				 }
     			  });
    		  }else if(localStorage.getItem(status) ==3){
    			   
    		  }else if(!nodename){
    			  $.ajax({
     				 url: "creator_set_proc.LF" ,
     				 type:'POST',
     				 datatype:"text",
     				 data:   $("#aform").serialize(),
     				 contentType: "application/x-www-form-urlencoded; charset=UTF-8",
     				 success: function(e){
     				 }
     			  });
    		  }
    		});
    	if(${p} == 1){
    		$("#fl1").css("color","#ffa500");
    	}else if(${p} == 2){
    		$("#fl2").css("color","#ffa500");
    	}else{
    		$("#fl3").css("color","#ffa500");
    	}
    	});
    
    	
    </script>
<div id="Crcircle"><div class="Ccirk  " id="fl1">1.크리에이터 소개</div>-<div class="Ccirk" id="fl2">2.클래스 기본정보</div>-<div class="Ccirk" id="fl3">3.클래스 미리 보기</div></div>