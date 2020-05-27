<%-- <%@page import="LECFLY.dao.impl.VideoTimeCut"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	$(document).ready(function() {
		
	});
	function videoLoad(videoPath, info, views, title) {
		$("#Htext p b").text(title);
		$("#videSource").attr("src",videoPath );
		$("#vide")[0].load();
		$("#vide")[0].play();
		$("#text1 p").text(info);
		$("#usrpick").text("조회수"+views+"명");
	}
	function mouseEven(path, gif, png) {
		$(".alter img").mouseover(function() {
			$(this).attr("src", path + gif)
			$(this).mouseout(function() {
				$(this).attr("src", path + png);
			});
		});
	}
</script>
<style>
.test {
	display: none;
}
</style>
<body>
	<div id="playWrap">

		<div id="Tcontent">

			<div id='Cleft'>
				<div id='Pheader'>
					<div id="Htext" class='vertical'>
						<p>
							<b>${videoList[0].title}</b>
						</p>
					</div>
				</div>
				<div id="Pvideo">
					<video controls autoplay="autoplay" id = "vide"
						poster="${crPath}${fn:split(videoList[index.current].imgPath,'-')[0]}">
						<source  src='${viPath}${videoList[0].videoPath}' type="video/mp4" id = "videSource" />
					</video>
					
				</div>
				<div id="aboutContent">
					<div class="vertical">
						<a class='bt1 '><b>PREV</b></a> <a class='bt1 sp'><b>NEXT</b></a>
					</div>
					<hr>
					<div id="uplorder">
						<div id='uplorderplayWrap'>
							<img id='usr' src="${crPath}${lecList.imgPath}"><span
								id="usrname" class="usrab">
								<h3>${lecList.nickname}</h3>
							</span> <span id="usrtitle" class="usrab"><b>${lecList.title}</b>-${lecList.subTitle}</span>
							<span id="usrpick" class="usrab">조회수
								${videoList[0].views}명</span>
						</div>
					</div>
					<hr>
					<div class="vertical">
						<span style="font-size: 24px"><b>강의소개 | 학습률</b></span>
					</div>
					<hr>
					<div id='aboutText'>
						<div id="text1">
							<h3>강의소개</h3>
							<p>${videoList[0].info}</p>
						</div>
						<div id="text2">
							<h3>진행순서</h3>
							<p>${videoList[0].orderInfo}</p>
						</div>
					</div>
				</div>
			</div>
			<div id="Cright">
				<div id='CrText' class='vertical'>
					<h2>커리큘럼</h2>
				</div>
				<div id="PvideoList">
					<div class="PvideoContent">
						<c:forEach begin="0" end="${videoList.size()-1}" varStatus="index">
							<div
								class='alter <c:out value="${index.index == 0? '' : 'Limg'}" /> '
								onclick="videoLoad('${viPath}${videoList[index.current].videoPath}','${videoList[index.current].info}','${videoList[index.current].duration}','${videoList[index.current].title}')">
								<img
									src="${crPath}${fn:split(videoList[index.current].imgPath,'-')[0]}"
									alt="img" class='playimgs'
									onload="mouseEven('${crPath}','${videoList[index.current].gifPath}','${fn:split(videoList[index.current].imgPath,'-')[0]}')">
								<p class='movieName'>${videoList[index.current].title}</p>
								<div class="Timg">
									<h4>${index.index+1}강${videoList[index.current].title}</h4>
									<p>${videoList[index.current].duration}</p>
									<span>강의시작하기</span>
								</div>
							</div>
						</c:forEach>

					</div>
				</div>
			</div>
		</div>
		<hr>
	</div>

</body>

