package com.LECFLY.LF.service.inf.cart;

import java.util.List;
import java.util.Map;

import com.LECFLY.LF.model.vo.CartVO;

public interface ICartSVC {
	// 회원이 장바구니의 목록을 조회할 수 있다.
	public Map<String,List> myCartList(CartVO cartVO) throws Exception;
	// 회원이 상품 번호를 이용하여 장바구니에 상품을 추가하기 전인지 혹은 추가된 상품인지 확인 할 수 있다.
	public boolean findCartGoods(CartVO cartVO) throws Exception; 
	// 회원이 상품을 장바구니에 넣을 수 있다.
	public void addGoodsInCart(CartVO cartVO) throws Exception;
	// 회원이 장바구니안에 있는 상품의 갯수를 수정할 수 있다.
	public boolean modifyCartCnt(int id) throws Exception;
	// 회원이 장바구니 안에 있는 상품을 삭제 할 수 있다.
	public Map<String, Object> showGoodsProc(int mbId, int lecId);
}
