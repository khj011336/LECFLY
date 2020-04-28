package com.LECFLY.LF.model.dao.impl.Creator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.creator.ILectureDAO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
@Repository
public class LectureMysqlDAOImpl implements ILectureDAO {
	@Autowired
	JdbcTemplate jtem;
	
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
	public List<LectureVO> showLectureList(int id, boolean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LectureVO> showLectureList(int id, int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LectureVO> showLectureList(int id, int offset, int limit, boolean order) {
		// TODO Auto-generated method stub
		return null;
	}

}
