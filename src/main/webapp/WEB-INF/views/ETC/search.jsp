<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	var sw = $('input[name=search]').val();
	if (sw != null && sw != '') {
		$('.search_word').text("'"+sw+"'");		
	} else {
		$('.search_word').text();		
	}
</script>
	
<div class="search_wrapper">
	<div class="search_top">
		<h2 class="search_title"><span class="search_word"></span> 검색 결과</h2>
		<span class="search_result_count">48</span>
		<ul class="sort">
			<li><select>
					<option>카테고리선택</option>
					<option>음악</option>
					<option>운동</option>
					<option>요리</option>
					<option>미술</option>
					<option>라이프스타일</option>
					<option>커리어</option>
					<option>여행</option>
			</select></li>
			<li><select>
					<option>정확도순</option>
					<option>최신순</option>
					<option>인기순</option>
					<option>만족도순</option>
			</select></li>
		</ul>
	</div>
	
	<div class="main_video_wrapper">

	<div class="main_video_block_row"> <!-- 한 행에 전시할 강의 시작점마다 -->
		<div class="main_video_block">
			<div class="main_video_thumb">
			<a href="#"> <img src="resource/img/dummy_lec_img/art/art_2m.jpg" alt="lecfly lecture"></a>
			</div>
			<div class="main_video_info">
				<p class="main_video_info_category">미술</p>
				<div class="main_video_like"><i class="fas fa-heart fa-lg"></i>5341</div>
				<p class="main_video_info_title">"찰흙으로 세상을 만들자"</p>
				<img src="resource/img/dummy_lec_img/art/art_2m.jpg" class="video_info_creator_img">
				<p class="main_video_info_creator_name">조물주물</p>
				
			</div>
		</div>
		<div class="main_video_block">
			<div class="main_video_thumb">
			<a href="#"> <img src="resource/img/dummy_lec_img/art/art_5m.jpg" alt="lecfly lecture"></a>
			</div>
			<div class="main_video_info">
				<p class="main_video_info_category">미술</p>
				<div class="main_video_like"><i class="fas fa-heart fa-lg"></i>5341</div>
				<p class="main_video_info_title">"함부로 따라하면 안되는 문신"</p>
				<img src="resource/img/dummy_lec_img/art/art_5m.jpg" class="video_info_creator_img">
				<p class="main_video_info_creator_name">TaTo</p>
				
			</div>
		</div>
		<div class="main_video_block">
			<div class="main_video_thumb">
			<a href="#"> <img src="resource/img/dummy_lec_img/currier/currier_5m.jpg" alt="lecfly lecture"></a>
			</div>
			<div class="main_video_info">
				<p class="main_video_info_category">커리어</p>
				<div class="main_video_like"><i class="fas fa-heart fa-lg"></i>5341</div>
				<p class="main_video_info_title">"승마 이론"</p>
				<img src="resource/img/dummy_lec_img/currier/currier_5m.jpg" class="video_info_creator_img">
				<p class="main_video_info_creator_name">기수</p>
				
			</div>
		</div>
		<div class="main_video_block">
			<div class="main_video_thumb">
			<a href="#"> <img src="resource/img/dummy_lec_img/exercise/exercise_5m.jpg" alt="lecfly lecture"></a>
			</div>
			<div class="main_video_info">
				<p class="main_video_info_category">운동</p>
				<div class="main_video_like"><i class="fas fa-heart fa-lg"></i>5341</div>
				<p class="main_video_info_title">"초심자도 따라하는 암벽등반"</p>
				<img src="resource/img/dummy_lec_img/exercise/exercise_5m.jpg" class="video_info_creator_img">
				<p class="main_video_info_creator_name">Climer</p>
				
			</div>
		</div>
	</div>
	
	<div class="main_video_block_row"><!-- 한 행에 전시할 강의 시작점마다 -->
		<div class="main_video_block">
			<div class="main_video_thumb">
			<a href="#"> <img src="resource/img/dummy_lec_img/life_style/life_style_2m.jpg" alt="lecfly lecture"></a>
			</div>
			<div class="main_video_info">
				<p class="main_video_info_category">라이프스타일</p>
				<div class="main_video_like"><i class="fas fa-heart fa-lg"></i>5341</div>
				<p class="main_video_info_title">"손끝에서 펼쳐지는 magic"</p>
				<img src="resource/img/dummy_lec_img/life_style/life_style_2m.jpg" class="video_info_creator_img">
				<p class="main_video_info_creator_name">손끝사랑</p>
				
			</div>
		</div>
		<div class="main_video_block">
			<div class="main_video_thumb">
			<a href="#"> <img src="resource/img/dummy_lec_img/trable/trable_2m.jpg" alt="lecfly lecture"></a>
			</div>
			<div class="main_video_info">
				<p class="main_video_info_category">여행</p>
				<div class="main_video_like"><i class="fas fa-heart fa-lg"></i>5341</div>
				<p class="main_video_info_title">"걸어서 세계속으로"</p>
				<img src="resource/img/dummy_lec_img/trable/trable_2m.jpg" class="video_info_creator_img">
				<p class="main_video_info_creator_name">BACK팩</p>
				
			</div>
		</div>
		<div class="main_video_block">
			<div class="main_video_thumb">
			<a href="#"> <img src="resource/img/dummy_lec_img/trable/trable_8m.jpg" alt="lecfly lecture"></a>
			</div>
			<div class="main_video_info">
				<p class="main_video_info_category">여행</p>
				<div class="main_video_like"><i class="fas fa-heart fa-lg"></i>5341</div>
				<p class="main_video_info_title">"대한민국 곳곳의 산을 오르자"</p>
				<img src="resource/img/dummy_lec_img/trable/trable_8m.jpg" class="video_info_creator_img">
				<p class="main_video_info_creator_name">어니스트</p>
				
			</div>
		</div>
		<div class="main_video_block">
			<div class="main_video_thumb">
			<a href="#"> <img src="https://cdn.class101.net/images/5212f4a6-8ae0-4252-aaa4-c6537fc91a3b/1600xauto" alt="lecfly lecture"></a>
			</div>
			<div class="main_video_info">
				<p class="main_video_info_category">미술</p>
				<div class="main_video_like"><i class="fas fa-heart fa-lg"></i>5341</div>
				<p class="main_video_info_title">"전하고 싶은 한 줄, 필림의 딥펜 캘리그래피"</p>
				<img src="https://cdn.class101.net/images/5212f4a6-8ae0-4252-aaa4-c6537fc91a3b/1600xauto" class="video_info_creator_img">
				<p class="main_video_info_creator_name">필림</p>
				
			</div>
		</div>
	</div>
</div>
</div>

