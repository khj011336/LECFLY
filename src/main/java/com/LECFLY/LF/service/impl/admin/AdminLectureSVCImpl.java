package com.LECFLY.LF.service.impl.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.inf.admin.IAdminLectureDAO;
import com.LECFLY.LF.model.vo.CouponVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.service.inf.admin.IAdminLectureSVC;

@Service
public class AdminLectureSVCImpl implements IAdminLectureSVC {

	@Autowired
	private IAdminLectureDAO alDAO;
	
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
	public Map<String,Integer> checkMaxPageNumber() {
		int totalRecords = alDAO.checkNumberOfLectures();
		int maxPg = totalRecords / AD_PAGE_SIZE + (
				totalRecords % AD_PAGE_SIZE == 0 ? 0 : 1 );
		HashMap<String,Integer> rMap = new HashMap<>();
		rMap.put("totalRecords", totalRecords);
		rMap.put("maxPg", maxPg);
		return rMap;
	}

	@Override
	public List<LectureVO> selectAllLecture(int pageNumber) {
		int offset = (pageNumber -1)*AD_PAGE_SIZE;
		List<LectureVO> lecList = alDAO.searchLectureForAll(offset, AD_PAGE_SIZE);
		return lecList;
	}

}
