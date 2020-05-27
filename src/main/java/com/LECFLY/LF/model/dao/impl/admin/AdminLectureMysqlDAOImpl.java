package com.LECFLY.LF.model.dao.impl.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.admin.IAdminLectureDAO;
import com.LECFLY.LF.model.vo.cart.CouponVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.model.vo.virtual.CategoryLectureStatVO;

@Repository("jdbcAdminLecture")
public class AdminLectureMysqlDAOImpl implements IAdminLectureDAO{

	@Autowired
	private JdbcTemplate jtem;
	
	/** 전체 강의목록 조회 */
	public static String SQL_ADMIN_SELECT_LECTURE_ALL = 
			"SELECT * FROM LECTURES ORDER BY ID ASC";
	/** 전체 강의갯수 조회 */
	public static String SQL_SELECT_LECTURE_NUMBER = 
			"SELECT COUNT(ID) FROM LECTURES";
	/** 전체 강의목록 조회(페이지별) */
	public static String SQL_SELECT_LECTURE_ALL_PG = 
			"SELECT * FROM LECTURES ORDER BY ID DESC LIMIT ?,?";
	/** 전체 영상목록 조회(페이지별) */
	public static String SQL_SELECT_VIDEO_ALL_PG = 
			"SELECT * FROM VIDEO ORDER BY ID DESC LIMIT ?,?";
	/** 전체 영상갯수 조회 */
	public static String SQL_SELECT_VIDEO_NUMBER = 
			"SELECT COUNT(ID) FROM VIDEO";
	@Override
	public boolean insertLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LectureVO selectLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LectureVO> selectLectureList() {
		return jtem.query(SQL_ADMIN_SELECT_LECTURE_ALL, BeanPropertyRowMapper.newInstance(LectureVO.class));
	}

	@Override
	public boolean insertVideo(VideoVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateVideo(VideoVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteVideo(VideoVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VideoVO selectVideo(VideoVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VideoVO> selectVideoList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertKit(KitVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateKit(KitVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteKit(KitVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public KitVO selectKit(KitVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KitVO> selectKitList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertCoupon(CouponVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCoupon(CouponVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCoupon(CouponVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CouponVO selectCoupon(CouponVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CouponVO> selectCouponList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkNumberOfLectures() {
		return jtem.queryForObject(SQL_SELECT_LECTURE_NUMBER, Integer.class);
	}

	@Override
	public List<LectureVO> searchLectureForAll(int offset, int limit) {
		return jtem.query(SQL_SELECT_LECTURE_ALL_PG, BeanPropertyRowMapper.newInstance(LectureVO.class),
				offset, limit);
	}

	@Override
	public List<VideoVO> searchVideoForAll(int offset, int limit) {
		return jtem.query(SQL_SELECT_VIDEO_ALL_PG, BeanPropertyRowMapper.newInstance(VideoVO.class), offset, limit);
	}

	@Override
	public int checkNumberOfVideos() {
		return jtem.queryForObject(SQL_SELECT_VIDEO_NUMBER, Integer.class);
	}

	@Override
	public List<LectureVO> selectLectureListSearchFilter(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectLectureApproval() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectLectureAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectTodayInCnt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectMemberCnt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectCreatorCnt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectNewMemberCnt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectCreatorApprovalCnt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectQnaCommentCnt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkNumberOfLecturesSearch(Map<String, Object> searchMap) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CategoryLectureStatVO> selectCategoryLectureCnt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateLectureApprovalforIds(ArrayList<Integer> checkList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLectureDisapprovalforIds(ArrayList<Integer> checkList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delectLectureforIds(ArrayList<Integer> checkList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LectureVO> searchLectureByApproval(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LectureVO> searchLectureByLike(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LectureVO> searchLectureByApprovalDone(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}



}
