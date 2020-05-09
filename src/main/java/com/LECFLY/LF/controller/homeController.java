package com.LECFLY.LF.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class homeController {
	@RequestMapping(value = "/home.LF", method = RequestMethod.GET )
	public String temphome(HttpSession ses, Model model) {
		System.out.println("도착");
		return "lecture/main.ho";
	}
	// LecFly 이용안내
	@RequestMapping(value = "lecfly_guide.LF", method = RequestMethod.GET)
	public String lecflyGuide() {
		System.out.println("lecflyGuide()...");	
		return "payment/ticket_guide/lecfly_guide.ho";
	}	
	// LecFly TICKET
	@RequestMapping(value = "lecfly_ticket.LF", method = RequestMethod.GET)
	public String lecflyTicket() {
		System.out.println("lecflyTicket()...");	
		return "payment/ticket_guide/lecfly_ticket.ho";
	}
}
