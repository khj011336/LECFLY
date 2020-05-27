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

<script type="text/javascript">
	function selectNotice(ntId) { window.location.href		
			= '${pageContext.request.contextPath}'
			+ '/cs_receive_notice.LF?id='+ ntId;
	}	
</script>
<link type="text/css" rel="stylesheet" href="resources/css/CScenter/CSCenter.css">
<link type="text/css" rel="stylesheet" href="resources/css/CScenter/receive_board.css">

</head>
<body>	
<div class="CSsection">
	<div class="cre_notice">
                <div id="cre_notice_p">
                	<h4>크리에이터 공지사항</h4>
                	<br>
                    <p><b> LECFLY의 새소식을 확인하세요! </b></p>
                </div>
                
                <div id="cre_notice_table">
                    <c:if test="${!empty ntSize}">
		     	
                    <table>
                        <tr style="height:46px">
                            <th>NO</th>
                            <th>제목</th>
                            <th>등록일</th>
                            <th>조회수</th>
                        </tr>
                        <c:forEach var="nt" items="${notice}" varStatus="vs">
                        <tr id="tr_nt_${nt.id}" onclick="selectNotice('${nt.id}')" style="height:46px">
                            <td><c:out value="${nt.id}" default="0"/></td>
                            <td><c:out value="${nt.title}" default="제목없음"/></td>
                            <td><fmt:formatDate value="${nt.writedDay}" pattern="yyyy.MM.dd" /></td>
                            <td><c:out value="${nt.hits}" default="0"/></td>
                        </tr>
                        </c:forEach>
                     </table>
                     </c:if>
                    <div id="notice_numbering"><c:if test="${pn > 1}">
						<a href="${pageContext.request.contextPath}/creator_CS.LF?pn=${pn-1}">[PREV]</a>
					</c:if>
					 &nbsp; &nbsp;
					<c:forEach varStatus="vs" begin="1" end="${maxPn}" step="1">
						<c:if test='${vs.current eq pn}'>
							<b style='color: orangered'> ${vs.current}</b>
						</c:if>	
						<c:if test='${vs.current ne pn}'>
							<a href="${pageContext.request.contextPath}/creator_CS.LF?pn=${vs.current}"> ${vs.current}</a>
						</c:if>
						 &nbsp;
						 ${vs.current eq maxPn ? '': '|&nbsp;'}
					</c:forEach>
					 &nbsp; &nbsp;
					<c:if test="${pn < maxPn}">
						<a href="${pageContext.request.contextPath}/creator_CS.LF?pn=${pn+1}">[NEXT]</a>
					</c:if></div>
                </div>
            </div>
     </div>
</body>
</html>