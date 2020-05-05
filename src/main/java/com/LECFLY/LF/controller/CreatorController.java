package com.LECFLY.LF.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.LECFLY.LF.model.dao.inf.creator.ICreatorDAO;
import com.LECFLY.LF.model.dao.inf.creator.ILectureDAO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.service.impl.creator.LectureSVCImpl;
import com.google.gson.Gson;

@Controller
public class CreatorController {
	public static int MAXPAGE = 0;
	@Autowired
	LectureSVCImpl LecSVC;
	@Autowired
	ILectureDAO LecDAO;
	@RequestMapping(value = "home.LF", method = RequestMethod.GET )
	public String temphome() {
		System.out.println("도착");
		return "home";
	}
	@RequestMapping(value ="creator.LF", method= RequestMethod.GET)
	public String showLectureList(HttpSession ses, Model model ,@RequestParam(value = "page",defaultValue = "1",required = false) int page) {
		ses.setAttribute("id",1);
		ses.setAttribute("fid",2);
		int status =(Integer) ses.getAttribute("id");
		int fid =(Integer)ses.getAttribute("fid");
		MAXPAGE = LecSVC.checkOfLectureNumber(fid);
		System.out.println(MAXPAGE);
		if(status == 1 && page ==1) {
			model.addAttribute("maxPage",MAXPAGE);
			model.addAttribute("lecList", LecSVC.showLectureList(2,1, 0));
			return "creator/cre_class_list.page";
		}else if(status == 1 &&page >=2){
			model.addAttribute("maxPage",MAXPAGE);
			List<LectureVO> LecList = LecSVC.showLectureList(2,page, 0);
			model.addAttribute("lecList",LecList);
			return "creator/_cre_class";
		}else {
			return "회원로그인폼";
		}
	}
	@RequestMapping(value = "creator_video_show.LF" ,method =RequestMethod.POST)
	public String showVideoList( Model model ,HttpServletRequest req) {
		
		return "creator/cre_play_list.page";
	}
	@RequestMapping(value = "creator_new_profile.LF" ,method =RequestMethod.GET)
	public String createProfile() {
		System.out.println("도착2");
		return "creator/cre_profile.page";
	}
	@RequestMapping(value = "creator_comment_List.LF" ,method =RequestMethod.GET)
	public String showCreCommentList() {
		return "creator/cre_comment_list.page";
	}
	@RequestMapping(value = "creator_CS.LF" ,method =RequestMethod.GET)
	public String showCreCSList() {
		return "creator/cre_cs_1.page";
	}
	@RequestMapping(value = "creator_statistics.LF" ,method =RequestMethod.GET)
	public String showstatisticsList() {
		return "creator/cre_statistics.page";
	}
}
