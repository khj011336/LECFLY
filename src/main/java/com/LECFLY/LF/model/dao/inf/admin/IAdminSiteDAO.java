package com.LECFLY.LF.model.dao.inf.admin;

import java.util.List;

import com.LECFLY.LF.model.vo.HomeFileManagerVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;

public interface IAdminSiteDAO {
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
	List<HomeFileManagerVO> selectBannerList();
	
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
	List<LectureVO> selectRecommendLectureList(List<Integer> reIds);
	
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
	List<LectureVO> selectNomalLectureList();
	// 추천강의 id들을 조회할 수 있다.
	List<Integer> getRecommendIds();
	
	// 메인_강의에 좋아요를 할 수 있다.
	boolean likeBtnClick(int status, int memberId, int lectureId);
	// 카테고리별 강의를 전체조회할 수 있다.
	List<LectureVO> selectLectureListForCategory(int category);
	// 키워드로 강의를 검색할 수 있다. 
	List<LectureVO> selectLectureListForKeyword(String keyword);	
}
