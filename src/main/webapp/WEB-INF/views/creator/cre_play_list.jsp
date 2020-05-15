<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
<script src="resources/js/creator/select.js"></script>
<script>
var max = ${maxPage};
var CFID = ${CFId};
var category =${category};
var pagea = 1 ;
function nationforVideo(pagea , max){
	var nate = "";
	 if(pagea >1 ){
		 nate +=	"<span onclick='pagenate(pagea-1)'>[이전]</span>"; 
	 }
	 for(var i = 1 ; i< max+1; i++){
		 if(i == pagea ){
			 nate +=	"<span style='color: orange'>"+i+"</span>";
		 }else{
			 nate += "<span onclick='pagenate("+i+")'>"+i+"</span>";
		 }
	 }
	 if(pagea < max){
		 nate += "<span onclick='pagenate(pagea+1)'>[다음]</span>";
	 }
	 return nate;
	 }
	 
	function videoUpload(id){
		location.href ="video_upload.LF?CFID="+id;
	}
	
function updateVideo(pk){
	if($("option").val()== 1){
// 		location.href ="video_upload.LF?CFID="+pk;
	}else{
		alert("키트");
	}
}
function pagenate(page){
	$.ajax({
	    type : 'get',  
	    dataType : 'json', 
	    data : {"page" : page ,"CFID" : CFID },
	    url : 'creator_video_show_proc.LF',
	    success : function(returnData) {
	    	pagea = returnData.page;
	    	$("#appendList").find(".videoTR").remove();
	    	 $.each(returnData.jsonText,function(index,item){
	    		$("#appendList").append("<tr class = 'bottomlineaa videoTR'> <td class='checkbox'><input type='checkbox' class='check-one check' /></td>"+
				"<td colspan='2' class='goods'><img src='"+item.imgPath+"' alt='홈트레이닝' />"+
				"<div id='countor'> <span style='width: 500px'>"+item.title +"</span> <span><a href='##' class='sellerTitle'>"+item.createdAt+"</a></span>"+
				" <span> <select name='test1'> <option value='1'>동영상 수정</option> <option value='2'>판매킷 수정</option> </select> </span> </div></td>"+
				"<td class='count'></td> <td class='count'></td> <td class='subtotal'>"+
				"<p><i class='fas fa-comment-dots'></i><span>"+item.status+"</span></p>"+
				"<p><i class='fas fa-heart'></i><span></span>"+item.likeCount+"</p>"+
				"<p><i class='fas fa-eye'></i><span>"+item.views+"</span></p>"+
				"</td> <td> </td> <td class='opration'><span onclick='updateVideo("+item.id+")' class='deleteOne'>수정</span></td> </tr>"
				);
	    	});	
	    	 $("#paginate").html(nationforVideo(pagea , max));
	    },
	    error:function(e){
	       if(e.status==300){
	           alert("데이터를 가져오는데 실패하였습니다.");
	  	   }
	    }
	}); 
}
</script>
<title>주제</title>
</head>
<body>
	<div id="shoppingCart_wrapper">
		<div id="shoppingCart_content">
			<div class="shoppingCart_title_box">
				<h1 class="shoppingCart_title">동영상 목록</h1>
				<h3 class="shoppingCart_subtitle"></h3>
			</div>
			<div class="cartMain">
				<table id="cartTable">
					<thead>
						<tr>
							<th><label for="fl select-all"> <input
									type="checkbox" class="check-all check"> <span><a
										href="javascript:void(0)" class="selallSPAN">&nbsp;전체</a></span></label></th>
							<th colspan="2"></th>
							<th id="forfixs"></th>
							<th class="crinf">클래스 정보수정</th>
							<th class="listup" onclick="videoUpload(CFID,category)">+영상업로드</th>
							<th id="listdel">삭제</th>
							<th style="width: 150px;">정렬&nbsp;<select>
									<option>오름차순</option>
									<option>내림차순</option>
									<option>날자순</option>
									<option>조회순</option>
							</select></th>
						</tr>
					</thead>

					<tbody id="appendList">
						<c:forEach varStatus="vs" begin="0" end="${lecList.size()-1}"
							step="1">
							<tr class='bottomlineaa videoTR'>
								<td class="checkbox"><input type="checkbox"
									class="check-one check" /></td>
								<td colspan="2" class="goods"><img
									src="${lecList[vs.index].imgPath}" alt="홈트레이닝" />
									<div id="countor">
										<span style="width: 500px"><c:out
												value="${lecList[vs.current].title}" default="동영상을 만들어주세요"></c:out></span>
										<span><a href="##" class="sellerTitle"><fmt:formatDate
													value="${lecList[vs.current].createdAt}"
													pattern="yyyy-MM-dd" /></a> </span> <span> <select
											name="test1">
												<option value="1">동영상 수정</option>
												<option value="2">판매킷 수정</option>
										</select>
										</span>
									</div></td>
								<td class="count"></td>
								<td class="count"></td>
								<td class="subtotal">
									<p> <i class="fas fa-comment-dots"></i><span>${lecList[vs.current].status}</span> </p>
									<p> <i class="fas fa-heart"></i><span>${lecList[vs.current].likeCount}</span> </p>
									<p> <i class="fas fa-eye"></i><span>${lecList[vs.current].views}</span> </p>
								</td>
								<td></td>
								<td class="opration"><span
									onclick='updateVideo(${lecList[vs.current].id})'
									class="deleteOne">수정</span></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			 
				<div id="paginate">
					<c:if test="${videoPage > 1}">
						<span onclick="pagenate(${videoPage-1})">[이전]</span>
					</c:if>
					<c:forEach varStatus="vs" begin="1" end="${maxPage}" step="1">
						<c:if test='${vs.current eq videoPage}'>
							<span style='color: orange'>${vs.current}</span>
						</c:if>
						<c:if test='${vs.current ne videoPage}'>
							<span onclick="pagenate(${vs.current})">${vs.current}</span>
						</c:if>
		</c:forEach>
					<c:if test="${videoPage < maxPage}">
						<span onclick="pagenate(${videoPage+1})">[다음]</span>
					</c:if>
				</div>
			</div>
			<div class="cartFootercre" id="cartFooter"></div>
		</div>
	</div>

</body>
</html>