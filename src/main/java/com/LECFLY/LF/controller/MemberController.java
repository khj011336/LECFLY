package com.LECFLY.LF.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	
	// 로그인창 으로 이동했을때
	@RequestMapping(value="login.LF", method=RequestMethod.GET)
	public String MemberLoginPage() {
		System.out.println("MemberLoginPage()...");
		return "member/login";
	}
	
	// 아
	@RequestMapping(value="log_in.LF", method=RequestMethod.POST)
	public String MemberLoginedHomePage() {
		
		return "home";
	} 

	
	
	
	
	
}
