<!-- 비밀번호 변경 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="mypage_bottom_info">
	<h2 class="mypage_bottom_title">비밀번호 변경</h2>
	<div class="mypage_bottom_contents">
<!-- <<<<<<< HEAD -->
<!-- 		<div class="um_title mypage_upw"><h2>''님 안녕하세요? ^^</h2></div> -->
<!-- 		<div id="mypage_upw_main"> -->
<!-- 			<div id="upw_changepw_box"> -->
<!-- 				<div> -->
<!-- 					<div class="upw_label upw_label1"><label for="upw_oldpw">비밀번호:</label></div> -->
<!-- 					<input type="password" id="upw_oldpw" name="upw_oldpw" placeholder="현재비밀번호를 입력해주세요"> -->
<!-- 				</div> -->
<!-- 				<div> -->
<!-- 					<div class="upw_label"><label for="upw_newpw">새 비밀번호:</label></div> -->
<!-- 					<input type="password" id="upw_newpw" name="upw_newpw" placeholder="변경할 비밀번호를 입력해주세요"> -->
<!-- 				</div> -->
<!-- 				<div> -->
<!-- 					<div class="upw_label"><label for="upw_newpw_re">새 비밀번호 확인:</label></div> -->
<!-- 					<input type="password" id="upw_newpw_re" name="upw_newpw_re" placeholder="변경할 비밀번호 다시입력해주세요"> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<!-- chapca?? 추가?? --> 
			
			
			
<!-- 			<div><input type="button" value="다음" id="upw_nextbtn"></div> -->
			
<!-- 		</div> -->
<!-- 	</div> -->
<!-- ======= -->
		<div id="mypage_pw_table">
		     <table>
		     	<tr>
		        	<th>현재 비밀번호</th>
                    <td><input class="update_pw_input" id="input_member_pw" type="password" placeholder="기존 패스워드를 입력하세요" name="member_pw" size="30" maxlength="30" required></td>
                </tr>
                <tr>
		        	<th>새 비밀번호</th>
                    <td><input class="update_pw_input" id="new_password_1" type="password" placeholder="새로운 패스워드를 입력하세요" name="member_pw" required></td>
                </tr>
                <tr>
                	<td></td>
                	<td style="font-size:12px;">비밀번호는 6~16자 영문, 숫자를 사용해주세요.</td>
                </tr>
                <tr>
		        	<th>새 비밀번호 확인</th>
                    <td><input class="update_pw_input" id="new_password_2" type="password" placeholder="패스워드를 한번더 입력하세요" name="member_pw" required></td>
                </tr>
                <tr>
                	<td></td>
                	<td style="font-size:12px;">비밀번호 확인을 위해 새 비밀번호를 다시 한번 더 입력해주세요.</td>
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

</div>