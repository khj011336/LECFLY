<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.admin_table_wrap {
	margin: 0 auto;
	text-align:center;
	padding: 30px;
}
.admin_table_wrap > table {
	border-top: 2px solid black; 
	border-bottom: 2px solid black; 
	width:100%;
}
.admin_table_wrap td {
	border: .1px solid lightgray; 
}
.admin_table_head > th {
	background-color: #e8e8e8;
}
.admin_table_filter > table {
	margin: 30px;
	width:800px;
	border: .1px solid #e8e8e8; 
}
.admin_table_filter th {
	background-color: #e8e8e8;
}
.admin_table_filter caption {
	caption-side: top;
	
}
.admin_table_filter .date_filter{
    border: 1px solid #98989b;
	padding: 0px;
}
</style>    
<h4>이용권 결제내역</h4>

<div class="admin_table_filter">
	<table>
		<caption>검색조건설정</caption>
		<tr>
			<th>기간검색</th>
			<td>
				<span class="date_filter"><a href="#">오늘</a></span>
				<span class="date_filter"><a href="#">3일</a></span>
				<span class="date_filter"><a href="#">7일</a></span>
				<span class="date_filter"><a href="#">1개월</a></span>
				<input type="date"/> ~ <input type="date"/>
			</td>
		</tr><td></td>
		<tr>
			<th>판매상태</th>
			<td>
				<lable><input name="goods_con" type="radio" value="">판매</lable>
				<lable><input name="goods_con" type="radio" value="">품절</lable>
				<lable><input name="goods_con" type="radio" value="">승인대기</lable>
			</td><td></td>
		</tr>
		<tr>
			<th>조건선택</th>
			<td>
				<select name="">
   					<option value="">상품명</option>
  					<option value="">판매자</option>
    				<option value="">상품코드</option>
    				<option value="">강의명</option>
				</select>
			<input type="text" size="40"></td>
		<td><input type="submit" value="조회"/></td>
		</tr>

	</table>
</div>
    

<div class="admin_table_wrap">
	<table>
		<tr class="admin_table_head">
			<th><input type="checkbox"/></th> <th>번호</th> <th>상품</th> <th>구매자</th> <th>결제방법</th> <th>결제일</th> <th>만료일</th> <th>기타</th><th>기타</th> <th>기타</th><th>기타</th>
		</tr>
		<% for(int i=1; i<=20;i++) {%>
		<tr>
			<td><input type="checkbox"/></td> <td><%=i %></td> <td></td> <td></td> <td></td> <td>2020.01.03</td> <td>2020.02.04</td><td></td> <td></td> <td></td> <td></td> 
		</tr>
		<% } %>
	</table>
</div>