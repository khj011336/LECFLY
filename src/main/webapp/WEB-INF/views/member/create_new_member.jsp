<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
	<meta charset="utf-8">
	<title>회원가입</title>
	<meta name="author" content="Your Name">
	<meta name="description" content="Example description">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" type="image/x-icon" href=""/>
	
    <link type="text/css" rel="stylesheet" href="resources/css/common/main.css">
    <link type="text/css" rel="stylesheet" href="resources/css/member/create_new_member.css">
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- 다음지도 가져오는 스크립트-->
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    
    <script>
	    // input text에서 숫자만 받게 하는 스크립트
	    $("input:text[numberOnly]").on("keyup", function() {
	        $(this).val($(this).val().replace(/[^0-9]/g,""));
	    });
	    
	    // 다음 지도 api 가져옴
	    function find_address() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
// 	                var extraAddr = ''; // 참고항목 변수

	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }

	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
// 	                if(data.userSelectedType === 'R'){
// 	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
// 	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
// 	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
// 	                        extraAddr += data.bname;
// 	                    }
// 	                    // 건물명이 있고, 공동주택일 경우 추가한다.
// 	                    if(data.buildingName !== '' && data.apartment === 'Y'){
// 	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
// 	                    }
// 	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
// 	                    if(extraAddr !== ''){
// 	                        extraAddr = ' (' + extraAddr + ')';
// 	                    }
	                
// 	                }

	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('cnm_mb_adress_num').value = data.zonecode;
	                document.getElementById("cnm_mb_adress_basic").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("cnm_mb_adress_detail").focus();
	            }
	        }).open();
	    }
        
        // 중복체크
        $(document).ready( function() {
    		$('#cnm_mb_nick_check_btn').on("click", function() {
    			var nicname = $('input[name=nickname]').val();
    			var tUrl = "${pageContext.request.contextPath}/";
    			tUrl += 'nic_dupcheck.LF';
    			$.ajax ({ 
    				type: 'get', 
    				url: tUrl,
    				data: "nickname="+nicname,
    				success: function(res) {
    					console.log(res);
    					$('#nicmsg').html();
    					$('#nicmsg').removeClass('yes');
    					$('#nicmsg').removeClass('no');
    					$('#nicmsg').removeClass('error');
    					var msg = "";
    					switch(res) {
    						case 'yes': 
    							msg = '이미 사용중인 닉네임입니다';
    							$('input[type=submit]').attr('disabled',true);
    							break;
    						case 'no':
    							msg = '사용 가능한 닉네임입니다';
    							$('input[type=submit]').attr('disabled',false);
    							break;
    						case 'error':
    							msg = '입력된 닉네임이 없습니다.';
    							$('input[type=submit]').attr('disabled',true);
    							break;
    					}
    					$('#nicmsg')
    						.html('<b>'+msg+'</b>');
    					$('#nicmsg').addClass(res);
    				}
    			});
    		});
    		$('#cnm_mb_email_check_btn').on("click", function() {
    			var email = $('input[name=email]').val();
    			var tUrl = "${pageContext.request.contextPath}/";
    			tUrl += 'email_dupcheck.LF';
    			$.ajax ({ 
    				type: 'get', 
    				url: tUrl,
    				data: "email="+email,
    				success: function(res) {
    					console.log(res);
    					$('#emailmsg').html();
    					$('#emailmsg').removeClass('yes');
    					$('#emailmsg').removeClass('no');
    					$('#emailmsg').removeClass('error');
    					var msg = "";
    					switch(res) {
    						case 'yes': 
    							msg = '이미 사용중인 이메일입니다';
    							$('input[type=submit]').attr('disabled',true);
    							break;
    						case 'no':
    							msg = '사용 가능한 이메일입니다';
    							$('input[type=submit]').attr('disabled',false);
    							break;
    						case 'error':
    							msg = '입력된 이메일이 없습니다.';
    							$('input[type=submit]').attr('disabled',true);
    							break;
    					}
    					$('#emailmsg')
    						.html('<b>'+msg+'</b>');
    					$('#emailmsg').addClass(res);
    				}
    			});
    		});
    	});
        $(function() {
            $("#imgProc").on('change', function(){
                readURL(this);
            });
        });
        function readURL(input) {
            if (input.files && input.files[0]) {
               var reader = new FileReader();
               reader.onload = function (e) {
                  $('#preImage').attr('src', e.target.result);
               }
               reader.readAsDataURL(input.files[0]);
            }
        }
    </script>
    
</head>
<div id="cnm_wrap">
	<form name="join_member" action="join_member_proc.LF" method="post">
	    <div class="cnm_title">
	    	<br><br><br><br>
	        <h3>회원가입</h3>
	        <br>
	    </div>
	    <!--각종 약관들? 이 페이지 넘어오기전에 새로운 페이지에서 처리한단.-->
	    <div id="cnm_wrap2">
	    	<div id="cnm_pic">
	            <img id="preImage" src="resources/imges/logo/LecFly_SLOGO_LW_W.png" width="148px" height="148px">
<!-- 	          	<input type="button" value="EDIT"> -->
				<input type="file" accept="image/*" id="imgProc" name="cnm_upload_pic" placeholder="사진 추가" size='64'>
	        </div>
	        
		    <div id="cnm_table">
			     <table>
			     	<tr>
			     		<th><label class="cnm_subtitle" for="name">이름</label></th>
			     		<td><input type="text" id="cnm_mb_name" name="name" class="input_cnm" placeholder="이름"
			     		 value="${!empty name ? name : ''}"></td>
			     	</tr>
			     	<tr>
			        	<th><label class="cnm_subtitle" for="nickname">닉네임</label></th>
	                    <td>
	                    	<div style="display: inline-block">
	                    		<input type="text" id="cnm_mb_nick" name="nickname" class="input_cnm" placeholder="닉네임"
	                    		 value="${!empty nickname ? nickname : ''}">
<!-- 	                    		<input type="button" id="cnm_mb_nick_check_btn" onclick="javascript:document.join_member.submit();" value="중복확인"> -->
	                    		<input type="button" id="cnm_mb_nick_check_btn" value="중복확인">
	                    	</div>
	                    </td>
	                </tr>
	                <tr>
	                	<td></td>
	                	<td style="font-size:12px;" id="nicmsg">${!empty nickname ? nick_msg : '닉네임은 6~14자의 영어/숫자 조합해주세요.'}</td>
	                </tr>
			     	<tr>
			        	<th><label class="cnm_subtitle" for="birthday">생년월일</label></th>
	                    <td><input type="date" id="cnm_mb_birth" name="birthday" class="input_cnm" style="color:grey"
			     		 value=<fmt:formatDate value="${birthday}" pattern="yyyy-MM-dd"/>></td>
	                </tr>
	                <tr>
			        	<th><label class="cnm_subtitle">성별</label></th>
	                    <td>
			     		 	<c:choose>
			     		 		<c:when test="${empty gender}">
	                    	<input type="radio" id="cnm_mb_f" name="gender" value="1"><label for="cnm_mb_f" class="gender_sub_title">여성</label>
	   						<input type="radio" id="cnm_mb_m" name="gender" value="3" checked><label for="cnm_mb_m" class="gender_sub_title">남성</label>
			     		 		</c:when>
			     		 		<c:when test="${gender eq '1' }">
	                    	<input type="radio" id="cnm_mb_f" name="gender" value="1"><label for="cnm_mb_f" class="gender_sub_title">여성</label>
	   						<input type="radio" id="cnm_mb_m" name="gender" value="3" checked><label for="cnm_mb_m" class="gender_sub_title">남성</label>
			     		 		</c:when>
			     		 		<c:when test="${gender eq '3' }">
	                    	<input type="radio" id="cnm_mb_f" name="gender" value="1"><label for="cnm_mb_f" class="gender_sub_title">여성</label>
	   						<input type="radio" id="cnm_mb_m" name="gender" value="3" checked><label for="cnm_mb_m" class="gender_sub_title">남성</label>
			     		 		</c:when>
			     		 		
			     		 	</c:choose>
	   					</td>
	                </tr>
	                <tr>
			        	<th><label class="cnm_subtitle" for="email">이메일</label></th>
	                    <td>
	                    	<div style="display: inline-block">
	                    		<input type="text" id="cnm_mb_email" name="email" class="input_cnm" placeholder="이메일" value=${email}>
	                    		<input type="button" id="cnm_mb_email_check_btn" value="중복확인">
	                    	</div>
	                    </td>
	                </tr>
	                <tr>
	                	<td></td>
	                	<td style="font-size:12px;" id="">${!empty email_msg ? email_msg : '실제 사용 가능한 이메일을 입력하세요.'}</td>
	                </tr>
	                <tr>
			        	<th>비밀번호</th>
	                    <td><input type="password" id="cnm_mb_pw" name="password" class="input_cnm" placeholder="비밀번호" value=${password}></td>
	                </tr>
	                <tr>
	                	<td></td>
	                	<td style="font-size:12px;">비밀번호는 6~16자 영문, 숫자를 사용해주세요.</td>
	                </tr>
	                <tr>
			        	<th>비밀번호 확인</th>
	                    <td><input type="password" id="cnm_mb_pw_confirm" name="pw_confirm" class="input_cnm" placeholder="비밀번호 확인" ${pw_confirm}></td>
	                </tr>
	                <tr>
	                	<td></td>
	                	<td style="font-size:12px;">비밀번호 확인을 위해 새 비밀번호를 다시 한번 더 입력해주세요.</td>
	                </tr>
	                <tr>
			        	<th><label class="cnm_subtitle" for="phNumber">휴대전화</label></th>
	                    <td>
	                    	<label class="cnm_ph_padding">010 - </label>
				        	<input type="text" class="cnm_mb_ph" id="cnm_mb_ph_first" name="phNumber" placeholder="0000" maxlength="4"
				        	 onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" value=${phNumber}>
				        	<label>-</label>
				        	<input type="text" class="cnm_mb_ph" id="cnm_mb_ph_second" name="phNumber2" placeholder="0000" maxlength="4"
				        	 onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" value=${phNumber2}>
				    	</td>
	                </tr>
	                <tr>
			        	<th rowspan="3"><label class="cnm_subtitle">주소</label></th>
	                    <td>
	                    	<div style="display: inline-block">
					    		<input type="text" id="cnm_mb_adress_num" name="postalcode" placeholder="우편번호" readonly value="${postalcode}">
					        	<input type="button" id="find_adress_btn" value="주소찾기" onclick="find_address()">
				        	</div>
	                    </td>
	                </tr>
	                <tr>
			        	<td><input type="text" id="cnm_mb_adress_basic" name="basic_address" class="input_cnm" placeholder="주소" value=${basic_address}></td>
	                </tr>
	                <tr>
	                	<td><input type="text" id="cnm_mb_adress_detail" name="detail_address" class="input_cnm" placeholder="상세주소" value=${detail_address}></td>
	                </tr>
	                <tr>
			        	<th rowspan="2">소식 수신 동의</th>
			        	<td style="font-size:14px; padding-top:13px;"><b>LecFly의 다양한 소식들을 받아 보시겠습니까?</b><br><br>
							이벤트정보, 기타 다양한 정보를 빠르게 만나실 수 있습니다. <br>(주문, 배송내역은 수신여부와 상관 없이 기본 발송됩니다)
			        	</td>
			        </tr>
			        <tr>
	                    <td>
	                    	<input type="checkbox" id = "cnm_mb_agree_news_bymail" name = "agree_receive_email"  value="agree_email">
	                           <label for= "cnm_mb_agree_news_bymail">네 이메일로 받아볼래요!</label>
	                           <input type="checkbox" id = "cnm_mb_agree_news_bysms" name = "agree_receive_sms"  value="agree_sms">
	                           <label for= "cnm_mb_agree_news_bysms">네 문자로 받아볼래요!</label>
	                       </td>
	                </tr>
	                <!-- <tr>
			        	<th rowspan="2">이용 및 개인정보 동의</th>
			        	<td>
			        		<input type="checkbox" id = "cnm_mb_agree_clause" name = "cnm_mb_agree_clause"  value="agree_clause">
	                           <label for= "cnm_mb_agree_clause"><a href="#" onclick="showClause()">사이트 및 개인정보 이용 약관</a></label>
	                       </td>
			        </tr> -->
	            </table>
	        </div>
		</div>
		<div id="print_msg">${msg}</div>
		<div class="cnm_bottom">
		    <div id="cnm_submit_btn">
		    	<a style="color: black;" href="#" onclick="javascript:document.join_member.submit();">회원가입하기</a>
		    </div>
	    </div>
    </form>
</div>