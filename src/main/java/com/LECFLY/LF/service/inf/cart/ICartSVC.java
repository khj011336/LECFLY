package com.LECFLY.LF.service.inf.cart;

import java.util.List;
import java.util.Map;

import com.LECFLY.LF.model.vo.admin.PayHistoryVO;
import com.LECFLY.LF.model.vo.cart.CartVO;
import com.LECFLY.LF.model.vo.cart.TicketVO;


public interface ICartSVC {

	// 회원이 로그인 시 , 강의 상세페이지로 이동 할 수 있다.
	public Map<String, Object>showLectureProc(int lecId);
	public List<TicketVO> selectOneTicket(int ticId);
	public Map<String, Object> showCartProc(int mbId);
	public Map<String, Object> showCartByNoMbProc(int kitId);
	public boolean checkCartForKitMb(int mbId, int kitId, int i);
	int insertNewCartByTicId(int mbId, int kitId, String gdType);
	public boolean updateStateForPayBegin(int mbId, int gdsId, int gdType);
	public String orderFinishedProc(int mbId, int result);


}
