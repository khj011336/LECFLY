package com.LECFLY.LF.model.dao.impl.creator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.creator.ILectureDAO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
@Repository
public class LectureMysqlDAOImpl implements ILectureDAO {
	@Autowired
	JdbcTemplate jtem;
	final String SELECT_LECTURES_limit = "select * from lectures where fid = ? order by created_at desc  limit ?,? ";
	final String SELECT_LECTURES = "select * from lecfly_db order by blank where fid = ?";
	final String CHECK_NUMBER_LECTURES = "select count(*) as cp_mb from lecfly_db ";
	@Override
	public boolean isCreator(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertNewLecture(LectureVO Lvo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertNewLecture(int category, String subTitle, String title, String titleImg, String infoImg,
			String info) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLecture() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLectureStatus(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLecture() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LectureVO> selectLectureList(int id, boolean order) {
		return jtem.query( SELECT_LECTURES, BeanPropertyRowMapper.newInstance(LectureVO.class),id,order);

	}

	@Override
	public List<LectureVO> selectLectureList(int id, int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LectureVO> selectLectureList(int id, int offset, int limit, int order) {
		return jtem.query(SELECT_LECTURES_limit, new Object[] {id,offset,limit},BeanPropertyRowMapper.newInstance(LectureVO.class) );
		
	}

	@Override
	public int checkNumberOfLectures(int fid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
