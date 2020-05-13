package com.LECFLY.LF.service.impl.member;

import java.sql.Timestamp;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.impl.member.MemberMySqlDAOImpl;
import com.LECFLY.LF.model.vo.MemberVO;
import com.LECFLY.LF.service.inf.member.ILoginSVC;

@Service
public class loginSVCImpl implements ILoginSVC {
	
	@Autowired
	MemberMySqlDAOImpl mbDao;
	

	public static final int MB_LOGIN_PARAM_ERROR = 1;
	public static final int MB_PW_PARAM_ERROR = 2;
	public static final int MB_LOGIN_NONE = 3;
	public static final int MB_LOGIN_AUTH_OK = 4;
	public static final int MB_LOGIN_PW_MISMATCH = 5;
	
	public static final HashMap<Integer, String> MB_MSG_MAP = new HashMap<Integer, String>();
	
	public static final String getMsg(int r) {
		MB_MSG_MAP.put(MB_LOGIN_PARAM_ERROR, "로그인 파람 에러");
		MB_MSG_MAP.put(MB_PW_PARAM_ERROR, "패스워드 파람 에러");
		MB_MSG_MAP.put(MB_LOGIN_NONE, "가입되지 않은 회원 계정");
		MB_MSG_MAP.put(MB_LOGIN_AUTH_OK, "로그인 인증 성공");
		MB_MSG_MAP.put(MB_LOGIN_PW_MISMATCH, "로그인 암호 불일치");
		return MB_MSG_MAP.get(r);
	}
	
	
	@Override
	public int loginProcess(String email, String pw) {
		if( email == null || email.isEmpty() ) {
			return MB_LOGIN_PARAM_ERROR;
		}
		if( pw == null || pw.isEmpty() ) {
			return MB_PW_PARAM_ERROR;
		}
		// 가입된 회원여부
		if( mbDao.memberEamil(email) != 1 ) {
			return MB_LOGIN_NONE;
		} 
		
		// 패스워드 일치 여부 		controller단에서 아래 함수 재사용
		MemberVO mb = this.mbDao.memberPassword(email, pw);
		if( mb == null ) {
			return MB_LOGIN_PW_MISMATCH;
		} else {
			return MB_LOGIN_AUTH_OK;
		}
	}

	@Override
	public boolean joinMember(String pic, String name, String nicname, Timestamp birthday, int gender, String email,
			String password, String phNumber, int agreeReceive, String basicAddress, String detailAddress,
			int postalCode) {
		return mbDao.insertNewMember(pic, name, nicname, birthday, gender, email, password, 
				phNumber, agreeReceive, basicAddress, detailAddress, postalCode);
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
