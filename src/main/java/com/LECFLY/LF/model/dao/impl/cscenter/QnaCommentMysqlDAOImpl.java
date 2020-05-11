package com.LECFLY.LF.model.dao.impl.cscenter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.cscenter.IQnaCommentDAO;
import com.LECFLY.LF.model.vo.QnaCommentVO;


@Repository
public class QnaCommentMysqlDAOImpl implements IQnaCommentDAO{
	@Autowired
	private JdbcTemplate jtem;
	
	public static String SQL_INSERT_COMMENT 
		= "insert into qna_comment values(null,?,0,?,?,now(),now())";
	public static String SQL_SELECT_ALL_COMMENTS 
		= "select * from qna_comment order by created_at desc";
	// 컴패션 2차정렬? 
	public static String SQL_SELECT_ALL_COMMENTS_QNA 
		= "select * from qna_comment where qna_id = ? order by created_at desc";
	public static String SQL_COUNT_COMMENTS_QNA	
		= "select count(*) from qna_comment where qna_id = ?";
	@Override
	public boolean qnaCommentAdd(QnaCommentVO qc) {
		int r = jtem.update(SQL_INSERT_COMMENT, qc.getContent(),
				qc.getQnaId(), qc.getMbId());
		return r == 1;
	}
	
	@Override
	public boolean qnaCommentAdd(String content, int qnaId, int mbId, String mbLogin) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<QnaCommentVO> qnaCommentList() {
		return jtem.query(SQL_SELECT_ALL_COMMENTS,BeanPropertyRowMapper.newInstance(QnaCommentVO.class));
	}
	@Override
	public List<QnaCommentVO> qnaCommentListForQna(int qnaId) {
		return jtem.query(SQL_SELECT_ALL_COMMENTS_QNA,BeanPropertyRowMapper.newInstance(QnaCommentVO.class));
		}
	@Override
	public QnaCommentVO qnaCommentSelectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean qnaCommentUpdate(QnaCommentVO qc) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean qnaCommentRemove(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Integer[] checkNumberOfQnaComments() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int checkNumberOfQnaCommentsForQna(int qnaId) {
		return jtem.queryForObject(SQL_COUNT_COMMENTS_QNA,
				Integer.class, qnaId);
	}
	@Override
	public int checkNumberOfQnaCommentsForMember(int mbId) {
		// TODO Auto-generated method stub
		return 0;
	}		
	
	
}
