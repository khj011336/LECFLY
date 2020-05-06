package com.LECFLY.LF.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	
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
	// 관리자 추천강의 관리
	@RequestMapping(value = "/admin_recommend.LF")
	public String adminRecommend() {
		return "admin/admin_recommend.ad";
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
