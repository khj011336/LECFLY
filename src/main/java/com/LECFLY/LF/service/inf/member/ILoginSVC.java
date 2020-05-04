package com.LECFLY.LF.service.inf.member;

import org.apache.commons.net.ntp.TimeStamp;
import org.springframework.stereotype.Service;

import com.LECFLY.LF.model.dao.inf.member.IMemberDAO;
import com.LECFLY.LF.model.vo.MemberVO;

@Service
public interface ILoginSVC {
	
	//로그인하기
	//log_in.lf (proc; post; 암호화; 세션; 회원)			로그인proc실행(selectOneMember(email,pw) )	
	int loginProcess(String email, String pw);
	//회원가입 전 약관확인
	//agree.lf(proc; post; 비회원)약관 확인 여부 체크
	boolean agreeClause();
	//회원가입
	//member_join.lf (proc; post; dao; 비회원)			회원가입proc 실행(createNewMember)
	boolean joinMember(
			String pic, String name, String nicname, TimeStamp birthday, int gender, 
			String email, String password, String phNumber, int agreeReceive, 
			String baiscAddress, String detailAddress, int postalCode);
	//이메일 찾기
	//find_login.lf (proc; post; dao; 비회원)			이메일찾기proc실행(findEmail(phNumber) )
	boolean findEmail(String phNumber, String name);
	
	//비밀번호 찾기
	//find_pw.lf (proc; post; dao; 비회원)			비밀번호 재발급proc실행(createNewPWToEmail(email)
	boolean findPw(String email);
	//로그아웃하기						
	//logout.lf (proc; get; 회원)			로그아웃proc실행 후 default로 이동		session의 memberVO 제거
	boolean logout();
}
