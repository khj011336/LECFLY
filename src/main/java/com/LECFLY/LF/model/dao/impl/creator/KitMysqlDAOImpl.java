package com.LECFLY.LF.model.dao.impl.creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.vo.creator.KitVO;

@Repository
public class KitMysqlDAOImpl {
	@Autowired
	JdbcTemplate jtem;
	final String INSERT_KIT = "insert into kit values(null,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	final String SELECT_ONE_KIT = "select * from kit where CFId = ?";
	final String UPDATE_ONE_KIT = "update kit  set attribute = null, title = ?,price = ?,remain= ? , img_path = ? , deliver = ?,"
			+ "delivery_price = ? , from_to = ?, info = ? , detail_info= ?  where CFId = ?";
	public boolean insertKit(KitVO kitVO) {
		int r = jtem.update(INSERT_KIT,kitVO.getfId(),kitVO.getCFId(),kitVO.getCategory(),kitVO.getAttribute(),kitVO.getTitle(),
				kitVO.getPrice(),kitVO.getRemain(),kitVO.getImgPath(),kitVO.getDeliver(),kitVO.getDeliveryPrice(),kitVO.getFromTo(),
				kitVO.getInfo(),kitVO.getDetailInfo());
		return r == 1;
	}
	public boolean updateKit(KitVO kitVo) {
		int r= jtem.update(UPDATE_ONE_KIT, kitVo.getTitle(),kitVo.getPrice(),kitVo.getRemain(),kitVo.getImgPath(),kitVo.getDeliver()
				,kitVo.getDeliveryPrice(),kitVo.getFromTo(),kitVo.getInfo(),kitVo.getDetailInfo());
		return r== 1;
	}
	public KitVO selectOneKit(int CFid) {
		try {
		return jtem.queryForObject(SELECT_ONE_KIT, BeanPropertyRowMapper.newInstance(KitVO.class), CFid);
		}catch (DataAccessException e) {
			System.out.println("셀렉 키트 에러");
		System.out.println(e);
		return null;
		}
	}
	public boolean insertKit(int fid , int cfid , int cate , String attr, String title , int price , int remain , String imgPath,
			String deliver , int deliverPrice , String fromTO , String info , String detail) {
		int r = jtem.update(INSERT_KIT,fid , cfid,cate , attr , title , price , remain ,imgPath , deliver , deliverPrice, fromTO,info, detail);
		return r== 1;
	}
	
}
