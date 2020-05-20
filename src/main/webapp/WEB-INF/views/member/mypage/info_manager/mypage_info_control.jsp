<!-- 비밀번호 변경 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="mypage_bottom_info">
	<h2 class="mypage_bottom_title">로그인 정보 확인</h2>
	<div class="mypage_bottom_contents">

		<div id="mypage_info_control_table">
		     <table>
		     	<tr>
                	<td></td>
                	<td style="font-size:16px;">비밀번호를 한번 더 입력해주세요!</td>
                </tr>
		     	<tr>
		        	<th>아이디</th>
                    <td><input class="info_control_input" id="input_member_id" type="text" placeholder="기존 패스워드를 입력하세요" name="email" value="${member.email}" readonly></td>
                </tr>
                <tr>
		        	<th>비밀번호</th>
                    <td><input class="info_control_input" id="input_member_pw" type="password" placeholder="패스워드를 입력하세요" name="pw" required></td>
                </tr>
            </table>
        </div>
<!-- 		<button>비밀번호 변경</button> -->
		<input type="submit" class="btn_post" value="개인정보 수정페이지로 이동">
	</div>
	
</div>