package com.LECFLY.LF.service.impl.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.LECFLY.LF.model.dao.impl.TestGeon2;
import com.LECFLY.LF.model.dao.inf.Comment.ICommentDAO;
import com.LECFLY.LF.model.dao.inf.cart.ICartDAO;
import com.LECFLY.LF.model.dao.inf.cart.IGoodsDAO;
import com.LECFLY.LF.model.dao.inf.creator.ICreatorDAO;
import com.LECFLY.LF.model.vo.admin.PayHistoryVO;
import com.LECFLY.LF.model.vo.cart.CartVO;
import com.LECFLY.LF.model.vo.cart.TicketListVO;
import com.LECFLY.LF.model.vo.cart.TicketVO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.model.vo.member.CommentVO;
import com.LECFLY.LF.service.inf.cart.ICartSVC;
import com.LECFLY.LF.service.inf.comment.ICommentSVC;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CartSVCImpl implements ICartSVC {
	@Autowired
	private ICartDAO cartDAO;

	@Autowired
	private IGoodsDAO gdDao;

	@Autowired
	private ICommentDAO comDao;

	@Autowired
	private TestGeon2 testDAO2;

	public static final String[] STR_TICKET_NAME_MAP = {"", "1카테고리이용권", "3카테고리이용권", "전체이용권"};
	public static final int[] TICKET_PRICE_MAP = { 0 , 12900, 30900, 49900};

	@Override
	public Map<String, Object> showLectureProc(int lecId) {
		System.out.println("cartSVC :: showGoodsProc");
		if ( lecId > 0) {
			LectureVO lec = testDAO2.selectOneLecture(lecId); // lecDAO.selectOneLecture(lecId);
			//5 5
			int fId = lec.getFid(); // creator Foreign key
			int cFId = lec.getId(); // class lecture Foreign Key
			KitVO kit = testDAO2.selectOneKit(cFId); // KitDAO.selectOneKit(cFId);
			List<VideoVO> vid = testDAO2.selectOneVideo(cFId); // vidDAO.selectOneKit(cFId);

			Map<String,Object> cMap = testDAO2.selectOneCreator(fId); //creDAO.selectOneCreator(fId);
			String creName = (String)cMap.get("name");
			String creNickname = (String)cMap.get("nickname");
			String creInfo = (String)cMap.get("info");
			System.out.printf("%s, %s, %s  = ", creName, creNickname, creInfo);
			List<CommentVO> comList = comDao.selectCommentsForOrderNumAsc(0, lecId);
			Map<String, Object> rMap = new HashMap<>();
			rMap.put("lec", lec);
			rMap.put("kit", kit);
			rMap.put("vid", vid);
			rMap.put("creName", creName);
			rMap.put("creNickname", creNickname);
			rMap.put("creInfo", creInfo);
			rMap.put("ccList", comList);
			return rMap;
		} else {
			System.out.println("lecId ERROR");
			System.out.println("lecId = " + lecId );
		}
		return null;
	}

	@Override
	public List<TicketVO> selectOneTicket(int ticId) {
		List<TicketVO> ticList = cartDAO.selectTicketList(ticId);
		return null;
	}

	@Override
	public Map<String, Object> showCartProc(int mbId) {
		System.out.println("cartSvc :: showCartProc()");
		List<CartVO> cartList = cartDAO.selectCartListByMbId(mbId);
		List<CreatorVO> creList = new ArrayList<>();
		List<KitVO> kitList = new ArrayList<>();
		List<TicketListVO> ticketList = new ArrayList<>();

		Map<String, Object> rMap = new HashMap<>();
		rMap.put("cartList", cartList);
		rMap.put("kitList", kitList);
		rMap.put("creList", creList);
		rMap.put("ticketList", ticketList);
		return rMap;
	}

	@Override
	public Map<String, Object> showCartByNoMbProc(int kitId) {
		// 비회원이 등록시 하려고함
		// 미 구현
		return null;
	}

	@Override
	public boolean checkCartForKitMb(int mbId, int kitId, int categoryId) {
		int r = cartDAO.checkCartByMbIdKitId(mbId, kitId, categoryId);
		System.out.println("r = " + r);
		if( r == 1 ) {
			System.out.println("상품 1개 존재");
			return true;
		} else if (r > 1) {
			System.out.println("상품 에러(1개 이상 존재)");
		}
		return false;
	}

	@Override
	public int insertNewCartByTicId(int mbId, int kitId, String gdType) {
		String gdName = "";
		int gdPrice = 0;
		int categoryId = 0; // ticket
		int state = 0;

		if( gdType.equals("kit") == true ) {
			KitVO kv = gdDao.getOneKitById(kitId);
			gdName = kv.getTitle();
			gdPrice = kv.getPrice();
			categoryId = 1;
			state = 0;
		} else { // ticket
			TicketVO tv = gdDao.getOneTicketById(kitId);
			gdName = tv.STR_TICKET_NAME_MAP.get(kitId);
			gdPrice = tv.TICKET_PRICE_MAP.get(kitId);
			state = 0;
		}
		return cartDAO.insertNewCartByTicId(mbId, categoryId, kitId, "", gdName, gdPrice, state);
		//return cartDAO.insertNewCartByTicId(mbId, categoryId, kitId, "", gdName, gdPrice, state);

	}

	@Override
	public String orderFinishedProc(int mbId, int result) {
		String Uuid = UUID.randomUUID().toString();
		boolean r = cartDAO.updateUuidStateBymbId(mbId, result, Uuid);
		return Uuid;
	}

	@Override
	public boolean updateStateForPayBegin(int mbId, int gdsId, int gdType) {
		return cartDAO.updateStateByMbid(mbId, gdsId, gdType);
	}

	







}
