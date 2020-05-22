package com.LECFLY.LF.service.impl.cart;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.LECFLY.LF.model.dao.inf.cart.ICartDAO;
import com.LECFLY.LF.model.vo.cart.CartVO;
import com.LECFLY.LF.service.inf.cart.ICartSVC;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CartSVCImpl implements ICartSVC {
	@Autowired
	private ICartDAO cartDAO;
	
	@Override
	public Map<String, List> myCartList(CartVO cartVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean findCartGoods(CartVO cartVO) throws Exception {
		return cartDAO.selectCountInCart(cartVO);
	}

	@Override
	public void addGoodsInCart(CartVO cartVO) throws Exception {
		cartDAO.insertGoodsInCart(cartVO);
	}

	@Override
	public boolean modifyCartCnt(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
