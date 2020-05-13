package com.LECFLY.LF.model.dao.impl.cart;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.cart.ICartDAO;
import com.LECFLY.LF.model.vo.CartVO;

@Repository("ctMybatis")
public class cartMysqlMybatisDAOImpl implements ICartDAO {
	@Autowired
	private SqlSessionTemplate sstem;
	
	@Override
	public boolean insertNewCart(CartVO ct) throws DataAccessException {
		System.out.println("mybatis: insertNewCart()");
		int r = sstem.insert("ICartDAO.SQL_INSERT_CART", ct);
		return r == 1;
	}

	@Override
	public boolean insertNewCart(int memberId, int goodsId, int count) throws DataAccessException {
		System.out.println("mybatis: insertNewCart()");
		CartVO ct = new CartVO(memberId, goodsId, count);
		int r = sstem.insert("ICartDAO.insertNewMember", ct);
		return r == 1;
	}

	@Override
	public boolean isDuplicateCart(int goodsId) throws DataAccessException {
		Object r = sstem.selectOne("ICartDAO.SQL_CART_DUPCHECK", goodsId);
		System.out.println("ct dup cnt: " + r);
		int nDup = (Integer)r;
		return nDup == 1;
	}

	@Override
	public List<CartVO> selectAllCart() throws DataAccessException {
		return sstem.selectList("ICartDAO.SQL_SELECT_ALL_CART");
	}

	@Override
	public boolean deleteOneCart(int memberId, int goodsId) throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateOneCart(int count) throws DataAccessException {
		// TODO Auto-generated method stub
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
