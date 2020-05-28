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
import org.springframework.web.bind.annotation.ResponseBody;

import com.LECFLY.LF.model.dao.impl.TestGeon2;
import com.LECFLY.LF.model.dao.inf.creator.IKitDAO;
import com.LECFLY.LF.model.dao.inf.payHistory.IPayHistoryDAO;
import com.LECFLY.LF.model.vo.cart.CartVO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.model.vo.member.CommentVO;
import com.LECFLY.LF.model.vo.member.MemberVO;
import com.LECFLY.LF.service.inf.cart.ICartSVC;
import com.LECFLY.LF.service.inf.payhistory.IPayHistorySVC;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

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
	
	
	// 회원이 한개의 선택한 티켓을 바로 주문페이지로 이동할 수 있다.
	@RequestMapping(value = "pay_order.LF", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> showOrderProc(HttpSession ses,
								@RequestParam(value = "ticName", defaultValue="1") int ticName,
								Model model) {
			System.out.println("티켓 안내 페이지로 이동!");
			Map<String, Object> rMap = new HashMap<>();
			MemberVO mb = (MemberVO)ses.getAttribute("member");
			if ( mb != null) {
				int mbId = mb.getId();			
				System.out.println("결제 페이지로 이동! ticName = " + ticName);
				Map<String, Object> pMap = paySvc.showOrderProc(mbId, ticName);
				if( pMap != null) {
					System.out.println("pMap 은 not null");
					int ticMap = (Integer)pMap.get("r");
					CartVO ct = (CartVO)pMap.get("cart");
					List<CartVO> ctList = new ArrayList<CartVO>();
					ctList.add(ct);
					if ( ticMap == 1 ) {
						rMap.put("ctSize", ctList.size());
						rMap.put("ticMap", ticMap);
						rMap.put("ctList", ctList);
						rMap.put("result", "yes");
					} else {
						rMap.put("result", "no");
						System.out.println("no 실패");
						rMap.put("msg", "이미 티켓이 존재하고 있습니다.");
						System.out.println("이미 티켓이 존재하고 있습니다.");
					}
					
					System.out.println("yes 성공");
				} else {
					rMap.put("result", "no");
					rMap.put("msg", "pMap 은 null");
					System.out.println("pMap 은 null");				
					System.out.println("no 실패");
				}
			} else {
				rMap.put("result", "no");
				rMap.put("msg", "mb는 null");
				System.out.println("mb는 null");				
				System.out.println("no 실패");
			}
			return rMap;
	}
	
	// 회원이 세션 로그인 후, 강의 상세페이지로 이동 할 수 있다.
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
	
	// 회원이 키트를 장바구니에 담을 떄, 담긴 것과 아닌 것을 분기해서 처리 할 수 있다.
	@RequestMapping(value = "check_pay_cart.LF", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> CheckOrderProc(HttpSession ses, 
											  @RequestParam("kitId") int kitId,
											  @RequestParam(value = "gdType", required = false, defaultValue = "kit" ) String gdType) {
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		Map<String, Object> rMap = new HashMap<>(); 
		if( mb != null ) {
			int mbId = mb.getId();
			boolean r = cartSvc.checkCartForKitMb(mbId, kitId); 
			if ( r ) {
				System.out.println("상품이 만들어짐");
				int c = 1;
				rMap.put("c", c);
			} else {
				System.out.println("상품이 없음");
				int c = 0;
				rMap.put("c", c);
				// 넣을 제품이 키트인지 티켓인지 구분...							
				int cr = cartSvc.insertNewCartByTicId(mbId, kitId, gdType);
				if( cr == 1 ) {
					
				} else {
					
				}
			}
		} else {
			System.out.println("mb 없음");
			int c = 0;
			rMap.put("c", c);
		}
		return rMap;
	}
	
	
	
//	장바구니페이지로 들어 갈 때, 세션으로 물건들을 넣을 수 있다.
	@RequestMapping(value = "pay_cart.LF", method = RequestMethod.GET)
	public String showCartProc(HttpSession ses, 
			@RequestParam("kitId") int kitId,
			Model model){
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		if(mb != null) {
			int mbId = mb.getId();
			if( mbId > 0 ) {
				System.out.println("회원으로 장바구니 이동!");
				//카트에서 해당 mb가 저키트를 가지고있는지 체크하는 함수 select 하는함수	
				Map<String, Object> cMap = cartSvc.showCartProc(mbId, kitId);
				if(cMap != null) {
					List<KitVO> kitList = (List<KitVO>)cMap.get("kitList");
					List<CreatorVO> creList = (List<CreatorVO>)cMap.get("creList");
					model.addAttribute("kitList", kitList);
					model.addAttribute("creList", creList);					
				}
			} else {
				System.out.println("비회원으로 장바구니 이동!");
				Map<String, Object> cMap = cartSvc.showCartProc(mbId, kitId);
			}
			System.out.println("payment/pay_cart.pay");
			
		} else {
			// 여유 생기면 구현예정
			Map<String, Object> pMap = cartSvc.showCartByNoMbProc(kitId); // 카트아이디가 리턴되야함
			System.out.println("mb 가없음");
		}
		return "payment/pay_cart.pay";
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
