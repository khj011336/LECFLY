<!-- 비밀번호 변경 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- 다음지도 가져오는 스크립트-->
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    
    <script>
	    $("input:text[close]").on("click", function() {
			$('#mypage_mb_update_confirm').html('');
	    });
    
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
	                
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('cnm_mb_adress_num').value = data.zonecode;
	                document.getElementById("cnm_mb_adress_basic").value = addr;
	                // 상세주소 필드의 내용이 사라진다.
	                document.getElementById("cnm_mb_adress_detail").value = '';
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("cnm_mb_adress_detail").focus();
	            }
	        }).open();
	    }
	    
	    //jquery
        $(document).ready( function() {

    	 	// 중복체크
    		$('#cnm_mb_nick_check_btn').on("click", function() {
    			var nickname = $('input[name=nickname]').val();
    			var tUrl = "${pageContext.request.contextPath}/";
    			tUrl += 'nic_dupcheck.LF';
    			if(nickname == '${member.nicname}'){
					$('#nicmsg').html('<b>사용예정인 닉네임을 입력하세요</b>');
    			} else{
	    			$.ajax ({ 
	    				type: 'get', 
	    				url: tUrl,
	    				data: "nickname="+nickname,
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
	    							break;
	    						case 'no':
	    							msg = '사용 가능한 닉네임입니다';
	    							break;
	    						case 'error':
	    							msg = '입력된 닉네임이 없습니다.';
	    							break;
	    					}
	    					$('#nicmsg').html('<b>'+msg+'</b>');
	    					$('#nicmsg').addClass(res);
	    				}
	    			});
    			}
    		});
    		
    	 	// 수정시 해결사항
    		$('#cnm_mb_nick_check_btn').on("click", function() {
    			var nic = $('input[name=nickname]').val();
    			var ph1 = $('input[name=ph1]').val();
    			var ph2 = $('input[name=ph2]').val();
    			var pc = $('input[name=postalcode]').val();
    			var ba = $('input[name=basic_address]').val();
    			var da = $('input[name=detail_address]').val();
    			var ae = $('input[name=agree_email]').val();
    			var as = $('input[name=agree_sms]').val();
    			var tUrl = "${pageContext.request.contextPath}/";
    			tUrl += 'update_mb_info.LF';
    			if(nickname == '${member.nicname}'){
					$('#nicmsg').html('<b>사용예정인 닉네임을 입력하세요</b>');
    			} else {
	    			$.ajax ({ 
	    				type: 'get', 
	    				url: tUrl,
	    				data: "nic="+nic+"&ph1="+ph1+"&ph2="+ph2+"&pc="+pc+"&ba="+ba+"&da="+da+"&ae="+ae+"&as="+as,
	    				success: function(res) {
	    					console.log(res);
	    					$('#nicmsg').html();
	    					$('#nicmsg').removeClass('yes');
	    					$('#nicmsg').removeClass('no');
	    					$('#nicmsg').removeClass('error');
	    					var msg = "";
	    					switch(res) {
	    						case '1': 
	    							msg = '이미 사용중인 닉네임입니다';
	    							break;
	    						case 'no':
	    							msg = '사용 가능한 닉네임입니다';
	    							break;
	    						case 'error':
	    							msg = '입력된 닉네임이 없습니다.';
	    							break;
	    					} // swutch 끝
	    					
	<%--     					$('#mypage_bottom').html(<%@ include file="mypage/attend_lec_manager/mmypage_mb_update.jsp"%>); --%>
	    				} //success 끝
	    			}); // ajax 끝
    			} // else 끝
    		}); // 수정시 해결사항끝
    	 	
    	 	$("#mb_update_confirm").on("click", function() {
    	 		console.log("mb_update_confirm 눌럿다");
    	 		var url = "${pageContext.request.contextPath}/mypage_mb_update_proc.LF";
    	 		var nickname = $("input[name=nickname]").val();
    	 		var ph1 = $("input[name=ph1]").val();
    	 		var ph2 = $("input[name=ph2]").val();
    	 		var agreeEmail = $("input[name=agreeEmail]").val();	
    	 		var agreeSms = $("input[name=agreeSms]").val();
    	 		var postalcode = $("input[name=postalcode]").val();
    	 		var basicAddress = $("input[name=basicAddress]").val();
    	 		var detailAddress = $("input[name=detailAddress]").val();
    	 		
    	 		var params = "nickname=" + encodeURIComponent(nickname) +  "&ph1=" + 
    	 			encodeURIComponent(ph1) + "&ph2=" + encodeURIComponent(ph2) + 
    	 			"&agreeEmail=" + encodeURIComponent(agreeEmail) + "&agreeSms=" + encodeURIComponent(agreeSms) + 
    	 			"&postalcode=" + postalcode + "&basicAddress=" + encodeURIComponent(basicAddress) + 
    	 			"&detailAddress=" + encodeURIComponent(detailAddress);
    	 		console.log("params = " + params );
    	 		$.ajax({
    	 			type: "POST",
    	 			url: url,
    	 			data: params,
    	 			dataType: "JSON",
    	 			success: function(res, status, xhr) {
    	 				console.log("수정성공");
    	 				$("#mypage_mb_update_confirm").html(res.temp);
    	 			},
    	 			error: function(status, xhr) {
    	 				console.log("수정실패")
    	 			}
    	 		});
    	 		
    	 	
    	 	})
    	 	
    	});
	    
    </script>
<div class="mypage_bottom_info">
	<h2 class="mypage_bottom_title">회원정보 수정</h2>
	<div class="mypage_bottom_contents">
		<div id="mypage_update_info_table">
			<div id="cnm_wrap3">
		    	<!-- <div id="cnm_pic">
		            <img src="resource/img/logo/LecFly_SLOGO_LW_W.png" width="148px" height="148px">
		          	<input type="button" value="EDIT">
		        </div> -->
		        <div id="cnm_table_left">
			    <div id="cnm_table2">
			    	<table>
			    		<tr>
	                		<td colspan="2" style="height:70px;"><b style="color:orangered;">*수정 불가 Part*</b><br><span style="font-size:12px; color:orangered;">개명 등의 이유로 수정을 원하시는 경우 고객센터로 요청해주시면 처리해드리겠습니다.</span></td>
	                	</tr>
				     	<tr>
				     		<th><label class="cnm_subtitle" for="cnm_mb_name">이름</label></th>
				     		<td><input type="text" id="cnm_mb_name" name="cnm_mb_name" class="input_cnm" style="background-color:lightgrey" readonly
				     		value=${member.name}></td>
				     	</tr>
				     	<tr>
				        	<th><label class="cnm_subtitle" for="cnm_mb_birth">생년월일</label></th>
		                    <td><input type="date" id="cnm_mb_birth" name="cnm_mb_birth" class="input_cnm" style="color:grey" readonly
		                    value=<fmt:formatDate value="${member.birthday}" pattern="yyyy-MM-dd"/>></td>
		                </tr>
		                <tr>
				        	<th><label class="cnm_subtitle">성별</label></th>
		                    <td>
<!-- 		                    	<input type="radio" id="cnm_mb_f" name="cnm_mb_gender" value="여" disabled><label for="cnm_mb_f" class="gender_sub_title">여성</label> -->
<!-- 	    						<input type="radio" id="cnm_mb_m" name="cnm_mb_gender" value="남" disabled><label for="cnm_mb_m" class="gender_sub_title">남성</label> -->
								<input type="text" id="cnm_mb_m" name="cnm_mb_gender" readonly value="${member.gender==1?'여성':'남성'}">
	    					</td>
		                </tr>
		                <tr>
				        	<th><label class="cnm_subtitle" for="cnm_mb_email2">이메일</label></th>
		                    <td>
		                    	<div style="display: inline-block">
		                    		<input type="text" id="cnm_mb_email2" name="cnm_mb_email2" class="input_cnm" style="background-color:lightgrey" readonly
		                    		value=${member.email}>
		                    	</div>
		                    </td>
		                </tr>
	                </table>
                </div>
             </div>
             <div id="cnm_table_right">
                <div id="cnm_table2">
<!--                 	<form action="update_mb_info.LF" method="post"> -->
				<form>
	                <table>
	                	<tr>
	                		<td colspan="2" style="height:70px;"><b style="color:orangered;">*수정 가능 Part*</b><br><span style="font-size:12px; color:orangered;">&nbsp;</span></td>
	                	</tr>
		                <tr>
				        	<th><label class="cnm_subtitle" for="cnm_mb_nick">닉네임</label></th>
		                    <td>
		                    	<div style="display: inline-block">
		                    		<input type="text" id="cnm_mb_nick" name="nickname" class="input_cnm" placeholder="닉네임" value=${member.nicname}>
		                    		<input type="button" id="cnm_mb_nick_check_btn" value="중복확인">
		                    	</div>
		                    </td>
		                </tr>
		                <tr>
		                	<td></td>
		                	<td style="font-size:12px;" id="nicmsg">닉네임은 6~14자의 영어/숫자 조합해주세요.</td>
		                </tr>
		                <tr>
				        	<th><label class="cnm_subtitle" for="cnm_mb_ph_first">휴대전화</label></th>
		                    <td>
		                    	<label class="cnm_ph_padding">010 - </label>
					        	<input type="text" class="cnm_mb_ph" id="cnm_mb_ph_first" name="ph1" placeholder="0000" maxlength="4"
					        	 numberOnly value=${fn:substring(member.phNumber,3,7)}>
					        	<label>-</label>
					        	<input type="text" class="cnm_mb_ph" id="cnm_mb_ph_second" name="ph2" placeholder="0000" maxlength="4"
					        	 numberOnly value=${fn:substring(member.phNumber,7,11)}>
					    	</td>
		                </tr>
		                <tr>
				        	<th rowspan="3"><label class="cnm_subtitle">주소</label></th>
		                    <td>
		                    	<div style="display: inline-block">
						    		<input type="text" id="cnm_mb_adress_num" name="postalcode" placeholder="우편번호" value=${member.postalCode}>
						        	<input type="button" id="find_adress_btn" value="주소찾기" onclick="find_address()">
					        	</div>
		                    </td>
		                </tr>
		                <tr>
				        	<td><input type="text" id="cnm_mb_adress_basic" name="basic_adress" class="input_cnm" placeholder="주소" value="${member.basicAddress}"></td>
		                </tr>
		                <tr>
		                	<td><input type="text" id="cnm_mb_adress_detail" name="detail_adress" class="input_cnm" placeholder="상세주소" value="${member.detailAddress}"></td>
		                </tr>
		                <tr>
				        	<th rowspan="2">소식 수신 동의</th>
				        	<td style="font-size:14px; padding-top:13px;"><b>LecFly의 다양한 소식들을 받아 보시겠습니까?</b><br><br>
								이벤트정보, 기타 다양한 정보를 빠르게 만나실 수 있습니다. <br>(주문, 배송내역은 수신여부와 상관 없이 기본 발송됩니다)
				        	</td>
				        </tr>
				        <tr>
		                    <td>
		                    	<input type="checkbox" id = "cnm_mb_agree_news_bymail" name = "agree_email"  value="agree_email" 
		                    	${member.agreeReceive==1 or member.agreeReceive==3 ? 'checked' : ''}>
	                            <label for= "cnm_mb_agree_news_bymail">네 이메일로 받아볼래요!</label>
	                            <input type="checkbox" id = "cnm_mb_agree_news_bysms" name = "agree_sms"  value="agree_sms"
	                            ${member.agreeReceive==2 or member.agreeReceive==3 ? 'checked' : ''}>
	                            <label for= "cnm_mb_agree_news_bysms">네 문자로 받아볼래요!</label>
	                        </td>
		                </tr>
		           </table>
		           </form>
		    </div>
	        </div>
		</div>
    </div>	
   	<div id="mypage_update_info_btn">
<!-- 			<button>회원정보 수정</button> -->
		<a href="#mypage_mb_update_confirm" id="mb_update_confirm">회원정보 수정</a> 
	</div>
	</div>
	<div id="mypage_mb_update_confirm" class="overlay">
<!-- 		<div class="popup"> -->
<!-- 			<a class="close" href="#">x</a> -->
<!-- 			<div class="mypage_mb_update_popup_content"> -->
<%-- 				<h2 class="mypage_mb_isupdate">'${member.name}'님 회원정보 수정 성공</h2> --%>
<!-- 			</div> -->
<!-- 			<input id="mypage_mb_update_popup_submitbtn" type="button" value="확인" class="close"> -->
<!-- 		</div> -->
	</div>
</div>