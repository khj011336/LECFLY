<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<link type="text/css" rel="stylesheet" href="resources/css/CScenter/CSCenter.css">
<link type="text/css" rel="stylesheet" href="resources/css/CScenter/receive_board.css">

</head>
<body>
<div id="receiveBoard_wrapper">
		<!-- <div id = "receiveBoard_button">
			<div id = "button_left">
			<span class="onlyForAdmin" id="rbBtn">수정</span>
			<div id = "button_right">
			<span class="onlyForAdmin" id="rbBtn">삭제</span>
			</div>
		</div>   -->
        <div id="receiveBoard_content">
            
            <div class="receiveBoard_content_title">
                <span class=""></span>
             	 ${Notice.id}번 | ${Notice.title}
                <span class="divider">|</span>
                <span class="receiveBoard_category">
                <a href="#">${Notice.stype}</a></span>
                <span class="titleRight">
                <span class="readhits">
                	조회수 &nbsp;${Notice.hits}
                </span>
                <span class="readWriterTime">
                	 | ${Notice.writedDay}
                </span>
                </span>
            </div>
            
        <div id="writeInfo">
        <div id="readHead">
            <div class="readLeft">
                <img src="resources/imges/unknown/no_profile_img.PNG" class="board_info_uploader_img">
                <strong>
                    <a rel="#">${Notice.mbId} LecFly 관리자</a>
                </strong>
            </div>
            <div class="titleRight">
            <span class="file">첨부파일:
            	<c:if test="${fpsCount gt 0}">
					<c:forEach var="fp" items="${fps}" varStatus="vs">
						<%@ include file="cs_file.jsp" %>						
					</c:forEach>
				</c:if>
			</span>
            </div>
        </div>
        </div>
        <div id="receiveBoard_articleBody">
         <textarea  readonly >${Notice.content}</textarea>
       <%--  ${Notice.content} --%>
        </div>
    </div>
</div>
</body>
</html>