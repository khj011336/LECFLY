<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
    $().ready(function () {
		$(window).scroll(function(){
			var Dheight = $(document).height();
			
			var Wheight = $(window).height();
			var WScrollTop = $(window).scrollTop(); 
			console.log(Dheight);
			console.log(Wheight);
			console.log(WScrollTop);
				if((Dheight) == Wheight + WScrollTop){
					append_Lec();
				}
		});
		var offset = 0; 
		var limit = 5;
		function append_Lec(){
			alert("ddd");
			
// 		$.post("creator.LF",{offset:offset,limit:limit},function(data){
// 			$(#CRcontent).append(data);
// 			offset += limit;
// 		});	
		}
	});
    
    </script>
    <link href="resources/css/creator/creator.css" rel ="stylesheet" type="text/css" >
<link href="resources/css/creator/cre_comment_mt.css" rel ="stylesheet" type="text/css" >
<link href ="resources/css/creator/lecplay.css" rel ="stylesheet" type="text/css" >
      <div id = 'CRwrap'>
       
        <div id="CRmain" class="CRwidth">
           
           
            <div id="CRcontent">
                <div id="CRhead"><span class="CRHT">온라인 클래스</span> <a href=""><span id="CRHT2">+새로운 클래스</span></a></div>
                 <c:if test="${ empty ddd}">
                
                 </c:if>
                <c:forEach begin="1" end="${empty ddd ? '1': ddd.size()  }"  var="Lecture" >
               
                <div class = 'CRconbox'>
                    <div class='CRP'>
                    <img src="../resource/img/dummy_img4.jpg" class="CRimg" alt ="dd"></div>
                    <div class ="CRC">
                        <p class='CRname'><c:out value="${ddd}" default="새로운클래스를 만들어보세요 "></c:out></p>
                        <div class="CRstatus">
                        <c:if test="${ !empty ddd }">
                        <p class="stus1 rau"></p>
                        <p class="stus2 rau">영상 14</p>
                        <p class="stus3 rau">미정</p>
                        </c:if>
                        </div>
                        <c:if test="${ !empty ddd }">
                        <div class='CRsend'><p>수정하기</p></div>
                        </c:if>
                    </div>
                </div>
               
                </c:forEach>
               
            </div>
            <div id ='CRguide'>
                 <div id="CRhead2" class="CRHT"><p>LEC 가이드</p>
                 </div>
                     <%for(int i =0 ; i<3 ; i++){ %>
                  <div class="CRguideCon">
                      <p class='CRfo'>강의 올리는방법</p>
                      <br>
                      <p class='CRsize'>
                 </p>
                      <span class="CRbot">자세히 보기..</span>
                  </div>
           <%} %>
            </div>
        </div>
    </div>
