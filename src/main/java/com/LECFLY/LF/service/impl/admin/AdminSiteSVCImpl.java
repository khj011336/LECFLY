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
	public List<HomeFileManagerVO> selectBannerList(HomeFileManagerVO vo) {
		System.out.println("svc selectList 시작");
		return adDAO.selectBannerList(vo);
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
	public List<LectureVO> selectRecommendLectureList(LectureVO vo) {
		// TODO Auto-generated method stub
		return null;
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
	public List<LectureVO> selectNomalLectureList(LectureVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
