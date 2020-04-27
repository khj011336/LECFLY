<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<script>
	
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
	</script>
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
           		<%@ include file="Lecfly_CS_2_0.jsp"%>
           </div>	
       </div>
