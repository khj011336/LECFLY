package com.LECFLY.LF.service.impl.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.LECFLY.LF.model.dao.impl.TestGeon;
import com.LECFLY.LF.model.dao.inf.cart.ICartDAO;
import com.LECFLY.LF.model.dao.inf.creator.ILectureDAO;
import com.LECFLY.LF.model.vo.CartVO;
import com.LECFLY.LF.model.vo.CommentClassVO;
import com.LECFLY.LF.model.vo.creator.CommentVO;
import com.LECFLY.LF.model.vo.creator.KitVO;
import com.LECFLY.LF.model.vo.creator.LectureVO;
import com.LECFLY.LF.model.vo.creator.VideoVO;
import com.LECFLY.LF.service.inf.cart.ICartSVC;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CartSVCImpl implements ICartSVC {
	@Autowired
	private ICartDAO cartDAO;
	
//	@Autowired
//	private ILectureDAO lecDAO;
	
	@Autowired
	private TestGeon testDAO; 
	
	
	
	
	
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
	public Map<String, Object> showGoodsProc(int mbId, int lecId) {
		System.out.println("cartSVC :: showGoodsProc");
		if(mbId > 0 && lecId > 0) {
			LectureVO lec = //lecDAO.selectOneLecture(lecId);
							testDAO.selectOneLecture(lecId);
			int cFId = lec.getId();
			KitVO kit = // kitDAO.selectOneKitByCFId(cFId);
					testDAO.selectOneKitByCFId(cFId);
			List<VideoVO> vdList = //vdDAO.selectAllViedosByCFId(cFId);
					testDAO.selectAllViedosByCFId(cFId);
			int fId = lec.getFid();
			
			Map<String, Object> cMap = //creDAO.selectCreNameAndCreInfoByIdRtMap(fId);
										testDAO.selectCreNameAndCreInfoByIdRtMap(fId);
			String creName = (String)cMap.get("name");
			String creInfo = (String)cMap.get("info");
			List<CommentClassVO> comClassList = testDAO.selectAllCommentByLecId(cFId);
			
			Map<String, Object> rMap = new HashMap<>();
			rMap.put("lec", lec);
			rMap.put("kit", kit);
			rMap.put("vdList", vdList);
			rMap.put("creName", creName);
			rMap.put("creInfo", creInfo);
			rMap.put("ccList", comClassList);
			
		} else {
			System.out.println("mbId 나 lecId 오류 ");
			System.out.println("mbId = " + mbId + " / lecId = " + lecId);
		}
		return null;
	}

}
