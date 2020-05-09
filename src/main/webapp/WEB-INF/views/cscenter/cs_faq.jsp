<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
 	response.setHeader("Cache-Control", "no-store");
%>
<meta charset="UTF-8">
<title>CSCENTER/QNA</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript">
	function selectQna(atId) { window.location.href		
			= '${pageContext.request.contextPath}'
			+ '/Qna_receive.LF?id='+ Id;
	}	
</script>
<link type="text/css" rel="stylesheet" href="resources/css/CScenter/CSCenter.css">
<link type="text/css" rel="stylesheet" href="resources/css/CScenter/receive_board.css">

</head>
<body>
<div class="CSsection">
	<div id="CSsec_title"><h2>고객섬김센터</h2></div>
    <div id="CSsec_subtitle">
       <ul>
           <li><h4><a href="cs_qna.LF" id= "CS1">QnA</a></h4></li>
           <li><h4><a href="cs_faq.LF" id= "CS2">자주묻는 질문</a></h4></li>
           <li><h4><a href="cs_notice.LF" id= "CS3">공지사항</a></h4></li>
       </ul>
    </div>
    <div id="CS_page">
	<div id="faq">
       	<div id="faq_p">
           	<h4>자주묻는 질문</h4>
          
           
           <div id="faq_nav">
           <ul>
           	   <li><a href="#" id="faq_0">전체</a></li>
               <li><a href="#" id="faq_1">이용안내</a></li>
               <li><a href="#" id="faq_2">강의수강</a></li>
               <li><a href="#" id="faq_3">준비물 키트</a></li>
               <li><a href="#" id="faq_4">결제/환불</a></li>
               <li><a href="#" id="faq_5">크리에이터</a></li>
               <li><a href="#" id="faq_6">기타</a></li>
           </ul>
           </div>
           </div>
           <div id="faq_main">
           		<div id="faq_table">
			    	<ul>
			    		<%for(int i =0 ; i<10 ; i++){ %>
			    		<li>
			    			<div id ="faq_acodian">
			      		<div id="faq_aco_type">&#91;전체&#93;</div>
			      		<div id="faq_aco_title">회원정보수정은 어디서 하나요?</div>
			             	<div id="faq_aco_txt">
			             		홈페이지에 로그인 후 [마이페이지]를 클릭해주세요<br>
			             		[정보관리]를 클릭해 회원정보와 비밀번호를 수정할 수 있습니다.<br>
			             		수정 불가능한 부분을 개명 등의 이유로 수정을 원하시는 경우 고객센터로 요청해주시면 처리해드리겠습니다.
			             	</div>
			          	</div>
			    		</li>
			    		<%} %>
			    	</ul>
			    	
			        <div id="faq_numbering">&lt;&nbsp;<b>1</b> 2 3 4 5 6 7 8 9 10&nbsp;&gt;</div>
			    </div>
           </div>	
       </div>
</div>
</div>
</body>
</html>