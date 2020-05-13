<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ include file="../common/_common.jsp" %>     --%>
		<c:choose>
			<c:when test="${fn:endsWith(fp,'.png') 
				or fn:endsWith(fp,'.jpg') 
				or fn:endsWith(fp,'.gif')}">
				<div id="file_show_${vs.index}" class="image_file">
					<b> ${vs.index}번 img path: ${fp}</b> <br>
					<img 
	src="${pageContext.request.contextPath}${fp}" 
						alt='origin file은 ${fn:split(fp,"_")[1]}' 
						width="20%" >
				</div>
			</c:when>
			<c:when test="${not fn:endsWith(fp,'.png') 
				and not fn:endsWith(fp,'.jpg') 
				and not fn:endsWith(fp,'.gif')}">
				<div id="file_show_${vs.index}" class="normal_file">
					<b> ${vs.index}번 file name: ${fn:split(fp,"_")[1]}</b> <br>
					<a 
	href="${pageContext.request.contextPath}${fp}">첨부파일 링크</a>					
				</div>
			</c:when>
		</c:choose>