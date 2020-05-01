<!-- 댓글내역 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- <a class="mypage_registerCoupon" href="#popup1">쿠폰 등록</a> -->
<!-- <div id="popup1" class="overlay"> -->
<!-- 	<div class="popup"> -->
<!-- 		<h2 class="mypage_coupon_h2">쿠폰 등록하기</h2> -->
<!-- 		<a class="close" href="#">x</a> -->
<!-- 		<div class="mypage_coupon_content"> -->
<!-- 			<input type="text" name="mypage_coupon" id="mypage_coupon" -->
<!-- 				placeholder="쿠폰 코드를 입력해주세요." size="20"> <input type="button" -->
<!-- 				value="등록하기" name="register_coupon" /> -->
<!-- 		</div> -->
<!-- 		<p id="mypage_coupon_p">필독! 주의사항</p> -->
<!-- 		<ul id="mypage_coupon_ul"> -->
<!-- 			<li>이미 사용된 쿠폰은 등록할 수 없습니다.</li> -->
<!-- 			<li>하나의 계정당 종류별 한 개의 쿠폰만 등록할 수 있습니다.</li> -->
<!-- 			<li>쿠폰 등록이 완료되면 내 쿠폰으로 즉시 지급됩니다.</li> -->
<!-- 			<li>일부 쿠폰의 경우, 등록기한 이후에는 사용이 불가능합니다.</li> -->
<!-- 		</ul> -->
<!-- 	</div> -->
<!-- </div> -->
<div class="mypage_bottom_info">
	<h2 class="mypage_bottom_title">쿠폰</h2>
	<a class="mypage_registerCoupon" href="#popup1">쿠폰 등록</a>
<div id="popup1" class="overlay">
	<div class="popup">
		<h2 class="mypage_coupon_h2">쿠폰 등록하기</h2>
		<a class="close" href="#">x</a>
		<div class="mypage_coupon_content">
			<input type="text" name="mypage_coupon" id="mypage_coupon"
				placeholder="쿠폰 코드를 입력해주세요." size="20"> <input type="button"
				value="등록하기" name="register_coupon" />
		</div>
		<p id="mypage_coupon_p">필독! 주의사항</p>
		<ul id="mypage_coupon_ul">
			<li>이미 사용된 쿠폰은 등록할 수 없습니다.</li>
			<li>하나의 계정당 종류별 한 개의 쿠폰만 등록할 수 있습니다.</li>
			<li>쿠폰 등록이 완료되면 내 쿠폰으로 즉시 지급됩니다.</li>
			<li>일부 쿠폰의 경우, 등록기한 이후에는 사용이 불가능합니다.</li>
		</ul>
	</div>
</div>
	<div class="mypage_bottom_contents">
		<div class="mypage_table">
			<table border="0">
				<tr>
					<th style='width: 100px'>번호</th>
					<th style='width: 100px'>쿠폰명</th>
					<th>할인금액(률)</th>
					<th>적용대상</th>
					<th>사용여부</th>
					<th style='width: 200px'>유효기간</th>
				</tr>
				<tr>
					<td>1</td>
					<td>신규회원쿠폰</td>
					<td>5000원</td>
					<td>신규회원</td>
					<td>X</td>
					<td>2020.05.01 11:59</td>
				</tr>
				<tr>
					<td>2</td>
					<td>클래스 구입 쿠폰</td>
					<td>10000원</td>
					<td>전체회원</td>
					<td>X</td>
					<td>2020.05.01 11:59</td>
				</tr>
				<tr>
					<td>3</td>
					<td>행사 쿠폰</td>
					<td>10%</td>
					<td>전체회원</td>
					<td>X</td>
					<td>2020.05.01 11:59</td>
				</tr>
				<tr>
					<td>4</td>
					<td>완강 쿠폰</td>
					<td>30000원</td>
					<td>전체회원</td>
					<td>X</td>
					<td>2020.05.01 11:59</td>
				</tr>
				<tr>
					<td>5</td>
					<td>생일 쿠폰</td>
					<td>10000원</td>
					<td>전체회원</td>
					<td>X</td>
					<td>2020.05.01 11:59</td>
				</tr>
				<tr>
					<td>6</td>
					<td>재등록 쿠폰</td>
					<td>10000원</td>
					<td>전체회원</td>
					<td>X</td>
					<td>2020.05.01 11:59</td>
				</tr>
				<tr>
					<td>7</td>
					<td>3카테고리 쿠폰</td>
					<td>30000원</td>
					<td>전체회원</td>
					<td>X</td>
					<td>2020.05.01 11:59</td>
				</tr>
				<tr>
					<td>8</td>
					<td>All카테고리 쿠폰</td>
					<td>50000원</td>
					<td>전체회원</td>
					<td>X</td>
					<td>2020.05.01 11:59</td>
				</tr>
				<tr>
					<td>9</td>
					<td>EarlyBird쿠폰</td>
					<td>10000원</td>
					<td>전체회원</td>
					<td>X</td>
					<td>2020.05.01 11:59</td>
				</tr>
				<tr>
					<td>10</td>
					<td>배송비 무료 쿠폰</td>
					<td>배송비 무료</td>
					<td>전체회원</td>
					<td>X</td>
					<td>2020.05.01 11:59</td>
				</tr>
			</table>
		</div>
		<div id="mypage_table_numbering">
			&lt;&nbsp;<b>1</b> 2 3 4 5 6 7 8 9 10&nbsp;&gt;
		</div>
	</div>
</div>