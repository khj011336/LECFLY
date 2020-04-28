package com.LECFLY.LF.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreatorController {
	
	@RequestMapping(value = "home.LF", method = RequestMethod.GET )
	public String temphome() {
		System.out.println("도착");
		return "home";
	}
	@RequestMapping(value ="creator.LF", method= RequestMethod.GET)
	public String showLectureList() {
		System.out.println("크리에이터");
		System.out.println("도착2");
		return "creator/creator_center";
		
	}
	
}
