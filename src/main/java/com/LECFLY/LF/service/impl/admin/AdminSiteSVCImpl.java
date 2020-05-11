package com.LECFLY.LF.service.impl.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.inf.admin.IAdminSiteDAO;
import com.LECFLY.LF.model.vo.HomeFileManagerVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.service.inf.admin.IAdminSiteSVC;

@Service
public class AdminSiteSVCImpl implements IAdminSiteSVC {
	@Autowired
	private IAdminSiteDAO adDAO;

	@Override
	public boolean insertBanner(HomeFileManagerVO vo) {
		System.out.println("svc insert 시작");
		return adDAO.insertBanner(vo);
	}

	@Override
	public boolean updateBanner(HomeFileManagerVO vo) {
		return adDAO.updateBanner(vo);
	}

	@Override
	public boolean deleteBanner(HomeFileManagerVO vo) {
		return adDAO.deleteBanner(vo);
	}

	@Override
	public HomeFileManagerVO selectBanner(HomeFileManagerVO vo) {
		return adDAO.selectBanner(vo);
	}

	@Override
	public List<HomeFileManagerVO> selectBannerList() {
		System.out.println("svc selectList 시작");
		return adDAO.selectBannerList();
	}

	@Override
	public boolean insertRecommendLecture(LectureVO vo) {
		return false;
	}

	@Override
	public boolean updateRecommendLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRecommendLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LectureVO selectRecommendLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LectureVO> selectRecommendLectureList(List<Integer> reIds) {
		return adDAO.selectRecommendLectureList(reIds);
	}

	@Override
	public boolean insertNomalLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateNomalLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteNomalLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LectureVO selectNomalLecture(LectureVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LectureVO> selectNomalLectureList() {
		return adDAO.selectNomalLectureList();
	}

	@Override
	public List<Integer> getRecommendIds() {
		return adDAO.getRecommendIds();
	}

	@Override
	public boolean likeBtnClick(int status, int memberId, int lectureId) {
		// TODO Auto-generated method stub
		return adDAO.likeBtnClick(status, memberId, lectureId);
	}

	@Override
	public List<LectureVO> selectLectureListForCategory(int category) {
		return adDAO.selectLectureListForCategory(category);
	}

	@Override
	public List<LectureVO> selectLectureListForKeyword(String keyword) {
		return adDAO.selectLectureListForKeyword(keyword);
	}

}
