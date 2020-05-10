package com.LECFLY.LF.model.dao.impl.cscenter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.cscenter.IFaqDAO;
import com.LECFLY.LF.model.vo.FaqVO;
import com.LECFLY.LF.model.vo.QnaVO;

@Repository
public class FaqMysqlDAOImpl implements IFaqDAO{
	// Faq 목록 보여주기
	public static String SQL_FAQ_SHOWALL
		= "select * from faqs order by id desc";
	// Faq 페이지 조회
	public static String SQL_FAQ_SHOWALL_PG
		= "SELECT * FROM faqs order by id desc limit ?, ?";
	// Faq 갯수 카운트
	public static String SQL_CHECK_FAQ_NUMBERS
		= "select count(id) as cnt from faqs";	
	// Faq type별 보여주기
	public static final String SQL_SEARCH_TYPE 
		= "SELECT * FROM faqs where type like concat('%',?,'%') ";
	
	//@Autowired
	private JdbcTemplate jtem;	
	private SimpleJdbcInsert simIn;
	
	public FaqMysqlDAOImpl() {}
	
	@Autowired
	public FaqMysqlDAOImpl(JdbcTemplate jtem) {
		this.jtem = jtem;		
		this.simIn = 
		 new SimpleJdbcInsert(jtem.getDataSource());
		simIn.withTableName("qnas");
		simIn.usingGeneratedKeyColumns("id");
	}


	@Override
	public List<FaqVO> showAllFaqs() {
		// VO <==> TBL
		return jtem.query(SQL_FAQ_SHOWALL, BeanPropertyRowMapper.newInstance(FaqVO.class));

	}

	@Override
	public List<FaqVO> showAllFaqs(boolean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FaqVO> showAllFaqs(int offset, int limit) {
		return jtem.query(SQL_FAQ_SHOWALL_PG, BeanPropertyRowMapper.newInstance(FaqVO.class), offset, limit);

	}

	@Override
	public List<FaqVO> showAllFaqs(int offset, int limit, boolean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkNumberOfFaqs() {
		return jtem.queryForObject(SQL_CHECK_FAQ_NUMBERS, Integer.class);
	}

	@Override
	public List<FaqVO> showAllFaqsForType(int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FaqVO> showAllFaqsForType(int type, boolean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FaqVO> showAllFaqsForType(int type, int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FaqVO> showAllFaqsForType(int type, int offset, int limit, boolean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkNumberOfFaqsForType() {
		// TODO Auto-generated method stub
		return 0;
	}	
		
	
	
}
