package com.LECFLY.LF.model.dao.impl.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.member.ILecAttendDAO;
import com.LECFLY.LF.model.vo.LecAttendVO;

@Repository
public class LecAttendMySqlDAOImpl implements ILecAttendDAO {

	@Autowired
	private JdbcTemplate jtem;
	
	class LecAttendMySqlImplRowMapper implements RowMapper<LecAttendVO> {

		@Override
		public LecAttendVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			int id = rs.getInt("id");
			int mbId = rs.getInt("mb_id");
			int classId = rs.getInt("class_id");
			int videoId = rs.getInt("video_id");
			String videoName = rs.getString("video_name");
			String videoPic = rs.getString("video_pic");
			int viewingTime = rs.getInt("viewing_time");
			float untilShow = rs.getFloat("until_show");
			Timestamp showAt = rs.getTimestamp("show_at");
			
			LecAttendVO la = new LecAttendVO(id, mbId, classId, videoId, videoName, 
					videoPic, viewingTime, untilShow, showAt);
			
			return la;
		}
		
	}
	/** 처음에 클래스에서 비디오 클릭시 해야할것 영상이끝나면  until_show, show_at  업데이트할예정*/
	public static final String SQL_INSERT_NEW_LEC_ATTEND = 
			"insert into lec_attends values( null, ?, ?, ?, ?, ?, ?, 0, now() )"; //
	
	public static final String SQL_SELECT_ONE_LEC_ATTEND_BY_MBID_CLASSID = 
				"select * from lec_attends where mb_id = ? and class_id = ?";
	
	@Override
	public boolean insertNewLecAttend(int mbId, int classId, int videoId, int videoName, int videoPic) {
		System.out.println("insertNewLecAttend()");
		try {
			System.out.println( SQL_INSERT_NEW_LEC_ATTEND + " / mbId = " + mbId + 
					" / classId = " + classId + " / videoId = " + videoId + 
				" / videoName = " + videoName + " / videoPic = " + videoPic );
			int r = jtem.update(SQL_INSERT_NEW_LEC_ATTEND, mbId, classId, videoId, videoName, videoPic);
			return (r == 1);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException..");
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean insertNewLecAttendByVO(LecAttendVO la) {
		System.out.println("insertNewLecAttendByVO()");
		try {
			System.out.println(SQL_INSERT_NEW_LEC_ATTEND + " / mbId = " + la.getMbId() + 
						" / classId = " + la.getClassId() + " / videoId = " + la.getVideoId() + 
					" / videoName = " + la.getVideoName() + " / videoPic = " + la.getVideoPic());
			int r = jtem.update(SQL_INSERT_NEW_LEC_ATTEND, la.getMbId(), 
					la.getClassId(), la.getVideoId(), la.getVideoName(), la.getVideoPic());
			return (r == 1);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException..");
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Override
	public LecAttendVO selectOneLecAttendByMbIdClassId(int mbId, int classId) {
		System.out.println("selectOneLecAttendByMbIdClassId()");
		try {
			System.out.println(SQL_SELECT_ONE_LEC_ATTEND_BY_MBID_CLASSID + 
										"mbId = " + mbId + "classId = " + classId);
			return jtem.queryForObject(SQL_SELECT_ONE_LEC_ATTEND_BY_MBID_CLASSID, 
					new LecAttendMySqlImplRowMapper(), mbId, classId);
		} catch(DataAccessException e) {
			System.out.println("DataAccessException..");
			e.printStackTrace();
		}
		return null;
	}
	
}
