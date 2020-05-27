package com.LECFLY.LF.model.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.vo.admin.PayHistoryVO;
import com.LECFLY.LF.model.vo.cart.CouponVO;
import com.LECFLY.LF.model.vo.cart.TicketVO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.model.vo.cscenter.QnaVO;
import com.LECFLY.LF.model.vo.member.CommentVO;

@Repository
public class Test {
	// 임시 다른 다오 건들이지말라는 요청받아서 그냥 새로 만듬
	@Autowired
	private JdbcTemplate jtem;
	
	
	// 『  VideoMysqlDAOImpl 가져가세요

	public static final String SQL_SELECT_ONE_VIDEO_BY_ID = "select * from video where id = ?";

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
	
	public static final String SQL_SELECT_VIDEO_TITLE_BY_ID = 
			"select title from video where id = ?";
	
	public String selectVideoTitleById(int id) {
		try {
			System.out.println(SQL_SELECT_VIDEO_TITLE_BY_ID + " / id = " + id);
			return jtem.queryForObject(SQL_SELECT_VIDEO_TITLE_BY_ID, String.class, id);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException..");
			e.printStackTrace();
		}
		return null;
	}
	
	
	//                            』
	
	
	
	/** */
	
	// 『  CreatorMysqlDAOImpl 가져가세요

	public static final String SQL_SELECT_IMG_PATH_BY_ID = 
			"select img_path, nickname from creator where id = ?"; // 세현추가
	
	public static final String SQL_SELECT_FID_BY_ID = "select fid from creator where id = ?";
	
	public static final String SQL_SELECT_ONE_CREATOR_BY_ID = 
			"select * from creator where id = ?";
	
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

	public int selectFidById(int creatorId) {
		try {
			System.out.println(SQL_SELECT_FID_BY_ID + " / id = " + creatorId);
			return jtem.queryForObject(SQL_SELECT_FID_BY_ID, Integer.class, creatorId);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException..");
			e.printStackTrace();
		}
		return 0;
	}
	
	public CreatorVO selectOneCreatorById(int id) {
		try {
			System.out.println(SQL_SELECT_ONE_CREATOR_BY_ID + " / id = " + id);
			jtem.queryForObject(SQL_SELECT_ONE_CREATOR_BY_ID, 
					BeanPropertyRowMapper.newInstance(CreatorVO.class), id);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException..");
			e.printStackTrace();
		}
		return null;
	}
	
	////////////////////            』
	
	/** */
	
	//    『     CommentMysqlDAOImpl 가져가세요

	// 세현추가 0515
	public static final String SQL_CHECK_NUMBER_OF_COMMENTS_FOR_MEMBER = 
			"select count(*) from comments where mb_id = ? and table_cate = 0 or table_cate = 1";
	// 세현추가 0515
	public static final String SQL_SELECT_ALL_COMMENT_FOR_ID_OFFSET_LIMIT = 
			"select * from comments where mb_id = ? and table_cate = 0 or table_cate = 1 order by created_at desc limit ?, ?";
	
	//@Override /** 세현 추가*/
	public int checkNumberOfCommentsForMember(int mbId) {
		System.out.println("checkNumberOfCommentsForMember()");
		try {			System.out.println(SQL_CHECK_NUMBER_OF_COMMENTS_FOR_MEMBER + " / mb_id = " + mbId );
			return jtem.queryForObject(SQL_CHECK_NUMBER_OF_COMMENTS_FOR_MEMBER,
						Integer.class, mbId);
		}catch (DataAccessException e) {
			System.out.println("DataAccessException");
			e.printStackTrace();
		}
		return -1;
		
	}
	
	//@Override/** 세현추가 */
	public List<CommentVO> selectAllMyComment(int mbId, int offset, int limit) {
		System.out.println("selectAllMyComment()");
		try {
			System.out.println(SQL_SELECT_ALL_COMMENT_FOR_ID_OFFSET_LIMIT + 
					" / mb_id = " + mbId + " / offset = " + offset + " / limit = " + limit);
			return  jtem.query(SQL_SELECT_ALL_COMMENT_FOR_ID_OFFSET_LIMIT, 
					BeanPropertyRowMapper.newInstance(CommentVO.class), mbId, offset, limit);
		}catch (DataAccessException e) {
			System.out.println("DataAccessException");
			e.printStackTrace();
		}
		return null;
	}		
	
	public static final String SQL_SELECT_COMMENTS_COMMENT_BY_ID = 
			"select comment from comments where id = ?";
	
	public String selectCommentCommentById(int id) {
		try {
			System.out.println(SQL_SELECT_COMMENTS_COMMENT_BY_ID + " / id = " + id);
			return jtem.queryForObject(SQL_SELECT_COMMENTS_COMMENT_BY_ID, String.class, id);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException..");
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static final String SQL_SELECT_ALL_COMMENTS_QNAS_BY_MEMBER_ID = 
			"select * from comments where mb_id = ? and table_cate = 2 order by created_at desc";


	//@Override/** 0515 세현추가 mb_id가있는 모든 qna 문장을 찾음  */
	public List<CommentVO> showAllCommentsQnasByMemberId(int mbId) {
		try{
			return jtem.query(SQL_SELECT_ALL_COMMENTS_QNAS_BY_MEMBER_ID, 
				BeanPropertyRowMapper.newInstance(CommentVO.class), mbId);
		} catch (DataAccessException e) {
			System.out.println("DataAccessException");
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	///////////////////////       』
	
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
	
	/** 사용하지않은쿠폰(사용가능한 쿠폰의 갯수를 세어주는 함수) */
	public static final String SQL_COUNT_NOT_USE_COUPONS_BY_MBID = 
			"SELECT COUNT(*) FROM COUPONS WHERE MB_ID = ? AND USE_CHECK = 0";
	
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
	
	public int checkNumberOfCouponseByMbId(int mbId) {
		System.out.println("dao: checkNumberOfCouponseByMbId()");
		try {
			System.out.println(SQL_COUNT_NOT_USE_COUPONS_BY_MBID + " / mb_id = " + mbId);
			return jtem.queryForObject(
					SQL_COUNT_NOT_USE_COUPONS_BY_MBID, Integer.class, mbId);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException..");
			e.printStackTrace();
		}
		return 0;
	}
	
	
	////////////////////      』
	
	/** */
	
	/////////////// ILectureDAO
	
	public static final String SQL_SELECT_ONE_ID_CATEGOTY_TITLE_TITLEIMG_NICKNAME_LIKECOUNT_IMGPATH_BY_ID 
			= "select id, category, title, title_img, nickname, like_count, img_path from lectures where id = ?";
	
	public Map<String, Object> selectOneIdCategotyTitleTitleimgNicknameLikeCountImgPathById(int lecId) {
		System.out.println("selectOneIdCategotyTitleTitleimgNicknameLikeCountImgPathById()");
		try {
			System.out.println(
					SQL_SELECT_ONE_ID_CATEGOTY_TITLE_TITLEIMG_NICKNAME_LIKECOUNT_IMGPATH_BY_ID + 
						" / id = " + lecId);
			Map<String, Object> rMap = 
					jtem.queryForMap(
							SQL_SELECT_ONE_ID_CATEGOTY_TITLE_TITLEIMG_NICKNAME_LIKECOUNT_IMGPATH_BY_ID, lecId);
			return rMap;
		} catch(DataAccessException e) {
			System.out.println("DataAccessException..");
			e.printStackTrace();
		}
		return null;
	}

	public static final String SQL_SELECT_LECTURE_TITLE_BY_ID = 
			"select title from lectures where id = ?";
	
	public String selectLectureTitleById(int id) {
		try {
			System.out.println(SQL_SELECT_LECTURE_TITLE_BY_ID + " / id = " + id);
			return jtem.queryForObject(SQL_SELECT_LECTURE_TITLE_BY_ID, String.class, id);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException..");
			e.printStackTrace();
		}
		return null;
	}

	///////////
	
	public static final String SQL_SELECT_PIC_BY_ID = "select pic from members where id = ?"; 
	// MemberDAO 가져가세요..
	public String selectMemberPicById(int id) {
		try {
			System.out.println(SQL_SELECT_PIC_BY_ID + " / id = " + id);
			return jtem.queryForObject(SQL_SELECT_PIC_BY_ID, String.class, id);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException.."); 
			e.printStackTrace();
		}
		return null;
	}

	//////////
	
	/** */
	
	////////// 『 TiketDAOImpl 에서 사용하세요~
	
	public static final String SQL_SELECT_TIKET_BY_MBID = 
			"SELECT * FROM TICKETS WHERE MB_ID = ?";
	
	public List<TicketVO> selectTiketByMbId(int mbId) {
		System.out.println("dao : selectTiketByMbId()");
		try {
			System.out.println(SQL_SELECT_TIKET_BY_MBID + " / mb_id = " + mbId);
			return  jtem.query(SQL_SELECT_TIKET_BY_MBID, 
					BeanPropertyRowMapper.newInstance(TicketVO.class), mbId);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException..");
			e.printStackTrace();
		}
		return null;
	}
	
	public static final String SQL_SELECT_ONE_TIKET_FOR_CANUSE_BUY_MBID =
			"SELECT * FROM TICKETS WHERE MB_ID = ? and (current_time() <= end_day)";
	public TicketVO selectOneTiketForCanUseByMbId(int mbId) {
		try{
			System.out.println(SQL_SELECT_ONE_TIKET_FOR_CANUSE_BUY_MBID + " / mbId = " + mbId);
			jtem.queryForObject(SQL_SELECT_ONE_TIKET_FOR_CANUSE_BUY_MBID, 
						BeanPropertyRowMapper.newInstance(TicketVO.class), mbId);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException..");
			e.printStackTrace();
		}
		return null;
	}
	
	////////////////////////////////// 』
	
	/** */
	
	//////// 『 PayHistoryImpl 에서 사용하세요
	
	public static final String SQL_SELECT_PAY_HISTORIES_BY_BUYMBID = 
			"select * from pay_histories where buy_mb_id = ?";
	
	public static final String SQL_SELECT_PAY_HISTORIES_BY_BUYMBID_DELIVERYSTATUS = 
			"select * from pay_histories where buy_mb_id = ? and delivery_status = ?";
	
	public List<PayHistoryVO> selectAllPayHistoriesByMbId(int buyMbId) {
		try {
			System.out.println( SQL_SELECT_PAY_HISTORIES_BY_BUYMBID + " / buymbId = " + buyMbId);
			return jtem.query(SQL_SELECT_PAY_HISTORIES_BY_BUYMBID, 
					BeanPropertyRowMapper.newInstance(PayHistoryVO.class), buyMbId);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException..");
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<PayHistoryVO> selectAllPayHistoriesByMbIdDeliveryStatus
											(int buyMbId, int deliveryStatus) {
		try {
			System.out.println(SQL_SELECT_PAY_HISTORIES_BY_BUYMBID_DELIVERYSTATUS + 
					" / buy_mb_id = " + buyMbId + " / deliveryStatus = " + deliveryStatus);
			return jtem.query(SQL_SELECT_PAY_HISTORIES_BY_BUYMBID_DELIVERYSTATUS, 
					BeanPropertyRowMapper.newInstance(PayHistoryVO.class), buyMbId, deliveryStatus);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException..");
			e.printStackTrace();
		}
		return null;
	}

	// 문장이름이랑 문장 sql에서 확인한번필요함   
	// 문장이름 1안 
	public static final String SQL_SELECT_PAY_HISTORIES_BY_BUYMBID_GDSTYPE_RT_ID_GDSID_PAYWAY_DEALDAY_CHECKSAMEORDER_DELIVERYSTATUS_PAYHISTORYSUM 
		= "select id, gds_id, pay_way, deal_day, check_same_order, delivery_status, pay_history_sum from pay_histories where buy_mb_id = ? and gds_type = ?";
	// 문장이름 2안
//	public static final String SQL_SELECT_MYPAGE_PAY_STATUS_DATA_MAP_BY_MBID_GDSTYPE = 
//			"select id, gds_id, pay_way, deal_day, check_same_order, delivery_status, pay_history_sum from pay_histories where buy_mb_id = ? and gds_type = ?";
	// 상품명(id) 결제금액 구매일 배송상태 카드종류
	
	// 구매한회원으로만 검색 1안
	public static final String SQL_SELECT_PAY_HISTORIES_BY_BUYMBID_RT_ID_GOODSID_PAYWAY_DEALDAY_CHECKSAMEORDER_DELIVERYSTATUS_PAYHISTORYSUM 
		= "select id, gds_id, pay_way, deal_day, check_same_order, delivery_status, pay_history_sum from pay_histories where buy_mb_id = ?";
	// 검색 2안
//	public static final String SQL_SELECT_MYPAGE_PAY_STATUS_DATA_MAP_BY_MBID 
//		= "select id, gds_id, pay_way, deal_day, check_same_order, delivery_status, pay_history_sum from pay_histories where buy_mb_id = ?";
	
	public List<Map<String, Object>> selectMemberPayHistoryByBuyMbIdgdsType(int buyMbId, int gdsType) {
		System.out.println("dao selectMemberPayHistoryByBuyMbIdgdsType()..");
		if(gdsType == 3) {
			try {
				System.out.println("전체검색");
				System.out.println(SQL_SELECT_PAY_HISTORIES_BY_BUYMBID_RT_ID_GOODSID_PAYWAY_DEALDAY_CHECKSAMEORDER_DELIVERYSTATUS_PAYHISTORYSUM + "buyMbId = " + buyMbId);
				jtem.queryForList(SQL_SELECT_PAY_HISTORIES_BY_BUYMBID_RT_ID_GOODSID_PAYWAY_DEALDAY_CHECKSAMEORDER_DELIVERYSTATUS_PAYHISTORYSUM,
						buyMbId);
			} catch(DataAccessException e) {
				System.out.println("DataAccessException..");
				e.printStackTrace();
			}
		} else {
			try {
				System.out.println("이용권이나 키트검색");
				System.out.println(SQL_SELECT_PAY_HISTORIES_BY_BUYMBID_GDSTYPE_RT_ID_GDSID_PAYWAY_DEALDAY_CHECKSAMEORDER_DELIVERYSTATUS_PAYHISTORYSUM 
						+ " / buyMbId = " + buyMbId + " / gsType = " + gdsType);
				return jtem.queryForList(SQL_SELECT_PAY_HISTORIES_BY_BUYMBID_GDSTYPE_RT_ID_GDSID_PAYWAY_DEALDAY_CHECKSAMEORDER_DELIVERYSTATUS_PAYHISTORYSUM, 
						buyMbId, gdsType);
			} catch(DataAccessException e) {
				System.out.println("DataAccessException");
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	////////    』
	
	/** */
	
	///////// 『  KitImpl 에서 사용하세요~~
	
	public static final String SQL_SELECT_ONE_KIT_BY_ID = 
			"select * from kits where id = ?"; 
	public KitVO selectOneKitById(int id) {
		try {
			return jtem.queryForObject(SQL_SELECT_ONE_KIT_BY_ID, 
					BeanPropertyRowMapper.newInstance(KitVO.class), id);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException");
			e.printStackTrace();
		}
		return null;
	}

	
	
	




	
	/////// 』
	
}
