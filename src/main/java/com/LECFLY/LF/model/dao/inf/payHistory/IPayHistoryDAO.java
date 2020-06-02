package com.LECFLY.LF.model.dao.inf.payHistory;

import java.util.List;
import java.util.Map;

import com.LECFLY.LF.model.vo.cart.TicketVO;


public interface IPayHistoryDAO {

	List<TicketVO> insertOneCategorybyName(int ticName);

	int insertNewHistory(int mbId, String uuid);

	

}
