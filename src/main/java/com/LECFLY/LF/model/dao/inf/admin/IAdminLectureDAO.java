package com.LECFLY.LF.model.dao.inf.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.LECFLY.LF.model.vo.cart.CouponVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.model.vo.virtual.CategoryLectureStatVO;

public interface IAdminLectureDAO {
	// 강의 관리
	// 강의를 등록할 수 있다.
	boolean insertLecture(LectureVO vo);
	// 강의를 수정할 수 있다.
	boolean updateLecture(LectureVO vo);
	// 강의를 삭제할 수 있다.
	boolean deleteLecture(LectureVO vo);
	// 강의를 상세조회할 수 있다.
	LectureVO selectLecture(LectureVO vo);
	// 강의를 전체조회할 수 있다.
	List<LectureVO> selectLectureList();
	
	// 영상 관리
	// 영상을 등록할 수 있다.
	boolean insertVideo(VideoVO vo);
	// 영상을 수정할 수 있다.
	boolean updateVideo(VideoVO vo);
	// 영상을 삭제할 수 있다.
	boolean deleteVideo(VideoVO vo);
	// 영상을 상세조회할 수 있다.
	VideoVO selectVideo(VideoVO vo);
	// 영상을 전체조회할 수 있다.
	List<VideoVO> selectVideoList();
	
	// 키트 관리(Creator폴더)
	// 키트를 등록할 수 있다.
	boolean insertKit(KitVO vo);
	// 키트를 수정할 수 있다.
	boolean updateKit(KitVO vo);
	// 키트를 삭제할 수 있다.
	boolean deleteKit(KitVO vo);
	// 키트를 상세조회할 수 있다.
	KitVO selectKit(KitVO vo);
	// 키트를 전체조회할 수 있다.
	List<KitVO> selectKitList();
	
	// 쿠폰 관리
	// 쿠폰을 등록할 수 있다.
	boolean insertCoupon(CouponVO vo);
	// 쿠폰을 수정할 수 있다.
	boolean updateCoupon(CouponVO vo);
	// 쿠폰을 삭제할 수 있다.
	boolean deleteCoupon(CouponVO vo);
	// 쿠폰을 상세조회할 수 있다.
	CouponVO selectCoupon(CouponVO vo);
	// 쿠폰을 전체조회할 수 있다.
	List<CouponVO> selectCouponList();
	
	int checkNumberOfLectures();
	List<LectureVO> searchLectureForAll(int offset, int limit);
	List<VideoVO> searchVideoForAll(int offset, int limit);
	int checkNumberOfVideos();
	int checkNumberOfLecturesSearch(Map<String, Object> searchMap);
	List<LectureVO> selectLectureListSearchFilter(Map<String, Object> condition);
	int selectLectureApproval();
	int selectLectureAll();
	int selectTodayInCnt();
	int selectMemberCnt();
	int selectCreatorCnt();
	int selectNewMemberCnt();
	int selectCreatorApprovalCnt();
	int selectQnaCommentCnt();
	List<CategoryLectureStatVO> selectCategoryLectureCnt();
	boolean updateLectureApprovalforIds(ArrayList<Integer> checkList);
	boolean updateLectureDisapprovalforIds(ArrayList<Integer> checkList);
	boolean delectLectureforIds(ArrayList<Integer> checkList);
	List<LectureVO> searchLectureByApproval(int offset, int limit);
	List<LectureVO> searchLectureByLike(int offset, int limit);
	List<LectureVO> searchLectureByApprovalDone(int offset, int limit);

}
