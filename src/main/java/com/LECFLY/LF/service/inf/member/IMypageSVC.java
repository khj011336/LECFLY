package com.LECFLY.LF.service.inf.member;


import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.LECFLY.LF.model.vo.LecAttendVO;
import com.LECFLY.LF.model.vo.LecTypeVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.model.vo.member.MemberVO;

public interface IMypageSVC {
							
//마이페이지 정보 확인하기
	//회원의 등급확인하기
	//회원이 이용중인 이용권 갯수 표시
	//회원이 보유중인 쿠폰 갯수 표시
	//회원이 수강중인 강의 갯수 확인하기
	//회원이 해당 강의 중 보던 영상 표시하기				
//	mypage.lf(form, post, dao)	마이페이지 메인화면 페이지 이동
//tikcetVO/couponVO/showClassVideoVO를 dao에서 불러와 실행
	
//회원의 프로필 사진 수정하기							
//	change_pro_pic.lf(proc; post, dao, attr)			proc완료후 mypage.lf 프로필사진 업데이트된 상태로 forward
	
//크리에이터 신청하기							
//	크리에이터신청페이지.lf(form, post)			크리에이터 신청 폼으로 이동		

	boolean updateMemberProfileImg(int mbId, String pic);
	
	List<LecAttendVO> selectLecToStatusForMbIdStatus(int mbId, int status);
	
	Map<String, Object> selectVideoAndCreImgPathAndCreNicname(int mbId, int status);

	
	
	VideoVO selectLecVideo(int vdId);

	Map<String, Object> selectAllMyComment(int mbId, int pn);

	Map<String, Object> //selectAllMyCommentQna(int mbId, int pn);
						selectAllMyQna(int mbId, int pn);
	
	Map<String, Object> selectAllMyCoupon(int mbId, int pn);

	MemberVO selectOneMember(int mbId);

	Map<String, Object> selectMyPageDeliveryInfoMap(int mbId);

	Map<String, Object> selectMyPageContents(int mbId); 
	
	// 회원정보 수정에서 회원정보를 수정하는 서비스
	Map<String, Object> updateOneMemberInfo(
			MemberVO mb, String nickname, String ph1, String ph2, String agreeEmail, String agreeSms, 
			int postalcode, String basicAddress, String detailAddress);
	boolean updateOneMember(MemberVO mb);

	// 비밀번호 변경에서 비밀번호를 새로 설정하는 서비스
	Map<String, Object> updateOneMemberPw(String email, String newPw, String newPwConfirm);
	boolean updateOneMember(String email, String pw);

	Map<String, Object> selectMyPageDeliveryStatMap(int mbId, int deliveryStat);

	Map<String, Object> selectMemberPayHistoriesByPayStatusMbId(String payStatus, int mbId);

	Map<String, Object> showMyPageDeliveryContentsByMbIdDeliveryStat(int mbId, int deliveryStat);

	Map<String, Object> selectMypagePayHistoryListByMbId(int mbId, int pageNumber);

	
//회원이 신청한 강의목록 표시하기							수강 관리
//	mypage_attending_class.lf(proc, post, dao)			해당 조각페이지 불러오게 리턴			
	
//회원이 보던 영상 표시하기							
//	mypage_attending_video.lf(proc, post, dao)			"			
	
//회원이 좋아요한 강의 확인하기							
//	mypage_like.lf(proc,post,dao)			"			
	
//회원이 찜하기한 강의 확인하기							
//	mypage_will_attend.lf(proc,post,dao)			"			
	
//회원이 작성한 댓글내역 확인하기							활동 내역
//	mypage_comment.lf(proc,post,dao)			"			
	
//회원이 문의한 qna내역 확인하기							
//	mypage_qna.lf(proc,post,dao)			"			
	
//펀딩신청내역 확인하기							
//	mypage_funding.lf(proc,post,dao)			"			
	
//회원이 보유중인 쿠폰 표시							
//	mypage_coupon.lf(proc,post,dao)			"			
	
//회원이 이용중인 이용권 표시							
//	mypage_ticket.lf(proc,post,dao)			"			
	
//회원이 가입시 입력한 정보 수정하기							정보 관리
//	mypage_update_info.lf(proc,post,dao)			"			
	
//회원의 비밀번호 변경하기							
//	mypage_update_pw.lf(proc,post,dao)			"			
	
//회원이 결제한 물품의 배송정보 표시하기							배송 관리
//	mypage_payment.lf(form,post,dao)			"			
	
//회원이 결제한 내역 확인하기							
//	mypage_payment.lf(form,post,dao)			"			
	
//장바구니 목록 확인하기							
//	mypage_shopping.lf(form,post,dao)			"			
	
}
