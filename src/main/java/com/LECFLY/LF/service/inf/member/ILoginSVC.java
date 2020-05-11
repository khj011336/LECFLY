package com.LECFLY.LF.service.inf.member;

import java.sql.Timestamp;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.vo.MemberVO;

@Service
public interface ILoginSVC {
	
	
//	name nicname birthday
//	gender < 0 && gender < 4
//	email password phNumber
//	agreeReceive < -1 && agreeReceive > 4
	public static final int MB_EMAIL_ERROR = 1;
	public static final int MB_PW_ERROR = 2;
	public static final int MB_EMAIL_NONE = 3;
	public static final int MB_EMAIL_AUTH_OK = 4;
	public static final int MB_EMAIL_PW_MISMATCH = 5;
	
	public static final HashMap<Integer, String> MB_MSG_MAP = new HashMap<Integer, String>();
	
	String getMsg(int r);
	
	//로그인하기
	//log_in.lf (proc; post; 암호화; 세션; 회원)			로그인proc실행(selectOneMember(email,pw) )	
	int loginProcess(String email, String pw);
	MemberVO login(String email, String pw);
	//회원가입
	//member_join.lf (proc; post; dao; 비회원)			회원가입proc 실행(createNewMember)
	boolean joinMember(
			String pic, String name, String nicname, Timestamp birthday, int gender, 
			String email, String password, String phNumber, int agreeReceive, 
			String baiscAddress, String detailAddress, int postalCode);
	boolean joinMember(MemberVO mb);
	boolean check_dup_nick(String nickname);
	boolean check_dup_email(String email);
	//이메일 찾기
	//find_login.lf (proc; post; dao; 비회원)			이메일찾기proc실행(findEmail(phNumber) )
	String findEmail(String phNumber, String name);
	
	//비밀번호 찾기
	//find_pw.lf (proc; post; dao; 비회원)			비밀번호 재발급proc실행(createNewPWToEmail(email)
	boolean findPw(String email);
	//로그아웃하기						
	//logout.lf (proc; get; 회원)			로그아웃proc실행 후 default로 이동		session의 memberVO 제거
	boolean logout();
}
