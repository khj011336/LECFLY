package com.LECFLY.LF.model.dao.impl.creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.vo.creator.KitVO;

@Repository
public class KitMysqlDAOImpl {
	@Autowired
	JdbcTemplate jtem;
	final String INSERT_KIT = "insert into kit values(null,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public boolean insertKit(KitVO kitVO) {
		int r = jtem.update(INSERT_KIT,kitVO.getfId(),kitVO.getCFId(),kitVO.getCategory(),kitVO.getAttribute(),kitVO.getTitle(),
				kitVO.getPrice(),kitVO.getRemain(),kitVO.getImgPath(),kitVO.getDeliver(),kitVO.getDeliveryPrice(),kitVO.getFromTo(),
				kitVO.getInfo(),kitVO.getDetailInfo());
		return r == 1;
	}
	
	public boolean insertKit(int fid , int cfid , int cate , String attr, String title , int price , int remain , String imgPath,
			String deliver , int deliverPrice , String fromTO , String info , String detail) {
		int r = jtem.update(INSERT_KIT,fid , cfid,cate , attr , title , price , remain ,imgPath , deliver , deliverPrice, fromTO,info, detail);
		return r== 1;
	}
	
}
