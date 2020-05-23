package com.LECFLY.LF.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.LECFLY.LF.model.vo.CommentVO;
import com.LECFLY.LF.model.vo.MemberVO;
import com.LECFLY.LF.model.vo.TicketVO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.service.inf.cart.ICartSVC;
import com.LECFLY.LF.service.inf.payhistory.IPayHistorySVC;

@Controller
public class PaymentController {
	@Autowired
	IPayHistorySVC paySvc;
	@Autowired
	ICartSVC cartSvc;
	@Autowired
	CartVO cartVO;
	@Autowired
	MemberVO memberVO;
	
	final String[] STR_CATE = {"전체", "미술", "음악", "요리", "라이프스타일", "운동", "커리어", "여행"};
	
	// 회원이 티켓구매 안내 페이지로 이동할 수 있다.
	@RequestMapping(value = "lecfly_ticket.LF", method = RequestMethod.GET)
	public String showTicketProc() {
		System.out.println("티켓 안내 페이지로 이동!");
		return "payment/ticket_guide/lecfly_ticket.pay";
	}
	
	// 회원이 선택한 티켓을 주문페이지로 이동할 수 있다.
	@RequestMapping(value = "pay_order.LF", method = RequestMethod.POST)
	public String showOrderProc(HttpSession ses,
								@RequestParam("ticName") int ticName,
								Model model) {
		System.out.println("왔서왔어");
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		int mbId = mb.getId();
		if(mbId > 0) {
			System.out.println("결제 페이지로 이동! ticName = " + ticName);
			Map<String, Object> pMap = paySvc.showOrderProc(mbId, ticName);
			return "payment/pay_order.pays";
		} else {
			System.out.println("멤버 로그인 페이지로 이동!");
			return "member/login";
		}
		
	}
	
	// 회원이 세션 로그인 후, 상품 상세페이지로 이동 할 수 있다.
	@RequestMapping(value = "pay_goodsDetail.LF", method = RequestMethod.GET)
	public String showLectureProc(@RequestParam("lecId") int lecId, Model model) {
		System.out.println("payController :: showLectureProc()");
		
		Map<String,Object> lMap = cartSvc.showLectureProc(lecId);
			if( lMap != null ) {
				LectureVO lec = (LectureVO)lMap.get("lec");
				int category = lec.getCategory();
				String strCategory = STR_CATE[category];
				KitVO kit = (KitVO)lMap.get("kit");
				List<VideoVO> vidList = (List<VideoVO>)lMap.get("vid");
				String creName = (String)lMap.get("creName");
				String creNickname = (String)lMap.get("creNickname");
				String creInfo = (String)lMap.get("creInfo");
				List<CommentVO> ccList = (List<CommentVO>)lMap.get("ccList");
				System.out.println("kit " + kit);
				model.addAttribute("lec", lec);
				model.addAttribute("cate", strCategory);
				model.addAttribute("kit", kit);
				model.addAttribute("vidList", vidList);
				model.addAttribute("creName", creName);
				model.addAttribute("creNickname", creNickname);
				model.addAttribute("creInfo", creInfo);
				model.addAttribute("ccList", ccList);
				return "payment/pay_goodsDetail.pay";
			} else {
				return "lecture/main.ho";
			}
	}
//	 회원과 비회원이 장바구니페이지로 들어 갈 때, 세션으로 물건들을 넣을 수 있다.
	@RequestMapping(value = "pay_cart.LF", method = RequestMethod.POST)
	public String showCartProc(HttpSession ses,
							   @RequestParam("kitId") int kitId,
							   Model model){
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		int mbId = mb.getId(); 
		if( mbId > 0 ) {
			System.out.println("회원으로 장바구니 이동!");
			Map<String, Object> cMap = cartSvc.showCartProc(mbId, kitId);
			if(cMap != null) {
				List<KitVO> kitList = (List<KitVO>)cMap.get("kitList");
				model.addAttribute("kitList", kitList);
				List<CreatorVO> creList = (List<CreatorVO>)cMap.get("creList");
				model.addAttribute("creList", creList);
			} else { 
				System.out.println("payment/pay_goodsDetail.pay");
				return "payment/pay_goodsDetail.pay";
			}
		} else {
			System.out.println("비회원으로 장바구니 이동!");
			Map<String, Object> cMap = cartSvc.showCartProc(mbId, kitId);
		}
		System.out.println("payment/pay_cart.pays");
		return "payment/pay_cart.pays";
	}
	
	
	
	
	
	 //테스트 용.
//	@RequestMapping(value = "pay_cart.LF", method = RequestMethod.GET)
//	public String showCartProc() {
//		System.out.println("장바구니 페이지로 이동");
//		return "payment/pay_cart.pay";
//	}
//	
//	// - 주문 페이지로 이동할 수 있다.
//		@RequestMapping(value = "/pay_order.LF", method = RequestMethod.GET)
//		public String selectOrder() {
//			System.out.println("결제 페이지로 이동");
//			return "payment/pay_order.pay";
//		}
//			
//	// - 결제 페이지로 이동할 수 있다.
//		@RequestMapping(value = "/pay_order_finish.LF", method = RequestMethod.GET)
//		public String selectOrderFinish() {
//			System.out.println("결제 완료페이지로 이동");
//			return "payment/pay_order_finish.pay";
//		}
//			
//	// - 주문 상세페이지로 이동할 수 있다.
//		@RequestMapping(value = "/pay_order_detail.LF", method = RequestMethod.GET)
//		public String selectOrderDetail() {
//			System.out.println("결제 상세페이지로 이동");
//			return "payment/pay_order_detail.pay";
//		}


}
