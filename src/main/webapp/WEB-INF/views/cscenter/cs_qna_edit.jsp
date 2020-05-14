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
	                	 	<input type="text" class="input input_qna_type" placeholder="이름" value="${qna.stype}" readonly>
	                	</div>
	                </td>
	            </tr>
	            <tr>
	            	<th>이름</th>
	            	<td>
		            	<div class="post_input_wrap">
		            		<input type="text" class="input input_qna_name" placeholder="이름" value="${qna.type}" readonly>
		            	</div>
	            	</td>
	            </tr>
	            <tr>
	            	<th>아이디</th>
	            	<td>
		            	<div class="post_input_wrap">
		            		<input type="text" class="input input_qna_id" placeholder="아이디" value="kildong2203" readonly>
		            	</div>
	            	</td>
	            </tr>
	            <tr>
	            	<th>휴대폰</th>
	            	<td>
		            	<div class="post_input_wrap">
		            		<input type="text" class="input input_qna_phone" placeholder="휴대폰" value="010-1234-1111" readonly>
		            	</div>
	            	</td>
	            </tr>
	            <tr>
	            	<th>이메일</th>
	            	<td>
		            	<div class="post_input_wrap">
		            		<input type="text" class="input input_qna_email" placeholder="이메일" value="kildong@naver.com" readonly>
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
		            		<input type="text" class="input input_qna_title" placeholder="${qna.title}" value="${qna.title}">
		            	</div>
		            </td>
	            </tr>
	            <tr>
	            	<th>내용</th>
	            	<td>
		            	<div class="post_input_wrap">
		            		<textarea  class="input input_qna_txtarea" placeholder="내용을 입력해주세요" cols="97px" rows="30px" style="resize: none;"></textarea>
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
		                	<!-- <label for="add_thumb" class="label_add_thumb">사진첨부하기</label> -->
		                	<input type="file" id="add_thumb" accept="image/*">
		                	<input type="file" id="add_thumb" accept="image/*">
		                	<input type="file" id="add_thumb" accept="image/*">
		                	<!-- <ul>
		                		<li>
			                		<label for="add_thumb" class="label_add_thumb">사진첨부하기</label>
			                		<input type="file" id="add_thumb" accept="image/*">
		                		</li>
		                		<li>
			                		<label for="add_thumb2" class="label_add_thumb">사진첨부하기</label>
			                		<input type="file" id="add_thumb2" accept="image/*">
		                		</li>
		                		<li>
			                		<label for="add_thumb3" class="label_add_thumb">사진첨부하기</label>
			                		<input type="file" id="add_thumb3" accept="image/*">
		                		</li>
	                		</ul> -->
		                </div>
	                </td>
	            </tr>
	            <tr>
	            	<th>&nbsp;</th>
	            	<td>
	            		<ul class="post_qna_ul">
	            			<li>이미지는 1장에 최대 5Mbyte의 용량 제한이 있습니다.</li>
	            			<li>파일명은 영문만 가능합니다.</li>
	            			<li>첨부 사진은 3장까지만 등록이 가능합니다.</li>
	            		</ul>
					</td>
				</tr>
				<tr>
	            	<td>&nbsp;</td><td>&nbsp;</td>
	            </tr>
	            <tr>
					<th colspan="2">
						<br>
						<input id = "post_private" name = "post_private" type="checkbox" value="post_private">
	                    <label for= "post_private">비공개로 게시하시겠습니까?</label>
					</th>
	            </tr>
	            <tr>
					<th colspan="2">
						<br>
						<br>
						<input type="submit" class="btn_post" value="문의글 작성하기">
						<!-- <a href="#" title="문의글 수정" class="btn_post">문의글 수정하기</a> -->
					</th>
	            </tr>
	       </table>
	      </form>
    	</div>
    </div>
</body>
</html>