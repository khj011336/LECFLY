package com.LECFLY.LF.model.dao.impl.creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LECFLY.LF.model.dao.inf.creator.ICreatorDAO;
import com.LECFLY.LF.model.vo.creator.CreatorVO;

@Repository
public class CreatorMysqlDAOImpl implements ICreatorDAO {
	final String INSERT_NEW_CREATOR = "insert into creator values(null,?,?,?,?,?,?,?,?,now())";
	final String SELECT_ONE_CREATOR = "select * from creator where fId = ?";
	final String UPDATE_CREATOR = "update creator set img_path = ? , nickname = ?"
			+ ",cellphone = ? , sns = ? , info = ? , status = ?  where fid = ?";
	@Autowired
	JdbcTemplate jtem;

	public boolean insertNewCreator(CreatorVO crvo) {
		int r = jtem.update(INSERT_NEW_CREATOR, crvo.getFid(), crvo.getImgPath(), crvo.getName(), crvo.getNickname(),
				crvo.getCellPhone(), crvo.getSNS(), crvo.getInfo(), crvo.getStatus());
		return r == 1;
	}

	public boolean insertNewCreator(int fid, String imgPath, String name, String nickname, String cellphone, String sns,
			String info, int status) {
		int r = jtem.update(INSERT_NEW_CREATOR, fid, imgPath, name, nickname, cellphone, sns, info, status);
		return r == 1;
	}

	@Override
	public CreatorVO selectOneCreator(int id) {
		try {
			return jtem.queryForObject(SELECT_ONE_CREATOR, BeanPropertyRowMapper.newInstance(CreatorVO.class), id);
		} catch (DataAccessException e) {
			System.out.println("셀렉트 크리에이터 에러");
			System.out.println(e);
			return null;
		}
	}

	@Override
	public boolean updateCreator(CreatorVO crVo, int fid) {
		int r = jtem.update(UPDATE_CREATOR, crVo.getImgPath(), crVo.getNickname(), crVo.getCellPhone(), crVo.getSNS(),
				crVo.getInfo(), crVo.getStatus(), fid);
		return r == 1;
	}
}
