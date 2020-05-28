package com.LECFLY.LF.model.dao.impl.creator;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.creator.IKitDAO;
import com.LECFLY.LF.model.vo.creator.KitVO;

@Repository
public class KitMysqlMybatisDAOImpl implements IKitDAO{
	@Autowired
	private SqlSessionTemplate sstem;
//	JdbcTemplate jtem;
	final String INSERT_KIT = "insert into kit values(null,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	final String SELECT_ONE_KIT = "select * from kit where CFId = ?";
	final String UPDATE_ONE_KIT = "update kit  set attribute = null, title = ?,price = ?,remain= ? , img_path = ? , deliver = ?,"
			+ "delivery_price = ? , from_to = ?, info = ? , detail_info= ?  where CFId = ?";
	public boolean insertKit(KitVO kitVO) {
		int r = sstem.insert("IKitDAO.BATIS_INSERT_KIT",kitVO);
//		(INSERT_KIT,kitVO.getfId(),kitVO.getCFId(),kitVO.getCategory(),kitVO.getAttribute(),kitVO.getTitle(),
//				kitVO.getPrice(),kitVO.getRemain(),kitVO.getImgPath(),kitVO.getDeliver(),kitVO.getDeliveryPrice(),kitVO.getFromTo(),
//				kitVO.getInfo(),kitVO.getDetailInfo());
		return r == 1;
	}
	public boolean updateKit(KitVO kitVo , int CFId) {
		HashMap<String, Object> kithash = new HashMap<String, Object>();
		kithash.put("title", kitVo.getTitle());
		kithash.put("price", kitVo.getPrice());
		kithash.put("remain", kitVo.getRemain());
		kithash.put("imgPath", kitVo.getImgPath());
		kithash.put("deliver", kitVo.getDeliver());
		kithash.put("deliveryPrice", kitVo.getDeliveryPrice());
		kithash.put("fromTo", kitVo.getFromTo());
		kithash.put("info", kitVo.getInfo());
		kithash.put("detailInfo",kitVo.getDetailInfo() );
		kithash.put("CFId", CFId);
		int r= sstem.update("IKitDAO.BATIS_UPDATE_KIT",kithash);
//				
		return r== 1;
	}
	public KitVO selectOneKit(int CFid) {
		try {
		return sstem.selectOne("IKitDAO.BATIS_SELECT_ONE_KIT",CFid);
		}catch (DataAccessException e) {
			System.out.println("셀렉 키트 에러");
		System.out.println(e);
		return null;
		}
	}
	public boolean insertKit(int fid , int cfid , int cate , String attr, String title , int price , int remain , String imgPath,
			String deliver , int deliverPrice , String fromTO , String info , String detail) {
		KitVO kitvo = new KitVO(0, fid, cfid, cate, attr, title, price, remain, imgPath, deliver, deliverPrice, fromTO, info, detail);
		int r = sstem.insert(INSERT_KIT,kitvo);
		return r== 1;
	}
	
}
