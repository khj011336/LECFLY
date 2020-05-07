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

import com.LECFLY.LF.model.dao.inf.cscenter.IQnaDAO;
import com.LECFLY.LF.model.vo.QnaVO;

@Repository
public class QnaMysqlDAOImpl implements IQnaDAO{
	// 조회수 증가
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
		= "SELECT * FROM qnas order by created_at desc limit ?, ?";
	// QnA 갯수 카운트
	public static final String SQL_CHECK_QNA_NUMBERS
	= "select count(id) as cnt from qnas";	
	
	//@Autowired
	private JdbcTemplate jtem;	
	private SimpleJdbcInsert simIn;
	
	public QnaMysqlDAOImpl() {}
	
	@Autowired
	public QnaMysqlDAOImpl(JdbcTemplate jtem) {
		this.jtem = jtem;		
		this.simIn = 
		 new SimpleJdbcInsert(jtem.getDataSource());
		simIn.withTableName("qnas");
		simIn.usingGeneratedKeyColumns("id");
	}	
		
	@Override
	public boolean insertNewQna(QnaVO qa) {
		int r = jtem.update(SQL_QNA_INSERT_VO,
				qa.getMbId(), qa.getMbNicname(), qa.getType(), qa.getTitle(), 
				qa.getContent(), qa.getFile(), qa.getShowPrivate(), qa.getHits(), qa.getComment() );
		return r == 1; //? true: false;
	}

	@Override
	public int insertNewQnaReturnKey(QnaVO qa) {
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("mbId", qa.getMbId());
		paramMap.put("mbNicname", qa.getMbNicname());
		paramMap.put("type", qa.getType());
		paramMap.put("title", qa.getTitle());
		paramMap.put("content", qa.getContent());
		paramMap.put("file", qa.getFile());
		paramMap.put("showPrivqae", qa.getShowPrivate());
		paramMap.put("writedDay", new Date());
		paramMap.put("updatedDay", new Date());
		paramMap.put("hits", qa.getHits());
		paramMap.put("comment", qa.getComment());
		
		Number num = simIn.executeAndReturnKey(paramMap);
		return num.intValue(); // <<PK>> id 리턴	
	}

	@Override
	public int insertNewQnaReturnKey2(QnaVO qa) {
		KeyHolder kh = new GeneratedKeyHolder();
		PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt  = con.prepareStatement( SQL_QNA_INSERT_VO, new String[] {"id"});
				pstmt.setInt(1, qa.getMbId());
				pstmt.setInt(2, qa.getMbId());
				pstmt.setString(3, qa.getMbNicname());
				pstmt.setInt(4, qa.getType());
				pstmt.setString(5, qa.getTitle());
				pstmt.setString(6, qa.getContent());
				pstmt.setString(7, qa.getFile());
				pstmt.setInt(8, qa.getShowPrivate());
				pstmt.setInt(9, qa.getHits());
				pstmt.setInt(10, qa.getComment());
				return pstmt;
			}
		};
		jtem.update(psc, kh);
		Number r = kh.getKey(); // PK
		return r.intValue();
	}

	@Override
	public boolean insertNewQna(int mbId, String mbNicname, int type, String title, String content, int showPrivate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public QnaVO selectOneQna(int id) {
		return jtem.queryForObject(SQL_QNA_SHOWONE,BeanPropertyRowMapper.newInstance(QnaVO.class), id);
	}

	@Override
	public boolean updateQna(int id, int type, String title, String content, int showPrivate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean increaseReadCount(int id) {
		int r = jtem.update(SQL_QNA_READ_INC, id);
		return r == 1;
	}

	@Override
	public boolean deleteQna(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<QnaVO> showAllQnas() {
		// VO <==> TBL
		return jtem.query(SQL_QNA_SHOWALL, BeanPropertyRowMapper.newInstance(QnaVO.class));
	}

	@Override
	public List<QnaVO> showAllQnas(boolean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QnaVO> showAllQnas(int offset, int limit) {
		return jtem.query(SQL_QNA_SHOWALL_PG, BeanPropertyRowMapper.newInstance(QnaVO.class), offset, limit);

	}

	@Override
	public List<QnaVO> showAllQnas(int offset, int limit, boolean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkNumberOfQnas() {
		return jtem.queryForObject(SQL_CHECK_QNA_NUMBERS, Integer.class);
	}
	
}