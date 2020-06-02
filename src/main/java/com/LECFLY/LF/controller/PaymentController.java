package com.LECFLY.LF.controller;

import java.net.PasswordAuthentication;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.velocity.tools.view.WebappUberspector.SetAttributeExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.LECFLY.LF.model.dao.impl.Test;
import com.LECFLY.LF.model.vo.LecTypeVO;
import com.LECFLY.LF.model.vo.PostscriptVO;
import com.LECFLY.LF.model.vo.admin.PayHistoryVO;
import com.LECFLY.LF.model.vo.cart.CartVO;
import com.LECFLY.LF.model.vo.cart.TicketListVO;
import com.LECFLY.LF.model.vo.cart.TicketVO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.model.vo.member.CommentVO;
import com.LECFLY.LF.model.vo.member.MemberVO;
import com.LECFLY.LF.service.inf.cart.ICartSVC;
import com.LECFLY.LF.service.inf.comment.ICommentSVC;
import com.LECFLY.LF.service.inf.member.IMypageSVC;
import com.LECFLY.LF.service.inf.member.IPostscriptSVC;
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
	@Autowired
	IPayHistorySVC payhisSvc;

	//후기/댓글서비스 추가
	@Autowired
	IPostscriptSVC psSvc;
	@Autowired
	ICommentSVC ctSvc;
	@Autowired				// 지금 저기에 분배할 sql 마이페이지에 필요한거 넣어뒀습니다 가져가시고 해당하는 인터페이스 같이 생성해주세요.
	private Test testDao;

	final String[] STR_CATE = {"전체", "미술", "음악", "요리", "라이프스타일", "운동", "커리어", "여행"};


	// 회원이 한개의 선택한 티켓을 바로 주문페이지로 이동할 수 있다.
	@RequestMapping(value = "before_order.LF", method = RequestMethod.POST)
	//@RequestMapping(value = "before_order.LF", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> beforePayOrderProc(HttpSession ses,
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

	// 회원이 장바구니안에 담겨있는 상품을 결제 할 수 있다.
	@RequestMapping(value = "pay_order.LF", method = RequestMethod.POST)
	public String showPayOrder(HttpSession ses,@RequestBody Map<String,Object> poData, Model model) {

		System.out.println("poMap: " + poData);
			MemberVO mb = (MemberVO)ses.getAttribute("member");

			System.out.println(">>po mb = " + mb);

			if(mb != null) {
			int mbId = mb.getId();
			//int totalPrice = (Integer)poData.get("totalPrice");
			//String totalPts = (String)poData.get("totalPts");
			//System.out.println("totalPts: " + totalPts);

			String via = (String)poData.get("via"); // 루트

			model.addAttribute("pd", poData);
			
			List<Map<String,Object>> dataList = (List<Map<String,Object>>)poData.get("data");

			for(Map<String,Object> m : dataList) {
				cartSvc.updateStateForPayBegin(mbId, (int)m.get("gdsId"), (int)m.get("gdType")); // state 0대상, 0 -> 1
			}
			
//			"via" : "fromBaro",
//			"size": 1,
//			"totalPts": 1,
//			"totalPrice": gTicket.gdsPrice,
//			"data": [ gTicket ]
//			if( via.equals("fromBaro") ) {
//
//				List<Map<String,Object>> dataList = (List<Map<String,Object>>)poData.get("data");
////				"gdsId": gIntName - 1,
////				"gdsName": "1카테고리 회원권",
////				"gdType": 0,
////				"gdsImgPath": "resources/images/tickets/ticket_0.png",
////				"gdsPrice": 12900
//				Map<String,Object> poticket = dataList.get(0);
//				String pogdsTitle = (String) poticket.get("gdsName");
//
//			} else if( via.equals("fromCart") ) {
//
//			} else {
//				System.out.println("from error!");
//			}

			model.addAttribute("mbId", mbId);
			//model.addAttribute("totalPrice", totalPrice);
			return "payment/pay_order.pays";

			} else { // mb == null이면
				return "member/login";
			}
	}

	// 회원이 세션 로그인 후, 강의 상세페이지로 이동 할 수 있다.
	@RequestMapping(value = "pay_goodsDetail.LF", method = RequestMethod.GET)
	public String showLecture(
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
				model.addAttribute("lecId", lecId);
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
				String comment = "<div id='comment_all'>";
				List<CommentVO> ctList = ctSvc.selectCommentsForOrderNumAsc(ctSvc.LEC_ARTICLE, lecId);
				for (int i = 0; i < ctList.size(); i++) {
					CommentVO ctori = ctList.get(i);
					comment += "			<div id='ct_"+ctori.getOrderNum()+"' " +(ctori.getDepth()==0?"":" style='padding-left:"+ctori.getDepth()*20+"px'")+"><image src='resources/imges/unknown/no_profile_img.PNG' style='width:15px; heigth:15px;'/><label>" + ctori.getMbNic() + "님</label>\r\n" +
							"				<label style=\"padding-left:45px;\">" + ctori.getComment() + "</label>\r\n" +
							"				<small style=\"text-align:right; color:lightgrey;\">(" + sdf.format(ctori.getCreatedAt()) +")</small>\r\n" +
							"				<input type=\"hidden\" value='"+ ctori.getId()+"'>" +
//							"				<i id=\"under_comment\" style=\"padding-left:10px\" class=\"fas fa-comments\"></i>\r\n" +
							"				</div>\r\n" //+
//							"				<div id='udner_ct_form'></div>"
							;
				}
				comment+="</div>";
				System.out.println(comment);
				model.addAttribute("comment", comment);
//				List<CommentVO> ctList = ctSvc.selectCommentsForOrderNumAsc(ctSvc.LEC_ARTICLE, lecId);
//				for (CommentVO ct : ctList) {
//					System.out.println("test" + ct);
//				}
//				model.addAttribute("ctList", ctList);

				// 5.27 해당 회원이 현재 이용권을 이용하는지 확인하는 기능
//				MemberVO mb = (MemberVO)ses.getAttribute("member");
//				if(mb != null) {
//					TicketVO ticket = testDao.selectOneTiketByMbId(mb.getId());
//					if(ticket != null) {
//						int cntUseCategory = ticket.getName(); // 몇개의 클래스를 고를수있는지??
//						String mbStrCate = "";
//						if(cntUseCategory == 1) {
//							mbStrCate = LecTypeVO.STR_CATEGORY[Integer.parseInt(ticket.getCategory())];
//							model.addAttribute("mbStrCate0",mbStrCate);
//						} else if(cntUseCategory == 2) {
//							String[] arrayCategories = ticket.getCategory().split("_");
//							for (int i = 0; i < arrayCategories.length; i++) {
//								mbStrCate = LecTypeVO.STR_CATEGORY[Integer.parseInt(arrayCategories[i])];
//								model.addAttribute("mbStrCate"+i,mbStrCate);
//							}
//						} else if(cntUseCategory == 3) {
//							mbStrCate = LecTypeVO.STR_CATEGORY[Integer.parseInt(ticket.getCategory())];
//							model.addAttribute("mbStrCate0",mbStrCate);
//						}
//					}
//				} else
//					model.addAttribute("mbStrCate0", null);


//				for (int i = 0; i < strCateList.size(); i++) {
//					if(strCateList.get(i).equals(strCategory)) {
//						System.out.println("해당 이용권 이용중");
//
//					}
//				}

				return "payment/pay_goodsDetail.pay";
			} else {
				return "lecture/main.ho";
			}
	}

	// 단일 댓글 작성시 (대댓글 x)
	@RequestMapping(value="insert_comment.LF", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insert_comment(
			HttpSession ses,
			@RequestParam(value="ct") String ct,
			@RequestParam(value="CFId") int CFId
			) {
		System.out.println("insert_comment.LF 진입 성공 ct = "+ct+ ", lecId = "+CFId);
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
		int r = ctSvc.addComment(mbId, ctSvc.LEC_ARTICLE, CFId, ct, mbNic, ctSvc.ORIGIN_COMMENT);
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
		String comment = "<div id='comment_all' style=\"padding: 40px;\">";
		List<CommentVO> ctList = ctSvc.selectCommentsForOrderNumAsc(ctSvc.LEC_ARTICLE, CFId);
		for (int i = 0; i < ctList.size(); i++) {
			CommentVO ctori = ctList.get(i);
			String dep = "";
			int margin = 0;
			margin = 30;
			if(ctori.getDepth() != 0) {
				dep = "ㄴ";
				margin = margin - ctori.getDepth() * 10;
			}
			comment += "			<div style='display:inline-block;margin-top:4px; width:160px; "+(ctori.getDepth()==0?"'":" padding-left:"+ctori.getDepth()*10+"px;'")+">"+dep+"<image src='resources/imges/unknown/no_profile_img.PNG' style='width:15px; heigth:15px;'/><label>" + ctori.getMbNic() + "님</label>\r\n</div>" +
					"				<div style=\"display:inline-block;margin-top:4px; width:400px;  margin-left:"+margin+"px;\"><label style=\" \">" + ctori.getComment() + "</label>\r\n" +
					"				<small style=\"text-align:right; color:lightgrey;\">(" + sdf.format(ctori.getCreatedAt()) +")</small>\r\n" +
					"				<input type=\"hidden\" value='"+ ctori.getId()+"'><i id=\"under_comment\" style=\"padding-left:10px\" class=\"fas fa-comments\"></i>" +
					"				</div><div id='udner_ct_form'></div>";
		}
		comment += "</div>";
		comment+="</div>";
		rMap.put("temp", comment);
		System.out.println(comment);
		return rMap;
	}
	// 회원이 키트를 장바구니에 담을 떄, 담긴 것과 아닌 것을 분기해서 처리 할 수 있다.
	@RequestMapping(value = "pay_cart.LF", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> CheckOrderProc(HttpSession ses,
											  @RequestParam(value = "kitId") int kitId,
											  @RequestParam(value = "gdType", required = false, defaultValue = "kit" ) String gdType) {
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		Map<String, Object> rMap = new HashMap<>();
		if( mb != null ) {
			int mbId = mb.getId();
			boolean r = cartSvc.checkCartForKitMb(mbId, kitId, gdType.equals("ticket") ? 0:1);
			// status 0, mbid, kidId(gdId), gdType(categoeryId)
			if ( r ) {
				System.out.println("상품이 만들어짐");
				//int c = 1;
				rMap.put("c", 1);// 중복됨...

			} else {
				System.out.println("상품이 없음");
				//int c = 0;
				//rMap.put("c", c);
				// 넣을 제품이 키트인지 티켓인지 구분...
				int cr = cartSvc.insertNewCartByTicId(mbId, kitId, gdType);
				if( cr == 1 ) {
					System.out.println("장바구니 추가 성공");
					rMap.put("c", 0);
				} else {
					System.out.println("상품 중복이 없으나 장바구니 추가 실패");
					rMap.put("c", 2); // db, sever err
				}
			}
		} else {
			System.out.println("mb 없음");
			int c = 3; // 로그인 없거나 가입안됨,..,
			rMap.put("c", c);
		}
		return rMap;
	}


//	장바구니페이지로 들어 갈 때, 세션으로 물건들을 넣을 수 있다.
	@RequestMapping(value = "show_cart.LF", method = RequestMethod.GET)
	public String showCartProc(HttpSession ses, Model model){
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		if(mb != null) {
			int mbId = mb.getId();
			if( mbId > 0 ) {
				System.out.println("회원으로 장바구니 이동!");
				//카트에서 해당 mb가 저키트를 가지고있는지 체크하는 함수 select 하는함수
				Map<String, Object> cMap = cartSvc.showCartProc(mbId); // state 0인 내것만..
				if(cMap != null) {
					List<CartVO> cartList = (List<CartVO>)cMap.get("cartList");
					List<KitVO> kitList = (List<KitVO>)cMap.get("kitList");
					List<CreatorVO> creList = (List<CreatorVO>)cMap.get("creList");
					List<TicketListVO> ticketList = (List<TicketListVO>)cMap.get("ticketList");

					System.out.println("ctList = " + cartList );
					List<Map<String,Object>> cartViewList
						= new ArrayList<Map<String,Object>>();
					for (CartVO ct : cartList) {
						Map<String,Object> cartView // VO대신
						= new HashMap<String, Object>();
						//cartView.put("ct", ct);
						cartView.put("id", ct.getId()); // cartVO pk
						cartView.put("gdsId", ct.getGdsId());
						cartView.put("gdsName", ct.getGdsName());
						cartView.put("gdsCnt", ct.getGdsCnt());
						cartView.put("gdsPrice", ct.getGdsPrice());
						cartView.put("gdType", ct.getCategoryId()); // 0, 1
						//
						String imgPath = null;
						if( ct.getCategoryId() == CartVO.CATEGORY_ID_TICKET )
							imgPath = "resources/images/tickets/ticket_"+ct.getGdsId()+".png";
						else { // kit
							for (KitVO kt : kitList) {
								if( kt.getId() == ct.getGdsId() )
									imgPath = "resources/images/kits/"+ kt.getImgPath();
							}
						}
						cartView.put("gdsImgPath", imgPath);
						//
						String creName = null;
						if( ct.getCategoryId() == CartVO.CATEGORY_ID_TICKET )
							creName = "admin";
						else { // kit
							for (KitVO kt : kitList) {
								if( kt.getId() == ct.getGdsId() )
									creName = kt.getTitle();
							}
						}
						cartView.put("gdsCreName", creName);
						//
						cartViewList.add(cartView);
					}
					model.addAttribute("cartViewList", cartViewList);
				}
			} else {
				System.out.println("비회원으로 장바구니 이동!");
				Map<String, Object> cMap = cartSvc.showCartProc(mbId);
			}

		} else {
			// 여유 생기면 구현예정
			//Map<String, Object> pMap = cartSvc.showCartByNoMbProc(kitId); // 카트아이디가 리턴되야함
			model.addAttribute("msg", "mb 가없음");
			System.out.println("mb 가없음");
		}
		return "payment/pay_cart.pays";
	}

	// 회원이 주문페이지에서 결제완료페이지로 이동할 수 있다.
	@RequestMapping(value = "pay_orderFinished.LF", method = RequestMethod.GET)
	public String showOrderFinishedProc(HttpSession ses, @RequestParam( value = "result") int result, Model model) {
		System.out.println("결제완료 페이지로 이동");
		MemberVO mb = (MemberVO)ses.getAttribute("member");
		int mbId = mb.getId();
		String uuid = cartSvc.orderFinishedProc(mbId, result);
		// 밖에서 받아와야할것
		// 카트아이디 , 쿠폰아이디,
		// 안에서 처리해야할거
		// 판매자아이디는 키트나 티켓에있어 티켓이나 키트는 카트에있어 . 
		// 		-> 두번찾아야되 먼저 카트를먼저찾고 카트에서 키트나 티켓을찾아야되 
		// insert하고 select 
		// select 한다는건 가져오는거에여 뭘가져와야되? PayHistoryVO 이게 리턴타입이야. 
		// 
		//int r = payhisSvc.insertPayHis(mbId, uuid); // 목표 PayHistory에 insert
		
		
		//payhisSvc.orderFinishedProc(cartId, couponId, mbId, uuid);
		return "payment/pay_orderFinished.pays";
	}

	@RequestMapping(value = "pay_sendEmail.LF")
	public void sendEmail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 메일 관련 정보
		String host ="smtp.naver.com";
		final String username = "kgu5634";
		final String password = "rlarjs1577";
		//int port = 465;
		int port = 587;
		
		//메일 내용
		String recipient = "kgu5634@naver.com";
		String subject = "[LECFLY] 결제하신 내역을 안내해드립니다.";
		String body = "이름: 김건우입니다. \n\n";
		
		Properties props = System.getProperties();
		
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", "host");
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			String un = username;
			String pw = password;
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(un, pw);
			}
		});
		session.setDebug(true);
		
		Message mimeMessage = new MimeMessage(session);
		mimeMessage.setFrom(new InternetAddress("kgu5634@naver.com"));
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		mimeMessage.setSubject(subject);
		mimeMessage.setText(body);
		Transport.send(mimeMessage);
	}
	
}
