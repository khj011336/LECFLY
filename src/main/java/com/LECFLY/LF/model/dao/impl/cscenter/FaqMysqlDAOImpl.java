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

@Repository
public class FaqMysqlDAOImpl implements IFaqDAO{
	// Faq 목록 보여주기
	public static String SQL_FAQ_SHOWALL
		= "select * from faqs order by created_at desc";
	// Faq 상세조회
	public static String SQL_FAQ_SHOWONE
		= "select * from faqs where id = ?";
	// Faq 등록하기
	public static String SQL_FAQ_INSERT_VO
		= "insert into faqs values(0, ?, ?, ?)";
	// Faq 수정하기
	public static String SQL_FAQ_UPDATE_VO
		= "update faqs set title = ?, content = ? where id = ?";
	// Faq 삭제하기
	public static String SQL_FAQ_DELETE_VO
		= "delete faqs where id = ?";
	// Faq 페이지 조회
	public static String SQL_FAQ_SHOWALL_PG
		= "SELECT * FROM faqs order by created_at desc limit ?, ?";
	// Faq 갯수 카운트
	public static String SQL_CHECK_FAQ_NUMBERS
	= "select count(id) as cnt from faqs";	
	
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
	public boolean insertNewFaq(FaqVO fq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insertNewFaqReturnKey(FaqVO fq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertNewFaqReturnKey2(FaqVO fq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean insertNewFaq(int type, String title, String content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateFaq(int type, String title, String content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteFaq(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<FaqVO> showAllFaqs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FaqVO> showAllFaqs(boolean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FaqVO> showAllFaqs(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FaqVO> showAllFaqs(int offset, int limit, boolean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkNumberOfFaqs() {
		// TODO Auto-generated method stub
		return 0;
	}	
		
	
	
}
