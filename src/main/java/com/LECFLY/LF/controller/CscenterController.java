package com.LECFLY.LF.controller;

import java.io.File;
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
import org.springframework.web.servlet.ModelAndView;

import com.LECFLY.LF.service.inf.cscenter.IQnaSVC;

@Controller
public class CscenterController {
	
	// cscenter 홈
	@RequestMapping(value = "/cscenter.LF", method = RequestMethod.GET)
	public String cscenterHome() {
		System.out.println("cscenterHome()...");	
		return "cscenter/cs_main";
	}
	// QnA
	@RequestMapping(value = "/cs_qna.LF", method = RequestMethod.GET)
	public String cscenterQnA() {
		System.out.println("cscenterQnA()...");	
		return "cscenter/cs_qna";
	}
	// FAQ
	@RequestMapping(value = "/cs_faq.LF", method = RequestMethod.GET)
	public String cscenterFAQ() {
		System.out.println("cscenterFAQ()...");
		return "cscenter/cs_faq";
	}
	// NOTICE
	@RequestMapping(value = "/cs_notice.LF", method = RequestMethod.GET)
	public String cscenterNotice() {
		System.out.println("cscenterNotice()...");
		return "cscenter/cs_notice";
	}
	// QnA 글쓰기
	@RequestMapping(value = "/cs_post_qna.LF", method = RequestMethod.GET)
	public String cscenterPostQna() {
		return "cscenter/cs_qna_post.cs";
	}
	// QnA 글 상세보기
	@RequestMapping(value = "/cs_receive_qna.LF", method = RequestMethod.GET)
	public String cscenterReceiveQna() {
		return "cscenter/cs_qna_receive.cs";
	}
}
