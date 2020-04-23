<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<div id="Crpf_wrap">
        <div id='Crpf_content'>
        	<div id="Crpf_head"><span class="creator_h1">크리에이터 소개</span></div>
        	<div class="Crpf_form">
	            <div class="Crpf_text1"><span class="creator_h2">프로필 사진</span></div>
	            <!-- src="" 여기에 이제 기본이미지는 안넣은상태인걸한후 파일선택후 경로 입력되게끔 만들어야함 -->
		        <div class='Crpf_imgbox1'>
		            <div><img   
		                	  class="Crpf_imgbox1"></div>
		            <div class="Crpf_find creator_h4"><input type='file'></div>
	            </div>
	           
	            <div class="Crpf_text1"><label for="Crpf_name" class="creator_h3">크리에이터 닉네임</label></div>
	            <div><input type="text" id="Crpf_name" 
	            	name="nick_name" class="Crpf_bar1" placeholder="내용을 입력해주세요"></div>
	            
	            <!-- 크리에이터 연락처 인데 주소 넣는건지(address)or 폰번호 넣는건지 모르겠음(PH)-->
	            <div class="Crpf_text1"><label for="Crpf_creator_ph" class="creator_h3">연락처</label></div>
	            <div><input type="text" id="cCrpf_ph" 
	            	name="Crpf_ph" class="Crpf_bar1" placeholder="내용을 입력해주세요"></div>
	            
	            <!-- 크리에이터 sns 계정 -->
	            <div class="Crpf_text1"><label for="Crpf_sns" class="creator_h3">SNS계정</label></div>
	            <div><input type="text" id="Crpf_sns" 
	            	name="Crpf_sns_login" class="Crpf_bar1" placeholder="내용을 입력해주세요"></div>
	            
	            <div class="Crpf_text1"><label for="Crpf_des" class="Crpf_h3">크리에이터 소개</label></div>
	            <div><textarea id="Crpf_des" name="creator_des" class="Crpf_bar2  uplnotes" placeholder="내용을 입력해주세요"></textarea></div>
	            <div><input type="button" value="다음" class="Crpf_next_btn"></div>
            </div>
        </div>
    </div>
     			
     			