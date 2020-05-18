<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
 	response.setHeader("Cache-Control", "no-store");
%>
<meta charset="UTF-8">
<title>CSCENTER/FAQ/크리에이터</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
           <li><h4><a href="cs_faq.LF" style="background-color: orange" id= "CS2">자주묻는 질문</a></h4></li>
           <li><h4><a href="cs_notice.LF" id= "CS3">공지사항</a></h4></li>
       </ul>
    </div>
    <div id="CS_page">
	<div id="faq">
       	<div id="faq_p">
           	<h4>자주묻는 질문</h4>
          
           
           <div id="faq_nav">
           <ul>
           	   <li><a href="cs_faq.LF" id="faq_0">전체</a></li>
               <li><a href="cs_faq_1.LF" id="faq_1">이용안내</a></li>
               <li><a href="cs_faq_2.LF" id="faq_2">강의수강</a></li>
               <li><a href="cs_faq_3.LF" id="faq_3">준비물 키트</a></li>
               <li><a href="cs_faq_4.LF" id="faq_4">결제/환불</a></li>
               <li><a href="cs_faq_5.LF" style="background-color: orange"  id="faq_5">크리에이터</a></li>
               <li><a href="cs_faq_6.LF" id="faq_6">기타</a></li>
           </ul>
           </div>
           </div>
           <div id="faq_main">
           		<div id="faq_table">
           		
           			<c:if test="${!empty fqSize}">
			    	<ul>
			    		<c:forEach var="fq" items="${faq5}" varStatus="vs">
			    		<li>
			    			<div id ="faq_acodian">
			      		<div id="faq_aco_type">&#91;<c:out value="${fq.stype}" default="type없음"/>&#93;</div>
			      		<div id="faq_aco_title"><c:out value="${fq.title}" default="title없음"/></div>
			             	<div id="faq_aco_txt">
			             		<c:out value="${fq.content}" default="type없음"/>
			             	</div>
			          	</div>
			    		</li>
			    		</c:forEach>
			    	</ul>
			    	</c:if>
			        <div id="faq_numbering">
			        	<c:if test="${pn > 1}">
						<a href="${pageContext.request.contextPath}/cs_faq_5.LF?pn=${pn-1}">[PREV]</a>
					</c:if>
					 &nbsp; &nbsp;
					<c:forEach varStatus="vs" begin="1" end="${maxPn}" step="1">
						<c:if test='${vs.current eq pn}'>
							<b style='color: orangered'> ${vs.current}</b>
						</c:if>	
						<c:if test='${vs.current ne pn}'>
							<a href="${pageContext.request.contextPath}/cs_faq_5.LF?pn=${vs.current}"> ${vs.current}</a>
						</c:if>
						 &nbsp;
						 ${vs.current eq maxPn ? '': '|&nbsp;'}
					</c:forEach>
					 &nbsp; &nbsp;
					<c:if test="${pn < maxPn}">
						<a href="${pageContext.request.contextPath}/cs_faq_5.LF?pn=${pn+1}">[NEXT]</a>
					</c:if>
               
			        </div>
			    </div>
           </div>	
       </div>
</div>
</div>
</body>
</html>