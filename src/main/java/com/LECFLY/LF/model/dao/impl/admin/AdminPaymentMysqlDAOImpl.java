package com.LECFLY.LF.model.dao.impl.admin;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.admin.IAdminPaymentDAO;
import com.LECFLY.LF.model.vo.CouponVO;
import com.LECFLY.LF.model.vo.PayHistoryVO;
import com.LECFLY.LF.model.vo.ProfitHistoryVO;


public class AdminPaymentMysqlDAOImpl implements IAdminPaymentDAO{

	//@Autowired
	private JdbcTemplate jtem;	
	
	// 결제내역 Part
	// 결제내역 목록 보여주기
	public static final String SQL_PAYHISTORY_SHOWALL
		= "select * from pay_histories order by created_at desc";
	// 결제내역 상세조회
	public static final String SQL_PAYHISTORY_SHOWONE
		= "select * from pay_histories where id = ?";
	// 결제내역 등록하기
	public static final String SQL_PAYHISTORY_INSERT_VO
		= "insert into pay_histories values(0, ?, ?, ?, ?, ?, ? , ?, now(), now(), ?, ?)";
	// 결제내역 수정하기
	public static final String SQL_PAYHISTORY_UPDATE_VO
		= "update pay_histories set type = ?, title = ?, content = ?, showPrivate = ? where id = ?";
	// 결제내역 삭제하기
	public static final String SQL_PAYHISTORY_DELETE_VO
		= "delete pay_histories where id = ?";
	// 결제내역 페이지 조회
	public static final String SQL_PAYHISTORY_SHOWALL_PG
		= "SELECT * FROM pay_histories order by created_at desc limit ?, ?";
	// 결제내역 갯수 카운트
	public static final String SQL_CHECK_PAYHISTORY_NUMBERS
	= "select count(id) as cnt from pay_histories";	
	
	
	// 쿠폰 Part
	// 쿠폰 목록 보여주기
	public static final String SQL_COUPON_SHOWALL
		= "select * from coupons order by created_at desc";
	// 쿠폰 상세조회
	public static final String SQL_COUPON_SHOWONE
		= "select * from coupons where id = ?";
	// 쿠폰 등록하기
	public static final String SQL_COUPON_INSERT_VO
		= "insert into coupons values(0, ?, ?, ?, ?, ?, ?, now(), ?)";
	// 쿠폰 수정하기
	public static final String SQL_COUPON_UPDATE_VO
		= "update coupons set useCheck = ?, discount = ?, endDay = ? where id = ?";
	// 쿠폰 삭제하기
	public static final String SQL_COUPON_DELETE_VO
		= "delete coupons where id = ?";
	// 쿠폰 페이지 조회
	public static final String SQL_COUPON_SHOWALL_PG
		= "SELECT * FROM coupons order by created_at desc limit ?, ?";
	// 쿠폰 갯수 카운트
	public static final String SQL_CHECK_COUPON_NUMBERS
	= "select count(id) as cnt from coupons";	
	
	// 수익분배 Part
	// 수익분배 목록 보여주기
	public static final String SQL_PROFITHISTORY_SHOWALL
		= "select * from profit_histories order by created_at desc";
	// 수익분배 상세조회
	public static final String SQL_PROFITHISTORY_SHOWONE
		= "select * from profit_histories where id = ?";
	// 수익분배 등록하기
	public static final String SQL_PROFITHISTORY_INSERT_VO
		= "insert into profit_histories values(0, ?, ?, ?, ?, ?, ? , ?, now(), now(), ?, ?)";
	// 수익분배 수정하기
	public static final String SQL_PROFITHISTORY_UPDATE_VO
		= "update profit_histories set type = ?, title = ?, content = ?, showPrivate = ? where id = ?";
	// 수익분배내역 삭제하기
	public static final String SQL_PROFITHISTORY_DELETE_VO
		= "delete profit_histories where id = ?";
	// 수익분배내역 페이지 조회
	public static final String SQL_PROFITHISTORY_SHOWALL_PG
		= "SELECT * FROM profit_histories order by created_at desc limit ?, ?";
	// 수익분배내역 갯수 카운트
	public static final String SQL_CHECK_PROFITHISTORY_NUMBERS
	= "select count(id) as cnt from profit_histories";	
	
	@Override
	public boolean updatePayHistory(PayHistoryVO ph) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePayHistory(PayHistoryVO ph) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PayHistoryVO> selectOnePayHistoryList(PayHistoryVO ph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PayHistoryVO> selectPayHistoryList(PayHistoryVO ph) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkNumberOfPayHistories() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean insertCoupon(CouponVO cp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCoupon(CouponVO cp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCoupon(CouponVO cp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CouponVO> selectOneCoupon(CouponVO cp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CouponVO> selectCouponList(CouponVO cp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkNumberOfCoupons() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean insertNewProfit(ProfitHistoryVO pf) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ProfitHistoryVO> selectOneProfit(ProfitHistoryVO pf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateProfit(ProfitHistoryVO pf) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProfit(ProfitHistoryVO pf) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ProfitHistoryVO> showAllProfits(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkNumberOfProfits() {
		// TODO Auto-generated method stub
		return 0;
	}

}
