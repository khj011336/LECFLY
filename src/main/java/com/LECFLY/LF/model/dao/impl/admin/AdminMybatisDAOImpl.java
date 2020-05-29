package com.LECFLY.LF.model.dao.impl.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.admin.IAdminLectureDAO;
import com.LECFLY.LF.model.vo.admin.PayHistoryVO;
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
	// 강의 상세 조회
	@Override
	public List<LectureVO> selectLectureListSearchFilter(Map<String, Object> condition) {
		List<LectureVO> list = sstem.selectList("IAdminDAO.SQL_SELECT_LECTURE_BY_FILTER_PG", condition);
		return list;
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
	// 체크리스트 강의 승인
	@Override
	public boolean updateLectureApprovalforIds(ArrayList<Integer> checkList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", checkList);
		return sstem.update("IAdminDAO.SQL_UPDATE_LECTURE_APPROVAL_IDS", map) == 1;
	}
	// 체크리스트 강의 승인 거절
	@Override
	public boolean updateLectureDisapprovalforIds(ArrayList<Integer> checkList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", checkList);
		return sstem.update("IAdminDAO.SQL_UPDATE_LECTURE_DISAPPROVAL_IDS", map) == 1;
	}
	// 체크리스트 강의 삭제
	@Override
	public boolean deleteLectureforIds(ArrayList<Integer> checkList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", checkList);
		return sstem.delete("IAdminDAO.SQL_DELETE_LECTURE_IDS", map) == 1;
	}
	// 상세 강의 수 검색 
	@Override
	public int checkNumberOfLecturesSearch(Map<String, Object> searchMap) {
		int totalRecords = sstem.selectOne("IAdminDAO.SQL_SELECT_LECTURE_NUMBER_SEARCH", searchMap);
		return totalRecords;
	}

	// 전체조회 승인대기순
	@Override
	public List<LectureVO> searchLectureByApproval(int offset, int limit) {
		Map<String,Object> map = new HashMap<>();
		map.put("offset", offset);
		map.put("limit", limit);
		return sstem.selectList("IAdminDAO.SQL_SELECT_LECTURE_ALL_PG_APPROVAL",map);
	}
	// 전체조회 인기순

	@Override
	public List<LectureVO> searchLectureByLike(int offset, int limit) {
		Map<String,Object> map = new HashMap<>();
		map.put("offset", offset);
		map.put("limit", limit);
		return sstem.selectList("IAdminDAO.SQL_SELECT_LECTURE_ALL_PG_LIKE",map);
	}
	// 전체조회 승인완료순
	@Override
	public List<LectureVO> searchLectureByApprovalDone(int offset, int limit) {
		Map<String,Object> map = new HashMap<>();
		map.put("offset", offset);
		map.put("limit", limit);
		return sstem.selectList("IAdminDAO.SQL_SELECT_LECTURE_ALL_PG_APPROVAL_DONE",map);
	}

	@Override
	public boolean updateMemberApprovalforIds(ArrayList<Integer> checkList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", checkList);
		return sstem.update("IAdminDAO.SQL_UPDATE_MEMBER_APPROVAL_IDS", map) == 1;
	}

	@Override
	public boolean updateCreatorApprovalforIds(ArrayList<Integer> checkList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", checkList);
		return sstem.update("IAdminDAO.SQL_UPDATE_CREATOR_APPROVAL_IDS", map) == 1;
	}

	@Override
	public boolean updateMemberDisapprovalforIds(ArrayList<Integer> checkList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", checkList);
		return sstem.update("IAdminDAO.SQL_UPDATE_MEMBER_DISAPPROVAL_IDS", map) == 1;
	}

	@Override
	public boolean updateCreatorDisapprovalforIds(ArrayList<Integer> checkList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", checkList);
		return sstem.update("IAdminDAO.SQL_UPDATE_CREATOR_DISAPPROVAL_IDS", map) == 1;
	}

	@Override
	public boolean deleteMemberforIds(ArrayList<Integer> checkList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", checkList);
		return sstem.delete("IAdminDAO.SQL_DELETE_MEMBER_IDS", map) == 1;
	}

	@Override
	public boolean deleteCreatorforIds(ArrayList<Integer> checkList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ids", checkList);
		return sstem.delete("IAdminDAO.SQL_DELETE_CREATOR_IDS", map) == 1;
	}

	@Override
	public int checkNumberOfPayment() {
		return sstem.selectOne("IAdminDAO.SQL_SELECT_PAYMENT_NUMBER");
	}

	@Override
	public List<PayHistoryVO> searchPaymentForAll(int offset, int limit) {
		Map<String,Object> map = new HashMap<>();
		map.put("offset", offset);
		map.put("limit", limit);
		return sstem.selectList("IAdminDAO.SQL_SELECT_PAYMENT_ALL_PG",map);
	}

	@Override
	public int checkNumberOfCoupon() {
		return sstem.selectOne("IAdminDAO.SQL_SELECT_COUPON_NUMBER");
	}

	@Override
	public List<CouponVO> searchCouponForAll(int offset, int limit) {
		Map<String,Object> map = new HashMap<>();
		map.put("offset", offset);
		map.put("limit", limit);
		return sstem.selectList("IAdminDAO.SQL_SELECT_COUPON_ALL_PG",map);
	}

	@Override
	public int checkNumberOfKit() {
		return sstem.selectOne("IAdminDAO.SQL_SELECT_KIT_NUMBER");
	}

	@Override
	public List<KitVO> searchKitForAll(int offset, int limit) {
		Map<String,Object> map = new HashMap<>();
		map.put("offset", offset);
		map.put("limit", limit);
		return sstem.selectList("IAdminDAO.SQL_SELECT_KIT_ALL_PG",map);
	}

	@Override
	public List<PayHistoryVO> searchPaymentForAllOld(int offset, int limit) {
		Map<String,Object> map = new HashMap<>();
		map.put("offset", offset);
		map.put("limit", limit);
		return sstem.selectList("IAdminDAO.SQL_SELECT_PAYMENT_ALL_PG_OLD",map);
	}
}
