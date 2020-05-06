<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.LECFLY.LF.model.vo.creator.LectureVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
$().ready(function () {
	

    var page = 2;  
 
var isVisible = false;

$(window).on('scroll',function() {

    if (checkVisible($('#offset'))&&!isVisible) {
    	if( page<=${maxPage} ){
  	  $('html,body').animate({scrollTop :($(window).scrollTop()+170) - $('#offset').height()},400);
   		 }   
    	if(page == ${maxPage+1}){
    	   $("#offset").append("<h4>목록이없습니다</h4>")
    	   }
        isVisible=true;
        getList(page);
        page++;
    }
});
function checkVisible( box, tOf ) {
	tOf = tOf || "object visible";
    var viewportHeight = $(window).height(),  
        scrolltop = $(window).scrollTop(),  
        y = $(box).offset().top,
        elementHeight = $(box).height();   
    
    if (tOf == "object visible") return ((y < (viewportHeight + scrolltop)) && (y > (scrolltop - elementHeight)));
}
 function creatNewclass(){
	 $(".CRC").css("cursor","pointer");
	 $(".CRP").css("cursor","pointer");
	 $(".CRC,.CRP").on("click", function () {
		window.location.href="creator_new_profile.LF";
	});
	   }
   function getList(page){
	   
	   if(page <= ${maxPage} && ${maxPage} != 0 ){ 
		  
		   $("#offset").append("<img id='offimg' src='resources/imges/creator/loading.gif'>");
		   $.ajax({
           type : 'get',  
           dataType : 'text', 
           data : {"page" : page},
           url : 'creator.LF',
           success : function(returnData) {
        	   $("#offset").remove();
        	   var cutor = $("#offset").html();
        	   $("#offset").remove();
        		$("#CRcontent").append(returnData);
        		$("#CRcontent").append(cutor);
        	   page++;
        	   isVisible = false;
        	
            },
           error:function(e){
              if(e.status==300){
                  alert("데이터를 가져오는데 실패하였습니다.");
              }
          }
       }); 
       } 
   }
   function selectLecture(Lcid) {
		var form = document.createElement('form');
		form.setAttribute('method', 'post');
		form.setAttribute('action', 'creator_video_show.LF');
		form.setAttribute('id', Lcid);
		document.charset = "utf-8";
// 		for ( var key in params) {
// 			var hiddenField = document.createElement('input');
// 			hiddenField.setAttribute('type', 'hidden');
// 			hiddenField.setAttribute('name', key);
// 			hiddenField.setAttribute('value', params[key]);
// 			form.appendChild(hiddenField);
// 		}
		document.body.appendChild(form);
		form.submit();
   }
});
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
