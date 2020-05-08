package com.LECFLY.LF.controller;

import java.util.List;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.LECFLY.LF.model.dao.inf.member.IMemberDAO;
import com.LECFLY.LF.model.vo.MemberVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.service.inf.member.ILoginSVC;
import com.LECFLY.LF.service.inf.member.IMypageSVC;

@Controller
public class MemberController {
	
	@Autowired
	ILoginSVC logSvc;
	@Autowired
	IMypageSVC mpSvc;
	
	
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
			ses.setAttribute("msg", logSvc.getMsg(r));
//			return "member/login";
			return "redirect:login.LF";
		}
	} 
	
	// 로그아웃 시
	@RequestMapping(value="logout_proc.LF", method=RequestMethod.GET)
	public String memberLogout(HttpSession ses, Model model) {
		System.out.println("logout_proc()...");
		ses.invalidate();
		return "redirect:/";
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
			String cnm_mb_name, String cnm_mb_nick, @DateTimeFormat(pattern="yyyy-MM-dd")Date cnm_mb_birth,
			int cnm_mb_gender, String cnm_mb_email, String cnm_mb_pw,
			String cnm_mb_pw_confirm, String cnm_mb_ph1, String cnm_mb_ph2,
			int cnm_mb_adress_num,String cnm_mb_adress_basic, String cnm_mb_adress_detail,
			String cnm_mb_agree_news_bymail, String cnm_mb_agree_news_bysms
			){
		System.out.println("join_member_proc....");
		// birthday 인자값 timestamp로 변환
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Timestamp birthday = Timestamp.valueOf(sdf.format(cnm_mb_birth));
		System.out.println(cnm_mb_ph1 +"/"+ cnm_mb_ph2 +"/"+ cnm_mb_agree_news_bymail +"/"+ cnm_mb_agree_news_bysms +"/"
				+ birthday);
		// ph 인자값 결합
		String ph = "010"+cnm_mb_ph1 + cnm_mb_ph2;
		// agreeReceive 값 결합 및 변환
		int agreeReceive = 0;
		if( cnm_mb_agree_news_bymail.equals("agree_email"))
			agreeReceive += 1;
		if( cnm_mb_agree_news_bysms.equals("agree_sms"))
			agreeReceive += 2;
		
//		MemberVO mb = new MemberVO(
//				null, cnm_mb_name, cnm_mb_nick, birthday, cnm_mb_gender, 
//				cnm_mb_email, cnm_mb_pw, ph, agreeReceive, cnm_mb_adress_basic, 
//				cnm_mb_adress_detail, cnm_mb_adress_num);
		
		if(logSvc.joinMember(null, cnm_mb_name, cnm_mb_nick, birthday, cnm_mb_gender, 
				cnm_mb_email, cnm_mb_pw, ph, agreeReceive, cnm_mb_adress_basic, 
				cnm_mb_adress_detail, cnm_mb_adress_num))
			System.out.println(cnm_mb_name + "회원 생성 성공");
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
	public String memberChangeProfilePicture(HttpSession ses, 
			@RequestParam(value="id", defaultValue ="0") int id, // 바꾸려고하는 id
			@RequestParam(value="pic", defaultValue ="") String filePath,  
			Model model) {
		System.out.println("memberChangeProfilePicture()...");
		// 교수님말: 회원 비밀번호 한번더 인증하는 작업이 필요하다고함 (회원의 개인정보를 바꾸기 때문에)		
		int loginedId = (Integer)ses.getAttribute("mbId");
		boolean b = mpSvc.updateMemberProfileImg(loginedId, id, filePath);
		if( b ) {
			
		} else {
			
		}
		return "member/mypage/mypage"; // forward
	}
	
//크리에이터 신청하기							
//	apply_creator.lf(form, post)			크리에이터 신청 폼으로 이동
	@RequestMapping(value="apply_creator.LF", method=RequestMethod.POST)
	public String memberApplyCreator() {
		System.out.println("memberApplyCreator()...");
		
		
		return "redirect:mypage.LF?pn=apply_creator"; // ??? 조각페이지면 이런형식으로 띄우고 이거 체크필요
	}
	
	
//회원이 신청한 강의목록 표시하기							수강 관리
	
//	수강중인강의
//	mypage_attending_class.lf(proc, post, dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_attending_lec.LF", method=RequestMethod.POST)
	public String memberMypageAttendingLec(HttpSession ses, 
			@RequestParam(value="id", defaultValue ="0") int id, Model model) {
		System.out.println("memberMypageAttendingLec()...");	
		
//		List<VideoVO> vdList = mpSvc.showAllAttendingLec(); // 내가 수강한 비디오 목록을 리스트로 받으려함
//		if(vdList != null) {
//			return "";
//		} else {
//			return "";
//		}
		 return "member/mypage/attend_lec_manager/mypage_attending_lec";
	}
	
	//회원이 찜하기한 강의 확인하기							
//	mypage_will_attend.lf(proc,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_will_attend.LF", method=RequestMethod.POST)
	public String memberMypageWillAttend() {
		System.out.println("memberMypageWillAttend()...");	
		return "member/mypage/attend_lec_manager/mypage_will_attend";
	}

	//회원이 좋아요한 강의 확인하기							
	//	mypage_like.lf(proc,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_like.LF", method=RequestMethod.POST)
	public String memberMypageLike() {
		System.out.println("memberMypageLike()...");	
		return "member/mypage/attend_lec_manager/mypage_like";
	}
	
	
	
	@RequestMapping(value="mypage_no_list.LF", method=RequestMethod.POST)
	public String memberMypageNOList() {
		System.out.println("memberMypageNOList()...");	
		return "member/mypage/attend_lec_manager/mypage_no_list";
	}	
	
//회원이 보던 영상 표시하기							
//	mypage_attending_video.lf(proc, post, dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_attending_video.LF", method=RequestMethod.POST)
	public String memberMypageAttendingVideo() {
		System.out.println("memberMypageAttendingVideo()...");	
		return "redirect:mypage.LF?pn=attending_video";
	}
	

	
////////활동내역
		
//회원이 작성한 댓글내역 확인하기							활동 내역
//	mypage_comment.lf(proc,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_comment.LF", method=RequestMethod.POST)
	public String memberMypageComment() {
		System.out.println("memberMypageComment()...");	
		return "memeber/mypage/activity/mypage_comment";
	}

//회원이 문의한 qna내역 확인하기							문의 내역
//	mypage_qna.lf(proc,post,dao)				해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_qna.LF", method=RequestMethod.POST)
	public String memberMypageQna() {
		System.out.println("memberMypageQna()...");	
		return "member/mypage/activity/mypage_qna";
	}
//펀딩신청내역 확인하기									펀딩신청내역
//	mypage_funding.lf(proc,post,dao)		해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_funding.LF", method=RequestMethod.POST)
	public String memberMypageFunding() {
		System.out.println("memberMypageFunding()...");	
		return "member/mypage/activity/mypage_funding";
	}
	
//회원이 보유중인 쿠폰 표시							나의쿠폰
//	mypage_coupon.lf(proc,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_coupon_info.LF", method=RequestMethod.POST)
	public String memberMypageCoupon() {
		System.out.println("memberMypageCoupon()...");	
		return "member/mypage/activity/coupon_info";
	}

	
//// 정보관리	
	
// 회원이 가입시 입력한 정보 수정하기							회원정보 수정
//	mypage_update_info.lf(proc,post,dao)		해당 조각페이지 불러오게 리턴			
	@RequestMapping(value="mypage_mb_update.LF", method=RequestMethod.POST)
	public String memberMypageUpdateInfo() {
		System.out.println("memberMypageUpdateInfo()...");	
		return "member/mypage/info_manager/mypage_mb_update";
	}
	
//회원의 비밀번호 변경하기								비밀번호 변경
//	mypage_update_pw.lf(proc,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_pw_update.LF", method=RequestMethod.POST)
	public String memberMypageUpdatePw() {
		System.out.println("memberMypageUpdatePw()...");	
		return "member/mypage/info_manager/mypage_pw_update";
	}


//////	 주문 / 배송관리
	
//회원이 결제한 물품의 배송정보 표시하기							배송 관리
//	mypage_payment.lf(form,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_payment_info.LF", method=RequestMethod.POST)
	public String memberMypagePayment() {
		System.out.println("memberMypagePayment()...");	
		return "member/mypage/order_manager/mypage_payment_info";
	}
	
//회원이 결제한 내역 확인하기							
//	mypage_payment_history.lf(form,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_payment_history.LF", method=RequestMethod.POST)
	public String memberMypagePaymentHistory() {
		System.out.println("memberMypagePaymentHistory()...");	
		return "redirect:mypage.LF?pn=payment_history";
	}
	
	
	
//회원이 이용중인 이용권 표시							
//	mypage_ticket.lf(proc,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_ticket.LF", method=RequestMethod.POST)
	public String memberMypageTicket() {
		System.out.println("memberMypageTicket()...");	
		return "redirect:mypage.LF?pn=ticket";
	}

	

	
//장바구니 목록 확인하기							
//	mypage_shopping.lf(form,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_shoppingcart.LF", method=RequestMethod.GET)
	public String memberMypageShopping() {
		System.out.println("memberMypageShopping()...");	
		return "member/mypage/order_manager/mypage_shoppingcart";
	}
	
	// 세현 테스트 mypage.jsp 관련(load 써먹을수있나 테스트중.)..
	@RequestMapping(value="mypage_list.LF", method=RequestMethod.GET)
	public String memberMypageList() {
		System.out.println("memberMypageList()...");	
		return "member/mypage/info_manager/mypage_mb_update";
	}
	
	@RequestMapping(value="mypage_delivery_info.LF", method=RequestMethod.GET)
	public String memberMypageDeliveryInfo() {
		System.out.println("memberMypageDeliveryInfo()...");	
		return "member/mypage/order_manager/mypage_delivery_info";
	}
	
	
	@RequestMapping(value="mypage_recive_address.LF", method=RequestMethod.GET) // ???/
	public String memberMypageReciveAddress() {
		System.out.println("memberMypageReciveAddress()...");	
		return "member/mypage/order_manager/mypage_delivery_info";
	}
	
	
////////////////////////////////////////////////////
	
	// 네비 장바구니 클릭
	@RequestMapping(value="shopping_cart.LF", method=RequestMethod.GET)
	public String memberShoppingCart() {
		System.out.println("memberShoppingCart()...");	
		return "payment/shoppingCart";
	}
	
	
	
	


	
}