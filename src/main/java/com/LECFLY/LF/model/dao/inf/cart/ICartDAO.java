package com.LECFLY.LF.model.dao.inf.cart;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataAccessException;

import com.LECFLY.LF.model.vo.cart.CartVO;
import com.LECFLY.LF.model.vo.cart.TicketVO;
import com.LECFLY.LF.model.vo.creator.KitVO;

public interface ICartDAO {
	int insertNewCartByMbIdTicId(int categoryId, int mbId, int kitOrTicId, String uuid);
	// 회원이 장바구니의 목록을 조회할 수 있다.
	public List<CartVO> selectCartList(int mbId, int kitId) throws DataAccessException;
	public List<TicketVO> selectTicketList(int ticId) throws DataAccessException;
	public List<KitVO> selectKitList(List<CartVO> cartList) throws DataAccessException;
	// 회원이 상품 번호를 이용하여 장바구니에 상품을 추가하기 전인지 혹은 추가된 상품인지 확인 할 수 있다.
	public boolean selectCountInCart(CartVO cartVO) throws DataAccessException;
	// 회원이 상품을 장바구니에 넣을 수 있다.
	public void insertGoodsInCart(CartVO cartVO) throws DataAccessException;
	// 회원이 장바구니안에 있는 상품의 갯수를 수정할 수 있다.
	public void updateCartGoodsCnt(CartVO cartVO) throws DataAccessException;
	// 회원이 장바구니 안에 있는 상품을 삭제 할 수 있다.
	public void deleteCartGoods(int id) throws DataAccessException;
	public int insertNewCartRtKey(CartVO cart);
	CartVO selectOneCartByUUId(int mbId, String uuid);
	
}
