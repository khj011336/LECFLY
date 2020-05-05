<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.LECFLY.LF.model.vo.creator.LectureVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
    var page = 1;  //페이징과 같은 방식이라고 생각하면 된다. 
    
//     $(function(){  //페이지가 로드되면 데이터를 가져오고 page를 증가시킨다.
//          getList(page);
//          page++;
//     }); 
    $(window).scroll(function(){   //스크롤이 최하단 으로 내려가면 리스트를 조회하고 page를 증가시킨다.
        if($(window).scrollTop() >= $(document).height() - $(window).height()){
             getList(page);
              page++;   
        } 
   });
//     if( scrollTop + windowHeight + 30 > documentHeight ){
//         fetchList();
//     }
   function getList(page){
       $.ajax({
           type : 'post',  
           dataType : 'json', 
           data : {"page" : page},
           url : 'creator.LF',
           success : function(returnData) {
        	   alert(returnData);
        	   alert("Dd");
        	   $(".CRconbox").append($(".CRconbox"));
        	   
            },
           error:function(e){
              if(e.status==300){
                  alert("데이터를 가져오는데 실패하였습니다.");
              }
          }
       }); 
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
    </script>
      <div id = 'CRwrap'>
       
        <div id="CRmain" class="CRwidth">
           
           
            <div id="CRcontent">
                <div id="CRhead"><span class="CRHT">온라인 클래스</span><a href=""><span id="CRHT3">기본정보수정</span></a> <a href="creator_new_profile.LF"><span id="CRHT2">+새로운 클래스</span></a></div>
                 
              
              <c:forEach begin="0" end="${empty lecList ? '1': lecList.size()-1  }" varStatus="vs"  >
                <div class = 'CRconbox'>
                  
                    <div class='CRP'>
                    <c:set  var ="titleImg" value="${lecList[vs.current].titleImg}"/>
                    <c:if test="${lecList[vs.current].titleImg eq 'sample' }">
                   <c:set  var ="titleImg" value="resources/imges/logo/LecFly_SLOGO_W_C.png"/>
                    
                    </c:if>
                    <img src= "<c:out value='${titleImg}'/>" class="CRimg" alt ="dd"></div>
                    <div class ="CRC">
                        <p class='CRname'><c:out value="${lecList[vs.current].title}" default="새로운클래스를 만들어보세요 "></c:out></p>
                        <div class="CRstatus">
                        <c:if test="${ !empty lecList }">
                        <p class="stus1 rau">${lecList[vs.current].status}</p>
                        <p class="stus2 rau">영상 ${lecList[vs.current].videoTrack}</p>
                        <p class="stus3 rau"><fmt:formatDate value="${lecList[vs.current].createdAt}" pattern="yyyy-MM-dd"/>
</p>
                        </c:if>
                        </div>
                        <c:if test="${ !empty lecList }">
                        <div class='CRsend' onclick="selectLecture(${lecList[vs.current].id})" ><p>수정하기</p></div>
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
