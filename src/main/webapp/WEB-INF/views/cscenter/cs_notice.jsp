<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
 	response.setHeader("Cache-Control", "no-store");
%>
<meta charset="UTF-8">
<title>CSCENTER/NOTICE</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- <script type="text/javascript">
	function selectNotice(ntId) { window.location.href		
			= '${pageContext.request.contextPath}'
			+ '/Notice_receive.LF?id='+ Id;
	}	
</script> -->
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
           <li><h4><a href="cs_notice.LF" style="background-color: orange" id= "CS3">공지사항</a></h4></li>
       </ul>
    </div>
    <div id="CS_page">
	<div class="notice">
                <div id="notice_p">
                	<h4>공지사항</h4>
                	<br>
                    <p><b> LECFLY의 새소식을 확인하세요! </b></p>
                </div>
                
                <div id="notice_table">
             	<c:if test="${!empty ntSize}">
		     	
                    <table>
                        <tr>
                            <th>NO</th>
                            <th>제목</th>
                            <th>등록일</th>
                            <th>조회수</th>
                        </tr>
                        <c:forEach var="nt" items="${notice}" varStatus="vs">
                        <tr id="tr_nt_${nt.id}" onclick="selectNotice('${nt.id}')">
                            <td><c:out value="${nt.id}" default="0"/></td>
                            <td><c:out value="${nt.title}" default="제목없음"/></td>
                            <td><fmt:formatDate value="${nt.writedDay}" pattern="yyyy.MM.dd" /></td>
                            <td><c:out value="${nt.hits}" default="0"/></td>
                        </tr>
                        </c:forEach>
                     </table>
                     </c:if>
                    <div id="notice_numbering"><c:if test="${pn > 1}">
						<a href="${pageContext.request.contextPath}/cs_notice.LF?pn=${pn-1}">[PREV]</a>
					</c:if>
					 &nbsp; &nbsp;
					<c:forEach varStatus="vs" begin="1" end="${maxPn}" step="1">
						<c:if test='${vs.current eq pn}'>
							<b style='color: orangered'> ${vs.current}</b>
						</c:if>	
						<c:if test='${vs.current ne pn}'>
							<a href="${pageContext.request.contextPath}/cs_notice.LF?pn=${vs.current}"> ${vs.current}</a>
						</c:if>
						 &nbsp;
						 ${vs.current eq maxPn ? '': '|&nbsp;'}
					</c:forEach>
					 &nbsp; &nbsp;
					<c:if test="${pn < maxPn}">
						<a href="${pageContext.request.contextPath}/cs_notice.LF?pn=${pn+1}">[NEXT]</a>
					</c:if></div>
                </div>
            </div>
</div>
</div>
</body>
</html>