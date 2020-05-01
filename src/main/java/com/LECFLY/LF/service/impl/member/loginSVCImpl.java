package com.LECFLY.LF.service.impl.member;

import org.apache.commons.net.ntp.TimeStamp;

import com.LECFLY.LF.model.vo.MemberVO;
import com.LECFLY.LF.service.inf.member.ILoginSVC;

public class loginSVCImpl implements ILoginSVC {

	@Override
	public MemberVO loginMember(String email, String pw) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkPhNumber(String phNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkRight(String number) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findEmail() {
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
