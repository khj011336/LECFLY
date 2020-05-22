package com.LECFLY.LF.model.dao.impl.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
	private static final String SQL_SELECT_CART_LIST = "select * from cart where mbId = ?";
	private static final String SQL_SELECT_TICKET_LIST = "";
	private static final String SQL_SELECT_KIT_LIST = "";
	private static final String SQL_SELECT_COUNT_IN_CART = "select if(count(*)=0, 'false', 'true) from cart where gdsId = ? and mbId = ? ";
	private static final String SQL_INSERT_GOODS_IN_CART = "insert into cart(id, mbId, gdsId) values(?, ?, ?)";
	private static final String SQL_UPDATE_CART_GOODS_CNT = "update cart set gdCnt = ? where mbid = ? and gdsId = ?";
	private static final String SQL_DELETE_CART_GOODS = "delete from cart where id = ?";
	private static final String SQL_SELECT_MAX_CART_ID = "select ifnull(max(id), 0) +1 from cart";
	
	@Override
	public List<CartVO> selectCartList(CartVO cartVO) throws DataAccessException {
		List<CartVO> cartList = jtem.query(SQL_SELECT_CART_LIST, BeanPropertyRowMapper.newInstance(CartVO.class), cartVO);
		return cartList;
	}

	@Override
	public List<TicketVO> selectTicketList(List<CartVO> cartList) throws DataAccessException {
		// TODO Auto-generated method stub
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

}
