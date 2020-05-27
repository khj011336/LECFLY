package com.LECFLY.LF.controller;

import java.text.SimpleDateFormat;
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

import com.LECFLY.LF.model.vo.PostscriptVO;
import com.LECFLY.LF.model.vo.cart.CartVO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.model.vo.member.CommentVO;
import com.LECFLY.LF.model.vo.member.MemberVO;
import com.LECFLY.LF.service.inf.cart.ICartSVC;
import com.LECFLY.LF.service.inf.comment.ICommentSVC;
import com.LECFLY.LF.service.inf.member.IPostscriptSVC;
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
	
	//후기/댓글서비스 추가
	@Autowired
	IPostscriptSVC psSvc;
	@Autowired
	ICommentSVC ctSvc;
	
	final String[] STR_CATE = {"전체", "미술", "음악", "요리", "라이프스타일", "운동", "커리어", "여행"};
	
	// 회원이 티켓구매 안내 페이지로 이동할 수 있다.
	@RequestMapping(value = "lecfly_ticket.LF", method = RequestMethod.GET)
	public String showTicketProc() {
		System.out.println("티켓 안내 페이지로 이동!");
		return "payment/ticket_guide/lecfly_ticket.pay";
	}
	
	// 회원이 한개의 선택한 티켓을 주문페이지로 이동할 수 있다.
	@RequestMapping(value = "pay_order.LF", method = RequestMethod.POST)
	public String showOrderProc(HttpSession ses,
								@RequestParam("ticName") int ticName,
								Model model) {
		System.out.println("티켓 안내 페이지로 이동!");
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		
		if(mb != null) {
			int mbId = mb.getId();
			System.out.println("결제 페이지로 이동! ticName = " + ticName);
			Map<String, Object> pMap = paySvc.showOrderProc(mbId, ticName);
			if( pMap != null) {
				int ticMap = (Integer)pMap.get("r");
				CartVO ct = (CartVO)pMap.get("cart");
				List<CartVO> ctList = new ArrayList<CartVO>();
				ctList.add(ct);
				if ( ticMap == 1 )
				model.addAttribute("ctSize", ctList.size());		
				model.addAttribute("ticMap", ticMap);
				model.addAttribute("ctList", ctList);
			} else {
				System.out.println("이미 티켓이 존재하고 있습니다.");
			}
		} else {
			System.out.println("멤버 로그인 페이지로 이동!");
			return "member/login";
		}
		return "payment/pay_order.pays";
	}
	
	// 회원이 세션 로그인 후, 상품 상세페이지로 이동 할 수 있다.
	@RequestMapping(value = "pay_goodsDetail.LF", method = RequestMethod.GET)
	public String showLectureProc(
			@RequestParam("lecId") int lecId, Model model, HttpSession ses
			) {
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
				
				//5.26gm - 후기를 위한 추가사항
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String postscript = "";
				List<PostscriptVO> psList = psSvc.readAllPostscriptInLec(lecId);
				for (PostscriptVO ps : psList) {
					System.out.println("test" + ps);
				}
				List<String> psListRate = new ArrayList<String>(psList.size());
				for (int i = 0; i < psList.size(); i++) {
					String stars = "";
					float rate = psList.get(i).getRate();
					int times = (int)rate;
					for (int j = 0; j < times; j++) {
						stars += "★";
					}
					if( (rate*2)%2 == 1)
						stars += "☆";
					postscript +=
							"		\r\n	<p id=\"register_review\">" + 
							"					<span class=\"review_name\">"+ psList.get(i).getMbLogin() +"</span>&nbsp;&nbsp;<label>"+stars+ 
							"					</label><span class=\"review_week\"><small>"+sdf.format(psList.get(i).getWritedDay())+"</small>" + 
							"						</span>\r\n\r\n<small>"+psList.get(i).getContent()+"</small>" + 
							"				</p>";
				}
				model.addAttribute("postscript", postscript);
				
				// 5.27 댓글을 위한 추가사항
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String comment = "";
				List<CommentVO> ctList = ctSvc.selectCommentsForOrderNumAsc(ctSvc.LEC_ARTICLE, lecId);
				for (int i = 0; i < ctList.size(); i++) {
					CommentVO ctori = ctList.get(i);
					comment += "			<div"+(ctori.getDepth()==0?"":" style='padding-left:"+ctori.getDepth()*20+"px'")+"><image src='resources/imges/unknown/no_profile_img.PNG' style='width:15px; heigth:15px;'/><label>" + ctori.getMbNic() + "님</label>\r\n" + 
							"				<label style=\"padding-left:45px;\">" + ctori.getComment() + "</label>\r\n" +
							"				<small style=\"text-align:right; color:lightgrey;\">(" + sdf.format(ctori.getCreatedAt()) +")</small>\r\n" +
							"				<input type=\"hidden\" value='"+ ctori.getId()+"'><i id=\"under_comment\" style=\"padding-left:10px\" class=\"fas fa-comments\"></i>" + 
							"				</div><div id='udner_ct_form'></div>";
				}
				model.addAttribute("comment", comment);
//				List<CommentVO> ctList = ctSvc.selectCommentsForOrderNumAsc(ctSvc.LEC_ARTICLE, lecId);
//				for (CommentVO ct : ctList) {
//					System.out.println("test" + ct);
//				}
//				model.addAttribute("ctList", ctList);
				
				// 5.27 강의 신청하기를 위한 데이터 출력(회원이 가지고 있는 category를 뽑아야됨)
				MemberVO mb = (MemberVO)ses.getAttribute("member");
				
				
				return "payment/pay_goodsDetail.pay";
			} else {
				return "lecture/main.ho";
			}
	}
	
	// 단일 댓글 작성시 (대댓글 x)
	@RequestMapping(value="insert_comment.LF", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> memberMypageUpdatePwProc(
			HttpSession ses,
			@RequestParam(value="ct") String ct,
			@RequestParam(value="lecId") int lecId
			) {
		System.out.println("insert_comment.LF 진입 성공 ct = "+ct+ ", lecId = "+lecId);
		Map<String, Object> rMap = new HashMap<String, Object>();
		String temp = "";
		String result = "";
		
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		if(mb==null) {
			System.out.println("로그아웃상태");
			temp="로그아웃되어있음";
			rMap.put("temp",temp);
			return rMap;
		}
		int mbId = mb.getId();
		String mbNic = mb.getNicname();
		int r = ctSvc.addComment(mbId, ctSvc.LEC_ARTICLE, lecId, ct, mbNic, ctSvc.ORIGIN_COMMENT);
		switch (r) {
		case 1:
			result = "성공";
			break;
		case 2:
			result = "실패";
			break;
		case 3:
			result = "해당 글 없음";
			break;
		case 4:
			result = "order증산 실패";
			break;
		default:
			break;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<CommentVO> ctList = ctSvc.selectCommentsForOrderNumAsc(ctSvc.LEC_ARTICLE, lecId);
		for (int i = 0; i < ctList.size(); i++) {
			CommentVO ctori = ctList.get(i);
			temp += "			<div"+(ctori.getDepth()==0?"":" style='padding-left:"+ctori.getDepth()*20+"px'")+"><image src='resources/imges/unknown/no_profile_img.PNG' style='width:15px; heigth:15px;'/><label>" + ctori.getMbNic() + "님</label>\r\n" + 
					"				<label style=\"padding-left:45px;\">" + ctori.getComment() + "</label>\r\n" +
					"				<small style=\"text-align:right; color:lightgrey;\">(" + sdf.format(ctori.getCreatedAt()) +")</small>\r\n" +
					"				<input type=\"hidden\" value='"+ ctori.getId()+"'><i id=\"under_comment\" style=\"padding-left:10px\" class=\"fas fa-comments\"></i>" + 
					"				</div><div id='udner_ct_form'></div>";
		}
		rMap.put("temp", temp);
		System.out.println(temp);
		return rMap;
	}
	
	
	@RequestMapping(value = "check_pay_cart.LF", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> CheckOrderProc(HttpSession ses, @RequestParam("kitId") int kitId) {
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		Map<String, Object> rMap = new HashMap<>(); 
		if( mb != null ) {
			int mbId = mb.getId();
			boolean r = cartSvc.checkCartForKitMb(mbId, kitId); 
			if ( r ) {
				System.out.println("1개가 있어서 만들필요없어");
				int c = 1;
				rMap.put("c", c);
			}else {
				System.out.println("1개가 없어서 만들어야되");
				int c = 0;
				rMap.put("c", c);
				cartSvc.insertNewCartByMbIdTicId(mbId, kitId);
			}
			
		} else {
			System.out.println("mb 없음");
			System.out.println("왜일로온지모르겠어.");
			int c = 0;
			rMap.put("c", c);
		}
		return rMap;
	}
	
	
	
//	 회원과 비회원이 장바구니페이지로 들어 갈 때, 세션으로 물건들을 넣을 수 있다.
	@RequestMapping(value = "pay_cart.LF", method = RequestMethod.POST)
	public String showCartProc(HttpSession ses,
							   @RequestParam("kitId") int kitId,
							   Model model){
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		if(mb != null) {
			int mbId = mb.getId();
			if( mbId > 0 ) {
				System.out.println("회원으로 장바구니 이동!");
				System.out.println("kitId = " + kitId);
				//카트에서 해당 mb가 저키트를 가지고있는지 체크하는 함수 select 하는함수	
				Map<String, Object> cMap = cartSvc.showCartProc(mbId, kitId);
				if(cMap != null) {
					List<KitVO> kitList = (List<KitVO>)cMap.get("kitList");
					model.addAttribute("kitList", kitList);
					List<CreatorVO> creList = (List<CreatorVO>)cMap.get("creList");
					model.addAttribute("creList", creList);
				}
			} else {
				System.out.println("비회원으로 장바구니 이동!");
				Map<String, Object> cMap = cartSvc.showCartProc(mbId, kitId);
				
			}
			System.out.println("payment/pay_cart.pays");
			
		} else {
			// 여유생기면 구현예정
			//Map<String, Object> pMap = cartSvc.showCartByNoMbProc(kitId); // 카트아이디가 리턴되애되
			System.out.println("mb 가없음");
		}
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
