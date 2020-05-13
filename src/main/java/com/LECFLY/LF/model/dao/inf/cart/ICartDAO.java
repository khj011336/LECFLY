package com.LECFLY.LF.model.dao.inf.cart;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.LECFLY.LF.model.vo.CartVO;

public interface ICartDAO {
//	- 장바구니를 추가할 수 있다.
	boolean insertNewCart(CartVO ct) throws DataAccessException;
	boolean insertNewCart(int memberId, int goodsId, int count) throws DataAccessException;
//	- 장바구니 중복체크 할 수 있다.
	boolean isDuplicateCart(int goodsId) throws DataAccessException;
//	- 장바구니의 리스트를 조회 할 수 있다.
	List<CartVO> selectAllCart() throws DataAccessException;
//	- 장바구니의 리스트를 삭제할 수 있다.
	boolean deleteOneCart(int memberId, int goodsId) throws DataAccessException;
//	- 장바구니 물건의 수량을 수정할 수 있다.
	boolean updateOneCart(int count) throws DataAccessException;
//	- 장바구니의 금액을 합계 할 수 있다.
	public Integer[] checkNumberOfCart(List<CartVO> ctList) throws DataAccessException;
//	- 장바구니의 상품의 수량을 변경 할 수 있다.
	int checkNumberOfCartForMember(int mbId) throws DataAccessException;
	int checkNumberOFCartForGoods(int gdId) throws DataAccessException;
}
