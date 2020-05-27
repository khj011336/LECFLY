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
        <c:forEach begin="0" varStatus="rs"  end="${videoStat.title.size()-1}">
        <c:if test ="${not empty videoStat.title}">
            <option value="${rs.index}">${videoStat.title[rs.current]}</option>
            </c:if>
            </c:forEach>
        </select></form></div>
        <div></div>
    </div>
   
     <div class ="CreAvere CreSD" id = "statst">
        <%@include file="_cre_statistics.jsp" %>
    </div>
  
</div>
</body>
</html>