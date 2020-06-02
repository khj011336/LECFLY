package com.LECFLY.LF.model.dao.impl.payhistory;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.payHistory.IPayHistoryDAO;
import com.LECFLY.LF.model.vo.cart.TicketVO;

@Repository
public class PayHistoryMySqlImpl implements IPayHistoryDAO {
	@Autowired
	JdbcTemplate jtem;
	
	// SQL 정의문
	private final String SQL_INSERT_ONE_CATEGORY_BY_NAME = "insert into ticket_list values(null, ?, ?, null, ?, now(), now())";
	private final String SQL_INSERT_ONE_HISTORY_BY_MBID = "insert into pay_histories values(null,)";
	
	@Override
	public List<TicketVO> insertOneCategorybyName(int ticName) {
		return jtem.query(SQL_INSERT_ONE_CATEGORY_BY_NAME, BeanPropertyRowMapper.newInstance(TicketVO.class), ticName);
	}
	
	@Override
	public int insertNewHistory(int mbId, String uuid) {
		int r = jtem.queryForObject(SQL_INSERT_ONE_HISTORY_BY_MBID, BeanPropertyRowMapper.newInstance(Integer.class), mbId, uuid);
		return 0;
	}

	
	
}
