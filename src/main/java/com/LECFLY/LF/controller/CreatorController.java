package com.LECFLY.LF.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.LECFLY.LF.model.dao.inf.creator.ILectureDAO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.service.impl.creator.LectureSVCImpl;

@Controller
@SessionAttributes({"creator","sawonDetail"})
public class CreatorController {
	public static int MAXPAGE = 0;
	@Autowired
	LectureSVCImpl LecSVC;
	@Autowired
	ILectureDAO LecDAO;
	@ModelAttribute("creator")
	public CreatorVO dummyvo() {
	return new CreatorVO();
	}
	@RequestMapping(value ="creator.LF", method= RequestMethod.GET)
	public String showLectureList(HttpSession ses, Model model ,@RequestParam(value = "page",defaultValue = "1",required = false) int page) {
		ses.setAttribute("id",1);
		ses.setAttribute("fid",2);
		int status =(Integer) ses.getAttribute("id");
		int fid =(Integer)ses.getAttribute("fid");
		if(status == 1 && page ==1) {
			MAXPAGE = LecSVC.checkOfLectureNumber(2);
			model.addAttribute("maxPage",MAXPAGE);
			model.addAttribute("lecList", LecSVC.showLectureList(2,page, 0));
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
	
	@RequestMapping(value = "creator_new_profile.LF" ,method =RequestMethod.GET)
	public String createProfile(Model model ,HttpSession ses ) {
		model.addAttribute("p",1);
		System.out.println("도착 뉴프로필");
		
		return "creator/cre_profile.page";
	}
	
	@RequestMapping(value = "creator_new_profile_proc.LF" ,method =RequestMethod.POST)
	@ResponseBody
	public String createProfile(Model model, @ModelAttribute(value="creator") CreatorVO cr   ) {
		model.addAttribute("p",1);
		System.out.println("정상");
		System.out.println(cr+"저장");
		return "creator/cre_profile.page";
	}
	@RequestMapping(value = "creator_new_lecture.LF" ,method =RequestMethod.GET)
	public String createLecture(Model model  ) {
		model.addAttribute("p",2);
		System.out.println("도착 뉴 렉쳐");
		
		return "creator/cre_lecture_upload.page";
	}
	
	@RequestMapping(value = "creator_new_lecture_proc.LF" ,method =RequestMethod.POST)
	@ResponseBody
	public String createLectureproc(Model model   ) {
		model.addAttribute("p",2);
		System.out.println("비정상");
		return "home.LF";
	}
	@RequestMapping(value = "creator_set_proc.LF" ,method =RequestMethod.POST)
	@ResponseBody
	public String createSetProc(Model model   ) {
		model.addAttribute("p",2);
		System.out.println("자동저장 ");
		return "home.LF";
	}
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "creator_video_show.LF" ,method =RequestMethod.POST)
	public String showVideoList( Model model ,HttpServletRequest req) {
		
		return "creator/cre_play_list.page";
	}
	
	@RequestMapping(value = "creator_new_lecture2.LF" ,method =RequestMethod.GET)
	public String createLecture(Model model ,HttpSession ses) {
		model.addAttribute("p",2);
		return "creator/cre_lecture_upload.page";
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
