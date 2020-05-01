package com.LECFLY.LF.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.LECFLY.LF.model.dao.inf.creator.ICreatorDAO;
import com.LECFLY.LF.model.dao.inf.creator.ILectureDAO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.service.impl.creator.LectureSVCImpl;
import com.LECFLY.LF.service.inf.creator.ILectureSVC;

@Controller
public class CreatorController {
	LectureSVCImpl LecSVC;
	ICreatorDAO CreDAO;
	@RequestMapping(value = "home.LF", method = RequestMethod.GET )
	public String temphome() {
//		LecSVC.showLectureList(1, 1, 1, 1);
		System.out.println("도착");
		return "home";
	}
	@RequestMapping(value ="creator.LF", method= RequestMethod.GET)
	public String showLectureList(HttpSession ses, Model model ,HttpServletRequest req) {
		ses.setAttribute("id",0);
		int status =(Integer) ses.getAttribute("id");
		if(status == 1) {
			model.addAttribute("lecList",LecSVC.showLectureList(1, 3, 5, 1));
			return "redirect:creator/creator_centor";
		}else if(status== 2) {
			
		}else {
			
		}
		
		
		return "creator/creator_center";
		
	}
	
}
