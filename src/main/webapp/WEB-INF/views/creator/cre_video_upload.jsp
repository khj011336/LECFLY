<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script>
//function upload(ul, form){
//	console.log('aa');
//		 $.ajax({
//			 url: ul ,
//			 type:'POST',
//			 enctype:"multipart/form-data",
//			 data: form ,
//			 processData: false,
//			 contentType: false,
//			 success: function(data, jqXHR,textStatus){
			   
//			 },
//			 error: function(jqXHR, textStatus , errorThrown){
			 
//			 }
//		  });
//	}
$().ready(function(){
$("#uplUP").change(function () {
// 	var fomr = $("#viform")[0];
	var formdata =  new FormData();
	var file = this.files[0];
	formdata.append("viFile",file);
$.ajax({
	type :"post",
	enctype:"multipart/form-data",
	url : "video_proc.LF",
	processData: false,
    contentType: false,
	data: formdata,
	success: function () {
		alert("성공");
	},
	error: function () {
		
	}
	}); 
});
});


</script>


<div id='uplwrap'>

    <div class="uplPa" id="uplz">동영상 업로드 -</div>
    <div class="uplPa" id= 'uply'>동영상 정보</div>
    <form action="Creator/creatorcenter.up" method="post" enctype="multipart/form-data" id = "viform">
    <input type="hidden" value="${video.CFId}" name= "CFId">
        <div id="uplT" class="uplflex" >
            <div id="uplL" class="uplPa">
                <div id="uplmar" class='uplshadow'><input type="text" value="${video.title }" 
                 size="85" placeholder="영상제목을 입력해주세요"></div>
                <div class='uplshadow'><textarea class="uplnotes"  cols="83" rows="6">
영상 내용을 입력해주세요.
                </textarea></div>
            </div>
            <div id="uplR" >
               <div class='uplshadow'>
                <video  controls>
                <source src="resource/video/soap.mp4" type ='video/mp4'/>
                </video>
                <div><input type="url" placeholder="http://creator/resource/video/wildlife.mp4"></div>
                <div id="urlvt"><input type="file"  accept="video/*" id="uplUP" name = "viFile"></div>
            </div>
            </div>
        </div>
        <div id="uplb" class="uplflex">
            <div class="uplPa">
            <h3>미리보기 이미지</h3>
             <div id="uplimgbox" class="uplflex">
                 <div class="uplimgb uplshadow"><img alt="" src="${video.imgPath }"></div>
                 <div class="uplimgb uplshadow padp"><img alt="" src="${video.imgPath }"></div>
                 <div class="uplimgb uplshadow padp"><img alt="" src='${video.gifPath }'></div>
                 <div id="uplfile"><input type="file" accept="image/*" id ="imgProc"></div>
                 
             </div>
             </div>
             <div id='uplmr' class="uplPa">
             <h3>저장 카테고리 및 댓글허용</h3>
            <div id="uplRcate" class="uplflex">
                <div>
                    <p>저장 카테고리</p>
                    <select name ="category">
                        <option value="${category}">${category}</option>
                    </select>
                </div>
                <div>
                   <p>게시 동영상댓글</p>
                    <select name="commentYorN">
                        <option value ="1">허용</option>
                        <option value = "2">차단</option>
                    </select>
                </div>
            </div>
          </div>
        </div>
        <div id='uplend' class="uplPa">
            <div id="upltextarea" >
                <h3>진행순서 기입</h3>
                <textarea class="uplnotes uplshadow " name="info">
                    
                </textarea>
            </div>
        </div>
        <div><input type="submit" value="업로드" class="upl_bt"></div>
<!--         <div id="upllas"><input type="submit" value="올리기"></div> -->
    </form>
</div>
