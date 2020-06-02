package com.LECFLY.LF.model.dao.impl.payhistory;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.payHistory.IPayHistoryDAO;
import com.LECFLY.LF.model.vo.admin.PayHistoryVO;
import com.LECFLY.LF.model.vo.cart.TicketVO;

@Repository
public class PayHistoryMySqlImpl implements IPayHistoryDAO {
	@Autowired
	JdbcTemplate jtem;
	
	// SQL 정의문
	private final String SQL_INSERT_ONE_CATEGORY_BY_NAME = "insert into ticket_list values(null, ?, ?, null, ?, now(), now())";
	private final String SQL_InSERT_ONE_HISTORYVO_BY_PHIS = "insert into pay_histories values(null, ?, ?, ?, ?, ?, ?, ?, ?, now(), ?, 1, '', now(), ?)";
	// 																	  	 insertNewPayHistory(mbId, MbId, 0, cart.getGdsId(), couponId, cart.getGdsCnt(), kitDelPrice, uuid, payHistorySum);
	private final String SQL_SELECT_PAYHISTORY_BY_UUID = "select * from pay_histories where check_same_order = ?";
	
	@Override
	public List<TicketVO> insertOneCategorybyName(int ticName) {
		return jtem.query(SQL_INSERT_ONE_CATEGORY_BY_NAME, BeanPropertyRowMapper.newInstance(TicketVO.class), ticName);
	}

	@Override
	public int insertNewPayHistory(PayHistoryVO phis) {
		
//		System.out.println(SQL_InSERT_ONE_HISTORYVO_BY_PHIS + phis.getBuyMbId() + " " + phis.getSellMbId()+ " " + phis.getGoodsType() + " " + phis.getGoodsId() + " " + phis.getPayWay() + " " + phis.getCouponId() + " " + phis.getCheckSameOrder() + " " + phis.getPayHistorySum());
		int r = jtem.update(SQL_InSERT_ONE_HISTORYVO_BY_PHIS, phis.getBuyMbId(), phis.getSellMbId(), phis.getGoodsType() ,phis.getGoodsId(), phis.getPayWay(), phis.getCouponId(), phis.getBuyProductCount(), phis.getDiliveryPrice(), phis.getCheckSameOrder(), phis.getPayHistorySum());
		return r;
	}

	@Override
	public List<PayHistoryVO> selectPayHistorybyUuid(String uuid) {
		return jtem.query(SQL_SELECT_PAYHISTORY_BY_UUID, BeanPropertyRowMapper.newInstance(PayHistoryVO.class), uuid);
	}

	
	
}
