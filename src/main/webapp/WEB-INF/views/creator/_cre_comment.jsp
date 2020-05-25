<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<c:if test="${not empty lecList}">
  <c:forEach  begin="0" end="${lecList.size()-1}" varStatus="in">
   <div class = "wrapComment">
                <div class = 'CRconboxb'>
                    <div class='CRP'>
                    <img src="${crPath}${lecList[in.current].titleImg}" class="CRimg" alt ="dd"></div>
                    <div class ="CRC">
                        <p class='CRname'>${lecList[in.current].title}</p>
                        <div class="CRstatus">
                        <p class="stus1 rau CRcol">만족도 20%</p>
                        <p class="stus2 rau CRcol">좋아요30</p>
                        <p class="stus3 rau CRcol">수강이수율10%</p>
                        </div>
                        <div class='CRsendCo'><p class='CRcol'>작성제출</p></div>
                    </div>
                     <div class="MADtailb">
                        <div class="percen">답변률%<span>sss</span></div>
                        <div class="percen">좋아요%<span></span></div>
                        <div class="perton">전체글<span></span></div>
                        <div class="perton">답변글<span></span></div>
                        <div class="perton">미답변<span></span></div>
                        <div class="perton">history<span></span></div>

                    </div>
                </div>
                        <div class="confirmTB">
                    <div class="MADbutton">버튼 아코디언
        	<%@include file ="_comment.jsp" %>
                    </div>
                </div>
                </div>
                </c:forEach>
                 </c:if>
                <div id ="offset"></div>
               