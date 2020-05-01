package com.LECFLY.LF.model.dao.impl.member;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.LECFLY.LF.model.dao.inf.member.IMemberDAO;
import com.LECFLY.LF.model.vo.MemberVO;

public class MemberMySqlDAOImpl implements IMemberDAO {
	
	@Autowired
	JdbcTemplate jtem;
	
	private static final String SQL_INSERT_NEW_MEMBER = 
			"insert into members values()";
	
	
	// 회원정보
	@Override
	public boolean insertNewMember(MemberVO mb) {
		MemberVO mb1 = new MemberVO(pic, name, nicname, 
				birthday, gender, email, password, 
				phNumber, agreeReceive, baiscAddress, detailAddress, postalCode);
		jtem.update(SQL_INSERT_NEW_MEMBER, );
		return false;
	}

	@Override
	public boolean insertNewMember(String name, String nicname, Timestamp birthday, int gender, String email,
			String password, String phNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertNewMember(String pic, String name, String nicname, Timestamp birthday, int gender,
			String email, String password, String phNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MemberVO> selectAllMemberAscLimitTen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> selectAllMemberDescLimitTen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> selectOneMonthInsertMemberAscLimitTen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> selectOneMonthInsertMemberDescLimitTen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO selectOneMemberById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO selectOneMemberByNicName(String nicname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO selectOneMemberByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO selectOneMemberByPhNumber(String phNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateMemberById(int id, MemberVO mb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMemberByNicName(String nicname, MemberVO mb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMemberByEmail(String email, MemberVO mb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMemberByPhNumber(String phNumber, MemberVO mb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMemberNicnameToId(int id, String nicname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMemberEmailToId(int id, String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMemberPasswordToId(int id, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMemberAgreeReceiveById(int id, int agreeReceive) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMemberUseTicketById(int id, int useTicket) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMemberNicnameToEmail(String email, String nicname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMemberPasswordToEmail(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMemberAgreeReceiveByEmail(String email, int agreeReceive) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMemberUseTicketById(String email, int useTicket) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int doubleCheckEmailPassword(String email, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberEamil(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberPassword(String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
