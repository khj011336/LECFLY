package com.LECFLY.LF.service.impl.member;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.impl.member.MemberMySqlDAOImpl;
import com.LECFLY.LF.model.vo.MemberVO;
import com.LECFLY.LF.service.inf.member.ILoginSVC;

@Service
public class loginSVCImpl implements ILoginSVC {
	
	@Autowired
	MemberMySqlDAOImpl mbDao;
	
	@Override
	public String getMsg(int r) {
		MB_MSG_MAP.put(MB_EMAIL_ERROR, "로그인 비었음");
		MB_MSG_MAP.put(MB_PW_ERROR, "패스워드 비었음");
		MB_MSG_MAP.put(MB_EMAIL_NONE, "가입되지 않은 회원 이메일");
		MB_MSG_MAP.put(MB_EMAIL_AUTH_OK, "로그인 인증 성공");
		MB_MSG_MAP.put(MB_EMAIL_PW_MISMATCH, "로그인 암호 불일치");
		return MB_MSG_MAP.get(r);
	}
	
	@Override
	public int loginProcess(String email, String pw) {
		if( email == null || email.isEmpty() ) {
			System.out.println(getMsg(MB_EMAIL_ERROR));
			return MB_EMAIL_ERROR;
		}
		if( pw == null || pw.isEmpty() ) {
			System.out.println(getMsg(MB_PW_ERROR));
			return MB_PW_ERROR;
		}
		// 가입된 회원여부
		int r = mbDao.memberEamil(email);
		if( r == 0 ) {
			System.out.println(getMsg(MB_EMAIL_NONE));
			return MB_EMAIL_NONE;
		} 
		// 패스워드 일치 여부 		controller단에서 아래 함수 재사용
		MemberVO mb = this.mbDao.memberPassword(email, pw);
		if( mb == null ) {
			System.out.println(getMsg(MB_EMAIL_PW_MISMATCH));
			return MB_EMAIL_PW_MISMATCH;
		} else { //패스워드 일치
			System.out.println(getMsg(MB_EMAIL_AUTH_OK));
			return MB_EMAIL_AUTH_OK;
		}
	}
	
	@Override
	public MemberVO login(String email, String pw) {
		return this.mbDao.memberPassword(email, pw);
	}

	@Override
	public boolean joinMember(String pic, String name, String nicname, Timestamp birthday, int gender, String email,
			String password, String phNumber, int agreeReceive, String basicAddress, String detailAddress,
			int postalCode) {
		return mbDao.insertNewMember(pic, name, nicname, birthday, gender, email, password, 
				phNumber, agreeReceive, basicAddress, detailAddress, postalCode);
	}
	
	@Override
	public boolean joinMember(MemberVO mb) {
		return mbDao.insertNewMember(mb);
	}

	@Override
	public String findEmail(String phNumber, String name) {
		
		return mbDao.findEmailByPhNmuberAndName(phNumber, name); 
		//return null;
	}

	@Override
	public boolean findPw(String email) {
		if( mbDao.findEmailInDB(email) ) {
			StringBuffer tempPw;
			char t = ' ';
			for (int i = 0; i < 12; i++) {
				
			}
			// 자바 메일발송 관련 api 실행후 임시 비밀번호 발송
//			mbDao.setNewPwByEmail(email, newPw);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

}
