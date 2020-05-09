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
	<div class="notice">
                <div id="notice_p">
                	<h4>공지사항</h4>
                	<br>
                    <p><b> LECFLY의 새소식을 확인하세요! </b></p>
                </div>
                
                <div id="notice_table">
                    <table>
                        <tr>
                            <th>NO</th>
                            <th>제목</th>
                            <th>등록일</th>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>고객센터 전화상담 운영 임시중단 안내</td>
                            <td>2020.02.25</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>설 연휴 배송 일정 및 고객센터 휴무 안내</td>
                            <td>2020.01.20</td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>서비스 이용약관 개정 안내</td>
                            <td>2019.10.02</td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>NH농협카드, KB국민카드 전산시스템 작업 안내</td>
                            <td>2019.09.09</td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td>2019년 추석 연휴 배송 및 고객센터 휴무 일정 안내</td>
                            <td>2019.09.05</td>
                        </tr>
                        <tr>
                            <td>6</td>
                            <td>홈페이지 서버 점검 안내</td>
                            <td>2019.07.16</td>
                        </tr>
                        <tr>
                            <td>7</td>
                            <td>홈페이지 서버 점검 안내</td>
                            <td>2019.07.16</td>
                        </tr>
                        <tr>
                            <td>8</td>
                            <td>홈페이지 서버 점검 안내</td>
                            <td>2019.07.16</td>
                        </tr>
                        <tr>
                            <td>9</td>
                            <td>홈페이지 서버 점검 안내</td>
                            <td>2019.07.16</td>
                        </tr>
                        <tr>
                            <td>10</td>
                            <td>홈페이지 서버 점검 안내</td>
                            <td>2019.07.16</td>
                        </tr>
                     </table>
                    <div id="notice_numbering">&lt;&nbsp;<b>1</b> 2 3 4 5 6 7 8 9 10&nbsp;&gt;</div>
                </div>
            </div>
</div>
</div>
</body>
</html>