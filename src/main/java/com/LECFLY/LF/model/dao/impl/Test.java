package com.LECFLY.LF.model.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.vo.CouponVO;
import com.LECFLY.LF.model.vo.QnaCommentVO;
import com.LECFLY.LF.model.vo.QnaVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;

@Repository
public class Test {
	// 임시 다른 다오 건들이지말라는 요청받아서 그냥 새로 만듬
	@Autowired
	private JdbcTemplate jtem;
	
	
	// 『  VideoMysqlDAOImpl 가져가세요

	final String SQL_SELECT_ONE_VIDEO_BY_ID = "select * from video where id = ?";

	//@Override /** 세현 추가 0515 */
	public VideoVO selectOneVideoById(int id) {
		try {
			System.out.println(SQL_SELECT_ONE_VIDEO_BY_ID + " / id = " + id);
			return jtem.queryForObject(SQL_SELECT_ONE_VIDEO_BY_ID,
			 	 	BeanPropertyRowMapper.newInstance(VideoVO.class), id);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException..");
			e.printStackTrace();
		}
		return null;
	}
	
	//                            』
	
	
	
	/** */
	
	// 『  CreatorMysqlDAOImpl 가져가세요

	final String SQL_SELECT_IMG_PATH_BY_ID = "select img_path, nickname from creator where id = ?"; // 세현추가

		//@Override/** 세현추가0515 */
	public Map<String, Object> selectOneCreatorByIdRtImgPathAndNicname(int fId) {
		try {
			System.out.println(SQL_SELECT_IMG_PATH_BY_ID + " / id = " + fId);
			return jtem.queryForMap(SQL_SELECT_IMG_PATH_BY_ID ,fId);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException..");
			e.printStackTrace();
		}
		return null;
	}

	
	////////////////////            』
	
	
	
	/** */
	
	//    『     QnaCommentMysqlDAOImpl 가져가세요

	// 세현추가 0515
	public static final String SQL_CHECK_NUMBER_OF_QNA_COMMENTS_FOR_MEMBER = 
			"select count(*) from qna_comment where mb_id = ?";
	// 세현추가 0515
	public static final String SQL_SELECT_ALL_QNA_COMMENT_FOR_ID_OFFSET_LIMIT = 
			"select * from qna_comment where mb_id = ? order by writed_day desc limit ?, ?";

	//@Override /** 세현 추가*/
	public int checkNumberOfQnaCommentsForMember(int mbId) {
		System.out.println("checkNumberOfQnaCommentsForMember()");
		try {
			System.out.println(SQL_CHECK_NUMBER_OF_QNA_COMMENTS_FOR_MEMBER + " / mb_id = " + mbId );
			return jtem.queryForObject(SQL_CHECK_NUMBER_OF_QNA_COMMENTS_FOR_MEMBER,
						Integer.class, mbId);
		}catch (DataAccessException e) {
			System.out.println("DataAccessException");
			e.printStackTrace();
		}
		return -1;
		
	}
	
	//@Override/** 세현추가 */
	public List<QnaCommentVO> selectAllMyComment(int mbId, int offset, int limit) {
		System.out.println("selectAllMyComment()");
		try {
			System.out.println(SQL_SELECT_ALL_QNA_COMMENT_FOR_ID_OFFSET_LIMIT + 
					" / mb_id = " + mbId + " / offset = " + offset + " / limit = " + limit);
			return  jtem.query(SQL_SELECT_ALL_QNA_COMMENT_FOR_ID_OFFSET_LIMIT, 
					BeanPropertyRowMapper.newInstance(QnaCommentVO.class), mbId, offset, limit);
		}catch (DataAccessException e) {
			System.out.println("DataAccessException");
			e.printStackTrace();
		}
		return null;
	}		
	
	
	///////////////////////       』
	
	/** */
	
	//   『 QnaMysqlDAOImpl 가져가세요


	public static final String SQL_SELECT_ALL_QNAS_BY_MEMBER_ID = 
				"select * from qnas where mb_id = ? order by writed_day desc";


	//@Override/** 0515 세현추가 mb_id가있는 모든 qna 문장을 찾음  */
	public List<QnaVO> showAllQnasByMemberId(int mbId) {
		try{
			return jtem.query(SQL_SELECT_ALL_QNAS_BY_MEMBER_ID, 
				BeanPropertyRowMapper.newInstance(QnaVO.class), mbId);
		} catch (DataAccessException e) {
			System.out.println("DataAccessException");
			e.printStackTrace();
		}
		return null;
	}

	/////////////////////////////////	 』
	
	
	/** */
	
	// 『 CouponMySqlDAOImpl 가져가세요
	
	/** 회원이 쿠폰등록시 해당쿠폰이있는지확인할수잇는문장 */
	public static final String SQL_SELECT_COUPON_BY_CODE = 
				"SELECT * FROM COUPONS WHERE CODE = ? AND USE_CHECK = 0";
	
	/** SQL_SELECT_COUPON_BY_CODE를 쓴함수가게 VO로 리턴되고 유저를 등록하고싶다면. */
	public static final String SQL_UPDATE_COUPON_MBID_BY_ID =
						"UPDATE COUPONS SET MB_ID = ? WHERE ID = ?";
	
	/** SQL_SELECT_COUPON_BY_CODE를 쓴함수가게 VO로 리턴되고 쿠폰을 사용하게하려면 */
	public static final String SQL_UPDATE_COUPON_MB_USE_BY_ID_MBID =
			"UPDATE COUPONS SET USE_CHECK = 1 WHERE ID = ? AND MB_ID=?";
	
	/** 마이페이지에서 쿠폰 조회할떄 사용하는 문장 사용한쿠폰 + 사용안한쿠폰 이 날짜순으로 섞여있다. */
	public static final String SQL_SELECT_ALL_MY_COUPONS_BY_MBID = 
			"SELECT * FROM COUPONS WHERE MB_ID = ? ORDER BY END_DAY";
	
//	/** 사용한다면 ?? 마이페이지에서 사용한 쿠폰 리스트 뽑을떄 출력*/
//	public static final String SQL_SELECT_ALL_USE_MY_COUPONS_BY_MBID = 
//			"SELECT * FROM COUPONS WHERE MB_ID = ? AND USE_CHECK=1 ORDER BY END_DAY";
	
//	/** 사용한다면 ?? 마이페이지에서 사용하지않은 쿠폰 리스트 뽑을떄 출력 */
//	public static final String SQL_SELECT_ALL_NOT_USE_MY_COUPONS_BY_MBID = 
//			"SELECT * FROM COUPONS WHERE MB_ID = ? AND USE_CHECK=0 ORDER BY END_DAY";
	
	public CouponVO selectOneCouponByCode (String code) {
		System.out.println("selectOneCouponByCode()");
		try {
			System.out.println(SQL_SELECT_COUPON_BY_CODE + " / code = " + code);
			return jtem.queryForObject(SQL_SELECT_COUPON_BY_CODE, 
					BeanPropertyRowMapper.newInstance(CouponVO.class), code);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException...");
			e.printStackTrace();
		}
		return null;
	} 
	
	public boolean updateCouponMbIdById(int couponId, int mbId) {
		System.out.println("updateCouponMbIdById()");
		try {
			System.out.println(SQL_UPDATE_COUPON_MBID_BY_ID + 
						" / couponId = " + couponId + " / mbId = " + mbId);
			int r = jtem.update(SQL_UPDATE_COUPON_MBID_BY_ID, couponId, mbId);
			return (r == 1);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException..");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateCouponMbUseByMbId(int couponId, int mbId) {
		try {
			System.out.println(SQL_UPDATE_COUPON_MB_USE_BY_ID_MBID + 
					" / couponId = " + couponId + " / mbId = " + mbId);
			int r = jtem.update(SQL_UPDATE_COUPON_MB_USE_BY_ID_MBID, couponId, mbId );
			return (r == 1);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException..");
			e.printStackTrace();
		}
		return false;
	}
	
	//@Override /** 세현 0515 추가 */
	public List<CouponVO> selectAllCouponByMbId(int mbId) {
		System.out.println("selectAllCouponByMbId()");
		try{
			System.out.println(SQL_SELECT_ALL_MY_COUPONS_BY_MBID + " / mbId = "+ mbId);
			return jtem.query(SQL_SELECT_ALL_MY_COUPONS_BY_MBID, 
 				BeanPropertyRowMapper.newInstance(CouponVO.class), mbId);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException");
			e.printStackTrace();
		}
		return null;
	}

	
	////////////////////      』
	
	/** */
	
	
	
	
	
	
}
