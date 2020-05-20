package com.LECFLY.LF.controller;

import java.util.List;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.LECFLY.LF.model.vo.CouponVO;
import com.LECFLY.LF.model.vo.MemberVO;
import com.LECFLY.LF.model.vo.QnaCommentVO;
import com.LECFLY.LF.model.vo.QnaVO;
import com.LECFLY.LF.model.vo.ShowClassVideoVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.service.impl.member.loginSVCImpl;
import com.LECFLY.LF.service.inf.member.ILoginSVC;
import com.LECFLY.LF.service.inf.member.IMypageSVC;

@Controller
public class MemberController {
	
	@Autowired
	ILoginSVC logSvc;
	@Autowired
	private IMypageSVC mpSvc;
	
	
	// 로그인창 으로 이동했을때
	
	@RequestMapping(value="login.LF", method=RequestMethod.GET)
	public String memberLoginPage(Model model, String msg) {
		model.addAttribute("login_msg", msg);
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
			model.addAttribute("login_msg", logSvc.getMsg(r));
			model.addAttribute("email", email);
			model.addAttribute("pw", pw);
			return "member/login";
//			return "redirect:login.LF";
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
	public String join_member_proc( HttpSession ses, Model model, String cnm_upload_pic,
			String name, String nickname, @DateTimeFormat(pattern="yyyy-MM-dd")Date birthday,
			String gender, String email, String password,
			String pw_confirm, String phNumber, String phNumber2,
			String postalcode, String basic_address, String detail_address,
			String agree_receive_email, String agree_receive_sms
//			String cnm_upLoad_pic,
//			String cnm_mb_name, String cnm_mb_nick, @DateTimeFormat(pattern="yyyy-MM-dd")Date cnm_mb_birth,
//			String cnm_mb_gender, String cnm_mb_email, String cnm_mb_pw,
//			String cnm_mb_pw_confirm, String cnm_mb_ph1, String cnm_mb_ph2,
//			String postalcode, String cnm_mb_adress_basic, String cnm_mb_adress_detail,
//			String cnm_mb_agree_news_bymail, String cnm_mb_agree_news_bysms
			){
		// 인자 테스트
		System.out.println("join_member_proc....");
		if( !name.isEmpty() && name != null ) {
			System.out.println("이름 있음");
			model.addAttribute("name", name);
		}
		if( !nickname.isEmpty() && nickname!=null  ) {
			System.out.println("닉네임 있음");
			model.addAttribute("nickname", nickname);
			if(logSvc.check_dup_nick(nickname))
				model.addAttribute("nick_msg", "중복된 닉네임입니다.");
			else
				model.addAttribute("nick_msg", "사용가능한 닉네임입니다.");
		}
		if( birthday!=null ) {
			System.out.println("생년월일");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			Timestamp birth = Timestamp.valueOf(sdf.format(birthday));
			model.addAttribute("birthday", birth);
			System.out.println(birth);
		}
		if( !gender.isEmpty()&&gender!=null ) {
			System.out.println("성별있음");
			model.addAttribute("gender", gender);
		}
		if( !email.isEmpty()&&email!=null ) {
			System.out.println("이메일 있음");
			model.addAttribute("email", email);
			if(logSvc.check_dup_email(email))
				model.addAttribute("email_msg", "가입된 이메일입니다.");
			else
				model.addAttribute("email_msg", "사용가능한 이메일입니다.");
		}
		if( !password.isEmpty()&&password!=null ) {
			System.out.println("비밀번호 있음");
			model.addAttribute("password", password);
		}
		if( !pw_confirm.isEmpty()&&pw_confirm!=null ) {
			System.out.println("비밀번호 확인 있음");
			model.addAttribute("pw_confirm", pw_confirm);
		}
		if( !phNumber.isEmpty()&&phNumber!=null ) {
			System.out.println("전화번호 앞자리 있음");
			model.addAttribute("phNumber", phNumber);
		}
		if( !phNumber2.isEmpty()&& phNumber2!=null ) {
			System.out.println("전화번호 뒷자리 있음");
			model.addAttribute("phNumber2", phNumber2);
		}
		if( !postalcode.isEmpty()&& postalcode!=null ) {
			System.out.println("우편번호 있음");
			model.addAttribute("postalcode", postalcode);
		}
		if( !basic_address.isEmpty()&& basic_address!=null ) {
			System.out.println("기본 주소 있음");
			System.out.println(basic_address);
			model.addAttribute("basic_address", basic_address);
		}
		if( !detail_address.isEmpty()&& detail_address!=null ) {
			System.out.println("상세주소 있음");
			model.addAttribute("detail_address", detail_address);
		}
		model.addAttribute("msg", 
				logSvc.check_none(name, nickname, birthday, gender, 
				email, password, pw_confirm, phNumber, phNumber2));
		if(!name.isEmpty()&&name!=null && !nickname.isEmpty()&&nickname!=null && birthday!=null && 
				!gender.isEmpty()&&gender!=null && !email.isEmpty()&&email!=null && 
				!password.isEmpty()&&password!=null && !pw_confirm.isEmpty()&&pw_confirm!=null && 
				!phNumber.isEmpty()&&phNumber!=null && !phNumber2.isEmpty()&& phNumber2!=null) {
			System.out.println("필수 인자값 모두 입력됨!");
			// birthday 인자값 timestamp로 변환
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			Timestamp birth = Timestamp.valueOf(sdf.format(birthday));
			System.out.println("birthday check" + birthday);
			// gender 변환
			int gen = 0;
			int code = 0;
			try {
				gen = Integer.parseInt(gender);
				code = Integer.parseInt(postalcode);
			} catch (NullPointerException e) {
				System.out.println(e);
			}
			System.out.println("gen" + gen + "/code" +  code);
			// ph 인자값 결합
			String ph = "010"+ phNumber + phNumber2;
			// agreeReceive 값 결합 및 변환
			int agreeReceive = 0;
			if( agree_receive_email==null || agree_receive_email.isEmpty() || agree_receive_sms==null || agree_receive_sms.isEmpty()) {
				agreeReceive = 0;
				System.out.println("agree없음");
			}else {
				if( agree_receive_email.equals("agree_email"))
					agreeReceive += 1;
				if( agree_receive_sms.equals("agree_sms"))
					agreeReceive += 2;
				System.out.println("agree있음");
			}
			System.out.println("agreeReceive " + agreeReceive);
			
			if(logSvc.joinMember(cnm_upload_pic, name, nickname, birth, gen, 
					email, password, ph, agreeReceive, basic_address, 
					detail_address, code)) {
				System.out.println(name + "회원 생성 성공");
			} else {
				System.out.println(name + "회원성공 실패");
			}
			
			return "member/login";
			
		}
		return "member/create_new_member";
//		model.addAttribute("pic", cnm_upload_pic);
//		model.addAttribute("name", name); 
//		model.addAttribute("birthday", birthday);
//		model.addAttribute("gender", gender);
//		model.addAttribute("email", email);
//		model.addAttribute("pw", password);
//		model.addAttribute("pw_confirm", pw_confirm); 
//		model.addAttribute("ph1", phNumber);
//		model.addAttribute("ph2", phNumber2);
//		model.addAttribute("postal_code", postalcode);
//		model.addAttribute("basic_adress", basic_address);
//		model.addAttribute("detail_adress", detail_address);
//		model.addAttribute("agree_mail", agree_receive_email); 
//		model.addAttribute("agree_sms", agree_receive_sms);
		
		
		
//		MemberVO mb = new MemberVO(
//				null, cnm_mb_name, cnm_mb_nick, birthday, cnm_mb_gender, 
//				cnm_mb_email, cnm_mb_pw, ph, agreeReceive, cnm_mb_adress_basic, 
//				cnm_mb_adress_detail, cnm_mb_adress_num);
		
		// 만약 null 예외가 있으면 프론트엔드(즉 JS)에서 처리 후 넘어오게함. 대신 그곳에서 강제로 뚫고 들어왔을때 대비해서 만든 예외처리
		// UQ가 걸린 3개 항목 nickname/email/ph_number를 검색해서 사용가능한지 확인하는 서비스 단을 구성해야됨.
	}
	// 닉네임 중복체크
	@RequestMapping(value="nic_dupcheck.LF", method=RequestMethod.GET)
	@ResponseBody
	public String nicknameDupCheck(String nickname) {
		// req.getParam과 타입맵핑을 자동으로 해줌
		System.out.println("nic_dupcheck.LF");
		//String login = req.getParameter("login");
		if( nickname != null && !nickname.isEmpty() ) {
			if( logSvc.check_dup_nick(nickname) ) {
				return "yes";
			} else {
				return "no";
			}
		} else {
			return "error";
		} 
	}
	// 이메일 중복체크
	@RequestMapping(value="email_dupcheck.LF", method=RequestMethod.GET)
	@ResponseBody
	public String emailDupCheck(String email) {
		// req.getParam과 타입맵핑을 자동으로 해줌
		System.out.println("email_dupcheck.LF");
		//String login = req.getParameter("login");
		if( email != null && !email.isEmpty() ) {
			if( logSvc.check_dup_email(email) ) {
				return "yes";
			} else {
				return "no";
			}
		} else {
			return "error";
		} 
	}
//		System.out.println("들어옴"+nickname);
//		ses.setAttribute("nickname", nickname);
//		if(logSvc.check_dup_nick(nickname))
//			ses.setAttribute("nick_msg", "중복된 닉네임입니다.");
//			model.addAttribute("nick_msg", "중복된 닉네임입니다.");
//		else
//			ses.setAttribute("nick_msg", "사용가능한 닉네임입니다.");
//			model.addAttribute("nick_msg", "사용가능한 닉네임입니다.");
//		return "redirect:join_new_member.LF";
//		return "member/create_new_member";
//	}
	//test_proc.LF
//	@RequestMapping(value="test_proc.LF", method=RequestMethod.POST)
//	public String test_proc(HttpSession ses, Model model, String cnm_upload_pic,
//			String name, String nickname, @DateTimeFormat(pattern="yyyy-MM-dd")Date birthday,
//			String gender, String email, String password,
//			String pw_confirm, String phNumber, String phNumber2,
//			String postalcode, String basic_address, String detail_address,
//			String agree_receive_email, String agree_receive_sms
//	@RequestMapping(value="check_dup_nic.LF", method=RequestMethod.POST)
//	public String test_proc(HttpSession ses, Model model 
//			@ModelAttribute(value = "pic")String cnm_upload_pic, 
//			@ModelAttribute(value = "name")String name, 
//			@ModelAttribute(value = "nickname")String nickname, 
//			@ModelAttribute(value = "birthday")String birthday,
//			@ModelAttribute(value = "gender")String gender, 
//			@ModelAttribute(value = "email")String email, 
//			@ModelAttribute(value = "pw")String password,
//			@ModelAttribute(value = "pw_confirm")String pw_confirm, 
//			@ModelAttribute(value = "ph1")String phNumber, 
//			@ModelAttribute(value = "ph2")String phNumber2,
//			@ModelAttribute(value = "postalcode")String postalcode,
//			@ModelAttribute(value = "basic_adress")String basic_address,
//			@ModelAttribute(value = "detail_adress")String detail_address,
//			@ModelAttribute(value = "agree_mail")String agree_receive_email, 
//			@ModelAttribute(value = "agree_sms")String agree_receive_sms
//			){
//		System.out.println("test");
//		System.out.println(nickname + "test");
//		model.addAttribute("pic", cnm_upload_pic);
//		model.addAttribute("name", name); 
//		model.addAttribute("nickname", nickname);
//		model.addAttribute("birthday", birthday);
//		model.addAttribute("gender", gender);
//		model.addAttribute("email", email);
//		model.addAttribute("pw", password);
//		model.addAttribute("pw_confirm", pw_confirm); 
//		model.addAttribute("ph1", phNumber);
//		model.addAttribute("ph2", phNumber2);
//		model.addAttribute("postal_code", postalcode);
//		model.addAttribute("basic_adress", basic_address);
//		model.addAttribute("detail_adress", detail_address);
//		model.addAttribute("agree_mail", agree_receive_email); 
//		model.addAttribute("agree_sms", agree_receive_sms);
//		return "redirect:join_new_member.LF";
//	}
	
//이메일 찾기		******일단 기능 미구현으로 남김...********				
	//	find_mb_login.lf (form; get; 비회원)			이메일찾기 폼 이동
	//	find_login.lf (proc; post; dao; 비회원)			이메일찾기proc실행(findEmail(phNumber) )
	// 로그인창에서 아이디찿기 클릭시 
//	@RequestMapping(value="find_mb_login.LF", method=RequestMethod.GET)
//	public String memberFindLoginPage() {
//		System.out.println("memberFindLoginPage()...");
//		return "member/find_mb_login";
//	}


//비밀번호 찾기						
	//	find_mb_pw.lf (form; get; 비회원)			비밀번호 재발급폼 이동
	// 로그인창에서 비밀번호 찾기 클릭시
	@RequestMapping(value="find_mb_pw.LF", method=RequestMethod.GET)
	public String memberFindPasswordPage() {
		System.out.println("memberFindPasswordPage()...");
		return "member/find_mb_pw";
	}
	
	//	find_pw_proc.lf (proc; post; dao; 비회원)			비밀번호 재발급proc실행(createNewPWToEmail(email)
	@RequestMapping(value="find_pw_proc.LF", method=RequestMethod.POST)
	public String memberFindPasswordProc(Model model,
			String email, String name, String phNumber) {
		System.out.println("memberFindPasswordProc()...");
		if(email!=null&&!email.isEmpty()&&name!=null&&!name.isEmpty()&&phNumber!=null&&!phNumber.isEmpty()) {
			System.out.println("모든 인자값 다 있음");
			if(logSvc.findPw(email, name, phNumber)==1) {
				System.out.println("회원 db에서 찾음");
				String password = logSvc.makeTemptPw();
				System.out.println("password: " + password);
				if(logSvc.makeTempPwIn(email, password)) {
					System.out.println("임시비밀번호 생성 완료");
					return "redirect:/";
				}
			} else {
				System.out.println("등록된 회원 없음...");
				model.addAttribute("msg","가입되지 않은 회원입니다...");
			}
		} else if(email==null || email.isEmpty()) {
			System.out.println("email없음");
			model.addAttribute("msg","이메일을 입력하세요!");
		} else if(name==null || name.isEmpty()) {
			System.out.println("name없음");
			model.addAttribute("msg","이름을 입력하세요!");
		} else if(phNumber==null || phNumber.isEmpty()) {
			System.out.println("phNumber없음");
			model.addAttribute("msg","휴대전화번호를 입력하세요!");
		}
		return "redirect:find_mb_pw.LF";
	}
	
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
	@RequestMapping(value="mypage.LF", method= {RequestMethod.GET, RequestMethod.POST})
	public String memberMyPage(HttpSession ses, Model model) {
		System.out.println("memberMyPage()");
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		if(mb != null) {
			model.addAttribute("mb", mb);
			model.addAttribute("mbLoginNicname", mb.getNicname());
			System.out.println("mb = " + mb);
			return "member/mypage.ho";
		} else {
			// 실패시 로그인창으로~
			model.addAttribute("msg", "로그인후 이용가능합니다.");
			return "member/login";
		}
	}		
	
//	회원의 프로필 사진 수정하기							
//	change_pro_pic.lf(proc; post, dao, attr)			proc완료후 mypage.lf 프로필사진 업데이트된 상태로 forward
	@RequestMapping(value="change_pro_pic.LF", method=RequestMethod.POST)
	public String memberChangeProfilePicture(HttpSession ses,
			@RequestParam(value="pic", defaultValue ="") String filePath,  
			Model model) {
		System.out.println("memberChangeProfilePicture()...");		
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		int mbId = mb.getId();
		boolean b = mpSvc.updateMemberProfileImg(mbId, filePath);
		if( b ) {
			model.addAttribute("msg", "회원 프로필 이미지 변경 성공");
		} else {
			model.addAttribute("msg", "회원 프로필 이미지 변경 실패");
			model.addAttribute("errCode", 1);
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
	
	@RequestMapping(value="mypage_delete_attending_lec.LF", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> memberMypageDeleteAttendingLec(HttpSession ses) 
	{
		System.out.println("memberMypageDeleteAttendingLec()");
		Map<String, Object> rMap = new HashMap<>();
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		int mbId = mb.getId();
		
		return null;
	}
	
//회원이 신청한 강의목록 표시하기							수강 관리
//	수강중인강의
//	mypage_attending_class.lf(proc, post, dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_attending_lec.LF", method=RequestMethod.POST)
	public String memberMypageAttendingLec(HttpSession ses,
			@RequestParam(value="status", defaultValue ="0") int status, Model model) {
		System.out.println("memberMypageAttendingLec()...");
		// 내가 수강한 비디오 목록을 리스트로 받으려함
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		System.out.println("mb = " + mb);
		if(mb != null) { 
			int mbId = mb.getId();
			List<ShowClassVideoVO> scvList = mpSvc.selectLecToStatusForMbIdStatus(mbId, status);
			if(scvList != null) {
				System.out.println("scvList = " + scvList + " / scvList.size() = " + scvList.size());
				model.addAttribute("scvList", scvList);
			} else {
				System.out.println("scvList = null");
				model.addAttribute("msg_status", "수강중인 강의");
				model.addAttribute("mp_msg", "수강중인 강의 내역이 없습니다.");
			}
			return "member/mypage/attend_lec_manager/mypage_attending_lec";
		} else {
			model.addAttribute("msg", "로그인후 이용가능합니다.");
			return "member/login";
		}
	}
	
	//회원이 찜하기한 강의 확인하기							
//	mypage_will_attend.lf(proc,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_will_attend.LF", method=RequestMethod.POST)
	public String memberMypageWillAttend(HttpSession ses,
			@RequestParam(value="status", defaultValue ="1") int status, Model model) {
		System.out.println("memberMypageWillAttend()...");	
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		if(mb != null) { 
			int mbId = mb.getId();
			Map<String, Object> listMap = mpSvc.selectVideoAndCreImgPathAndCreNicname(mbId, status);
			if(listMap != null) {
				List<VideoVO> vdList = (List<VideoVO>)listMap.get("vdList");
				List<String> creImgPathList = (List<String>)listMap.get("creImgPathList");
				List<String> creNickNameList = (List<String>)listMap.get("nickNameList");
				System.out.println("vdList = " + vdList + " / creImgPathList = " + creImgPathList +
						  " / creNickNameList" + creNickNameList);
				model.addAttribute("vdList", vdList);
				model.addAttribute("creImgPathList", creImgPathList);
				model.addAttribute("creNickNameList", creNickNameList);
		
			} else {
				
				model.addAttribute("msg_status", "찜하기한 강의");
				model.addAttribute("mp_msg", "찜하기한 강의 내역이 없습니다.");
			}
			return "member/mypage/attend_lec_manager/mypage_will_attend";
		} else {
			System.out.println("mb = null");
			model.addAttribute("msg", "로그인후 이용가능합니다.");
			return "member/login";
		}
	}

	//회원이 좋아요한 강의 확인하기							
	//	mypage_like.lf(proc,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_like.LF", method=RequestMethod.POST)
	public String memberMypageLike(HttpSession ses, 
			@RequestParam(value="status", defaultValue ="2") int status, Model model) {
		System.out.println("memberMypageLike()...");
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		if(mb != null) {
			int mbId = mb.getId();
			Map<String, Object> listMap = mpSvc.selectVideoAndCreImgPathAndCreNicname(mbId, status);
			System.out.println("listMap = " + listMap);
			if(listMap != null) {
				List<VideoVO> vdList = (List<VideoVO>)listMap.get("vdList");
				List<String> vdCateList = (List<String>)listMap.get("vdCateList");
				List<String> creImgPathList = (List<String>)listMap.get("creImgPathList");
				List<String> creNickNameList = (List<String>)listMap.get("nickNameList");
				System.out.println("vdList = " + vdList + " / creImgPathList = " + creImgPathList +
						  " / creNickNameList" + creNickNameList);
				model.addAttribute("vdList", vdList);
				model.addAttribute("vdCateList", vdCateList);
				model.addAttribute("creImgPathList", creImgPathList);
				model.addAttribute("creNickNameList", creNickNameList);
			} else {
				model.addAttribute("msg_status", "좋아요한  강의");
				model.addAttribute("mp_msg", "좋아요한 강의 내역이 없습니다.");
			}
			return "member/mypage/attend_lec_manager/mypage_like";
		} else {
			model.addAttribute("msg", "로그인후 이용가능합니다.");
			return "member/login";
		}
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
	public String memberMypageComment(HttpSession ses,
			@RequestParam(value = "pn", required = false, defaultValue = "1" ) int pageNumber,
			Model model) 
	{
		System.out.println("memberMypageComment()...");
		System.out.println("pn =" + pageNumber);
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		int mbId = mb.getId();
		System.out.println("mb = " + mb);
		Map<String, Object> qnaComMap = mpSvc.selectAllMyComment(mbId, pageNumber);
		System.out.println("qnaComMap = " + qnaComMap);
		if( qnaComMap != null ) {
			int totalRecords = (int)qnaComMap.get("totalRecords");
			int maxPG = (int)qnaComMap.get("maxPG");
			List<QnaCommentVO> qnacomList = (List<QnaCommentVO>)qnaComMap.get("qnacomList");
			List<QnaVO> qnaList = (List<QnaVO>)qnaComMap.get("qnaList");
			model.addAttribute("totalRecords", totalRecords);
			model.addAttribute("maxPG", maxPG);
			model.addAttribute("qnacomList", qnacomList);
			model.addAttribute("qnaList", qnaList);
			model.addAttribute("pn", pageNumber);
		} else {
			model.addAttribute("msg_status", "댓글 내역");
			model.addAttribute("mp_msg", mb.getNicname() + " 님의 댓글 내역이 없습니다.");
		}
		return "member/mypage/activity/mypage_comment";
	}

//회원이 문의한 qna내역 확인하기							문의 내역
//	mypage_qna.lf(proc,post,dao)				해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_qna.LF", method=RequestMethod.POST)
	public String memberMypageQna( HttpSession ses,
			@RequestParam(value = "pn", required = false, defaultValue = "1" ) int pageNumber,
			Model model ) {
		System.out.println("memberMypageQna()...");
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		int mbId = mb.getId();
		System.out.println("mb = " + mb);
		Map<String, Object> qnaMap = mpSvc.selectAllMyQna(mbId, pageNumber);
		
		if( qnaMap != null ) {
			int totalRecords = (int)qnaMap.get("totalRecords");
			int maxPG = (int)qnaMap.get("maxPG");
			List<QnaVO> qnaList = (List<QnaVO>)qnaMap.get("qnaList");
			model.addAttribute("totalRecords", totalRecords);
			model.addAttribute("maxPG", maxPG);
			model.addAttribute("qnaList", qnaList);
			model.addAttribute("pn", pageNumber);
		} else {
			model.addAttribute("msg_status", "문의 내역" );
			model.addAttribute("mp_msg", mb.getNicname() + " 님의 문의 내역이 없습니다.");
		}
		return "member/mypage/activity/mypage_qna";
		
	}
//펀딩신청내역 확인하기	펀딩 날림. -세현

	
//회원이 보유중인 쿠폰 표시							나의쿠폰
//	mypage_coupon.lf(proc,post,dao)			해당 조각페이지 불러오게 리턴
	@RequestMapping(value="mypage_coupon_info.LF", method=RequestMethod.POST)
	public String memberMypageCoupon( HttpSession ses, 
			@RequestParam(value = "pn", required = false, defaultValue = "1" ) int pageNumber,
			Model model ) {
		System.out.println("memberMypageCoupon()...");
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		int mbId = mb.getId();
		Map<String, Object> couponMap = mpSvc.selectAllMyCoupon(mbId, pageNumber); // select 저함수안에서 디버그처리
		if( couponMap != null ) {
			int totalRecords = (int)couponMap.get("totalRecords");
			int maxPG = (int)couponMap.get("maxPG");
			List<CouponVO> couponList = (List<CouponVO>)couponMap.get("couponList");
			model.addAttribute("totalRecords", totalRecords);
			model.addAttribute("maxPG", maxPG);
			model.addAttribute("couponList", couponList);
			model.addAttribute("pn", pageNumber);
		} else {
			System.out.println("couponMap 은 null");
			model.addAttribute("msg_status", "나의 쿠폰" );
			model.addAttribute("mp_msg", mb.getNicname() + " 님이 등록하신 쿠폰이 없습니다.");
		}
		
		return "member/mypage/activity/mypage_coupon_info";
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
	public String memberMypageDeliveryInfo(HttpSession ses
			) 
	{
		System.out.println("memberMypageDeliveryInfo()...");
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		int mbId = mb.getId();
		System.out.println("mbId = " + mbId);
		Map<String, Object> rMap = mpSvc.selectMyPageDeliveryInfoMap(mbId);
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