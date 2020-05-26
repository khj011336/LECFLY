package com.LECFLY.LF.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.LECFLY.LF.model.vo.admin.HomeFileManagerVO;
import com.LECFLY.LF.model.vo.cart.CouponVO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.model.vo.cscenter.FaqVO;
import com.LECFLY.LF.model.vo.cscenter.NoticeVO;
import com.LECFLY.LF.model.vo.cscenter.QnaCommentVO;
import com.LECFLY.LF.model.vo.cscenter.QnaVO;
import com.LECFLY.LF.model.vo.member.MemberVO;
import com.LECFLY.LF.model.vo.virtual.CategoryLectureStatVO;
import com.LECFLY.LF.model.vo.virtual.MemberStatVO;
import com.LECFLY.LF.model.vo.virtual.PaymentStatVO;
import com.LECFLY.LF.service.inf.admin.IAdminBoardSVC;
import com.LECFLY.LF.service.inf.admin.IAdminFileSVC;
import com.LECFLY.LF.service.inf.admin.IAdminLectureSVC;
import com.LECFLY.LF.service.inf.admin.IAdminMemberSVC;
import com.LECFLY.LF.service.inf.admin.IAdminPaymentSVC;
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
	private IAdminPaymentSVC adPmSvc;

	@Autowired
	private IAdminFileSVC adFileSvc;
	
	// 관리자 홈
	@RequestMapping(value = "/admin.LF", method = RequestMethod.GET)
	public String adminHome(HttpSession ses, Model model) {
		// 방문자수 select count(id) from members where logined_at > date_sub(now(), interval 1 day);
		int allMbToday = adLecSvc.selectTodayInCnt();
		// 회원수 select count(id) from members;
		int allMbCnt = adLecSvc.selectMemberCnt();
		// 업로더수 select count(id) from members where check_creator = 3;
		int allCrCnt = adLecSvc.selectCreatorCnt();
		// 전체 강의수 select count(id) from lectures;
		int allLecCnt = adLecSvc.selectLectureAll();
		// 신규회원수 select count(id) from members where joined_at >=(CURDATE()-interval 7 day);
		int newMbCnt = adLecSvc.selectNewMemberCnt();
		// 업로더 승인대기수 select count(id) from members where check_creator = 2;
		int appCrCnt = adLecSvc.selectCreatorApprovalCnt();
		// 강의 승인대기수 select count(id) from lectures where status = 2;
		int appLecCnt = adLecSvc.selectLectureApproval();
		// 문의 답변하기 수  select count(id) from qnas where comment = 0;
		int cmQnaCnt = adLecSvc.selectQnaCommentCnt();
		
		model.addAttribute("allMbToday", allMbToday);// 방문자수
		model.addAttribute("allMbCnt", allMbCnt);// 회원수
		model.addAttribute("allCrCnt", allCrCnt);// 업로더수
		model.addAttribute("allLecCnt", allLecCnt);// 전체 강의수
		model.addAttribute("newMbCnt", newMbCnt);// 신규회원수
		model.addAttribute("appCrCnt", appCrCnt);// 업로더 승인대기수 
		model.addAttribute("appLecCnt", appLecCnt);// 강의 승인대기수
		model.addAttribute("cmQnaCnt", cmQnaCnt);// 문의 답변하기 수
		return "admin/admin_main.ad";
	}
	
	// 관리자 메인 통계 - 달 기준 멤버가입수 (최근 1년)
	@RequestMapping(value = "/stat_monthlyMember.LF", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> stat_monthlyMember() {
		Map<String,Object> jsonMap = new HashMap<String, Object>();
		System.out.println("최근 1년 달 기준 멤버 가입 수 검색");
		List<MemberStatVO> monthlyMemberList = adMbSvc.statCountMemberByMonth();
		List<String> monthName = new ArrayList<>();
		List<Integer> memberCnt = new ArrayList<>();
		for (MemberStatVO ms : monthlyMemberList) {
			ms.setMonthName(ms.getMonthName());
			System.out.println(ms.toString());
			 monthName.add(ms.getMonthName());
			 memberCnt.add(ms.getMsCount());
		}
		jsonMap.put("monthName",monthName);
		jsonMap.put("memberCnt", memberCnt);
		return jsonMap;
	}
	
	// 관리자 메인 통계 - 카테고리별 강의수
	@RequestMapping(value = "/stat_categoryLecture.LF", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> statCategoryLecture () {
		Map<String,Object> jsonMap = new HashMap<String, Object>();
		System.out.println("카테고리별 강의수 검색");
		List<CategoryLectureStatVO> cateLecList = adLecSvc.selectCategoryLectureCnt();
		List<String> cateName = new ArrayList<>();
		List<Integer> lectureCnt = new ArrayList<>();
		for (CategoryLectureStatVO ca : cateLecList) {
			ca.setName(ca.getName());
			System.out.println(ca.toString());
			cateName.add(ca.getName());
			lectureCnt.add(ca.getLectureCnt());
		}
		jsonMap.put("cateName",cateName);
		jsonMap.put("lectureCnt", lectureCnt);
		return jsonMap;
	}
	
	// 관리자 메인 통계 - 달 기준 매출액 (최근 1년)
	@RequestMapping(value = "/stat_monthlySale.LF", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> stat_monthlySale() {
		Map<String,Object> jsonMap = new HashMap<String, Object>();
		System.out.println("최근 1년 달 기준 매출 검색");
		List<PaymentStatVO> monthlyKitSaleList = adPmSvc.statSumKitSaleByMonth();
		List<PaymentStatVO> monthlyTicketSaleList = adPmSvc.statSumTicketSaleByMonth();
		List<PaymentStatVO> monthlyTotalSaleList = adPmSvc.statSumTotalSaleByMonth();
		
		List<String> monthName = new ArrayList<>();
		List<Integer> KitSaleSum = new ArrayList<>();
		List<Integer> TicketSaleSum = new ArrayList<>();
		List<Integer> totalSum = new ArrayList<>();
		for (PaymentStatVO ps : monthlyTotalSaleList) {
			System.out.println("최근 1년 달 기준 매출 검색3-1");
			ps.setMonthName(ps.getMonthName());
			System.out.println(ps.toString());
			 monthName.add(ps.getMonthName());
			 totalSum.add(ps.getTotalSum());
		}
		for (PaymentStatVO ps : monthlyTicketSaleList) {
			System.out.println("최근 1년 달 기준 매출 검색3-2");
			ps.setMonthName(ps.getMonthName());
			System.out.println(ps.toString());
			 monthName.add(ps.getMonthName());
			 TicketSaleSum.add(ps.getTicketSum());
		}
		for (PaymentStatVO ps : monthlyKitSaleList) {
			System.out.println("최근 1년 달 기준 매출 검색3-3");
			ps.setMonthName(ps.getMonthName());
			System.out.println(ps.toString());
			 monthName.add(ps.getMonthName());
			 KitSaleSum.add(ps.getKitSum());
		}
		jsonMap.put("monthName",monthName);
		jsonMap.put("KitSaleSum", KitSaleSum);
		jsonMap.put("TicketSaleSum", TicketSaleSum);
		jsonMap.put("totalSum",  totalSum);
		
		return jsonMap;
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
//	// 관리자 추천강의 관리
//	@RequestMapping(value = "/admin_recommend.LF")
//	public String adminRecommend() {
//		return "admin/admin_recommend.ad";
//	}
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
	public String adminLecture(Model model,
			@RequestParam(value = "pn",required = false, defaultValue = "1") int pageNumber) {
		Map<String,Integer> rMap = adLecSvc.checkLectureMaxPageNumber();
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
	// 관리자 강의관리(전체조회)
	@RequestMapping(value = "/admin_lecture_list.LF", method = RequestMethod.GET)
	public String adminLectureListProc(Model model, 
			@RequestParam(value = "p",required = false, defaultValue = "1") int pageNumber,
			@RequestParam(value = "o",required = false, defaultValue = "1") int order) {
		Map<String,Integer> rMap = adLecSvc.checkLectureMaxPageNumber();
		List<LectureVO> lecList = new ArrayList<>();
		switch (order) {
		case 1: // 정렬 최신순
			lecList = adLecSvc.selectAllLecture(pageNumber);
			break;
		case 2: // 정렬 승인대기순
			lecList = adLecSvc.selectAllLectureByApproval(pageNumber);
			break;	
		case 3: // 정렬 승인완료
			lecList = adLecSvc.selectAllLectureByApprovalDone(pageNumber);
			break;
		case 4: // 정렬 인기순
			lecList = adLecSvc.selectAllLectureByLike(pageNumber);
			break;	
		default:
			break;
		}
		if(lecList != null && rMap != null) {
			model.addAttribute("listSize", lecList.size());
			model.addAttribute("lecList", lecList);
			model.addAttribute("maxPn", rMap.get("maxPg"));
			model.addAttribute("totalRecords", rMap.get("totalRecords"));
			model.addAttribute("pn", pageNumber);
		}
		return "admin/adminLecture/admin_lecture.ad";
	}
	// 관리자 강의관리(상세조회) json
	@RequestMapping(value = "/admin_lecture_search.LF", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> adminLectureListSearch(
			@RequestBody Map<String, Object> params){
		// 검색 조건 취합
		int pageNumber = Integer.parseInt((String) params.get("pn"));
		int category = Integer.parseInt((String) params.get("category"));
		params.put("category", category);
		int status = Integer.parseInt((String) params.get("status"));
		params.put("status", status);
		
		// 검색(page, data)
		Map<String,Object> jsonMap = new HashMap<String, Object>();
		Map<String,Integer> rMap = adLecSvc.checkLectureMaxPageNumberSearch(params);
		List<LectureVO> lecList = adLecSvc.selectAllLectureSearch(params);
		// 검색 결과 처리
		if(lecList != null && rMap != null) {
			jsonMap.put("listSize", lecList.size());
			jsonMap.put("lecList", lecList);
			jsonMap.put("maxPn", rMap.get("maxPg"));
			jsonMap.put("totalRecords", rMap.get("totalRecords"));
			jsonMap.put("pn", pageNumber);
		}
      return jsonMap;
	}
	
	// 관리자 강의리스트(다중) 1승인완료 AJAX 호출(백업)
	@ResponseBody
	@RequestMapping(value = "/admin_update_approval_lecture.LF", method = RequestMethod.POST)
	public String adminLectureListApprovalProc(
			@RequestBody ArrayList<Integer> checkList) {
		
		for (Integer id : checkList) {
			System.out.println(id); // 수정할 id 값들 전달
		}
		
		boolean b = adLecSvc.updateLectureApprovalforIds(checkList);
		if(b) {
			System.out.println("승인완료");
			return "redirect:admin_lecture.LF";
		} else {
			System.out.println("승인실패");
			return "redirect:admin_lecture.LF";
		}
	}
	// 관리자 강의리스트(다중) 2승인거절 AJAX 호출
	@ResponseBody
	@RequestMapping(value = "/admin_update_disapprove_lecture.LF", method = RequestMethod.POST)
	public String adminLectureListDisapprovalProc(
			@RequestBody ArrayList<Integer> checkList) {
		
		for (Integer id : checkList) {
			System.out.println(id); // 수정할 id 값들 전달
		}
		
		boolean b = adLecSvc.updateLectureDisapprovalforIds(checkList);
		if(b) {
			System.out.println("승인거절 완료");
			return "redirect:admin_lecture.LF";
		} else {
			System.out.println("승인거절 실패");
			return "redirect:admin_lecture.LF";
		}
	}
	// 관리자 강의리스트(다중) 3삭제 AJAX 호출
	@ResponseBody
	@RequestMapping(value = "/admin_delete_lecture_list.LF", method = RequestMethod.POST)
	public String adminDeleteLectureListProc(
			@RequestBody ArrayList<Integer> checkList) {
		
		for (Integer id : checkList) {
			System.out.println(id); // 수정할 id 값들 전달
		}
		
		boolean b = adLecSvc.delectLectureforIds(checkList);
		if(b) {
			System.out.println("삭제완료");
			return "redirect:admin_lecture.LF";
		} else {
			System.out.println("삭제실패");
			return "redirect:admin_lecture.LF";
		}
	}
	
	// 관리자 영상관리
	@RequestMapping(value = "/admin_video.LF")
	public String adminVideo(Model model) {
		List<VideoVO> vdList = adLecSvc.selectVideoList();
		model.addAttribute("vdList", vdList);
		return "admin/adminLecture/admin_video.ad";
	}
	// 관리자 영상관리(전체조회)
	@RequestMapping(value = "/admin_video_list.LF", method = RequestMethod.GET)
	public String adminVideoListProc(Model model, 
			@RequestParam(value = "pn",required = false, defaultValue = "1") int pageNumber) {
		Map<String,Integer> rMap = adLecSvc.checkVideoMaxPageNumber();
		List<VideoVO> vdList = adLecSvc.selectAllVideo(pageNumber);
		if(vdList != null && rMap != null) {
			model.addAttribute("listSize", vdList.size());
			model.addAttribute("vdList", vdList);
			model.addAttribute("maxPn", rMap.get("maxPg"));
			model.addAttribute("totalRecords", rMap.get("totalRecords"));
			model.addAttribute("pn", pageNumber);
		}
		return "admin/adminLecture/admin_video.ad";
	}
	
	// 관리자 결제내역관리
	@RequestMapping(value = "/admin_payment.LF")
	public String adminPayment() {
		return "admin/adminProduct/admin_payment.ad";
	}
	
	// 관리자 쿠폰관리
	@RequestMapping(value = "/admin_coupon.LF")
	public String adminCoupon(Model model) {
		List<CouponVO> cpList = adLecSvc.selectCouponList();
		model.addAttribute("cpList", cpList);
		return "admin/adminProduct/admin_coupon.ad";
	}
	
	// 관리자 키트관리
		@RequestMapping(value = "/admin_kit.LF")
		public String adminKit(Model model) {
			List<KitVO> kitList = adLecSvc.selectKitList();
			model.addAttribute("kitList", kitList);
			return "admin/adminProduct/admin_kit.ad";
		}
		
	// 관리자 회원관리
	@RequestMapping(value = "/admin_member.LF")
	public String adminMember() {
		return "admin/adminMember/admin_member.ad";
	}
	// 관리자 회원리스트 출력
	@RequestMapping(value = "/admin_member.LF", method = RequestMethod.GET)
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
	
//	// 관리자 크리에이터관리
//	@RequestMapping(value = "/admin_creator.LF")
//	public String adminCreator(Model model) {
//		List<CreatorVO> crList = adMbSvc.selectCreatorMemberList();
//		model.addAttribute("crList", crList);
//		return "admin/adminMember/admin_creator.ad";
//	}
	// 관리자 크리에이터관리
		@RequestMapping(value = "/admin_creator.LF")
		public String adminCreator() {
			return "admin/adminMember/admin_creator.ad";
		}
	
	// 관리자 크리에이터 회원리스트 출력
	@RequestMapping(value = "/admin_creator.LF", method = RequestMethod.GET)
	public String adminCreatorListProc(Model model, 
			@RequestParam(value = "pn",required = false, defaultValue = "1") int pageNumber) {
		System.out.println("PN? "+ pageNumber);
		Map<String,Integer> rMap = adMbSvc.checkMaxPageNumberForCreator();
		List<CreatorVO> crList = adMbSvc.selectAllCreator(pageNumber);
		if(crList != null && rMap != null) {
			model.addAttribute("listSize", crList.size());
			model.addAttribute("crList", crList);
			model.addAttribute("maxPn", rMap.get("maxPg"));
			model.addAttribute("totalRecords", rMap.get("totalRecords"));
			model.addAttribute("pn", pageNumber);
		}
		return "admin/adminMember/admin_creator.ad";
	}
	// 관리자 크리에이터리스트(다중) 갱신 AJAX 호출
	@RequestMapping(value = "/admin_update_creator_list.LF", method = RequestMethod.POST)
	public String adminCreatorListUpdateProc(@RequestParam(value="checkList[]") List<Integer> checkList) {
		for (Integer id : checkList) {
			System.out.println("체크 id: "+id);
		}
		return "redirect:admin_creator.LF";
	}
	// 회원 통계 내역
		@RequestMapping(value = "/admin_member_stat.LF")
		public String adminMemberStat() {
			return "admin/adminMember/admin_memberstat.ad";
		}	
	
	// 관리자 공지내역
	@RequestMapping(value = "/admin_board_notice.LF")
	public String adminBoardNotice() {
		return "admin/adminBoard/admin_board_notice.ad";
	}
	// 관리자 공지내역리스트 출력
	@RequestMapping(value = "/admin_board_notice.LF", method = RequestMethod.GET)
	public String adminBoardNoticeListProc(Model model, 
			@RequestParam(value = "pn",required = false, defaultValue = "1") int pageNumber) {
		System.out.println("PN? "+ pageNumber);
		Map<String,Integer> rMap = adBdSvc.checkMaxPageNumberOfNotice();
		List<NoticeVO> ntList = adBdSvc.selectAllNotice(pageNumber);
		if(ntList != null && rMap != null) {
			model.addAttribute("listSize", ntList.size());
			model.addAttribute("ntList",ntList);
			model.addAttribute("maxPn", rMap.get("maxPg"));
			model.addAttribute("totalRecords", rMap.get("totalRecords"));
			model.addAttribute("pn", pageNumber);
		}
		return "admin/adminBoard/admin_board_notice.ad";
	}
	// 관리자 공지내역리스트(다중) 갱신 AJAX 호출
	@RequestMapping(value = "/admin_update_notice_list.LF", method = RequestMethod.POST)
	public String adminNoticeListUpdateProc(@RequestParam(value="checkList[]") List<Integer> checkList) {
		for (Integer id : checkList) {
			System.out.println("체크 id: "+id);
		}
		return "redirect:admin_board_notice.LF";
	}
	
	// 관리자 자주묻는질문
	@RequestMapping(value = "/admin_board_faq.LF")
	public String adminBoardFaq() {
		return "admin/adminBoard/admin_board_faq.ad";
	}
	// 관리자 자주묻는질문 내역 리스트 출력
	@RequestMapping(value = "/admin_board_faq.LF", method = RequestMethod.GET)
	public String adminBoardFaqListProc(Model model, 
			@RequestParam(value = "pn",required = false, defaultValue = "1") int pageNumber) {
		System.out.println("PN? "+ pageNumber);
		Map<String,Integer> rMap = adBdSvc.checkMaxPageNumberOfFaq();
		List<FaqVO> fqList = adBdSvc.selectAllFaq(pageNumber);
		if(fqList != null && rMap != null) {
			model.addAttribute("listSize", fqList.size());
			model.addAttribute("fqList",fqList);
			model.addAttribute("maxPn", rMap.get("maxPg"));
			model.addAttribute("totalRecords", rMap.get("totalRecords"));
			model.addAttribute("pn", pageNumber);
		}
		return "admin/adminBoard/admin_board_faq.ad";
	}
	// 관리자 자주묻는질문내역리스트(다중) 갱신 AJAX 호출
	@RequestMapping(value = "/admin_update_faq_list.LF", method = RequestMethod.POST)
	public String adminFaqListUpdateProc(@RequestParam(value="checkList[]") List<Integer> checkList) {
		for (Integer id : checkList) {
			System.out.println("체크 id: "+id);
		}
		return "redirect:admin_board_faq.LF";
	}
	
	// 관리자 문의내역
	@RequestMapping(value = "/admin_board_qna.LF")
	public String adminBoardQna() {
		return "admin/adminBoard/admin_board_qna.ad";
	}
	// 관리자 문의내역 리스트 출력
	@RequestMapping(value = "/admin_board_qna.LF", method = RequestMethod.GET)
	public String adminBoardQnaListProc(Model model, 
			@RequestParam(value = "pn",required = false, defaultValue = "1") int pageNumber) {
		System.out.println("PN? "+ pageNumber);
		Map<String,Integer> rMap = adBdSvc.checkMaxPageNumberOfQna();
		List<QnaVO> qaList = adBdSvc.selectAllQna(pageNumber);
		if(qaList != null && rMap != null) {
			model.addAttribute("listSize", qaList.size());
			model.addAttribute("qaList", qaList);
			model.addAttribute("maxPn", rMap.get("maxPg"));
			model.addAttribute("totalRecords", rMap.get("totalRecords"));
			model.addAttribute("pn", pageNumber);
		}
		return "admin/adminBoard/admin_board_qna.ad";
	}
	// 관리자 문의내역리스트(다중) 갱신 AJAX 호출
	@RequestMapping(value = "/admin_update_qna_list.LF", method = RequestMethod.POST)
	public String adminQnaListUpdateProc(@RequestParam(value="checkList[]") List<Integer> checkList) {
		for (Integer id : checkList) {
			System.out.println("체크 id: "+id);
		}
		return "redirect:admin_board_qna.LF";
	}
	
	// 관리자 댓글내역
	@RequestMapping(value = "/admin_board_comment.LF")
	public String adminBoardComment() {
		return "admin/adminBoard/admin_board_comment.ad";
	}
	// 관리자 댓글내역 리스트 출력
	@RequestMapping(value = "/admin_board_comment.LF", method = RequestMethod.GET)
	public String adminBoardCommentListProc(Model model, 
			@RequestParam(value = "pn",required = false, defaultValue = "1") int pageNumber) {
		System.out.println("PN? "+ pageNumber);
		Map<String,Integer> rMap = adBdSvc.checkMaxPageNumberOfComment();
		List<QnaCommentVO> qcList = adBdSvc.selectAllComment(pageNumber);
		if(qcList != null && rMap != null) {
			model.addAttribute("listSize", qcList.size());
			model.addAttribute("qcList", qcList);
			model.addAttribute("maxPn", rMap.get("maxPg"));
			model.addAttribute("totalRecords", rMap.get("totalRecords"));
			model.addAttribute("pn", pageNumber);
		}
		return "admin/adminBoard/admin_board_comment.ad";
	}
	// 관리자 댓글내역리스트(다중) 갱신 AJAX 호출
	@RequestMapping(value = "/admin_update_comment_list.LF", method = RequestMethod.POST)
	public String adminCommentListUpdateProc(@RequestParam(value="checkList[]") List<Integer> checkList) {
		for (Integer id : checkList) {
			System.out.println("체크 id: "+id);
		}
		return "redirect:admin_board_comment.LF";
	}
}
