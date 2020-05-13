package com.LECFLY.LF.model.dao.impl.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.cart.ICartDAO;
import com.LECFLY.LF.model.vo.CartVO;

@Repository("ctJdbc")
public class CartMysqlDAOImpl implements ICartDAO {
	
	@Autowired
	private JdbcTemplate jtem;
	
	// SQL 정의부
	private static final String SQL_INSERT_CART = "insert into cart values(null, ?, ?, ?, now())";
	private static final String SQL_INSERT_CARTVO = "insert into cart(memberId, goodsId, count) values(?, ?, ?)";
	private static final String SQL_CART_DUPCHECK = "select count(id) from cart where goodsId = ?";
	private static final String SQL_SELECT_ALL_CART = "select * from cart order by created_at desc";
	private static final String SQL_SELECT_CART_ID = "select * from cart where id = ?";
	private static final String SQL_UPDATE_CART = "update cart set count = ?";
	private static final String SQL_DELECT_CART_ID = "delete count(id) from cart where memberId =? and where goodsId = ?";
	@Override
	public boolean insertNewCart(CartVO ct) throws DataAccessException {
		int r = this.jtem.update(SQL_INSERT_CART, ct.getMemberId(), ct.getGoodsId(), ct.getCount());
		return r == 1;
	}

	@Override
	public boolean insertNewCart(int memberId, int goodsId, int count) throws DataAccessException {
		return jtem.update(SQL_INSERT_CARTVO, memberId, goodsId, count) == 1;
	}

	@Override
	public boolean isDuplicateCart(int goodsId) throws DataAccessException {
		int r = jtem.queryForObject(SQL_CART_DUPCHECK, Integer.class, goodsId);
		System.out.println("dup cnt = " + r);
		return r >= 1;
	}

	@Override
	public List<CartVO> selectAllCart() throws DataAccessException {
		List<CartVO> ctList = jtem.query(SQL_SELECT_ALL_CART, BeanPropertyRowMapper.newInstance(CartVO.class));
		return ctList;
	}

	@Override
	public boolean deleteOneCart(int memberId, int goodsId) throws DataAccessException {
		int r = jtem.queryForObject(SQL_DELECT_CART_ID, Integer.class, memberId, goodsId);
		return r == 1;
	}

	@Override
	public boolean updateOneCart(int count) throws DataAccessException {
		try {
			int r = jtem.update(SQL_UPDATE_CART, count);
			return r == 1;
		} catch (DataAccessException e) {
			System.out.println("dao/ 장바구니 갯수 정보 갱신 실패 - " + count);
		}
		return false;
	}

	@Override
	public Integer[] checkNumberOfCart(List<CartVO> ctList) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkNumberOfCartForMember(int mbId) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkNumberOFCartForGoods(int gdId) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}

}
