package com.LECFLY.LF.model.dao.impl.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.member.IPostscriptDAO;
import com.LECFLY.LF.model.vo.PostscriptVO;

@Repository
public class PostscriptMysqlDAOImpl implements IPostscriptDAO {
	
	private static final String SQL_ADD_POSTSCRIPT = 
			"insert into postscripts values(null,?,?,?,?,?,now(),null,null,null,null)";
	private static final String SQL_READ_POSTSCRIPT_LIST = "SELECT * FROM postscripts where class_id=?";
	private static final String SQL_READ_ONE_POSTSCRIPT = "SELECT * FROM postscripts where id=?";
	private static final String SQL_UPDATE_ONE_POSTSCRIPT = "update postscripts set content=?,rate=? where id=?";
	private static final String SQL_DELETE_ONE_POSTSCRIPT = "delete from postscripts where id=?";
	
	@Autowired
	JdbcTemplate jtem;

	
	@Override
	public boolean addPostscript(int classId, int mbId, String mbLogin, String content, float rate) {
		System.out.println("db: addPostscript");
		return jtem.update(SQL_ADD_POSTSCRIPT, classId, mbId, mbLogin, content, rate)==1;
	}
	
	@Override
	public boolean addPostscript(PostscriptVO ps) {
		System.out.println("db: addPostscript");
		return jtem.update(SQL_ADD_POSTSCRIPT, 
				ps.getClassId(), ps.getMbId(), ps.getMbLogin(), ps.getContent(), ps.getRate())==1;
	}

	@Override
	public List<PostscriptVO> readAllPostscriptInLec(int lecId) {
		System.out.println("DB: readAllPostscriptInLec");
		return jtem.query(SQL_READ_POSTSCRIPT_LIST, BeanPropertyRowMapper.newInstance(PostscriptVO.class), lecId);
	}

	@Override
	public PostscriptVO readOnePostscript(int id) {
		System.out.println("DB: readOnePostscript");
		return jtem.queryForObject(SQL_READ_ONE_POSTSCRIPT, BeanPropertyRowMapper.newInstance(PostscriptVO.class), id);
	}

	@Override
	public boolean updateOnePostscript(PostscriptVO ps) {
		System.out.println("DB: updateOnePostscript");
		return jtem.update(SQL_UPDATE_ONE_POSTSCRIPT,ps.getContent(), ps.getRate(), ps.getId())==1;
	}

	@Override
	public boolean deleteOnePostscript(int id) {
		System.out.println("deleteOnePostscript");
		return jtem.update(SQL_DELETE_ONE_POSTSCRIPT,id) == 1;
	}

	@Override
	public boolean deleteAllPostscriptInLec(int lecId) {
		// TODO Auto-generated method stub
		return false;
	}

}
