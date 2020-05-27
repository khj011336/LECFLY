

 var videoUP = '${videoUP}';
 function videoChange(){
		var video = $("#viosrc").attr("src");
		if(video != undefined && video != null && video.indexOf('mp4') != -1 ){
			return true;
		} else{
			return false;
		}
	}
 function ispty(){
	    var each =	$('#viform').find("input[type!=hidden],textarea,select").not("input[type=url]").not("input[type=button]").not("input[type=file]");
	    var a = 0;
	    for(var i =0 ; i<each.length;i++ ){
	    	if(each[i].value == undefined || each[i].value == null || each[i].value ==""){
	    		a++;
	    	}
	    } 
	    	if(a>0){
	    		alert("값을 다입력해주세요");
	    		return true;
	    	}else{
	    		return false;
	    	}
	  }
 var upbutton = 0;
$().ready(function() {

$(".upl_bt").on("click",function(){
	if(videoUP != '1'){
		if(!ispty()){
			if(!videoChange()){
					alert("동영상을 등록해주세요");
				}else{
					upbutton = 1;
						var form = $("#viform");
						$("#uplUP").attr("disabled","disabled");
						$("#imgProc").attr("disabled","disabled");
						form.submit();
				}
		}
	}else{
		location.href= "video_update_proc.LF";	
	}
});

	$("#imgProc").change(function () {
		if(!videoChange()){
			alert("비디오를 먼저 추가해주세요");
		}else{
			var formdataimg = new FormData();
			var fileimg = this.files[0];
			formdataimg.append("addimgFile", fileimg);
			$.ajax({
				type : "post",
				enctype : "multipart/form-data",
				url : "video_img_proc.LF",
				processData : false,
				contentType : false,
				data : formdataimg,
				success : function(result) {
					console.log(result.png);
					var img = result.png.split('-');
					var cr = result.crPath;
					$("#img1").attr("src",cr+img[0]);
					 
				},
				error : function() {

				}
			});
		} 
	});
		$("#uplUP").change(function() {
			$("#vioSample").attr("poster","resources/imges/creator/loading.gif");
			var formdata = new FormData();
			var file = this.files[0];
			formdata.append("viFile", file);
			 
			$.ajax({
				type : "post",
				enctype : "multipart/form-data",
				url : "video_proc.LF",
				processData : false,
				contentType : false,
				data : formdata,
				dataType:"json",
				success : function(result) {
					var cr = result.cr ,
					  vi = result.vi,
					  png = result.png ,
					 gif =result.gif ,
					 video =result.video ;
					var ims = png.split('-');
					console.log(result.video);
					$("#img1").attr("src",cr+ims[0] );
					$("#img2").attr("src",cr+ims[1] );
					$("#gif").attr("src",cr+gif );
					$("#viosrc").attr("src",vi+video );
					$("#vioSample")[0].load();
					$("#vioSample").attr("poster","");
					 
				},
				error : function() {

				}
			});
		});
	});