package com.LECFLY.LF.model.dao.impl.creator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.creator.ILectureDAO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;

@Repository
public class LectureMysqlDAOImpl implements ILectureDAO {
	@Autowired
	JdbcTemplate jtem;
	final String SELECT_LECTURES_limit = "select * from lectures where fid = ? order by created_at desc  limit ?,? ";
	final String SELECT_LECTURES = "select * from lectures where id = ? order by id desc ";
	final String SELECT_LECTURES_FOR_STAT = "select * from lectures where fid = ? order by id desc ";
	final String SELECT_ONE_LECTURE = "select * from lectures where id = ?";
	final String CHECK_NUMBER_LECTURES = "select count(*) as cp_mb from lectures where fid =? ";
	final String INSERT_NEW_LECTURE = "insert into lectures values(null , ? , ?, ? , ? ,? ,?,?,?,?,null,0,0,?,?,now(),now());";
	final String UPDATE_NEW_LECTURE = "update lectures set category = ?, subtitle = ?, title = ?, title_img = ? ,info_img = ? , info_imgb = ? ,"
			+ "info = ? , status = ? , updated_at = now() , img_path  =  ? , nickname = ? where id = ?";
	final String UPDATE_ONLY_LECTURE = "update lectures set category = ?, subtitle = ?, title = ?, title_img = ? ,info_img = ? , info_imgb = ? ,"
			+ "info = ? , status = ? , updated_at = now()  where id = ?";

	@Override
	public boolean insertNewLecture(LectureVO Lvo) {
		int r = jtem.update(INSERT_NEW_LECTURE, Lvo.getFid(), Lvo.getSubTitle(), Lvo.getTitle(), Lvo.getTitleImg(),
				Lvo.getInfoImg(), Lvo.getInfoImg(), Lvo.getInfoImgb(), Lvo.getInfo(), Lvo.getStatus(),
				Lvo.getNickname(), Lvo.getImgPath());
		return r == 1;
	}

	public boolean insertNewLecture(int fid, int category, String subTitle, String title, String titleImg,
			String infoImg, String infoImgb, String info, int status, String nickname, String imgpath) {
		int r = jtem.update(INSERT_NEW_LECTURE, fid, category, subTitle, title, titleImg, infoImg, infoImgb, info,
				status, nickname, imgpath);
		return r == 1;
	}

	public LectureVO selectOneLectureForUpdate(int Lectureid) {
		try {
			return jtem.queryForObject(SELECT_ONE_LECTURE, BeanPropertyRowMapper.newInstance(LectureVO.class),
					Lectureid);
		} catch (DataAccessException e) {
			System.out.println("셀렉트 렉쳐 에러");
			System.out.println(e);
			return null;
		}
	}

	@Override
	public boolean updateLecture(LectureVO lecVO, CreatorVO crVO, int id) {
		int r = jtem.update(UPDATE_NEW_LECTURE, lecVO.getCategory(), lecVO.getSubTitle(), lecVO.getTitle(),
				lecVO.getTitleImg(), lecVO.getInfoImg(), lecVO.getInfoImgb(), lecVO.getInfo(), lecVO.getStatus(),
				crVO.getImgPath(), crVO.getNickname(), id);
		return r == 1;
	}

	@Override
	public boolean updateOnlyLecuture(LectureVO lecVO, int id) {
		int r = jtem.update(UPDATE_ONLY_LECTURE, lecVO.getCategory(), lecVO.getSubTitle(), lecVO.getTitle(),
				lecVO.getTitleImg(), lecVO.getInfoImg(), lecVO.getInfoImgb(), lecVO.getInfo(), lecVO.getStatus(), id);
		return r == 1;
	}

	@Override
	public LectureVO selectLecture(int id) {
		return jtem.queryForObject(SELECT_LECTURES, BeanPropertyRowMapper.newInstance(LectureVO.class), id);
	}
	@Override
	public List<LectureVO> selectLectureListForSTAT(int id) {
		return jtem.query(SELECT_LECTURES_FOR_STAT, BeanPropertyRowMapper.newInstance(LectureVO.class), id);
	}
 

	@Override
	public List<LectureVO> selectLectureList(int id, int offset, int limit, int order) {
		return jtem.query(SELECT_LECTURES_limit, new Object[] { id, offset, limit },
				BeanPropertyRowMapper.newInstance(LectureVO.class));
	}

	@Override
	public int checkNumberOfLectures(int fid) {
		return jtem.queryForObject(CHECK_NUMBER_LECTURES, Integer.class, fid);
	}

}
