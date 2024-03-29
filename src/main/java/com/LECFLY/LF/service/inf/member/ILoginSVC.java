package com.LECFLY.LF.service.inf.member;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.vo.member.MemberVO;

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
	// 로그인 시 로그인 횟수 증가
	boolean incLoginCnt(int id);
	// 로그인 시 로그인날자 갱신
	boolean updateLoginDate(int id);
	
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
	int findEmail(String phNumber, String name);
	
	//비밀번호 찾기
	//find_pw.lf (proc; post; dao; 비회원)			비밀번호 재발급proc실행(createNewPWToEmail(email)
	int findPw(String email, String name, String phNumber);
	
	// 임시비밀번호 생성
	boolean makeTempPwIn(String email, String password);
	String makeTemptPw();

	String check_none(String name, String nickname, Date birthday,
			String gender, String email, String password,
			String pw_confirm, String phNumber, String phNumber2);

}
