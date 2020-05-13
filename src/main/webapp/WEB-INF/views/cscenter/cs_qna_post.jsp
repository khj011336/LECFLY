<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CSCENTER/PostQnA</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link type="text/css" rel="stylesheet" href="resources/css/CScenter/CSCenter.css">
<link type="text/css" rel="stylesheet" href="resources/css/CScenter/receive_board.css">
</head>
<body>
	<div class="CSsection">
	<div id="CSsec_title"><h2>고객섬김센터</h2></div>
		<div class="post_board">
            <div id="post_title">
            <br><br><br><br>
               <h4>QnA게시판 문의하기</h4>
            </div>
            <br><br>
	 		<form action="${pageContext.request.contextPath}/cs_post_qna.LF" method="post" enctype="multipart/form-data">
	        <table>
	            <tr>
	                <th>문의 종류</th>
	                <td class="radio_qna_type">
	                	<input type="radio" id="0" name="a" ><label for="0">회원관련</label> &nbsp;
		                <input type="radio" id="1" name="a" ><label for="1">결제/배송관련</label> &nbsp;
		                <input type="radio" id="2" name="a"><label for="2">이용권</label> &nbsp;
		                <input type="radio" id="3" name="a" ><label for="3">강의</label> &nbsp;
		                <input type="radio" id="4"name="a" ><label for="4">펀딩</label> &nbsp;
		                <input type="radio" id="5"name="a" ><label for="5">기타</label> &nbsp;
	                </td>
	            </tr>
	            <tr>
	            	<th>&nbsp;</th>
	            	<td>
	            	<input type="button" class="edit_info" value="회원정보 변경하기">
	            	
	            	</td>
	            </tr>
	            <tr>
	            	<th>이름</th>
	            	<td>
		            	<div class="post_input_wrap">
		            		<input type="text" class="input input_qna_name" placeholder="이름" value="${mbId}" readonly>
		            	</div>
	            	</td>
	            </tr>
	            <tr>
	            	<th>닉네임</th>
	            	<td>
		            	<div class="post_input_wrap">
		            		<input type="text" class="input input_qna_id" placeholder="닉네임" value="${mbnicname}" readonly>
		            	</div>
	            	</td>
	            </tr>
	            <tr>
	            	<th>휴대폰</th>
	            	<td>
		            	<div class="post_input_wrap">
		            		<input type="text" class="input input_qna_phone" placeholder="휴대폰" value="${mbphNumber}" readonly>
		            	</div>
	            	</td>
	            </tr>
	            <tr>
	            	<th>이메일</th>
	            	<td>
		            	<div class="post_input_wrap">
		            		<input type="text" class="input input_qna_email" placeholder="이메일" value="${mbemail}" readonly>
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
		            		<input type="text" class="input input_qna_title" placeholder="제목을 입력해주세요">
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
		                	<input type="file" id="add_thumb" multiple="multiple" accept="image/*">
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
						<input id = "post_private" name = "post_private" type="checkbox" value="post_private">
	                    <label for= "post_private">비공개로 게시하시겠습니까?</label>
					</th>
	            </tr>
	            <tr>
					<th colspan="2">
						<br>
						<br>
						<input type="submit" class="btn_post" value="문의글 작성하기">
					</th>
	            </tr>
	       </table>
	      </form>
    	</div>
    </div>
</body>
</html>