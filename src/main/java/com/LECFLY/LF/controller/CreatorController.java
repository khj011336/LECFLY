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
import org.springframework.web.servlet.ModelAndView;
import com.LECFLY.LF.model.dao.impl.creator.KitMysqlMybatisDAOImpl;
import com.LECFLY.LF.model.dao.inf.creator.ICreatorDAO;
import com.LECFLY.LF.model.dao.inf.creator.ILectureDAO;
import com.LECFLY.LF.model.dao.inf.creator.IVideoDAO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.model.vo.cscenter.NoticeVO;
import com.LECFLY.LF.model.vo.member.MemberVO;
import com.LECFLY.LF.service.impl.comment.CommentSVCImpl;
import com.LECFLY.LF.service.impl.creator.CreatorSVCImpl;
import com.LECFLY.LF.service.impl.creator.FileSVCImpl;
import com.LECFLY.LF.service.impl.creator.LectureSVCImpl;
import com.LECFLY.LF.service.inf.creator.IVideoSVC;
import com.LECFLY.LF.service.inf.cscenter.INoticeSVC;

@Controller
@SessionAttributes({ "creator", "Lecture", "video", "creatorKit" })
public class CreatorController {
	public static final int REFUSE = 1;
	public static final int APPLY = 2;
	public static final int GRANT = 3;
	public static final int WRITING = 4;
	private int MAXPAGE = 0;
	private String USERNAME = "";
	private int memberId = 0;
	private String imgPath = "";
	private String videoPath = "";
	private int isCreator = 0;
	public static final String[] CATEGORIRES = { "", "미술", "음악", "요리", "라이프스타일", "운동", "커리어", "여행" };
	public static final String[] GRANTSTATUS = { "", "거절", "요청중", "승인", "작성중" };
	@Autowired
	LectureSVCImpl LecSVC;
	@Autowired
	CreatorSVCImpl CreSVC;
	@Autowired
	ILectureDAO LecDAO;
	@Autowired
	ICreatorDAO CreDAO;
	@Autowired
	IVideoDAO ViDAO;
	@Autowired
	IVideoSVC VdoSVC;
	@Autowired
	FileSVCImpl fileSVC;
	@Autowired
	KitMysqlMybatisDAOImpl kitDAO;
	@Autowired
	CommentSVCImpl commentSVC;
	@Autowired
	private INoticeSVC ntSvc;

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
		MemberVO mb = new MemberVO(3, "dd", "길동", "hong", null, 1, "ad", "asd", "ddd", null, 3, 0, 0, 0, null, "dd",
				"dd", 1111, null, null);
		model.addAttribute("grant", GRANTSTATUS);

		if (mb != null) {
			memberId = mb.getId();
			MAXPAGE = LecSVC.checkOfLectureNumber(memberId);
			USERNAME = mb.getName();
			imgPath = "/images/2020/" + USERNAME + "/Img";
			videoPath = "/images/2020/" + USERNAME + "/video";
			CreatorVO creVO = CreDAO.selectOneCreator(memberId);
			System.out.println(creVO);
			if (creVO != null) {
				ses.setAttribute("creator", creVO);
				if (creVO.getStatus() == GRANT) {
					isCreator = GRANT;
				} else if (creVO.getStatus() == APPLY) {
					isCreator = APPLY;
				} else if (creVO.getStatus() == WRITING) {
					isCreator = WRITING;
				} else if (creVO.getStatus() == REFUSE) {
					isCreator = REFUSE;
				}
			}
		} else {
			return "member/login";
		}

		if (mb != null && page == 1) {
			MAXPAGE = LecSVC.checkOfLectureNumber(memberId);
			model.addAttribute("crPath", imgPath);
			model.addAttribute("isCreator", isCreator);
			model.addAttribute("maxPage", MAXPAGE);
			model.addAttribute("lecList", LecSVC.showLectureList(memberId, page, 0));
			return "creator/cre_class_list.page";
		} else if (mb != null && page >= 2) {
			model.addAttribute("crPath", imgPath);
			model.addAttribute("maxPage", MAXPAGE);
			List<LectureVO> LecList = LecSVC.showLectureList(memberId, page, 0);
			model.addAttribute("lecList", LecList);
			return "creator/_cre_class";
		}

		return "member/login";

	}

	@RequestMapping(value = "creator_writing_profile.LF", method = RequestMethod.GET)
	public String createProfileWriting(Model model,
			@RequestParam(value = "LecId", required = false, defaultValue = "0") int id, HttpSession ses,
			@ModelAttribute(value = "creator") CreatorVO cr) {
		model.addAttribute("isUpdate", 5);
		model.addAttribute("LecId", id);
		model.addAttribute("p", 1);
		model.addAttribute("isCreator", isCreator);
		model.addAttribute("crPath", imgPath);
		System.out.println("도착 뉴프로필 라이팅");
		if (cr.getId() == 0) {
			System.out.println("널첵");
			CreatorVO creVO = CreDAO.selectOneCreator(memberId);
			model.addAttribute("creator", creVO);
		}

		return "creator/cre_profile.page";
	}

	@RequestMapping(value = "creator_writing_lecture.LF", method = RequestMethod.GET)
	public String createLectureWriting(Model model, @ModelAttribute(value = "Lecture") LectureVO lec,
			@RequestParam(value = "LecId", required = false, defaultValue = "0") int id,
			@RequestParam(value = "isUpdate", required = false, defaultValue = "0") int up) {
		model.addAttribute("isUpdate", up);
		model.addAttribute("update", up);
		model.addAttribute("p", 2);
		model.addAttribute("isCreator", isCreator);
		model.addAttribute("crPath", imgPath);
		model.addAttribute("LecId", id);
		if (lec.getId() == 0) {
			LectureVO LecVO = LecDAO.selectOneLectureForUpdate(id);
			model.addAttribute("Lecture", LecVO);
		}
		return "creator/cre_lecture_upload.page";
	}

	@RequestMapping(value = "creator_writing_store.LF", method = RequestMethod.POST)
	public String createWritingStore(Model model, HttpSession ses, SessionStatus sesStatus,
			@RequestParam(value = "LecId", required = false, defaultValue = "0") int id,
			@RequestParam(value = "isUpdate", required = false, defaultValue = "0") int up,
			@ModelAttribute(value = "Lecture") LectureVO Lecvo, @ModelAttribute(value = "creator") CreatorVO CreVO) {
		model.addAttribute("isCreator", isCreator);
		System.out.println("작성중인 첫 프로필 처리2");
		CreatorVO creVO = CreVO;
		LectureVO lecVO = Lecvo;
		System.out.println(creVO);
		System.out.println(lecVO);
		System.out.println("id= " + id + "isUpdate = " + up);
		if (up == 0) {
			lecVO.setStatus(APPLY);
			creVO.setStatus(APPLY);
		}
		LecSVC.fileProcessforLectures(lecVO, memberId, model, USERNAME);
		if (isCreator == WRITING) {
			if (up == 0) {
				CreSVC.fileProcessforCreator(creVO, ses, model, USERNAME, memberId);
				CreDAO.updateCreator(creVO, memberId);
			}
			LecDAO.updateLecture(lecVO, creVO, id);
		} else {
			System.out.println("업데이트 진입");
			LecDAO.updateOnlyLecuture(lecVO, id);
		}
		sesStatus.setComplete();
		return "creator/cre_href";
	}

	@RequestMapping(value = "creator_update_profile.LF", method = RequestMethod.GET)
	public String createProfileUpdate(Model model, HttpSession ses, @ModelAttribute(value = "creator") CreatorVO cr) {
		model.addAttribute("p", 5);
		model.addAttribute("isCreator", isCreator);
		model.addAttribute("crPath", imgPath);
		System.out.println("도착 뉴프로필 update");
		if (cr.getId() == 0) {
			CreatorVO creVO = CreDAO.selectOneCreator(memberId);
			if (creVO != null) {
				model.addAttribute("creator", creVO);
			}
		}

		return "creator/cre_profile.page";
	}

	@RequestMapping(value = "creator_update_store.LF", method = RequestMethod.POST)
	public String createUpdateStore(Model model, HttpSession ses, SessionStatus sesStatus,
			@RequestParam(value = "isUpdate", required = false, defaultValue = "0") int up,
			@ModelAttribute(value = "creator") CreatorVO crvo) {
		CreatorVO creVO = crvo;
		System.out.println("크리에이터 업데이트 ");
		if (crvo.getImgPathM() != null && !creVO.getImgPathM().isEmpty()) {
			if (new File(FileSVCImpl.getPath(USERNAME, 1) + creVO.getImgPath()).delete()) {
				System.out.println("기존 크리에이터이미지 이미지 삭제");
			}
			Map<String, String> file = fileSVC.writeFile(creVO.getImgPathM(), memberId, USERNAME);
			creVO.setImgPath(file.get("file"));
			System.out.println("기존 크리에이터이미지 이미지 갱신");
		}
		System.out.println(creVO);
		CreDAO.updateCreator(creVO, memberId);
		sesStatus.setComplete();
		return "creator/cre_href";
	}

	@RequestMapping(value = "creator_new_profile.LF", method = RequestMethod.GET)
	public String createProfile(Model model, HttpSession ses) {
		model.addAttribute("p", 1);
		model.addAttribute("isCreator", isCreator);
		model.addAttribute("crPath", imgPath);
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
		if (USERNAME != null && isCreator != WRITING) {
			cr.setFid(memberId);
			cr.setName(USERNAME);
		}
		CreSVC.fileProcessforCreator(cr, ses, model, USERNAME, memberId);
		LecSVC.unloadProcess(unload, LecVO, ses, cr, sesStatus, USERNAME, memberId, isCreator);
		return "creator/cre_lecture_upload.page";
	}

	@RequestMapping(value = "creator_new_lecture.LF", method = RequestMethod.GET)
	public String createLecture(Model model, SessionStatus sesStatus,
			@RequestParam(value = "nl", required = false, defaultValue = "0") int cl, HttpSession ses,
			@ModelAttribute(value = "Lecture") LectureVO lecVo) {
		System.out.println(cl);
		int resetCounter = 1;
		model.addAttribute("crPath", imgPath);
		model.addAttribute("p", 2);
		model.addAttribute("isCreator", isCreator);
		if (cl == 1 && resetCounter == 1) {
			resetCounter++;
			model.addAttribute("Lecture", null);
			lecVo.setFid(memberId);
			model.addAttribute("Lecture", lecVo);
			System.out.println(ses.getAttribute("Lecture"));
		}
		System.out.println(ses.getAttribute("Lecture"));
		return "creator/cre_lecture_upload.page";
	}

	@RequestMapping(value = "creator_new_lecture_proc.LF", method = RequestMethod.POST)
	public String createLectureproc(Model model, @ModelAttribute(value = "Lecture") LectureVO lec,
			SessionStatus sesStatus, HttpSession ses,
			@RequestParam(value = "unloadB", required = false) String unload) {
//		세션 자동 저장단
		System.out.println("렉쳐 프로세스");
		model.addAttribute("p", 2);
		CreatorVO cr = (CreatorVO) ses.getAttribute("creator");
		LecSVC.fileProcessforLectures(lec, memberId, model, USERNAME);
		LecSVC.unloadProcess(unload, lec, ses, cr, sesStatus, USERNAME, memberId, isCreator);
		return "storeMapping";
	}

	@RequestMapping(value = "creator_rightset_proc.LF", method = RequestMethod.POST)
	public String createSetProc(Model model, @ModelAttribute(value = "Lecture") LectureVO lec, HttpSession ses,
			SessionStatus sesStatus) {
		// TODO 회원이 크리에이터 인경우 및 리다이렉트
		CreatorVO cr = (CreatorVO) ses.getAttribute("creator");
		LecSVC.storeProcess(lec, memberId, cr, sesStatus, model, USERNAME, isCreator);
		return "creator/cre_href";
	}

	@RequestMapping(value = "creator_video_show.LF", method = RequestMethod.GET)
	public String showVideoList(HttpSession ses, Model model, @RequestParam(value = "CFID", required = false) int CF,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "category") int category) {

		int CFID = CF;
		String xo[] = { "허용", "불가" };
		model.addAttribute("crPath", imgPath);
		model.addAttribute("commentxo", xo);
		MAXPAGE = VdoSVC.checkOfLectureNumber(CFID);
		if (page == 1) {
			return VdoSVC.showVideoList(category, CFID, MAXPAGE, page, model);
		}
		return "creator/cre_play_list.page";

	}

	@RequestMapping(value = "creator_video_show_proc.LF", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> showVideoListProc(@RequestParam(value = "CFID", required = false) int CF,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page) {
		Map<String, Object> jso = new HashMap<String, Object>();
		jso.put("crPath", imgPath);
		jso.put("CFID", CF);
		jso.put("jsonText", VdoSVC.showLectureList(CF, page));
		jso.put("page", page);
		return jso;

	}

	@RequestMapping(value = "video_upload.LF", method = RequestMethod.GET)
	public String videoUpload(@RequestParam(value = "CFID", defaultValue = "0") int CFID,
			@RequestParam(value = "category", defaultValue = "0") int category, Model model, HttpSession ses,
			@ModelAttribute(value = "video") VideoVO vio) {
		if (CFID != 0) {
			vio.setCategory(category);
			vio.setCFId(CFID);
			vio.setfId(memberId);
			model.addAttribute("categ", CATEGORIRES);
			model.addAttribute(vio);
			model.addAttribute("crPath", imgPath);
			model.addAttribute("viPath", videoPath);
		}
		return "creator/cre_video_upload.page";
	}

	@RequestMapping(value = "video_proc.LF", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> videoUploadProc(@ModelAttribute(value = "video") VideoVO vio, Model model,
			HttpSession ses, @RequestParam(value = "viFile", required = false) MultipartFile videoFile) {
		return VdoSVC.videoProc(vio, videoFile, model, ses, USERNAME, imgPath, videoPath);
	}

	@RequestMapping(value = "video_img_proc.LF", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> imgUploadProc(@ModelAttribute(value = "video") VideoVO vio, Model model,
			@RequestParam(value = "addimgFile", required = false) MultipartFile addimgfile) {
		model.addAttribute("crPath", imgPath);
		Map<String, String> imgMap = VdoSVC.imgProc(vio, addimgfile, model, USERNAME);
		imgMap.put("crPath", imgPath);
		return imgMap;
	}

	@RequestMapping(value = "video_upload_proc.LF", method = RequestMethod.POST)
	public String videoUpload(@ModelAttribute(value = "video") VideoVO vio, Model model, SessionStatus sesStatus,
			@RequestParam(value = "unloadz") String unload) {
		if (unload.equals("1")) {
			vio.setStatus(4);
		} else {
			vio.setStatus(3);
		}
		vio.setfId(memberId);
		System.out.println(vio.toString());
		VdoSVC.insertNewVideo(vio);
		sesStatus.setComplete();
		return "creator/cre_href";
	}

	@RequestMapping(value = "video_update.LF", method = RequestMethod.GET)
	public String videoUpdate(@RequestParam(value = "CFID", defaultValue = "0") int CFID,
			@RequestParam(value = "VID", defaultValue = "0") int id, Model model, HttpSession ses,
			@ModelAttribute(value = "video") VideoVO vio) {
		VideoVO viVO = ViDAO.selectOneVideo(CFID, id);
		System.out.println(viVO);
		if (viVO != null) {
			model.addAttribute("categ", CATEGORIRES);
			model.addAttribute("isUpdate", "5");
			model.addAttribute("video", viVO);
			model.addAttribute("videoUP", "1");
			model.addAttribute("crPath", imgPath);
			model.addAttribute("viPath", videoPath);
		}
		return "creator/cre_video_upload.page";
	}

	@RequestMapping(value = "video_update_proc.LF", method = RequestMethod.POST)
	public String videoUpdateProc(HttpSession ses, @ModelAttribute(value = "video") VideoVO vio,
			SessionStatus sesstatus) {
		System.out.println("비디오 업데이트 진입");
		if (vio.getCFId() != 0 && vio.getId() != 0) {
			System.out.println(vio + "업데이트");
			ViDAO.updateVideo(vio, vio.getCFId(), vio.getId());
			sesstatus.setComplete();
		}

		return "creator/cre_href";
	}

	@RequestMapping(value = "kit_upload.LF", method = RequestMethod.GET)
	public String KitUpload(@RequestParam(value = "CFID", required = false, defaultValue = "0") int CF,
			@RequestParam(value = "category") int category, Model model,
			@ModelAttribute(value = "creatorKit") KitVO kit) {
		KitVO kitCheck = kitDAO.selectOneKit(CF);
		model.addAttribute("CATEGORIRES", CATEGORIRES);
		model.addAttribute("CFID", CF);
		model.addAttribute("category", category);
		System.out.println(kitCheck);
		if (kitCheck != null) {
			System.out.println("널아님");
			kitCheck.setAttribute("update");
			model.addAttribute("creatorKit", kitCheck);
			model.addAttribute("crPath", imgPath);
			System.out.println(kitCheck + "2");
		}
		return "creator/cre_kit.page";
	}

	@RequestMapping(value = "kit_upload_proc.LF", method = RequestMethod.POST)
	public String KitUploadProc(@RequestParam(value = "CFID", required = false, defaultValue = "0") int CF,
			@RequestParam(value = "category") int category, Model model,
			@ModelAttribute(value = "creatorKit") KitVO kit, HttpSession ses, SessionStatus sesstatus) {
		boolean kitxo = false;
		System.out.println(kit.getAttribute());
		if (kit.getAttribute() != null && !kit.getAttribute().isEmpty()) {
			kitxo = kit.getAttribute().equals("update");
		}
		if (kitxo) {
			if (kit.getImgPath() != null && !kit.getImgPath().isEmpty()) {
				if (new File(FileSVCImpl.getPath(USERNAME, 1) + kit.getImgPath()).delete()) {
					System.out.println("기존 키트 이미지 삭제");
				}
			}
			Map<String, String> file = fileSVC.writeFile(kit.getKitImg(), CF, USERNAME);
			kit.setImgPath(file.get("file"));
			System.out.println(kit + "2");
			kitDAO.updateKit(kit, CF);
			sesstatus.setComplete();
		} else {
			System.out.println("킷저장단");
			Map<String, String> filea = fileSVC.writeFile(kit.getKitImg(), CF, USERNAME);
			kit.setCFId(CF);
			kit.setCategory(category);
			kit.setImgPath(filea.get("file"));
			kit.setfId(memberId);
			kitDAO.insertKit(kit);
			sesstatus.setComplete();
		}
		return "creator/cre_href";
	}

	@RequestMapping(value = "creator_lecplay.LF", method = RequestMethod.GET)
	public String show_video(Model model) {
		int fid = 30325;
		int CFID = 159;

		List<LectureVO> Lec = LecDAO.selectLectureList(CFID);
		String username = Lec.get(0).getImgPath().split("_")[1];
		String videoPath = "/images/2020/" + username + "/video";
		String imgPath = "/images/2020/" + username + "/Img";
		model.addAttribute("crPath", imgPath);
		model.addAttribute("viPath", videoPath);
		model.addAttribute("lecList", Lec);
		model.addAttribute("videoList", ViDAO.selectVideoTrack(fid, CFID));
		return "lecture/lecplay.page";
	}

	@RequestMapping(value = "creator_comment_List.LF", method = RequestMethod.GET)
	public String showCreCommentList(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			Model model) {
//		commentSVC.addComment(mbId, tableCate, atId, comment, mbNic, targetCtId);
		if (page == 1) {
			MAXPAGE = LecSVC.checkOfLectureNumber(memberId);
			model.addAttribute("crPath", imgPath);
			model.addAttribute("isCreator", isCreator);
			model.addAttribute("maxPage", MAXPAGE);
			model.addAttribute("lecList", LecSVC.showLectureList(memberId, page, 0));
			return "creator/cre_comment_list.page";
		} else if (page >= 2) {
			model.addAttribute("crPath", imgPath);
			model.addAttribute("maxPage", MAXPAGE);
			List<LectureVO> LecList = LecSVC.showLectureList(memberId, page, 0);
			model.addAttribute("lecList", LecList);
			return "creator/_cre_comment";
		}
		return "creator/cre_comment_list.page";
	}

	@RequestMapping(value = "creator_CS.LF", method = RequestMethod.GET)
	public ModelAndView creatorNotice(
			@RequestParam(value = "pn", required = false, defaultValue = "1") int pageNumber) {
		System.out.println("creatorNotice(PN)..");
		int ntmaxPG = ntSvc.checkMaxCreatorPageNumber();
		if (pageNumber > ntmaxPG || pageNumber <= 0) {
			System.out.println("잘못된 페이지 번호: " + pageNumber);
		}
		List<NoticeVO> ntList = ntSvc.showAllCreatorNotices(pageNumber);
		ModelAndView mav = new ModelAndView("creator/cre_cs_1.page");
		if (ntList != null) {
			mav.addObject("ntSize", ntList.size());
			mav.addObject("notice", ntList);
			mav.addObject("maxPn", ntmaxPG);
			mav.addObject("pn", pageNumber); // 활성페이지

			System.out.println("게시글리스트 조회 성공: " + ntList.size());
		} else {
			mav.addObject("msg", "게시글리스트 조회 실패!");
		}
		return mav;
	}

	@RequestMapping(value = "creator_statistics.LF", method = RequestMethod.GET)
	public String showstatisticsList(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			Model model) {
		if (page == 1) {
			MAXPAGE = LecSVC.checkOfLectureNumber(memberId);
			model.addAttribute("crPath", imgPath);
			model.addAttribute("isCreator", isCreator);
			model.addAttribute("maxPage", MAXPAGE);
			model.addAttribute("lecList", LecSVC.showLectureList(memberId, page, 0));
			return "creator/cre_statistics.page";
		} else if (page >= 2) {
			model.addAttribute("crPath", imgPath);
			model.addAttribute("maxPage", MAXPAGE);
			List<LectureVO> LecList = LecSVC.showLectureList(memberId, page, 0);
			model.addAttribute("lecList", LecList);
			return "creator/_cre_statistics";
		}
		return "creator/cre_statistics.page";
	}
}
