package com.LECFLY.LF.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.LECFLY.LF.model.vo.NoticeVO;
import com.LECFLY.LF.model.vo.QnaVO;
import com.LECFLY.LF.service.inf.cscenter.ICscenterFileSVC;
import com.LECFLY.LF.service.inf.cscenter.INoticeSVC;
import com.LECFLY.LF.service.inf.cscenter.IQnaSVC;

@Controller
@RequestMapping("/cscenter")
public class CscenterController {
	@Autowired
	private IQnaSVC qaSvc;
	
//	@Autowired
//	private IFaqSVC fqSvc;
//	
	@Autowired
	private INoticeSVC ntSvc;
	
	@Autowired
	private ICscenterFileSVC csSvc; 
	
//	// cscenter 홈
//	@RequestMapping(value = "/cscenter.LF", method = RequestMethod.GET)
//	public String cscenterHome() {
//		System.out.println("cscenterHome()...");	
//		return "cscenter/cs_main";
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
//		return "cscenter/cs_faq";
//	}
//	// NOTICE
//	@RequestMapping(value = "/cs_notice.LF", method = RequestMethod.GET)
//	public String cscenterNotice() {
//		System.out.println("cscenterNotice()...");
//		return "cscenter/cs_notice";
//	}
	
	
	// 회원이 QnA 글쓰기 + 파일
	@RequestMapping(value = "/cs_post_qna.LF", method = RequestMethod.GET)
	public String cscenterPostQna() {
		System.out.println("cscenterPostQna()...");
		return "cscenter/cs_qna_post.cs";
	}
	
	@RequestMapping(value = "/cs_add_qna.LF", method = RequestMethod.GET)
	public String cscenterAddQna(int mbId, String mbNicname, int type, String title, String content, List<MultipartFile>file, int showPrivate, HttpSession ses) {
		System.out.println("cscenterAddQna()...");
		System.out.println("multipart size: " + file.size());
		String realPath = ses.getServletContext().getRealPath(ICscenterFileSVC.DEF_UPLOAD_DEST)+"/";
		
		//다중 처리
		Map<String, Object> rMap = csSvc.writeUploadedMultipleFiles(file, realPath, (String)ses.getAttribute("mbLoginName"));
		String filePath = (String)rMap.get("muliFPs");
		
		System.out.println("총 파일 수: " + rMap.get("fileCnt"));
		System.out.println("총 볼륨(MB): "+ rMap.get("totalMB") +"MB");
		
		// public img src... 
		int qaRtkey = this.qaSvc.insertNewQnaReturnKey(mbId, mbNicname, type, title, content,filePath, showPrivate );
		// 상세보기 => atId?
		if( qaRtkey > 0 ) {
			System.out.println("게시글 등록 성공: " + qaRtkey);
			return "redirect:cs_receive_qna.LF?id="+ qaRtkey;
		} else {
			System.out.println("게시글 등록 실패: " + title);
			return "cscenter/cs_qna_post.cs"; //
		}
	}
	
	// QnA 글 상세보기
	@RequestMapping(value = "/cs_receive_qna.LF", method = RequestMethod.GET)
	public String cscenterReceiveQna(HttpSession ses, int id, Model model) {
		QnaVO qa = this.qaSvc.selectOneQna(id);
		if( qa != null ) {
			System.out.println("게시글 상세조회 성공 " + qa);
			model.addAttribute("qna", qa);
			String qaFilePath = qa.getFile();
			int fpsCount = -1;
			if( qaFilePath != null && qaFilePath.isEmpty()) {
				String fps[] = null;
				if( qaFilePath.indexOf(ICscenterFileSVC.MULTI_SEP) != -1 ) {
					fps = qaFilePath.split("\\" + ICscenterFileSVC.MULTI_SEP);
					fpsCount = fps.length;
				} else {
					fpsCount = 1;
					fps = new String[]{qaFilePath};
				}
				model.addAttribute("fps", fps);
			} else {
				//첨부파일 없는 정상 게시글 상세보기
				fpsCount = 0;
			}
			model.addAttribute("fpsCount", fpsCount);
			return "cscenter/cs_qna_receive";
		} else {model.addAttribute("msg", "게시글 상세조회 실패 - " + id);
			return "redirect:cs_qna.LF";
		}
	}
	// QnA 글 수정하기
	@RequestMapping(value = "/cs_edit_qna.LF", method = RequestMethod.GET)
	public String cscenterEditQna(HttpSession ses, Model model, 
			@RequestParam(value = "qaId", defaultValue = "0") int id){
		if(id == 0 ) {
			return "redirect:cs_qna.LF";
		}
		QnaVO qa = qaSvc.selectOneQna(id);
		if( qa != null ) {
			// 세션로그인 유저가 편집대상 게시글 작성자인가? 아니면 권한이 있거나?
			int writerId = qa.getMbId();
			if( writerId == (int)ses.getAttribute("mbId")) {
				model.addAttribute("qna", qa);
				return "cscenter/cs_qna_edit.cs";
			} else {
				model.addAttribute("msg", "게시글 편집폼 준비 실패: 작성자 아님");
				return "redirect:redirect:cs_qna.LF?id=" +id; 
			}
		} else {
			model.addAttribute("msg", "게시글 편집폼 준비 실패: 게시글 없음");
			return "redirect:cs_qna.LF?id=" +id; 
		}
	}	
	@RequestMapping(value = "/cs_update_qna.LF", method = RequestMethod.POST)
	public String qnaUpdateProc(HttpSession ses, @ModelAttribute(value = "qna") QnaVO qa) { // vo를 command객체로 사용하자.
		System.out.println("qna update: "+ qa);
		boolean b = qaSvc.updateQna(qa);
		if( b ) {
			return "redirect:cs_qna.LF?id="+qa.getId();
		} else {
			return "cscenter/cs_qna_edit";
		}
	}
	// QnA 글 삭제하기
	@RequestMapping(value = "/cs_delete_qna.LF", method = RequestMethod.GET)
	public String cscenterDeleteQna() {
		return null;
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
		ModelAndView mav = new ModelAndView("cscenter/cs_qna");
		if( qaList != null ) {
			mav.addObject("atSize", qaList.size());
			mav.addObject("qna", qaList);
			mav.addObject("maxPn", qamaxPG);
			mav.addObject("pn", pageNumber); // 활성페이지 
				System.out.println("게시글리스트 조회 성공: " + qaList.size());
		} else {
			mav.addObject("msg", "게시글리스트 조회 실패!");
		}
		return mav;
	}
	
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
		return "cscenter/cs_notice_post.cs";
	}
	
	@RequestMapping(value = "/cs_add_notice.LF", method = RequestMethod.GET)
	public String cscenterAddNotice(int mbId, String mbNicname, int type, String title, String content, List<MultipartFile>file, int showPrivate, HttpSession ses) {
		System.out.println("cscenterAddNotice()...");
		System.out.println("multipart size: " + file.size());
		String realPath = ses.getServletContext().getRealPath(ICscenterFileSVC.DEF_UPLOAD_DEST)+"/";
		
		//다중 처리
		Map<String, Object> rMap = csSvc.writeUploadedMultipleFiles(file, realPath, (String)ses.getAttribute("mbLoginName"));
		String filePath = (String)rMap.get("muliFPs");
		
		System.out.println("총 파일 수: " + rMap.get("fileCnt"));
		System.out.println("총 볼륨(MB): "+ rMap.get("totalMB") +"MB");
		
		// public img src... 
		int ntRtkey = this.ntSvc.insertNewNoticeReturnKey(mbId, type, title, content,filePath );
		// 상세보기 => atId?
		if( ntRtkey > 0 ) {
			System.out.println("게시글 등록 성공: " + ntRtkey);
			return "redirect:cs_receive_notice.LF?id="+ ntRtkey;
		} else {
			System.out.println("게시글 등록 실패: " + title);
			return "cscenter/cs_notice_post.cs"; //
		}
	}
	
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
			return "cscenter/cs_notice_receive";
		} else {model.addAttribute("msg", "게시글 상세조회 실패 - " + id);
			return "redirect:cs_notice.LF";
		}
	}
	// Notice 글 수정하기
	@RequestMapping(value = "/cs_edit_notice.LF", method = RequestMethod.GET)
	public String cscenterEditNotice(HttpSession ses, Model model, 
			@RequestParam(value = "ntId", defaultValue = "0") int id){
		if(id == 0 ) {
			return "redirect:cs_notice.LF";
		}
		NoticeVO nt = ntSvc.selectOneNotice(id);
		if( nt != null ) {
			// 세션로그인 유저가 편집대상 게시글 작성자인가? 아니면 권한이 있거나?
			int writerId = nt.getMbId();
			if( writerId == (int)ses.getAttribute("mbId")) {
				model.addAttribute("notice", nt);
				return "cscenter/cs_notice_edit.cs";
			} else {
				model.addAttribute("msg", "게시글 편집폼 준비 실패: 작성자 아님");
				return "redirect:redirect:cs_notice.LF?id=" +id; 
			}
		} else {
			model.addAttribute("msg", "게시글 편집폼 준비 실패: 게시글 없음");
			return "redirect:cs_notice.LF?id=" +id; 
		}
	}	
	@RequestMapping(value = "/cs_update_notice.LF", method = RequestMethod.POST)
	public String noticeUpdateProc(HttpSession ses, @ModelAttribute(value = "notice") NoticeVO nt) { // vo를 command객체로 사용하자.
		System.out.println("notice update: "+ nt);
		boolean b = ntSvc.updateNotice(nt);
		if( b ) {
			return "redirect:cs_notice.LF?id="+nt.getId();
		} else {
			return "cscenter/cs_notice_edit";
		}
	}
	// QnA 글 삭제하기
	@RequestMapping(value = "/cs_delete_notice.LF", method = RequestMethod.GET)
	public String cscenterDeleteNotice() {
		return null;
	}
	
	// QnA 리스트 조회하기 (페이지네이션, 정렬)
	@RequestMapping(value = "cs_notice.LF",method = RequestMethod.GET)
	public ModelAndView cscenterNotice( @RequestParam(value = "pn",required = false,defaultValue = "1") int pageNumber) {
		System.out.println("cscenterNotice(PN)..");
		int ntmaxPG = ntSvc.checkMaxPageNumber();
		if( pageNumber > ntmaxPG || pageNumber <= 0 ) {
			System.out.println("잘못된 페이지 번호: " + pageNumber);
			return new ModelAndView(
				"redirect:cs_notice.LF?pn=1");
		}
		List<NoticeVO> ntList = ntSvc.showAllNotices(pageNumber);
		ModelAndView mav = new ModelAndView("cscenter/cs_notice");
		if( ntList != null ) {
			mav.addObject("atSize", ntList.size());
			mav.addObject("qna", ntList);
			mav.addObject("maxPn", ntmaxPG);
			mav.addObject("pn", pageNumber); // 활성페이지 
				System.out.println("게시글리스트 조회 성공: " + ntList.size());
		} else {
			mav.addObject("msg", "게시글리스트 조회 실패!");
		}
		return mav;
	}
	
}
