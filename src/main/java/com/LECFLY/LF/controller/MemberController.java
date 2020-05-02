package com.LECFLY.LF.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	
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
	
	//login.LF 에서 회원가입을 눌렀을시 약관동의 페이지
	@RequestMapping(value="clause.LF", method=RequestMethod.GET)
	public String memberClausePage() {
		System.out.println("memberClausePage()...");
		return "member/clause";
	}
	
	// 약관동의 에서 넘어와서 회원가입 폼이 준비된 페이지
	@RequestMapping(value="join_new_member.LF", method=RequestMethod.GET)
	public String memberJoinPage() {
		// 서비스: 약관페이지에서 넘어올떄 약관동의버튼 모두체크 하는 것을 처리 
		
//		if() { // 약관페이지에서 넘어올떄 약관동의버튼 모두체크시 
			return "member/create_new_member";
//		} else { // 약관을 모두 체크하지않았을경우
//			return "member/clause"; // 아니면
//			return "redirect:clause.LF?err=1" // 이런식??
//		}
	}
	
	// 로그인창에서 아이디찿기 클릭시 
	@RequestMapping(value="find_mb_login.LF", method=RequestMethod.GET)
	public String memberFindLoginPage() {
		System.out.println("memberFindLoginPage()...");
		return "member/find_mb_login";
	}
	
	// 로그인창에서 비밀번호 찾기 클릭시
	@RequestMapping(value="find_mb_pw.LF", method=RequestMethod.GET)
	public String memberFindPasswordPage() {
		System.out.println("memberFindPasswordPage()...");
		return "member/find_mb_pw";
	}
	
	
	
	
	
}