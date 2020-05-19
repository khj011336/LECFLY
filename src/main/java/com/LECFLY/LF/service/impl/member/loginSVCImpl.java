package com.LECFLY.LF.service.impl.member;

import java.sql.Timestamp;
import java.util.Date;
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
		
		
		if ( name != null && nicname != null && birthday != null && gender < 0 && gender < 4 && email != null && 
				password != null && phNumber != null && agreeReceive < -1 && agreeReceive > 4) {
		} else {

		}
		
		return mbDao.insertNewMember(pic, name, nicname, birthday, gender, email, password, 
				phNumber, agreeReceive, basicAddress, detailAddress, postalCode);
	}
	
	@Override
	public boolean joinMember(MemberVO mb) {
		return mbDao.insertNewMember(mb);
	}
	
	@Override
	public boolean check_dup_nick(String nickname) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean check_dup_email(String email) {
		System.out.println("이메일 중복체크");
		int r = mbDao.memberEamil(email);
		return r == 1;
	}

	@Override
	public int findEmail(String phNumber, String name) {
		System.out.println("이메일 찾기");
		int r = (mbDao.findEmailByPhNmuberAndName(phNumber, name) != null) ? 1: 0;
		return r;
	}

	@Override
	public int findPw(String email, String name, String phNumber) {
		MemberVO mbEmail = mbDao.findEmailInDB(email);
		if( mbEmail == null ) {
			System.out.println("이메일 db에 없음");
			return 2;
		} else if(!mbEmail.getName().equals(name)){
			System.out.println("이메일과 이름 불일치");
			return 3;
		} else if(!mbEmail.getPhNumber().equals(phNumber)) {
			System.out.println("이메일과 전화번호 불일치");
			return 4;
		} else {
			System.out.println("인증 성공");
			return 1;
		}		
	}
	
	@Override
	public boolean makeTempPwIn(String email, String password) {
			mbDao.updateMemberPasswordToEmail(email, password);
		return false;
	}
	
	@Override
	public String makeTemptPw() {
		String result = "";
		int target = (int)(Math.random()*10 + 6);
		for (int i = 0; i < target; i++) {
			char c= ' ';
			int ran = (int)(Math.random()*62);
			if(ran<10) {
				c = (char)(ran+48);//숫자
			} else if(ran<36) {
				c = (char)(ran+55);//대문자
			} else {
				c = (char)(ran+61);//소문자
			}
			result += c;
		}
		return result;
	}

	@Override
	public String check_none(String name, String nickname, Date birthday, String gender, String email, String password,
			String pw_confirm, String phNumber, String phNumber2) {
		if( name.isEmpty() || name == null ) {
			System.out.println("이름 x");
			return "이름이 비었습니다";
		}
		if( !nickname.isEmpty() && nickname!=null  ) {
			System.out.println("닉네임 x");
			return "닉네임이 비었습니다";
		}
		if( birthday!=null ) {
			System.out.println("생년월일 x");
			return "생년월일이 비었습니다";
		}
		if( !gender.isEmpty()&&gender!=null ) {
			System.out.println("성별 x");
			return "성별이 비었습니다";
		}
		if( !email.isEmpty()&&email!=null ) {
			System.out.println("이메일 x");
			return "이메일이 비었습니다";
		}
		if( !password.isEmpty()&&password!=null ) {
			System.out.println("비밀번호 x");
			return "비밀번호가 비었습니다";
		}
		if( !pw_confirm.isEmpty()&&pw_confirm!=null ) {
			System.out.println("비밀번호 확인 x");
			return "비밀번호 확인이 안됬습니다";
		}
		if( !phNumber.isEmpty()&&phNumber!=null ) {
			System.out.println("전화번호 앞자리 x");
			return "전화번호가 비었습니다";
		}
		if( !phNumber2.isEmpty()&& phNumber2!=null ) {
			System.out.println("전화번호 뒷자리 x");
			return "전화번호가 비었습니다";
		}
		return null;
	}

}
