package com.LECFLY.LF.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.LECFLY.LF.model.vo.member.MemberVO;
import com.LECFLY.LF.service.inf.comment.ICommentSVC;

@Controller
public class TestController {
/*	
	*****(필독!) 테스트용 댓글 컨트롤러입니다. 삭제예정....******
*/	
	@Autowired
	ICommentSVC ctSvc;


	@RequestMapping(value="test.LF", method=RequestMethod.GET)
	public String commentTestForm(HttpSession ses, Model model) {
		System.out.println("test폼 이동");
		return "test_jsp/comment_test";
	}

	@RequestMapping(value="ct_test_proc.LF", method=RequestMethod.POST)
	public String commentTestProc(HttpSession ses, Model model, String comment, int targetCtId) {
		System.out.println("test_proc실행");
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		System.out.println(mb);
		int mbId = mb.getId();
		int tableCate = 0;
		int atId = 1;
		String mbNic = mb.getNicname();
		int r = ctSvc.addComment(mbId, tableCate, atId, comment, mbNic, targetCtId);
		System.out.println(r+"번결과");
		return "test_jsp/comment_edit_test";
	}

	@RequestMapping(value="test_edit.LF", method=RequestMethod.GET)
	public String commentEditTestForm(HttpSession ses, Model model) {
		System.out.println("test폼 이동");
		return "test_jsp/comment_edit_test";
	}

	@RequestMapping(value="ct_edit_test_proc.LF", method=RequestMethod.POST)
	public String commentTestEditProc(HttpSession ses, Model model, String comment, int targetCtId) {
		System.out.println("test_proc실행");
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		ctSvc.updateOneComment(targetCtId, comment);
		return "home";
	}
}
