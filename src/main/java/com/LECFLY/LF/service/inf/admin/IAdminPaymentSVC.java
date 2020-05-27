package com.LECFLY.LF.service.inf.admin;

import java.util.List;

import com.LECFLY.LF.model.vo.virtual.PaymentStatVO;

public interface IAdminPaymentSVC {
	
	//통계파트
	List<PaymentStatVO> statSumKitSaleByMonth();
	List<PaymentStatVO> statSumTicketSaleByMonth();
	List<PaymentStatVO> statSumTotalSaleByMonth();
}
