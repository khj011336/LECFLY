<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<div id="sellkitregistration_wrap">
        <div id="sellkitregistration_head"><span class="creator_h1">판매키트 등록 </span></div>
        
        <div id="sellkitregistration_content">
        	<div class="creator_h2">판매키트</div>
            <div id="sellkitregistration_main_top">
                <div class="sellkitregistration_nav_part1">
<!--  										상품 카테고리                -->
                    <div class="sellkitregistration_mini_title_interval creator_h3">
                        <div class="sellkitregistration_inline sellkitregistration_nav1"><label for="sellkitregistration_item_category" class="">상품 카테고리</label></div>
                        <div class="sellkitregistration_inline"><input type="text" id="sellkitregistration_item_category" name="item_category" class="sellkitregistration_bar1" readonly></div>
                        <div class="sellkitregistration_inline"><input type="button" value="카테고리 검색" class="sellkitregistration_btn1"></div>
                    </div>
<!--                     					상품명 -->
                    <div class="sellkitregistration_mini_title_interval creator_h3">
                        <div class="sellkitregistration_inline sellkitregistration_nav1"><label for="sellkitregistration_item_name">상품명</label></div>
                        <div class="sellkitregistration_inline"><input type="text" id="sellkitregistration_item_name" name="item_name" class="sellkitregistration_bar2"></div>
                    </div>
<!--                     					판매가 -->
                    <div class="sellkitregistration_mini_title_interval creator_h3">
                        <div class="sellkitregistration_inline sellkitregistration_nav1"><label for="sellkitregistration_item_price">판매가</label></div>
                        <div class="sellkitregistration_inline"><input type="number" id="sellkitregistration_item_price" name="item_price" class="sellkitregistration_bar1" min="0" step="10" value="10000">원</div>
                    </div>
<!-- 										재고수량				 -->
                    <div class="sellkitregistration_mini_title_interval creator_h3">  
                        <div class="sellkitregistration_inline sellkitregistration_nav1"><label for="sellkitregistration_item_count">재고수량</label></div>
                        <div class="sellkitregistration_inline"><input type="number" id="sellkitregistration_item_count" name="sellkitregistration_item_count"  class="sellkitregistration_bar1" min="0" step="1">개</div>
                    </div>    
                </div>
                <div class="sellkitregistration_nav_part2">
<!--                 						상품속성 -->
                    <div class="sellkitregistration_mini_title_interval creator_h3">
                        <div class="sellkitregistration_inline sellkitregistration_nav1">상품속성</div>
                        <div class="sellkitregistration_inline"><input type="button" value="속성설정" class="sellkitregistration_btn1"></div>
                    </div>
                </div>
            </div>
            <div class="sellkitregistration_main_center">
                <div class="sellkitregistration_inline sellkitregistration_nav1 creator_h2">상품이미지</div>
                <div class="sellkitregistration_main_center_part1_div">
                    <div id="sellkitregistration_sub_img_box0" class="sellkitregistration_inline">
                        <div class="sellkitregistration_img"><img id="sellkitregistration_represent_img" name="represent_img" src="resource/img/xbox_img.PNG" class="sellkitregistration_img" alt="대표이미지"></div>
                        <div class="sellkitregistration_img_add_btn_div">대표이미지</div>
                    </div>

                    <div id="sellkitregistration_sub_img_box1" class="sellkitregistration_inline">
                        <div class="sellkitregistration_img"><img id="sellkitregistration_sub_img1" name="sub_img" src="resource/img/xbox_img.PNG" class="sellkitregistration_img" alt="추가이미지"></div>
                        <div class="sellkitregistration_img_add_btn_div">추가이미지</div>
                    </div>
                    <div id="sellkitregistration_sub_img_box2" class="sellkitregistration_inline">
                        <div class="sellkitregistration_img"><img id="sellkitregistration_sub_img2" name="sub_img" src="resource/img/xbox_img.PNG" class="sellkitregistration_img" alt="추가이미지"></div>
                        <div class="sellkitregistration_img_add_btn_div">추가이미지</div>
                    </div>
                    <div id="sellkitregistration_sub_img_box3" class="sellkitregistration_inline">
                        <div class="sellkitregistration_img"><img id="sellkitregistration_sub_img1" name="sub_img" src="resource/img/xbox_img.PNG" class="sellkitregistration_img" alt="추가이미지"></div>
                        <div class="sellkitregistration_img_add_btn_div">추가이미지</div>
                    </div>
                </div>
            </div>
            <div class="sellkitregistration_main_bottom">
                <div class="sellkitregistration_main_bottom_part1">
<!--                 					택배사 -->
                    <div id="sellkitregistration_delivery_companybox" class="sellkitregistration_mini_title_interval creator_h3">
                        <div class="sellkitregistration_inline sellkitregistration_nav1"><label for="sellkitregistration_delivery_company">택배사</label></div>
                        <div class="sellkitregistration_inline"><input type="text" id="sellkitregistration_delivery_company" name="delivery_company" class="sellkitregistration_bar1"></div>
                    </div>
<!-- 								배송비 -->
                    <div id="sellkitregistration_pricebox" class="sellkitregistration_mini_title_interval creator_h3">
                        <div class="sellkitregistration_inline sellkitregistration_nav1"><label for="sellkitregistration_delivery_price">배송비</label></div>
                        <div class="sellkitregistration_inline"><input type="number" id="sellkitregistration_delivery_price" name="delivery_price" class="sellkitregistration_bar1" min="0" step="10" value="0">원</div>
                    </div>
                </div>
                <div class="sellkitregistration_main_bottom_part2">
                    <div class="sellkitregistration_mini_title_interval creator_h3">
                        <div class="sellkitregistration_inline sellkitregistration_nav1"><label for="sellkitregistration_delivery_adress">발송지</label></div>
                        <div class="sellkitregistration_inline"><input type="text" class="sellkitregistration_bar3" id="sellkitregistration_delivery_adress" name="sellkitregistration_delivery_adress" readonly></div>
                        <div class="sellkitregistration_inline"><input type="button" value="주소 검색" class="sellkitregistration_btn1"></div>
                    </div>
                    <div class="sellkitregistration_mini_title_interval creator_h3">
                        <div class="sellkitregistration_inline sellkitregistration_nav1"><label for="sellkitregistration_delivery_guide_msg">배송안내문구</label></div>
                        <div class="sellkitregistration_inline"><select class="sellkitregistration_bar3" id="sellkitregistration_delivery_guide_msg" name="delivery_guide_msg">
                            <option value="msg1"></option>
                            <option value="msg2"></option>
                            <option value="msg3"></option>
                        </select></div>
                    </div>
                </div>
                <div class="sellkitregistration_main_bottom_part3 creator_h3">      
                    <div class="sellkitregistration_detail_info_registration_part1">  
	                    <div class="sellkitregistration_mini_title_interval"><label for="sellkitregistration_detail_info_registration">상세정보등록</label></div>
	                    <div class="sellkitregistration_mini_title_interval sellkitregistration_nav_dummy2"><label for="sellkitregistration_detail_info_registration">내용</label></div>
                    </div>
                        <!-- html 클릭시 readonly로바뀌고 동적으로? html코드가나온다?                   -->
                    <div class="sellkitregistration_detail_info_registration_part2">    
	                    <div id="sellkitregistration_text_btn_box" class="sellkitregistration_inline"><input type="button" value="Text" class="sellkitregistration_btn2"></div>
	                    <div id="sellkitregistration_html_btn_box" class="sellkitregistration_inline"><input type="button" value="HTML" class="sellkitregistration_btn2"></div>
	                    <div id="sellkitregistration_help_btn_box" class="sellkitregistration_inline sellkitregistration_btn_interval1"><input type="button" value="도움말" class="sellkitregistration_btn2"></div>    
	                    <div><textarea id="sellkitregistration_detail_info_registration" name="detail_info_registration" class="sellkitregistration_bar4" placeholder="내용을 입력해주세요"></textarea></div>
	                    <div class="sellkitregistration_btn_interval2">
	                    	<div id="sellkitregistration_fix_btn_box" class="sellkitregistration_inline"><input type="button" value="수정" class="sellkitregistration_btn3"></div>
                    		<div id="sellkitregistration_save_btn_box" class="sellkitregistration_inline"><input type="button" value="저장" class="sellkitregistration_btn3"></div>
                    	</div>
                    </div>
                </div>
            </div>
            
            <div><input type="button" value="완료" class="creator_next_btn sellkitregistration_next_btn"></div>
        </div>
    </div>