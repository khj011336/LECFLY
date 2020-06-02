package com.LECFLY.LF.model.dao.inf.cart;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.dao.DataAccessException;

import com.LECFLY.LF.model.vo.admin.PayHistoryVO;
import com.LECFLY.LF.model.vo.cart.CartVO;
import com.LECFLY.LF.model.vo.cart.TicketVO;
import com.LECFLY.LF.model.vo.creator.KitVO;

public interface ICartDAO {
	int insertNewCartByTicId(int mbId, int categoryId, int kitOrTicId, String uuid, String ticketName, int ticketPrice, int state);
	// 회원이 장바구니의 목록을 조회할 수 있다.
	public List<CartVO> selectCartListByMbId(int mbId) throws DataAccessException;
	public List<TicketVO> selectTicketList(int ticId) throws DataAccessException;
	public List<KitVO> selectKitList(List<CartVO> cartList) throws DataAccessException;
	public int insertNewCartRtKey(CartVO cart);
	CartVO selectOneCartByUUId(String uuid);
	List<CartVO> selectCartListByCategoryIdMbId(int categoryId, int mbId);
	/**
	 * @param categoryId // 0이면 이용권  1이면 키트
	 * @param mbId
	 * @param kitOrTicId // 이용권 or 키트 아이디
	 *
	 */
	int checkCartByMbIdKitId(int mbId, int kitId, int categoryId);
	boolean updateUuidStateBymbId(int mbId, int result, String uuid);
	boolean updateStateByMbid(int mbId, int gdsId, int gdType);
	

}
