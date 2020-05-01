package com.LECFLY.LF.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@RequestMapping(value="login.LF", method=RequestMethod.GET)
	public String MemberLoginPage() {
		System.out.println("MemberLoginPage()...");
		return "member/login";
	}
	
	
	
	
	
	
	
}
