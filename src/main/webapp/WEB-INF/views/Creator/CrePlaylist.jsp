<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주제</title>
<link type="text/css" rel="stylesheet" href="creatorlist.css">
<link type="text/css" rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link href="../resource/css/CrePlaylist.css" rel="stylesheet"
	type="text/css">
</head>

<body>
	<div id="shoppingCart_wrapper">
		<div id="shoppingCart_content">
			<div class="shoppingCart_title_box">
				<h1 class="shoppingCart_title">동영상 목록</h1>
				<h3 class="shoppingCart_subtitle"></h3>
			</div>
			<div class="cartMain">
				<table id="cartTable">
					<thead>
						<tr >
							<th><label for="fl select-all"> <input
									type="checkbox" class="check-all check"> <span><a
										href="javascript:void(0)" class="selallSPAN">&nbsp;전체</a></span></label></th>
							<th colspan="2"></th>
							<th id="forfixs"></th>
							<th class="crinf">클래스 정보수정</th>
							<th class="listup">+영상업로드</th>
							<th id="listdel">삭제</th>
							<th style="width: 150px;">정렬&nbsp;<select>
									<option>오름차순</option>
									<option>내림차순</option>
									<option>날자순</option>
									<option>조회순</option>
							</select></th>
						</tr>
					</thead>
					<tbody>
						<tr class = 'bottomlineaa'>
							<td class="checkbox"><input type="checkbox"
								class="check-one check" /></td>
							<td colspan="2" class="goods"><img
								src="../resource/img/l3.PNG" alt="홈트레이닝" />

								<div id="countor">
									<span style="width: 500px">dddddddddddd홈트의 재정의&gt; 다이어트
										패키지ddddddddddd</span> <span><a href="##" class="sellerTitle">2020.09.09.10:33</a>
									</span> <span> <select name="test1">
											<option value="1">동영상 수정</option>
											<option value="2">판매킷 수정</option>
									</select>
									</span>
								</div></td>
							<td class="count"></td>
							<td class="count"></td>
							<td class="subtotal">
								<p>
									<i class="fas fa-comment-dots"></i><span>2342342</span>
								</p>
								<p>
									<i class="fas fa-heart"></i><span></span>234234234
								</p>
								<p>
									<i class="fas fa-eye"></i><span>23423442</span>
								</p>
							</td>
							<td></td>
							<td class="opration"><span class="deleteOne">수정</span></td>
						</tr>
							<tr class = 'bottomlineaa'>
							<td class="checkbox"><input type="checkbox"
								class="check-one check" /></td>
							<td colspan="2" class="goods"><img
								src="../resource/img/l3.PNG" alt="홈트레이닝" />

								<div id="countor">
									<span style="width: 500px">dddddddddddd홈트의 재정의&gt; 다이어트
										패키지ddddddddddd</span> <span><a href="##" class="sellerTitle">2020.09.09.10:33</a>
									</span> <span> <select name="test1">
											<option value="1">동영상 수정</option>
											<option value="2">판매킷 수정</option>
									</select>
									</span>
								</div></td>
							<td class="count"></td>
							<td class="count"></td>
							<td class="subtotal">
								<p>
									<i class="fas fa-comment-dots"></i><span>2342342</span>
								</p>
								<p>
									<i class="fas fa-heart"></i><span></span>234234234
								</p>
								<p>
									<i class="fas fa-eye"></i><span>23423442</span>
								</p>
							</td>
							<td></td>
							<td class="opration"><span class="deleteOne">수정</span></td>
						</tr>
<!-- 						<tr> -->
					</tbody>
				</table>
			</div>
			<div class="cartFooter" id="cartFooter"></div>
		</div>
	</div>
	<script>
		// javaScript의 html 내의 요소들을 움직일 수 있는 dom 객체를 조작하는 방법.
		window.onload = function() {
			//호환document.getElementsByClassName 방법；

			// getElementsById() id 속성을 사용하여 접근.
			// getElementsByClassName() class 속성을 사용하여 접근, 컬렉션 객체를 반환

			// cls => class, ret => return, els =
			if (!document.getElementsByClassName) {
				document.getElementsByClassName = function(cls) {
					var ret = [];
					var els = document.getElementsByTagName('*');
					for (var i = 0; i < els.length; i++) {
						if (els[i].className === cls
								|| els[i].className.indexOf(cls + ' ') >= 0
								|| els[i].className.indexOf(' ' + cls) >= 0
								|| els[i].className.indexOf(' ' + cls + ' ') >= 0) {
							ret.push(els[i]);
						}
					}
					;
					return ret;
				}
			}

			var cartTable = document.getElementById('cartTable');
			var tr = cartTable.children[1].rows; //children 자식노드;
			var checkInputs = document.getElementsByClassName('check');
			var checkAllInput = document.getElementsByClassName('check-all');
			var selectedTotal = document.getElementById('selectedTotal');
			var priceTotal = document.getElementById('priceTotal');
			var selected = document.getElementById('selected');
			var cartFooter = document.getElementById('cartFooter');
			var selectedViewList = document.getElementById('selectedViewList');
			var multiDelete = document.getElementById('multiDelete');
			var allDelete = document.getElementById('allDelete');
			var selallSPAN = document.getElementsByClassName('selallSPAN');

			//박스 이벤트 선택；
			for (var i = 0; i < checkInputs.length; i++) {
				checkInputs[i].onclick = function() {
					if (this.className === 'check-all check') { //全选；
						for (var j = 0; j < checkInputs.length; j++) {
							checkInputs[j].checked = this.checked;
						}
					}
					;
					if (this.checked == false) {
						for (var k = 0; k < checkAllInput.length; k++) {
							checkAllInput[k].checked = false;
						}
					}
					getTotal();
				}
			}
			;
			selallSPAN[0].onclick = selallSPAN[1].onclick = function() {
				for (var k = 0; k < checkAllInput.length; k++) {
					if (checkAllInput[k].checked) {
						checkAllInput[k].checked = false;

					} else {
						checkAllInput[k].checked = true;
					}
				}
				for (var j = 0; j < checkInputs.length; j++) {
					checkInputs[j].checked = checkAllInput[0].checked;
				}
				getTotal();
			}

			//계산；
			function getTotal() {
				var selected = 0;
				var price = 0;
				var HTMLstr = '';
				for (var i = 0; i < tr.length; i++) {
					var perCount = tr[i].getElementsByTagName('input')[1].value;
					if (tr[i].getElementsByTagName('input')[0].checked) {
						tr[i].className = "on";
						selected += parseInt(tr[i]
								.getElementsByTagName('input')[1].value);
						price += parseFloat(tr[i].cells[4].innerHTML);
						HTMLstr += '<div><img src="'
								+ tr[i].getElementsByTagName('img')[0].src
								+ '"/><span class="selCount">'
								+ perCount
								+ '</span><span class="del" index="' + i + '">선택해제</span></div>'
					} else {
						tr[i].className = " ";
					}
				}
				;
				selectedTotal.innerHTML = selected;
				priceTotal.innerHTML = price.toFixed(3);
				selectedViewList.innerHTML = HTMLstr;
				//0을 선택한 경우；
				if (selected == 0) {
					cartFooter.className = "cartFooter";
				}
			}

			//선택한 상자 표시 및 숨기기；
			selected.onclick = function() {
				if (cartFooter.className == 'cartFooter') {
					if (selectedTotal.innerHTML != 0) {
						cartFooter.className = 'cartFooter show';
					}
				} else {
					cartFooter.className = "cartFooter";
				}
			}

			//이벤트 에이전트 선택 해제;
			selectedViewList.onclick = function(e) {
				e = e || window.event;
				var el = e.srcElement;
				if (el.className == "del") {
					var index = el.getAttribute('index');
					var input = tr[index].getElementsByTagName('input')[0];
					input.checked = false;
					input.onclick();
				}
			}

			//더하기와 빼기 이벤트；
			for (var i = 0; i < tr.length; i++) {
				//더하기 및 빼기 버튼；
				tr[i].onclick = function(e) {
					e = e || window.event;
					document.onselectstart = new Function(
							"event.returnValue=false;");
					var el = e.target || e.srcElement;
					var cls = el.className;
					var input = this.getElementsByTagName('input')[1];
					var val = parseInt(input.value);
					var reduce = this.getElementsByTagName('span')[3];
					switch (cls) {
					case 'add':
						input.value = val + 1;
						reduce.innerHTML = '+';
						getSubtotal(this);
						break;
					case 'reduce':
						if (val > 1) {
							input.value = val - 1;
							getSubtotal(this);
						}
						if (input.value <= 1) {
							reduce.innerHTML = '+';
						}
						break;
					case 'deleteOne':
						//한 줄 삭제；
						var conf = confirm('선택하신 상품을 삭제하시겠습니까？');
						if (conf) {
							this.parentNode.removeChild(this);
						}
						break;
					default:
						break;
					}
					getTotal();
				}
				//input 입력 이벤트；
				tr[i].getElementsByTagName('input')[1].onkeyup = function() {
					var val = parseInt(this.value);
					var tr = this.parentNode.parentNode;
					var reduce = tr.getElementsByTagName('span')[3];
					if (isNaN(val) || val < 1) {
						val = 1;
					}
					this.value = val; //입력 제어 방법；
					if (val <= 1) {
						reduce.innerHTML = "";
					} else {
						reduce.innerHTML = "-";
					}
					getSubtotal(tr);
					getTotal();
				}
			}
			;
			//합계
			function getSubtotal(tr) {
				var tds = tr.cells;
				var price = parseFloat(tds[2].innerHTML);
				var count = tr.getElementsByTagName('input')[1].value;
				var subTotal = parseFloat(price * count).toFixed(3);
				tds[4].innerHTML = subTotal;
			}

			//삭제；
			multiDelete.onclick = function() {
				if (selectedTotal.innerHTML != '0') {
					var conf = confirm('선택하신 상품을 삭제하시겠습니까?');
					if (conf) {
						cartDel();
						getTotal();
					}
				}
			}
			allDelete.onclick = function() {
				var conf = confirm('전체 상품을 삭제하시겠습니까?？');
				if (conf) {
					checkAllInput[0].checked = true;
					checkAllInput[0].onclick();
					cartDel();
					getTotal();
				}
			}
			//삭제할 떄 i의 변경 사항 유의;
			function cartDel() {
				for (var i = 0; i < tr.length; i++) {
					var input = tr[i].getElementsByTagName('input')[0];
					if (input.checked) {
						tr[i].parentNode.removeChild(tr[i]);
						i--;
					}
					;
				}
				;
			}
		}
	</script>
</body>
</html>