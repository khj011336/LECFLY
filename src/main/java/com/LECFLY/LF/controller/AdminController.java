package com.LECFLY.LF.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	// 관리자 홈
	@RequestMapping(value = "/admin.LF")
	public String adminHome() {
		return "admin/adminpage";
	}
	// 관리자 사이트이용안내
	@RequestMapping(value = "/admin_site.LF")
	public String adminSite() {
		return "admin/admin_site";
	}
	// 관리자 배너관리
	@RequestMapping(value = "/admin_banner.LF")
	public String adminBanner() {
		return "admin/admin_banner";
	}
	// 관리자 추천강의 관리
	@RequestMapping(value = "/admin_recommend.LF")
	public String adminRecommend() {
		return "admin/admin_recommend";
	}
	// 관리자 계정관리
	@RequestMapping(value = "/admin_account.LF")
	public String adminAccount() {
		return "admin/admin_account";
	}
	// 관리자 강의관리
	@RequestMapping(value = "/admin_lecture.LF")
	public String adminLecture() {
		return "admin/admin_";
	}
	// 관리자 영상관리
	@RequestMapping(value = "/admin_video.LF")
	public String adminVideo() {
		return "admin/admin_";
	}
	// 관리자 키트관리
	@RequestMapping(value = "/admin_kit.LF")
	public String adminKit() {
		return "admin/admin_";
	}
	// 관리자 결제내역관리
	@RequestMapping(value = "/admin_payment.LF")
	public String adminPayment() {
		return "admin/admin_";
	}
	// 관리자 쿠폰관리
	@RequestMapping(value = "/admin_coupon.LF")
	public String adminCoupon() {
		return "admin/admin_";
	}
	// 관리자 회원관리
	@RequestMapping(value = "/admin_member.LF")
	public String adminMember() {
		return "admin/admin_";
	}
	// 관리자 크리에이터관리
	@RequestMapping(value = "/admin_creator.LF")
	public String adminCreator() {
		return "admin/admin_";
	}
	// 관리자 공지내역
	@RequestMapping(value = "/admin_board_notice.LF")
	public String adminBoardNotice() {
		return "admin/admin_";
	}
	// 관리자 자주묻는질문
	@RequestMapping(value = "/admin_board_faq.LF")
	public String adminBoardFaq() {
		return "admin/admin_";
	}
	// 관리자 문의내역
	@RequestMapping(value = "/admin_board_qna.LF")
	public String adminBoardQna() {
		return "admin/admin_";
	}
	// 관리자 댓글내역
	@RequestMapping(value = "/admin_board_comment.LF")
	public String adminBoardComment() {
		return "admin/admin_";
	}
}
