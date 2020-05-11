<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
 	response.setHeader("Cache-Control", "no-store");
%>
<meta charset="UTF-8">
<title>CSCENTER/QNA</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript">
	function selectQna(qaId) { window.location.href		
			= '${pageContext.request.contextPath}'
			+ '/qna_receive.LF?id='+ Id;
	}	
</script>
<link type="text/css" rel="stylesheet" href="resources/css/CScenter/CSCenter.css">
<link type="text/css" rel="stylesheet" href="resources/css/CScenter/receive_board.css">

</head>
<body>
<div class="CSsection">
	<div id="CSsec_title"><h2>고객섬김센터</h2></div>
    <div id="CSsec_subtitle">
       <ul>
           <li><h4><a href="cs_qna.LF" id= "CS1">QnA</a></h4></li>
           <li><h4><a href="cs_faq.LF" id= "CS2">자주묻는 질문</a></h4></li>
           <li><h4><a href="cs_notice.LF" id= "CS3">공지사항</a></h4></li>
       </ul>
    </div>
    <div id="CS_page">
	<div class="QnA">
    	<div id="qna_p">
        	<h3>QnA</h3>
        </div>
	    <div id="qna_noticebox">
	        <p>	
	        	온라인 취미 클래스 플랫폼 LecFly입니다. 
	        	<br>LecFly를 이용해주셔서 감사합니다.
         		<br>서비스 이용시 불편사항이나 문의사항 빠르고 친절하게 안내해 드리겠습니다.
         		<br>
         		<br>QnA게시판은 회원만 작성 가능합니다.
         		<br>비회원께서는 회원가입을 해주시거나 우측 하단 실시간문의를 이용해주시면 감사하겠습니다.
         		<br>*실시간문의는 운영시간내에만 이용가능합니다.
         		<br><br>감사합니다:)
         		<a href="cs_post_qna.LF"><button class="edit_qna">QnA 작성하기</button></a>
			</p>
	    </div>
	    <div id="qna_table">
		     
		     <h2> 문의 내역 (test용 전체 게시글 리스트: ${pn}페이지 -
				<c:out value="${qaSize}" default="0"/>개) </h2>
		     <c:if test="${!empty qaSize}">
		     
		     <table>
		     	<tr>
		        	<th>NO</th>
                    <th>제목</th>
                    <th>구분</th>
                    <th>작성자</th>
                    <th>등록일</th>
                    <th>조회수</th>
                 </tr>
                 <c:forEach var="qa" items="${qna}" varStatus="vs">
                 <tr id="tr_qa_${qa.id}" onclick="selectQna('${qa.id}')"> 
                 	<td><c:out value="${qa.id}" default="0"/> </td>
                 	<td>
						<c:out value="${qa.title}" default="제목없음"/>
						<span class="qc_cnt">
							<small style="color: red">
							 (${cntQnaComments[vs.index]}) 
							</small>
						</span>
					</td>
					<td><c:out value="${qa.type}" default="선택안함"/></td>
					<td><c:out value="${qa.mbId}" default="멤버없음"/></td>
	               	<td><fmt:formatDate value="${qa.writedDay}" pattern="yyyy.MM.dd" /> </td>
					<td><c:out value="${qa.hits}" default="0"/></td>
				</tr>
				</c:forEach>	
              </table>
              </c:if>
              
               <div id="qna_numbering">
	               	<c:if test="${pn > 1}">
						<a href="${pageContext.request.contextPath}/cs_qna.LF?pn=${pn-1}">[PREV]</a>
					</c:if>
					 &nbsp; &nbsp;
					<c:forEach varStatus="vs" begin="1" end="${maxPn}" step="1">
						<c:if test='${vs.current eq pn}'>
							<b style='color: orangered'> ${vs.current}</b>
						</c:if>	
						<c:if test='${vs.current ne pn}'>
							<a href="${pageContext.request.contextPath}/cs_qna.LF?pn=${vs.current}"> ${vs.current}</a>
						</c:if>
						 &nbsp;
						 ${vs.current eq maxPn ? '': '|&nbsp;'}
					</c:forEach>
					 &nbsp; &nbsp;
					<c:if test="${pn < maxPn}">
						<a href="${pageContext.request.contextPath}/cs_qna.LF?pn=${pn+1}">[NEXT]</a>
					</c:if>
               
               </div>
		                    
            </div>     
       </div>
</div>
</div>
</body>
</html>