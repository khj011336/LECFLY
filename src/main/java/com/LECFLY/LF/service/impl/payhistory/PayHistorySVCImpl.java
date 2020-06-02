package com.LECFLY.LF.service.impl.payhistory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.inf.cart.ICartDAO;
import com.LECFLY.LF.model.dao.inf.creator.IKitDAO;
import com.LECFLY.LF.model.dao.inf.payHistory.IPayHistoryDAO;
import com.LECFLY.LF.model.vo.admin.PayHistoryVO;
import com.LECFLY.LF.model.vo.cart.CartVO;
import com.LECFLY.LF.model.vo.cart.TicketVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.service.inf.payhistory.IPayHistorySVC;
@Service
public class PayHistorySVCImpl implements IPayHistorySVC {
	@Autowired
	IPayHistoryDAO payDao;
	@Autowired
	ICartDAO ctDao;
	@Autowired
	IKitDAO kitDao;
	
	@Override
	public Map<String, Object> showOrderProc(int mbId, int ticName) {
		int categoryId = CartVO.CATEGORY_ID_TICKET;
		UUID uuid = UUID.randomUUID();
		String strUuid = uuid.toString();
		String ticketName = TicketVO.STR_TICKET_NAME_MAP.get(ticName);
		int ticketPrice = TicketVO.TICKET_PRICE_MAP.get(ticName);
		int state = CartVO.CATEGORY_STATE_WAIT;
		System.out.println("ticName = " + ticName + "categoryId = "
				+ categoryId + "strUuid = " + strUuid + "ticketName = " + ticketName + "ticketPrice = " + ticketPrice );
		int r = ctDao.insertNewCartByTicId(mbId, categoryId, ticName, strUuid, ticketName, ticketPrice, state);
		CartVO cart = ctDao.selectOneCartByUUId(strUuid);
		System.out.println("svc . cart = " + cart);

		Map<String, Object> rMap = new HashMap<>();
		rMap.put("r", r);
		rMap.put("cart", cart);
		return rMap;
	}
	
	@Override
	//public List<PayHistoryVO> insertPayHis(int mbId, String uuid, int payWay, int couponId) {
	public Map<String, Object> insertPayHis(int mbId, String uuid, int payWay, int couponId) {
		List<CartVO> ctList = ctDao.findListByUuid(uuid);
		List<String> titleList = new ArrayList<>();
		Map<String, Object> rMap = new HashMap<>();
		int addPrice = 0;
		int addDelPrice = 0;
		for (int i = 0; i < ctList.size(); i++) {
			CartVO cart = ctList.get(i);
			if(cart.getCategoryId() == 0) {
				cart.getGdsId();
				cart.getGdsName();
				addPrice += cart.getGdsPrice();
				cart.getGdsCnt();
				addDelPrice += 0;
				cart.getCreatedAt();
				System.out.println("cart.getGdsName() = " + cart.getGdsName());
				System.out.println("TicketVO.STR_TICKET_NAME_MAP.get(1) = " + TicketVO.STR_TICKET_NAME_MAP.get(1));
				String title = cart.getGdsName();
				System.out.println("title = " + title);
				titleList.add(title);
				PayHistoryVO phis = new PayHistoryVO(mbId, 0, 1, cart.getGdsId(), couponId, cart.getGdsCnt(), 0, uuid, cart.getGdsPrice());
				payDao.insertNewPayHistory(phis);
				// insertNewPayHistory(mbId, kitSellMbId, 0, cart.getGdsId(), couponId, cart.getGdsCnt(), kitDelPrice, uuid, payHistorySum);
			} else if(cart.getCategoryId() == 1) {
				//애가 키트의 아이디야.
				cart.getGdsId();
				cart.getGdsName();
				addPrice += cart.getGdsPrice();
				cart.getGdsCnt();
				cart.getCreatedAt();
				
				KitVO kit = kitDao.selectOneKit(cart.getGdsId());
				int kitDelPrice = kit.getDeliveryPrice();
				int kitSellMbId = kit.getfId();
				String title = kit.getTitle();
				addDelPrice += kit.getDeliveryPrice();
				System.out.println("title = " + title);
				titleList.add(title);
				PayHistoryVO phis = new PayHistoryVO(mbId, kitSellMbId, 2, cart.getGdsId(), couponId, cart.getGdsCnt(), kitDelPrice, uuid, cart.getGdsPrice());
				
				payDao.insertNewPayHistory(phis);
				// insertNewPayHistory(mbId, kitSellMbId, 0, cart.getGdsId(), couponId, cart.getGdsCnt(), kitDelPrice, uuid, payHistorySum);
			} else {
				System.out.println("0 또는 1 외의 잘못된 값 입력 ");
			}
		}
		List<PayHistoryVO> hisList = payDao.selectPayHistorybyUuid(uuid);
		List<String> payNameList = new ArrayList<>();
		for (int i = 0; i < hisList.size(); i++) {
			String payName = hisList.get(i).getPayWay() == 1 ? "카드결제" : "카카오페이"; 
			payNameList.add(payName);		
		}
		
		rMap.put("addPrice", addPrice);
		rMap.put("addDelPrice", addDelPrice);
		rMap.put("hisList", hisList);
		rMap.put("titleList", titleList);
		rMap.put("payNameList", payNameList);
		//return hisList;
		return rMap;
	}
	
	
}
