<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<link type="text/css" rel="stylesheet" href="ttt.css">
	<div id="cls_wrap">
      	<div id="cls_content">
       		<div id="cls_head"><span class="creator_h1">클래스기본정보</span></div>
       		<div id="cls_part1">
       			<div id="cls_form">
       			
       				<div class="cls_text1"><label for="cls_category" class="creator_h3">클래스 카테고리</label></div>
       				<div><select id="cls_category" name="category" class="cls_bar1">
       					<option value="1"></option>
       					<option value="2"></option>
       				</select></div>
       				
       				<div class="cls_text1"><label for="cls_dif" class="creator_h3">클래스 난이도</label></div>
       				<div><select id="cls_dif" name="dif" class="cls_bar1">
       					<option value="high">상</option>
       					<option value="middle">중</option>
       					<option value="row">하</option>
       				</select></div>
       				
       				<div class="cls_text1"><label for="cls_class_topic" class="creator_h3">클래스 주제</label></div>
       				<div><input type="text" id="cls_class_topic" name="topic" 
       					class="cls_bar1" placeholder="내용을 입력해주세요"></div>
       					
       				<div class="cls_text1"><label for="cls_class_title" class="creator_h3">클래스 타이틀</label></div>
       				<div><input type="text" id="cls_class_title" name="title" 
       					class="cls_bar1" placeholder="내용을 입력해주세요"></div>
       					
       			</div>
       			<div id="cls_exbox"></div>
       		</div>
       		<div id="cls_part2">
	    		<div class="cls_text1"><label for="cls_cover_img" class="creator_h3">클래스 커버이미지</label><span class="creator_h5 cls_left_interval">커버로 사용할 이미지를 추가해보세요</span></div>
       			<div id="cls_imgbox1" class="cls_imgbox1"><img src="resource/img/creator/dummy_img1.jpg" class="cls_imgbox1">
       			<input type="file" name="cover_img_path" class="cls_bar2"></div>
       			<div id="cls_img_path_box"></div>
       		</div>
       		<div id="cls_part3">
       			<div class="cls_text1"><span class="creator_h3">강의 소개하기</span></div>
       			<div id="cls_imgbox2" class="cls_imgbox2"><img src="resource/img/creator/dummy_img1.jpg" class="cls_imgbox2">
       			<input  type="file"></div>
       			<div id="cls_imgbox3" class="cls_imgbox2"><img src="resource/img/creator/dummy_img1.jpg" class="cls_imgbox2">
       			<input  type="file"></div>
       			<div id="cls_contentbox"></div>
       		</div>
       		<div id="cls_part4">
       			<div class="cls_text1"><label for="cls_des" class="creator_h3">강의에 대해서 입력해주세요</label></div>
       			<div><textarea id="cls_des" name="des" class="cls_bar3 uplnotes" placeholder="내용을 입력해주세요"></textarea></div>
       			<div><input type="button" value="저장" class="creator_next_btn cls_next_btn"></div>
       		</div>
       		
        </div>
    </div>