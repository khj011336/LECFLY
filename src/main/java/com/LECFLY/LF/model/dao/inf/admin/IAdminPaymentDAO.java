package com.LECFLY.LF.model.dao.inf.admin;

import java.util.List;

import com.LECFLY.LF.model.vo.ProfitHistoryVO;
import com.LECFLY.LF.model.vo.admin.PayHistoryVO;
import com.LECFLY.LF.model.vo.cart.CouponVO;
import com.LECFLY.LF.model.vo.virtual.PaymentStatVO;


public interface IAdminPaymentDAO {
	// 결제관리

	// 결제내역을 갱신할 수 있다.
	boolean updatePayHistory(PayHistoryVO ph);
	// 결제내역을 삭제할 수 있다.
	boolean deletePayHistory(PayHistoryVO ph);
	// 결제내역을 상세조회 할 수 있다.
	List<PayHistoryVO> selectOnePayHistoryList(PayHistoryVO ph);
	// 결제내역을 전체 조회 할 수 있다.
	List<PayHistoryVO> selectPayHistoryList(PayHistoryVO ph);
	int checkNumberOfPayHistories();


	// 쿠폰 관리
	
	// 쿠폰을 등록할 수 있다.
	boolean insertCoupon(CouponVO cp);
	// 쿠폰을 수정할 수 있다.
	boolean updateCoupon(CouponVO cp);
	// 쿠폰을 삭제할 수 있다.
	boolean deleteCoupon(CouponVO cp);
	// 쿠폰을 상세조회할 수 있다.
	List<CouponVO> selectOneCoupon(CouponVO cp);
	// 쿠폰을 전체조회할 수 있다.
	List<CouponVO> selectCouponList(CouponVO cp);
	int checkNumberOfCoupons();
	
	
	// 크리에이터 수익분배 관리
	
	// 수익분배를 등록할 수 있다.
	boolean insertNewProfit(ProfitHistoryVO pf);
	// 수익분배를 상세보기 할 수 있다.
	List<ProfitHistoryVO> selectOneProfit(ProfitHistoryVO pf);
	// 수익분배를 편집 할 수 있다.
	boolean updateProfit(ProfitHistoryVO pf);
	// 수익분배를 삭제 할 수 있다.
	boolean deleteProfit(ProfitHistoryVO pf);
	// 수익분배 목록을 전체 조회할수 있다.
	List<ProfitHistoryVO> showAllProfits(int offset, int limit);
	int checkNumberOfProfits();
	
	
	//통계
	List<PaymentStatVO> statSumKitSaleByMonth();
	List<PaymentStatVO> statSumTicketSaleByMonth();
	List<PaymentStatVO> statSumTotalSaleByMonth();
	
	
	
}
