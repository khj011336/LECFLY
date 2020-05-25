package com.LECFLY.LF.model.dao.impl.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.cart.ICartDAO;
import com.LECFLY.LF.model.vo.cart.CartVO;
import com.LECFLY.LF.model.vo.cart.TicketVO;
import com.LECFLY.LF.model.vo.creator.KitVO;

@Repository
public class CartMysqlDAOImpl implements ICartDAO {
	@Autowired
	JdbcTemplate jtem;
	
	// SQL 정의문
	private static final String SQL_INSERT_NEW_CART = "insert into cart values( null, ?, ?, ?, 1, ?, now() )";
	private static final String SQL_SELECT_CART_LIST = "select * from cart where mb_id = ?"; 
			//"insert into cart(member_id, goods_id) values(?, ?)";
	private static final String SQL_SELECT_TICKET_LIST = "select * from tickets where id = ?";
	private static final String SQL_SELECT_KIT_LIST = "";
	private static final String SQL_SELECT_COUNT_IN_CART = "select if(count(*)=0, 'false', 'true) from cart where gdsId = ? and mbId = ? ";
	private static final String SQL_INSERT_GOODS_IN_CART = "insert into cart(id, mbId, gdsId) values(?, ?, ?)";
	private static final String SQL_UPDATE_CART_GOODS_CNT = "update cart set gdCnt = ? where mbid = ? and gdsId = ?";
	private static final String SQL_DELETE_CART_GOODS = "delete from cart where id = ?";
	private static final String SQL_SELECT_MAX_CART_ID = "select ifnull(max(id), 0) +1 from cart";
	/////////////////////////////////////////////////////////////////////////////////////////////////
	private static final String SQL_INSERT_IN_CART = "insert into cart values(null, ?, 1, ?, 1, now())";
	
	/**
	 * @param categoryId // 0이면 이용권  1이면 키트
	 * @param mbId
	 * @param kitOrTicId // 이용권 or 키트 아이디 
	 * 
	 */
	@Override
	public int insertNewCartByMbIdTicId(int categoryId, int mbId, int kitOrTicId, String uuid) {
		System.out.println("insertNewCartByMbIdTicId().");
		int r = jtem.update(SQL_INSERT_NEW_CART, mbId, categoryId, kitOrTicId, uuid);
		return r;
	}
	// 0 이용권 1 키트*/ 이게 카테고리아이디      키트나 티켓의 아이디 갯수 1 uuid  now()
	// id null mb_id 받아 caterory_id  gds_id gd_cnt check_same_order created_at

	
	
	@Override
	public List<CartVO> selectCartListByMbId(int mbId) throws DataAccessException {
		System.out.println(SQL_SELECT_CART_LIST + "mbId = " + mbId);
		List<CartVO> cartList = jtem.query(SQL_SELECT_CART_LIST, BeanPropertyRowMapper.newInstance(CartVO.class), mbId);
		return cartList;
	}

	@Override
	public List<TicketVO> selectTicketList(int ticId) throws DataAccessException {
		System.out.println("selectTicketList()");
		try {
		return jtem.query(SQL_SELECT_TICKET_LIST, BeanPropertyRowMapper.newInstance(TicketVO.class), ticId);
		} catch (DataAccessException e) {
			System.out.println("selectTicketList DataAccessException");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<KitVO> selectKitList(List<CartVO> cartList) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean selectCountInCart(CartVO cartVO) throws DataAccessException {
		boolean r = jtem.query(SQL_SELECT_COUNT_IN_CART, BeanPropertyRowMapper.newInstance(CartVO.class), cartVO) != null;
		return r;
	}

	@Override
	public void insertGoodsInCart(CartVO cartVO) throws DataAccessException {
		jtem.query(SQL_INSERT_GOODS_IN_CART, BeanPropertyRowMapper.newInstance(CartVO.class), cartVO);
	}

	@Override
	public void updateCartGoodsCnt(CartVO cartVO) throws DataAccessException {
		jtem.update(SQL_UPDATE_CART_GOODS_CNT, cartVO.getGdCnt(), cartVO.getMbId(), cartVO.getGdsId());
	}

	@Override
	public void deleteCartGoods(int id) throws DataAccessException {
		jtem.query(SQL_DELETE_CART_GOODS, BeanPropertyRowMapper.newInstance(CartVO.class), id);

	}
	
	@Override
	public int insertNewCartRtKey(CartVO cart) {
		System.out.println(SQL_INSERT_IN_CART + "/ mbId = " + cart.getMbId() + "gdsId = " + cart.getGdsId());
		KeyHolder kh = new GeneratedKeyHolder();
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(SQL_INSERT_IN_CART);
				pstmt.setInt(1, cart.getMbId());
				pstmt.setInt(2, cart.getGdsId());
				return pstmt;
			}
		};
		jtem.update(psc, kh);
		Number r = kh.getKey(); // PK
		return r.intValue();
	}


	private static final String SQL_ONE_CART_BY_UUID = "select * from cart where check_same_order = ?";
	@Override
	public CartVO selectOneCartByUUId(int mbId, String uuid) {
		return jtem.queryForObject(SQL_ONE_CART_BY_UUID,BeanPropertyRowMapper.newInstance(CartVO.class), uuid);
	}


	private static final String SQL_ONE_CART_BY_MBID_KITID = "select count(*) from cart where mb_id = ? and gds_id = ?";
	
	@Override
	public int checkCartByMbIdKitId(int mbId, int kitId) {
		System.out.println("checkCartByMbIdKitId 왔어");
		return jtem.queryForObject(SQL_ONE_CART_BY_MBID_KITID, Integer.class, mbId, kitId);
	}

}
