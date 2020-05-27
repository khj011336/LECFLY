package com.LECFLY.LF.service.impl.payhistory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.inf.cart.ICartDAO;
import com.LECFLY.LF.model.dao.inf.payHistory.IPayHistoryDAO;
import com.LECFLY.LF.model.vo.cart.CartVO;
import com.LECFLY.LF.service.inf.payhistory.IPayHistorySVC;
@Service
public class PayHistorySVCImpl implements IPayHistorySVC {
	@Autowired
	IPayHistoryDAO payDao;
	@Autowired
	ICartDAO ctDao;
	// 바로 결제를 위한 폼 준비하기.
	@Override
	public Map<String, Object> showOrderProc(int mbId, int ticName) {
		int categoryId = CartVO.CATEGORY_ID_TICKET;
		UUID uuid = UUID.randomUUID();
		String strUuid = uuid.toString();
		int r = ctDao.insertNewCartByMbIdTicId(categoryId, mbId, ticName, strUuid);
		CartVO cart = ctDao.selectOneCartByUUId(mbId, strUuid);
		System.out.println("svc . cart = " + cart);
		
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("r", r);
		rMap.put("cart", cart);
		return rMap;
	}


}
