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
	public static String SQL_NOTICE_READ_INC
		= "update notices set hits = hits + 1 where id = ?";
	// Notice 목록(고객센터게시판) 보여주기
	public static String SQL_NOTICE_SHOWALL
		= "select * from notices where type like '0' order by created_day desc";
	// Notice 상세조회
	public static String SQL_NOTICE_SHOWONE
		= "select * from notices where id = ?";
	// Notice 등록하기
	public static String SQL_NOTICE_INSERT_VO
		= "insert into notices values(0, ?, ?, ?, ?, now(), now(), ?)";
	// Notice 수정하기
	public static String SQL_NOTICE_UPDATE_VO
		= "update notices set type = ?, title = ?, content = ?, updated_day = now() where id = ?";
	// Notice 삭제하기
	public static String SQL_NOTICE_DELETE_VO
		= "delete notices where id = ?";
	// Notice 페이지 조회
	public static String SQL_NOTICE_SHOWALL_PG
		= "SELECT * FROM notices order by created_day desc limit ?, ?";
	// Notice 갯수 카운트
	public static String SQL_CHECK_NOTICE_NUMBERS
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
		int r = jtem.update(SQL_NOTICE_INSERT_VO,
				nt.getMbId(), nt.getType(), nt.getTitle(), 
				nt.getContent(), nt.getFile(), nt.getHits());
		return r == 1; //? true: false;
	}

	@Override
	public int insertNewNoticeReturnKey(NoticeVO nt) {
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("mbId", nt.getMbId());
		paramMap.put("type", nt.getType());
		paramMap.put("title", nt.getTitle());
		paramMap.put("content", nt.getContent());
		paramMap.put("file", nt.getFile());
		paramMap.put("hits", nt.getHits());
		
		Number num = simIn.executeAndReturnKey(paramMap);
		return num.intValue(); // <<PK>> id 리턴	
	}

	@Override
	public int insertNewNoticeReturnKey2(NoticeVO nt) {
		KeyHolder kh = new GeneratedKeyHolder();
		PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt  = con.prepareStatement( SQL_NOTICE_INSERT_VO, new String[] {"id"});
				pstmt.setInt(1, nt.getMbId());
				pstmt.setInt(2, nt.getType());
				pstmt.setString(3, nt.getTitle());
				pstmt.setString(4, nt.getContent());
				pstmt.setString(5, nt.getFile());
				pstmt.setInt(6, nt.getHits());
				return pstmt;
			}
		};
		jtem.update(psc, kh);
		Number r = kh.getKey(); // PK
		return r.intValue();
	}

	@Override
	public boolean insertNewNotice(int mbId, int type, String title, String content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NoticeVO selectOneNotice(int id) {
		return jtem.queryForObject(SQL_NOTICE_SHOWONE,BeanPropertyRowMapper.newInstance(NoticeVO.class), id);
	}

	@Override
	public boolean updateNotice(int id, int type, String title, String content) {
		int r = jtem.update(SQL_NOTICE_UPDATE_VO, id, type, title, content);
		return r == 1;
	}
	
	@Override
	public boolean updateNotice(NoticeVO vo) {
		int r = jtem.update(SQL_NOTICE_UPDATE_VO, 
				vo.getId(),
				vo.getType(),
				vo.getTitle(), 
				vo.getContent());
		return r == 1;
	}
	
	@Override
	public boolean increaseReadCount(int id) {
		int r = jtem.update(SQL_NOTICE_READ_INC, id);
		return r == 1;
	}

	@Override
	public boolean deleteNotice(int id) {
		// TODO Auto-generated method stub
		return false;
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
