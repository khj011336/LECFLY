<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%-- <script>
	
	var ROOTCP = '<%= application.getContextPath()%>';
	
	$(document).ready(function() {
		$("#faq_0").click(function() {
			var url = ROOTCP+'/CSCenter/Lecfly_CS_2_0.jsp';
			$("#faq_main").load(url, function(){
				console.log("faq_0 전체 로딩");
			});			
		}); // 전체
		
		$("#faq_1").click(function() {
			var url = ROOTCP+'/CSCenter/Lecfly_CS_2_1.jsp';
			$("#faq_main").load(url, function(){
				console.log("faq_1 이용안내 로딩");
			});			
		}); // 이용안내
		
		$("#faq_2").click(function() {
			var url = ROOTCP+'/CSCenter/Lecfly_CS_2_2.jsp';
			$("#faq_main").load(url, function(){
				console.log("faq_2 강의수강 로딩");
			});			
		}); // 강의수강
		
		$("#faq_3").click(function() {
			var url = ROOTCP+'/CSCenter/Lecfly_CS_2_3.jsp';
			$("#faq_main").load(url, function(){
				console.log("faq_3 준비물 키트 로딩");
			});			
		}); // 준비물 키트
		
		$("#faq_4").click(function() {
			var url = ROOTCP+'/CSCenter/Lecfly_CS_2_4.jsp';
			$("#faq_main").load(url, function(){
				console.log("faq_4 결제/환불 로딩");
			});			
		}); // 결제/환불
		
		$("#faq_5").click(function() {
			var url = ROOTCP+'/CSCenter/Lecfly_CS_2_5.jsp';
			$("#faq_main").load(url, function(){
				console.log("faq_5 크리에이터 로딩");
			});			
		}); // 크리에이터
		
		$("#faq_6").click(function() {
			var url = ROOTCP+'/CSCenter/Lecfly_CS_2_6.jsp';
			$("#faq_main").load(url, function(){
				console.log("faq_6 기타 로딩");
			});			
		}); // 기타
		
	});	
	</script> --%>
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
