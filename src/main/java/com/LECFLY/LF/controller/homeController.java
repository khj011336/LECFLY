package com.LECFLY.LF.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class homeController {
	@RequestMapping(value = "/home.LF", method = RequestMethod.GET )
	public String temphome() {
		System.out.println("도착");
		return "lecture/main.ho";
	}
	
}
