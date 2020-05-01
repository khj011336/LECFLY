<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href='css/lecplay.css' rel='stylesheet' type='text/css'>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
 <!-- <link type="text/css" rel="stylesheet" href="../resource/css/CSCenter.css">     -->
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
	 		<form>
	        <table>
	            <tr>
	                <th>문의 종류</th>
	                <td class="radio_qna_type">
	                	<input type="radio" id="1" name="a" ><label for="1">회원관련</label> &nbsp;
		                <input type="radio" id="2" name="a" ><label for="2">결제/배송관련</label> &nbsp;
		                <input type="radio" id="3" name="a"><label for="3">이용권</label> &nbsp;
		                <input type="radio" id="4" name="a" ><label for="4">강의</label> &nbsp;
		                <input type="radio" id="5"name="a" ><label for="5">펀딩</label> &nbsp;
		                <input type="radio" id="6"name="a" ><label for="6">기타</label> &nbsp;
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
		            		<input type="text" class="input input_qna_name" placeholder="이름" value="홍길동" readonly>
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
						<!-- <input type="submit" class="btn_post" value="문의글 작성하기"> -->
						<a href="#" title="문의글 등록" class="btn_post">문의글 작성하기</a>
					</th>
	            </tr>
	       </table>
	      </form>
    	</div>
    </div>
</body>
</html>