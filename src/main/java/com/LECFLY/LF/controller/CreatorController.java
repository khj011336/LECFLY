package com.LECFLY.LF.controller;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.LECFLY.LF.model.dao.inf.creator.ICreatorDAO;
import com.LECFLY.LF.model.dao.inf.creator.ILectureDAO;
import com.LECFLY.LF.model.dao.inf.creator.IVideoDAO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.service.impl.creator.CreatorSVCImpl;
import com.LECFLY.LF.service.impl.creator.FileSVCImpl;
import com.LECFLY.LF.service.impl.creator.LectureSVCImpl;
import com.LECFLY.LF.service.inf.creator.IVideoSVC;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
@MultipartConfig(location ="C:\\fusion11\\apache-tomcat-8.5.50\\uploadTemp"
,maxFileSize = -1,maxRequestSize = -1,fileSizeThreshold = 1024)
@Controller
@SessionAttributes({ "creator", "Lecture" })
public class CreatorController {
	public static int MAXPAGE = 0;
	@Autowired
	LectureSVCImpl LecSVC;
	@Autowired
	CreatorSVCImpl CreSVC;
	@Autowired
	ILectureDAO LecDAO;
	@Autowired
	ICreatorDAO CreDAO;
	@Autowired
	IVideoSVC VdoSVC;
	@Autowired
	FileSVCImpl fileSVC;
	@ModelAttribute("creator")
	public CreatorVO dummyCRvo() {
		return new CreatorVO();
	}

	@ModelAttribute("Lecture")
	public LectureVO dummyLEvo() {
		return new LectureVO();
	}
	@ModelAttribute("video")
	public VideoVO dummyVIvo() {
		return new VideoVO();
	}

	@RequestMapping(value = "creator.LF", method = RequestMethod.GET)
	public String showLectureList(HttpSession ses, Model model,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page) {
		//TODO 멤버아이디 id fid  이름 수정 체크넘버 수정
		ses.setAttribute("id", 1);
		ses.setAttribute("fid", 2);
		ses.setAttribute("membertest", "hongil");
		ses.setAttribute("crPath", FileSVCImpl.getPath((String) ses.getAttribute("membertest"), 1));
		int loginStatus = (Integer) ses.getAttribute("id");
		int fid = (Integer) ses.getAttribute("fid");
		MAXPAGE = LecSVC.checkOfLectureNumber(2);
		if (loginStatus == 1 && page == 1) {
			MAXPAGE = LecSVC.checkOfLectureNumber(2);
			model.addAttribute("maxPage", MAXPAGE);
			model.addAttribute("lecList", LecSVC.showLectureList(2, page, 0));
			return "creator/cre_class_list.page";
		} else if (loginStatus == 1 && page >= 2) {
			model.addAttribute("maxPage", MAXPAGE);
			List<LectureVO> LecList = LecSVC.showLectureList(2, page, 0);
			model.addAttribute("lecList", LecList);
			return "creator/_cre_class";
		} else {
			return "회원로그인폼";
		}
	}

	@RequestMapping(value = "creator_new_profile.LF", method = RequestMethod.GET)
	public String createProfile(Model model, HttpSession ses) {
		model.addAttribute("p", 1);
		System.out.println("도착 뉴프로필");
		return "creator/cre_profile.page";
	}

	@RequestMapping(value = "creator_new_profile_proc.LF", method = RequestMethod.POST)
	public String createProfile(Model model, @ModelAttribute(value = "creator") CreatorVO cr, HttpSession ses,
			SessionStatus sesStatus, @RequestParam(value = "unloadA", required = false) String unload) {
//		세션 자동 저장단
		System.out.println("크리에이터 프로세스");
		model.addAttribute("p", 1);
		LectureVO LecVO = (LectureVO) ses.getAttribute("Lecture");
		//TODO 멤버관련 인수 수정
		String memberName = (String)ses.getAttribute("membertest");
		int memberId  =(Integer) ses.getAttribute("id") != null? (Integer) ses.getAttribute("id"): null  ;
		if(memberName != null) {
			cr.setId(memberId);
			cr.setName(memberName);
		}
		CreSVC.fileProcessforCreator(cr, ses, model);
		LecSVC.unloadProcess(unload, LecVO, ses, cr, sesStatus);
		return "creator/cre_lecture_upload.page";
	}

	@RequestMapping(value = "creator_new_lecture.LF", method = RequestMethod.GET)
	public String createLecture(Model model) {
		model.addAttribute("p", 2);
		return "creator/cre_lecture_upload.page";
	}

	@RequestMapping(value = "creator_new_lecture_proc.LF", method = RequestMethod.POST)
	public String createLectureproc(Model model, @ModelAttribute(value = "Lecture") LectureVO lec,
			SessionStatus sesStatus, HttpSession ses,
			@RequestParam(value = "unloadB", required = false) String unload) {
//		세션 자동 저장단
//TODO 회원이 크리에이터 인경우
		System.out.println("렉쳐 프로세스");
		model.addAttribute("p", 2);
		CreatorVO cr = (CreatorVO) ses.getAttribute("creator");
		LecSVC.fileProcessforLectures(lec, ses, model);
		LecSVC.unloadProcess(unload, lec, ses, cr, sesStatus);
		
		return "storeMapping";
	}

	@RequestMapping(value = "creator_rightset_proc.LF", method = RequestMethod.POST)
	public String createSetProc(Model model, @ModelAttribute(value = "Lecture") LectureVO lec,
			HttpSession ses , SessionStatus sesStatus) {
		//TODO 회원이 크리에이터 인경우 및 리다이렉트
		CreatorVO cr = (CreatorVO) ses.getAttribute("creator");
		LecSVC.storeProcess(lec, ses, cr, sesStatus, model);
		return "return:/creator/cre_class_list";
	}
 
	@RequestMapping(value = "creator_video_show.LF" ,method = RequestMethod.POST)
	public String showVideoList(HttpSession ses, Model model,
			@RequestParam(value="CFID" , required =false) String CF ,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value="category") int category
			) {
		
		int loginStatus = (Integer) ses.getAttribute("id");
			MAXPAGE = VdoSVC.checkOfLectureNumber(3);
		System.out.println("cf ==" +CF);
		if (loginStatus == 1 && page == 1) {
//TODO			cfid 임시 번호 입력 연결후 때 수정
			model.addAttribute("category",category);
			model.addAttribute("CFId","3");
			model.addAttribute("maxPage", MAXPAGE);
			model.addAttribute("videoPage", page);
			model.addAttribute("lecList", VdoSVC.showLectureList(3,page));
			return "creator/cre_play_list.page";
		}  
		return "creator/cre_play_list.page";
		
	}
		@RequestMapping(value = "creator_video_show_proc.LF" ,method = RequestMethod.GET)
		@ResponseBody
		public Map<String, Object> showVideoListProc(    
				@RequestParam(value="cfid" , required =false) String CF ,
				@RequestParam(value = "page", defaultValue = "1", required = false) int page) {
			Map<String,Object> jso = new HashMap<String, Object>();
			 jso.put("jsonText", VdoSVC.showLectureList(3,page));
			 jso.put("page",page);
			return jso ;

		}
	 
	@RequestMapping(value= "video_upload.LF", method = RequestMethod.GET)
	public String videoUpload(@RequestParam(value = "CFID") int CFID, Model model, HttpSession ses) {
		System.out.println(CFID);
		System.out.println(CFID);
		return "creator/cre_video_upload.page";
	}
	@RequestMapping(value= "video_upload_proc.LF", method = RequestMethod.POST)
	public String videoUpload( @ModelAttribute(value = "video") VideoVO vio, Model model, HttpSession ses
			 ) {
//		fileSVC.extractImage(dd, 2, fi);
//		비디오 강의 업로드시 좋아요 0 으로 업데이트
		return "";
	}
	@RequestMapping(value= "video_proc.LF", method = RequestMethod.POST)
	public String videoUpload( Model model, HttpSession ses,
			@RequestParam(value = "viFile")MultipartFile videoFile ) {
	  Map<String, String> storedFileName = fileSVC.writeFilesForvideo(videoFile, 1, "gong");
	  System.out.println(storedFileName.get("png"));
	  System.out.println(storedFileName.get("gif"));
	  System.out.println(storedFileName.get("video"));
//		비디오 강의 업로드시 좋아요 0 으로 업데이트
		return "";
	}
	 
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "creator_comment_List.LF", method = RequestMethod.GET)
	public String showCreCommentList() {
		return "creator/cre_comment_list.page";
	}

	@RequestMapping(value = "creator_CS.LF", method = RequestMethod.GET)
	public String showCreCSList() {
		return "creator/cre_cs_1.page";
	}

	@RequestMapping(value = "creator_statistics.LF", method = RequestMethod.GET)
	public String showstatisticsList() {
		return "creator/cre_statistics.page";
	}
}
