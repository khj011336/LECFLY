
 
	

  
function select(){
	  var page = 2;  
	  var isVisible = false;
   this.sc = function(){ $(window).on('scroll',function() {

    if (checkVisible($("#offset"))&&!isVisible) {
    	if( page<= 3 ){
  	  $('html,body').animate({scrollTop :($(window).scrollTop()+170) - $('#offset').height()},400);
   		 }   
    	if(page == 3){
    	   $("#offset").append("<h4>목록이없습니다</h4>")
    	   }
        isVisible=true;
        getList(page);
        page++;
    }
});
   }
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
	   
	   if(page <= 3 && 3 != 0 ){ 
		  
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
}