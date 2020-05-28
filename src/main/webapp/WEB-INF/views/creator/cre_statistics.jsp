<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
    <script src="${pageContext.request.contextPath}/resources/chart/highcharts.js"></script>
<script src="${pageContext.request.contextPath}/resources/chart/modules/exporting.js"></script>
<script src="${pageContext.request.contextPath}/resources/chart/modules/export-data.js"></script>
<script src="${pageContext.request.contextPath}/resources/chart/modules/accessibility.js"></script>
 
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="Crewrapp">
    <div id="Creaver">
        <div><p>클래스 분석</p></div>
        <div><form><select id="CreSele">
        <c:choose >
        <c:when test="${not empty videoStat.title}">
        <c:forEach begin="0" varStatus="rs"  end="${videoStat.title.size()-1}">
            <option value="${rs.index}">${videoStat.title[rs.current]}</option>
            </c:forEach></c:when>
        <c:when test="${empty videoStat.title}">
        <option value="">없음</option>
        </c:when>
            </c:choose>
        </select></form></div>
        <div></div>
    </div>
   
     <div class ="CreAvere CreSD" id = "statst">
        <%@include file="_cre_statistics.jsp" %>
    </div>
  
</div>
</body>
</html>