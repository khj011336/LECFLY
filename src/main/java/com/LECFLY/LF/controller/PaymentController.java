package com.LECFLY.LF.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.LECFLY.LF.model.vo.CartVO;
import com.LECFLY.LF.model.vo.MemberVO;
import com.LECFLY.LF.service.inf.cart.ICartSVC;

@Controller("cartController")
@RequestMapping("/cart")
	public class PaymentController {
		@Autowired
		private ICartSVC ctSvc;
		@Autowired
		private CartVO cartVO;
		@Autowired
		private MemberVO memberVO;

// - 강의 상페 페이지를 조회할 수 있다.
	@RequestMapping(value= "/pay_intro.LF", method = RequestMethod.GET)
	public String selectLecture() {
		System.out.println("강의 상세 페이지로 이동");
		return "paymnet/pay_intro.pay";
	}
		
// - 장바구니 페이지를 조회할 수 있다.
	@RequestMapping(value = "/pay_cart.LF", method = RequestMethod.GET)
	public String selectCart() {
		System.out.println("장바구니 페이지로 이동");
		return "payment/pay_cart.pay";
	}

// - 주문 페이지로 이동할 수 있다.
	@RequestMapping(value = "/pay_order.LF", method = RequestMethod.GET)
	public String selectOrder() {
		System.out.println("결제 페이지로 이동");
		return "payment/pay_order.pay";
	}
		
// - 결제 페이지로 이동할 수 있다.
	@RequestMapping(value = "/pay_order_finish.LF", method = RequestMethod.GET)
	public String selectOrderFinish() {
		System.out.println("결제 완료페이지로 이동");
		return "payment/pay_order_finish.pay";
	}
		
// - 주문 상세페이지로 이동할 수 있다.
	@RequestMapping(value = "/pay_order_detail.LF", method = RequestMethod.GET)
	public String selectOrderDetail() {
		System.out.println("결제 상세페이지로 이동");
		return "payment/pay_order_detail.pay";
	}
		
}
