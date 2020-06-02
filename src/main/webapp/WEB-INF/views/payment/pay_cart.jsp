<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	var cartData = [];
	var cartTotalPrice = 0;
	var cartTotalPts = 0;
</script>
	
<link type="text/css" rel="stylesheet" href="resources/css/payment/pay_cart.css">
		<div id="shoppingCart_wrapper">
			<div id="shoppingCart_content">
				<div class="shoppingCart_title_box">
					<h1 class="shoppingCart_title">장바구니</h1>
					<h3 class="shoppingCart_subtitle">
						<span class="shoppingCart_basket">장바구니</span> <span class="shoppingCart_order_sheet">&gt;
							주문서</span> <span class="shoppingCart_order_finish">&gt; 주문완료</span>
					</h3>
				</div>
				<div class="cartMain">
					<table id="cartTable">
						<thead>
							<tr>
								<th id="shoppingCart_th"><label for="fl select-all">
										<input type="checkbox" class="check-all check" /> <span><a
											href="javascript:void(0)" class="selallSPAN">&nbsp;전체</a></span>
								</label></th>
								<th id="shoppingCart_th" colspan="2">상품정보</th>
								<th id="shoppingCart_th">예상가격</th>
								<th id="shoppingCart_th">수 량</th>
								<th id="shoppingCart_th">최종가격</th>
								<th id="shoppingCart_th">&nbsp;</th>
							</tr>
						</thead>
						<tbody>
<%-- 						<c:if test="${not empty cartViewList}"> 카드 없어요!! </c:if> --%>
						<c:forEach var="gd" items="${cartViewList}" varStatus="vs">
							<input type="hidden" name="tic_id" value="${gd.id}">	
							<tr id="ctTr_${gd.id}">
								<td id="shoppingCart_td" class="checkbox">
									<input type="checkbox" class="check-one check">
								</td>
								<td id="shoppingCart_td" colspan="2" class="goods">
								<img src="${gd.gdsImgPath}" alt="홈트레이닝" /> 
									<span>
										<a id="shoppingCart_a" href="##" class="goodsTitle">&nbsp;&lt;${gd.gdType}&gt;${gd.gdsName}</a>
									</span>
									<span>
										<a id="shoppingCart_a" href="##" class="sellerTitle">&nbsp;${gd.gdsCreName}</a>
									</span>
								</td>
								<td id="shoppingCart_td" class="price">${gd.gdsPrice}</td>
								<td id="shoppingCart_td" class="count">
									<span class="reduce">-</span>
										<input type="text" class="count-input" value="${gd.gdsCnt}" />
									<span class="add">+</span>
								</td>
								<td id="shoppingCart_td" class="subtotal">
									${gd.gdsPrice} 
								</td>
								<td id="shoppingCart_td" class="opration">
									<span class="deleteOne">삭 제</span>
								</td>
							</tr>
							<script>
							 var ctData = { "gdsId": ${gd.gdsId},
										"gdsName": '${gd.gdsName}',
										"gdType": ${gd.gdType},
										"gdsImgPath": '${gd.gdsImgPath}',
										"gdsPrice": ${gd.gdsPrice},
										"gdsCnt": ${gd.gdsCnt} 
									};
							 cartData.push(ctData);
							 cartTotalPts += ctData.gdsCnt; 
							 cartTotalPrice += (ctData.gdsCnt * ctData.gdsPrice);
							</script>							
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="cartFooter" id="cartFooter">
					<div class="selall fl">
						<label for="fl select-all"> 
							<input type="checkbox" class="check-all check">
							<span>
								<a id="shoppingCart_a" href="javascript:void(0)" class="selallSPAN">&nbsp;전체</a>
							</span>
						</label>
					</div>
					<a href="#" id="multiDelete" class="fl delete">삭제</a>
					 <a href="#" id="allDelete" class="fl delete">전체삭제</a>
					<div class="fr closing">
						<input id="moveOrder" class="fr closing" type="button" value="주문하기"> 
					</div>
					<div class="fr total">
						전체 주문금액: <span id="priceTotal">0</span>
					</div>
					<div class="fr selected" id="selected">
						선택된 상품 <span id="selectedTotal">0</span>개 
						<span class="arrow up">︽선택 상품 미리보기</span>
						<span class="arrow down">︾</span>
					</div>
					<div class="selected-view">
						<div id="selectedViewList" class="clearfix">
						</div>
						<span class="arrow">◆<span>◆</span></span>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
		$(document).ready(function() {
			$("#moveOrder").on("click", function() {				
				$.ajax({
					type: 'POST',
					url: '${pageContext.request.contextPath}' + '/pay_order.LF',							
					contentType: 'application/json',
					data: JSON.stringify({
							"via" : "fromCart",
							"size": cartData.length,
							"totalPts": cartTotalPts,
							"totalPrice": cartTotalPrice,
							"data": cartData
					}),
					success: function(res, status, xhr) {
						alert("성공");
						$('#homemain').html(res);
					},
					error: function(status, xhr) {
						alert("실패");
					}
				});
			});
		});
		// javaScript의 html 내의 요소들을 움직일 수 있는 dom 객체를 조작하는 방법.
		// 	window.onload = function() {
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
					if (this.className === 'check-all check') {
						for (var j = 0; j < checkInputs.length; j++) {
							checkInputs[j].checked = this.checked;
						}
					};
					if (this.checked == false) {
						for (var k = 0; k < checkAllInput.length; k++) {
							checkAllInput[k].checked = false;
						}
					}
					getTotal();
				}
			};
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
						selected += parseInt(tr[i].getElementsByTagName('input')[1].value);
						price += parseFloat(tr[i].cells[4].innerHTML);
						HTMLstr += '<div><img src="'
								+ tr[i].getElementsByTagName('img')[0].src
								+ '"/><span class="selCount">'
								+ perCount
								+ '</span><span class="del" index="'+i+'">선택해제</span></div>'
					} else {
						tr[i].className = " ";
					}
				};
				selectedTotal.innerHTML = selected;
				priceTotal.innerHTML = price.toFixed(0);
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
					console.log(this);
					console.log(this.value)
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
				};			
			}
			//합계
			function getSubtotal(tr) {
				var tds = tr.cells;
				var price = parseInt(tds[2].innerHTML);
				var count = tr.getElementsByTagName('input')[1].value;
 				var subTotal = parseInt(price * count).toFixed(0);
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
	</script>