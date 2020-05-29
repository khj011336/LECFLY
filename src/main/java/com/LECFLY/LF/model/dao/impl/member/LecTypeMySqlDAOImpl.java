package com.LECFLY.LF.model.dao.impl.member;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.member.ILecTypeDAO;
import com.LECFLY.LF.model.vo.LecTypeVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.mysql.jdbc.PreparedStatement;

@Repository
public class LecTypeMySqlDAOImpl implements ILecTypeDAO {
	
	@Autowired
	private JdbcTemplate jtem; 
	
	public static final String SQL_INSERT_NEW_LEC_TYPE_BY_VO = 
			"insert into lec_types values( null, ?, ?, ?, now() )";
	
	public static final String SQL_SELECT_ALL_LEC_TYPE_BY_MBID_STATUS = 
			"select * from lec_types where mb_id = ? and status = ?";
	
	
	class LecTypeMySqlImplRowMapper implements RowMapper<LecTypeVO> {

		@Override
		public LecTypeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt("id");
			int mbId = rs.getInt("mb_id");
			int status = rs.getInt("status");
			int classId = rs.getInt("class_id");
			Timestamp createAt = rs.getTimestamp("create_at");
			LecTypeVO lt = new LecTypeVO(id, mbId, status, classId, createAt);
			return lt;
		}
		
	}
	
	@Override
	public int insertNewLecTypeRtPK(LecTypeVO lt) {
//		KeyHolder kh = new GeneratedKeyHolder();
//		PreparedStatementCreator psc = new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				//PreparedStatement pstmt = con.prepareStatement(SQL_INSERT_NEW_LEC_TYPE_BY_VO, new String[] {"id"});
//				pstmt.setInt( 1, lt.getMbId() );
//				pstmt.setInt( 2, lt.getStatus() );
//				pstmt.setInt( 3, lt.getClassId() );
//				
//				return pstmt;
//			}
//			
//		};
//		jtem.update(psc, kh);
//		Number r = kh.getKey();
//		return r.intValue()
		return -1;
	};
	
	
	
	@Override
	public List<LecTypeVO> selectAllLecTypeByMbIdStatus(int mbId, int status) {
		System.out.println("dao : selectAllLecTypeByMbIdStatus()..");
		System.out.println(" / mbId = " + mbId + "/ status = " + status);
		try {
			System.out.println(SQL_SELECT_ALL_LEC_TYPE_BY_MBID_STATUS +  // 이게오히려하나짜리여야되네
							" / mbId = " + mbId + "/ status = " + status );
			return jtem.query(SQL_SELECT_ALL_LEC_TYPE_BY_MBID_STATUS, 
					BeanPropertyRowMapper.newInstance(LecTypeVO.class), mbId, status);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException...");
			e.printStackTrace();
		}
		return null;
	}

	public static final String SQL_COUNT_LEC_TYPE_BY_MBID_STATUS = 
			"select count(*) from lec_types where mb_id = ? and status = ?";

	@Override
	public int checkNumberOfLectureByMbIdStatus(int mbId, int status) {
		try {
			System.out.println(SQL_COUNT_LEC_TYPE_BY_MBID_STATUS +
					 " / mbId = " + mbId + " / status = " + status);
			return jtem.queryForObject(SQL_COUNT_LEC_TYPE_BY_MBID_STATUS, Integer.class, mbId, status);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException.. ");
			e.printStackTrace();
		}
		return 0;
	}
	
}