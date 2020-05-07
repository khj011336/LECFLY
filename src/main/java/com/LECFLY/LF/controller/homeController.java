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
	
}
