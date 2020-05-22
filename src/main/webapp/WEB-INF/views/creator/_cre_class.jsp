<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<script>
var arrNumber =["실패","요청중","승인","작성중"];
function tx(v){
	return arrNumber[v];
}
</script>	 
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
					<p class="stus1 rau">${grant[lecList[vs.current].status]}</p>
					<p class="stus2 rau">영상 ${lecList[vs.current].videoTrack}</p>
					<p class="stus3 rau">
						<fmt:formatDate value="${lecList[vs.current].createdAt}"
							pattern="yyyy-MM-dd" />
					</p>
				</c:if>
			</div>
			<c:if test="${ !empty lecList }">
			<c:set var = "status" value="${lecList[vs.current].status}"/>
			<c:choose >
			<c:when test="${status eq 2}">
			
			 	</c:when>
			 <c:when test="${status  != 4 }">
				<div class='CRsend'
					onclick="selectLecture(${lecList[vs.current].id},${lecList[vs.current].category})">
					<p>수정하기</p>
				</div>
				</c:when>
				<c:when test="${status eq 4 }">
				<c:choose>
				<c:when test="${isCreator == 3}">
				<div class='CRsend'
					onclick="LectureUpdate(${lecList[vs.current].id})">
					<p>작성하기</p>
				</div>
				</c:when>
				<c:when test="${isCreator == 4}">
				<div class='CRsend'
					onclick="creatorUpdate(${lecList[vs.current].id})">
					<p>작성하기</p>
				</div>
				</c:when>
				</c:choose>
				</c:when>
			</c:choose>
			</c:if>
			<c:if test="${ empty lecList }">
			<div class='CRsend'>
					<p>시작하기</p>
				</div>
			</c:if>
		</div>

	</div>
</c:forEach>
<div id='offset' ></div>