package com.LECFLY.LF.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.LECFLY.LF.model.vo.cscenter.FaqVO;
import com.LECFLY.LF.model.vo.cscenter.NoticeVO;
import com.LECFLY.LF.model.vo.cscenter.QnaCommentVO;
import com.LECFLY.LF.model.vo.cscenter.QnaVO;
import com.LECFLY.LF.model.vo.member.CommentVO;
import com.LECFLY.LF.model.vo.member.MemberVO;
import com.LECFLY.LF.service.impl.creator.FileSVCImpl;
import com.LECFLY.LF.service.inf.comment.ICommentSVC;
import com.LECFLY.LF.service.inf.cscenter.ICscenterFileSVC;
import com.LECFLY.LF.service.inf.cscenter.IFaqSVC;
import com.LECFLY.LF.service.inf.cscenter.INoticeSVC;
import com.LECFLY.LF.service.inf.cscenter.IQnaCommentSVC;
import com.LECFLY.LF.service.inf.cscenter.IQnaSVC;


@Controller
//@RequestMapping("/cscenter")
public class CscenterController {
	@Autowired
	private IQnaSVC qaSvc;
	
	@Autowired
	private IFaqSVC fqSvc;
	
	@Autowired
	private INoticeSVC ntSvc;
	
	
	 @Autowired 
	 private ICscenterFileSVC csSvc;
	 
	
	@Autowired
	private IQnaCommentSVC qcSvc;
	
	@Autowired
	private ICommentSVC cmSvc;

	@Autowired
	private FileSVCImpl fsSvc;
	
//	@Autowired
//	private IMemberSVC mbSvc;
	
//	// cscenter 홈
//	@RequestMapping(value = "cscenter.LF", method = RequestMethod.GET)
//	public String cscenterHome() {
//		System.out.println("cscenterHome()...");	
//		return "cscenter/cs_qna.ho";
//	}
	
//	// QnA
//	@RequestMapping(value = "/cs_qna.LF", method = RequestMethod.GET)
//	public String cscenterQnA() {
//		System.out.println("cscenterQnA()...");	
//		return "cscenter/cs_qna";
//	}
//	// FAQ
//	@RequestMapping(value = "/cs_faq.LF", method = RequestMethod.GET)
//	public String cscenterFAQ() {
//		System.out.println("cscenterFAQ()...");
//		return "cscenter/cs_faq.ho";
//	}
//	// NOTICE
//	@RequestMapping(value = "/cs_notice.LF", method = RequestMethod.GET)
//	public String cscenterNotice() {
//		System.out.println("cscenterNotice()...");
//		return "cscenter/cs_notice.ho";
//	}
	
	
	// 회원이 QnA 글쓰기 + 파일
		@RequestMapping(value = "cs_post_new_qna.LF", method = {RequestMethod.GET, RequestMethod.POST})
		public String cscenterPostNewQna(HttpSession ses, Model model ) {
			System.out.println("cscenterPostNewQna()...");
			MemberVO mb = (MemberVO)ses.getAttribute("member");			
			model.addAttribute("mb", mb);
			System.out.println("mb = " + mb);
			return "cscenter/cs_qna_post.ho";
		}
	
	@RequestMapping(value = "cs_post_qna.LF", method = {RequestMethod.GET, RequestMethod.POST})
	public String cscenterAddQna(int mbId, @RequestParam(required = false, value = "multiFile")MultipartFile File, String mbNicname, int type, String title, String content, List<MultipartFile>file, int showPrivate, HttpSession ses) {
		System.out.println("cscenterAddQna()...");
		
			Map<String, String> fileMap = null;
		if(File != null) {
			fileMap = fsSvc.writeFile(File, mbId, "cscenter");
			System.out.println(fileMap.get("file"));
			System.out.println(File.getOriginalFilename());
		}
		System.out.println("multipart size: " + file.size());
		String realPath = ses.getServletContext().getRealPath(ICscenterFileSVC.DEF_UPLOAD_DEST)+"/";
		
		//다중 처리
		Map<String, Object> rMap = csSvc.writeUploadedMultipleFiles(file, realPath, (String)ses.getAttribute("mbId"));
		String filePath = fileMap.get("file");
		
		System.out.println("총 파일 수: " + rMap.get("fileCnt"));
		System.out.println("총 볼륨(MB): "+ rMap.get("totalMB") +"MB");
		
		// public img src... 
		int qaRtkey = this.qaSvc.insertNewQnaReturnKey(mbId, mbNicname, type, title, content,filePath, showPrivate );
		// 상세보기
		if( qaRtkey > 0 ) {
			System.out.println("게시글 등록 성공: " + qaRtkey);
			return "redirect:qna_receive.LF?id=" + qaRtkey;
			//return "redirect:cs_receive_qna.ho?id="+ qaRtkey;
		} else {
			System.out.println("게시글 등록 실패: " + title);
			return "cscenter/cs_qna_post.ho"; //
		}
	}
	
	// QnA 글 상세보기
	@RequestMapping(value = "/qna_receive.LF", method = {RequestMethod.GET, RequestMethod.POST})
	public String cscenterReceiveQna(HttpSession ses, int id, Model model , @RequestParam(value = "mbId", defaultValue = "1") int memberId) {
		MemberVO mb = (MemberVO)ses.getAttribute("member");			
		model.addAttribute("mb", mb);
		QnaVO qa = this.qaSvc.selectOneQna(id);
		int pn = this.qaSvc.checkPageNumber(id);
			System.out.println("pn은?" + pn);
		if( qa != null ) {
			System.out.println("게시글 상세조회 성공 " + qa);
			model.addAttribute("qna", qa);
//			String qaFilePath = qa.getFile();
//			int fpsCount = -1;
//			if( qaFilePath != null && qaFilePath.isEmpty()) {
//				String fps[] = null;
//				if( qaFilePath.indexOf(ICscenterFileSVC.MULTI_SEP) != -1 ) {
//					fps = qaFilePath.split("\\" + ICscenterFileSVC.MULTI_SEP);
//					fpsCount = fps.length;
//				} else {
//					fpsCount = 1;
//					fps = new String[]{qaFilePath};
//				}
//				model.addAttribute("fps", fps);
//			} else {
//				//첨부파일 없는 정상 게시글 상세보기
//				fpsCount = 0;
//			}
//			model.addAttribute("fpsCount", fpsCount);
			model.addAttribute("pn", pn);
			// 댓글 등록
			
			//댓글 리스트
			List<CommentVO> qcList = cmSvc.selectCommentsForOrderNumAsc(2, qa.getId());
			if(qcList != null ) {
				System.out.println("댓글 상세조회 성공 " + qcList);
				model.addAttribute("qcSize", qcList.size());
				model.addAttribute("qnaComment", qcList);
			}else {
				System.out.println("댓글 상세조회 실패 " + qcList);
				model.addAttribute("msg", "댓글리스트 조회 실패");
			}
			return "cscenter/cs_qna_receive.ho";
			
		} else {
			model.addAttribute("msg", "게시글 상세조회 실패 - " + id);
			return "redirect:cs_qna.ho";
		}
	}
	// QnA 글 수정하기
	@RequestMapping(value = "/cs_edit_qna.LF", method = {RequestMethod.GET, RequestMethod.POST})
	public String cscenterEditQna(HttpSession ses, Model model, int id,  @RequestParam(value = "mbId", defaultValue = "1") int memberId){
//			@RequestParam(value = "qaId", defaultValue = "0") int id){
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		model.addAttribute("mb", mb);
		System.out.println("mb = " + mb);
		if(id == 0 ) {
			System.out.println("qna update: id=0");
			return "redirect:cs_qna.LF";
		}else {
			QnaVO qa = qaSvc.selectOneQna(id);
			if( qa != null ) {
				// 세션로그인 유저가 편집대상 게시글 작성자인가? 아니면 권한이 있거나?
//				int writerId = qa.getMbId();
//				if( writerId == (int)ses.getAttribute("mbId")) {
					model.addAttribute("qna", qa);
					return "cscenter/cs_qna_edit.ho";
//				} else {
//					model.addAttribute("msg", "게시글 편집폼 준비 실패: 작성자 아님");
//					return "redirect:redirect:cs_qna.ho?id=" +id; 
//				}
			
			} else {
				model.addAttribute("msg", "게시글 편집폼 준비 실패: 게시글 없음");
				return "redirect:cs_receive_qna.ho?id=" +id; 
			}
		}
		
	}	
	
	@RequestMapping(value = "/cs_update_qna.LF", method = {RequestMethod.GET, RequestMethod.POST})
	public String qnaUpdateProc(HttpSession ses, @ModelAttribute(value = "qna") QnaVO qa) { // vo를 command객체로 사용하자.
		System.out.println("qnaUpdateProc: "+qa);
		boolean b = qaSvc.updateQna(qa.getId(), qa.getTitle(), qa.getContent(), qa.getShowPrivate());
		if( b ) {
			System.out.println("qnaUpdateProc: 1");
			return "redirect:qna_receive.LF?id="+qa.getId();
		} else {
			System.out.println("qnaUpdateProc: 2");
			return "cscenter/cs_qna_receive.ho";
		}
	}
	
	// QnA 글 삭제하기
	@RequestMapping(value = "/qna_delete.LF", method = {RequestMethod.GET, RequestMethod.POST})
	public String cscenterDeleteQna(int id, HttpSession ses,  @RequestParam(value = "mbId", defaultValue = "1") int memberId) {
		System.out.println("cscenterDeleteQna()"+ id);
		int commentCheck = this.qcSvc.checkNumberOfCommentsForQna(id);
		if(commentCheck >= 1) {
			System.out.println("댓글이 있어서 삭제 불가능");
			return "cscenter/cs_qna_receive.LF";
		}else {
			System.out.println("댓글이 없어서 삭제가능");
			boolean b = qaSvc.deleteQna(id);
			if( b ) {
				return "redirect:cs_qna.LF";
			} else {
				return "cscenter/cs_qna_receive.LF";
			}
		}
			
	}
	
	// QnA 리스트 조회하기 (페이지네이션, 정렬)
	@RequestMapping(value = "cs_qna.LF",method = RequestMethod.GET)
	public ModelAndView cscenterQnA( @RequestParam(value = "pn",required = false,defaultValue = "1") int pageNumber) {
		System.out.println("cscenterQnA(PN)..");
		int qamaxPG = qaSvc.checkMaxPageNumber();
		if( pageNumber > qamaxPG || pageNumber <= 0 ) {
			System.out.println("잘못된 페이지 번호: " + pageNumber);
			return new ModelAndView(
				"redirect:cs_qna.LF?pn=1");
		}
		List<QnaVO> qaList = qaSvc.showAllQnas(pageNumber);
		ModelAndView mav = new ModelAndView("cscenter/cs_qna.ho");
		if( qaList != null ) {
			mav.addObject("qaSize", qaList.size());
			mav.addObject("qna", qaList);
			mav.addObject("maxPn", qamaxPG);
			mav.addObject("pn", pageNumber); // 활성페이지 
			
			// 댓글의 개수 리스트/배열
			List<Integer> cntComments = new ArrayList<Integer>();
			for (int i = 0; i < qaList.size(); i++) {
				int cntQC = cmSvc.checkNumberOfComments(2, qaList.get(i).getId());
				cntComments.add(cntQC);
			}
			System.out.println("댓글수" +  cntComments);
			mav.addObject("cntComments", cntComments);
			System.out.println("게시글리스트 조회 성공: " + qaList.size());
		} else {
			mav.addObject("msg", "게시글리스트 조회 실패!");
		}
		return mav;
	}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//QNA COMMENT
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//- 댓글 리스트가 게시글 상세보기에 연동 표시될 수 있다.
	@RequestMapping(value = "/cs_qna_receive.LF", method = {RequestMethod.GET, RequestMethod.POST})
	public String commentListProc(
			@RequestParam(value="qnaId") int qnaId, Model model) {
		List<QnaCommentVO> qcList = qcSvc.commentListForQna(qnaId);		
		if( qcList != null ) {
			model.addAttribute("qnaId", qnaId);
			model.addAttribute("qcSize", qcList.size());
			model.addAttribute("qnaComments", qcList );
			return "qna/receive.ho";
		} else {
			return "redirect:/cs_qna_receive.ho?id="+ qnaId;
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//FAQ
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// FAQ 리스트 조회하기 (페이지네이션, 정렬)
	@RequestMapping(value = "cs_faq.LF", method = RequestMethod.GET)
	public ModelAndView cscenterFaq( @RequestParam(value = "pn",required = false,defaultValue = "1") int pageNumber) {
		System.out.println("cscenterFaq(PN)..");
		int fqmaxPG = fqSvc.checkMaxPageNumber();
		if( pageNumber > fqmaxPG || pageNumber <= 0 ) {
			System.out.println("잘못된 페이지 번호: " + pageNumber);
			return new ModelAndView("redirect:cs_faq.ho?pn=1");
		}
		List<FaqVO> fqList = fqSvc.showAllFaqs(pageNumber);
		ModelAndView mav = new ModelAndView("cscenter/cs_faq.ho");
		if( fqList != null ) {
			mav.addObject("fqSize", fqList.size());
			mav.addObject("faq", fqList);
			mav.addObject("maxPn", fqmaxPG);
			mav.addObject("pn", pageNumber); // 활성페이지 
				System.out.println("게시글리스트 조회 성공: " + fqList.size());
		} else {
			mav.addObject("msg", "게시글리스트 조회 실패!");
		}
		return mav;
	}
	
	// FAQ type1 리스트 조회하기 (페이지네이션, 정렬)
		@RequestMapping(value = "cs_faq_1.LF", method = RequestMethod.GET)
		public ModelAndView cscenterFaqForType1( @RequestParam(value = "pn",required = false,defaultValue = "1") int pageNumber) {
			System.out.println("cscenterFaqForType(PN)..");
			int fqmaxPG = fqSvc.checkMaxPageNumberForType(1);
			if( pageNumber > fqmaxPG || pageNumber <= 0 ) {
				System.out.println("잘못된 페이지 번호: " + pageNumber);
				return new ModelAndView("redirect:cs_faq_1.ho?pn=1");
			}
			List<FaqVO> fqList = fqSvc.showFaqsForType(1, pageNumber);
			ModelAndView mav = new ModelAndView("cscenter/cs_faq_1.ho");
			if( fqList != null ) {
				mav.addObject("fqSize", fqList.size());
				mav.addObject("faq1", fqList);
				mav.addObject("maxPn", fqmaxPG);
				mav.addObject("pn", pageNumber); // 활성페이지 
					System.out.println("type 1 게시글리스트 조회 성공: " + fqList.size());
			} else {
				mav.addObject("msg", "type 1 게시글리스트 조회 실패!");
			}
			return mav;
		}
	// FAQ type2 리스트 조회하기 (페이지네이션, 정렬)
		@RequestMapping(value = "cs_faq_2.LF", method = RequestMethod.GET)
		public ModelAndView cscenterFaqForType2( @RequestParam(value = "pn",required = false,defaultValue = "1") int pageNumber) {
			System.out.println("cscenterFaqForType(PN)..");
			int fqmaxPG = fqSvc.checkMaxPageNumberForType(2);
			if( pageNumber > fqmaxPG || pageNumber <= 0 ) {
				System.out.println("잘못된 페이지 번호: " + pageNumber);
				return new ModelAndView("redirect:cs_faq_2.ho?pn=1");
			}
			List<FaqVO> fqList = fqSvc.showFaqsForType(2, pageNumber);
			ModelAndView mav = new ModelAndView("cscenter/cs_faq_2.ho");
			if( fqList != null ) {
				mav.addObject("fqSize", fqList.size());
				mav.addObject("faq2", fqList);
				mav.addObject("maxPn", fqmaxPG);
				mav.addObject("pn", pageNumber); // 활성페이지 
					System.out.println("type 2 게시글리스트 조회 성공: " + fqList.size());
			} else {
				mav.addObject("msg", "type 2 게시글리스트 조회 실패!");
			}
			return mav;
		}	
	// FAQ type3 리스트 조회하기 (페이지네이션, 정렬)
		@RequestMapping(value = "cs_faq_3.LF", method = RequestMethod.GET)
		public ModelAndView cscenterFaqForType3( @RequestParam(value = "pn",required = false,defaultValue = "1") int pageNumber) {
			System.out.println("cscenterFaqForType(PN)..");
			int fqmaxPG = fqSvc.checkMaxPageNumberForType(3);
			if( pageNumber > fqmaxPG || pageNumber <= 0 ) {
				System.out.println("잘못된 페이지 번호: " + pageNumber);
				return new ModelAndView("redirect:cs_faq_3.ho?pn=1");
			}
			List<FaqVO> fqList = fqSvc.showFaqsForType(3, pageNumber);
			ModelAndView mav = new ModelAndView("cscenter/cs_faq_3.ho");
			if( fqList != null ) {
				mav.addObject("fqSize", fqList.size());
				mav.addObject("faq3", fqList);
				mav.addObject("maxPn", fqmaxPG);
				mav.addObject("pn", pageNumber); // 활성페이지 
					System.out.println("type 3 게시글리스트 조회 성공: " + fqList.size());
			} else {
				mav.addObject("msg", "type 3 게시글리스트 조회 실패!");
			}
			return mav;
		}	
		// FAQ type4 리스트 조회하기 (페이지네이션, 정렬)
		@RequestMapping(value = "cs_faq_4.LF", method = RequestMethod.GET)
		public ModelAndView cscenterFaqForType4( @RequestParam(value = "pn",required = false,defaultValue = "1") int pageNumber) {
			System.out.println("cscenterFaqForType(PN)..");
			int fqmaxPG = fqSvc.checkMaxPageNumberForType(4);
			if( pageNumber > fqmaxPG || pageNumber <= 0 ) {
				System.out.println("잘못된 페이지 번호: " + pageNumber);
				return new ModelAndView("redirect:cs_faq_4.ho?pn=1");
			}
			List<FaqVO> fqList = fqSvc.showFaqsForType(4, pageNumber);
			ModelAndView mav = new ModelAndView("cscenter/cs_faq_4.ho");
			if( fqList != null ) {
				mav.addObject("fqSize", fqList.size());
				mav.addObject("faq4", fqList);
				mav.addObject("maxPn", fqmaxPG);
				mav.addObject("pn", pageNumber); // 활성페이지 
					System.out.println("type 4 게시글리스트 조회 성공: " + fqList.size());
			} else {
				mav.addObject("msg", "type 4 게시글리스트 조회 실패!");
			}
			return mav;
		}	

		// FAQ type5 리스트 조회하기 (페이지네이션, 정렬)
		@RequestMapping(value = "cs_faq_5.LF", method = RequestMethod.GET)
		public ModelAndView cscenterFaqForType5( @RequestParam(value = "pn",required = false,defaultValue = "1") int pageNumber) {
			System.out.println("cscenterFaqForType(PN)..");
			int fqmaxPG = fqSvc.checkMaxPageNumberForType(5);
			if( pageNumber > fqmaxPG || pageNumber <= 0 ) {
				System.out.println("잘못된 페이지 번호: " + pageNumber);
				return new ModelAndView("redirect:cs_faq_5.ho?pn=1");
			}
			List<FaqVO> fqList = fqSvc.showFaqsForType(5, pageNumber);
			ModelAndView mav = new ModelAndView("cscenter/cs_faq_5.ho");
			if( fqList != null ) {
				mav.addObject("fqSize", fqList.size());
				mav.addObject("faq5", fqList);
				mav.addObject("maxPn", fqmaxPG);
				mav.addObject("pn", pageNumber); // 활성페이지 
					System.out.println("type 5 게시글리스트 조회 성공: " + fqList.size());
			} else {
				mav.addObject("msg", "type 5 게시글리스트 조회 실패!");
			}
			return mav;
		}	
		// FAQ type5 리스트 조회하기 (페이지네이션, 정렬)
		@RequestMapping(value = "cs_faq_6.LF", method = RequestMethod.GET)
		public ModelAndView cscenterFaqForType6( @RequestParam(value = "pn",required = false,defaultValue = "1") int pageNumber) {
			System.out.println("cscenterFaqForType(PN)..");
			int fqmaxPG = fqSvc.checkMaxPageNumberForType(6);
			if( pageNumber > fqmaxPG || pageNumber <= 0 ) {
				System.out.println("잘못된 페이지 번호: " + pageNumber);
				return new ModelAndView("redirect:cs_faq_6.ho?pn=1");
			}
			List<FaqVO> fqList = fqSvc.showFaqsForType(6, pageNumber);
			ModelAndView mav = new ModelAndView("cscenter/cs_faq_6.ho");
			if( fqList != null ) {
				mav.addObject("fqSize", fqList.size());
				mav.addObject("faq6", fqList);
				mav.addObject("maxPn", fqmaxPG);
				mav.addObject("pn", pageNumber); // 활성페이지 
					System.out.println("type 6 게시글리스트 조회 성공: " + fqList.size());
			} else {
				mav.addObject("msg", "type 6 게시글리스트 조회 실패!");
			}
			return mav;
		}			
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//NOTICE
////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 관리자가 Notice 글쓰기
//	@RequestMapping(value = "/cs_post_noice.LF", method = RequestMethod.GET)
//	public String cscenterPostNotice() {
//		return "cscenter/cs_notice_post.cs";
//	}
	// Notice 글 상세보기
//	@RequestMapping(value = "/cs_receive_notice.LF", method = RequestMethod.GET)
//	public String cscenterReceiveNotice() {
//		return "cscenter/cs_notice_receive.cs";
//	} 
	// 관리자가 Notice 글 수정하기
//	@RequestMapping(value = "/cs_edit_noice.LF", method = RequestMethod.GET)
//	public String cscenterEditNotice() {
//		return "cscenter/cs_notice_edit.cs";
//	}
	// 관리자가 Notice 글 삭제하기
//	@RequestMapping(value = "/cs_delete_notice.LF", method = RequestMethod.GET)
//	public String cscenterDeleteNotice() {
//		return null;
//	} 
	// 회원이 Notice 글쓰기 + 파일
	@RequestMapping(value = "/cs_post_notice.LF", method = RequestMethod.GET)
	public String cscenterPostNotice() {
		System.out.println("cscenterPostNotice()...");
		return "cscenter/cs_notice_post.ho";
	}
	
//	@RequestMapping(value = "/cs_add_notice.LF", method = RequestMethod.GET)
//	public String cscenterAddNotice(int mbId, String mbNicname, int type, String title, String content, List<MultipartFile>file, int showPrivate, HttpSession ses) {
//		System.out.println("cscenterAddNotice()...");
//		System.out.println("multipart size: " + file.size());
//		String realPath = ses.getServletContext().getRealPath(ICscenterFileSVC.DEF_UPLOAD_DEST)+"/";
//		
//		//다중 처리
//		Map<String, Object> rMap = csSvc.writeUploadedMultipleFiles(file, realPath, (String)ses.getAttribute("mbLoginName"));
//		String filePath = (String)rMap.get("muliFPs");
//		
//		System.out.println("총 파일 수: " + rMap.get("fileCnt"));
//		System.out.println("총 볼륨(MB): "+ rMap.get("totalMB") +"MB");
//		
//		// public img src... 
//		int ntRtkey = this.ntSvc.insertNewNoticeReturnKey(mbId, type, title, content,filePath );
//		// 상세보기 => atId?
//		if( ntRtkey > 0 ) {
//			System.out.println("게시글 등록 성공: " + ntRtkey);
//			return "redirect:cs_receive_notice.ho?id="+ ntRtkey;
//		} else {
//			System.out.println("게시글 등록 실패: " + title);
//			return "cscenter/cs_notice_post.ho"; //
//		}
//	}
	// Notice 글 상세보기
	@RequestMapping(value = "/cs_receive_notice.LF", method = RequestMethod.GET)
	public String cscenterReceiveNotice(HttpSession ses, int id, Model model) {
		NoticeVO nt = this.ntSvc.selectOneNotice(id);
		if( nt != null ) {
			System.out.println("게시글 상세조회 성공 " + nt);
			model.addAttribute("Notice", nt);
			String ntFilePath = nt.getFile();
			int fpsCount = -1;
			if( ntFilePath != null && ntFilePath.isEmpty()) {
				String fps[] = null;
				if( ntFilePath.indexOf(ICscenterFileSVC.MULTI_SEP) != -1 ) {
					fps = ntFilePath.split("\\" + ICscenterFileSVC.MULTI_SEP);
					fpsCount = fps.length;
				} else {
					fpsCount = 1;
					fps = new String[]{ntFilePath};
				}
				model.addAttribute("fps", fps);
			} else {
				//첨부파일 없는 정상 게시글 상세보기
				fpsCount = 0;
			}
			model.addAttribute("fpsCount", fpsCount);
			
			return "cscenter/cs_notice_receive.ho";
		} else {model.addAttribute("msg", "게시글 상세조회 실패 - " + id);
			return "redirect:cs_notice.ho";
		}
	}
	
	// Notice 글 수정하기
	@RequestMapping(value = "/cs_edit_notice.LF", method = RequestMethod.GET)
	public String cscenterEditNotice(HttpSession ses, Model model, 
			@RequestParam(value = "ntId", defaultValue = "0") int id){
		if(id == 0 ) {
			return "redirect:cs_notice.ho";
		}
		NoticeVO nt = ntSvc.selectOneNotice(id);
		if( nt != null ) {
			// 세션로그인 유저가 편집대상 게시글 작성자인가? 아니면 권한이 있거나?
			int writerId = nt.getMbId();
			if( writerId == (int)ses.getAttribute("mbId")) {
				model.addAttribute("notice", nt);
				return "cscenter/cs_notice_edit.ho";
			} else {
				model.addAttribute("msg", "게시글 편집폼 준비 실패: 작성자 아님");
				return "redirect:redirect:cs_notice.ho?id=" +id; 
			}
		} else {
			model.addAttribute("msg", "게시글 편집폼 준비 실패: 게시글 없음");
			return "redirect:cs_notice.ho?id=" +id; 
		}
	}	
//	@RequestMapping(value = "/cs_update_notice.LF", method = RequestMethod.POST)
//	public String noticeUpdateProc(HttpSession ses, @ModelAttribute(value = "notice") NoticeVO nt) { // vo를 command객체로 사용하자.
//		System.out.println("notice update: "+ nt);
//		boolean b = ntSvc.updateNotice(nt);
//		if( b ) {
//			return "redirect:cs_notice.ho?id="+nt.getId();
//		} else {
//			return "cscenter/cs_notice_edit.ho";
//		}
//	}
//	// Notice 글 삭제하기
//	@RequestMapping(value = "/cs_delete_notice.LF", method = RequestMethod.GET)
//	public String cscenterDeleteNotice() {
//		return null;
//	}
	
	//Notice 리스트 조회하기 (페이지네이션, 정렬)
	@RequestMapping(value = "cs_notice.LF",method = RequestMethod.GET)
	public ModelAndView cscenterNotice( @RequestParam(value = "pn",required = false,defaultValue = "1") int pageNumber) {
		System.out.println("cscenterNotice(PN)..");
		int ntmaxPG = ntSvc.checkMaxPageNumber();
		if( pageNumber > ntmaxPG || pageNumber <= 0 ) {
			System.out.println("잘못된 페이지 번호: " + pageNumber);
		}
		List<NoticeVO> ntList = ntSvc.showAllNotices(pageNumber);
		ModelAndView mav = new ModelAndView("cscenter/cs_notice.ho");
		if( ntList != null ) {
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
	
	
	
	
}
