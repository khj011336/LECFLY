package com.LECFLY.LF.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.LECFLY.LF.model.vo.HomeFileManagerVO;
import com.LECFLY.LF.model.vo.MemberVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.service.inf.admin.IAdminFileSVC;
import com.LECFLY.LF.service.inf.admin.IAdminSiteSVC;

@Controller
public class AdminController {
	@Autowired
	private IAdminSiteSVC adSiteSvc;
	
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
		return "admin/admin_site.ad";
	}
	// 관리자 배너관리
	@RequestMapping(value = "/admin_banner.LF")
	public String adminBanner() {
		return "admin/admin_banner.ad";
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
		return "admin/admin_banner.ad";
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
	public String adminLecture() {
		return "admin/admin_lecture.ad";
	}
	// 관리자 영상관리
	@RequestMapping(value = "/admin_video.LF")
	public String adminVideo() {
		return "admin/admin_video.ad";
	}
	// 관리자 키트관리
	@RequestMapping(value = "/admin_kit.LF")
	public String adminKit() {
		return "admin/admin_kit.ad";
	}
	// 관리자 결제내역관리
	@RequestMapping(value = "/admin_payment.LF")
	public String adminPayment() {
		return "admin/admin_payment.ad";
	}
	// 관리자 쿠폰관리
	@RequestMapping(value = "/admin_coupon.LF")
	public String adminCoupon() {
		return "admin/admin_coupon.ad";
	}
	// 관리자 회원관리
	@RequestMapping(value = "/admin_member.LF")
	public String adminMember() {
		return "admin/admin_member.ad";
	}
	// 관리자 회원리스트 출력
	@RequestMapping(value = "/admin_member_list.LF", method = RequestMethod.GET)
	public String adminMemberList(MemberVO vo, Model model) {
		return "admin/admin_member.ad";
	}
	
	// 관리자 크리에이터관리
	@RequestMapping(value = "/admin_creator.LF")
	public String adminCreator() {
		return "admin/admin_creator.ad";
	}
	// 관리자 공지내역
	@RequestMapping(value = "/admin_board_notice.LF")
	public String adminBoardNotice() {
		return "admin/admin_board_notice.ad";
	}
	// 관리자 자주묻는질문
	@RequestMapping(value = "/admin_board_faq.LF")
	public String adminBoardFaq() {
		return "admin/admin_board_faq.ad";
	}
	// 관리자 문의내역
	@RequestMapping(value = "/admin_board_qna.LF")
	public String adminBoardQna() {
		return "admin/admin_board_qna.ad";
	}
	// 관리자 댓글내역
	@RequestMapping(value = "/admin_board_comment.LF")
	public String adminBoardComment() {
		return "admin/admin_board_comment.ad";
	}
}
