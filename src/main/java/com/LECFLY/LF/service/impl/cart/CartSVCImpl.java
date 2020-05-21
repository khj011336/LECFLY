package com.LECFLY.LF.service.impl.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.LECFLY.LF.model.dao.impl.TestGeon;
import com.LECFLY.LF.model.dao.impl.TestGeon2;
import com.LECFLY.LF.model.dao.inf.Comment.ICommentDAO;
import com.LECFLY.LF.model.dao.inf.cart.ICartDAO;
import com.LECFLY.LF.model.dao.inf.creator.ICreatorDAO;
import com.LECFLY.LF.model.dao.inf.creator.IKITDAO;
import com.LECFLY.LF.model.dao.inf.creator.ILectureDAO;
import com.LECFLY.LF.model.dao.inf.creator.IVideoDAO;
import com.LECFLY.LF.model.vo.CartVO;
import com.LECFLY.LF.model.vo.CommentClassVO;
import com.LECFLY.LF.model.vo.CommentVO;
import com.LECFLY.LF.model.vo.TicketVO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.service.inf.cart.ICartSVC;
import com.LECFLY.LF.service.inf.comment.ICommentSVC;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CartSVCImpl implements ICartSVC {
	@Autowired
	private ICartDAO cartDAO;
	
	@Autowired
	private ICommentDAO comDao;
	
	@Autowired
	private TestGeon2 testDAO2;
	
	@Autowired
	private ICreatorDAO creDao;
	
	@Override
	public Map<String, List> myCartList(CartVO cartVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean findCartGoods(CartVO cartVO) throws Exception {
		return cartDAO.selectCountInCart(cartVO);
	}

	@Override
	public void addGoodsInCart(CartVO cartVO) throws Exception {
		cartDAO.insertGoodsInCart(cartVO);
	}

	@Override
	public boolean modifyCartCnt(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> showLectureProc(int lecId) {
		System.out.println("cartSVC :: showGoodsProc");
		if ( lecId > 0) {
			LectureVO lec = testDAO2.selectOneLecture(lecId); // lecDAO.selectOneLecture(lecId);
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
	public int insertNewCartRtKey(int mbId, int kitId) {
		CartVO cart = new CartVO(mbId, 1, kitId, 1);
		int rtKey = cartDAO.insertNewCartRtKey(cart);
		return rtKey;
	}

	@Override
	public Map<String, Object> showCartProc(int mbId, int kitId) {
		// 장바구니 리스트를 뽑는다. (아이디 기준으로)
		// 장바구니에서 필요한 것 (kit의 사진 제목, 가격, 카테고리), (cre의 판매자 이름)
		// 장바구니에서 내가 뽑고 싶은거 => <gdsId>
		
		// 목적은
		// 장바구니의 리스트를 뽑는다. gdsId랑 kitId랑 같은 걸로.
		// 키트의 리스트를 뽑는다.
		// 크리에이터의 리스트를 뽑느다. <FK랑 참조>
		int r = cartDAO.insertNewCartByMbIdKitId(mbId, kitId);
		if(r == 1) {
			List<CartVO> ctList = cartDAO.selectCartList(mbId, kitId);
			
			List<CreatorVO> creList = new ArrayList<>();
			List<KitVO> kitList = new ArrayList<>();	
			for (int i = 0; i < ctList.size(); i++) {
				KitVO kit = testDAO2.selectOneKitbyId(kitId);
				CreatorVO cre = testDAO2.selectOneCreByfId(kit.getfId()); 
				creList.add(cre);
				kitList.add(kit);
			}
			
			Map<String, Object> rMap = new HashMap<>();
			rMap.put("cartList", ctList);
			rMap.put("kitList", kitList);
			rMap.put("creList", creList);
			
			return rMap;
		} else {
			return null;
		}
		
		
		
		
	}

	
	

	


}
