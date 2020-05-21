package com.LECFLY.LF.model.dao.inf.member;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.LECFLY.LF.model.vo.MemberVO;

public interface IMemberDAO {
	//impl로 옮겨야됨
	
	int LOGIN_NOT_FOUND = -1;
	int PASSWORD_MISMATCH = -2;
	
	Map<Integer, String> LOGINERROR_MAP = new HashMap<Integer, String>() {
		{
			put(LOGIN_NOT_FOUND, "이메일(아이디)이 없습니다");
			put(PASSWORD_MISMATCH, "비밀번호가 다릅니다.");
		}
	};
	
// Create
	// insert VO
	boolean insertNewMember(MemberVO mb);
	// insert columns
	boolean insertNewMember(String pic, String name, String nicname, 
			Timestamp birthday, int gender, String email, String password, String phNumber, 
			int agreeReceive, String basicAddress, String detailAddress, int postalCode);

// Read
	// 모든 회원 올림차순 조회 id asc limit 10
	List<MemberVO> selectAllMembersAscLimitTen();
	// 모든 회원 내림차순 조회 id desc limit 10	
	List<MemberVO> selectAllMembersDescLimitTen();
	
	// 한달동안 가입한 회원의수 asc limit 10
	List<MemberVO> selectOneMonthInsertMembersAscLimitTen();
	// 한달동안 가입한 회원의수 desc limit 10
	List<MemberVO> selectOneMonthInsertMembersDescLimitTen();
	
	// id 로 회원조회
	MemberVO selectOneMemberById(int id);
	// nicname 으로 회원조회
	MemberVO selectOneMemberByNicName(String nicname);
	// email로 회원조회
	MemberVO selectOneMemberByEmail(String email);
	// 휴대전화번호로 회원조회
	MemberVO selectOneMemberByPhNumber(String phNumber);
	
// Update
	// id를통해 모든정보 update
	boolean updateMemberById(int id, MemberVO mb);
	// email를통해 모든정보 update
	boolean updateMemberByEmail(String email, MemberVO mb);
	// id를통해 nicname 변경
	boolean updateMemberNicnameToId(int id, String nicname);
	// 이안에서 체크하는 게필요함 비밀번호를 바꾸게하려는 id에 해당하는애가 맞는지~~
	boolean updateMemberPasswordToId(int id, String password);
	// id를통해 항목체크를 바꿀수있다 (email 메세지 수신...)
	boolean updateMemberAgreeReceiveById(int id, int agreeReceive);
	// id를통해 있으면 이용권 바꿀수있다.  ==> 이용권 구매할때사용할거같음
	boolean updateMemberUseTicketById(int id, int useTicket);
	
	// email을 통해 항목체크를 바꿀수있다 (email 메세지 수신...)
	boolean updateMemberAgreeReceiveByEmail(String email, int agreeReceive);
	// email을 통해 있으면 이용권 바꿀수있다.  ==> 이용권 구매할때사용할거같음
	boolean updateMemberUseTicketByEmail(String email, int useTicket);
//	boolean updateMemberUseTicketById(String email, int useTicket);
	
	// 로그인할떄 필요할거같음 이메일이랑 패스워드가 맞는지. 안에 select로 찾아야되나봄
	int doubleCheckEmailPassword(String email, String password);
	
	// 로그인이있느지 체크 
	int memberEamil(String email);
	
	// 비밀번호가 같은지 체크
	MemberVO memberPassword(String email, String password);
	
	// 이름과 전화번호로 이메일 찾기
	MemberVO findEmailByPhNmuberAndName(String phNumber, String name);
	
	// 이메일 검색하여 Member객체 출력ㄴ
	MemberVO findEmailInDB(String email);
	
	// 가입된 이메일로 임시 비밀번호 생성하기
	boolean setNewPwByEmail(String email, String pw);

	// id를 통해 회원 프로필사진 수정
	boolean updatePicById(int id);
	
	// id로 크리에이터 상태 변경
	boolean setCreatorStatusById(int id, int creatorStatus);
	
	// id를 검색값으로 회원의 모든 정보 수정
	boolean updateOneMemberById(int id, MemberVO mb);
	
	// id를 통해 회원 정보 삭제
	boolean deleteOneMemberById(int id);
	
	
	// 세현 추가 마이페이지에서 회원 id, 업데이트할 사진 path 입력하면은 sql 에 업데이트 하려고함
	boolean updateMemberProfileImg(int mbId, String filePath);
	
	// 5.14 이메일을 매개로 패스워드 업데이트(비밀번호 재발급 기능에 사용함)
	boolean updateMemberPasswordToEmail(String email, String password);
	
	// 5.20 닉네임이 중복체크
	boolean dupCheckNickname(String nickname);
	

	
	
	
	
}
