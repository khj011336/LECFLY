<%@page import="mvc.UploadServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
    <link href="creator.css" type="text/css" rel="stylesheet">
<script>
$("#uplUP").change(function () {
$.ajax({
	type :"POST",
	url : "Creator/creatorcenter.up",
	data: "uplUP",
	success: function () {
		alert("성공");
	},
	}); 
});


</script>

<div id='uplwrap'>

    <div class="uplPa" id="uplz">동영상 업로드 -</div>
    <div class="uplPa" id= 'uply'>동영상 정보</div>
    <form action="Creator/creatorcenter.up" method="post" enctype="multipart/form-data">
        <div id="uplT" class="uplflex" >
            <div id="uplL" class="uplPa">
                <div id="uplmar" class='uplshadow'><input type="text" size="85" placeholder="영상제목을 입력해주세요"></div>
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
                <div id="urlvt"><input type="file" id="uplUP" name = "file1"></div>
            </div>
            </div>
        </div>
        <div id="uplb" class="uplflex">
            <div class="uplPa">
            <h3>미리보기 이미지</h3>
             <div id="uplimgbox" class="uplflex">
                
                 <div class="uplimgb uplshadow"><img alt="img" src="resource/img/dummy_img1.jpg"></div>
                 <div class="uplimgb uplshadow padp"><img alt="img" src="resource/img/dummy_img2.jpg"></div>
                 <div class="uplimgb uplshadow padp"><img alt="img" src='resource/img/dummy_img3.jpg'></div>
                 <div id="uplfile"><input type="file"></div>
                 
             </div>
             </div>
             <div id='uplmr' class="uplPa">
             <h3>저장 카테고리 및 댓글허용</h3>
            <div id="uplRcate" class="uplflex">
                <div>
                    <p>저장 카테고리</p>
                    <select>
                        <option>test1</option>
                        <option>test2</option>
                        <option>test3</option>
                    </select>
                </div>
                <div>
                   <p>게시 동영상댓글</p>
                    <select>
                        <option>허용</option>
                        <option>차단</option>
                    </select>
                </div>
            </div>
          </div>
        </div>
        <div id='uplend' class="uplPa">
            <div id="upltextarea" >
                <h3>진행순서 기입</h3>
                <textarea class="uplnotes uplshadow " >
                    
                </textarea>
            </div>
        </div>
        <div><input type="submit" value="다음" class="upl_bt"></div>
<!--         <div id="upllas"><input type="submit" value="올리기"></div> -->
    </form>
</div>
