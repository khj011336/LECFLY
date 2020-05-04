package com.LECFLY.LF.service.impl.member;

import org.apache.commons.net.ntp.TimeStamp;

import com.LECFLY.LF.model.dao.impl.member.MemberMySqlDAOImpl;
import com.LECFLY.LF.model.vo.MemberVO;
import com.LECFLY.LF.service.inf.member.ILoginSVC;

public class loginSVCImpl implements ILoginSVC {
	
	MemberMySqlDAOImpl mbDao;
	
	@Override
	public MemberVO loginMember(String email, String pw) {
		if(mbDao.memberEamil(email) != 1 ) {
			System.out.println("email 없음");
			return null;
		} else { 
			MemberVO mb = mbDao.memberPassword(email, pw);
			MemberVO mb = null;
			return mb;
		}
	}

	@Override
	public boolean agreeClause() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean joinMember(String pic, String name, String nicname, TimeStamp birthday, int gender, String email,
			String password, String phNumber, int agreeReceive, String baiscAddress, String detailAddress,
			int postalCode) {
		return false;
	}

	@Override
	public boolean findEmail(String phNumber, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findPw(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

}
