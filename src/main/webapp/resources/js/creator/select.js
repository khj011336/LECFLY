  
function selectList(boxid,maxPage,appendid,method,url){
	  var page = 2;  
	  var isVisible = false;
   this.List = function(){ $(window).on('scroll',function() {

    if (checkVisible($(boxid))&&!isVisible) {
    	if( page<= maxPage ){
  	  $('html,body').animate({scrollTop :($(window).scrollTop()+170) - $(boxid).height()},400);
   		 }   
    	if(page == maxPage+1){
    	   $(boxid).append("<h4>목록이없습니다</h4>")
    	   }
        isVisible=true;
        getList(page);
        page++;
        console.log(page);
    }
});
   }
function checkVisible( box, tOf ) {
	tOf = tOf || "object visible";
    var viewportHeight = $(window).height(),  
        scrolltop = $(window).scrollTop(),  
        y = $(box).offset().top,
        elementHeight = $(box).height();   
    
    if (tOf == "object visible") return ((y < (viewportHeight + scrolltop-80)) && (y > (scrolltop - elementHeight)));
}
 
   function getList(page){
	   
	   if(page <= maxPage && maxPage != 0 ){ 
		  
		   $(boxid).append("<img id='offimg' src='resources/imges/creator/loading.gif'>");
		   $.ajax({
           type : method,  
           dataType : 'text', 
           data : {"page" : page},
           url : url,
           success : function(returnData) {
        	   $(boxid).remove();
        	   var cutor = $(boxid).html();
        	   $(boxid).remove();
        		$(appendid).append(returnData);
        		$(appendid).append(cutor);
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
}
function selectLecture(Lcid) {
	var form = document.createElement('form');
	form.setAttribute('method', 'post');
	form.setAttribute('action', 'creator_video_show.LF');
	form.setAttribute('id', Lcid);
	document.charset = "utf-8";
//		for ( var key in params) {
//			var hiddenField = document.createElement('input');
//			hiddenField.setAttribute('type', 'hidden');
//			hiddenField.setAttribute('name', key);
//			hiddenField.setAttribute('value', params[key]);
//			form.appendChild(hiddenField);
//		}
	document.body.appendChild(form);
	form.submit();
}
function creatNewclass(){
	 $(".CRC").css("cursor","pointer");
	 $(".CRP").css("cursor","pointer");
	 $(".CRC,.CRP").on("click", function () {
		window.location.href="creator_new_profile.LF";
	});
	   }