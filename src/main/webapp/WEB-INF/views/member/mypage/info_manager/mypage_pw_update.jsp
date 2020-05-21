<!-- 비밀번호 변경 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="mypage_bottom_info">
	<h2 class="mypage_bottom_title">비밀번호 변경</h2>
	<form action="update_mb_pw" method="post">
	<div class="mypage_bottom_contents">
		<div id="mypage_pw_table">
		     <table>
		     	<tr>
		        	<th>현재 비밀번호</th>
                    <td><input class="update_pw_input" id="input_member_pw" type="password" placeholder="기존 패스워드를 입력하세요" name="pw" size="30" maxlength="30" required></td>
                </tr>
                <tr>
		        	<th>새 비밀번호</th>
                    <td><input class="update_pw_input" id="new_password_1" type="password" placeholder="새로운 패스워드를 입력하세요" name="newPw" required></td>
                </tr>
                <tr>
                	<td></td>
                	<td style="font-size:12px;" name="pw_msg">비밀번호는 6~16자 영문, 숫자를 사용해주세요.</td>
                </tr>
                <tr>
		        	<th>새 비밀번호 확인</th>
                    <td><input class="update_pw_input" id="new_password_2" type="password" placeholder="패스워드를 한번더 입력하세요" name="newPwConfirm" required></td>
                </tr>
                <tr>
                	<td></td>
                	<td style="font-size:12px;" name="pw_check_msg">비밀번호 확인을 위해 새 비밀번호를 다시 한번 더 입력해주세요.</td>
                </tr>
            </table>
        </div>
<!-- 		<button>비밀번호 변경</button> -->
		<a href="#mypage_pw_update_confirm">비밀번호 변경</a> 
	</div>
	<div id="mypage_pw_update_confirm" class="overlay">
		<div class="popup">
			
			<a class="close" href="#">x</a>
			<div class="mypage_pw_update_popup_content">
				<h2 class="mypage_pw_isupdate">'??'님 비밀번호 수정 성공</h2>
			</div>
			<input id="mypage_pw_update_popup_submitbtn" type="button" value="확인">
		</div> 
    </div>
    </form>

</div>