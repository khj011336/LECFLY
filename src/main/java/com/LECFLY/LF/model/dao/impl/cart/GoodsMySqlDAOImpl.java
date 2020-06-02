package com.LECFLY.LF.model.dao.impl.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.cart.IGoodsDAO;
import com.LECFLY.LF.model.vo.cart.TicketListVO;
import com.LECFLY.LF.model.vo.cart.TicketVO;
import com.LECFLY.LF.model.vo.creator.KitVO;

@Repository
public class GoodsMySqlDAOImpl implements IGoodsDAO {
	
	@Autowired
	JdbcTemplate jtem;

	@Override
	public KitVO getOneKitById(int id) {
		return jtem.queryForObject("select * from kit where id = ?", 
				BeanPropertyRowMapper.newInstance(KitVO.class), id);
	}

	@Override
	public TicketVO getOneTicketById(int id) {
		return jtem.queryForObject("select * from tickets where id = ?", BeanPropertyRowMapper.newInstance(TicketVO.class), id);
	}

}
