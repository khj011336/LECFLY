package com.LECFLY.LF.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

import com.LECFLY.LF.model.dao.inf.IShowClassVideoDAO;
import com.LECFLY.LF.model.vo.ShowClassVideoVO;
import com.fasterxml.jackson.databind.BeanProperty;

@Repository
public class ShowClassVideoMysqlImpl implements IShowClassVideoDAO {
	
	
	class ShowClassVideoRowMapperImpl implements RowMapper<ShowClassVideoVO> {

		@Override
		public ShowClassVideoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			ShowClassVideoVO scv = 
					new ShowClassVideoVO(rs.getInt("id"), rs.getInt("mb_id"), rs.getInt("status"), 
							rs.getInt("class_id"), rs.getInt("video_id"), rs.getString("video_name"), 
							rs.getString("video_pic"), rs.getInt("viewing_time"), 
							rs.getFloat("until_show"), rs.getTimestamp("show_at"));
			System.out.println("mapRow scv = " + scv);
			return scv;
		}
		
	}
	
	@Autowired
	private JdbcTemplate jtem;
	
	public static final String SQL_INSERT_NEW_SCV = 
			"insert into show_class_video valuse(null, ?, ?, ?, ?, ?, ?, ?, ?, now())";
	
	public static final String SQL_INSERT_NEW_SCV_STATUS_ATTENDING = 
			"insert into show_class_video valuse(null, ?, " + 
					ShowClassVideoVO.STATUS_ATTENDING + ", ?, ?, ?, ?, ?, ?, now())";
		
	public static final String SQL_INSERT_NEW_SCV_STATUS_WILL_ATTENDING = 
			"insert into show_class_video valuse(null, ?, " + 
					ShowClassVideoVO.STATUS_WILL_ATTENDING + ", ?, ?, ?, ?, ?, ?, now())";
	
	public static final String SQL_INSERT_NEW_SCV_STATUS_LIKE = 
			"insert into show_class_video valuse(null, ?, " + 
					ShowClassVideoVO.STATUS_LIKE + ", ?, ?, ?, ?, ?, ?, now())";
	
	public static final String SQL_SELECT_ALL_SCV_FOR_MBID_STATUS = 
				"select * from show_class_video where mb_id = ? and status = ?";
	
	public static final String SQL_SELECT_ALL_VDID_FOR_MBID_STATUS = 
			"select video_id from show_class_video where mb_id = ? and status = ?";
	
	public static final String SQL_CHECK_SVC_STATUS_ATTENDING = 
			"select count(*) from show_class_video where mb_id = ? and status = " + 
					ShowClassVideoVO.STATUS_ATTENDING + ", video_id = ?";
	
	public static final String SQL_CHECK_SVC_STATUS_WILL_ATTENDING = 
			"select count(*) from show_class_video where mb_id = ? and status = " + 
					ShowClassVideoVO.STATUS_WILL_ATTENDING + " and video_id = ?";
	
	public static final String SQL_CHECK_SVC_STATUS_LIKE = 
			"select count(*) from show_class_video where mb_id = ? and status = " + 
					ShowClassVideoVO.STATUS_LIKE + " and video_id = ?"; 
	
	public static final String SQL_DELETE_SVC = 
			"delete show_class_video where id = ?"; 
	
//	public static final String SQL_ = ""; 
	
	
	
	// 신규 추가할수있다
	
	@Override
	public boolean insertNewSCVStatusAttending(ShowClassVideoVO scv) {
		System.out.println("insertNewSCVStatusAttending()..");
		try {
			int r = jtem.update(SQL_INSERT_NEW_SCV_STATUS_ATTENDING, scv.getMbId(), 
					scv.getClassId(), scv.getVideoId(), scv.getVideoName(), 
					scv.getVideoPic(), scv.getViewingTime(), scv.getUntilShow());
			return (r == 1);
		} catch (DataAccessException e) {
			System.out.println("DataAccessException...");
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public boolean insertNewSCVStatusWillAttending(ShowClassVideoVO scv) {
		System.out.println("insertNewSCVStatusWillAttending()..");
		try {
			int r = jtem.update(SQL_INSERT_NEW_SCV_STATUS_WILL_ATTENDING, scv.getMbId(), 
					scv.getClassId(), scv.getVideoId(), scv.getVideoName(), 
					scv.getVideoPic(), scv.getViewingTime(), scv.getUntilShow());
			return (r == 1);
		} catch (DataAccessException e) {
			System.out.println("DataAccessException...");
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public boolean insertNewSCVStatusLike(ShowClassVideoVO scv) {
		System.out.println("insertNewSCVStatusLike()..");
		try {
			int r = jtem.update(SQL_INSERT_NEW_SCV_STATUS_LIKE, scv.getMbId(), 
					scv.getClassId(), scv.getVideoId(), scv.getVideoName(), 
					scv.getVideoPic(), scv.getViewingTime(), scv.getUntilShow());
			return (r == 1);
		} catch (DataAccessException e) {
			System.out.println("DataAccessException...");
			e.printStackTrace();
		}
		return false;
	}	
	
	@Override
	public boolean insertNewSCV(ShowClassVideoVO scv) {
		System.out.println("insertNewSCV()..");
		try {
			int r = jtem.update(SQL_INSERT_NEW_SCV, scv.getMbId(), scv.getStatus(), scv.getClassId(), scv.getVideoId(),
					scv.getVideoName(), scv.getVideoPic(), scv.getViewingTime(), scv.getUntilShow());
			return (r == 1);
		} catch (DataAccessException e) {
			System.out.println("DataAccessException...");
			e.printStackTrace();
			
		}
		return false;
	}
	
	@Override
	public boolean insertNewSCV(int mbId, int status, int classId, int videoId, String videoName, 
			String videoPic, int viewingTime, float untilShow) {
		System.out.println("insertNewSCV()..");
		try {
			int r = jtem.update(SQL_INSERT_NEW_SCV, mbId, status, classId, videoId,
					videoName, videoPic, viewingTime, untilShow);
			return (r == 1);
		} catch (DataAccessException e) {
			System.out.println("DataAccessException...");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int insertNewSCVRtPK(ShowClassVideoVO scv) {
		KeyHolder kh = new GeneratedKeyHolder();
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(SQL_INSERT_NEW_SCV);
				pstmt.setInt( 1, scv.getMbId() );
				pstmt.setInt( 1, scv.getStatus() );
				pstmt.setInt( 3, scv.getClassId() );
				pstmt.setInt( 4, scv.getVideoId() );
				pstmt.setString( 5, scv.getVideoName() );
				pstmt.setString( 6, scv.getVideoPic() );
				pstmt.setInt( 7, scv.getViewingTime() );
				pstmt.setFloat( 8, scv.getUntilShow() );
				return pstmt;
			}
		};
		try {
			jtem.update(psc, kh);
			Number r = kh.getKey();
			System.out.println( "keyhloder 방식 key = " + r );
			return r.intValue();
		} catch (DataAccessException e) {
			System.out.println("DataAccessException...");
			e.printStackTrace();
			return -1;
		}
	}
	
	@Override
	public boolean checkSCVStatusAttending(int mbId, int videoId) {
		try {
			int r = jtem.queryForObject(SQL_CHECK_SVC_STATUS_ATTENDING, 
					Integer.class ,mbId, videoId);
			System.out.println("r = " + r + " / r = 1이아니라면 return false");
			return (r == 1);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException...");
			e.printStackTrace();
			return false;
		}
	}
	
	
	@Override
	public boolean checkSCVStatusWillAttending(int mbId, int videoId) {
		try {
			int r = jtem.queryForObject(SQL_CHECK_SVC_STATUS_WILL_ATTENDING, 
						Integer.class ,mbId, videoId);
			System.out.println("r = " + r + " / r = 1이아니라면 return false");
			return (r == 1);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException...");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean checkSCVStatusLike(int mbId, int videoId) {
		try {
			int r = jtem.queryForObject(SQL_CHECK_SVC_STATUS_LIKE, 
					Integer.class ,mbId, videoId);
			System.out.println("r = " + r + " / r = 1이아니라면 return false");
			return (r == 1);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException...");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int insertNewSCVStatusAttendingRtPK(ShowClassVideoVO scv) {
		KeyHolder kh = new GeneratedKeyHolder();
		
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(SQL_INSERT_NEW_SCV_STATUS_ATTENDING);
				pstmt.setInt(1, scv.getMbId()); 
				pstmt.setInt(2, scv.getClassId()); 
				pstmt.setInt(3, scv.getVideoId());
				pstmt.setString(4, scv.getVideoName());
				pstmt.setString(5, scv.getVideoPic());
				pstmt.setInt(6, scv.getViewingTime());
				pstmt.setFloat(7, scv.getUntilShow());
				return pstmt;
			}
		};
		try {
			jtem.update(psc, kh);
			Number r = kh.getKey();
			System.out.println("kh.getKey() = " + r);
			return r.intValue();
		} catch(DataAccessException e) {
			System.out.println("DataAccessException...");
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int insertNewSCVStatusWillAttendingRtPK(ShowClassVideoVO scv) {
		KeyHolder kh = new GeneratedKeyHolder();
		
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(SQL_INSERT_NEW_SCV_STATUS_WILL_ATTENDING);
				pstmt.setInt(1, scv.getMbId()); 
				pstmt.setInt(2, scv.getClassId()); 
				pstmt.setInt(3, scv.getVideoId());
				pstmt.setString(4, scv.getVideoName());
				pstmt.setString(5, scv.getVideoPic());
				pstmt.setInt(6, scv.getViewingTime());
				pstmt.setFloat(7, scv.getUntilShow());
				return pstmt;
			}
		};
		try{
			jtem.update(psc, kh);
			Number r = kh.getKey();
			System.out.println("kh.getKey() = " + r);
			return r.intValue();
		} catch(DataAccessException e) {
			System.out.println("DataAccessException...");
			e.printStackTrace();
			return -1;
		}

	}

	@Override
	public int insertNewSCVStatusLikeRtPK(ShowClassVideoVO scv) {
		KeyHolder kh = new GeneratedKeyHolder();
		
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(SQL_INSERT_NEW_SCV_STATUS_LIKE);
				pstmt.setInt(1, scv.getMbId()); 
				pstmt.setInt(2, scv.getClassId()); 
				pstmt.setInt(3, scv.getVideoId());
				pstmt.setString(4, scv.getVideoName());
				pstmt.setString(5, scv.getVideoPic());
				pstmt.setInt(6, scv.getViewingTime());
				pstmt.setFloat(7, scv.getUntilShow());
				return pstmt;
			}
		};
		try {
			jtem.update(psc, kh);
			Number r = kh.getKey();
			System.out.println("kh.getKey() = " + r);
			return r.intValue();
		} catch(DataAccessException e) {
			System.out.println("DataAccessException...");
			e.printStackTrace();
			return -1;
		}
	}
	
	
	@Override
	public int insertNewSCVRtPK(int mbId, int status, int classId, int videoId, 
			String videoName, String videoPic, int viewingTime, float untilShow) {
		KeyHolder kh = new GeneratedKeyHolder();
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(SQL_INSERT_NEW_SCV);
				pstmt.setInt(1, mbId);
				pstmt.setInt(2, status);
				pstmt.setInt(3, classId);
				pstmt.setInt(4, videoId);
				pstmt.setString(5, videoName);
				pstmt.setString(6, videoPic);
				pstmt.setInt(7, viewingTime);
				pstmt.setFloat(8, untilShow);
				return pstmt;
			}
		};
		try{
			jtem.update(psc, kh);
			Number r = kh.getKey();
			System.out.println("kh.getKey() =" + r);
			return r.intValue();
		} catch(DataAccessException e) {
			System.out.println("DataAccessException...");
			e.printStackTrace();
			return -1;
		}
	}
	
	
	// 리스트로 조회할수있다
	@Override
	public List<ShowClassVideoVO> selectLecToStatusForMbId(int mbId, int status) {
		System.out.println("selectAllAttendingLecByMbId()...");
		try {
			System.out.println(SQL_SELECT_ALL_SCV_FOR_MBID_STATUS + 
					" / mb_id =" + mbId + " / status = " + status);
			List<ShowClassVideoVO> scvList =
					jtem.query(SQL_SELECT_ALL_SCV_FOR_MBID_STATUS, 
							new ShowClassVideoRowMapperImpl(), mbId, status);
			System.out.println("scvList = " + scvList);
			return scvList;
		} catch(DataAccessException e) {
			System.out.println("DataAccessException...");
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Integer> selectLecToStatusForMbIdRtVdPk(int mbId, int status) {
		try {
			List<Integer> vdIdList = jtem.queryForList(
					SQL_SELECT_ALL_VDID_FOR_MBID_STATUS, Integer.class, mbId, status);
			return vdIdList;
		} catch(DataAccessException e) {
			System.out.println("DataAccessException...");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteOneSCV(int scvId) {
		int r = jtem.update(SQL_DELETE_SVC, scvId);
		System.out.println("r = " + r + " / r = 1이아니라면 return false");
		return (r == 1);
	}
	
}
