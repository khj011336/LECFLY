<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
    function fundingPayment_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sellkitregistration_delivery_adress").value = extraAddr;
                
                } else {
                    document.getElementById("sellkitregistration_delivery_adress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sellkitregistration_delivery_adress').value += data.zonecode;
                document.getElementById("sellkitregistration_delivery_adress").value += addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sellkitregistration_delivery_adress").focus();
            }
        }).open();
    }
    
    	function movePaymentFinished() {
    		$('#homemain').load('<%=request.getContextPath()%>/payment/paymentFinished.jsp');
		}
    	
    	
    function setImageFromFile(input, expression, tempses) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $(expression).attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
    function ispty(){
        var each =	$('#kitform').find("input[type!=hidden],textarea,select").not("input[type=button]").not("input[type=file]");
        var a = 0;
        for(var i =0 ; i<each.length;i++ ){
        	if(each[i].value == undefined || each[i].value == null || each[i].value ==""){
        		a++;
        	}
        } 
        	if(a>0){
        		alert("값을 다입력해주세요");
        		return true;
        	}else{
        		return false;
        	}
      }
	$().ready(function(){
		$("#kitbtna").on("click",function(){
    		fundingPayment_execDaumPostcode()
    	});
		$("#kitImg").on("change",function(){
			setImageFromFile(this,"#sellkitregistration_sub_img1","temp");
				
			
		});
		$(document).on("click","#upbutton",function(){
		if(!ispty()){
			var form = $("#kitform");
			 
			form.submit();
		}
		});	
	});
    $(window).on("beforeunload",function(e){
   	 var nodename = false;
   	 var formdata = new FormData($('#viform')[0]);
   	 if(e.target.activeElement.nodeName.toLowerCase() == "body"||e.target.activeElement.nodeName.toLowerCase() == "input"){
   	   nodename = true;
	 }else{
		 nodename = false;
	 }
   	 if(nodename == false){
   		 return false;
   	 }
    });
    </script>
	<div id="sellkitregistration_wrap">
	<form action="kit_upload_proc.LF" method ="post" enctype="multipart/form-data" id = "kitform">
        <div id="sellkitregistration_head"><span class="creator_h1">판매키트 등록 </span></div>
        <input type = "hidden" value ="${category}" name = "category">
        <input type = "hidden" value ="${CFID}" name = "CFID">
        <div id="sellkitregistration_content">
        	<div class="creator_h2">판매키트</div>
            <div id="sellkitregistration_main_top">
                <div class="sellkitregistration_nav_part1">
<!--  										상품 카테고리                -->
                    <div class="sellkitregistration_mini_title_interval creator_h3">
                        <div class="sellkitregistration_inline sellkitregistration_nav1"><label for="sellkitregistration_item_category" class="">상품 카테고리</label></div>
                        <div class="sellkitregistration_inline"><input type="text" id="sellkitregistration_item_category" name="category" class="sellkitregistration_bar1" value="${CATEGORIRES[creatorKit.category]}" readonly></div>
                        <div class="sellkitregistration_inline"></div>
                    </div>
<!--                     					상품명 -->
                    <div class="sellkitregistration_mini_title_interval creator_h3">
                        <div class="sellkitregistration_inline sellkitregistration_nav1"><label for="sellkitregistration_item_name">상품명</label></div>
                        <div class="sellkitregistration_inline"><input type="text" id="sellkitregistration_item_name" name="title" value="${creatorKit.title}" class="sellkitregistration_bar2"></div>
                    </div>
<!--                     					판매가 -->
                    <div class="sellkitregistration_mini_title_interval creator_h3">
                        <div class="sellkitregistration_inline sellkitregistration_nav1"><label for="sellkitregistration_item_price">판매가</label></div>
                        <div class="sellkitregistration_inline"><input type="number" id="sellkitregistration_item_price" value="${creatorKit.price}" name="price" class="sellkitregistration_bar1" min="0" step="10000" value="10000">원</div>
                    </div>
<!-- 										재고수량				 -->
                    <div class="sellkitregistration_mini_title_interval creator_h3">  
                        <div class="sellkitregistration_inline sellkitregistration_nav1"><label for="sellkitregistration_item_count">재고수량</label></div>
                        <div class="sellkitregistration_inline"><input type="number" value="${creatorKit.remain}"id="sellkitregistration_item_count" name="remain"  class="sellkitregistration_bar1" min="0" step="1">개</div>
                    </div>    
                </div>
                <div class="sellkitregistration_nav_part2">
<!--                 						상품속성 -->
                    <div class="sellkitregistration_mini_title_interval creator_h3">
                        <div class="sellkitregistration_inline sellkitregistration_nav1"> </div>
                        <div class="sellkitregistration_inline"> </div>
                    </div>
                </div>
            </div>
            <div class="sellkitregistration_main_center">
                    <div id="sellkitregistration_sub_img_box3" class="sellkitregistration_inline">
                        <div class="sellkitregistration_img"><img id="sellkitregistration_sub_img1" src="${crPath}${creatorKit.imgPath}" class="sellkitregistration_img" alt="추가이미지"></div>
                        <div class="sellkitregistration_img_add_btn_div"><input type="file" name = "kitImg" id="kitImg"></div>
                    </div>
                </div>
            </div>
            <div class="sellkitregistration_main_bottom">
                <div class="sellkitregistration_main_bottom_part1">
<!--                 					택배사 -->								 
                    <div id="sellkitregistration_delivery_companybox" class="sellkitregistration_mini_title_interval creator_h3">
                        <div class="sellkitregistration_inline sellkitregistration_nav1"><label for="sellkitregistration_delivery_company">택배사</label></div>
                        <div class="sellkitregistration_inline"><input type="text" id="sellkitregistration_delivery_company" value="<c:out value='${creatorKit.deliver}' default ="대한통운택배" ></c:out>" name="deliver" class="sellkitregistration_bar1"></div>
                    </div>
<!-- 								배송비 -->
                    <div id="sellkitregistration_pricebox" class="sellkitregistration_mini_title_interval creator_h3">
                        <div class="sellkitregistration_inline sellkitregistration_nav1"><label for="sellkitregistration_delivery_price">배송비</label></div>
                        <div class="sellkitregistration_inline"><input type="number" id="sellkitregistration_delivery_price" value="${creatorKit.deliveryPrice}" name="deliveryPrice" class="sellkitregistration_bar1" min="0" step="1000" value="0">원</div>
                    </div>
                </div>
                <div class="sellkitregistration_main_bottom_part2">
                    <div class="sellkitregistration_mini_title_interval creator_h3">
                        <div class="sellkitregistration_inline sellkitregistration_nav1"><label for="sellkitregistration_delivery_adress">발송지</label></div>
                        <div class="sellkitregistration_inline"><input type="text" value="${creatorKit.fromTo}" class="sellkitregistration_bar3" id="sellkitregistration_delivery_adress" name="fromTo"></div>
                        <div class="sellkitregistration_inline"><input type="button" value="주소 검색" class="sellkitregistration_btn1" id ="kitbtna"></div>
                    </div>
                    <div class="sellkitregistration_mini_title_interval creator_h3">
                        <div class="sellkitregistration_inline sellkitregistration_nav1"><label for="sellkitregistration_delivery_guide_msg">배송안내문구</label></div>
                        <div class="sellkitregistration_inline"><select class="sellkitregistration_bar3" id="sellkitregistration_delivery_guide_msg" name="info">
                            <option value="1">신속 정확한 배달 해드리겠습니다.</option>
                            <option value="2">물건 깨짐 주의!!</option>
                            <option value="3">감사합니다.</option>
                        </select></div>
                    </div>
                </div>
                <div class="sellkitregistration_main_bottom_part3 creator_h3">      
                    <div class="sellkitregistration_detail_info_registration_part1">  
	                    <div class="sellkitregistration_mini_title_interval"><label for="sellkitregistration_detail_info_registration">상세정보등록</label></div>
	                    <div class="sellkitregistration_mini_title_interval sellkitregistration_nav_dummy2"><label for="sellkitregistration_detail_info_registration">내용</label></div>
                    </div>
                                
                    <div class="sellkitregistration_detail_info_registration_part2">    
	                    <div id="sellkitregistration_text_btn_box" class="sellkitregistration_inline"><input type="button" value="Text" class="sellkitregistration_btn2"></div>
	                    <div id="sellkitregistration_html_btn_box" class="sellkitregistration_inline"><input type="button" value="HTML" class="sellkitregistration_btn2"></div>
	                    <div id="sellkitregistration_help_btn_box" class="sellkitregistration_inline sellkitregistration_btn_interval1"></div>    
	                    <div><textarea id="sellkitregistration_detail_info_registration" name="DetailInfo" class="sellkitregistration_bar4" placeholder="내용을 입력해주세요">${creatorKit.detailInfo}</textarea></div>
	                    <div class="sellkitregistration_btn_interval2">
	                     
                    	</div>
                    </div>
                </div>
            </div>
            
            <div><input type="button" value="완료" class="creator_next_btn sellkitregistration_next_btn" id = "upbutton"></div>
            </form>
        </div>