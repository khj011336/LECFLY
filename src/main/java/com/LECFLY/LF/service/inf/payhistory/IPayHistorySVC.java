package com.LECFLY.LF.service.inf.payhistory;

import java.util.List;
import java.util.Map;


public interface IPayHistorySVC {

	Map<String, Object> showOrderProc(int mbId, int ticName);
	// 결제페이지
	// 로그인 된 회원이 카테고리 티켓을 선택후 주문 페이지로 이동 할 수 있다.
	
	
}
