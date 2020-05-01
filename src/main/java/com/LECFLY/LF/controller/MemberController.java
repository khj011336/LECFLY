package com.LECFLY.LF.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	
//	로그인하기						
//		login.lf (form; get; 비회원)			로그인폼 이동
	@RequestMapping(value = "login.LF", method = RequestMethod.GET )
	public String loginForm() {
		System.out.println("로그인");
		return "login";
	}

//	log_in.lf (proc; post; 암호화; 세션; 회원)			로그인proc실행(selectOneMember(email,pw) )	
	@RequestMapping(value = "log_in.LF", method = RequestMethod.POST)
	public String login() {
		
		return "home";
	}	
//	회원가입하기						
//		clause.lf(form; get; 비회원)			약관 폼 이동		
//		agree_receive.lf(proc; post; 비회원)			약관 확인 여부 체크		
//		create_new_member.lf (form; get; 비회원)			회원가입 폼 이동		이동시 약관확인 여부 체크 확인후 이동
//		member_join.lf (proc; post; dao; 비회원)			회원가입proc 실행(createNewMember)		
//	이메일 찾기						
//		find_mb_login.lf (form; get; 비회원)			이메일찾기 폼 이동		
//		find_login.lf (proc; post; dao; 비회원)			이메일찾기proc실행(findEmail(phNumber) )		
//	비밀번호 찾기						
//		find_mb_pw.lf (form; get; 비회원)			비밀번호 재발급폼 이동		
//		find_pw.lf (proc; post; dao; 비회원)			비밀번호 재발급proc실행(createNewPWToEmail(email)		
//	로그아웃하기						
//		logout.lf (proc; get; 회원)			로그아웃proc실행 후 default로 이동		session의 memberVO 제거
	
}
