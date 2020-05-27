package com.LECFLY.LF.service.impl.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.inf.admin.IAdminLectureDAO;
import com.LECFLY.LF.model.vo.cart.CouponVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.model.vo.virtual.CategoryLectureStatVO;
import com.LECFLY.LF.service.inf.admin.IAdminLectureSVC;

@Service
public class AdminLectureSVCImpl implements IAdminLectureSVC {

	@Autowired
	@Qualifier("mybatisAdmin")
	private IAdminLectureDAO adDAO;
	
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
		// TODO Auto-generated method stub
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
	public Map<String,Integer> checkLectureMaxPageNumber() {
		int totalRecords = adDAO.checkNumberOfLectures();
		int maxPg = totalRecords / AD_PAGE_SIZE + (
				totalRecords % AD_PAGE_SIZE == 0 ? 0 : 1 );
		HashMap<String,Integer> rMap = new HashMap<>();
		rMap.put("totalRecords", totalRecords);
		rMap.put("maxPg", maxPg);
		return rMap;
	}
	// 정렬 최신순
	@Override
	public List<LectureVO> selectAllLecture(int pageNumber) {
		int offset = (pageNumber -1)*AD_PAGE_SIZE;
		List<LectureVO> lecList = adDAO.searchLectureForAll(offset, AD_PAGE_SIZE);
		return lecList;
	}
	// 정렬 승인대기순
	@Override
	public List<LectureVO> selectAllLectureByApproval(int pageNumber) {
		int offset = (pageNumber -1)*AD_PAGE_SIZE;
		List<LectureVO> lecList = adDAO.searchLectureByApproval(offset, AD_PAGE_SIZE);
		return lecList;
	}
	// 정렬 승인대기순
	@Override
	public List<LectureVO> selectAllLectureByApprovalDone(int pageNumber) {
		int offset = (pageNumber -1)*AD_PAGE_SIZE;
		List<LectureVO> lecList = adDAO.searchLectureByApprovalDone(offset, AD_PAGE_SIZE);
		return lecList;
	}
	// 정렬 인기순
	@Override
	public List<LectureVO> selectAllLectureByLike(int pageNumber) {
		int offset = (pageNumber -1)*AD_PAGE_SIZE;
		List<LectureVO> lecList = adDAO.searchLectureByLike(offset, AD_PAGE_SIZE);
		return lecList;
	}	
	@Override
	public List<VideoVO> selectAllVideo(int pageNumber) {
		int offset = (pageNumber -1)*AD_PAGE_SIZE;
		List<VideoVO> vdList = adDAO.searchVideoForAll(offset, AD_PAGE_SIZE);
		return vdList;
	}

	@Override
	public Map<String, Integer> checkVideoMaxPageNumber() {
		int totalRecords = adDAO.checkNumberOfVideos();
		int maxPg = totalRecords / AD_PAGE_SIZE + (
				totalRecords % AD_PAGE_SIZE == 0 ? 0 : 1 );
		HashMap<String,Integer> rMap = new HashMap<>();
		rMap.put("totalRecords", totalRecords);
		rMap.put("maxPg", maxPg);
		return rMap;
	}

	@Override
	public List<LectureVO> selectLectureListSearchFilter(Map<String, Object> condition) {
		String pn = (String) condition.get("pn");
		int pageNumber = Integer.parseInt(pn);
		int offset =(pageNumber-1)*AD_PAGE_SIZE;
		condition.put("offset", offset);
		condition.put("limit", AD_PAGE_SIZE);
		System.out.println(condition);
		List<LectureVO> list = adDAO.selectLectureListSearchFilter(condition);
		System.out.println("결과수 : "+ list.size());
		return adDAO.selectLectureListSearchFilter(condition);
	}

	@Override
	public int selectLectureApproval() {
		return adDAO.selectLectureApproval();
	}

	@Override
	public int selectLectureAll() {
		return adDAO.selectLectureAll();
	}

	@Override
	public int selectTodayInCnt() {
		return adDAO.selectTodayInCnt();
	}

	@Override
	public int selectMemberCnt() {
		return adDAO.selectMemberCnt();
	}

	@Override
	public int selectCreatorCnt() {
		return adDAO.selectCreatorCnt();
	}

	@Override
	public int selectNewMemberCnt() {
		return adDAO.selectNewMemberCnt();
	}

	@Override
	public int selectCreatorApprovalCnt() {
		return adDAO.selectCreatorApprovalCnt();
	}

	@Override
	public int selectQnaCommentCnt() {
		return adDAO.selectQnaCommentCnt();
	}

	@Override
	public List<CategoryLectureStatVO> selectCategoryLectureCnt() {
		return adDAO.selectCategoryLectureCnt();
	}

	@Override
	public boolean updateLectureApprovalforIds(ArrayList<Integer> ids) {
		return adDAO.updateLectureApprovalforIds(ids);
	}

	@Override
	public boolean updateLectureDisapprovalforIds(ArrayList<Integer> checkList) {
		return adDAO.updateLectureDisapprovalforIds(checkList);
	}

	@Override
	public boolean delectLectureforIds(ArrayList<Integer> checkList) {
		return adDAO.delectLectureforIds(checkList);
	}
	// 상세조회 페이지수
	@Override
	public Map<String, Integer> checkLectureMaxPageNumberSearch(Map<String, Object> searchMap) {
		int totalRecords = adDAO.checkNumberOfLecturesSearch(searchMap);
		System.out.println(totalRecords+"서비스단 총레코드수");
		int maxPg = totalRecords / AD_PAGE_SIZE + (totalRecords % AD_PAGE_SIZE == 0 ? 0 : 1 );
		HashMap<String,Integer> rMap = new HashMap<>();
		rMap.put("totalRecords", totalRecords);
		rMap.put("maxPg", maxPg);
		return rMap;
	}
	// 상세조회 레코드수
	@Override
	public List<LectureVO> selectAllLectureSearch(Map<String, Object> searchMap) {
		String pn = (String) searchMap.get("pn");
		int pageNumber = Integer.parseInt(pn);
		int offset =(pageNumber-1)*AD_PAGE_SIZE;
		searchMap.put("offset", offset);
		searchMap.put("limit", AD_PAGE_SIZE);
		System.out.println(searchMap);
		List<LectureVO> list = adDAO.selectLectureListSearchFilter(searchMap);
		System.out.println("searchfilter result : "+ list.size());
		return list;
	}

}
