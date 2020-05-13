package com.LECFLY.LF.service.impl.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.inf.cart.ICartDAO;
import com.LECFLY.LF.model.vo.CartVO;
import com.LECFLY.LF.service.inf.cart.ICartSVC;

@Service
public class CartSVCImpl implements ICartSVC {
	@Autowired
	@Qualifier("ctMybatis")
	ICartDAO ctDao;
	
	@Override
	public boolean insertNewCart(CartVO ct) throws Exception {
		return ctDao.insertNewCart(ct);
	}

	@Override
	public boolean insertNewCart(int memberId, int goodsId, int count) throws Exception {
		return ctDao.insertNewCart(memberId, goodsId, count);
	}

	@Override
	public boolean isDuplicateCart(int goodsId) throws Exception {
		return ctDao.isDuplicateCart(goodsId);
	}

	@Override
	public List<CartVO> selectAllCart() throws Exception {
		return ctDao.selectAllCart();
	}

	@Override
	public boolean deleteOneCart(int memberId, int goodsId) throws Exception {
		return ctDao.deleteOneCart(memberId, goodsId);
	}

	@Override
	public boolean updateOneCart(int count) throws Exception {
		return ctDao.updateOneCart(count);
	}

	@Override
	public Integer[] checkNumberOfCart(List<CartVO> ctList) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkNumberOfCartForMember(int mbId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkNumberOFCartForGoods(int gdId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
