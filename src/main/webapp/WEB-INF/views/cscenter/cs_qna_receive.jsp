<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
 	response.setHeader("Cache-Control", "no-store");
%>
<meta charset="UTF-8">
<title>CSCENTER/QNA/RECEIVE</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	function selectQna(qaId) { window.location.href = '${pageContext.request.contextPath}'+ '/qna_receive.LF?id='+ qaId;
	}	
</script>
<script>
	function deleteconfirm(){
		if(confirm("삭제하시겠습니까?")){
			location.replace('${pageContext.request.contextPath}'+ '/qna_delete.LF?id=${qna.id}'); //yes
		}else{
			location.replace('${pageContext.request.contextPath}'+ '/qna_receive.LF?id=${qna.id}'); //no
		}
	}
	function editconfirm(){
		if(confirm("수정하시겠습니까?")){
			location.replace('${pageContext.request.contextPath}'+ '/cs_edit_qna.LF?id=${qna.id}'); //yes
		}else{
			location.replace('${pageContext.request.contextPath}'+ '/qna_receive.LF?id=${qna.id}'); //no
		}
	}
</script>
<link type="text/css" rel="stylesheet" href="resources/css/CScenter/CSCenter.css">
<link type="text/css" rel="stylesheet" href="resources/css/CScenter/receive_board.css">

</head>
<body>
<div id="receiveBoard_wrapper">
		<div id = "receiveBoard_button">
			<div id = "button_right">
				<%-- <a href="${pageContext.request.contextPath}/cs_edit_qna.LF?id=${qna.id}"><span id="rbBtn">수정</span></a> --%>
				<span id="rbBtn"><input type="button" value="수정" onclick="editconfirm()"></span>
				<span id="rbBtn"><input type="button" value="삭제" onclick="deleteconfirm()"></span>
			</div>
		</div>  
        <div id="receiveBoard_content">
          	<div class="receiveBoard_content_title">
                <span class=""></span>
             	 ${qna.id}번 | ${qna.title}
                <span class="divider">|</span>
                <span class="receiveBoard_category">${qna.stype}</span>
                <span class="titleRight">
                <span class="readhits">
                	조회수 &nbsp;${qna.hits}
                </span>
                <span class="readWriterTime">
                	 | ${qna.writedDay}
                </span>
                </span>
            </div>
            
        <div id="writeInfo">
        <div id="readHead">
            <div class="readLeft">
                <img src="resources/imges/unknown/no_profile_img.PNG" class="board_info_uploader_img">
                <strong>
                    ${qna.mbNicname}
                </strong>
                <span class="receiveBoradgrade">${qna.sshowPrivate}</span>
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
         <textarea  readonly >${qna.content}</textarea>
        </div>
        <div id="reply_count">댓글 <c:out value="${qcSize}" default="0"/>개</div>
        <div id="receiveBoard_bottom">
	      
	        <div id="comment_list">
			<c:choose>
				<c:when test="${!empty qcSize}">
					<ul>
						<c:forEach var="qc" items="${qnaComment}">
						<li> ${qc.mbLogin}회원 
							 ${qc.content} - 
							 <fmt:formatDate value="${qc.writedDay}" pattern="yyyy년MM월dd일 (HH시mm분ss초)"/> / 
							 <fmt:formatDate value="${qc.updatedDay}" pattern="yyyy년MM월dd일 (HH시mm분ss초)"/>
						</li>
						</c:forEach>
					</ul>
				</c:when>
				<c:when test="${empty qcSize}">
					<i>"작성된 댓글이 없습니다!"</i>
				</c:when>
			</c:choose>
			</div>
            </div>
        </div>
    </div>
</body>
</html>