package com.LECFLY.LF.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.LECFLY.LF.model.vo.CommentClassVO;
import com.LECFLY.LF.model.vo.CouponVO;
import com.LECFLY.LF.model.vo.FaqVO;
import com.LECFLY.LF.model.vo.HomeFileManagerVO;
import com.LECFLY.LF.model.vo.MemberVO;
import com.LECFLY.LF.model.vo.NoticeVO;
import com.LECFLY.LF.model.vo.QnaCommentVO;
import com.LECFLY.LF.model.vo.QnaVO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.service.inf.admin.IAdminBoardSVC;
import com.LECFLY.LF.service.inf.admin.IAdminFileSVC;
import com.LECFLY.LF.service.inf.admin.IAdminLectureSVC;
import com.LECFLY.LF.service.inf.admin.IAdminMemberSVC;
import com.LECFLY.LF.service.inf.admin.IAdminSiteSVC;

@Controller
public class AdminController {
	
	@Autowired
	private IAdminSiteSVC adSiteSvc;
	@Autowired
	private IAdminLectureSVC adLecSvc;
	@Autowired
	private IAdminMemberSVC adMbSvc;
	@Autowired
	private IAdminBoardSVC adBdSvc;

	@Autowired
	private IAdminFileSVC adFileSvc;
	
	// 관리자 홈
	@RequestMapping(value = "/admin.LF", method = RequestMethod.GET)
	public String adminHome() {
		return "admin/admin_main.ad";
	}
	// 관리자 사이트이용안내
	@RequestMapping(value = "/admin_site.LF")
	public String adminSite() {
		return "admin/adminSite/admin_site.ad";
	}
	// 관리자 배너관리
	@RequestMapping(value = "/admin_banner.LF")
	public String adminBanner() {
		return "admin/adminSite/admin_banner.ad";
	}
	// 관리자 배너삭제
	@RequestMapping(value = "/admin_delete_banner.LF")
	public String adminDeleteBanner(HomeFileManagerVO vo,@RequestParam("deleteId") String[] ids) {
		for (String id : ids) {
			vo.setId(Integer.parseInt(id));
			boolean r = adSiteSvc.deleteBanner(vo);
			if(r) {
				System.out.println("삭제성공");
			} else {
				System.out.println("삭제실패");
			}
		}	
		return "redirect:admin_banner.LF";
	}
	// 관리자 배너목록 출력
	@RequestMapping(value = "/admin_banner_list.LF", method = RequestMethod.GET)
	public String adminBannerListAll(HomeFileManagerVO vo, Model model) {
		model.addAttribute("bannerList", adSiteSvc.selectBannerList());
		return "admin/adminSite/admin_banner.ad";
	}
	// 관리자 배너 등록
	@RequestMapping(value = "/admin_insert_banner.LF", method = RequestMethod.POST)
	public String adminInsertBanner(HomeFileManagerVO vo,@RequestParam("bannerFile") MultipartFile upfile, HttpSession ses) throws IOException {
		System.out.println("adminInsertBanner()");
		
		String realPath = ses.getServletContext().getRealPath(IAdminFileSVC.DEF_ADMIN_UPLOAD_DEST + "/");
		String filePath = adFileSvc.insertUploadFile(upfile, realPath);
		
		vo.setFileName(upfile.getOriginalFilename());
		vo.setFilePath(filePath);
		vo.setFileSize(upfile.getSize());
		
		System.out.println(vo.toString());
		boolean r = adSiteSvc.insertBanner(vo);
		if(r) {
			System.out.println("업로드성공");
			return "redirect:admin_banner_list.LF";
		} else {
			System.out.println("업로드실패");
			return "redirect:admin_banner.LF";
		}
	}
	// 관리자 추천강의 관리
	@RequestMapping(value = "/admin_recommend.LF")
	public String adminRecommend() {
		return "admin/admin_recommend.ad";
	}
	// 홈의 모든 목록 조회(배너, 추천강의, 일반강의)
	@RequestMapping(value = "/home_show_all.LF")
	public String homeShowAll(HttpSession ses, Model model) {
		List<HomeFileManagerVO> bannerList = adSiteSvc.selectBannerList();
		List<Integer> reIds = adSiteSvc.getRecommendIds();
		List<LectureVO> recoList =  adSiteSvc.selectRecommendLectureList(reIds);
		List<LectureVO> nomalList =  adSiteSvc.selectNomalLectureList();
		model.addAttribute("bannerList", bannerList);
		model.addAttribute("recoList", recoList);
		model.addAttribute("nomalList", nomalList);
		return "redirect/home.LF";
	}
	
	// 관리자 계정관리
	@RequestMapping(value = "/admin_account.LF")
	public String adminAccount() {
		return "admin/admin_account.ad";
	}
	// 관리자 강의관리
	@RequestMapping(value = "/admin_lecture.LF")
	public String adminLecture(Model model) {
		List<LectureVO> lecList = adLecSvc.selectLectureList();
		model.addAttribute("lecList", lecList);
		return "admin/adminLecture/admin_lecture.ad";
	}
	// 관리자 강의관리(전체조회)
	@RequestMapping(value = "/admin_lecture_list.LF", method = RequestMethod.GET)
	public String adminLectureListProc(Model model, 
			@RequestParam(value = "pn",required = false, defaultValue = "1") int pageNumber) {
		Map<String,Integer> rMap = adLecSvc.checkMaxPageNumber();
		List<LectureVO> lecList = adLecSvc.selectAllLecture(pageNumber);
		if(lecList != null && rMap != null) {
			model.addAttribute("listSize", lecList.size());
			model.addAttribute("lecList", lecList);
			model.addAttribute("maxPn", rMap.get("maxPg"));
			model.addAttribute("totalRecords", rMap.get("totalRecords"));
			model.addAttribute("pn", pageNumber);
		}
		return "admin/adminLecture/admin_lecture.ad";
	}
	// 관리자 강의리스트(다중) 갱신 AJAX 호출
		@RequestMapping(value = "/admin_update_lecture_list.LF", method = RequestMethod.POST)
		public String adminLectureListUpdateProc(@RequestParam(value="checkList[]") List<Integer> checkList) {
			for (Integer id : checkList) {
				System.out.println("체크 id: "+id);
			}
			return "redirect:admin_lecture_list.LF";
		}
	// 관리자 영상관리
	@RequestMapping(value = "/admin_video.LF")
	public String adminVideo(Model model) {
		List<VideoVO> vdList = adLecSvc.selectVideoList();
		model.addAttribute("vdList", vdList);
		return "admin/adminLecture/admin_video.ad";
	}
	// 관리자 키트관리
	@RequestMapping(value = "/admin_kit.LF")
	public String adminKit(Model model) {
		List<KitVO> kitList = adLecSvc.selectKitList();
		model.addAttribute("kitList", kitList);
		return "admin/adminLecture/admin_kit.ad";
	}
	// 관리자 결제내역관리
	@RequestMapping(value = "/admin_payment.LF")
	public String adminPayment() {
		return "admin/adminLecture/admin_payment.ad";
	}
	// 관리자 쿠폰관리
	@RequestMapping(value = "/admin_coupon.LF")
	public String adminCoupon(Model model) {
		List<CouponVO> cpList = adLecSvc.selectCouponList();
		model.addAttribute("cpList", cpList);
		return "admin/adminLecture/admin_coupon.ad";
	}
	// 관리자 회원관리
	@RequestMapping(value = "/admin_member.LF")
	public String adminMember() {
		return "admin/adminMember/admin_member.ad";
	}
	// 관리자 회원리스트 출력
	@RequestMapping(value = "/admin_member_list.LF", method = RequestMethod.GET)
	public String adminMemberListProc(Model model, 
			@RequestParam(value = "pn",required = false, defaultValue = "1") int pageNumber) {
		Map<String,Integer> rMap = adMbSvc.checkMaxPageNumber();
		List<MemberVO> mbList = adMbSvc.selectAllMember(pageNumber);
		if(mbList != null && rMap != null) {
			model.addAttribute("listSize", mbList.size());
			model.addAttribute("mbList", mbList);
			model.addAttribute("maxPn", rMap.get("maxPg"));
			model.addAttribute("totalRecords", rMap.get("totalRecords"));
			model.addAttribute("pn", pageNumber);
		}
		return "admin/adminMember/admin_member.ad";
	}
	// 관리자 회원리스트(다중) 갱신 AJAX 호출
	@RequestMapping(value = "/admin_update_member_list.LF", method = RequestMethod.POST)
	public String adminMemberListUpdateProc(@RequestParam(value="checkList[]") List<Integer> checkList) {
		for (Integer id : checkList) {
			System.out.println("체크 id: "+id);
		}
		return "redirect:admin_member_list.LF";
	}
	
	// 관리자 크리에이터관리
	@RequestMapping(value = "/admin_creator.LF")
	public String adminCreator(Model model) {
		List<CreatorVO> crList = adMbSvc.selectCreatorMemberList();
		model.addAttribute("crList", crList);
		return "admin/adminMember/admin_creator.ad";
	}
	// 관리자 공지내역
	@RequestMapping(value = "/admin_board_notice.LF")
	public String adminBoardNotice(Model model, int offset, int limit) {
		List<NoticeVO> noList = adBdSvc.showAllNotices(offset, limit);
		return "admin/adminBoard/admin_board_notice.ad";
	}
	// 관리자 자주묻는질문
	@RequestMapping(value = "/admin_board_faq.LF")
	public String adminBoardFaq(Model model, int offset, int limit) {
		List<FaqVO> faqList = adBdSvc.showAllFaqs(offset, limit);
		return "admin/adminBoard/admin_board_faq.ad";
	}
	// 관리자 문의내역
	@RequestMapping(value = "/admin_board_qna.LF")
	public String adminBoardQna(Model model, int offset, int limit) {
		List<QnaVO> qnaList = adBdSvc.showAllQnas(offset, limit);
		return "admin/adminBoard/admin_board_qna.ad";
	}
	// 관리자 댓글내역
	@RequestMapping(value = "/admin_board_comment.LF")
	public String adminBoardComment(Model model, int offset, int limit) {
		List<CommentClassVO> coList= adBdSvc.showAllComments(offset, limit);
		return "admin/adminBoard/admin_board_comment.ad";
	}
}
