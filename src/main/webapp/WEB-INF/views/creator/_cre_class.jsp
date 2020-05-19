<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:forEach begin="0" end="${empty lecList ? '0': lecList.size()-1  }"
	varStatus="vs">
	<div class='CRconbox'
		onmouseover="${empty lecList ?'creatNewclass()' :''}">
		<div class='CRP'>
			<c:set var="titleImg" value="${lecList[vs.current].titleImg}" />
			<c:if test="${empty titleImg or titleImg eq 'sample'  }">
				<c:set var="titleImg"
					value="resources/imges/logo/LecFly_SLOGO_W_C.png" />
			</c:if>
			<img src="${crPath}${titleImg}" class="CRimg" alt="이미지">
		</div>
		<div class="CRC">
			<p class='CRname'>
				<c:out value="${lecList[vs.current].title}"
					default="새로운클래스를 만들어보세요 "></c:out> 
			</p>
			<div class="CRstatus">
				<c:if test="${ !empty lecList }">
					<p class="stus1 rau">${lecList[vs.current].status}</p>
					<p class="stus2 rau">영상 ${lecList[vs.current].videoTrack}</p>
					<p class="stus3 rau">
						<fmt:formatDate value="${lecList[vs.current].createdAt}"
							pattern="yyyy-MM-dd" />
					</p>
				</c:if>
			</div>
			<c:if test="${ !empty lecList }">
				<div class='CRsend'
					onclick="selectLecture(${lecList[vs.current].id},${lecList[vs.current].category})">
					<p>수정하기</p>
				</div>
			</c:if>
		</div>

	</div>
</c:forEach>
<div id='offset' ></div>