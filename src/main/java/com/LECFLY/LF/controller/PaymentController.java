package com.LECFLY.LF.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.LECFLY.LF.model.vo.CartVO;
import com.LECFLY.LF.model.vo.MemberVO;
import com.LECFLY.LF.service.inf.cart.ICartSVC;

@Controller
public class PaymentController {
	@Autowired
	ICartSVC cartSVC;
	@Autowired
	CartVO cartVO;
	@Autowired
	MemberVO memberVO;
	
	@RequestMapping(value = "pay_goodsDetail.LF", method = RequestMethod.POST)
	@ResponseBody
	public String addGoodsInCart(@RequestParam("gdsId") int gdsId,
							     HttpServletRequest request,
							     HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		memberVO = (MemberVO)session.getAttribute("memberInfo");
		int mbId = memberVO.getId();
		cartVO.setMbId(mbId);
		cartVO.setGdsId(gdsId);
		boolean isAreadyExisted = cartSVC.findCartGoods(cartVO);
		System.out.println("isAreadyExisted: " + isAreadyExisted);
		
		if ( isAreadyExisted == true) {
			return "already_existed";
		} else {
			cartSVC.addGoodsInCart(cartVO);
			return "add_success";
		}
	}
	

}
