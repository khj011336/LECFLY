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
			return jtem.queryForMap(SQL_SELECT_IMG_PATH_BY_ID, String.class ,fId);
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
			"select count(*) from qna_comment where id = ?";
	// 세현추가 0515
	public static final String SQL_SELECT_ALL_QNA_COMMENT_FOR_ID_OFFSET_LIMIT = 
			"select * from qna_comment where mb_id = ? order by writed_day desc limit ?, ?";

	//@Override /** 세현 추가*/
	public int checkNumberOfQnaCommentsForMember(int mbId) {
		try {
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
		try {
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
	
	String SQL_SELECT_ALL_MY_COUPONS_BY_MBID = 
			"select * from coupons where mb_id = ? order by end_day"; 
	
	//@Override /** 세현 0515 추가 */
	public List<CouponVO> selectAllCouponByMbId(int mbId) {
		try{
			System.out.println(SQL_SELECT_ALL_MY_COUPONS_BY_MBID + "/mbId = "+ mbId);
			return jtem.query(SQL_SELECT_ALL_MY_COUPONS_BY_MBID, 
 				BeanPropertyRowMapper.newInstance(CouponVO.class), mbId);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException");
			e.printStackTrace();
		}
		return null;
	}

	
	////////////////////      』
	
	
	
	
	
	
}
