package com.LECFLY.LF.model.dao.impl.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.admin.IAdminLectureDAO;
import com.LECFLY.LF.model.vo.cart.CouponVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.model.vo.virtual.CategoryLectureStatVO;

@Repository("mybatisAdmin")
public class AdminMybatisDAOImpl implements IAdminLectureDAO{

	@Autowired
	private SqlSessionTemplate sstem;
	
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
		return null;
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
		return sstem.selectOne("IAdminDAO.SQL_SELECT_LECTURE_NUMBER");
	}

	@Override
	public List<LectureVO> searchLectureForAll(int offset, int limit) {
		Map<String,Object> map = new HashMap<>();
		map.put("offset", offset);
		map.put("limit", limit);
		return sstem.selectList("IAdminDAO.SQL_SELECT_LECTURE_ALL_PG",map);
	}

	@Override
	public List<VideoVO> searchVideoForAll(int offset, int limit) {
		Map<String,Object> map = new HashMap<>();
		map.put("offset", offset);
		map.put("limit", limit);
		return sstem.selectList("IAdminDAO.SQL_SELECT_VIDEO_ALL_PG",map);
	}

	@Override
	public int checkNumberOfVideos() {
		return sstem.selectOne("IAdminDAO.SQL_SELECT_VIDEO_NUMBER");
	}

	@Override
	public int checkNumberOfLecturesSearchFilter(Map<String, Object> condition) {
		return sstem.selectOne("IAdminDAO.SQL_SELECT_LECTURE_NUMBER_BY_FILTER", condition);
	}

	@Override
	public List<LectureVO> selectLectureListSearchFilter(Map<String, Object> condition) {
		return sstem.selectList("IAdminDAO.SQL_SELECT_LECTURE_BY_FILTER_PG", condition);
	}
	
	
	// 관리자 메인 통계
	// 방문자수
	@Override
	public int selectTodayInCnt() {
		return sstem.selectOne("IAdminDAO.SQL_SELECT_TODAY_IN_CNT");
	}
	// 회원수
	@Override
	public int selectMemberCnt() {
		return sstem.selectOne("IAdminDAO.SQL_SELECT_MEMBER_CNT");
	}
	// 업로더수
	@Override
	public int selectCreatorCnt() {
		return sstem.selectOne("IAdminDAO.SQL_SELECT_CREATOR_CNT");
	}
	// 전체 강의수
	@Override
	public int selectLectureAll() {
		return sstem.selectOne("IAdminDAO.SQL_SELECT_LECTURE_CNT_ALL");
	}
	// 신규회원수
	@Override
	public int selectNewMemberCnt() {
		return sstem.selectOne("IAdminDAO.SQL_SELECT_NEW_MEMBER_CNT");
	}
	// 업로더 승인대기수 
	@Override
	public int selectCreatorApprovalCnt() {
		return sstem.selectOne("IAdminDAO.SQL_SELECT_CREATOR_APPROVAL_CNT");
	}
	// 강의 승인대기수	
	@Override
	public int selectLectureApproval() {
		return sstem.selectOne("IAdminDAO.SQL_SELECT_LECTURE_APPROVAL_CNT");
	}
	// 문의 답변하기 수	
	@Override
	public int selectQnaCommentCnt() {
		return sstem.selectOne("IAdminDAO.SQL_SELECT_QNA_COMMENT_CNT");
	}
	
	// 카테고리별 강의수
	@Override
	public List<CategoryLectureStatVO> selectCategoryLectureCnt() {
		return sstem.selectList("IAdminDAO.SQL_SELECT_CATEGORY_LECTURE");
	}
}
