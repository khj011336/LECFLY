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

import com.LECFLY.LF.model.dao.inf.cscenter.INoticeDAO;
import com.LECFLY.LF.model.vo.cscenter.NoticeVO;


@Repository
public class NoticeMysqlDAOImpl implements INoticeDAO{
	// Notice 조회수 증가
	public static String SQL_NOTICE_READ_INC
		= "update notices set hits = hits + 1 where id = ?";
	// Notice 목록(고객센터게시판) 보여주기
	public static String SQL_NOTICE_SHOWALL
		= "select * from notices where type like '0' order by id desc";
	// Notice 상세조회
	public static String SQL_NOTICE_SHOWONE
		= "select * from notices where id = ?";
//	// Notice 등록하기
//	public static String SQL_NOTICE_INSERT_VO
//		= "insert into notices values(0, ?, ?, ?, ?, now(), now(), ?)";
//	// Notice 수정하기
//	public static String SQL_NOTICE_UPDATE_VO
//		= "update notices set type = ?, title = ?, content = ?, updated_day = now() where id = ?";
//	// Notice 삭제하기
//	public static String SQL_NOTICE_DELETE_VO
//		= "delete notices where id = ?";
	// Notice 페이지 조회
	public static String SQL_NOTICE_SHOWALL_PG
		= "SELECT * FROM notices where type like '0' order by id desc limit ?, ?";
	// Notice 갯수 카운트
	public static String SQL_CHECK_NOTICE_NUMBERS
	= "select count(*) from notices where type like concat('%',0,'%')";	
	
	//@Autowired
	private JdbcTemplate jtem;	
	private SimpleJdbcInsert simIn;
	
	public NoticeMysqlDAOImpl() {}
	
	@Autowired
	public NoticeMysqlDAOImpl(JdbcTemplate jtem) {
		this.jtem = jtem;		
		this.simIn = 
		 new SimpleJdbcInsert(jtem.getDataSource());
		simIn.withTableName("Notices");
		simIn.usingGeneratedKeyColumns("id");
	}
	
	@Override
	public NoticeVO selectOneNotice(int id) {
		return jtem.queryForObject(SQL_NOTICE_SHOWONE,BeanPropertyRowMapper.newInstance(NoticeVO.class), id);
	}
		
	@Override
	public boolean increaseReadCount(int id) {
		int r = jtem.update(SQL_NOTICE_READ_INC, id);
		return r == 1;
	}

	@Override
	public List<NoticeVO> showAllNotices() {
		// VO <==> TBL
		return jtem.query(SQL_NOTICE_SHOWALL, BeanPropertyRowMapper.newInstance(NoticeVO.class));
	}

	@Override
	public List<NoticeVO> showAllNotices(boolean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeVO> showAllNotices(int offset, int limit) {
		return jtem.query(SQL_NOTICE_SHOWALL_PG, BeanPropertyRowMapper.newInstance(NoticeVO.class), offset, limit);

	}

	@Override
	public List<NoticeVO> showAllNotices(int offset, int limit, boolean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkNumberOfNotices() {
		return jtem.queryForObject(SQL_CHECK_NOTICE_NUMBERS, Integer.class);
	}

	
}
