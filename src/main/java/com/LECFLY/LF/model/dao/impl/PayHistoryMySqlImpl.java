package com.LECFLY.LF.model.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.payHistory.IPayHistoryDAO;
import com.LECFLY.LF.model.vo.TicketVO;

@Repository
public class PayHistoryMySqlImpl implements IPayHistoryDAO {
	@Autowired
	JdbcTemplate jtem;
	
	
	private final String SQL_INSERT_ONE_CATEGORY_BY_NAME = "insert into ticket_list values(null, ?, ?, null, ?, now(), now())";
	@Override
	public List<TicketVO> insertOneCategorybyName(int ticName) {
		return jtem.query(SQL_INSERT_ONE_CATEGORY_BY_NAME, BeanPropertyRowMapper.newInstance(TicketVO.class), ticName);
	}

}
