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
import com.LECFLY.LF.model.vo.NoticeVO;


@Repository
public class NoticeMysqlDAOImpl implements INoticeDAO{
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
		= "SELECT * FROM notices order by created_at desc limit ?, ?";
	// Notice 갯수 카운트
	public static final String SQL_CHECK_NOTICE_NUMBERS
	= "select count(id) as cnt from notices";	
	
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
	public boolean insertNewNotice(NoticeVO nt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insertNewNoticeReturnKey(NoticeVO nt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertNewNoticeReturnKey2(NoticeVO nt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean insertNewNotice(int type, String title, String content, String file) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NoticeVO selectOneNotice(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateNotice(int type, String title, String content, String file) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean increaseReadCount(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteNotice(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<NoticeVO> showAllNotices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeVO> showAllNotices(boolean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeVO> showAllNotices(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeVO> showAllNotices(int offset, int limit, boolean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkNumberOfNotices() {
		// TODO Auto-generated method stub
		return 0;
	}	
		
	
}
