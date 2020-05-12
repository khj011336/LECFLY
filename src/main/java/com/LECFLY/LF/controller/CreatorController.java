package com.LECFLY.LF.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.LECFLY.LF.model.dao.impl.creator.CreatorMysqlDAOImpl;
import com.LECFLY.LF.model.dao.impl.creator.LectureMysqlDAOImpl;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.service.impl.creator.CreatorSVCImpl;
import com.LECFLY.LF.service.impl.creator.LectureSVCImpl;

@Controller
@SessionAttributes({ "creator", "Lecture" })
public class CreatorController {
	public static int MAXPAGE = 0;
	@Autowired
	LectureSVCImpl LecSVC;
	@Autowired
	CreatorSVCImpl CreSVC;
	@Autowired
	LectureMysqlDAOImpl LecDAO;
	@Autowired
	CreatorMysqlDAOImpl CreDAO;
	 

	@ModelAttribute("creator")
	public CreatorVO dummyCRvo() {
		return new CreatorVO();
	}

	@ModelAttribute("Lecture")
	public LectureVO dummyLEvo() {
		return new LectureVO();
	}

	@RequestMapping(value = "creator.LF", method = RequestMethod.GET)
	public String showLectureList(HttpSession ses, Model model,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page) {
		ses.setAttribute("id", 1);
		ses.setAttribute("fid", 2);
		ses.setAttribute("membertest", "hongil");
		int status = (Integer) ses.getAttribute("id");
		int fid = (Integer) ses.getAttribute("fid");
		if (status == 1 && page == 1) {
			MAXPAGE = LecSVC.checkOfLectureNumber(2);
			model.addAttribute("maxPage", MAXPAGE);
			model.addAttribute("lecList", LecSVC.showLectureList(2, page, 0));
			return "creator/cre_class_list.page";
		} else if (status == 1 && page >= 2) {
			model.addAttribute("maxPage", MAXPAGE);
			List<LectureVO> LecList = LecSVC.showLectureList(2, page, 0);
			model.addAttribute("lecList", LecList);
			return "creator/_cre_class";
		} else {
			return "회원로그인폼";
		}
	}
	@RequestMapping(value = "creator_new_profile.LF" ,method =RequestMethod.GET)
	public String createProfile(Model model , HttpSession ses) {
		model.addAttribute("p", 1);
		System.out.println("도착 뉴프로필");
		return "creator/cre_profile.page";
	}
	 
	@RequestMapping(value = "creator_new_profile_proc.LF", method = RequestMethod.POST)
	public String createProfile(Model model, @ModelAttribute(value = "creator") CreatorVO cr, HttpSession ses,
			SessionStatus sesStatus , @RequestParam(value = "unloadA" ,required=false) String unload) {
//		세션 자동 저장단
		int countNull = 0;
		model.addAttribute("p", 1);
		
		LectureVO LecVO = (LectureVO) ses.getAttribute("Lecture");
		System.out.println("크리에이터 프로세스");
		CreSVC.fileProcessforCreator(cr, ses, model);
		if (unload.equals("y") ) {
			System.out.println("언로드진입");
			String nullcheck = LecVO.toString();
			String sep[] = nullcheck.split("=");
			for (int i = 0; i < 8; i++) {
				String value = sep[i].split(",")[0].trim();
				if ( !value.equals("0") &&!value.equals("null") &&!value.equals("category")) {
					if(!value.isEmpty()) {
						System.out.println(value);
					countNull++;
					}
				}
			}
			if (countNull >= 3) {
				System.out.println(" lec file > 3");
				int fid = (Integer)(ses.getAttribute("fid"));
				LecDAO.insertNewLecture(fid,LecVO.getCategory(),
						LecVO.getSubTitle(), LecVO.getTitle(), LecVO.getTitleImg(), LecVO.getInfoImg(), LecVO.getInfoImgb(),
						LecVO.getInfo(), cr.getNickname(),
						cr.getImgPath());
				CreDAO.insertNewCreator(fid, cr.getImgPath(), cr.getName(),
						cr.getNickname(), cr.getCellPhone(), cr.getSNS(), cr.getInfo());
				
			}
			sesStatus.setComplete();
		}
		return "creator/cre_lecture_upload.page";
	}

	@RequestMapping(value = "creator_new_lecture.LF", method = RequestMethod.GET)
	public String createLecture(Model model) {
		model.addAttribute("p", 2);
		return "creator/cre_lecture_upload.page";
	}

	@RequestMapping(value = "creator_new_lecture_proc.LF", method = RequestMethod.POST)
	public String createLectureproc(Model model, @ModelAttribute(value = "Lecture") LectureVO lec, HttpSession ses) {
//		세션 자동 저장단
		System.out.println("렉쳐 프로세스");
		model.addAttribute("p", 2);
		LecSVC.fileProcessforLectures(lec, ses, model);
		return "storeMapping";
	}

	@RequestMapping(value = "creator_set_proc.LF", method = RequestMethod.POST)
	public String createSetProc(Model model, HttpSession ses, SessionStatus sesStatus) {
		System.out.println("이탈 자동저장 ");
		LectureVO LeVO = (LectureVO) ses.getAttribute("Lecture");

		System.out.println(ses.getAttribute("creator"));
		System.out.println(ses.getAttribute("Lecture"));
		sesStatus.setComplete();
		return "creator/cre_class_list.page";
	}

	@RequestMapping(value = "creator_rightset_proc.LF", method = RequestMethod.POST)
	public ModelAndView createSetProc(ModelAndView model, @ModelAttribute(value = "Lecture") LectureVO lec,
			HttpSession ses) {
		System.out.println(ses.getAttribute("Lecture"));

		model.setViewName("redirect:creator/cre_class_list.page");
		return model;

	}

	@RequestMapping(value = "creator_video_show.LF", method = RequestMethod.POST)
	public String showVideoList(Model model, HttpServletRequest req) {

		return "creator/cre_play_list.page";
	}
	

	@RequestMapping(value = "creator_new_lecture2.LF", method = RequestMethod.GET)
	public String createLecture(Model model, HttpSession ses) {
		model.addAttribute("p", 2);
		return "creator/cre_lecture_upload.page";
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
