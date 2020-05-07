package com.LECFLY.LF.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.LECFLY.LF.model.dao.inf.member.IMemberDAO;
import com.LECFLY.LF.model.vo.MemberVO;
import com.LECFLY.LF.service.inf.member.ILoginSVC;

@Controller
public class MemberController {
	
	@Autowired
	ILoginSVC logSvc;
		
	// 로그인창 으로 이동했을때
	
	@RequestMapping(value="login.LF", method=RequestMethod.GET)
	public String memberLoginPage(Model model, String msg) {
		model.addAttribute("msg", msg);
		System.out.println("memberLoginPage()...");
		return "member/login";
	}
	
	// login.LF 에서 이메일 비밀번호 입력후 로그인 클릭시
	@RequestMapping(value="login_proc.LF", method=RequestMethod.POST)
	public String memberLoginedHomePage(HttpSession ses, Model model, String email, String pw) {
		System.out.println("memberLoginedHomePage()...");
		MemberVO mb = new MemberVO();
		int r = logSvc.loginProcess(email, pw);
		if( r == logSvc.MB_EMAIL_AUTH_OK ) {
			mb = logSvc.login(email, pw);
			ses.setAttribute("member", mb);
			System.out.println(mb);
			return "redirect:/";
		} else {
			model.addAttribute("msg", logSvc.getMsg(r));
//			return "member/login";
			return "redirect:login.LF";
		}
	} 
	

//	회원가입하기						
	//	clause.lf(form; get; 비회원)			약관 폼 이동
	//login.LF 에서 회원가입을 눌렀을시 약관동의 페이지
	@RequestMapping(value="clause.LF", method=RequestMethod.GET)
	public String memberClausePage() {
		System.out.println("memberClausePage()...");
		return "member/clause";
	}
	
	// 약관동의 에서 넘어와서 회원가입 폼을 준비하는 페이지
	// join_new_member.lf (form; get; 비회원)
	@RequestMapping(value="join_new_member.LF", method=RequestMethod.GET)
	public String memberJoinPage() {
		System.out.println("memberJoinPage()");
			return "member/create_new_member";
	}
	// 회원가입하는 proc
	//member_join.lf (proc; post; dao; 비회원)
	@RequestMapping(value="join_member_proc.LF", method=RequestMethod.POST)
	public String join_member_proc(
			String cnm_mb_name, String cnm_mb_nick, Timestamp cnm_mb_birth,
			int cnm_mb_gender, String cnm_mb_email, String cnm_mb_pw,
			String cnm_mb_pw_confirm, String cnm_mb_ph1, String cnm_mb_ph2,
			int cnm_mb_adress_num,String cnm_mb_adress_basic, String cnm_mb_adress_detail,
			String cnm_mb_agree_news_bymail, String cnm_mb_agree_news_bysms
			){
		System.out.println(cnm_mb_ph1 +"/"+ cnm_mb_ph2 +"/"+ cnm_mb_agree_news_bymail +"/"+ cnm_mb_agree_news_bysms);
		
		String ph = "010"+cnm_mb_ph1 + cnm_mb_ph2;
		int agreeReceive = 0;
		if( cnm_mb_agree_news_bymail.equals("agree_email"))
			agreeReceive += 1;
		if( cnm_mb_agree_news_bysms.equals("agree_sms"))
			agreeReceive += 2;
		
//		MemberVO mb = new MemberVO(
//				null, cnm_mb_name, cnm_mb_nick, cnm_mb_birth, cnm_mb_gender, 
//				cnm_mb_email, cnm_mb_pw, ph, agreeReceive, cnm_mb_adress_basic, 
//				cnm_mb_adress_detail, cnm_mb_adress_num);
		System.out.println("join_member_proc....");
		return "home";
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
	@RequestMapping(value="mypage_shopping.LF", method=RequestMethod.POST)
	public String memberMypageShopping() {
		System.out.println("memberMypageShopping()...");	
		return "redirect:mypage.LF?pn=shopping";
	}
	
	
	
	
	
	
	
	

	

	
}