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
	// 바로 결제를 위한 폼 준비하기.
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
	public int insertPayHis(int mbId, String uuid, int payWay, int couponId) {
		List<CartVO> ctList = ctDao.findListByUuid(uuid);
		int addCntCount = 0;
		int totalDelPrice = 0;
		for (int i = 0; i < ctList.size(); i++) {
			CartVO cart = ctList.get(i);
			if(cart.getCategoryId() == 0) {
				cart.getGdsId();
				cart.getGdsName();
				cart.getGdsPrice();
				cart.getGdsCnt();
				cart.getCreatedAt();
				
				KitVO kit = kitDaoselectOneKitById(cart.getGdsId());
				int kitDelPrice = kit.getDeliveryPrice();
				int kitOwn = Intekit.getfId();
				addCntCount += cart.getGdsCnt();
 				int payHistorySum = addCntCount * cart.getGdsPrice(); 
				PayHistoryVO phis = new PayHistoryVO(buyMbId, sellMbId, goodsType, goodsId, couponId, buyProductCount, diliveryPrice, checkSameOrder, payHistorySum);
			} else if(cart.getCategoryId() == 1) {
				//애가 키트의 아이디야.
				cart.getGdsId();
				cart.getGdsName();
				cart.getGdsPrice();
				cart.getGdsCnt();
				cart.getCreatedAt();
				addCntCount += cart.getGdsCnt();
				// 카트중에숴 키트인애들이야
				KitVO kit = kitDaoselectOneKitById(cart.getGdsId());
				int kitDelPrice = kit.getDeliveryPrice();
				totalDelPrice += kitDelPrice; 
			} else {
				System.out.println(" 0 1 외의 잘못된값입력 ");
			}
			
		}
		
		int buyProductCount = addCntCount;
		int diliveryPrice = totalDelPrice;
		int payHistorySum = 0;
		
		
		category_id를 판단하여 0, 1에 따라.. 0이면 티켓 테이블 조회하여 payhistory에 관련 덷이터 입력 준비
		1이면 키트 테이블 조회하여 역시 payhistory 관련 데이터를 입력준비한다. 
		단, 키트테이블 조회에서 seller-fid를 통하여  creator 테이블에서 판매자 정보를 조회하여 가져와서 pqyhistory에 입력 준비
		int r = payDao.insertNewHistory();
		return r;
	}
	
	
}
