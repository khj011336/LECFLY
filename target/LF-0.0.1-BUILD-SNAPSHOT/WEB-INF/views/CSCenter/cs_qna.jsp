<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<div class="QnA">
    	<div id="qna_p">
        	<h3>QnA</h3>
        </div>
	    <div id="qna_noticebox">
	        <p>	
	        	온라인 취미 클래스 플랫폼 LecFly입니다. 
	        	<br>LecFly를 이용해주셔서 감사합니다.
         		<br>서비스 이용시 불편사항이나 문의사항 빠르고 친절하게 안내해 드리겠습니다.
         		<br>
         		<br>QnA게시판은 회원만 작성 가능합니다.
         		<br>비회원께서는 회원가입을 해주시거나 우측 하단 실시간문의를 이용해주시면 감사하겠습니다.
         		<br>*실시간문의는 운영시간내에만 이용가능합니다.
         		<br><br>감사합니다:)
         		<button class="edit_qna">QnA 작성하기</button>
			</p>
	    </div>
	    <div id="qna_table">
		     
		     <h2> 문의 내역 </h2>
		     
		     <table>
		     	<tr>
		        	<th>NO</th>
                    <th>제목</th>
                    <th>구분</th>
                    <th>작성자</th>
                    <th>등록일</th>
                    <th>답변상태</th>
                 </tr>
                 <%for(int i =0 ; i<10 ; i++){ %>
                 <tr>
                     <td><%= i+1 %></td>
                     <td>제목없음</td>
                     <td>이용권</td>
                     <td>홍길동</td>
                     <td>2020.03.05</td>
                     <td>미답변</td>
                 </tr>
                 <% } %>
                 
               </table>
               <div id="qna_numbering">&lt;&nbsp;<b>1</b> 2 3 4 5 6 7 8 9 10&nbsp;&gt;</div>
		                    
            </div>     
       </div>