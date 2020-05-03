package com.LECFLY.LF.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.LECFLY.LF.model.dao.inf.creator.ICreatorDAO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.service.impl.creator.LectureSVCImpl;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

@Controller
public class CreatorController {
	@Autowired
	LectureSVCImpl LecSVC;
	ICreatorDAO CreDAO;
	@RequestMapping(value = "home.LF", method = RequestMethod.GET )
	public String temphome() {
		System.out.println("도착");
		return "home";
	}
	@RequestMapping(value ="creator.LF", method= RequestMethod.GET)
	public String showLectureList(HttpSession ses, Model model ,HttpServletRequest request) {
		ses.setAttribute("id",1);
		int status =(Integer) ses.getAttribute("id");
		if(status == 1) {
			int r = request.getAttribute("page") == null?0:(int)request.getAttribute("page") ;
			model.addAttribute("lecList",LecSVC.showLectureList(2,r, 5, 0));
			
			return "creator/class_list.page";
		}else if(status== 2) { 
			
		}else {
			return "회원로그인폼";
		}
		return "creator/creator_center.page";
	}
	@RequestMapping(value ="creator.LF", method= RequestMethod.POST)
	@ResponseBody
	public List<LectureVO> showLectureList(HttpSession ses, Model model ) {
		Gson gs = new Gson();
		ses.setAttribute("id",1);
		
		int status =(Integer) ses.getAttribute("id");
		if(status == 1) {
			
			System.out.println(gs.fromJson("page",String.class));
			int pagenation = Integer.parseInt( gs.fromJson("page",String.class));
	
			
			System.out.println("arriving ajax");
			model.addAttribute("lecList",LecSVC.showLectureList(2,pagenation, 5, 0));
			List<LectureVO> vo = LecSVC.showLectureList(2,pagenation, 5, 0);
			
			return vo;
		}else if(status== 2) { 
			
		}else {

		}
		return null;
	}
	@RequestMapping(value = "creator_video_show.LF" ,method =RequestMethod.POST)
	public String showVideoList( Model model ,HttpServletRequest req) {
		
		return "creator/cre_play_list.page";
	}
	@RequestMapping(value = "creator_new_profile.LF" ,method =RequestMethod.GET)
	public String createProfile() {
		System.out.println("도착2");
		return "creator/creator_profile.page";
	}
}
