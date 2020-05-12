<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
//     var status = 0;


var ex = false;
var finallwrite = false;

function setImageFromFile(input, expression, tempses) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $(expression).attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}
    $().ready(function () {
    	$("#cls_category option:nth-child("+${Lecture.category}+")").attr("selected","selected");
    	
     	$(".pubf").find("input,textarea,select").on("change",function(){
     		if(${p}==1){
            	sessionStorage.setItem("s1","1");
            	}else if(${p}==2){
            	sessionStorage.setItem("s2","1");
            	}
     		if($(this).attr("id")== "aas"){
     		setImageFromFile(this,".Crpf_imgbox1",'#tempImg');
     		}else if($(this).attr("id")== "titleimg"){
     			setImageFromFile(this,"#Timgshow",'#titleImg');
     		}
     		else if($(this).attr("id")== "infoimg"){
     		setImageFromFile(this,"#imgshow",'#tempImg');
 		}
   			 else if($(this).attr("id")== "infoimgb"){
    		setImageFromFile(this,"#imgshowb",'#tempImg');
		}
        	
        	});
    	$(document).on("click","#fl1",function(){
    		if(!ispty()){location.href ="creator_new_profile.LF";}
    	   });
    	$(document).on("click","#fl2",function(){
    		if(!ispty()){location.href ="creator_new_lecture.LF";}
    		});
    	$(document).on("click","#fl3",function(){
    		location.href ="";
    	});
    	$(document).on("click","#creatBtn",function(){
    		if(!ispty()){ex = true; location.href ="creator_new_lecture.LF";}
    	});
    	$(document).on("click",".exportb",function(){
    		if(!ispty()){
    			 var form = $('.pubf');
    			 finallwrite = true;
    				form.submit();
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
 function ispty(){
    var each =	$('.pubf').find("input[type!=hidden],textarea,select").not("input[type=button]").not("input[type=file]");
    var a = 0;
    for(var i =0 ; i<each.length;i++ ){
    	if(each[i].value == undefined || each[i].value == null || each[i].value ==""){
    		a++;
    	}
    } 
    	if(a>0){
    		alert("값을 다입력해주세요");
    		return true;
    	}else{
    		return false;
    	}
  }
//     function upload(ul, form){
//     	console.log('aa');
//      		 $.ajax({
//     			 url: ul ,
//     			 type:'POST',
//     			 enctype:"multipart/form-data",
//     			 data: form ,
//     			 processData: false,
//     			 contentType: false,
//     			 success: function(data, jqXHR,textStatus){
    				   
//     			 },
//     			 error: function(jqXHR, textStatus , errorThrown){
    				 
//     			 }
//     		  });
//      	}
 
 $(window).on("unload",function(e){
    		   var ischage = sessionStorage.getItem("s1");
    		 var ischageB =  sessionStorage.getItem("s2") ;
    		 var formdata = new FormData($('.pubf')[0]);
    		 var nodename = '';
    		 if(e.target.activeElement.nodeName.toLowerCase() == "body"||e.target.activeElement.nodeName.toLowerCase() == "input"){
    		   nodename = true;
    		 }else{
    			 nodename = false;
    		 }
    		   var pagenation = ${p};
    		   console.log(e.target.activeElement.nodeName.toLowerCase());
    		   console.log(ischage);
    		   console.log(nodename);
    		   console.log(pagenation);
    		   if(nodename && pagenation ==1 && ischage == "1" ){
    				  sessionStorage.setItem("s1","2");
    				  navigator.sendBeacon("creator_new_profile_proc.LF", formdata);
    			  }else if( nodename && pagenation ==2 && ischageB == "1"){
    				  sessionStorage.setItem("s2","2");
    				  navigator.sendBeacon("creator_new_lecture_proc.LF", formdata);
    			  }else if(ex){
    				   
    			  }else if(!nodename && !finallwrite &&  !ex){
    				  if(pagenation == 1){
    					  <%session.setAttribute("unloadA", "1");%>
    				  navigator.sendBeacon("creator_new_profile_proc.LF", formdata);
    				  }else if(pagenation ==2){
    					  <%session.setAttribute("unloadB", "1");%>
    					  navigator.sendBeacon("creator_new_lecture_proc.LF", formdata);  
    				  }
    			  }
    		});
    
    
    	
    </script>
<div id="Crcircle"><div class="Ccirk  " id="fl1">1.크리에이터 소개</div>-<div class="Ccirk" id="fl2">2.클래스 기본정보</div>-<div class="Ccirk" id="fl3">3.클래스 미리 보기</div></div>