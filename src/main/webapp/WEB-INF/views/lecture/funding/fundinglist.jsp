<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link type="text/css" rel="stylesheet" href="resource/css/main.css">
<link type="text/css" rel="stylesheet"
	href="resource/css/fundinglist.css">

<div class="fu_search_wrapper">

	<div class="fusearch_top">
		<ul class="fusort">
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
		<br> <br>
	</div>


	<h2 class="fumain_title">지금 HOT한 펀딩</h2>

	<div class="funding_video_wrapper">
		<div class="main_video_block_row">
			<!-- 한 행에 전시할 강의 시작점마다 -->
			<%
				for (int i = 0; i < 3; i++) {
			%>
			<div class="main_video_block_rec">
				<div class="main_video_thumb_rec">
					<a href="#">
						<div class="main_video_thumb_btn">
							<i class="far fa-heart fa-2x"></i>
						</div> <img src="resource/img/dummy_lec_img/art/art_1b.jpg"
						alt="lecfly lecture">
					</a>
				</div>
				<div class="main_video_info">
					<p class="main_video_info_category">
						미술 <span class="fufundINg">펀딩중</span> <span class="funding_rate">19%
							달성</span>
					</p>

					<p class="main_video_info_title">"이연공방 도자기 만들기와 물레 체험. 흙을 도화지
						삼아 나만의 색을 담은 도자기"</p>
					<img src="resource/img/dummy_lec_img/art/art_2m.jpg"
						class="video_info_creator_img">
					<p class="main_video_info_creator_name">이연공방</p>

					<div class="main_video_like">
						<p>
							<span class="funding_date">15일 남음</span>
						</p>
					</div>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>

	<h2 class="fumain_title">진행중인 펀딩</h2>

	<div class="main_video_wrapper">

		<div class="main_video_block_row">
			<!-- 한 행에 전시할 강의 시작점마다 -->
			<%
				for (int i = 0; i < 4; i++) {
			%>
			<div class="main_video_block">
				<div class="main_video_thumb">
					<a href="#"><div class="main_video_thumb_btn">
							<i class="far fa-heart fa-2x"></i>
						</div> <img src="resource/img/dummy_lec_img/art/art_2m.jpg"
						alt="lecfly lecture"></a>
				</div>
				<div class="main_video_info">
					<p class="main_video_info_category">
						미술 <span class="fufundINg">펀딩중</span> <span class="funding_rate">19%
							달성</span>
					</p>

					<p class="main_video_info_title">"이연공방 도자기 만들기와 물레 체험. 흙을 도화지
						삼아 나만의 색을 담은 도자기"</p>
					<img src="resource/img/dummy_lec_img/art/art_2m.jpg"
						class="video_info_creator_img">
					<p class="main_video_info_creator_name">이연공방</p>

					<div class="main_video_like">
						<p>
							<span class="funding_date">15일 남음</span>
						</p>
					</div>
				</div>
			</div>
			<%
				}
			%>
		</div>
		<div class="main_video_block_row">
			<!-- 한 행에 전시할 강의 시작점마다 -->
			<%
				for (int i = 0; i < 4; i++) {
			%>
			<div class="main_video_block">
				<div class="main_video_thumb">
					<a href="#"><div class="main_video_thumb_btn">
							<i class="far fa-heart fa-2x"></i>
						</div> <img src="resource/img/dummy_lec_img/art/art_2m.jpg"
						alt="lecfly lecture"></a>
				</div>
				<div class="main_video_info">
					<p class="main_video_info_category">
						미술 <span class="fufundINg">펀딩중</span> <span class="funding_rate">19%
							달성</span>
					</p>

					<p class="main_video_info_title">"이연공방 도자기 만들기와 물레 체험. 흙을 도화지
						삼아 나만의 색을 담은 도자기"</p>
					<img src="resource/img/dummy_lec_img/art/art_2m.jpg"
						class="video_info_creator_img">
					<p class="main_video_info_creator_name">이연공방</p>

					<div class="main_video_like">
						<p>
							<span class="funding_date">15일 남음</span>
						</p>
					</div>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>


</div>