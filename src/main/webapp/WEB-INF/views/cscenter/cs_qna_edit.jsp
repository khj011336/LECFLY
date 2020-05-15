<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
 	response.setHeader("Cache-Control", "no-store");
%>


<meta charset="UTF-8">
<title>CSCENTER/EDITQnA</title>
<link type="text/css" rel="stylesheet" href="resources/css/CScenter/CSCenter.css">
<link type="text/css" rel="stylesheet" href="resources/css/CScenter/receive_board.css">
</head>
<body>
	<div class="CSsection">
	<div id="CSsec_title"><h2>고객섬김센터</h2></div>
		<div class="post_board">
            <div id="post_title">
            <br><br><br><br>
               <h4>QnA게시판 문의 편집하기</h4>
            </div>
            <br><br>
	 		<form action="${pageContext.request.contextPath}/cs_update_qna.LF" method="post">
		 		<%--히든으로 게시물 번호 가져옴 --%>
				<input type="hidden" name="id" value="${qna.id}" />
			<table>
	        	<tr>
	            	<th>&nbsp;</th>
	            	<td style="font-size: 12px; color: orangered;">
	            	* 문의 종류와 첨부파일은 변경 불가능합니다. 변경을 원하실경우 삭제 후 재등록 부탁드립니다.<br><br>
	            	</td>
				</tr>
	            <tr>
	                <th>문의 종류</th>
	                <td>
	                	<div class="post_input_wrap">
	                		<span>${qna.stype}</span>
	                	</div>
	                </td>
	            </tr>
	            <tr>
	            	<th>이름</th>
	            	<td>
		            	<div class="post_input_wrap">
		            		<input type="text" class="input input_qna_name"  name="mbId" placeholder="${mbName}" value="123" readonly>
		            	</div>
	            	</td>
	            </tr>
	            <tr>
	            	<th>닉네임</th>
	            	<td>
		            	<div class="post_input_wrap">
		            		<input type="text" class="input input_qna_id" name="mbNicname" placeholder="${mbnicname}" value="홍길동" readonly>
		            	</div>
	            	</td>
	            </tr>
	            <tr>
	            	<th>휴대폰</th>
	            	<td>
		            	<div class="post_input_wrap">
		            		<input type="text" class="input input_qna_phone" placeholder="${mbphNumber}" value="${mbphNumber}" readonly>
		            	</div>
	            	</td>
	            </tr>
	            <tr>
	            	<th>이메일</th>
	            	<td>
		            	<div class="post_input_wrap">
		            		<input type="text" class="input input_qna_email" placeholder="${mbemail}" value="${mbemail}" readonly>
		            	</div>
		            </td>
	            </tr>
	            <tr>
	            	<th>&nbsp;</th>
	            	<th>&nbsp;</th>
	            </tr>
	            <tr>
	            	<th>&nbsp;</th>
	            	<td><input type="reset" class="btn_reset" style="background-color: orangered"  value="리셋하기"></td>
	            </tr>
	            <!--  -->
	            <tr>
	            	<th>제목</th>
	            	<td>
		            	<div class="post_input_wrap">
		            		<input type="text" class="input input_qna_title" name="title" placeholder="${qna.title}" value="${qna.title}">
		            	</div>
		            </td>
	            </tr>
	            <tr>
	            	<th>내용</th>
	            	<td>
		            	<div class="post_input_wrap">
		            		<textarea  class="input input_qna_txtarea" placeholder="${qna.content}" name="content" cols="97px" rows="30px" style="resize: none;">${qna.content}</textarea>
		            	</div>
		            </td>
	            </tr>
	            <tr>
	            	<th>&nbsp;</th>
	            	<th>&nbsp;</th>
	            </tr>
	            <tr>
	                <th>파일첨부</th>
	                <td>
		                <div class="post_add_thumb_wrap">
		                	<input type="file" id="add_thumb" multiple="multiple" name="File" accept="image/*">
		                </div>
	                </td>
	            </tr>
	            <tr>
	            	<th>&nbsp;</th>
	            	<td>
	            		<ul class="post_qna_ul">
	            			<li>파일당  최대 5Mbyte의 용량 제한이 있습니다.</li>
	            			<li>파일명은 영문만 가능합니다.</li>
	            		</ul>
					</td>
				</tr>
				<tr>
	            	<td>&nbsp;</td><td>&nbsp;</td>
	            </tr>
	            <tr>
					<th colspan="2">
						<br>
						<input id = "post_private" name = "showPrivate" type="checkbox" value="1">
	                    <label for= "post_private">비공개로 게시하시겠습니까?</label>
	                    <input type="hidden" name="showPrivate" value="0">
					</th>
	            </tr>
	            <tr>
					<th colspan="2">
						<br>
						<br>
						<input type="submit" class="btn_post" value="문의글 수정하기">
						<!-- <a href="#" title="문의글 수정" class="btn_post">문의글 수정하기</a> -->
					</th>
	            </tr>
	       </table>
	      </form>
    	</div>
    </div>
</body>
</html>