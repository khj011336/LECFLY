package com.LECFLY.LF.service.impl.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.inf.admin.IAdminPaymentDAO;
import com.LECFLY.LF.model.vo.virtual.PaymentStatVO;
import com.LECFLY.LF.service.inf.admin.IAdminPaymentSVC;

@Service
public class AdminPaymentSVCImpl implements IAdminPaymentSVC {

	@Autowired
	private IAdminPaymentDAO apDao;
	
	
	@Override
	public List<PaymentStatVO> statSumKitSaleByMonth() {
		return apDao.statSumKitSaleByMonth();
	}
	@Override
	public List<PaymentStatVO> statSumTicketSaleByMonth() {
		return apDao.statSumTicketSaleByMonth();
	}
	@Override
	public List<PaymentStatVO> statSumTotalSaleByMonth() {
		return apDao.statSumTotalSaleByMonth();
	}

}
