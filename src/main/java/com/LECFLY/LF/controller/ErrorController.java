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
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping(path = "/error")
public class ErrorController {
	@GetMapping
	public String defaultError() {
		return "common/error.jsp";
	}

	@GetMapping("/no-resource")
	public String noResource() {
		return "common/error404.jsp";
	}

	@GetMapping("/server-error")
	public String serverError() {
		return "common/error500.jsp";
	}
}