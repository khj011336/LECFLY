package com.LECFLY.LF.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.LECFLY.LF.model.dao.impl.creator.KitMysqlDAOImpl;
import com.LECFLY.LF.model.dao.inf.creator.ICreatorDAO;
import com.LECFLY.LF.model.dao.inf.creator.ILectureDAO;
import com.LECFLY.LF.model.vo.MemberVO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.service.impl.creator.CreatorSVCImpl;
import com.LECFLY.LF.service.impl.creator.FileSVCImpl;
import com.LECFLY.LF.service.impl.creator.LectureSVCImpl;
import com.LECFLY.LF.service.inf.creator.IVideoSVC;

@Controller
@SessionAttributes({ "creator", "Lecture", "video","creatorKit" })
public class CreatorController {
	public static int MAXPAGE = 0;
	public static String USERNAME = "";
	public static int memberId = 0;
	public static String imgPath = "";
	public static String videoPath = "";
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
	@Autowired
	KitMysqlDAOImpl kitDAO;
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
	@ModelAttribute("creatorKit")
	public KitVO dummyKitvo() {
		return new KitVO();
	}

	@RequestMapping(value = "creator.LF", method = RequestMethod.GET)
	public String showLectureList(HttpSession ses, Model model,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page) {
//		lectures fid = member id ; 
//		agreerecive 3= 승인 , 2 = 승인중 , 1 = 거절  
		MemberVO mb = (MemberVO) ses.getAttribute("member");
		if(mb != null) {
		memberId = mb.getId();
		MAXPAGE = LecSVC.checkOfLectureNumber(memberId);
		USERNAME = mb.getName();
		imgPath = "/images/2020/"+USERNAME+"/Img";
		videoPath = "/images/2020/"+USERNAME+"/video";
		int loginStatus = (Integer) ses.getAttribute("id");
		
		if (loginStatus == 1 && page == 1) {
			MAXPAGE = LecSVC.checkOfLectureNumber(2);
			model.addAttribute("maxPage", MAXPAGE);
			model.addAttribute("lecList", LecSVC.showLectureList(memberId, page, 0));
			return "creator/cre_class_list.page";
		} else if (loginStatus == 1 && page >= 2) {
			model.addAttribute("maxPage", MAXPAGE);
			List<LectureVO> LecList = LecSVC.showLectureList(memberId, page, 0);
			model.addAttribute("lecList", LecList);
			return "creator/_cre_class";
		}
		return "creator/_cre_class";
		}else {
			return "login.LF";
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
		// 언로드시 Lecture 정보가 지정해놓은 수보다 많이 입력되있으면 자동 저장하기위함
		LectureVO LecVO = (LectureVO) ses.getAttribute("Lecture");
		// TODO 멤버관련 인수 수정
		if (USERNAME != null) {
			cr.setFid(memberId);
			cr.setName(USERNAME);
		}
		CreSVC.fileProcessforCreator(cr, ses, model,USERNAME , memberId  );
		LecSVC.unloadProcess(unload, LecVO, ses, cr, sesStatus , USERNAME,memberId);
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
		LecSVC.fileProcessforLectures(lec,memberId, model , USERNAME);
		LecSVC.unloadProcess(unload, lec, ses, cr, sesStatus , USERNAME,memberId);

		return "storeMapping";
	}

	@RequestMapping(value = "creator_rightset_proc.LF", method = RequestMethod.POST)
	public String createSetProc(Model model, @ModelAttribute(value = "Lecture") LectureVO lec, HttpSession ses,
			SessionStatus sesStatus) {
		// TODO 회원이 크리에이터 인경우 및 리다이렉트
		CreatorVO cr = (CreatorVO) ses.getAttribute("creator");
		LecSVC.storeProcess(lec, memberId, cr, sesStatus, model , USERNAME);
		return "creator/cre_href";
	}

	@RequestMapping(value = "creator_video_show.LF", method = RequestMethod.GET)
	public String showVideoList(HttpSession ses, Model model, @RequestParam(value = "CFID", required = false) int CF,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "category") int category) {
		int loginStatus = (Integer) ses.getAttribute("id");
		System.out.println(USERNAME+"ddddd");
		System.out.println(memberId);
		int CFID =CF;
		MAXPAGE = VdoSVC.checkOfLectureNumber(CFID);
		if (loginStatus == 1 && page == 1) {
			return VdoSVC.showVideoList(category, CFID, MAXPAGE, page, model);
		}
		return "creator/cre_play_list.page";

	}

	@RequestMapping(value = "creator_video_show_proc.LF", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> showVideoListProc(@RequestParam(value = "CFID", required = false) int CF,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page) {
		Map<String, Object> jso = new HashMap<String, Object>();
		jso.put("jsonText", VdoSVC.showLectureList(CF, page));
		jso.put("page", page);
		return jso;

	}

	@RequestMapping(value = "video_upload.LF", method = RequestMethod.GET)
	public String videoUpload(@RequestParam(value = "CFID", defaultValue = "0") int CFID, Model model, HttpSession ses,
			@ModelAttribute(value = "video") VideoVO vio) {
		if (CFID != 0) {
			vio.setCFId(CFID);
			vio.setfId(memberId);
			model.addAttribute(vio);
		}
		return "creator/cre_video_upload.page";
	}

	@RequestMapping(value = "video_upload_proc.LF", method = RequestMethod.POST)
	public String videoUpload(@ModelAttribute(value = "video") VideoVO vio, Model model, SessionStatus sesStatus
			,@RequestParam(value = "unloadz") String unload) {
//		비디오 강의 업로드시 좋아요 0 으로 업데이트
		if(unload.equals("1")) {
			vio.setStatus(4);
		}
		System.out.println(vio.toString());
		VdoSVC.insertNewVideo(vio);
		sesStatus.setComplete();
		return "creator/cre_href";
	}

	@RequestMapping(value = "video_proc.LF", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> videoUploadProc(@ModelAttribute(value = "video") VideoVO vio, Model model,
			HttpSession ses, @RequestParam(value = "viFile", required = false) MultipartFile videoFile) {
//TODO		멤버 이름 수정 및 아이디 		비디오 강의 업로드시 좋아요 0 으로 업데이트
		return VdoSVC.videoProc(vio, videoFile, model,ses,imgPath,videoPath);
	}

	@RequestMapping(value = "video_img_proc.LF", method = RequestMethod.POST)
	@ResponseBody
	public String imgUploadProc(@ModelAttribute(value = "video") VideoVO vio, Model model,
			@RequestParam(value = "addimgFile", required = false) MultipartFile addimgfile) {
//TODO		멤버 이름 수정 및 아이디
		return VdoSVC.imgProc(vio, addimgfile, model,USERNAME);
	}
	@RequestMapping(value="kit_upload.LF" ,method = RequestMethod.GET )
		public String KitUpload(@RequestParam(value = "CFID", required = false) int CF,
				@RequestParam(value = "category") int category , Model model
				,@ModelAttribute(value = "creatorKit") KitVO kit)  {
		KitVO kitCheck = kitDAO.selectOneKit(CF);
		if(kitCheck != null) {
			kitCheck.setAttribute("update");
			model.addAttribute("creatorKit",kitCheck);
			
		}
		return "creator/cre_kit.page";
	}
	@RequestMapping(value="kit_upload_proc.LF" ,method = RequestMethod.POST )
	public String KitUploadProc(@RequestParam(value = "CFID", required = false) int CF,
			@RequestParam(value = "category") int category , Model model
			,@ModelAttribute(value = "creatorKit") KitVO kit , HttpSession ses)  {
		
		if(kit.getAttribute().equals("update")) {
			if(new File(FileSVCImpl.getPath(USERNAME, 1)+kit.getImgPath()).delete()) {
				System.out.println("기존 키트 이미지 삭제");
				Map<String, String> file = fileSVC.writeFile(kit.getKitImg(), CF, USERNAME);
				kit.setImgPath(file.get("file"));
				kitDAO.updateKit(kit);
			}
		}else {
		System.out.println(kit);
		
		Map<String, String> filea = fileSVC.writeFile(kit.getKitImg(), CF, USERNAME);
		kit.setImgPath(filea.get("file"));
		kit.setfId(memberId);
				kitDAO.insertKit(kit);
		}
		return "creator/cre_href";
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
