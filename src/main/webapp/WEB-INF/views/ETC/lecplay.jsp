<%@page import="LECFLY.dao.impl.VideoTimeCut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>

$(document).ready(function () {
	$(".alter").click(function () {
		var th = document.getElementById("test");
		var so = $(this).find("p:first").text();
		$("#Pvideo video source").attr("src",so);
		$("#Pvideo").load("ETC/videoTest.jsp",{name:so}, function () {
			var name = $("#Pvideo video source").attr("src");
			
			$("#Htext p b").text(name);
			$("#uplorderplayWrap span#usrtitle b").text(name);
		});
	});
	$(".alter img").mouseover(function () {
		var sc =  $(this).attr("src");
		$(this).attr("src","resource/img/imgage.gif")
		$(this).mouseout(function () {
			$(this).attr("src",sc);
		});
	});
});

</script>
<style>
.test{
display: none;
}
<%String[] Test ={"dummy_video.mp4","Wildlife.mp4","working out.mp4"};
					
					
					%>
</style>
<body>
	<div id="playWrap">
	
		<div id="Tcontent">

			<div id='Cleft'>
				<div id='Pheader'>
					<div id="Htext" class='vertical'>
						<p>
							<b>Love your Life 나를 위한 천연비누</b>
						</p>
					</div>
				</div>
				<div id="Pvideo">
					<video controls autoplay="autoplay" poster="resource/img/lfly"  >
						<source  src='resource/video/soap.mp4' type="video/mp4" />
					</video>
				</div>
				<div id="aboutContent">
					<div class="vertical">
						<a class='bt1 '><b>PREV</b></a> <a class='bt1 sp'><b>NEXT</b></a>
					</div>
					<hr>
					<div id="uplorder">
						<div id='uplorderplayWrap'>
							<img id='usr' src="resource/img/1562545727180-1.png"><span
								id="usrname" class="usrab">
								<h3>순키-Sukiyy</h3>
							</span> <span id="usrtitle" class="usrab"><b> Love your Life
									나를 위한 천연비누  </b>-2 베이직한 마르세유 비누 만들기</span> <span id="usrpick"
								class="usrab">조회수 202345명</span>
						</div>
					</div>
					<hr>
					<div class="vertical">
						<span style="font-size: 24px"><b>강의소개 | 학습률</b></span>
					</div>
					<hr>
					<div id='aboutText'>
						<div id="text1">
							<h3>1.비누제작전 알아가기</h3>
							<p>이번 강의에서는 비누를 만들기전 알아야할 것들을 알려드립니다.
							 준비물 KIT 사용 용도 설명 부터 9년차
								비누강의를 진행하고있는 아뜰리에의 꿀팁까지 많은 정보를 알려드리는 강의이니 비누를 제작하기전 꼭! 가장 먼저
								수강해주세요 ♥ 
								앞으로의 수업 진행에 대한 궁금증은 아뜰리에의 QnA게시판을 이용해주세요 최대한 빠른시간안에 답변
								달아드리겠습니다.
								 수강신청해 주셔서 감사합니다.:)</p>
						</div>
						<div id="text2">
							<h3>진행순서</h3>
							<p>1. 재료 설명 및 계량 
							2. 교반 및 첨가물 아로마오일 첨가
							 3. 비누액 몰드 붓기 및 보온
							  4. 비누컷팅 및 트리밍 후 스탬프 찍기</p>
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
					
					<%for(int i = 0 ; i < 10; i++){ %>
 
						<div class = 'alter <%= (i==0 ? "":"Limg")  %>'>
						<%if(i==0){ %>
						<img src="resource/img/cooking2.jpg" alt="img" class ='playimgs'>
						<%}else{ %>
							<img src="resource/img/photosample.jpg" alt="img" class ='playimgs'>
							<%} %>
							<p class = 'movieName'>resource/video/<%=(i<3?Test[i]:"") %></p>
							
							<div class="Timg">
								<h4><%=i+1%>강<%=(i<3?Test[i]:"none") %></h4>
							<% 	if(i<3){%>
								<p><%=VideoTimeCut.media_player_time(i<3?Test[i]:"")%>초</p>
							<%	}else{ %>
								<p><%="none" %></p>
								<%} %>
								<span>강의시작하기</span>
							</div>
						</div>
						
						<%} %>
					</div>
				</div>
			</div>
		</div>
		<hr>
	</div>

</body>

