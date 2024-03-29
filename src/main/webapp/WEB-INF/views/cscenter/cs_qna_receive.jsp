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
	function deleteconfirm(mbId, logId){
		if(mbId == logId){
			if(confirm("삭제하시겠습니까?")){
				location.replace('${pageContext.request.contextPath}'+ '/qna_delete.LF?id=${qna.id}'); //yes
			}else{
				location.replace('${pageContext.request.contextPath}'+ '/qna_receive.LF?id=${qna.id}'); //no
			}
		}else {
			alert("작성자가 아닙니다. 본인만 삭제 가능합니다.");
		}
	}
	function editconfirm(mbId, logId){
		if(mbId == logId){
			if(confirm("수정하시겠습니까?")){
				location.replace('${pageContext.request.contextPath}'+ '/cs_edit_qna.LF?id=${qna.id}'); //yes
			}else{
				location.replace('${pageContext.request.contextPath}'+ '/qna_receive.LF?id=${qna.id}'); //no
			}
		}else {
			/* if(confirm("작성자가 아닙니다. 본인만 수정 가능합니다.")){
				location.replace('${pageContext.request.contextPath}'+ '/qna_receive.LF?id=${qna.id}'); //no
			} */
			alert("작성자가 아닙니다. 본인만 수정 가능합니다.");
		}
	}
	function listconfirm(){
		if(confirm("목록으로 돌아가시겠습니까?")){
			location.replace('${pageContext.request.contextPath}'+ '/cs_qna.LF?pn=${pn}'); //yes
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
			<div id = "button_left">
				<span id="rbBtn"><input type="button" value="목록" onclick="listconfirm()"></span>
			</div>
			<div id = "button_right">
				<span id="rbBtn"><input type="button" value="수정" onclick="editconfirm('${qna.mbId}', '${member.id}')"></span>
				<span id="rbBtn"><input type="button" value="삭제" onclick="deleteconfirm('${qna.mbId}', '${member.id}')"></span>
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
	            	<a href="C:\fusion11\spring_ws\LECFILE\2020\cscenter\Img${qna.file}">첨부파일</a>
				</span>
            </div>
        </div>
        </div>
        <div id="receiveBoard_articleBody">
         <textarea  readonly >${qna.content}</textarea>
        </div>
        <div class="counter" id="reply_count">댓글 <c:out value="${qcSize}" default="0"/>개</div>
        <div id="receiveBoard_bottom">
        	<div id="comment_list">
        		${comment}
        	</div>
        	<div id="input_comment">
	        	<textarea name="input_comment" rows="2" cols="112" placeholder="댓글을 입력해주세요"></textarea>
				<input style="width:70px; height: 26px;" id="input_btn" type="button" value="댓글달기">
			</div>
	      	<%-- <div id="input_comment">
	      	<form action="${pageContext.request.contextPath}/qna_receive.LF?id=${qna.id}" method="post" enctype="multipart/form-data">
	      		<input type="hidden" name="mbId" value="${mb.id}">
	      		<input type="hidden" name="mbNic" value="${mb.nicname}">
	      		<input type="hidden" name="tableCate" value=2>
	      		<input type="hidden" name="atId" value="${qna.id}">
	      		<label><b>'${mb.nicname}'님 댓글달기</b></label>
	      		<input type="text" class="input input_comment" name="comment" placeholder="댓글을 입력해주세요" size="80px">
				<input type="submit" class="btn_comment" value="댓글달기">	      	
	      	</form>
	      	</div>
	        <div id="comment_list">
				<ul>
					<c:if test="${!empty qcSize}">
					<c:forEach var="qc" items="${qnaComment}">
						<li> <b>'${qc.mbNic}'회원</b>
							 | <Strong style="font-size: 17px">${qc.comment}</Strong> - 
							 <fmt:formatDate value="${qc.createdAt}" pattern="yyyy년MM월dd일 (HH시mm분ss초)"/> 
						</li>
						<form action="${pageContext.request.contextPath}/qna_receive.LF?id=${qna.id}" method="post" enctype="multipart/form-data">
				      		<input type="hidden">
				      		&nbsp;&nbsp;>답글남기기<input type="text" class="input input_comment" name="comment" placeholder="답글을 입력해주세요" size="80px">
							<input type="submit" class="btn_reply" value="답글달기">	      	
				      	</form>
				      	
					</c:forEach>
				</c:if>
				<c:if test="${empty qcSize}">
					<li><P>작성된 댓글이 없습니다!</P></li>
				</c:if>
			</ul>
		
			</div> --%>
			
        </div>
        </div>
    </div>
</body>
</html>