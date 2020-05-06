package com.LECFLY.LF.service.inf.admin;

import java.util.List;

import com.LECFLY.LF.model.vo.HomeFileManagerVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;

public interface IAdminSiteSVC {
	// 배너 관리
		// 배너 이미지를 등록할 수 있다.
		boolean insertBanner(HomeFileManagerVO vo);
		// 배너 이미지를 수정할 수 있다.
		boolean updateBanner(HomeFileManagerVO vo);
		// 배너 이미지를 삭제할 수 있다.
		boolean deleteBanner(HomeFileManagerVO vo);
		// 배너 이미지를 상세조회할 수 있다.
		HomeFileManagerVO selectBanner(HomeFileManagerVO vo);
		// 배너 이미지를 전체조회할 수 있다.
		List<HomeFileManagerVO> selectBannerList(HomeFileManagerVO vo);
		
		// 추천 강의 전시 관리
		// 추천 강의를 등록할 수 있다.
		boolean insertRecommendLecture(LectureVO vo);
		// 추천 강의를 수정할 수 있다.
		boolean updateRecommendLecture(LectureVO vo);
		// 추천 강의를 삭제할 수 있다.
		boolean deleteRecommendLecture(LectureVO vo);
		// 추천 강의를 상세조회할 수 있다.
		LectureVO selectRecommendLecture(LectureVO vo);
		// 추천 강의를 전체조회할 수 있다.
		List<LectureVO> selectRecommendLectureList(LectureVO vo);
		
		// 일반 강의 전시 관리
		// 일반 강의를 등록할 수 있다.
		boolean insertNomalLecture(LectureVO vo);
		// 일반 강의를 수정할 수 있다.
		boolean updateNomalLecture(LectureVO vo);
		// 일반 강의를 삭제할 수 있다.
		boolean deleteNomalLecture(LectureVO vo);
		// 일반 강의를 상세조회할 수 있다.
		LectureVO selectNomalLecture(LectureVO vo);
		// 일반 강의를 전체조회할 수 있다.
		List<LectureVO> selectNomalLectureList(LectureVO vo);
}
