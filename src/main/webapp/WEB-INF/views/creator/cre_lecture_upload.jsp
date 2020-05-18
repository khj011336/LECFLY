<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%@include file="cre_status.jsp" %>
	<div id="cls_wrap">
	<form id = "lecform" class='pubf'  method="post" enctype="multipart/form-data" action="creator_rightset_proc.LF">
      	<div id="cls_content">
       		<div id="cls_head"><span class="creator_h1">클래스기본정보</span></div>
       		<div id="cls_part1">
       			<div id="cls_form">
       			<input type="hidden" name="unloadB" value="." id = "unloadb">
       			<input type= "hidden" name = "id"value ="${Lecture.id}">
       			<input type= "hidden" name = "fid"value ="${Lecture.fid}">
       			<input type= "hidden" name= "titleImg" value ="${Lecture.titleImg}" id ="temp1">
       			<input type= "hidden" name = "infoImg" value ="${Lecture.infoImg}" id ="temp2">
       			<input type= "hidden" name = "infoImgb" value ="${Lecture.infoImgb}" id ="temp2">
       				<div class="cls_text1"><label for="cls_category" class="creator_h3">클래스 카테고리</label></div>
       				<div><select id="cls_category" name="category" class="cls_bar1" >
       					<option value="1" >미술</option>
       					<option value="2">음악</option>
       					<option value="3">요리</option>
       					<option value="4">라이프스타일</option>
       					<option value="5">운동</option>
       					<option value="6">커리어</option>
       					<option value="7">여행</option>
       				</select></div>
       				
       				<div class="cls_text1"><label for="cls_dif" class="creator_h3">클래스 난이도</label></div>
       				<div><select id="cls_dif"   class="cls_bar1">
       					<option value="high">상</option>
       					<option value="middle" >중</option>
       					<option value="row">하</option>
       				</select></div>
       				
       				<div class="cls_text1"><label for="cls_class_topic" class="creator_h3">클래스 주제</label></div>
       				<div><input type="text" id="cls_class_topic" name="title" 
       					class="cls_bar1" placeholder="내용을 입력해주세요" value ="${Lecture.title}"></div>
       					
       				<div class="cls_text1"><label for="cls_class_title" class="creator_h3">클래스 타이틀</label></div>
       				<div><input type="text" id="cls_class_title" name="subTitle" value="${Lecture.subTitle}" 
       					class="cls_bar1" placeholder="내용을 입력해주세요"></div>
       					
       			</div>
       			<div id="cls_exbox"></div>
       		</div>
       		<div id="cls_part2">
	    		<div class="cls_text1"><label for="cls_cover_img" class="creator_h3">클래스 커버이미지</label><span class="creator_h5 cls_left_interval">커버로 사용할 이미지를 추가해보세요</span></div>
       			<div id="cls_imgbox1" class="cls_imgbox1"><img src="${Lecture.titleImg}" class="cls_imgbox1" id="Timgshow">
       			<input type="file" accept="image/gif, image/jpeg, image/png" name="TitleImgM" id="titleimg" class="cls_bar2"></div>
       			<div id="cls_img_path_box"></div>
       		</div>
       		<div id="cls_part3">
       			<div class="cls_text1"><span class="creator_h3">강의 소개하기</span></div>
       			<div id="cls_imgbox2" class="cls_imgbox2"><img src="${Lecture.infoImg}" class="cls_imgbox2" id ="imgshow">
       			<input  type="file" accept="image/gif, image/jpeg, image/png"  name = "infoImgM" id ="infoimg"></div>
       			<div id="cls_imgbox3" class="cls_imgbox2"><img src="${Lecture.infoImg}" class="cls_imgbox2" id ="imgshowb">
       			<input  type="file" accept="image/gif, image/jpeg, image/png" name = "infoImgbM" id ="infoimgb"></div>
       			<div id="cls_contentbox"></div>
       		</div>
       		<div id="cls_part4">
       			<div class="cls_text1"><label for="cls_des" class="creator_h3">강의에 대해서 입력해주세요</label></div>
       			<div><textarea id="cls_des" name="info" class="cls_bar3 uplnotes" placeholder="내용을 입력해주세요">${Lecture.info}</textarea></div>
       			<div><input type="button" value="저장" class="creator_next_btn cls_next_btn exportb"></div>
       		</div>
       		
        </div>
        </form>
    </div>