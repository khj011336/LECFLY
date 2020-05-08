package com.LECFLY.LF.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {
	@RequestMapping(value = "/pay_cart.LF", method = RequestMethod.GET)
	public String tempCart(HttpSession ses, Model model) {
		System.out.println("장바구니 페이지 이동");
		return "payment/pay_cart.pay";
	}

}
