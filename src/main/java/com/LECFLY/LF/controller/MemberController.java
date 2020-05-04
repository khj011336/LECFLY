package com.LECFLY.LF.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.LECFLY.LF.service.inf.member.ILoginSVC;

@Controller
public class MemberController {
	
	@Autowired
	ILoginSVC logSvc;
	
	// 로그인창 으로 이동했을때
	@RequestMapping(value="login.LF", method=RequestMethod.GET)
	public String memberLoginPage() {
		System.out.println("memberLoginPage()...");
		return "member/login";
	}
	
	// login.LF 에서 이메일 비밀번호 입력후 로그인 클릭시
	@RequestMapping(value="log_in.LF", method=RequestMethod.POST)
	public String memberLoginedHomePage() {
		System.out.println("memberLoginedHomePage()...");
//		if() { //서비스 처리: 이메일과 로그인이 일치(로그인이 성공했을때)
		// 여기서  서비스에서 로그인 성공 실패에 대한 처리를 하고 
		
			return "redirect:home.LF?login=" + "로그인값";
//		} else { //서비스 처리: 이메일과 로그인이 불일치() 
//			return "member/login"; // 1Model 을 해서 메세지를 넣는방법  
									/* 2 리턴값을 ModelAndView 로해서 
										add 하여 메세지넣는방법 */
//		}
	} 
	

//	회원가입하기						
	//	clause.lf(form; get; 비회원)			약관 폼 이동
	//login.LF 에서 회원가입을 눌렀을시 약관동의 페이지
	@RequestMapping(value="clause.LF", method=RequestMethod.GET)
	public String memberClausePage() {
		System.out.println("memberClausePage()...");
		return "member/clause";
	}
	
	// 약관동의 에서 넘어와서 회원가입 폼이 준비된 페이지
	// //	create_new_member.lf 		이동시 약관확인 여부 체크 확인후 이동
//	member_join.lf (proc; post; dao; 비회원)			회원가입proc 실행(createNewMember)		
	@RequestMapping(value="join_new_member.LF", method=RequestMethod.GET)
	public String memberJoinPage() {
		System.out.println("memberJoinPage()");
		// 서비스: 약관페이지에서 넘어올떄 약관동의버튼 모두체크 하는 것을 처리
//		agree_receive.lf(proc; post; 비회원)			약관 확인 여부 체크		
		
//		if() { // 약관페이지에서 넘어올떄 약관동의버튼 모두체크시 
			return "member/create_new_member";
//		} else { // 약관을 모두 체크하지않았을경우
//			return "member/clause"; // 아니면
//			return "redirect:clause.LF?err=1" // 이런식??
//		}
	}		
	
//이메일 찾기						
	//	find_mb_login.lf (form; get; 비회원)			이메일찾기 폼 이동
	//	find_login.lf (proc; post; dao; 비회원)			이메일찾기proc실행(findEmail(phNumber) )
	// 로그인창에서 아이디찿기 클릭시 
	@RequestMapping(value="find_mb_login.LF", method=RequestMethod.GET)
	public String memberFindLoginPage() {
		System.out.println("memberFindLoginPage()...");
		return "member/find_mb_login";
	}


//비밀번호 찾기						
	//	find_mb_pw.lf (form; get; 비회원)			비밀번호 재발급폼 이동
	//	find_pw.lf (proc; post; dao; 비회원)			비밀번호 재발급proc실행(createNewPWToEmail(email)
	// 로그인창에서 비밀번호 찾기 클릭시
	@RequestMapping(value="find_mb_pw.LF", method=RequestMethod.GET)
	public String memberFindPasswordPage() {
		System.out.println("memberFindPasswordPage()...");
		return "member/find_mb_pw";
	}
		
	//로그아웃하기						
//	logout.lf (proc; get; 회원)			로그아웃proc실행 후 default로 이동		session의 memberVO 제거
	@RequestMapping(value="logout.LF", method=RequestMethod.GET)
	public String memberLogoutLECFLY() {
		System.out.println("memberLogoutLECFLY()...");
		
		return "redirect:home.LF";
	}
	
/*
//	로그인하기						
//	login.lf (form; get; 비회원)			로그인폼 이동
	@RequestMapping(value = "login.LF", method = RequestMethod.GET )
	public String loginForm() {
		System.out.println("로그인");
		return "login";
	}

//log_in.lf (proc; post; 암호화; 세션; 회원)			로그인proc실행(selectOneMember(email,pw) )	
	@RequestMapping(value = "log_in.LF", method = RequestMethod.POST)
	public String login() {
		
		return "home";
	}	
*/	
	
	
////////////////////////////////////////   위쪽은 로그인 관련 페이지들
	
	//	마이페이지 정보 확인하기								
	//	mypage.lf(form, post, dao)			"마이페이지 메인화면 페이지 이동
	//tikcetVO/couponVO/showClassVideoVO
	//를 dao에서 불러와 우측 기능 실행"			"회원의 등급확인하기
	//회원이 이용중인 이용권 갯수 표시
	//회원이 보유중인 쿠폰 갯수 표시
	//회원이 수강중인 강의 갯수 확인하기
	//회원이 해당 강의 중 보던 영상 표시하기"	
	// 마이페이지 이동
	@RequestMapping(value="mypage.LF", method=RequestMethod.GET) // post 하면 405 에러뜸
	public String memberMyPage() {
		System.out.println("memberMyPage()");
		
		return "member/mypage";
	}	
	
	
//	회원의 프로필 사진 수정하기							
//	change_pro_pic.lf(proc; post, dao, attr)			proc완료후 mypage.lf 프로필사진 업데이트된 상태로 forward
	@RequestMapping(value="change_pro_pic.LF", method=RequestMethod.POST)
	public String memberChangeProfilePicture() {
		System.out.println("memberChangeProfilePicture()...");
		
		
		return "member/mypage";
	}
	
//크리에이터 신청하기							
//	apply_creator.lf(form, post)			크리에이터 신청 폼으로 이동
	@RequestMapping(value="apply_creator.LF", method=RequestMethod.POST)
	public String memberApplyCreator() {
		System.out.println("memberApplyCreator()...");
		
		
		return "redirect:mypage.LF?pn=apply_creator"; // ??? 조각페이지면 이런형식으로 띄우고 이거 체크필요
	}
	
	
//회원이 신청한 강의목록 표시하기							수강 관리
//	mypage_attending_class.lf(proc, post, dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_attending_class.LF", method=RequestMethod.POST)
	public String memberMypageAttendingClass() {
		System.out.println("memberMypageAttendingClass()...");	
		return "redirect:mypage.LF?pn=attending_class";
	}
	
//회원이 보던 영상 표시하기							
//	mypage_attending_video.lf(proc, post, dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_attending_video.LF", method=RequestMethod.POST)
	public String memberMypageAttendingVideo() {
		System.out.println("memberMypageAttendingVideo()...");	
		return "redirect:mypage.LF?pn=attending_video";
	}
	
//회원이 좋아요한 강의 확인하기							
//	mypage_like.lf(proc,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_like.LF", method=RequestMethod.POST)
	public String memberMypageLike() {
		System.out.println("memberMypageLike()...");	
		return "redirect:mypage.LF?pn=like";
	}
	
//회원이 찜하기한 강의 확인하기							
//	mypage_will_attend.lf(proc,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_will_attend.LF", method=RequestMethod.POST)
	public String memberMypageWillAttend() {
		System.out.println("memberMypageWillAttend()...");	
		return "redirect:mypage.LF?pn=will_attend";
	}
	
	
//회원이 작성한 댓글내역 확인하기							활동 내역
//	mypage_comment.lf(proc,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_comment.LF", method=RequestMethod.POST)
	public String memberMypageComment() {
		System.out.println("memberMypageComment()...");	
		return "redirect:mypage.LF?pn=comment";
	}

//회원이 문의한 qna내역 확인하기							
//	mypage_qna.lf(proc,post,dao)				해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_qna.LF", method=RequestMethod.POST)
	public String memberMypageQna() {
		System.out.println("memberMypageQna()...");	
		return "redirect:mypage.LF?pn=qna";
	}
//펀딩신청내역 확인하기							
//	mypage_funding.lf(proc,post,dao)		해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_funding.LF", method=RequestMethod.POST)
	public String memberMypageFunding() {
		System.out.println("memberMypageFunding()...");	
		return "redirect:mypage.LF?pn=funding";
	}
	
//회원이 보유중인 쿠폰 표시							
//	mypage_coupon.lf(proc,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_coupon.LF", method=RequestMethod.POST)
	public String memberMypageCoupon() {
		System.out.println("memberMypageCoupon()...");	
		return "redirect:mypage.LF?pn=coupon";
	}
//회원이 이용중인 이용권 표시							
//	mypage_ticket.lf(proc,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_ticket.LF", method=RequestMethod.POST)
	public String memberMypageTicket() {
		System.out.println("memberMypageTicket()...");	
		return "redirect:mypage.LF?pn=ticket";
	}
//회원이 가입시 입력한 정보 수정하기							정보 관리
//	mypage_update_info.lf(proc,post,dao)		해당 조각페이지 불러오게 리턴			
	@RequestMapping(value="mypage_update_info.LF", method=RequestMethod.POST)
	public String memberMypageUpdateInfo() {
		System.out.println("memberMypageUpdateInfo()...");	
		return "redirect:mypage.LF?pn=update_info";
	}
	
//회원의 비밀번호 변경하기							
//	mypage_update_pw.lf(proc,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_update_pw.LF", method=RequestMethod.POST)
	public String memberMypageUpdatePw() {
		System.out.println("memberMypageUpdatePw()...");	
		return "redirect:mypage.LF?pn=update_pw";
	}
	
	
//회원이 결제한 물품의 배송정보 표시하기							배송 관리
//	mypage_payment.lf(form,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_payment.LF", method=RequestMethod.POST)
	public String memberMypagePayment() {
		System.out.println("memberMypagePayment()...");	
		return "redirect:mypage.LF?pn=payment";
	}
//회원이 결제한 내역 확인하기							
//	mypage_payment_history.lf(form,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_payment_history.LF", method=RequestMethod.POST)
	public String memberMypagePaymentHistory() {
		System.out.println("memberMypagePaymentHistory()...");	
		return "redirect:mypage.LF?pn=payment_history";
	}
	
//장바구니 목록 확인하기							
//	mypage_shopping.lf(form,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_shopping.LF", method=RequestMethod.GET)
	public String memberMypageShopping() {
		System.out.println("memberMypageShopping()...");	
		return "redirect:mypage.LF?pn=shopping";
	}
	
////////////////////////////////////////////////////
	
	// 네비 장바구니 클릭
	@RequestMapping(value="shopping_cart.LF", method=RequestMethod.GET)
	public String memberShoppingCart() {
		System.out.println("memberShoppingCart()...");	
		return "payment/shoppingCart";
	}
	
	
	
	


	
}