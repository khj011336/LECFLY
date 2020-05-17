package com.LECFLY.LF.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.LECFLY.LF.model.vo.CartVO;
import com.LECFLY.LF.model.vo.CommentClassVO;
import com.LECFLY.LF.model.vo.MemberVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.service.inf.cart.ICartSVC;

@Controller
public class PaymentController {
	@Autowired
	ICartSVC cartSVC;
	@Autowired
	CartVO cartVO;
	@Autowired
	MemberVO memberVO;
	
	
	final String[] STR_CATE = {"전체", "미술", "음악", 
			"요리", "라이프스타일", "운동", "커리어", "여행"};
	
//	@RequestMapping(value = "pay_goodsDetail.LF", method = RequestMethod.POST)
//	@ResponseBody
//	public String addGoodsInCart(@RequestParam("gdsId") int gdsId,
//							     HttpServletRequest request,
//							     HttpServletResponse response) throws Exception {
//		HttpSession session = request.getSession();
//		memberVO = (MemberVO)session.getAttribute("memberInfo");
//		int mbId = memberVO.getId();
//		cartVO.setMbId(mbId);
//		cartVO.setGdsId(gdsId);
//		boolean isAreadyExisted = cartSVC.findCartGoods(cartVO);
//		System.out.println("isAreadyExisted: " + isAreadyExisted);
//		
//		if ( isAreadyExisted == true) {
//			return "already_existed";
//		} else {
//			cartSVC.addGoodsInCart(cartVO);
//			return "add_success";
//		}
//	}
	
	@RequestMapping(value = "pay_goodsDetail.LF", method = RequestMethod.GET)
	public String addGoodsInCart(
				@RequestParam("lecId") int lecId,
				HttpSession ses, Model model) 
	{
		System.out.println("payController::  addGoodsInCart()");
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		int mbId = mb.getId();
		System.out.println("mb = " + mb);
		
		Map<String, Object> pMap = cartSVC.showGoodsProc(mbId, lecId);
		if(pMap != null) {
			LectureVO lec = (LectureVO)pMap.get("lec");
			int category = lec.getCategory();
			String strCategory = STR_CATE[category];
			KitVO kit = (KitVO)pMap.get("kit");
			List<VideoVO> vdList = (List<VideoVO>)pMap.get("vdList");
			String creName = (String)pMap.get("creName");
			String creInfo = (String)pMap.get("creInfo");
			
			List<CommentClassVO> ccList = (List<CommentClassVO>)pMap.get("ccList");
			model.addAttribute("lec", lec);
			model.addAttribute("kit", kit);
			model.addAttribute("vdList", vdList);
			model.addAttribute("creName", creName);
			model.addAttribute("creInfo", creInfo);
			model.addAttribute("ccList", ccList);
			model.addAttribute("lecCategory", strCategory);
			return "payment/pay_goodsDetail";
		} else {
			
			return "";
		}
	}
	

}
