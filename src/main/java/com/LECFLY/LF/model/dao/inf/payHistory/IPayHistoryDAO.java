package com.LECFLY.LF.model.dao.inf.payHistory;

import java.util.List;
import java.util.Map;

import com.LECFLY.LF.model.vo.TicketVO;

public interface IPayHistoryDAO {

	List<TicketVO> insertOneCategorybyName(int ticName);

	

}
