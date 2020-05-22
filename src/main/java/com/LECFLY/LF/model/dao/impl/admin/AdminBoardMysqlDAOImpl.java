package com.LECFLY.LF.model.dao.impl.admin;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.admin.IAdminBoardDAO;
import com.LECFLY.LF.model.vo.CommentClassVO;
import com.LECFLY.LF.model.vo.QnaCommentVO;
import com.LECFLY.LF.model.vo.admin.FaqVO;
import com.LECFLY.LF.model.vo.admin.NoticeVO;
import com.LECFLY.LF.model.vo.admin.QnaVO;

@Repository
public class AdminBoardMysqlDAOImpl implements IAdminBoardDAO{
	
	@Autowired
	private JdbcTemplate jtem;	
	
	// QnA Part
	
	// QnA 조회수 증가
	public static final String SQL_QNA_READ_INC
		= "update qnas set hits = hits + 1 where id = ?";
	// QnA 목록 보여주기
	public static final String SQL_QNA_SHOWALL
		= "select * from qnas order by created_at desc";
	// QnA 상세조회
	public static final String SQL_QNA_SHOWONE
		= "select * from qnas where id = ?";
	// QnA 등록하기
	public static final String SQL_QNA_INSERT_VO
		= "insert into qnas values(0, ?, ?, ?, ?, ?, ? , ?, now(), now(), ?, ?)";
	// QnA 수정하기
	public static final String SQL_QNA_UPDATE_VO
		= "update qnas set type = ?, title = ?, content = ?, showPrivate = ? where id = ?";
	// QnA 삭제하기
	public static final String SQL_QNA_DELETE_VO
		= "delete qnas where id = ?";
	// QnA 페이지 조회
	public static final String SQL_QNA_SHOWALL_PG
		= "SELECT * FROM qnas order by id desc limit ?, ?";
	// QnA 갯수 카운트
	public static final String SQL_CHECK_QNA_NUMBERS
	= "select count(id) as cnt from qnas";	
	
	
	
	// Faq Part
	
	// Faq 목록 보여주기
	public static final String SQL_FAQ_SHOWALL
		= "select * from faqs order by created_at desc";
	// Faq 상세조회
	public static final String SQL_FAQ_SHOWONE
		= "select * from faqs where id = ?";
	// Faq 등록하기
	public static final String SQL_FAQ_INSERT_VO
		= "insert into faqs values(0, ?, ?, ?)";
	// Faq 수정하기
	public static final String SQL_FAQ_UPDATE_VO
		= "update faqs set title = ?, content = ? where id = ?";
	// Faq 삭제하기
	public static final String SQL_FAQ_DELETE_VO
		= "delete faqs where id = ?";
	// Faq 페이지 조회
	public static final String SQL_FAQ_SHOWALL_PG
		= "SELECT * FROM faqs order by id desc limit ?, ?";
	// Faq 갯수 카운트
	public static final String SQL_CHECK_FAQ_NUMBERS
	= "select count(id) as cnt from faqs";	

	
	// Notice Part
	
	// Notice 조회수 증가
	public static final String SQL_NOTICE_READ_INC
		= "update notices set hits = hits + 1 where id = ?";
	// Notice 목록 보여주기
	public static final String SQL_NOTICE_SHOWALL
		= "select * from notices order by created_at desc";
	// Notice 상세조회
	public static final String SQL_NOTICE_SHOWONE
		= "select * from notices where id = ?";
	// Notice 등록하기
	public static final String SQL_NOTICE_INSERT_VO
		= "insert into notices values(0, ?, ?, ?, ?, now(), now(), ?)";
	// Notice 수정하기
	public static final String SQL_NOTICE_UPDATE_VO
		= "update notices set type = ?, title = ?, content = ? where id = ?";
	// Notice 삭제하기
	public static final String SQL_NOTICE_DELETE_VO
		= "delete notices where id = ?";
	// Notice 페이지 조회
	public static final String SQL_NOTICE_SHOWALL_PG
		= "SELECT * FROM notices order by id desc limit ?, ?";
	// Notice 갯수 카운트
	public static final String SQL_CHECK_NOTICE_NUMBERS
	= "select count(id) as cnt from notices";	
	
	
	// Comment Part

	// Comment 목록 보여주기
	public static final String SQL_COMMENT_SHOWALL
		= "select * from qna_comment order by created_at desc";
	// Comment 등록하기
	public static final String SQL_COMMENT_INSERT_VO
		= "insert into qna_comment values(0, ?, ?, ?, ?, ?, ?, ?, now())";
	// Comment 수정하기
	public static final String SQL_COMMENT_UPDATE_VO
		= "update qna_comment set cMIF = ? where id = ?";
	// Comment 삭제하기
	public static final String SQL_COMMENT_DELETE_VO
		= "delete qna_comment where id = ?";
	// Comment 페이지 조회
	public static final String SQL_COMMENT_SHOWALL_PG
		= "SELECT * FROM qna_comment order by id desc limit ?, ?";
	// Comment 갯수 카운트
	public static final String SQL_CHECK_COMMENT_NUMBERS
	= "select count(id) as cnt from qna_comment";	
		
	
	
	
	
	
	@Override
	public boolean insertNewQna(QnaVO qa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<QnaVO> selectOneQna(QnaVO qa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateQna(QnaVO qa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteQna(QnaVO qa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<QnaVO> showAllQnas(int offset, int limit) {
		return jtem.query(SQL_QNA_SHOWALL_PG, BeanPropertyRowMapper.newInstance(QnaVO.class), offset, limit);
	}

	@Override
	public int checkNumberOfQnas() {
		return jtem.queryForObject(SQL_CHECK_QNA_NUMBERS, Integer.class);
	}

	@Override
	public boolean insertNewQna(FaqVO fq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateFaq(FaqVO fq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFaq(FaqVO fq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<FaqVO> showAllFaqs(int offset, int limit) {
		return jtem.query(SQL_FAQ_SHOWALL_PG, BeanPropertyRowMapper.newInstance(FaqVO.class), offset, limit);
	}

	@Override
	public int checkNumberOfFaqs() {
		return jtem.queryForObject(SQL_CHECK_FAQ_NUMBERS, Integer.class);
	}

	@Override
	public boolean insertNewNotice(NoticeVO nt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<NoticeVO> selectOneNotice(NoticeVO nt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateNotice(NoticeVO nt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteNotice(NoticeVO nt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<NoticeVO> showAllNotices(int offset, int limit) {
		return jtem.query(SQL_NOTICE_SHOWALL_PG, BeanPropertyRowMapper.newInstance(NoticeVO.class), offset, limit);
	}

	@Override
	public int checkNumberOfNotices() {
		return jtem.queryForObject(SQL_CHECK_NOTICE_NUMBERS, Integer.class);
	}

	@Override
	public boolean insertNewComment(QnaCommentVO cm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateComment(QnaCommentVO cm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteComment(QnaCommentVO cm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List <QnaCommentVO> showAllComments(int offset, int limit) {
		return jtem.query(SQL_COMMENT_SHOWALL_PG, BeanPropertyRowMapper.newInstance(QnaCommentVO.class), offset, limit);
	}

	@Override
	public int checkNumberOfComments() {
		return jtem.queryForObject(SQL_CHECK_COMMENT_NUMBERS, Integer.class);
	}

}
