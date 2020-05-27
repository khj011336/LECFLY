<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
  </script>

	<%@include file="cre_status.jsp" %>
	<div id="Crpf_wrap">
        <div id='Crpf_content'>
        	<div id="Crpf_head"><span class="creator_h1">크리에이터 소개</span></div>
        	<form  method="post"  id="aform" class='pubf'  enctype="multipart/form-data" action="creator_new_profile_proc.LF">
        	<input type="hidden" name="unloadA" value="." id = "unload">
        	<input type="hidden" name="id" value="${creator.id }">
        	<input type="hidden" name="imgPath" id="tempImg" value="${creator.imgPath }">
        	<input type="hidden" name="fid" value="${creator.fid }">
        	<div class="Crpf_form">
	            <div class="Crpf_text1"><span class="creator_h2">프로필 사진</span></div>
		        <div class='Crpf_imgbox1'>
		      
		            <div><img src ="${crPath}${creator.imgPath}"  class="Crpf_imgbox1" onError ="this.src='resources/imges/unknown/l4.PNG'"></div>
		            
		            <div class="Crpf_find creator_h4"><input type='file' id="aas" accept="image/gif, image/jpeg, image/png"  name="imgPathM" ></div>
	            </div>
	           
	            <div class="Crpf_text1"><label for="Crpf_name" class="creator_h3">닉네임</label></div>
	            <div><input type="text" id="Crpf_name" 
	            	name="nickname" class="Crpf_bar1" value="${creator.nickname }" placeholder="내용을 입력해주세요"></div>
	            
	            <!-- 크리에이터 연락처 인데 주소 넣는건지(address)or 폰번호 넣는건지 모르겠음(PH)-->
	            <div class="Crpf_text1"><label for="Crpf_creator_ph" class="creator_h3">연락처</label></div>
	            
	            <div><input type="tel" id="cCrpf_ph"  value="${creator.cellPhone }" pattern ="[0-9]{3}-[0-9]{4}-[0-9]{4}" title="010-1234-1234"
	            	name="cellPhone" class="Crpf_bar1" placeholder="내용을 입력해주세요"></div>
	            	
	            
	            <!-- 크리에이터 sns 계정 -->
	            <div class="Crpf_text1"><label for="Crpf_sns" class="creator_h3">SNS계정</label></div>
	            <div><input type="text" id="Crpf_sns" value="${creator.SNS}"
	            	name="SNS" class="Crpf_bar1" placeholder="내용을 입력해주세요" pattern= "http://www.[a-z].com/[a-z]" title="http://www.facebook.com/hongil"></div>
	            
	            <div class="Crpf_text1"><label for="Crpf_des" class="Crpf_h3">크리에이터 소개</label></div>
	            <div><textarea id="Crpf_des"  name="info" class="Crpf_bar2  uplnotes"  placeholder="내용을 입력해주세요">${creator.info}</textarea></div>
	            <div><input type="button" value="다음" class="Crpf_next_btn" id ="creatBtn"></div>
            </div>
            </form>
        </div>
    </div>
     			
     			